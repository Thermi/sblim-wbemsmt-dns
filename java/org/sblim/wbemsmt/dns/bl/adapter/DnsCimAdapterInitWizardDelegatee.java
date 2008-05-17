 /** 
  * DnsCimAdapterInitWizardDelegatee.java
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
  * Description: Delegatee for initializing Wizards
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.container.wizard.*;
import org.sblim.wbemsmt.dns.wizard.*;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class DnsCimAdapterInitWizardDelegatee implements DnsCimAdapterInitWizardIf {

	private final DnsCimAdapter adapter;

	public DnsCimAdapterInitWizardDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	public void initWizardImpl(DnsAddressMatchListWizardPage1DataContainer container, AddressMatchListWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getAddressMatchListWizard());
		adapter.getAddressMatchListWizard().init(container);
		adapter.clearSelectedZones();
	}

	public void initWizardImpl(DnsResourceRecordWizardPage1DataContainer container, CreateResourceRecordWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getResourceRecordWizard());
		adapter.getResourceRecordWizard().init(container,wizardContainer);
	}

	public void initWizardImpl(DnsForwardZoneWizardPage1DataContainer container, CreateForwardZoneWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getForwardZoneWizard());
		adapter.getForwardZoneWizard().init(container);
		adapter.clearSelectedZones();
	}

	public void initWizardImpl(DnsMasterZoneWizardPage1DataContainer container, CreateMasterZoneWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getMasterZoneWizard());
		adapter.getMasterZoneWizard().init(container);
		adapter.clearSelectedZones();
	}

	public void initWizardImpl(DnsReverseZoneWizardPage1DataContainer container, CreateReverseZoneWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getReverseZoneWizard());
        adapter.getReverseZoneWizard().init();
	}

	public void initWizardImpl(DnsSlaveZoneWizardPage1DataContainer container, CreateSlaveZoneWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getSlaveZoneWizard());
		adapter.getSlaveZoneWizard().init(container);
		adapter.clearSelectedZones();
	}

	public void initWizardImpl(DnsMastersWizardPage1DataContainer container, MasterWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getMastersWizard());
        adapter.getMastersWizard().init(container);
        adapter.clearSelectedZones();
	}

	public void initWizardImpl(DnsStubZoneWizardPage1DataContainer container, CreateStubZoneWizardContainer wizardContainer, String currentPagename) throws WbemsmtException {
		adapter.setActiveWizard(adapter.getStubZoneWizard());
		adapter.getStubZoneWizard().init(container);
		adapter.clearSelectedZones();
	}

}
