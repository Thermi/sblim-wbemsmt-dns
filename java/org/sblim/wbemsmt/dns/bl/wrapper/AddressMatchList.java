 /** 
  * MasterZone.java
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
  * Description: wrapper for a masterZone
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sblim.wbem.cim.CIMDataType;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchListHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchListsForService;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchListsForServiceHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsService;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AclHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AssociatedObjectsLoader;
import org.sblim.wbemsmt.dns.naming.AddressMatchListNaming;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectCreationException;
import org.sblim.wbemsmt.exception.ObjectDeletionException;
import org.sblim.wbemsmt.exception.ObjectRevertException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public class AddressMatchList extends DnsBusinessObject {

	/**
	 * Handler for acls
	 */
	AclHandler aclHandler = null;
	private Linux_DnsAddressMatchList fco;
	private AddressMatchListNaming addressMatchListNaming = new AddressMatchListNaming();
	/**
	 * @throws ModelLoadException 
	 * 
	 */
	public AddressMatchList(final Linux_DnsAddressMatchList fco, DnsCimAdapter adapter) throws ModelLoadException {
		super(adapter);
		this.fco = fco;
		updateName(addressMatchListNaming.getDisplayString(fco.getCimInstance()));
		aclHandler = new AclHandler(adapter, new AssociatedObjectsLoader()
		 {

			public List load(int index) {
				List result = new ArrayList();
				result.add(fco.getCimObjectPath());
				return result;
			}
			
		 }, null);
	}

	/**
	 * This one can be use to create AddressMatchList for any, localhost, localnets...
	 * @param name
	 * @param adapter
	 * @throws ModelLoadException 
	 */
	public AddressMatchList(String name, DnsCimAdapter adapter) throws ModelLoadException {
		super(adapter);
		this.fco = new Linux_DnsAddressMatchList();
		this.fco.set_Name(name);
		this.fco.getCimObjectPath().addKey(CIMPropertyBuilder.create(Linux_DnsAddressMatchList.CIM_PROPERTY_NAME, name, CIMDataType.STRING));
		aclHandler = new AclHandler(adapter, new AssociatedObjectsLoader()
		 {

			public List load(int index) {
				List result = new ArrayList();
				result.add(fco.getCimObjectPath());
				return result;
			}
			
		 }, null);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(fco.getCimObjectPath());
	}

	
	public Linux_DnsAddressMatchList getFco() {
			return fco;
	}
	
	public void loadChilds(CIMClient cimClient) {
	}

	public MessageList save(DnsAddressMatchListForServiceDataContainer container)  throws ObjectSaveException {
		//fco.set_Name((String) container.get_Name().getConvertedControlValue());
		updateName(NameFactory.createName(Linux_DnsAddressMatchListsForService.class, fco.get_Name()));
		MessageList result = aclHandler.save(AclHandler.IDX_USER);
		updateName(addressMatchListNaming.getDisplayString(fco.getCimInstance()));
		return result;
	}

	public void updateControls(DnsAddressMatchListForServiceDataContainer container) throws UpdateControlsException {
		container.get_Name().setControlValue(fco.get_Name());
		aclHandler.updateControls(container,AclHandler.IDX_USER,fco.get_Name());
	}

	public void updateModel(DnsAddressMatchListForServiceDataContainer container) throws ModelUpdateException {
		aclHandler.updateModel(container,null,AclHandler.IDX_USER);
	}

	public void delete() throws ObjectDeletionException {
		
		try {
			String serviceName = adapter.getDnsService().getFco().get_Name();
			updateName(NameFactory.createName(Linux_DnsAddressMatchListsForService.class, fco.get_Name()));
			String matchListName = fco.get_Name();
			List list = Linux_DnsAddressMatchListsForServiceHelper.enumerateInstances(adapter.getCimClient(),false);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Linux_DnsAddressMatchListsForService acl = (Linux_DnsAddressMatchListsForService) iter.next();
				Object serviceName2 = acl.get_Linux_DnsService().getKey(Linux_DnsService.CIM_PROPERTY_NAME).getValue().getValue();
				Object matchListName2 = acl.get_Linux_DnsAddressMatchList().getKey(Linux_DnsAddressMatchList.CIM_PROPERTY_NAME).getValue().getValue();
				
				if (serviceName2.equals(serviceName) && matchListName2.equals(matchListName))
				{
					Linux_DnsAddressMatchList aml = (Linux_DnsAddressMatchList) FcoHelper.reload(Linux_DnsAddressMatchListHelper.class, acl.get_Linux_DnsAddressMatchList(),adapter.getCimClient() );
					FcoHelper.delete(aml,adapter.getCimClient());
					if (DnsCimAdapter.DUMMY_MODE)
					{
						FcoHelper.delete(acl,adapter.getCimClient());
					}
					return;
				}
			}
			throw new ObjectDeletionException("MatchList " + matchListName + "was not found.", getFco());
			
		} catch (ModelLoadException e) {
			throw new ObjectDeletionException(getFco(),e);
		} catch (ObjectCreationException e) {
			throw new ObjectDeletionException(getFco(),e);
		}
	}
	
	private void updateName(Object value) {
		this.fco.getCimInstance().setProperty(Linux_DnsAddressMatchList.CIM_PROPERTY_NAME,CIMPropertyBuilder.createVaue(value, CIMDataType.STRING));
	}

	public MessageList revert(DnsAddressMatchListForServiceDataContainer container) throws ObjectRevertException {
		try {
			fco = (Linux_DnsAddressMatchList) FcoHelper.reload(fco, adapter.getCimClient());
			aclHandler.resetAcl(AclHandler.IDX_USER);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}
	
}
