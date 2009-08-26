 /** 
  * DnsCimAdapterUpdateControlsDelegatee.java
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
  * Description: Delegatee for Updating controls
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.fielddata.LinkData;
import org.sblim.wbemsmt.bl.fielddata.MemoData;
import org.sblim.wbemsmt.bl.fielddata.PictureData;
import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.welcome.WelcomeDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.*;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.listener.*;
import org.sblim.wbemsmt.exception.WbemsmtException;

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
			throws WbemsmtException {
		// do nothing is a base object

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws WbemsmtException {

		adapter.getSelectedAddressMatchList().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsAddressMatchListWizardPage1DataContainer container)
			throws WbemsmtException {

		adapter.getAddressMatchListWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(
			DnsAddressMatchListWizardSummaryDataContainer container)
			throws WbemsmtException {
		adapter.getAddressMatchListWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowNotifyForServiceDataContainer container)
			throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowNotifyForZoneDataContainer container)
			throws WbemsmtException {
		if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateControls(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateControls(container);
		}
		else {
			throw new  WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS,"Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowQueryForServiceDataContainer container)
			throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowQueryForZoneDataContainer container)
			throws WbemsmtException {
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
			throw new  WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS,"Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowRecursionForServiceDataContainer container)
			throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowTransferForServiceDataContainer container)
			throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws WbemsmtException {
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
			throw new  WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS,"Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public void updateControlsImpl(
			DnsAllowUpdateForZoneDataContainer container)
			throws WbemsmtException {
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
			throw new  WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS,"Cannot updateControls for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public void updateControlsImpl(
			DnsBlackholeForServiceDataContainer container)
			throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public void updateControlsImpl(DnsConfigurationDataContainer container)
			throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public void updateControlsImpl(DnsForwardZoneDataContainer container)
			throws WbemsmtException {
		adapter.getSelectedForwardZone().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public void updateControlsImpl(DnsHintZoneDataContainer container)
			throws WbemsmtException {
		adapter.getSelectedHintZone().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public void updateControlsImpl(DnsMasterZoneDataContainer container)
			throws WbemsmtException {
		adapter.getSelectedMasterZone().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsMasterZoneWizardPage1DataContainer container)
			throws WbemsmtException {
		adapter.getMasterZoneWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(
			DnsMasterZoneWizardSummaryDataContainer container)
			throws WbemsmtException {
		adapter.getMasterZoneWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public void updateControlsImpl(DnsResourceRecordDataContainer container)
			throws WbemsmtException {
		adapter.getSelectedResourceRecord().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsResourceRecordWizardPage1DataContainer container)
			throws WbemsmtException {
		adapter.getResourceRecordWizard().updateControls(container);

	}

	public void updateControlsImpl(DnsResourceRecordWizardPage2TypeMxDataContainer container) throws WbemsmtException {
		adapter.getResourceRecordWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordWizardPage2TypeOtherDataContainer container) throws WbemsmtException {
		adapter.getResourceRecordWizard().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(
			DnsResourceRecordWizardSummaryDataContainer container)
			throws WbemsmtException {
		adapter.getResourceRecordWizard().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public void updateControlsImpl(DnsReverseZoneDataContainer container)
			throws WbemsmtException {
		adapter.getSelectedReverseZone().updateControls(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)
	 */
	public void updateControlsImpl(
			DnsReverseZoneWizardPage1DataContainer container)
			throws WbemsmtException {
		adapter.getReverseZoneWizard().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public void updateControlsImpl(DnsServiceOperationsDataContainer container)
			throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public void updateControlsImpl(DnsSlaveZoneDataContainer container)
			throws WbemsmtException {
		adapter.getSelectedSlaveZone().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer)
	 */
	public void updateControlsImpl(DnsZoneDataContainer container)
			throws WbemsmtException {
		//do nothing - is a base object
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardPage1DataContainer)
	 */
	public void updateControlsImpl(DnsForwardZoneWizardPage1DataContainer container)
			throws WbemsmtException {
		adapter.getForwardZoneWizard().updateControls(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateControlsIf#updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardSummaryDataContainer)
	 */
	public void updateControlsImpl(DnsForwardZoneWizardSummaryDataContainer container)
			throws WbemsmtException {
		adapter.getForwardZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsServiceTracingDataContainer container) throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	public void updateControlsImpl(DnsSlaveZoneWizardPage1DataContainer container) throws WbemsmtException {
		adapter.getSlaveZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsSlaveZoneWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getSlaveZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsZoneTracingContainer container) throws WbemsmtException {
		adapter.getSelectedZone().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		adapter.getSelectedZone().updateControls(container,fco);
	}

	public void updateControlsImpl(DnsForwarderDataContainer container) throws WbemsmtException {
		//do nothing - is a base object
	}

	public void updateControlsImpl(DnsTTLDataContainer container) throws WbemsmtException {
		//do nothing - is a base object
		
	}

	public void updateControlsImpl(DnsAddMasterAddressDataContainer container) throws WbemsmtException {
		//do nothing - is a base object
	}

	public void updateControlsImpl(DnsReverseZoneWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getReverseZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordForReverseZoneWizardDataContainer container) throws WbemsmtException {
	}

	public void updateControlsImpl(DnsResourceRecordForReverseZoneWizardDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		adapter.getReverseZoneWizard().updateControls(container,fco);
	}

	public void updateControlsImpl(DnsResourceRecordListContainer container) throws WbemsmtException {
		adapter.getSelectedZone().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordListItemContainer container) throws WbemsmtException {
		adapter.getSelectedZone().updateControls(container);
	}

	public void updateControlsImpl(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		adapter.getSelectedZone().updateControls(container,fco);
	}

	public void updateControlsImpl(DnsSoaContainer container) throws WbemsmtException {
		if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateControls(container);
		}
		else if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateControls(container);
		}
		
		else throw new WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS,"Selected zone is no masterZone or ReverseZone");
	}

	public void updateControlsImpl(DnsMasterDataContainer container) throws WbemsmtException {
	}

	public void updateControlsImpl(DnsMastersForServiceDataContainer container) throws WbemsmtException {
		adapter.getSelectedMasters().updateControls(container);
	}

	public void updateControlsImpl(DnsMastersWizardPage1DataContainer container) throws WbemsmtException {
		adapter.getMastersWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsMastersWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getMastersWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsStubZoneDataContainer container) throws WbemsmtException {
		adapter.getSelectedStubZone().updateControls(container);
	}

	public void updateControlsImpl(DnsStubZoneWizardPage1DataContainer container) throws WbemsmtException {
		adapter.getStubZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsStubZoneWizardSummaryDataContainer container) throws WbemsmtException {
		adapter.getStubZoneWizard().updateControls(container);
	}

	public void updateControlsImpl(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		adapter.getDnsService().updateControls(container);
	}

	public void updateControlsImpl(WelcomeDataContainer container) throws WbemsmtException {
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
