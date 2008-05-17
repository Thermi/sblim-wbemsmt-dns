 /** 
  * MasterZoneWizard.java
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
  * Description: wrapper for creatinh masterzones
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.wizard;


import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class MasterZoneWizard extends DnsWizard {

	private DnsMasterZoneWizardPage1DataContainer page1;

	/**
	 * @param adapter
	 */
	public MasterZoneWizard(DnsCimAdapter adapter) {
		super(adapter);
	}


	public void updateControls(DnsMasterZoneWizardPage1DataContainer container) {
		page1 = container;
	}

	public void updateControls(DnsMasterZoneWizardSummaryDataContainer container) {
		container.get_usr_IpAdress().setControlValue(page1.get_usr_IpAdress().getConvertedControlValue());
		container.get_usr_Name().setControlValue(page1.get_usr_Name().getConvertedControlValue());
		container.get_usr_Server().setControlValue(page1.get_usr_Server().getConvertedControlValue());
		container.get_usr_Contact().setControlValue(page1.get_usr_Contact().getConvertedControlValue());
	}

	public void updateModel(DnsMasterZoneWizardPage1DataContainer container) {
		page1 = container;
		MessageList messageList = MessageList.init(container);
		container.get_usr_Contact().setControlValue(super.checkContact(container.get_usr_Contact(), messageList));
	}

	public void create(DnsMasterZoneWizardSummaryDataContainer container) throws WbemsmtException {
		
		
		Linux_DnsMasterZone zone;
        zone = new Linux_DnsMasterZone(adapter.getCimClient(),adapter.getNamespace());
		zone.set_key_Name((String) page1.get_usr_Name().getConvertedControlValue());
        zone.set_Type(Linux_DnsZone.PROPERTY_TYPE.VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Master);
		zone.set_ZoneFile(page1.get_usr_Name().getConvertedControlValue() + ".hosts");
		zone.set_Contact((String) page1.get_usr_Contact().getConvertedControlValue());
		zone.set_Server((String) page1.get_usr_Server().getConvertedControlValue());
		zone.set_SerialNumber(getInitialSerialNumber());
		zone.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
		
		zone = (Linux_DnsMasterZone) adapter.getFcoHelper().create(zone,adapter.getCimClient());
		
		createResourceRecord(zone, 
				page1.get_usr_Name().getConvertedControlValue() + ".",
				ResourceRecord.TYPE_NS,
				Linux_DnsResourceRecord.PROPERTY_FAMILY.VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Internet,
				(String) page1.get_usr_Server().getConvertedControlValue());

		createResourceRecord(zone, 
				(String) page1.get_usr_Server().getConvertedControlValue(),
				ResourceRecord.TYPE_A,
				Linux_DnsResourceRecord.PROPERTY_FAMILY.VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Internet,
				(String) page1.get_usr_IpAdress().getConvertedControlValue());

		createForwarders(zone);
		
		if (DnsCimAdapter.DUMMY_MODE)
		{
			super.createAclAssociations(zone,adapter.getDnsService().getFco());
		}
		
		adapter.setPathOfTreeNode(zone.getCimObjectPath());
		adapter.setMarkedForReload();
	
	}


	public void init(DnsMasterZoneWizardPage1DataContainer container) {
		container.get_usr_Contact().setControlValue("");
		container.get_usr_Server().setControlValue("");
		container.get_usr_IpAdress().setControlValue("");
		container.get_usr_Name().setControlValue("");
	}


}
