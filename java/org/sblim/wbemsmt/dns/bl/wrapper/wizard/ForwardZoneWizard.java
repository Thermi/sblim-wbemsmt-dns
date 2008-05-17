 /** 
  * ForwardZoneWizard.java
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
  * Description: Wrapper for ForwardZoneWizard
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import javax.cim.UnsignedInteger8;

import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardersForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class ForwardZoneWizard extends DnsWizard {

	protected DnsForwardZoneWizardPage1DataContainer page1;
	private ForwarderList forwarderList;
	private UnsignedInteger8 forward;

	/**
	 * @param adapter
	 */
	public ForwardZoneWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	
	public ForwarderList getForwarderList() throws WbemsmtException {
		if (forwarderList == null || forwarderList.isReloadFromServer())
		{
			forwarderList = new ForwarderList();
		}
		return forwarderList;
	}	

	
	public void create(DnsForwardZoneWizardSummaryDataContainer container)throws WbemsmtException {
		
		try {
			Linux_DnsForwardZone zone = new Linux_DnsForwardZone(adapter.getCimClient(),adapter.getNamespace());
			zone.set_key_Name((String) page1.get_usr_Name().getConvertedControlValue());
			zone.set_Type(Linux_DnsZone.PROPERTY_TYPE.VALUE_MAP_ENTRY_4_FOR_VALUE_ENTRY_Forward);
			zone.set_Forward(forward);
			zone.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
			zone = (Linux_DnsForwardZone) adapter.getFcoHelper().create(zone,adapter.getCimClient());
			adapter.setMarkedForReload();
			adapter.setPathOfTreeNode(zone.getCimObjectPath());

			Linux_DnsForwarders forwardersFco = new Linux_DnsForwarders(adapter.getCimClient(),adapter.getNamespace());
			forwardersFco.set_key_Name(NameFactory.createName(Linux_DnsForwardersForZone.class, zone.get_key_Name()));
			forwardersFco.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
			//	save the forwarder
			forwardersFco = saveForwardersIps(getForwarderList(), forwardersFco, zone);
			
			forward = null;
			forwarderList.setReloadFromServer(true);
			
		} catch (Exception e) {
			throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,e);
		}
	}




	public void updateControls(DnsForwardZoneWizardPage1DataContainer container) throws WbemsmtException {
		this.page1 = container;
		super.setForwarderToContainer(container, forward);
		container.get_Forwarders().setValues(getForwarders(getForwarderList()));
	}

	public void updateControls(DnsForwardZoneWizardSummaryDataContainer container) throws WbemsmtException {
		forward = getForwarder(page1); 

		container.get_usr_Name().setControlValue(page1.get_usr_Name().getConvertedControlValue());
		super.setForwarderToContainer(container, forward);
		container.get_Forwarders().setValues(getForwarders(getForwarderList()));
		
		container.get_Forward().getProperties().setReadOnly(true);
		container.get_Forwarders().getProperties().setReadOnly(true);
		container.get_usr_Name().getProperties().setReadOnly(true);
		container.get_Forwarders().setShowAllInReadOnlyView(true);

	}

	public void updateModel(DnsForwardZoneWizardPage1DataContainer container) throws WbemsmtException {
		this.page1 = container;
		this.forward = getForwarder(container);
		
		if (adapter.getUpdateTrigger() == container.get_usr_AddForwarder() ||
			adapter.getUpdateTrigger() == container.get_usr_RemoveForwarder() ||
			adapter.getUpdateTrigger() == container.get_usr_UseGlobalForwarders()
		)
		{
			forward = super.getForwarder(container);
            updateForwarders(getForwarderList(),container,container.get_usr_UseGlobalForwarders());

		}
	}


	public void init(DnsForwardZoneWizardPage1DataContainer container) {
		container.get_usr_Name().setControlValue("");
		container.get_usr_NewForwarder().setControlValue("");
		container.get_Forward().setControlValue(null);
		container.get_Forwarders().setControlValue(null);
		container.get_Forwarders().setValues(new String[]{});
	}

}
