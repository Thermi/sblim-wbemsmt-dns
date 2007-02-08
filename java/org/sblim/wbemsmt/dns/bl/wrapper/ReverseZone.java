 /** 
ReverseZone.java
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
  * Description: Wrapper for reverse zones
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.List;
import java.util.Vector;

import org.sblim.wbem.cim.CIMDataType;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsReverseZoneWrapper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.resourcerecord.ResourceRecordHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AclHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AssociatedObjectsLoader;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectDeletionException;
import org.sblim.wbemsmt.exception.ObjectRevertException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;

public class ReverseZone extends SlaveZone implements Zone {

	private final Linux_DnsReverseZoneWrapper fco;
	private final Zone reversedZone;

	/**
	 * 
	 */
	public ReverseZone(final Linux_DnsReverseZoneWrapper fco, Zone reversedZone, final DnsCimAdapter adapter) {
		super(adapter);
		this.fco = fco;
		this.reversedZone = reversedZone;
		initHandler(fco, adapter);
	}

	public ForwarderList getForwarderList() throws ModelLoadException {
		if (forwarderList == null || forwarderList.isReloadFromServer() )
		{
			forwarderList = new ForwarderList();
			forwarder = (Linux_DnsForwarders) getFirstChild(adapter.getCimClient(), Linux_DnsForwarders.class, fco.getMasterZone().getAssociated_Linux_DnsForwarders_Linux_DnsForwardersForZone_Names(adapter.getCimClient(), false), true, true);
			addForwarderIps(forwarder,forwarderList);
		}
		return forwarderList;
	}
	
	private void initHandler(final Linux_DnsReverseZoneWrapper fco, final DnsCimAdapter adapter) {
		aclHandler = new AclHandler(adapter, new AssociatedObjectsLoader()
		{
			public List load(int index) {
				switch (index) {
				case AclHandler.IDX_NOTIFY:
					return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowNotifyForZone_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_TRANSFER:
					return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowTransferForZone_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_QUERY:
					return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowQueryForZone_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_UPDATE:
					return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowUpdateForZone_Names(adapter.getCimClient(),false);
				default:
					break;
				}
				return null;
			}
		}, fco.getMasterZone());
		
		resourceRecordHandler = new ResourceRecordHandler(adapter,this);
	}

	/**
	 * 
	 * @param zoneFco
	 * @param adapter2
	 * @throws ModelLoadException thrown if the zoneFco is a type that is not supported. Supported are: master,slave,stub,hint,forward
	 */
	public ReverseZone(Linux_DnsMasterZone zoneFco, DnsCimAdapter adapter2) throws ModelLoadException {
		
		super(adapter2);
		Vector keyProperties = new Vector();
		keyProperties.add(CIMPropertyBuilder.create(Linux_DnsZone.CIM_PROPERTY_NAME,zoneFco.get_Name(),CIMDataType.STRING));
		keyProperties.add(CIMPropertyBuilder.create(Linux_DnsZone.CIM_PROPERTY_INSTANCEID,zoneFco.get_InstanceID(),CIMDataType.STRING));

		Linux_DnsMasterZone zone = Linux_DnsMasterZoneHelper.getInstance(adapter.getCimClient(),keyProperties);
		this.reversedZone = new MasterZone(zone,adapter);
		this.fco = new Linux_DnsReverseZoneWrapper(zone);

		initHandler(fco, adapter);
	}

	
	public Linux_DnsAddressMatchList getAcl(int index) throws ModelLoadException {
		return aclHandler.getAcl(index);
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
	public Linux_DnsReverseZoneWrapper getReverseZone() {
		return fco;
	}
	
	public ResourceRecordList getResourceRecords() {
		return reversedZone.getResourceRecords();
	}

	public void setResourceRecords(ResourceRecordList resourceRecords) {
		this.reversedZone.setResourceRecords(resourceRecords);
	}

	public void loadChilds(CIMClient cimClient) throws ModelLoadException {
		reversedZone.loadChilds(cimClient);
	}
	public String getName() {
		return reversedZone.getName();
	}

	private MessageList save(int idx) throws ObjectSaveException {
		return aclHandler.save(idx);
	}

	public MessageList save(DnsAllowUpdateForZoneDataContainer container) throws ObjectSaveException  {
		return save(AclHandler.IDX_UPDATE);
	}

	public MessageList save(DnsAllowTransferForZoneDataContainer container) throws ObjectSaveException  {
		return save(AclHandler.IDX_TRANSFER);
	}					
	
	public MessageList save(DnsAllowQueryForZoneDataContainer container) throws ObjectSaveException  {
		return save(AclHandler.IDX_QUERY);
	}

	public MessageList save(DnsReverseZoneDataContainer container) throws ObjectSaveException {
		
		try {
			fco.set_Forward(super.getForwarder(container));
			fco.set_ZoneFile((String) container.get_ZoneFile().getConvertedControlValue());
			fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
			if (fco.isModified())
			{
				fco.setMasterZone((Linux_DnsMasterZone) FcoHelper.save(fco.getMasterZone() ,container.getAdapter().getCimClient()));
			}

			super.saveForwardersIps(getForwarderList(), forwarder, fco.getMasterZone());
			forwarderList.setReloadFromServer(true);
			
			return null;
		} catch (ModelLoadException e) {
			throw new ObjectSaveException(e);
		}
	}

	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws UpdateControlsException {
		reversedZone.updateControls(container,fco);
	}

	public void updateControls(DnsAllowQueryForZoneDataContainer container) throws UpdateControlsException {
		updateControls(container,AclHandler.IDX_QUERY);
	}

	public void updateControls(DnsAllowTransferForZoneDataContainer container)  throws UpdateControlsException{
		updateControls(container,AclHandler.IDX_TRANSFER);
	}

	public void updateControls(DnsAllowUpdateForZoneDataContainer container)  throws UpdateControlsException{
		updateControls(container,AclHandler.IDX_UPDATE);
	}

	private void updateControls(DnsAddressMatchListDataContainer container, int idx)  throws UpdateControlsException{
		aclHandler.updateControls(container,idx,null);
	}

	public void updateControls(DnsReverseZoneDataContainer container) throws UpdateControlsException {

		container.get_Name().setControlValue(fco.get_Name());
		container.get_ZoneFile().setControlValue(fco.get_ZoneFile());

		try {
			super.setForwarder(container,fco.get_Forward());
			container.get_Forwarders().setValues(getForwarders(getForwarderList()));
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
		updateTTLDataContainer(adapter,fco.get_TTL(), container);
	}

	public void updateModel(DnsAllowUpdateForZoneDataContainer container)  throws ModelUpdateException{
		updateModel(container,null,AclHandler.IDX_UPDATE);
	}

	public void updateModel(DnsAllowTransferForZoneDataContainer container)  throws ModelUpdateException{
		updateModel(container,container.get_usr_UseGlobalAddressMatchList(),AclHandler.IDX_TRANSFER);
	}

	public void updateModel(DnsAllowQueryForZoneDataContainer container)  throws ModelUpdateException{
		updateModel(container,container.get_usr_UseGlobalAddressMatchList(),AclHandler.IDX_QUERY);
	}

	private void updateModel(DnsAddressMatchListDataContainer container, LabeledBaseInputComponentIf useGlobal, int idx) throws ModelUpdateException {
		aclHandler.updateModel(container,useGlobal,idx);
	}

	public void updateModel(DnsReverseZoneDataContainer container) throws ModelUpdateException 
	{
		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			fco.set_TTL(null);
		} 
		else
		{
			try {
				fco.set_Forward(super.getForwarder(container));
				updateForwarders(getForwarderList(),container,container.get_usr_UseGlobalForwarders());
			} catch (ModelLoadException e) {
				throw new ModelUpdateException(e);
			}
		}
	}

	public void updateControls(DnsZoneTracingContainer container) throws UpdateControlsException {

		
		container.get_Contact().setControlValue(fco.get_Contact());
		container.get_Expire().setControlValue(fco.get_Expire());
		container.get_Forward().setControlValue(fco.get_Forward());
		try {
			getForwarderList().removeIfNotExistsOnClient();
			container.get_Forwarders().setControlValue(getForwarderList().toString());
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
		container.get_Name().setControlValue(fco.get_Name());
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
		return fco.getReversedZone();
	}

	public void delete(Linux_DnsReverseZoneWrapper fco)  throws ObjectDeletionException {
		super.delete(fco.getReversedZone());
	}
	
	public MessageList save(DnsSoaContainer container) throws ObjectSaveException {
		return save(fco.getMasterZone(),container);
	}

	public void updateControls(DnsSoaContainer container) {
		updateControls(fco.getMasterZone(),container);
	}

	public void updateSerialNumber(DnsSoaContainer container) {
		super.setValues(fco.getMasterZone(), container, MessageList.init(container));
		super.updateSerialNumber(fco.getMasterZone(),container);
	}

	public MessageList revert(DnsAllowQueryForZoneDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_QUERY);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsAllowTransferForZoneDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_TRANSFER);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsAllowUpdateForZoneDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_UPDATE);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsReverseZoneDataContainer container) throws ObjectRevertException {
		try {
			fco.setMasterZone((Linux_DnsMasterZone) FcoHelper.reload(fco.getMasterZone(), adapter.getCimClient()));
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsSoaContainer container) throws ObjectRevertException {
		try {
			fco.setMasterZone((Linux_DnsMasterZone) FcoHelper.reload(fco.getMasterZone(), adapter.getCimClient()));
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

}
