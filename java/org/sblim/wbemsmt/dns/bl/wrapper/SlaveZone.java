 /** 
  * SlaveZone.java
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
  * Description: wrapper for a Linux_DnsSlaveZone
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
import org.sblim.wbemsmt.dns.bl.wrapper.list.MasterItemList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.dns.bl.wrapper.masters.MastersHandler;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class SlaveZone extends MasterZone implements Zone {

	private Linux_DnsSlaveZone fco;
	
	private MastersHandler masterHandler = null;
	/**
	 * @throws WbemsmtException 
	 * 
	 */
	public SlaveZone(final Linux_DnsSlaveZone fco,final DnsCimAdapter adapter) throws WbemsmtException {
		this(adapter);
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

		Linux_DnsMasters master = (Linux_DnsMasters) getFirstChild(Linux_DnsMasters.class, fco.getAssociated_Linux_DnsMasters_Linux_DnsMastersForZoneNames(adapter.getCimClient()), true, true, adapter.getCimClient(), adapter.getNamespace());
        masterHandler = new MastersHandler(adapter,master,false, fco);
	}

	/**
	 * 
	 */
	public SlaveZone(DnsCimAdapter adapter) {
		super(adapter);
		resourceRecordHandler = new ResourceRecordHandler(adapter,this);
	}

	
	public ResourceRecordList getResourceRecords() throws WbemsmtException {
		if (resourceRecords == null )
        {
        	adapter.addResourceRecords(this,fco.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(adapter.getCimClient()));
        }
        return resourceRecords;
	}

	public ForwarderList getForwarderList() throws WbemsmtException {
		if (forwarderList == null || forwarderList.isReloadFromServer() )
        {
        	forwarderList = new ForwarderList();
        	forwarder = (Linux_DnsForwarders) getFirstChild(Linux_DnsForwarders.class, fco.getAssociated_Linux_DnsForwarders_Linux_DnsForwardersForZoneNames(adapter.getCimClient()), true, true, adapter.getCimClient(), adapter.getNamespace());
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

	public MasterItemList getMasterList() throws WbemsmtException {
		return masterHandler.getUsedItems();
	}

	/**
	 * Get the wrapped fco
	 * @return
	 */
	public Linux_DnsSlaveZone getSlaveZone() {
		return fco;
	}

	public void loadChilds(WBEMClient cimClient) throws WbemsmtException {
		aclHandler.resetAcls();
		forwarderList = null;
		masterHandler.getUsedItems().setReloadFromServer(true);
	}

	public String getName() {
		return getSlaveZone().get_key_Name();
	}

	public MessageList save(DnsSlaveZoneDataContainer container)throws WbemsmtException {
		
		fco.set_Forward(super.getForwarder(container));
        fco.set_ZoneFile((String) container.get_ZoneFile().getConvertedControlValue());
        fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
        fco = (Linux_DnsSlaveZone) adapter.getFcoHelper().save(fco,container.getAdapter().getCimClient());
        
        masterHandler.save();

        super.saveForwardersIps(getForwarderList(), forwarder, fco);			
        forwarderList.setReloadFromServer(true);
        
        return null;
	}

	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		super.updateControls(container,fco);
	}

	public void updateControls(DnsSlaveZoneDataContainer container) throws WbemsmtException {
		super.setForwarderToContainer(container,fco.get_Forward());
        container.get_Forwarders().setValues(getForwarders(getForwarderList()));
        container.get_Name().setControlValue(fco.get_key_Name());
        container.get_ZoneFile().setControlValue(fco.get_ZoneFile());
        updateTTLDataContainer(adapter,fco.get_TTL(), container);
        masterHandler.updateIpAddressList(container);
		
	}

	public void updateModel(DnsSlaveZoneDataContainer container) throws WbemsmtException {

		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			fco.set_TTL(null);
			updateTTLDataContainer(adapter,fco.get_TTL(), container.get_TTL(),container.get_usr_TTLUnit());
		} 
		else
		{
			fco.set_Forward(super.getForwarder(container));
            updateForwarders(getForwarderList(),container,container.get_usr_UseGlobalForwarders());
            masterHandler.updateAddressModel(container);
		}

	}
	
	public void updateControls(DnsZoneTracingContainer container) throws WbemsmtException {

		container.get_Forward().setControlValue(fco.get_Forward());
        getForwarderList().removeIfNotExistsOnClient();
        container.get_Forwarders().setControlValue(getForwarderList().toString());
        container.get_Name().setControlValue(fco.get_key_Name());
        container.get_ResourceRecordFile().setControlValue(fco.get_ZoneFile());

        container.get_usr_MasterAddresses().setControlValue(getForwarderList().toString());
        updateTTLDataContainer(adapter,fco.get_TTL(), container.get_TTL(),container.get_TTLUnit());
        
        container.get_NegativeCaching_TTL().getProperties().setVisible(false);
        container.get_usr_NegativeCaching_TTLUnit().getProperties().setVisible(false);
        show(container.getAllowNotifyAcl(),true);
        show(container.getAllowTransferAcl(),true);
        show(container.getAllowQueryAcl(),true);
        show(container.getAllowUpdateAcl(),true);
        adapter.updateControls(container.getResourceRecords(),getResourceRecords().getFCOs());
	}
	
	public Linux_DnsZone getLinux_DnsZone() {
		return fco;
	}
	
	public MessageList save(DnsAllowNotifyForZoneDataContainer container) throws WbemsmtException { 
		return aclHandler.save(AclHandler.IDX_NOTIFY);
	}

	public void updateModel(DnsAllowNotifyForZoneDataContainer container) throws WbemsmtException {
		aclHandler.updateModel(container,container.get_usr_UseGlobalAddressMatchList(), AclHandler.IDX_NOTIFY);
	}
	
	public void updateControls(DnsAllowNotifyForZoneDataContainer container) throws WbemsmtException {
		aclHandler.updateControls(container,AclHandler.IDX_NOTIFY,null);
	}
	
	public void updateSerialNumber(DnsSoaContainer container) {
		//do nothing - a slave zone is having no SOA record
	}

	public MessageList revert(DnsSlaveZoneDataContainer container) throws WbemsmtException {
		fco = (Linux_DnsSlaveZone) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}

	public MessageList revert(DnsAllowNotifyForZoneDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_NOTIFY);
		return null;
	}
	
}
