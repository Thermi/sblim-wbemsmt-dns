 /** 
  * DnsCimAdapterInitContainerDelegatee.java
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
  * Description: Delegatee for init container actions
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.wizard.*;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.exception.InitContainerException;
import org.sblim.wbemsmt.exception.ModelLoadException;

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
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer)
	 */
	public void initContainerImpl(DnsAddressMatchListDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsAddressMatchListWizardPage1DataContainer container)
			throws InitContainerException {
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsAddressMatchListWizardSummaryDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowNotifyForServiceDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowNotifyForZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowQueryForServiceDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public void initContainerImpl(DnsAllowQueryForZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowRecursionForServiceDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowTransferForServiceDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public void initContainerImpl(
			DnsAllowUpdateForZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public void initContainerImpl(
			DnsBlackholeForServiceDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public void initContainerImpl(DnsConfigurationDataContainer container)
			throws InitContainerException {
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public void initContainerImpl(DnsForwardZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer)
	 */
	public void initContainerImpl(DnsForwarderDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public void initContainerImpl(DnsHintZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public void initContainerImpl(DnsMasterZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsMasterZoneWizardPage1DataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsMasterZoneWizardSummaryDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public void initContainerImpl(DnsResourceRecordDataContainer container)
			throws InitContainerException {
		container.get_Family().setValues(Linux_DnsResourceRecord.CIM_VALUEMAP_FAMILY);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordForReverseZoneWizardDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardPage1DataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardPage2TypeMxDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardPage2TypeOtherDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsResourceRecordWizardSummaryDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public void initContainerImpl(DnsReverseZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(
			DnsReverseZoneWizardPage1DataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsReverseZoneWizardSummaryDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public void initContainerImpl(DnsServiceOperationsDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer)
	 */
	public void initContainerImpl(DnsServiceTracingDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public void initContainerImpl(DnsSlaveZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(DnsSlaveZoneWizardPage1DataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(
			DnsSlaveZoneWizardSummaryDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer)
	 */
	public void initContainerImpl(DnsTTLDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer)
	 */
	public void initContainerImpl(DnsZoneDataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer)
	 */
	public void initContainerImpl(DnsZoneTracingContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardPage1DataContainer)
	 */
	public void initContainerImpl(DnsForwardZoneWizardPage1DataContainer container)
			throws InitContainerException {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInitContainerIf#initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardSummaryDataContainer)
	 */
	public void initContainerImpl(DnsForwardZoneWizardSummaryDataContainer container)
			throws InitContainerException {
	}

	public void initContainerImpl(DnsResourceRecordListContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsResourceRecordListItemContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsSoaContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsMasterDataContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsMastersForServiceDataContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsMastersWizardPage1DataContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsMastersWizardSummaryDataContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsStubZoneDataContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsStubZoneWizardPage1DataContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsStubZoneWizardSummaryDataContainer container) throws InitContainerException {
	}

	public void initContainerImpl(DnsForwardersForServiceDataContainer container) throws InitContainerException {
		try {
			adapter.getDnsService().initContainer(container);
		} catch (ModelLoadException e) {
			throw new InitContainerException(e);
		}
	}

}
