 /** 
  * DnsCimAdapterUpdateModelDelegatee.java
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
  * Description: Delegatte for updateModel actions (trigger for example by buttons)
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.wizard.*;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;

public class DnsCimAdapterUpdateModelDelegatee implements
		DnsCimAdapterUpdateModelIf {


	private final DnsCimAdapter adapter;

	/***
	 * 
	 * @param adapter
	 */
	public DnsCimAdapterUpdateModelDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer)
	 */
	public void updateModelImpl(DnsAddressMatchListDataContainer container)
			throws ModelUpdateException {
		// do nothing is a base object
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public void updateModelImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws ModelUpdateException {
		adapter.getSelectedAddressMatchList().updateModel(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
	 */
	public void updateModelImpl(
			DnsAddressMatchListWizardPage1DataContainer container)
			throws ModelUpdateException {

		adapter.getAddressMatchListWizard().updateModel(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public void updateModelImpl(
			DnsAllowNotifyForServiceDataContainer container)
			throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public void updateModelImpl(DnsAllowNotifyForZoneDataContainer container)
			throws ModelUpdateException {
		if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateModel(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateModel(container);
		}
		else
		{
			throw new  ModelUpdateException("Cannot updateModel for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public void updateModelImpl(
			DnsAllowQueryForServiceDataContainer container)
			throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public void updateModelImpl(DnsAllowQueryForZoneDataContainer container)
			throws ModelUpdateException {
		if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateModel(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateModel(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateModel(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateModel(container);
		}
		else
		{
			throw new  ModelUpdateException("Cannot updateModel for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public void updateModelImpl(
			DnsAllowRecursionForServiceDataContainer container)
			throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public void updateModelImpl(
			DnsAllowTransferForServiceDataContainer container)
			throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public void updateModelImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws ModelUpdateException {
		if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateModel(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateModel(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateModel(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateModel(container);
		}
		else
		{
			throw new  ModelUpdateException("Cannot updateModel for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public void updateModelImpl(DnsAllowUpdateForZoneDataContainer container)
			throws ModelUpdateException {

		if (adapter.getSelectedMasterZone() != null)
		{
			adapter.getSelectedMasterZone().updateModel(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			adapter.getSelectedSlaveZone().updateModel(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			adapter.getSelectedStubZone().updateModel(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			adapter.getSelectedReverseZone().updateModel(container);
		}
		else
		{
			throw new  ModelUpdateException("Cannot updateModel for container - selected zone " + adapter.getSelectedZone() + " not supported");
		}

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public void updateModelImpl(DnsBlackholeForServiceDataContainer container)
			throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public void updateModelImpl(DnsForwardZoneDataContainer container)
			throws ModelUpdateException {
		adapter.getSelectedForwardZone().updateModel(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public void updateModelImpl(DnsMasterZoneDataContainer container)
			throws ModelUpdateException {
		adapter.getSelectedMasterZone().updateModel(container);

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer)
	 */
	public void updateModelImpl(DnsMasterZoneWizardPage1DataContainer container)
			throws ModelUpdateException {
		adapter.getMasterZoneWizard().updateModel(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer)
	 */
	public void updateModelImpl(
			DnsResourceRecordWizardPage1DataContainer container)
			throws ModelUpdateException {
		adapter.getResourceRecordWizard().updateModel(container);
	}

	public void updateModelImpl(DnsResourceRecordWizardPage2TypeMxDataContainer container) throws ModelUpdateException {
		adapter.getResourceRecordWizard().updateModel(container);
	}

	public void updateModelImpl(DnsResourceRecordWizardPage2TypeOtherDataContainer container) throws ModelUpdateException {
		adapter.getResourceRecordWizard().updateModel(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public void updateModelImpl(DnsReverseZoneDataContainer container)
			throws ModelUpdateException {
		adapter.getSelectedReverseZone().updateModel(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)
	 */
	public void updateModelImpl(DnsReverseZoneWizardPage1DataContainer container)
			throws ModelUpdateException {
		adapter.getReverseZoneWizard().updateModel(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public void updateModelImpl(DnsServiceOperationsDataContainer container)
			throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public void updateModelImpl(DnsSlaveZoneDataContainer container)
			throws ModelUpdateException {
		adapter.getSelectedSlaveZone().updateModel(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterUpdateModelIf#updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardPage1DataContainer)
	 */
	public void updateModelImpl(DnsForwardZoneWizardPage1DataContainer container)
			throws ModelUpdateException {
		adapter.getForwardZoneWizard().updateModel(container);
	}

	public void updateModelImpl(DnsSlaveZoneWizardPage1DataContainer container) throws ModelUpdateException {
		adapter.getSlaveZoneWizard().updateModel(container);
	}

	public void updateModelImpl(DnsForwarderDataContainer container) throws ModelUpdateException {
		// do nothing - is a base object
	}

	public void updateModelImpl(DnsAddMasterAddressDataContainer container) throws ModelUpdateException {
		//do nothing - is a base object
	}

	public void updateModelImpl(DnsForwardZoneWizardSummaryDataContainer container) throws ModelUpdateException {
		// do nothing
	}

	public void updateModelImpl(DnsResourceRecordListContainer container) throws ModelUpdateException {
		adapter.getSelectedZone().updateModel(container);
	}

	public void updateModelImpl(DnsMastersForServiceDataContainer container) throws ModelUpdateException {
		adapter.getSelectedMasters().updateModel(container);
	}

	public void updateModelImpl(DnsMastersWizardPage1DataContainer container) throws ModelUpdateException {
		adapter.getMastersWizard().updateModel(container);
	}

	public void updateModelImpl(DnsStubZoneDataContainer container) throws ModelUpdateException {
		adapter.getSelectedStubZone().updateModel(container);
	}

	public void updateModelImpl(DnsStubZoneWizardPage1DataContainer container) throws ModelUpdateException {
		adapter.getStubZoneWizard().updateModel(container);
		
	}

	public void updateModelImpl(DnsForwardersForServiceDataContainer container) throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
	}

	public void updateModelImpl(DnsSoaContainer container) throws ModelUpdateException {
		if (adapter.getUpdateTrigger() == container.get_usr_SetSerialNumber())
		{
			adapter.getSelectedZone().updateSerialNumber(container);
		}
		
	}

	public void updateModelImpl(DnsConfigurationDataContainer container) throws ModelUpdateException {
		try {
			adapter.getDnsService().updateModel(container);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
		
	}

	public void updateModelImpl(DnsHintZoneDataContainer container) throws ModelUpdateException {
		adapter.getSelectedHintZone().updateModel(container);
		
		
	}

	public void updateModelImpl(DnsResourceRecordDataContainer container) throws ModelUpdateException {
		adapter.getSelectedResourceRecord().updateModel(container);
	}

	public void updateModelImpl(DnsTTLDataContainer container) throws ModelUpdateException {
		// do nothing it is just a base class
		
	}

	public void updateModelImpl(DnsResourceRecordListItemContainer container) throws ModelUpdateException {
		adapter.getSelectedZone().updateModel(container);
	}


}
