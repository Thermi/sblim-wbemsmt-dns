/** 
  * DnsCimAdapterIf.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.AdapterStubGenerator
  * @template: ./tools-dcg/templates/adapterInterface.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.adapter.*;


	/** 
	 * This is the interface containing all Methods
	 **/

public interface DnsCimAdapterIf extends DnsCimAdapterCountIf, DnsCimAdapterCreateIf, DnsCimAdapterDeleteIf, DnsCimAdapterInstallValidatorsIf, DnsCimAdapterSaveIf, DnsCimAdapterRevertIf, DnsCimAdapterUpdateControlsIf, DnsCimAdapterUpdateModelIf
{

	public static final String[] RESOURCE_BUNDLE_NAMES = new String[]{"messages","messagesDns"};

	/** 
	 * Create-Methods
	 **/
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public void createImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	
	/** 
	 * Save-Methods
	 **/
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	
	/** 
	 * Save-Methods for Lists
	 **/
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container, org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer container, org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	
	/** 
	 * Revert-Methods
	 **/
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	public MessageList revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectRevertException;
	
	/** 
	 * Revert-Methods for Lists
	 **/
	
	
	/** 
	 * UpdateModel-Methods
	 **/
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
	public void updateModelImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer container) throws org.sblim.wbemsmt.exception.ModelUpdateException;
		
	/** 
	 * UpdateControls-Methods
	 **/
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer container) throws org.sblim.wbemsmt.exception.UpdateControlsException;
	
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container, org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)  throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container, org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)  throws org.sblim.wbemsmt.exception.UpdateControlsException;
	public void updateControlsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer container, org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)  throws org.sblim.wbemsmt.exception.UpdateControlsException;
		
	/** 
	 * Delete-Methods
	 **/
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardZone fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsHintZone fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsReverseZoneWrapper fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsSlaveZone fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
	public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsStubZone fco) throws org.sblim.wbemsmt.exception.ObjectDeletionException;
			
	/** 
	 * Count-Methods
	 **/
	public int countImpl_DnsResourceRecordDataContainer() throws org.sblim.wbemsmt.exception.CountException;
	public int countImpl_DnsResourceRecordForReverseZoneWizardDataContainer() throws org.sblim.wbemsmt.exception.CountException;
	public int countImpl_DnsResourceRecordListItemContainer() throws org.sblim.wbemsmt.exception.CountException;
	
	/** 
	 * InstallValidator-Methods
	 **/
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer container);
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer container);
			
}