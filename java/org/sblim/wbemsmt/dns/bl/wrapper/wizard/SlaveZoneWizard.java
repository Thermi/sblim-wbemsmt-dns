 /** 
  * SlaveZoneWizard.java
  *
  * (C) Copyright IBM Corp. 2005
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

import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
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
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public class SlaveZoneWizard extends DnsWizard {

	private DnsSlaveZoneWizardPage1DataContainer page1;

	private MastersHandler mastersHandler;
	
	private Linux_DnsSlaveZone fco = new Linux_DnsSlaveZone();

	private Linux_DnsMasters masters;
	
	/**
	 * @param adapter
	 */
	public SlaveZoneWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	public void init(DnsSlaveZoneWizardPage1DataContainer container)
	{
		masters = new Linux_DnsMasters();
		fco = new Linux_DnsSlaveZone();		
		mastersHandler = new MastersHandler(adapter,masters,false, fco);
	}
	
	public MasterItemList getMasters() throws ModelLoadException {
		return mastersHandler.getUsedItems();
	}
	
	public void updateControls(DnsSlaveZoneWizardPage1DataContainer container) throws UpdateControlsException {
		this.page1 = container;
		mastersHandler.updateIpAddressList(container);
	}

	public void updateControls(DnsSlaveZoneWizardSummaryDataContainer container) throws UpdateControlsException {
		container.get_usr_Name().setControlValue(page1.get_usr_Name().getConvertedControlValue());
		mastersHandler.updateIpAddressList(container);
	}

	public void updateModel(DnsSlaveZoneWizardPage1DataContainer container) throws ModelUpdateException {
		mastersHandler.updateAddressModel(container);
	}

	public void create(DnsSlaveZoneWizardSummaryDataContainer container) throws ObjectSaveException {
		fco = new Linux_DnsSlaveZone();
		fco.set_Name((String) page1.get_usr_Name().getConvertedControlValue());
		fco.set_Type(new UnsignedInt8((short)Linux_DnsZone.TYPE_SLAVE));
		fco.set_ZoneFile(page1.get_usr_Name().getConvertedControlValue() + ".hosts");
		fco.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
		
		
		fco = (Linux_DnsSlaveZone) FcoHelper.create(fco,adapter.getCimClient());

		masters.set_Name(NameFactory.createName(Linux_DnsMastersForZone.class,fco.get_Name()));
		masters.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);

		//object is created
		mastersHandler.setZone(fco);
		masters = mastersHandler.save();

		if (DnsCimAdapter.DUMMY_MODE)
		{
			try {
				super.createAclAssociations(fco,adapter.getDnsService().getFco());
			} catch (ModelLoadException e) {
				throw new ObjectSaveException(e);
			}
		}

		createForwarders(fco);
		
		adapter.setMarkedForReload();
		container.setKey(new CimObjectKey(fco));
		
		//cleaup
		try {
			mastersHandler.getPredefinedItems().setReloadFromServer(true);
			mastersHandler.getUsedItems().setReloadFromServer(true);
			fco = new Linux_DnsSlaveZone();
		} catch (ModelLoadException e) {
			throw new ObjectSaveException(e);
		}
		
	}

}
