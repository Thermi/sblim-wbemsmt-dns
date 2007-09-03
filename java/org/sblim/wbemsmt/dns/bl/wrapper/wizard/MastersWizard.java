 /** 
  * MastersWizard.java
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
  * Description: wrapper for creatign Linux_DnsMasters-Objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import java.util.Vector;

import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForService;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MasterItemList;
import org.sblim.wbemsmt.dns.bl.wrapper.masters.MastersHandler;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public class MastersWizard extends DnsWizard {

	private DnsMastersWizardPage1DataContainer page1;

	private MastersHandler mastersHandler;
	
	private Linux_DnsMasters masters;
	
	/**
	 * @param adapter
	 */
	public MastersWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	public void init(DnsMastersWizardPage1DataContainer container)
	{
		masters = new Linux_DnsMasters();
		mastersHandler = new MastersHandler(adapter,masters,true, null);
	}
	
	public MasterItemList getMasters() throws ModelLoadException {
		return mastersHandler.getUsedItems();
	}
	
	public void updateControls(DnsMastersWizardPage1DataContainer container) throws UpdateControlsException {
		this.page1 = container;
		mastersHandler.updateIpAddressList(container);
	}

	public void updateControls(DnsMastersWizardSummaryDataContainer container) throws UpdateControlsException {
		container.get_Name().setControlValue(page1.get_Name().getConvertedControlValue());
		container.get_AddressList().setShowAllInReadOnlyView(true);
		mastersHandler.updateIpAddressList(container);
	}

	public void updateModel(DnsMastersWizardPage1DataContainer container) throws ModelUpdateException {
		mastersHandler.updateAddressModel(container);
	}

	public void create(DnsMastersWizardSummaryDataContainer container) throws ObjectSaveException {
		try {
			masters = new Linux_DnsMasters();
			//save is not done if the object is new - values are just set
			masters = mastersHandler.save();
			masters.set_Name(NameFactory.createName(Linux_DnsMastersForService.class,(String) page1.get_Name().getConvertedControlValue()));
			masters.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
	
			//do the create
			masters = (Linux_DnsMasters) adapter.getFcoHelper().create(masters,adapter.getCimClient());
			
			if (DnsCimAdapter.DUMMY_MODE)
			{
				Vector keys = new Vector();
				keys.add(CIMPropertyBuilder.create(Linux_DnsMastersForService.CIM_PROPERTY_LINUX_DNSSERVICE, adapter.getDnsService().getFco()));
				keys.add(CIMPropertyBuilder.create(Linux_DnsMastersForService.CIM_PROPERTY_LINUX_DNSMASTERS, masters));
				adapter.getFcoHelper().create(Linux_DnsMastersForService.class, adapter.getCimClient(), keys);
			}
	
			adapter.setMarkedForReload();
			adapter.setPathOfTreeNode(masters.getCimObjectPath());
			
			//cleaup
			mastersHandler.getPredefinedItems().setReloadFromServer(true);
			mastersHandler.getUsedItems().setReloadFromServer(true);
			masters = new Linux_DnsMasters();
		} catch (ModelLoadException e) {
			throw new ObjectSaveException(e);
		}
		
	}

}
