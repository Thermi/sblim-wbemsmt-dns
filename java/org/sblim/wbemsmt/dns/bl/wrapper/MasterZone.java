 /** 
  * MasterZone.java
  *
  * © Copyright IBM Corp.  2009,2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: wrapper for a master zone
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.List;

import javax.cim.CIMObjectPath;
import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.dns.bl.resourcerecord.ResourceRecordHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AclHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AssociatedObjectsLoader;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class MasterZone extends DnsBusinessObject implements Zone {

	private Linux_DnsMasterZone fco;

	protected ResourceRecordList resourceRecords; 

	/**
	 * Lazy loaded childs
	 */


	/**
	 * Handler for acls
	 */
	protected AclHandler aclHandler = null;
	
	/**
	 * Lists for the addresses
	 */

	protected  ForwarderList forwarderList;
	Linux_DnsForwarders forwarder = null;
	
	/**
	 * 
	 */
	public MasterZone(final Linux_DnsMasterZone fco,final DnsCimAdapter adapter) {
		super(adapter);
		this.fco = fco;
		aclHandler = new AclHandler(adapter, new AssociatedObjectsLoader()
		{

			public List<CIMObjectPath> load(int index) throws WbemsmtException {
				switch (index) {
                case AclHandler.IDX_NOTIFY:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowNotifyForZoneNames(adapter.getCimClient());
                case AclHandler.IDX_TRANSFER:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowTransferForZoneNames(adapter.getCimClient());
                case AclHandler.IDX_QUERY:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowQueryForZoneNames(adapter.getCimClient());
                case AclHandler.IDX_UPDATE:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowUpdateForZoneNames(adapter.getCimClient());
                default:
                	break;
                }
                return null;
			}
		}, fco);
		resourceRecordHandler = new ResourceRecordHandler(adapter,this);
	}

	/**
	 * 
	 */
	public MasterZone(DnsCimAdapter adapter) {
		this(null,adapter);
	}

	public Linux_DnsAddressMatchList getAcl(int index) throws WbemsmtException {
		return aclHandler.getAcl(index);
	}
	
	public ForwarderList getForwarderList() throws WbemsmtException {
		if (forwarderList == null || forwarderList.isReloadFromServer() )
        {
        	forwarderList = new ForwarderList();
        	List<CIMObjectPath> list = fco.getAssociated_Linux_DnsForwarders_Linux_DnsForwardersForZoneNames(adapter.getCimClient());
        	forwarder = (Linux_DnsForwarders) getFirstChild(Linux_DnsForwarders.class, list, true, true, adapter.getCimClient(), adapter.getNamespace());
        	addForwarderIps(forwarder,forwarderList);
        }
        return forwarderList;
	}	
	
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(fco.getCimObjectPath());

	}

	/**
	 * Get the wrapped fco
	 * @return
	 */
	public Linux_DnsMasterZone getMasterZone() {
		return fco;
	}
	
	public void setMasterZone(Linux_DnsMasterZone fco) {
		this.fco = fco;
	}

	public ResourceRecordList getResourceRecords() throws WbemsmtException {
		if (resourceRecords == null )
        {
        	adapter.addResourceRecords(this,fco.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(adapter.getCimClient()));
        }
        return resourceRecords;
	}

	public void setResourceRecords(ResourceRecordList resourceRecords) {
		this.resourceRecords = resourceRecords;
	}

	public void loadChilds(WBEMClient cimClient) throws WbemsmtException {
		aclHandler.resetAcls();
		forwarderList = null;
	}

	public String getName() {
		return getMasterZone().get_key_Name();
	}
	
	public MessageList save(DnsAllowUpdateForZoneDataContainer container) throws WbemsmtException  {
		return aclHandler.save(AclHandler.IDX_UPDATE);
	}

	public MessageList save(DnsAllowTransferForZoneDataContainer container) throws WbemsmtException  {
		return aclHandler.save(AclHandler.IDX_TRANSFER);
	}

	public MessageList save(DnsAllowQueryForZoneDataContainer container) throws WbemsmtException  {
		return aclHandler.save(AclHandler.IDX_QUERY);
	}


	public MessageList save(DnsMasterZoneDataContainer container) throws WbemsmtException {
		
		MessageList messageList = MessageList.init(container);
        
        fco.set_Forward(super.getForwarder(container));
        fco.set_ZoneFile((String) container.get_ZoneFile().getConvertedControlValue());
        fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
        if (fco.isModified())
        {
        	fco = (Linux_DnsMasterZone) adapter.getFcoHelper().save(fco,container.getAdapter().getCimClient());
        }

        super.saveForwardersIps(getForwarderList(), forwarder, fco);
        forwarderList.setReloadFromServer(true);
        
        return messageList;
	}

	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		super.updateControls(container,fco);
	}

	public void updateControls(DnsAllowQueryForZoneDataContainer container)  throws WbemsmtException{
		aclHandler.updateControls(container,AclHandler.IDX_QUERY,null);
	}

	public void updateControls(DnsAllowTransferForZoneDataContainer container) throws WbemsmtException {
		aclHandler.updateControls(container,AclHandler.IDX_TRANSFER,null);
	}

	public void updateControls(DnsAllowUpdateForZoneDataContainer container) throws WbemsmtException {
		aclHandler.updateControls(container,AclHandler.IDX_UPDATE,null);
	}

	public void updateControls(DnsMasterZoneDataContainer container) throws WbemsmtException {
		super.setForwarderToContainer(container,fco.get_Forward());
        container.get_Forwarders().setValues(getForwarders(getForwarderList()));
        container.get_Name().setControlValue(fco.get_key_Name());
        container.get_ZoneFile().setControlValue(fco.get_ZoneFile());
        
        updateTTLDataContainer(adapter,fco.get_TTL(), container.get_TTL(),container.get_usr_TTLUnit());
	}

	public void updateModel(DnsAllowQueryForZoneDataContainer container) throws WbemsmtException {
		aclHandler.updateModel(container,container.get_usr_UseGlobalAddressMatchList(),AclHandler.IDX_QUERY);
	}

	public void updateModel(DnsAllowTransferForZoneDataContainer container) throws WbemsmtException {
		aclHandler.updateModel(container,container.get_usr_UseGlobalAddressMatchList(),AclHandler.IDX_TRANSFER);
	}

	public void updateModel(DnsAllowUpdateForZoneDataContainer container) throws WbemsmtException {
		aclHandler.updateModel(container,null,AclHandler.IDX_UPDATE);
	}

	public void updateModel(DnsMasterZoneDataContainer container) throws WbemsmtException {
		
		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			fco.set_TTL(null);
			container.get_TTL().setModified(true);
		} 
		else
		{
			fco.set_Forward(super.getForwarder(container));
            updateForwarders(getForwarderList(),container,container.get_usr_UseGlobalForwarders());
		}
		
	}

	public void updateControls(DnsZoneTracingContainer container) throws WbemsmtException {

	    container.get_Contact().setControlValue(fco.get_Contact());
        container.get_Expire().setControlValue(fco.get_Expire());
        container.get_Forward().setControlValue(fco.get_Forward());
        getForwarderList().removeIfNotExistsOnClient();
        container.get_Forwarders().setControlValue(getForwarderList().toString());
        container.get_Name().setControlValue(fco.get_key_Name());
        container.get_ResourceRecordFile().setControlValue(fco.get_ZoneFile());
        container.get_Retry().setControlValue(fco.get_Retry());
        container.get_SerialNumber().setControlValue(fco.get_SerialNumber());
        container.get_Server().setControlValue(fco.get_Server());
        container.get_usr_MasterAddresses().getProperties().setVisible(false);
   
        updateTTLDataContainer(adapter,fco.get_TTL(), container.get_TTL(),container.get_TTLUnit());
        updateTTLDataContainer(adapter,fco.get_NegativeCachingTTL(), container.get_NegativeCaching_TTL(),container.get_usr_NegativeCaching_TTLUnit());
        
        
        show(container.getAllowNotifyAcl(),true);
        show(container.getAllowTransferAcl(),true);
        show(container.getAllowQueryAcl(),true);
        show(container.getAllowUpdateAcl(),true);
        adapter.updateControls(container.getResourceRecords(),getResourceRecords().getFCOs());
	}

	public Linux_DnsZone getLinux_DnsZone() {
		return fco;
	}

	public MessageList save(DnsSoaContainer container) throws WbemsmtException {
		return super.save(fco,container);
	}
	
	public void updateControls(DnsSoaContainer container) {
		updateControls(fco,container);
	}

	public void updateSerialNumber(DnsSoaContainer container) {
		super.setValues(fco, container, MessageList.init(container));
		super.updateSerialNumber(fco,container);
	}

	public MessageList revert(DnsAllowQueryForZoneDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_QUERY);
		return null;
	}

	public MessageList revert(DnsAllowTransferForZoneDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_TRANSFER);
		return null;
	}

	public MessageList revert(DnsAllowUpdateForZoneDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_UPDATE);
		return null;
	}

	public MessageList revert(DnsMasterZoneDataContainer container) throws WbemsmtException {
		fco = (Linux_DnsMasterZone) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}

	public MessageList revert(DnsSoaContainer container) throws WbemsmtException {
		fco = (Linux_DnsMasterZone) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}
	
}
