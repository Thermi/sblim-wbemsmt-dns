 /** 
ReverseZone.java
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
  * Description: Wrapper for reverse zones
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

	public ForwarderList getForwarderList() throws WbemsmtException {
		if (forwarderList == null || forwarderList.isReloadFromServer() )
        {
        	forwarderList = new ForwarderList();
        	forwarder = (Linux_DnsForwarders) getFirstChild(Linux_DnsForwarders.class, fco.getMasterZone().getAssociated_Linux_DnsForwarders_Linux_DnsForwardersForZoneNames(adapter.getCimClient()), true, true, adapter.getCimClient(), adapter.getNamespace());
        	addForwarderIps(forwarder,forwarderList);
        }
        return forwarderList;
	}
	
	private void initHandler(final Linux_DnsReverseZoneWrapper fco, final DnsCimAdapter adapter) {
		aclHandler = new AclHandler(adapter, new AssociatedObjectsLoader()
		{
			public List<CIMObjectPath> load(int index) throws WbemsmtException {
				switch (index) {
                case AclHandler.IDX_NOTIFY:
                	return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowNotifyForZoneNames(adapter.getCimClient());
                case AclHandler.IDX_TRANSFER:
                	return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowTransferForZoneNames(adapter.getCimClient());
                case AclHandler.IDX_QUERY:
                	return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowQueryForZoneNames(adapter.getCimClient());
                case AclHandler.IDX_UPDATE:
                	return fco.getReversedZone().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowUpdateForZoneNames(adapter.getCimClient());
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
	 * @throws WbemsmtException thrown if the zoneFco is a type that is not supported. Supported are: master,slave,stub,hint,forward
	 */
	public ReverseZone(Linux_DnsMasterZone zoneFco, DnsCimAdapter adapter2) throws WbemsmtException {
		
		super(adapter2);
		Linux_DnsMasterZone zone = Linux_DnsMasterZoneHelper.getInstance(adapter2.getCimClient(),zoneFco.getCimObjectPath());
        this.reversedZone = new MasterZone(zone,adapter);
        this.fco = new Linux_DnsReverseZoneWrapper(zone);

        initHandler(fco, adapter);
	}

	
	public Linux_DnsAddressMatchList getAcl(int index) throws WbemsmtException {
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
	
	public ResourceRecordList getResourceRecords() throws WbemsmtException {
		return reversedZone.getResourceRecords();
	}

	public void setResourceRecords(ResourceRecordList resourceRecords) {
		this.reversedZone.setResourceRecords(resourceRecords);
	}

	public void loadChilds(WBEMClient cimClient) throws WbemsmtException {
		reversedZone.loadChilds(cimClient);
	}
	public String getName() {
		return reversedZone.getName();
	}

	private MessageList save(int idx) throws WbemsmtException {
		return aclHandler.save(idx);
	}

	public MessageList save(DnsAllowUpdateForZoneDataContainer container) throws WbemsmtException  {
		return save(AclHandler.IDX_UPDATE);
	}

	public MessageList save(DnsAllowTransferForZoneDataContainer container) throws WbemsmtException  {
		return save(AclHandler.IDX_TRANSFER);
	}					
	
	public MessageList save(DnsAllowQueryForZoneDataContainer container) throws WbemsmtException  {
		return save(AclHandler.IDX_QUERY);
	}

	public MessageList save(DnsReverseZoneDataContainer container) throws WbemsmtException {
		
		fco.set_Forward(super.getForwarder(container));
        fco.set_ZoneFile((String) container.get_ZoneFile().getConvertedControlValue());
        fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
        if (fco.isModified())
        {
        	fco.setMasterZone((Linux_DnsMasterZone) adapter.getFcoHelper().save(fco.getMasterZone() ,container.getAdapter().getCimClient()));
        }

        super.saveForwardersIps(getForwarderList(), forwarder, fco.getMasterZone());
        forwarderList.setReloadFromServer(true);
        
        return null;
	}

	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		reversedZone.updateControls(container,fco);
	}

	public void updateControls(DnsAllowQueryForZoneDataContainer container) throws WbemsmtException {
		updateControls(container,AclHandler.IDX_QUERY);
	}

	public void updateControls(DnsAllowTransferForZoneDataContainer container)  throws WbemsmtException{
		updateControls(container,AclHandler.IDX_TRANSFER);
	}

	public void updateControls(DnsAllowUpdateForZoneDataContainer container)  throws WbemsmtException{
		updateControls(container,AclHandler.IDX_UPDATE);
	}

	private void updateControls(DnsAddressMatchListDataContainer container, int idx)  throws WbemsmtException{
		aclHandler.updateControls(container,idx,null);
	}

	public void updateControls(DnsReverseZoneDataContainer container) throws WbemsmtException {

		container.get_Name().setControlValue(fco.get_key_Name());
		container.get_ZoneFile().setControlValue(fco.get_ZoneFile());

		super.setForwarderToContainer(container,fco.get_Forward());
        container.get_Forwarders().setValues(getForwarders(getForwarderList()));
		updateTTLDataContainer(adapter,fco.get_TTL(), container);
	}

	public void updateModel(DnsAllowUpdateForZoneDataContainer container)  throws WbemsmtException{
		updateModel(container,null,AclHandler.IDX_UPDATE);
	}

	public void updateModel(DnsAllowTransferForZoneDataContainer container)  throws WbemsmtException{
		updateModel(container,container.get_usr_UseGlobalAddressMatchList(),AclHandler.IDX_TRANSFER);
	}

	public void updateModel(DnsAllowQueryForZoneDataContainer container)  throws WbemsmtException{
		updateModel(container,container.get_usr_UseGlobalAddressMatchList(),AclHandler.IDX_QUERY);
	}

	private void updateModel(DnsAddressMatchListDataContainer container, LabeledBaseInputComponentIf useGlobal, int idx) throws WbemsmtException {
		aclHandler.updateModel(container,useGlobal,idx);
	}

	public void updateModel(DnsReverseZoneDataContainer container) throws WbemsmtException 
	{
		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			fco.set_TTL(null);
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
		return fco.getReversedZone();
	}

	public void delete(Linux_DnsReverseZoneWrapper fco)  throws WbemsmtException {
		super.delete(fco.getReversedZone());
	}
	
	public MessageList save(DnsSoaContainer container) throws WbemsmtException {
		return save(fco.getMasterZone(),container);
	}

	public void updateControls(DnsSoaContainer container) {
		updateControls(fco.getMasterZone(),container);
	}

	public void updateSerialNumber(DnsSoaContainer container) {
		super.setValues(fco.getMasterZone(), container, MessageList.init(container));
		super.updateSerialNumber(fco.getMasterZone(),container);
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

	public MessageList revert(DnsReverseZoneDataContainer container) throws WbemsmtException {
		fco.setMasterZone((Linux_DnsMasterZone) adapter.getFcoHelper().reload(fco.getMasterZone(), adapter.getCimClient()));
		return null;
	}

	public MessageList revert(DnsSoaContainer container) throws WbemsmtException {
		fco.setMasterZone((Linux_DnsMasterZone) adapter.getFcoHelper().reload(fco.getMasterZone(), adapter.getCimClient()));
		return null;
	}

}
