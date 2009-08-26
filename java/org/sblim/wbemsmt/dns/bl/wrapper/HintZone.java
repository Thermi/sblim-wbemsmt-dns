 /** 
  * HintZone.java
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
  * Description: wrapper for a hint zone
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsHintZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.resourcerecord.ResourceRecordHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class HintZone extends ForwardZone implements Zone {

	private Linux_DnsHintZone fco;

	/**
	 * 
	 */
	public HintZone(Linux_DnsHintZone fco, DnsCimAdapter adapter) {
		super(adapter);
		this.fco = fco;
		resourceRecordHandler = new ResourceRecordHandler(adapter,this);
	}
	
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(fco.getCimObjectPath());
	}

	public ResourceRecordList getResourceRecords() throws WbemsmtException {
		if (resourceRecords == null )
        {
        	adapter.addResourceRecords(this,fco.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(adapter.getCimClient()));
        }
        return resourceRecords;
	}

	/**
	 * Get the wrapped fco
	 * @return
	 */
	public Linux_DnsHintZone getHintZone() {
		return fco;
	}

	public void loadChilds(WBEMClient cimClient) {
	}
	
	public String getName() {
		return getHintZone().get_key_Name();
	}

	public MessageList save(DnsHintZoneDataContainer container) throws WbemsmtException {
		fco.set_ZoneFile((String) container.get_ZoneFile().getConvertedControlValue());
		fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
		fco = (Linux_DnsHintZone) adapter.getFcoHelper().save(fco,container.getAdapter().getCimClient());
		forwarderList = null;
		return null;
	}

	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		super.updateControls(container,fco);
	}

	public void updateControls(DnsHintZoneDataContainer container) {
		container.get_Name().setControlValue(fco.get_key_Name());
		container.get_ZoneFile().setControlValue(fco.get_ZoneFile());
		updateTTLDataContainer(adapter,fco.get_TTL(), container);
	}

	public void updateControls(DnsZoneTracingContainer container) throws WbemsmtException {
		container.get_Name().setControlValue(fco.get_key_Name());
        container.get_ResourceRecordFile().setControlValue(fco.get_ZoneFile());
        container.get_usr_MasterAddresses().getProperties().setVisible(false);
        updateTTLDataContainer(adapter,fco.get_TTL(), container.get_TTL(),container.get_TTLUnit());

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
		//do nothing - a HintZone has no SerialNumber
	}
	
	public void updateModel(DnsHintZoneDataContainer container) {
		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			fco.set_TTL(null);
			updateTTLDataContainer(adapter,fco.get_TTL(), container.get_TTL(),container.get_usr_TTLUnit());
		} 
	}

	public MessageList revert(DnsHintZoneDataContainer container) throws WbemsmtException {
		fco = (Linux_DnsHintZone) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}
	
}

