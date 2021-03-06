 /** 
  * AddressMatchListWizard.java
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
  * Description: wrapper for creating addressMatchLists with a wizard
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import java.util.ArrayList;
import java.util.List;

import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchListsForService;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AclHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AssociatedObjectsLoader;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class AddressMatchListWizard extends DnsWizard {

	private DnsAddressMatchListWizardPage1DataContainer page1;

	private AclHandler aclHandler;
	
	private Linux_DnsAddressMatchList matchList = null;
	
	
	/**
	 * @param adapter
	 * @throws WbemsmtException 
	 */
	public AddressMatchListWizard(DnsCimAdapter adapter) throws WbemsmtException {
		super(adapter);
		
		matchList = new Linux_DnsAddressMatchList(adapter.getCimClient(),adapter.getNamespace());
		
		aclHandler = new AclHandler(adapter,new AssociatedObjectsLoader()
		{

			public List<?> load(int index) {
				List<Linux_DnsAddressMatchList> result = new ArrayList<Linux_DnsAddressMatchList>();
				result.add(matchList);
				return result;
			}
			
		}, null);
	}

	public void create(DnsAddressMatchListWizardSummaryDataContainer container) throws WbemsmtException
	{
		matchList = aclHandler.create(AclHandler.IDX_USER ,NameFactory.createName(Linux_DnsAddressMatchListsForService.class,(String) page1.get_Name().getConvertedControlValue()));
		adapter.setMarkedForReload();
		//force a reload
        aclHandler.resetAcl(AclHandler.IDX_USER);
        adapter.setPathOfTreeNode(aclHandler.getAcl(AclHandler.IDX_USER).getCimObjectPath());
        matchList = new Linux_DnsAddressMatchList(adapter.getCimClient(),adapter.getNamespace());
	}

	public void updateControls(DnsAddressMatchListWizardPage1DataContainer container) throws WbemsmtException {
		this.page1 = container;
		aclHandler.updateControls(page1,AclHandler.IDX_USER,null);
	}

	public void updateControls(DnsAddressMatchListWizardSummaryDataContainer container) throws WbemsmtException {
		container.get_Name().setControlValue(page1.get_Name().getConvertedControlValue());
        container.get_AddressList().setValues(aclHandler.getUsedAddressesAsArray(AclHandler.IDX_USER));
        container.get_AddressList().setShowAllInReadOnlyView(true);
	}

	public void updateModel(DnsAddressMatchListWizardPage1DataContainer container) throws WbemsmtException {
		if (adapter.getUpdateTrigger() == container.get_usr_AddNewAddress() || 
			adapter.getUpdateTrigger() == container.get_usr_AddPredefinedAddress() || 
			adapter.getUpdateTrigger() == container.get_usr_RemoveAddress())
		{
			aclHandler.updateModel(container,null,AclHandler.IDX_USER);
		}
	}

	public void init(DnsAddressMatchListWizardPage1DataContainer container) throws WbemsmtException {
		aclHandler.resetAcls();
        matchList = new Linux_DnsAddressMatchList(adapter.getCimClient(),adapter.getNamespace());
	}

}
