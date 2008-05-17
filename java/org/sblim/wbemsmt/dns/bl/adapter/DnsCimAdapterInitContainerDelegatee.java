 /** 
  * DnsCimAdapterInitContainerDelegatee.java
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
  * Description: Delegatee for init container actions
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.welcome.WelcomeDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.*;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class DnsCimAdapterInitContainerDelegatee implements
		DnsCimAdapterInitContainerIf {

	private final DnsCimAdapter adapter;

	public DnsCimAdapterInitContainerDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer)
	 */
	public void initContainerImpl(DnsAddMasterAddressDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer)
	 */
	public void initContainerImpl(DnsAddressMatchListDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsAddressMatchListWizardPage1DataContainer container)
			throws WbemsmtException {
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsAddressMatchListWizardSummaryDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowNotifyForServiceDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowNotifyForZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowQueryForServiceDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public void initContainerImpl(DnsAllowQueryForZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowRecursionForServiceDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowTransferForServiceDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowUpdateForZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsBlackholeForServiceDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public void initContainerImpl(DnsConfigurationDataContainer container)
			throws WbemsmtException {
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public void initContainerImpl(DnsForwardZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer)
	 */
	public void initContainerImpl(DnsForwarderDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public void initContainerImpl(DnsHintZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public void initContainerImpl(DnsMasterZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsMasterZoneWizardPage1DataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsMasterZoneWizardSummaryDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public void initContainerImpl(DnsResourceRecordDataContainer container)
			throws WbemsmtException {
		container.get_Type().setValues(ResourceRecord.TYPES);
		container.get_Family().setValues(Linux_DnsResourceRecord.PROPERTY_FAMILY.VALUE_ENTRIES_FOR_DISPLAY);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordForReverseZoneWizardDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardPage1DataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardPage2TypeMxDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardPage2TypeOtherDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardSummaryDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public void initContainerImpl(DnsReverseZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsReverseZoneWizardPage1DataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsReverseZoneWizardSummaryDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public void initContainerImpl(DnsServiceOperationsDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer)
	 */
	public void initContainerImpl(DnsServiceTracingDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public void initContainerImpl(DnsSlaveZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(DnsSlaveZoneWizardPage1DataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsSlaveZoneWizardSummaryDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer)
	 */
	public void initContainerImpl(DnsTTLDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer)
	 */
	public void initContainerImpl(DnsZoneDataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer)
	 */
	public void initContainerImpl(DnsZoneTracingContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(DnsForwardZoneWizardPage1DataContainer container)
			throws WbemsmtException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(DnsForwardZoneWizardSummaryDataContainer container)
			throws WbemsmtException {
	}

	public void initContainerImpl(DnsResourceRecordListContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsResourceRecordListItemContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsSoaContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsMasterDataContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsMastersForServiceDataContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsMastersWizardPage1DataContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsMastersWizardSummaryDataContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsStubZoneDataContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsStubZoneWizardPage1DataContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsStubZoneWizardSummaryDataContainer container) throws WbemsmtException {
	}

	public void initContainerImpl(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		adapter.getDnsService().initContainer(container);
	}

	public void initContainerImpl(WelcomeDataContainer container) throws WbemsmtException {
	}

}
