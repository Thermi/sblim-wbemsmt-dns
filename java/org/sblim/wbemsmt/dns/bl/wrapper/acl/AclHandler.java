 /** 
  * AclHandler.java
  *
  * � Copyright IBM Corp. 2005
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
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.dns.bl.validator.AddressMatchListElementValidator;
import org.sblim.wbemsmt.dns.bl.wrapper.DnsObject;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.list.AddressMatchListList;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectCreationException;
import org.sblim.wbemsmt.exception.ObjectDeletionException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;
import org.sblim.wbemsmt.exception.ValidationException;
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
	
	public static final int TYPE_IN_ZONE = 0; 
	public static final int TYPE_IN_SERVICE = 1; 
	public static final int TYPE_GLOBAL = 2; 

	public static final int IDX_NOTIFY = 0; 
	public static final int IDX_TRANSFER = 1; 
	public static final int IDX_UPDATE = 2; 
	public static final int IDX_QUERY = 3; 
	public static final int IDX_BLACKHOLE = 4; 
	public static final int IDX_USER = 5; 
	public static final int IDX_RECURSION = 6; 

	public Linux_DnsAddressMatchList getAcl(int index) throws ModelLoadException {

		if (acl[index] == null)
		{
			CIMClient cc = adapter.getCimClient();
			List associatedObjects = loader.load(index);
			if (associatedObjects == null)
			{
				throw new ModelLoadException(CANNOT_LOAD_OBJECTS_FOR_TYPE + index);
			}
			
			if (associatedObjects.size() == 0 || associatedObjects.get(0) instanceof CIMObjectPath )
			{
				acl[index] = (Linux_DnsAddressMatchList) getFirstChild(Linux_DnsAddressMatchList.class,associatedObjects,true,true, cc);
			}
			else
			{
				acl[index] = (Linux_DnsAddressMatchList) associatedObjects.get(0);
			}

			loadAclDependentObjects(index);
			
		}
		return acl[index];
	}

	
	
	
	private void loadAclDependentObjects(int index) throws ModelLoadException {
	
		notUsedAddresses[index] = new ArrayList();
		//add the userdefined ones
		AddressMatchListList addressMatchListList = adapter.getDnsService().getAddressMatchListList();
		for (int i=0; i < addressMatchListList.size(); i++)
		{
			String name = addressMatchListList.getAddressMatchList(i).getFco().get_Name();
			notUsedAddresses[index].add(name);
		}

		usedAddresses[index] = new ArrayList();
		usedAddressTypes[index] = new ArrayList();
		String[] addresses = acl[index].get_AddressMatchListElement();
		UnsignedInt8[] addressTypes = acl[index].get_AddressMatchListElementType();
		
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

	public void resetAcls() throws ModelLoadException {

		for (int i = 0; i < acl.length; i++) {
			try {
				resetAcl(i);
			} catch (ModelLoadException e) {
				if (e.getMessage().startsWith(CANNOT_LOAD_OBJECTS_FOR_TYPE))
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

	public void resetAcl(int idx) throws ModelLoadException {
		acl[idx] = null;
		acl[idx] = getAcl(idx);
		usedAddressTypes[idx] = usedAddresses[idx] = notUsedAddresses[idx] = null;
	}


	public MessageList save(int idx) throws ObjectSaveException {

		try {
			Linux_DnsAddressMatchList aclByIdx = getAcl(idx);
			boolean created = false;
			//create a new acl?
			if (addressMatchListExists[idx] && !aclByIdx.isValidCimInstance())
			{
				Class cls = getClassByIdx(idx);
				
				if (zone != null)
				{
					aclByIdx.set_Name(NameFactory.createName(cls, zone.get_Name()));
					aclByIdx.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
					acl[idx] = aclByIdx = (Linux_DnsAddressMatchList) FcoHelper.create(aclByIdx, adapter.getCimClient());
					if (DnsCimAdapter.DUMMY_MODE)
					{
						Vector keys = new Vector();
						keys.add(CIMPropertyBuilder.create(Linux_DnsAllowNotifyForZone.CIM_PROPERTY_LINUX_DNSADDRESSMATCHLIST,acl[idx]));
						keys.add(CIMPropertyBuilder.create(Linux_DnsAllowNotifyForZone.CIM_PROPERTY_LINUX_DNSZONE,zone));
						FcoHelper.create(cls,adapter.getCimClient(),keys);
					}
					created = true;
				}
				else
				{
					try {
						aclByIdx.set_Name(NameFactory.createName(cls, null));
						aclByIdx.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
						acl[idx] = aclByIdx = (Linux_DnsAddressMatchList) FcoHelper.create(aclByIdx, adapter.getCimClient());
						if (DnsCimAdapter.DUMMY_MODE)
						{
							Vector keys = new Vector();
							keys.add(CIMPropertyBuilder.create(Linux_DnsAllowNotifyForService.CIM_PROPERTY_LINUX_DNSADDRESSMATCHLIST,acl[idx]));
							keys.add(CIMPropertyBuilder.create(Linux_DnsAllowNotifyForService.CIM_PROPERTY_LINUX_DNSSERVICE,adapter.getDnsService().getFco()));
							FcoHelper.create(cls,adapter.getCimClient(),keys);
						}
						created = true;
					} catch (ModelLoadException e) {
						throw new ObjectSaveException(new Linux_DnsAllowNotifyForService(),e);
					}
					
				}
			}
			//delete the old
			else if (!addressMatchListExists[idx] && aclByIdx.isValidCimInstance())
			{
				try {
					if (zone != null)
					{
						if (DnsCimAdapter.DUMMY_MODE)
						{
							deleteAssociation(getClassByIdx(idx), aclByIdx, "get_Linux_DnsZone");
						}
	
						FcoHelper.delete(aclByIdx,adapter.getCimClient());
						resetAcl(idx);
						return null;
					}
					else
					{
						if (DnsCimAdapter.DUMMY_MODE)
						{
							deleteAssociation(getClassByIdx(idx), aclByIdx, "get_Linux_DnsService");
						}
						FcoHelper.delete(aclByIdx,adapter.getCimClient());
						resetAcl(idx);
						return null;
					}
				} catch (ObjectDeletionException e) {
					throw new ObjectSaveException(e);
				} catch (Exception e) {
					throw new ObjectSaveException(e);
				}
			}
			
			String[] addresses = new String[getUsedAddressesAsList(idx).size()];
			UnsignedInt8[] addressTypes = new UnsignedInt8[getUsedAddressTypesAsList(idx).size()];
			
			for (int i=0; i < getUsedAddressesAsList(idx).size(); i++) {
				addresses[i] = (String) getUsedAddressesAsList(idx).get(i);
				addressTypes[i] = (UnsignedInt8) getUsedAddressTypesAsList(idx).get(i); 
			}
			aclByIdx.set_AddressMatchListElement(addresses);
			aclByIdx.set_AddressMatchListElementType(addressTypes);
			
			if (aclByIdx.isModified() && aclByIdx.isValidCimInstance())
			{
				FcoHelper.save(aclByIdx,adapter.getCimClient());
				resetAcl(idx);
			}
			else if (created)
			{
				resetAcl(idx);
			}
			
			return null;
		} catch (ModelLoadException e1) {
			throw new ObjectSaveException(e1);
		}
	}

	/**
	 * Helper Method to delete a Assocation. Should  be only used in DummyMode
	 * @param associationHelperClass
	 * @param aclByIdx
	 * @param getterNameGroupComponent
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws ObjectDeletionException
	 * @throws ClassNotFoundException 
	 * @throws ModelLoadException 
	 */
	private void deleteAssociation(Class associationClass, Linux_DnsAddressMatchList aclByIdx, String getterNameGroupComponent) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ObjectDeletionException, ClassNotFoundException, ModelLoadException {
		CIMObjectPath groupPath = zone != null ? zone.getCimObjectPath() : adapter.getDnsService().getFco().getCimObjectPath();
		Class associationHelperClass = Class.forName(associationClass.getName() + "Helper");
		Method m = associationHelperClass.getMethod("enumerateInstances", new Class[]{CIMClient.class,boolean.class});
		List list = (List) m.invoke(null,new Object[]{adapter.getCimClient(),Boolean.FALSE});
		boolean found = false;
		for (Iterator iter = list.iterator(); !found && iter.hasNext();) {
			Object o = iter.next();
			CIMObjectPath pathZone = (CIMObjectPath) o.getClass().getMethod(getterNameGroupComponent, new Class[]{}).invoke(o, null);
			CIMObjectPath pathAcl = (CIMObjectPath) o.getClass().getMethod("get_Linux_DnsAddressMatchList", new Class[]{}).invoke(o, null);
			if (pathZone.equals(groupPath) && pathAcl.equals(aclByIdx.getCimObjectPath()))
			{
				FcoHelper.delete(o,adapter.getCimClient());
				found = true;
			}
		}
	}

	private Class getClassByIdx(int idx) throws ObjectSaveException {

		Class cls = null;
		if (zone != null)
		{
			if (idx == IDX_NOTIFY) cls = Linux_DnsAllowNotifyForZone.class;
			else if (idx == IDX_QUERY) cls = Linux_DnsAllowQueryForZone.class;
			else if (idx == IDX_UPDATE) cls = Linux_DnsAllowUpdateForZone.class;
			else if (idx == IDX_TRANSFER) cls = Linux_DnsAllowTransferForZone.class;
			else throw new ObjectSaveException("Cannot implicit create ACL for share of type " + idx);
		} else {
			if (idx == IDX_NOTIFY) cls = Linux_DnsAllowNotifyForService.class;
			else if (idx == IDX_QUERY) cls = Linux_DnsAllowQueryForService.class;
			else if (idx == IDX_TRANSFER) cls = Linux_DnsAllowTransferForService.class;
			else if (idx == IDX_RECURSION) cls = Linux_DnsAllowRecursionForService.class;
			else if (idx == IDX_BLACKHOLE) cls = Linux_DnsBlackholeForService.class;
			else throw new ObjectSaveException("Cannot implicit create ACL for service of type " + idx);
		}
		return cls;
	}
	
	public void updateControls(DnsAddressMatchListDataContainer container, int idx, String ignoreThisName) throws UpdateControlsException {
		
		try {
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
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}
	
	public void updateModel(DnsAddressMatchListDataContainer container, LabeledBaseInputComponentIf useGlobalButton,  int idx) throws ModelUpdateException {
		
		try {
			
			getAcl(idx);
			
			if (adapter.getUpdateTrigger() == container.get_usr_AddNewAddress())
			{
				String userEnteredAddress = (String) container.get_usr_NewAddress().getConvertedControlValue();
				if(StringUtils.isNotEmpty(userEnteredAddress))
				{
					AddressMatchListElementValidator validator = new AddressMatchListElementValidator(container.get_usr_NewAddress(),adapter);
					try {
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
					} catch (ValidationException e) {
						throw new ModelUpdateException(e);
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
					UnsignedInt16 index = (UnsignedInt16)indexList.get(i);
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
					UnsignedInt16 index = (UnsignedInt16) indexList.get(i);
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
					int index = ((UnsignedInt16) indexList.get(i)).intValue();
					if (index < getUsedAddressesAsList(idx).size() - 1)
					{
						indexList.set(i, new UnsignedInt16(index+1));

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
					int index = ((UnsignedInt16) indexList.get(i)).intValue();
					if (index > 0)
					{
						indexList.set(i, new UnsignedInt16(index-1));
											
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
				throw new ModelUpdateException("Cannot update Model");
			}

		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		} 
	}
	
	/**
	 * add the string to usedAddresses list at index idx, if addressToAdd not already exists.
	 * @param idx
	 * @param addressToAdd
	 * @param container 
	 * @throws ModelLoadException 
	 */
	private void add(int idx, String addressToAdd, DnsAddressMatchListDataContainer container) throws ModelLoadException {
		
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
			//TODO use other than ipv4 
			getUsedAddressTypesAsList(idx).add(new UnsignedInt8((short)Linux_DnsAddressMatchList.ADDRESSMATCHLISTELEMENTTYPE_IPV4));
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

	public String getUsedAddresses(int idx) throws ModelLoadException
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

	public String[] getUsedAddressesAsArray(int idx) throws ModelLoadException
	{
		return (String[]) getUsedAddressesAsList(idx).toArray(new String[getUsedAddressesAsList(idx).size()]);
	}

	private List getUsedAddressesAsList(int idx) throws ModelLoadException
	{
		if (usedAddresses[idx] == null)
		{
			loadAclDependentObjects(idx);
		}
		return usedAddresses[idx];
	}

	private List getUsedAddressTypesAsList(int idx) throws ModelLoadException
	{
		if (usedAddressTypes[idx] == null)
		{
			loadAclDependentObjects(idx);
		}
		return usedAddressTypes[idx];
	}

	private List getNotUsedAddressesAsList(int idx) throws ModelLoadException
	{
		if (notUsedAddresses[idx] == null)
		{
			loadAclDependentObjects(idx);
		}
		return notUsedAddresses[idx];
	}

	public Linux_DnsAddressMatchList create(int idx, String aclName) throws ObjectCreationException {
		try {
			acl[idx].set_Name(aclName);
			acl[idx].set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);

			String[] addresses = new String[getUsedAddressesAsList(idx).size()];
			UnsignedInt8[] addressTypes = new UnsignedInt8[getUsedAddressTypesAsList(idx).size()];
			
			for (int i=0; i < getUsedAddressesAsList(idx).size(); i++) {
				addresses[i] = (String) getUsedAddressesAsList(idx).get(i);
				addressTypes[i] = (UnsignedInt8) getUsedAddressTypesAsList(idx).get(i);
			}
			acl[idx].set_AddressMatchListElement(addresses);
			acl[idx].set_AddressMatchListElementType(addressTypes);
			acl[idx] = (Linux_DnsAddressMatchList) FcoHelper.create(acl[idx],adapter.getCimClient());

			if (DnsCimAdapter.DUMMY_MODE)
			{
				Vector keys = new Vector();
				keys.add(CIMPropertyBuilder.create(Linux_DnsAddressMatchListsForService.CIM_PROPERTY_LINUX_DNSADDRESSMATCHLIST,acl[idx]));
				keys.add(CIMPropertyBuilder.create(Linux_DnsAddressMatchListsForService.CIM_PROPERTY_LINUX_DNSSERVICE,adapter.getDnsService().getFco()));
				FcoHelper.create(Linux_DnsAddressMatchListsForService.class,adapter.getCimClient(),keys);
			}
			Linux_DnsAddressMatchList result = acl[idx];
			resetAcl(idx);
			
			return result;
		} catch (ModelLoadException e) {
			throw new ObjectCreationException(acl[idx],e);
		}
		
	}
}
