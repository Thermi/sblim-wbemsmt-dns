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

import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchListsForService;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchListsForServiceHelper;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AclHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AssociatedObjectsLoader;
import org.sblim.wbemsmt.dns.naming.AddressMatchListNaming;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class AddressMatchList extends DnsBusinessObject {

	/**
	 * Handler for acls
	 */
	AclHandler aclHandler = null;
	private Linux_DnsAddressMatchList fco;
	private AddressMatchListNaming addressMatchListNaming = new AddressMatchListNaming();
	/**
	 * @throws WbemsmtException 
	 * 
	 */
	public AddressMatchList(final Linux_DnsAddressMatchList fco, DnsCimAdapter adapter) throws WbemsmtException {
		super(adapter);
		this.fco = fco;
		updateName(addressMatchListNaming.getDisplayString(fco.getCimInstance(), adapter.getCimClient()));
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
	 * @throws WbemsmtException 
	 */
	public AddressMatchList(String name, DnsCimAdapter adapter) throws WbemsmtException {
		super(adapter);
		this.fco = new Linux_DnsAddressMatchList(adapter.getCimClient(),adapter.getNamespace());
		this.fco.set_key_Name(name);
		//is there a need to set the key of the objectpath
		//this.fco.getCimObjectPath().addKey(CIMPropertyBuilder.create(Linux_DnsAddressMatchList.PROPERTY_NAME.NAME, name, CIMDataType.STRING));
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
	
	public void loadChilds(WBEMClient cimClient) {
	}

	public MessageList save(DnsAddressMatchListForServiceDataContainer container)  throws WbemsmtException {
		//fco.set_Name((String) container.get_Name().getConvertedControlValue());
		updateName(NameFactory.createName(Linux_DnsAddressMatchListsForService.class, fco.get_key_Name()));
		MessageList result = aclHandler.save(AclHandler.IDX_USER);
		updateName(addressMatchListNaming.getDisplayString(fco.getCimInstance(), adapter.getCimClient()));
		return result;
	}

	public void updateControls(DnsAddressMatchListForServiceDataContainer container) throws WbemsmtException {
		container.get_Name().setControlValue(fco.get_key_Name());
		aclHandler.updateControls(container,AclHandler.IDX_USER,fco.get_key_Name());
	}

	public void updateModel(DnsAddressMatchListForServiceDataContainer container) throws WbemsmtException {
		aclHandler.updateModel(container,null,AclHandler.IDX_USER);
	}

	public void delete() throws WbemsmtException {
		
		try {
			String serviceName = adapter.getDnsService().getFco().get_Name();
			updateName(NameFactory.createName(Linux_DnsAddressMatchListsForService.class, fco.get_key_Name()));
			String matchListName = fco.get_key_Name();
			List list = Linux_DnsAddressMatchListsForServiceHelper.enumerateInstances(adapter.getCimClient(),adapter.getNamespace(),false);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Linux_DnsAddressMatchListsForService acl = (Linux_DnsAddressMatchListsForService) iter.next();
				Object serviceName2 = acl.get_GroupComponent_Linux_DnsService(adapter.getCimClient()).get_key_Name();
				Object matchListName2 = acl.get_PartComponent_Linux_DnsAddressMatchList(adapter.getCimClient()).get_key_Name();
				
				if (serviceName2.equals(serviceName) && matchListName2.equals(matchListName))
				{
					Linux_DnsAddressMatchList aml = acl.get_PartComponent_Linux_DnsAddressMatchList(adapter.getCimClient());
					adapter.getFcoHelper().delete(aml,adapter.getCimClient());
					if (DnsCimAdapter.DUMMY_MODE)
					{
						adapter.getFcoHelper().delete(acl,adapter.getCimClient());
					}
					return;
				}
			}
			throw new WbemsmtException(WbemsmtException.ERR_DELETE_OBJECT,"MatchList " + matchListName + "was not found.", getFco());
			
		} catch (Exception e) {
			throw new WbemsmtException(WbemsmtException.ERR_DELETE_OBJECT,getFco(),e);
		}
	}
	
	private void updateName(Object value) {
		this.fco.set_key_Name(value.toString());
	}

	public MessageList revert(DnsAddressMatchListForServiceDataContainer container) throws WbemsmtException {
		fco = (Linux_DnsAddressMatchList) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
        aclHandler.resetAcl(AclHandler.IDX_USER);
		return null;
	}
	
}
