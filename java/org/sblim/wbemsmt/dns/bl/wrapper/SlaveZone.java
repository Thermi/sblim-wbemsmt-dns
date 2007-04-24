 /** 
  * SlaveZone.java
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
  * Description: wrapper for a Linux_DnsSlaveZone
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.List;

import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsSlaveZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.resourcerecord.ResourceRecordHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AclHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AssociatedObjectsLoader;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MasterItemList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.dns.bl.wrapper.masters.MastersHandler;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectRevertException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public class SlaveZone extends MasterZone implements Zone {

	private Linux_DnsSlaveZone fco;
	
	private MastersHandler masterHandler = null;
	/**
	 * @throws ModelLoadException 
	 * 
	 */
	public SlaveZone(final Linux_DnsSlaveZone fco,final DnsCimAdapter adapter) throws ModelLoadException {
		this(adapter);
		this.fco = fco;
		aclHandler = new AclHandler(adapter, new AssociatedObjectsLoader()
		{
			public List load(int index) {
				switch (index) {
				case AclHandler.IDX_NOTIFY:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowNotifyForZone_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_TRANSFER:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowTransferForZone_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_QUERY:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowQueryForZone_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_UPDATE:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowUpdateForZone_Names(adapter.getCimClient(),false);
				default:
					break;
				}
				return null;
			}
		}, fco);
		Linux_DnsMasters master = (Linux_DnsMasters) getFirstChild(Linux_DnsMasters.class, fco.getAssociated_Linux_DnsMasters_Linux_DnsMastersForZone_Names(adapter.getCimClient(), false), true, true, adapter.getCimClient());
		
		masterHandler = new MastersHandler(adapter,master,false, fco);
	}

	/**
	 * 
	 */
	public SlaveZone(DnsCimAdapter adapter) {
		super(adapter);
		resourceRecordHandler = new ResourceRecordHandler(adapter,this);
	}

	
	public ResourceRecordList getResourceRecords() {
		if (resourceRecords == null )
		{
			adapter.addResourceRecords(this,fco.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(adapter.getCimClient(),false,false,null));
		}
		return resourceRecords;
	}

	public ForwarderList getForwarderList() throws ModelLoadException {
		if (forwarderList == null || forwarderList.isReloadFromServer() )
		{
			forwarderList = new ForwarderList();
			forwarder = (Linux_DnsForwarders) getFirstChild(Linux_DnsForwarders.class, fco.getAssociated_Linux_DnsForwarders_Linux_DnsForwardersForZone_Names(adapter.getCimClient(), false), true, true, adapter.getCimClient());
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

	public MasterItemList getMasterList() throws ModelLoadException {
		return masterHandler.getUsedItems();
	}

	/**
	 * Get the wrapped fco
	 * @return
	 */
	public Linux_DnsSlaveZone getSlaveZone() {
		return fco;
	}

	public void loadChilds(CIMClient cimClient) throws ModelLoadException {
		aclHandler.resetAcls();
		forwarderList = null;
		masterHandler.getUsedItems().setReloadFromServer(true);
	}

	public String getName() {
		return getSlaveZone().get_Name();
	}

	public MessageList save(DnsSlaveZoneDataContainer container)throws ObjectSaveException {
		
		try {
			fco.set_Forward(super.getForwarder(container));
			fco.set_ZoneFile((String) container.get_ZoneFile().getConvertedControlValue());
			fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
			fco = (Linux_DnsSlaveZone) FcoHelper.save(fco,container.getAdapter().getCimClient());
			
			masterHandler.save();

			super.saveForwardersIps(getForwarderList(), forwarder, fco);			
			forwarderList.setReloadFromServer(true);
			
			return null;
		} catch (ModelLoadException e) {
			throw new ObjectSaveException(e);
		}
	}

	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws UpdateControlsException {
		super.updateControls(container,fco);
	}

	public void updateControls(DnsSlaveZoneDataContainer container) throws UpdateControlsException {
		try {
			super.setForwarder(container,fco.get_Forward());
			container.get_Forwarders().setValues(getForwarders(getForwarderList()));
			container.get_Name().setControlValue(fco.get_Name());
			container.get_ZoneFile().setControlValue(fco.get_ZoneFile());
			updateTTLDataContainer(adapter,fco.get_TTL(), container);
			masterHandler.updateIpAddressList(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
		
	}

	public void updateModel(DnsSlaveZoneDataContainer container) throws ModelUpdateException {

		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			fco.set_TTL(null);
			updateTTLDataContainer(adapter,fco.get_TTL(), container.get_TTL(),container.get_usr_TTLUnit());
		} 
		else
		{
			try {
				fco.set_Forward(super.getForwarder(container));
				updateForwarders(getForwarderList(),container,container.get_usr_UseGlobalForwarders());
				masterHandler.updateAddressModel(container);
			} catch (ModelLoadException e) {
				throw new ModelUpdateException(e);
			}
		}

	}
	
	public void updateControls(DnsZoneTracingContainer container) throws UpdateControlsException {

		try {
			container.get_Forward().setControlValue(fco.get_Forward());
			try {
				getForwarderList().removeIfNotExistsOnClient();
				container.get_Forwarders().setControlValue(getForwarderList().toString());
			} catch (ModelLoadException e) {
				throw new UpdateControlsException(e);
			}
			container.get_Name().setControlValue(fco.get_Name());
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
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}
	
	public Linux_DnsZone getLinux_DnsZone() {
		return fco;
	}
	
	public MessageList save(DnsAllowNotifyForZoneDataContainer container) throws ObjectSaveException { 
		return aclHandler.save(AclHandler.IDX_NOTIFY);
	}

	public void updateModel(DnsAllowNotifyForZoneDataContainer container) throws ModelUpdateException {
		aclHandler.updateModel(container,container.get_usr_UseGlobalAddressMatchList(), AclHandler.IDX_NOTIFY);
	}
	
	public void updateControls(DnsAllowNotifyForZoneDataContainer container) throws UpdateControlsException {
		aclHandler.updateControls(container,AclHandler.IDX_NOTIFY,null);
	}
	
	public void updateSerialNumber(DnsSoaContainer container) {
		//do nothing - a slave zone is having no SOA record
	}

	public MessageList revert(DnsSlaveZoneDataContainer container) throws ObjectRevertException {
		try {
			fco = (Linux_DnsSlaveZone) FcoHelper.reload(fco, adapter.getCimClient());
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsAllowNotifyForZoneDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_NOTIFY);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}
	
}
