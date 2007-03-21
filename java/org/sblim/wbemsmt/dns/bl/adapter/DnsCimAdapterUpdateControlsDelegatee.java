 /** 
  * DnsCimAdapterUpdateControlsDelegatee.java
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
  * Description: Delegatee for Updating controls
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.fielddata.LinkData;
import org.sblim.wbemsmt.bl.fielddata.MemoData;
import org.sblim.wbemsmt.bl.fielddata.PictureData;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer;
import org.sblim.wbemsmt.dns.bl.container.welcome.WelcomeDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.listener.CreateAddressMatchListListener;
import org.sblim.wbemsmt.dns.listener.CreateForwardZoneListener;
import org.sblim.wbemsmt.dns.listener.CreateMasterZoneListener;
import org.sblim.wbemsmt.dns.listener.CreateMastersListener;
import org.sblim.wbemsmt.dns.listener.CreateSlaveZoneListener;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public class DnsCimAdapterUpdateControlsDelegatee implements
		DnsCimAdapterUpdateControlsIf {


	private final DnsCimAdapter adapter;

	public DnsCimAdapterUpdateControlsDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer)
	 */
	public void updateControlsImpl(DnsAddressMatchListDataContainer container)
			throws UpdateControlsException {
		// do nothing is a base object

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws UpdateControlsException {

		adapter.getSelectedAddressMatchList().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsAddressMatchListWizardPage1DataContainer container)
			throws UpdateControlsException {

		adapter.getAddressMatchListWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(
			DnsAddressMatchListWizardSummaryDataContainer container)
			throws UpdateControlsException {
		adapter.getAddressMatchListWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowNotifyForServiceDataContainer container)
			throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowNotifyForZoneDataContainer container)
			throws UpdateControlsException {
		if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateControls(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateControls(container);
		}
		else {
			throw new  UpdateControlsException("Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowQueryForServiceDataContainer container)
			throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowQueryForZoneDataContainer container)
			throws UpdateControlsException {
		if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateControls(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateControls(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateControls(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateControls(container);
		}
		else {
			throw new  UpdateControlsException("Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowRecursionForServiceDataContainer container)
			throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowTransferForServiceDataContainer container)
			throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws UpdateControlsException {
		if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateControls(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateControls(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateControls(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateControls(container);
		}
		else
		{
			throw new  UpdateControlsException("Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowUpdateForZoneDataContainer container)
			throws UpdateControlsException {
		if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateControls(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateControls(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateControls(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateControls(container);
		}
		else {
			throw new  UpdateControlsException("Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsBlackholeForServiceDataContainer container)
			throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public void updateControlsImpl(DnsConfigurationDataContainer container)
			throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public void updateControlsImpl(DnsForwardZoneDataContainer container)
			throws UpdateControlsException {
		adapter.getSelectedForwardZone().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public void updateControlsImpl(DnsHintZoneDataContainer container)
			throws UpdateControlsException {
		adapter.getSelectedHintZone().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public void updateControlsImpl(DnsMasterZoneDataContainer container)
			throws UpdateControlsException {
		adapter.getSelectedMasterZone().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsMasterZoneWizardPage1DataContainer container)
			throws UpdateControlsException {
		adapter.getMasterZoneWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(
			DnsMasterZoneWizardSummaryDataContainer container)
			throws UpdateControlsException {
		adapter.getMasterZoneWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public void updateControlsImpl(DnsResourceRecordDataContainer container)
			throws UpdateControlsException {
		adapter.getSelectedResourceRecord().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsResourceRecordWizardPage1DataContainer container)
			throws UpdateControlsException {
		adapter.getResourceRecordWizard().updateControls(container);

	}

	public void updateControlsImpl(DnsResourceRecordWizardPage2TypeMxDataContainer container) throws UpdateControlsException {
		adapter.getResourceRecordWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordWizardPage2TypeOtherDataContainer container) throws UpdateControlsException {
		adapter.getResourceRecordWizard().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(
			DnsResourceRecordWizardSummaryDataContainer container)
			throws UpdateControlsException {
		adapter.getResourceRecordWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public void updateControlsImpl(DnsReverseZoneDataContainer container)
			throws UpdateControlsException {
		adapter.getSelectedReverseZone().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsReverseZoneWizardPage1DataContainer container)
			throws UpdateControlsException {
		adapter.getReverseZoneWizard().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public void updateControlsImpl(DnsServiceOperationsDataContainer container)
			throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public void updateControlsImpl(DnsSlaveZoneDataContainer container)
			throws UpdateControlsException {
		adapter.getSelectedSlaveZone().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer)
	 */
	public void updateControlsImpl(DnsZoneDataContainer container)
			throws UpdateControlsException {
		//do nothing - is a base object
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardPage1DataContainer)
	 */
	public void updateControlsImpl(DnsForwardZoneWizardPage1DataContainer container)
			throws UpdateControlsException {
		adapter.getForwardZoneWizard().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(DnsForwardZoneWizardSummaryDataContainer container)
			throws UpdateControlsException {
		adapter.getForwardZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsServiceTracingDataContainer container) throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	public void updateControlsImpl(DnsSlaveZoneWizardPage1DataContainer container) throws UpdateControlsException {
		adapter.getSlaveZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsSlaveZoneWizardSummaryDataContainer container) throws UpdateControlsException {
		adapter.getSlaveZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsZoneTracingContainer container) throws UpdateControlsException {
		adapter.getSelectedZone().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws UpdateControlsException {
		adapter.getSelectedZone().updateControls(container,fco);
	}

	public void updateControlsImpl(DnsForwarderDataContainer container) throws UpdateControlsException {
		//do nothing - is a base object
	}

	public void updateControlsImpl(DnsTTLDataContainer container) throws UpdateControlsException {
		//do nothing - is a base object
		
	}

	public void updateControlsImpl(DnsAddMasterAddressDataContainer container) throws UpdateControlsException {
		//do nothing - is a base object
	}

	public void updateControlsImpl(DnsReverseZoneWizardSummaryDataContainer container) throws UpdateControlsException {
		adapter.getReverseZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordForReverseZoneWizardDataContainer container) throws UpdateControlsException {
	}

	public void updateControlsImpl(DnsResourceRecordForReverseZoneWizardDataContainer container, Linux_DnsResourceRecord fco) throws UpdateControlsException {
		adapter.getReverseZoneWizard().updateControls(container,fco);
	}

	public void updateControlsImpl(DnsResourceRecordListContainer container) throws UpdateControlsException {
		adapter.getSelectedZone().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordListItemContainer container) throws UpdateControlsException {
		adapter.getSelectedZone().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws UpdateControlsException {
		adapter.getSelectedZone().updateControls(container,fco);
	}

	public void updateControlsImpl(DnsSoaContainer container) throws UpdateControlsException {
		if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateControls(container);
		}
		else if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateControls(container);
		}
		
		else throw new UpdateControlsException("Selected zone is no masterZone or ReverseZone");
	}

	public void updateControlsImpl(DnsMasterDataContainer container) throws UpdateControlsException {
	}

	public void updateControlsImpl(DnsMastersForServiceDataContainer container) throws UpdateControlsException {
		adapter.getSelectedMasters().updateControls(container);
	}

	public void updateControlsImpl(DnsMastersWizardPage1DataContainer container) throws UpdateControlsException {
		adapter.getMastersWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsMastersWizardSummaryDataContainer container) throws UpdateControlsException {
		adapter.getMastersWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsStubZoneDataContainer container) throws UpdateControlsException {
		adapter.getSelectedStubZone().updateControls(container);
	}

	public void updateControlsImpl(DnsStubZoneWizardPage1DataContainer container) throws UpdateControlsException {
		adapter.getStubZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsStubZoneWizardSummaryDataContainer container) throws UpdateControlsException {
		adapter.getStubZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsForwardersForServiceDataContainer container) throws UpdateControlsException {
		try {
			adapter.getDnsService().updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	public void updateControlsImpl(WelcomeDataContainer container) throws UpdateControlsException {
		container.get_usr_WelcomeText().setControlValue(container.getAdapter().getBundle().getString("dns.welcome.objects"));
		container.get_usr_DnsPicture().setControlValue(new PictureData("/org/sblim/wbemsmt/dns/images/dns.gif"));
		container.get_usr_LinkCreateMasterzone().setControlValue(new LinkData(new CreateMasterZoneListener(),container.getAdapter().getBundle().getString("tree.menu.createMasterZone")));
		container.get_usr_LinkCreateForwardzone().setControlValue(new LinkData(new CreateForwardZoneListener(),container.getAdapter().getBundle().getString("tree.menu.createForwardZone")));
		container.get_usr_LinkCreateSlavezone().setControlValue(new LinkData(new CreateSlaveZoneListener(),container.getAdapter().getBundle().getString("tree.menu.createSlaveZone")));
		container.get_usr_LinkCreateAddressmatchlist().setControlValue(new LinkData(new CreateAddressMatchListListener(),container.getAdapter().getBundle().getString("tree.menu.createAdressMatchList")));
		container.get_usr_LinkCreateMasters().setControlValue(new LinkData(new CreateMastersListener(),container.getAdapter().getBundle().getString("tree.menu.createMasters")));
		container.get_usr_Memo().setControlValue(new MemoData(container.getAdapter().getBundle().getString("dns.welcome.additional.info")));
	}


}
