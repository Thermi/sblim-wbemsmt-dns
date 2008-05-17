 /** 
  * AclHandler.java
  *
  * © Copyright IBM Corp. 2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE COMMON PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Common Public License from
  * http://www.opensource.org/licenses/cpl1.0.php
  *
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: Class for handling ACLs
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.acl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.cim.CIMObjectPath;
import javax.cim.UnsignedInteger16;
import javax.cim.UnsignedInteger8;
import javax.wbem.client.WBEMClient;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.AbstractWbemsmtFco;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.dns.bl.validator.AddressMatchListElementValidator;
import org.sblim.wbemsmt.dns.bl.wrapper.DnsObject;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.list.AddressMatchListList;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;

public class AclHandler extends DnsObject {

	private static final String CANNOT_LOAD_OBJECTS_FOR_TYPE = "Cannot load objects for Type ";

	private final AssociatedObjectsLoader loader;

	private final Linux_DnsZone zone;
	
	public AclHandler(DnsCimAdapter adapter, AssociatedObjectsLoader loader, Linux_DnsZone zone) {
		super(adapter);
		this.loader = loader;
		this.zone = zone;
	}

	private boolean[] addressMatchListExists = new boolean[ACL_COUNT];
	
	private static final int ACL_COUNT = 7;
	
	private Linux_DnsAddressMatchList[] acl = new Linux_DnsAddressMatchList[ACL_COUNT];
	protected List[] usedAddresses = new List[ACL_COUNT];
	protected List[] usedAddressTypes = new List[ACL_COUNT];
	protected List[] notUsedAddresses = new List[ACL_COUNT];
	
	public static final int IDX_NOTIFY = 0; 
	public static final int IDX_TRANSFER = 1; 
	public static final int IDX_UPDATE = 2; 
	public static final int IDX_QUERY = 3; 
	public static final int IDX_BLACKHOLE = 4; 
	public static final int IDX_USER = 5; 
	public static final int IDX_RECURSION = 6; 

	public Linux_DnsAddressMatchList getAcl(int index) throws WbemsmtException {

		if (acl[index] == null)
		{
			WBEMClient cc = adapter.getCimClient();
			List associatedObjects = loader.load(index);
			if (associatedObjects == null)
			{
				WbemsmtException e = new WbemsmtException(WbemsmtException.ERR_LOADING_MODEL,CANNOT_LOAD_OBJECTS_FOR_TYPE + index);
                throw e;
			}
			
			if (associatedObjects.size() == 0 || associatedObjects.get(0) instanceof CIMObjectPath )
			{
				acl[index] = (Linux_DnsAddressMatchList) getFirstChild(Linux_DnsAddressMatchList.class,associatedObjects,true,true, cc, adapter.getNamespace());
			}
			else
			{
				acl[index] = (Linux_DnsAddressMatchList) associatedObjects.get(0);
			}

			loadAclDependentObjects(index);
			
		}
		return acl[index];
	}

	
	
	
	private void loadAclDependentObjects(int index) throws WbemsmtException {
	
		notUsedAddresses[index] = new ArrayList();
		//add the userdefined ones
		AddressMatchListList addressMatchListList = adapter.getDnsService().getAddressMatchListList();
		for (int i=0; i < addressMatchListList.size(); i++)
		{
			String name = addressMatchListList.getAddressMatchList(i).getFco().get_key_Name();
			notUsedAddresses[index].add(name);
		}

		usedAddresses[index] = new ArrayList();
		usedAddressTypes[index] = new ArrayList();
		String[] addresses = acl[index].get_AddressMatchListElement();
		UnsignedInteger8[] addressTypes = acl[index].get_AddressMatchListElementType();
		
		for (int i = 0; addresses != null && i < addresses.length; i++) {
			String address = addresses[i];

			//if its a global addressMatchList - remove from the global not used list
			if (adapter.getDnsService().getAddressMatchListList().getAddressMatchListByListName(address) != null)
			{
				notUsedAddresses[index].remove(address);
			}
			usedAddresses[index].add(address);
			usedAddressTypes[index].add(addressTypes[i]);
		}
		
		if (usedAddresses[index].size() > 0)
		{
			addressMatchListExists[index] = true;
		}
	}

	public void resetAcls() throws WbemsmtException {

		for (int i = 0; i < acl.length; i++) {
			try {
				resetAcl(i);
			} catch (WbemsmtException e) {
				if (e.getUserObject() != null && e.getMessage().startsWith(CANNOT_LOAD_OBJECTS_FOR_TYPE))
				{
					//thats okay - not all objects do have all types of acls
				}
				else
				{
					throw e;
				}
			}
		}
		
	}

	public void resetAcl(int idx) throws WbemsmtException {
		acl[idx] = null;
		acl[idx] = getAcl(idx);
		usedAddressTypes[idx] = usedAddresses[idx] = notUsedAddresses[idx] = null;
	}


	public MessageList save(int idx) throws WbemsmtException {

		Linux_DnsAddressMatchList aclByIdx = getAcl(idx);
        boolean created = false;
        //create a new acl?
        if (addressMatchListExists[idx] && !aclByIdx.isFromServer())
        {
        	Class cls = getClassByIdx(idx);
        	
        	if (zone != null)
        	{
        		aclByIdx.set_key_Name(NameFactory.createName(cls, zone.get_key_Name()));
        		aclByIdx.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
        		acl[idx] = aclByIdx = (Linux_DnsAddressMatchList) adapter.getFcoHelper().create(aclByIdx, adapter.getCimClient());
        		if (DnsCimAdapter.DUMMY_MODE)
        		{
                    Linux_DnsAllowNotifyForZone assoc = new Linux_DnsAllowNotifyForZone(adapter.getCimClient(),adapter.getNamespace());
                    assoc.set_GroupComponent_Linux_DnsZone(zone);
                    assoc.set_PartComponent_Linux_DnsAddressMatchList(acl[idx]);
                    adapter.getFcoHelper().create(assoc,adapter.getCimClient());
        		}
        		created = true;
        	}
        	else
        	{
        		aclByIdx.set_key_Name(NameFactory.createName(cls, null));
                aclByIdx.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
                acl[idx] = aclByIdx = (Linux_DnsAddressMatchList) adapter.getFcoHelper().create(aclByIdx, adapter.getCimClient());
                if (DnsCimAdapter.DUMMY_MODE)
                {
                    Linux_DnsAllowNotifyForService assoc = new Linux_DnsAllowNotifyForService(adapter.getCimClient(),adapter.getNamespace());
                	assoc.set_GroupComponent_Linux_DnsService(adapter.getDnsService().getFco());
                    assoc.set_PartComponent_Linux_DnsAddressMatchList(acl[idx]);
                	adapter.getFcoHelper().create(assoc,adapter.getCimClient());
                }
                created = true;
        		
        	}
        }
        //delete the old
        else if (!addressMatchListExists[idx] && aclByIdx.isFromServer())
        {
        	try {
        		if (zone != null)
        		{
        			if (DnsCimAdapter.DUMMY_MODE)
        			{
        				deleteAssociation(getClassByIdx(idx), aclByIdx);
        			}

        			adapter.getFcoHelper().delete(aclByIdx,adapter.getCimClient());
        			resetAcl(idx);
        			return null;
        		}
        		else
        		{
        			if (DnsCimAdapter.DUMMY_MODE)
        			{
        				deleteAssociation(getClassByIdx(idx), aclByIdx);
        			}
        			adapter.getFcoHelper().delete(aclByIdx,adapter.getCimClient());
        			resetAcl(idx);
        			return null;
        		}
        	} catch (Exception e) {
        		throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,e);
        	}
        }
        
        String[] addresses = new String[getUsedAddressesAsList(idx).size()];
        UnsignedInteger8[] addressTypes = new UnsignedInteger8[getUsedAddressTypesAsList(idx).size()];
        
        for (int i=0; i < getUsedAddressesAsList(idx).size(); i++) {
        	addresses[i] = (String) getUsedAddressesAsList(idx).get(i);
        	addressTypes[i] = (UnsignedInteger8) getUsedAddressTypesAsList(idx).get(i); 
        }
        aclByIdx.set_AddressMatchListElement(addresses);
        aclByIdx.set_AddressMatchListElementType(addressTypes);
        
        if (aclByIdx.isModified() && aclByIdx.isFromServer())
        {
        	adapter.getFcoHelper().save(aclByIdx,adapter.getCimClient());
        	resetAcl(idx);
        }
        else if (created)
        {
        	resetAcl(idx);
        }
        
        return null;
	}

	/**
	 * Helper Method to delete a Assocation. Should  be only used in DummyMode
	 * @param aclByIdx
	 * @param associationHelperClass
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws WbemsmtException
	 * @throws ClassNotFoundException 
	 * @throws WbemsmtException 
	 */
	private void deleteAssociation(Class associationClass, Linux_DnsAddressMatchList aclByIdx) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, WbemsmtException {
		
	    String className = ClassUtils.getShortClassName(associationClass);

	    Method m = zone != null ? 
	            zone.getClass().getMethod("getAssociations_" + className, new Class[]{WBEMClient.class, boolean.class, boolean.class, String.class, String[].class}) : 
	            adapter.getDnsService().getFco().getClass().getMethod("getAssociations_" + className, new Class[]{WBEMClient.class, boolean.class, boolean.class, String.class, String[].class});
	    
	    Object fco = zone != null ? (Object)zone : (Object)adapter.getDnsService().getFco();
	            
	    List list = (List) m.invoke(fco, new Object[]{adapter.getCimClient(),new Boolean(false),new Boolean(false),null,null});
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			AbstractWbemsmtFco o = (AbstractWbemsmtFco) iter.next();
			adapter.getFcoHelper().delete(o,adapter.getCimClient());
		}
	}

	private Class getClassByIdx(int idx) throws WbemsmtException {

		Class cls = null;
		if (zone != null)
		{
			if (idx == IDX_NOTIFY) cls = Linux_DnsAllowNotifyForZone.class;
			else if (idx == IDX_QUERY) cls = Linux_DnsAllowQueryForZone.class;
			else if (idx == IDX_UPDATE) cls = Linux_DnsAllowUpdateForZone.class;
			else if (idx == IDX_TRANSFER) cls = Linux_DnsAllowTransferForZone.class;
			else throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Cannot implicit create ACL for share of type " + idx);
		} else {
			if (idx == IDX_NOTIFY) cls = Linux_DnsAllowNotifyForService.class;
			else if (idx == IDX_QUERY) cls = Linux_DnsAllowQueryForService.class;
			else if (idx == IDX_TRANSFER) cls = Linux_DnsAllowTransferForService.class;
			else if (idx == IDX_RECURSION) cls = Linux_DnsAllowRecursionForService.class;
			else if (idx == IDX_BLACKHOLE) cls = Linux_DnsBlackholeForService.class;
			else throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Cannot implicit create ACL for service of type " + idx);
		}
		return cls;
	}
	
	public void updateControls(DnsAddressMatchListDataContainer container, int idx, String ignoreThisName) throws WbemsmtException {
		
		getAcl(idx);
        
        for (int i = getNotUsedAddressesAsList(idx).size() - 1; i >= 0; i--) {
        	String address = (String) getNotUsedAddressesAsList(idx).get(i);
        	if (address.equals(ignoreThisName))
        	{
        		getNotUsedAddressesAsList(idx).remove(i);
        	}
        }
        
        container.get_AddressList().setValues((String[]) getUsedAddressesAsList(idx).toArray(new String[getUsedAddressesAsList(idx).size()]));
        container.get_usr_UserAddresses().setValues((String[]) getNotUsedAddressesAsList(idx).toArray(new String[getNotUsedAddressesAsList(idx).size()]));
	}
	
	public void updateModel(DnsAddressMatchListDataContainer container, LabeledBaseInputComponentIf useGlobalButton,  int idx) throws WbemsmtException {
		
		getAcl(idx);
        
        if (adapter.getUpdateTrigger() == container.get_usr_AddNewAddress())
        {
        	String userEnteredAddress = (String) container.get_usr_NewAddress().getConvertedControlValue();
        	if(StringUtils.isNotEmpty(userEnteredAddress))
        	{
        		AddressMatchListElementValidator validator = new AddressMatchListElementValidator(container.get_usr_NewAddress(),adapter);
        		MessageList list = validator.validate();
                if (!list.hasErrors())
                {
                	if (!validator.isPredefindAddressMatchList())
                	{
                		add(idx,userEnteredAddress,container);
                	}
                	else
                	{
                		boolean found = false;
                		for (int i=0; !found && i < getNotUsedAddressesAsList(idx).size(); i++) {
                			String notUsedAddress = (String) getNotUsedAddressesAsList(idx).get(i);
                			if (notUsedAddress.equals(userEnteredAddress))
                			{
                				getNotUsedAddressesAsList(idx).remove(i);
                				add(idx,userEnteredAddress,container);
                				found = true;
                			}
                		}
                		if (!found)
                		{
                			list = MessageList.init(container);
                			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_ACL,"value.not.added.to.acl",new Object[]{container.get_usr_NewAddress()});
                			list.addMessage(new Message(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_ACL,Message.WARNING,msg,container.get_usr_NewAddress()));

                		}
                	}
                }
                else
                {
                	MessageList.init(container).addAll(list);
                }
        		
        	}
        	//reset the values
        	container.get_usr_NewAddress().setControlValue("");
        	container.get_usr_UserAddresses().setControlValue(new ArrayList());
        }
        else if (adapter.getUpdateTrigger() == container.get_usr_AddPredefinedAddress())
        {
        	List indexList = (List) container.get_usr_UserAddresses().getConvertedControlValue();
        	
        	for (int i = indexList.size() - 1; i >= 0; i--) {
        		UnsignedInteger16 index = (UnsignedInteger16)indexList.get(i);
        		String addressToAdd = (String) getNotUsedAddressesAsList(idx).remove(index.intValue());
        		add(idx,addressToAdd,container);

        	}
        	//reset the values
        	container.get_usr_NewAddress().setControlValue("");
        	container.get_usr_UserAddresses().setControlValue(new ArrayList());
        }
        else if (adapter.getUpdateTrigger() == container.get_usr_RemoveAddress())
        {
        	List indexList = (List) container.get_AddressList().getConvertedControlValue();
        	for (int i = indexList.size() - 1; i >= 0; i--) {
        		UnsignedInteger16 index = (UnsignedInteger16) indexList.get(i);
        		getUsedAddressTypesAsList(idx).remove(index.intValue());
        		String addressToRemove = (String) getUsedAddressesAsList(idx).remove(index.intValue());
        		
        		//if the adress is a link to a userdefined addressMatchList, put to the not used list
        		if (adapter.getDnsService().getAddressMatchListList().getAddressMatchListByListName(addressToRemove) != null)
        		{
        			getNotUsedAddressesAsList(idx).add(addressToRemove);
        			container.get_usr_UserAddresses().setModified(true);
        		}
        	}
        	container.get_AddressList().setControlValue(new ArrayList());
        }
        else if (adapter.getUpdateTrigger() == container.get_usr_AddressDown())
        {
        	List indexList = (List) container.get_AddressList().getConvertedControlValue();
        	for (int i = indexList.size() - 1; i >= 0; i--) {
        		int index = ((UnsignedInteger16) indexList.get(i)).intValue();
        		if (index < getUsedAddressesAsList(idx).size() - 1)
        		{
        			indexList.set(i, new UnsignedInteger16(index+1));

        			Object address = getUsedAddressesAsList(idx).get(index);
        			Object nextAddress = getUsedAddressesAsList(idx).get(index+1);
        			getUsedAddressesAsList(idx).set(index, nextAddress);
        			getUsedAddressesAsList(idx).set(index+1, address);

        			Object type = getUsedAddressTypesAsList(idx).get(index);
        			Object nextType = getUsedAddressTypesAsList(idx).get(index+1);
        			getUsedAddressTypesAsList(idx).set(index,nextType);
        			getUsedAddressTypesAsList(idx).set(index+1,type);
        			
        			container.get_usr_UserAddresses().setModified(true);
        			
        		}
        	}
        	container.get_AddressList().setControlValue(indexList);
        }
        else if (adapter.getUpdateTrigger() == container.get_usr_AddressUp())
        {
        	List indexList = (List) container.get_AddressList().getConvertedControlValue();
        	for (int i = 0; i < indexList.size(); i++) {
        		int index = ((UnsignedInteger16) indexList.get(i)).intValue();
        		if (index > 0)
        		{
        			indexList.set(i, new UnsignedInteger16(index-1));
        								
        			Object address = getUsedAddressesAsList(idx).get(index);
        			Object prevAddress = getUsedAddressesAsList(idx).get(index-1);
        			getUsedAddressesAsList(idx).set(index, prevAddress);
        			getUsedAddressesAsList(idx).set(index-1, address);

        			Object type = getUsedAddressTypesAsList(idx).get(index);
        			Object prevType = getUsedAddressTypesAsList(idx).get(index-1);
        			getUsedAddressTypesAsList(idx).set(index,prevType);
        			getUsedAddressTypesAsList(idx).set(index-1,type);

        			container.get_usr_UserAddresses().setModified(true);
        			
        		}
        	}
        	container.get_AddressList().setControlValue(indexList);
        }
        else if (useGlobalButton != null && adapter.getUpdateTrigger() ==  useGlobalButton)
        {
        	for (int i = getUsedAddressesAsList(idx).size() - 1; i >= 0; i--) {
        		getUsedAddressTypesAsList(idx).remove(i);
        		String addressToRemove = (String) getUsedAddressesAsList(idx).remove(i);
        		
        		//if the adress is a link to a userdefined addressMatchList, put to the not used list
        		if (adapter.getDnsService().getAddressMatchListList().getAddressMatchListByListName(addressToRemove) != null)
        		{
        			getNotUsedAddressesAsList(idx).add(addressToRemove);
        		}
        	}
        	container.get_AddressList().setControlValue(new ArrayList());
        	addressMatchListExists[idx] = false;
        	container.get_usr_UserAddresses().setModified(true);
        	
        }
        else
        {
        	throw new WbemsmtException(WbemsmtException.ERR_UPDATING_MODEL,"Cannot update Model");
        } 
	}
	
	/**
	 * add the string to usedAddresses list at index idx, if addressToAdd not already exists.
	 * @param idx
	 * @param addressToAdd
	 * @param container 
	 * @throws WbemsmtException 
	 */
	private void add(int idx, String addressToAdd, DnsAddressMatchListDataContainer container) throws WbemsmtException {
		
		boolean found = false;
		for (Iterator iter = getUsedAddressesAsList(idx).iterator(); iter.hasNext() && !found;) {
			String element = (String) iter.next();
			if (element.equals(addressToAdd))
			{
				found = true;
			}
		}
		
		if (!found)
		{
			getUsedAddressesAsList(idx).add(addressToAdd);
			getUsedAddressTypesAsList(idx).add(Linux_DnsAddressMatchList.PROPERTY_ADDRESSMATCHLISTELEMENTTYPE.VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_IPv4);
			container.get_AddressList().setModified(true);
			addressMatchListExists[idx] = true;
		}
		else
		{
			MessageList list = MessageList.init(container);
			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_ACL,"value.not.added.to.acl",new Object[]{addressToAdd});
			list.addMessage(new Message(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_ACL,Message.WARNING,msg));
		}
	}

	public String getUsedAddresses(int idx) throws WbemsmtException
	{
		StringBuffer sb = new StringBuffer();
		
		for (Iterator iter = getUsedAddressesAsList(idx).iterator(); iter.hasNext();) {
			String addresss = (String) iter.next();
			if (sb.length() > 0)
			{
				sb.append(", ");
			}
			sb.append(addresss);
		}
		return sb.toString();
	}

	public String[] getUsedAddressesAsArray(int idx) throws WbemsmtException
	{
		return (String[]) getUsedAddressesAsList(idx).toArray(new String[getUsedAddressesAsList(idx).size()]);
	}

	private List getUsedAddressesAsList(int idx) throws WbemsmtException
	{
		if (usedAddresses[idx] == null)
		{
			loadAclDependentObjects(idx);
		}
		return usedAddresses[idx];
	}

	private List getUsedAddressTypesAsList(int idx) throws WbemsmtException
	{
		if (usedAddressTypes[idx] == null)
		{
			loadAclDependentObjects(idx);
		}
		return usedAddressTypes[idx];
	}

	private List getNotUsedAddressesAsList(int idx) throws WbemsmtException
	{
		if (notUsedAddresses[idx] == null)
		{
			loadAclDependentObjects(idx);
		}
		return notUsedAddresses[idx];
	}

	public Linux_DnsAddressMatchList create(int idx, String aclName) throws WbemsmtException {
		acl[idx].set_key_Name(aclName);
        acl[idx].set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);

        String[] addresses = new String[getUsedAddressesAsList(idx).size()];
        UnsignedInteger8[] addressTypes = new UnsignedInteger8[getUsedAddressTypesAsList(idx).size()];
        
        for (int i=0; i < getUsedAddressesAsList(idx).size(); i++) {
        	addresses[i] = (String) getUsedAddressesAsList(idx).get(i);
        	addressTypes[i] = (UnsignedInteger8) getUsedAddressTypesAsList(idx).get(i);
        }
        acl[idx].set_AddressMatchListElement(addresses);
        acl[idx].set_AddressMatchListElementType(addressTypes);
        acl[idx] = (Linux_DnsAddressMatchList) adapter.getFcoHelper().create(acl[idx],adapter.getCimClient());

        if (DnsCimAdapter.DUMMY_MODE)
        {
            Linux_DnsAddressMatchListsForService assoc = new Linux_DnsAddressMatchListsForService(adapter.getCimClient(),adapter.getNamespace());
            assoc.set_GroupComponent_Linux_DnsService(adapter.getDnsService().getFco());
            assoc.set_PartComponent_Linux_DnsAddressMatchList(acl[idx]);
        	adapter.getFcoHelper().create(assoc,adapter.getCimClient());
        }
        Linux_DnsAddressMatchList result = acl[idx];
        resetAcl(idx);
        
        return result;
		
	}

	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(new CIMObjectPath("AclHandlerForClass" + loader.getClass().getName()));
	}
}
