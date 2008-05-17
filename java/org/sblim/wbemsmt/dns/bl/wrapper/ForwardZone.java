 /** 
  * ForwardZone.java
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
  * Description: wrapper for a forwardzone
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.resourcerecord.ResourceRecordHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class ForwardZone extends DnsBusinessObject implements Zone {

	private Linux_DnsForwardZone fco;

	protected ResourceRecordList resourceRecords;
	
	/**
	 * Lists for the addresses
	 */

	protected  ForwarderList forwarderList;
	Linux_DnsForwarders forwarder = null;	
	/**
	 * 
	 */
	public ForwardZone(Linux_DnsForwardZone fco, DnsCimAdapter adapter) {
		this(adapter);
		this.fco = fco;
	}

	/**
	 * 
	 */
	public ForwardZone(DnsCimAdapter adapter) {
		super(adapter);
		resourceRecordHandler = new ResourceRecordHandler(adapter,this);
	}	
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(fco.getCimObjectPath());
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
	
	/**
	 * Get the wrapped fco
	 * @return
	 */
	public Linux_DnsForwardZone getForwardZone() {
		return fco;
	}
	
	public void loadChilds(WBEMClient cimClient) {
		forwarderList = null;
		
	}
	public String getName() {
		return getForwardZone().get_key_Name();
	}

	public MessageList save(DnsForwardZoneDataContainer container) throws WbemsmtException {
		
		fco.set_Forward(super.getForwarder(container));
        fco = (Linux_DnsForwardZone) adapter.getFcoHelper().save(fco,container.getAdapter().getCimClient());
        
        saveForwardersIps(getForwarderList(), forwarder, fco);
        forwarderList.setReloadFromServer(true);
        
        return null;
	}
	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		super.updateControls(container,fco);
	}

	public void updateControls(DnsForwardZoneDataContainer container) throws WbemsmtException {
		super.setForwarderToContainer(container,fco.get_Forward());
        container.get_Forwarders().setValues(getForwarders(getForwarderList()));
        container.get_Name().setControlValue(fco.get_key_Name());
	}

	public void updateModel(DnsForwardZoneDataContainer container) throws WbemsmtException {
			fco.set_Forward(super.getForwarder(container));
			updateForwarders(getForwarderList(),container,container.get_usr_UseGlobalForwarders());
	}

	public void updateControls(DnsZoneTracingContainer container) throws WbemsmtException {
	    container.get_Forward().setControlValue(fco.get_Forward());
        
        getForwarderList().removeIfNotExistsOnClient();
        container.get_Forwarders().setControlValue(getForwarderList().toString());
        container.get_Name().setControlValue(fco.get_key_Name());
        
        container.get_usr_MasterAddresses().getProperties().setVisible(false);
   
        container.get_TTL().getProperties().setVisible(false);
        container.get_NegativeCaching_TTL().getProperties().setVisible(false);
        container.get_usr_NegativeCaching_TTLUnit().getProperties().setVisible(false);
        show(container.getAllowNotifyAcl(),false);
        show(container.getAllowTransferAcl(),false);
        show(container.getAllowQueryAcl(),false);
        show(container.getAllowUpdateAcl(),false);
        adapter.updateControls(container.getResourceRecords(),getResourceRecords().getFCOs());
		
		
	}

	public Linux_DnsZone getLinux_DnsZone() {
		return fco;
	}

	public void updateSerialNumber(DnsSoaContainer container) {
		//do nothing - a ForwardZone has no SerialNumber
	}

	public MessageList revert(DnsForwardZoneDataContainer container) throws WbemsmtException {
		fco = (Linux_DnsForwardZone) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}

}
