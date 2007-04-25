/** 
  * DnsCimAdapterInstallValidatorsIf.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.AdapterStubGenerator
  * @template: ./tools-dcg/templates/adapterInterfaceInstallValidators.vm
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
	 * This is the interface containing only the InstallValidator-Methods for the delegate
	 **/

public interface DnsCimAdapterInstallValidatorsIf extends InstallValidatorsDelegatee
{

	public static final String[] RESOURCE_BUNDLE_NAMES = new String[]{"messages","messagesDns"};

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
	public void installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.welcome.WelcomeDataContainer container);
			
}