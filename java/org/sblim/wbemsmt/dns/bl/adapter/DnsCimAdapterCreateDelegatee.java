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

import org.sblim.wbemsmt.dns.bl.container.wizard.*;
import org.sblim.wbemsmt.exception.WbemsmtException;

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
			throws WbemsmtException {
		
		adapter.getAddressMatchListWizard().create(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterCreateIf#createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer)
	 */
	public void createImpl(DnsMasterZoneWizardSummaryDataContainer container)
			throws WbemsmtException {
		adapter.getMasterZoneWizard().create(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterCreateIf#createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer)
	 */
	public void createImpl(DnsResourceRecordWizardSummaryDataContainer container)
			throws WbemsmtException {
		adapter.getResourceRecordWizard().create(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterCreateIf#createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardSummaryDataContainer)
	 */
	public void createImpl(DnsForwardZoneWizardSummaryDataContainer container)
			throws WbemsmtException {
		adapter.getForwardZoneWizard().create(container);
	}

	public void createImpl(DnsSlaveZoneWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getSlaveZoneWizard().create(container);
	}

	public void createImpl(DnsReverseZoneWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getReverseZoneWizard().create(container);
		
	}

	public void createImpl(DnsMastersWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getMastersWizard().create(container);
	}

	public void createImpl(DnsStubZoneWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getStubZoneWizard().create(container);
		
	}

}
