 /** 
  * DnsCimAdapterCreateDelegatee.java
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
  * Description: Delegatte for create actions
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer;

import org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.exception.ObjectSaveException;

public class DnsCimAdapterCreateDelegatee implements DnsCimAdapterCreateIf {

	private final DnsCimAdapter adapter;

	public DnsCimAdapterCreateDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterCreateIf#createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
	 */
	public void createImpl(
			DnsAddressMatchListWizardSummaryDataContainer container)
			throws ObjectSaveException {
		
		adapter.getAddressMatchListWizard().create(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterCreateIf#createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer)
	 */
	public void createImpl(DnsMasterZoneWizardSummaryDataContainer container)
			throws ObjectSaveException {
		adapter.getMasterZoneWizard().create(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterCreateIf#createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer)
	 */
	public void createImpl(DnsResourceRecordWizardSummaryDataContainer container)
			throws ObjectSaveException {
		adapter.getResourceRecordWizard().create(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterCreateIf#createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardSummaryDataContainer)
	 */
	public void createImpl(DnsForwardZoneWizardSummaryDataContainer container)
			throws ObjectSaveException {
		adapter.getForwardZoneWizard().create(container);
	}

	public void createImpl(DnsSlaveZoneWizardSummaryDataContainer container) throws ObjectSaveException {
		adapter.getSlaveZoneWizard().create(container);
	}

	public void createImpl(DnsReverseZoneWizardSummaryDataContainer container) throws ObjectSaveException {
		adapter.getReverseZoneWizard().create(container);
		
	}

	public void createImpl(DnsMastersWizardSummaryDataContainer container) throws ObjectSaveException {
		adapter.getMastersWizard().create(container);
	}

	public void createImpl(DnsStubZoneWizardSummaryDataContainer container) throws ObjectSaveException {
		adapter.getStubZoneWizard().create(container);
		
	}

}
