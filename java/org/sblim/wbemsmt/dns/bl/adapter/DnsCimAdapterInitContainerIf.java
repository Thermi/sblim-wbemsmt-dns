/** 
  * DnsCimAdapterInitContainerIf.java
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
  * @template: org/sblim/wbemsmt/dcg/templates/adapterInterfaceInitContainer.vm
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
	 * This is the interface containing only the UpdateControls-Methods for the delegate
	 **/

public interface DnsCimAdapterInitContainerIf extends InitContainerDelegatee
{

	/** 
	 * InitContainer-Methods
	 **/
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	public void initContainerImpl(org.sblim.wbemsmt.dns.bl.container.welcome.WelcomeDataContainer container) throws org.sblim.wbemsmt.exception.InitContainerException;
	}