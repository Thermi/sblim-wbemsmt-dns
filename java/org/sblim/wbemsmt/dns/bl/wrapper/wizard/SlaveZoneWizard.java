 /** 
  * SlaveZoneWizard.java
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
  * Description: wrapper for creatign Linux_DnsSlaveZone-Objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsSlaveZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MasterItemList;
import org.sblim.wbemsmt.dns.bl.wrapper.masters.MastersHandler;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class SlaveZoneWizard extends DnsWizard {

	private DnsSlaveZoneWizardPage1DataContainer page1;

	private MastersHandler mastersHandler;
	
	private Linux_DnsSlaveZone fco = null;

	private Linux_DnsMasters masters;
	
	/**
	 * @param adapter
	 */
	public SlaveZoneWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	public void init(DnsSlaveZoneWizardPage1DataContainer container) throws WbemsmtException
	{
		masters = new Linux_DnsMasters(adapter.getCimClient(),adapter.getNamespace());
        fco = new Linux_DnsSlaveZone(adapter.getCimClient(),adapter.getNamespace());		
        mastersHandler = new MastersHandler(adapter,masters,false, fco);
	}
	
	public MasterItemList getMasters() throws WbemsmtException {
		return mastersHandler.getUsedItems();
	}
	
	public void updateControls(DnsSlaveZoneWizardPage1DataContainer container) throws WbemsmtException {
		this.page1 = container;
		mastersHandler.updateIpAddressList(container);
	}

	public void updateControls(DnsSlaveZoneWizardSummaryDataContainer container) throws WbemsmtException {
		container.get_usr_Name().setControlValue(page1.get_usr_Name().getConvertedControlValue());
		container.get_usr_IpAdressses().setShowAllInReadOnlyView(true);
		mastersHandler.updateIpAddressList(container);
	}

	public void updateModel(DnsSlaveZoneWizardPage1DataContainer container) throws WbemsmtException {
		mastersHandler.updateAddressModel(container);
	}

	public void create(DnsSlaveZoneWizardSummaryDataContainer container) throws WbemsmtException {
		fco = new Linux_DnsSlaveZone(adapter.getCimClient(),adapter.getNamespace());
		fco.set_key_Name((String) page1.get_usr_Name().getConvertedControlValue());
		fco.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
		fco.set_Type(Linux_DnsZone.PROPERTY_TYPE.VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_Slave);
		fco.set_ZoneFile(page1.get_usr_Name().getConvertedControlValue() + ".hosts");
		
		
		fco = (Linux_DnsSlaveZone) adapter.getFcoHelper().create(fco,adapter.getCimClient());

		masters.set_key_Name(NameFactory.createName(Linux_DnsMastersForZone.class,fco.get_key_Name()));
		masters.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);

		//object is created
		mastersHandler.setZone(fco);
		masters = mastersHandler.save();

		if (DnsCimAdapter.DUMMY_MODE)
		{
			super.createAclAssociations(fco,adapter.getDnsService().getFco());
		}

		createForwarders(fco);
		
		adapter.setMarkedForReload();
		adapter.setPathOfTreeNode(fco.getCimObjectPath());

		
		mastersHandler.getPredefinedItems().setReloadFromServer(true);
        mastersHandler.getUsedItems().setReloadFromServer(true);
        fco = new Linux_DnsSlaveZone(adapter.getCimClient(),adapter.getNamespace());
		
	}

}
