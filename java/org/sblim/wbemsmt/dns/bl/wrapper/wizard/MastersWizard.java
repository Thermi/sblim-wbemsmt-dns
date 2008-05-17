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

import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForService;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MasterItemList;
import org.sblim.wbemsmt.dns.bl.wrapper.masters.MastersHandler;
import org.sblim.wbemsmt.exception.WbemsmtException;

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

	public void init(DnsMastersWizardPage1DataContainer container) throws WbemsmtException
	{
		masters = new Linux_DnsMasters(adapter.getCimClient(), adapter.getNamespace());
        mastersHandler = new MastersHandler(adapter,masters,true, null);
	}
	
	public MasterItemList getMasters() throws WbemsmtException {
		return mastersHandler.getUsedItems();
	}
	
	public void updateControls(DnsMastersWizardPage1DataContainer container) throws WbemsmtException {
		this.page1 = container;
		mastersHandler.updateIpAddressList(container);
	}

	public void updateControls(DnsMastersWizardSummaryDataContainer container) throws WbemsmtException {
		container.get_Name().setControlValue(page1.get_Name().getConvertedControlValue());
		container.get_AddressList().setShowAllInReadOnlyView(true);
		mastersHandler.updateIpAddressList(container);
	}

	public void updateModel(DnsMastersWizardPage1DataContainer container) throws WbemsmtException {
		mastersHandler.updateAddressModel(container);
	}

	public void create(DnsMastersWizardSummaryDataContainer container) throws WbemsmtException {
		try {
			masters = new Linux_DnsMasters(adapter.getCimClient(),adapter.getNamespace());
			//save is not done if the object is new - values are just set
			masters = mastersHandler.save();
			masters.set_key_Name(NameFactory.createName(Linux_DnsMastersForService.class,(String) page1.get_Name().getConvertedControlValue()));
			masters.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
	
			//do the create
			masters = (Linux_DnsMasters) adapter.getFcoHelper().create(masters,adapter.getCimClient());
			
			if (DnsCimAdapter.DUMMY_MODE)
			{
                Linux_DnsMastersForService assoc = new Linux_DnsMastersForService(adapter.getCimClient(),adapter.getNamespace());
                assoc.set_GroupComponent_Linux_DnsService(adapter.getDnsService().getFco());
                assoc.set_PartComponent_Linux_DnsMasters(masters);
                adapter.getFcoHelper().create(assoc, adapter.getCimClient());                               			}
	
			adapter.setMarkedForReload();
			adapter.setPathOfTreeNode(masters.getCimObjectPath());
			
			//cleaup
			mastersHandler.getPredefinedItems().setReloadFromServer(true);
			mastersHandler.getUsedItems().setReloadFromServer(true);
			masters = new Linux_DnsMasters(adapter.getCimClient(),adapter.getNamespace());
		} catch (Exception e) {
			throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,e);
		}
		
	}

}
