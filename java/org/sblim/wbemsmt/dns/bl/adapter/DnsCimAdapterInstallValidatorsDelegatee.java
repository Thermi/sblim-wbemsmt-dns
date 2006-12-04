 /** 
  * DnsCimAdapterInstallValidatorsDelegatee.java
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
  * Description: Delegatee for installing the validators
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.wizard.*;
import org.sblim.wbemsmt.dns.bl.validator.AddressMatchListNameValidator;
import org.sblim.wbemsmt.dns.bl.validator.MasterAddressesSetValidator;
import org.sblim.wbemsmt.dns.bl.validator.ResourceRecordListValidator;
import org.sblim.wbemsmt.dns.bl.validator.ResourceRecordValidator;
import org.sblim.wbemsmt.dns.bl.validator.ReverseZoneIpValidator;
import org.sblim.wbemsmt.dns.bl.validator.ZoneNameValidator;
import org.sblim.wbemsmt.tools.validator.IpAddressFieldValidator;
import org.sblim.wbemsmt.tools.validator.RequiredFieldValidator;

public class DnsCimAdapterInstallValidatorsDelegatee implements
		DnsCimAdapterInstallValidatorsIf {

	private final DnsCimAdapter adapter;


	public DnsCimAdapterInstallValidatorsDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer)
	 */
	public void installValidatorsImpl(DnsAddressMatchListDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAddressMatchListForServiceDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
	 */
	public void installValidatorsImpl(
			DnsAddressMatchListWizardPage1DataContainer container) {

		RequiredFieldValidator requiredValidator = new RequiredFieldValidator(container.get_Name(),adapter);
		AddressMatchListNameValidator matchListNameValidator = new AddressMatchListNameValidator(container.get_Name(),adapter);
		requiredValidator.addChild(matchListNameValidator);
		adapter.addValidator(container,requiredValidator);

	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowNotifyForServiceDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowNotifyForZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowQueryForServiceDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowQueryForZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowRecursionForServiceDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowTransferForServiceDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowTransferForZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAllowUpdateForZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public void installValidatorsImpl(
			DnsBlackholeForServiceDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public void installValidatorsImpl(DnsConfigurationDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public void installValidatorsImpl(DnsForwardZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public void installValidatorsImpl(DnsHintZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public void installValidatorsImpl(DnsMasterZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer)
	 */
	public void installValidatorsImpl(
			DnsMasterZoneWizardPage1DataContainer container) {
		
		//validator for name
		RequiredFieldValidator requiredValidator = new RequiredFieldValidator(container.get_usr_Name(),adapter);
		ZoneNameValidator zoneNameValidator = new ZoneNameValidator(container.get_usr_Name(),adapter);
		requiredValidator.addChild(zoneNameValidator);
		adapter.addValidator(container,requiredValidator);

		//for contact
		adapter.addValidator(container, new RequiredFieldValidator(container.get_usr_Contact(),adapter));
		
		//for ip
		RequiredFieldValidator requiredFieldValidatorIp = new RequiredFieldValidator(container.get_usr_IpAdress(),adapter);
		requiredFieldValidatorIp.addChild(new IpAddressFieldValidator(container.get_usr_IpAdress(),adapter));
		adapter.addValidator(container, requiredFieldValidatorIp);
		
		//for server
		adapter.addValidator(container, new RequiredFieldValidator(container.get_usr_Server(),adapter));

	}



	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public void installValidatorsImpl(DnsResourceRecordDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer)
	 */
	public void installValidatorsImpl(
			DnsResourceRecordWizardPage1DataContainer container) {
		RequiredFieldValidator requiredValidator1 = new RequiredFieldValidator(container.get_usr_Name(),adapter);
		RequiredFieldValidator requiredValidator2 = new RequiredFieldValidator(container.get_usr_Type(),adapter);
		requiredValidator1.addChild(requiredValidator2);
		adapter.addValidator(container,requiredValidator1);

	}
	
	public void installValidatorsImpl(DnsResourceRecordWizardPage2TypeMxDataContainer container) {
		RequiredFieldValidator requiredValidator1 = new RequiredFieldValidator(container.get_usr_Value(),adapter);
		RequiredFieldValidator requiredValidator2 = new RequiredFieldValidator(container.get_usr_Priority(),adapter);
		ResourceRecordValidator recordValidator = new ResourceRecordValidator(adapter);
		requiredValidator1.addChild(requiredValidator2);
		requiredValidator2.addChild(recordValidator);
		adapter.addValidator(container,requiredValidator1);
	}

	public void installValidatorsImpl(DnsResourceRecordWizardPage2TypeOtherDataContainer container) {
		RequiredFieldValidator requiredValidator = new RequiredFieldValidator(container.get_usr_Value(),adapter);
		ResourceRecordValidator recordValidator = new ResourceRecordValidator(adapter);
		requiredValidator.addChild(recordValidator);
		adapter.addValidator(container,requiredValidator);
	}
	


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public void installValidatorsImpl(DnsReverseZoneDataContainer container) {

	}



	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)
	 */
	public void installValidatorsImpl(
			DnsReverseZoneWizardPage1DataContainer container) {
		RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator(container.get_usr_IpAddress(),adapter);
		requiredFieldValidator.addChild(new ReverseZoneIpValidator(container.get_usr_IpAddress(),adapter));
		adapter.addValidator(container,requiredFieldValidator);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public void installValidatorsImpl(
			DnsServiceOperationsDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public void installValidatorsImpl(DnsSlaveZoneDataContainer container) {
		MasterAddressesSetValidator masterAddressValidator = new MasterAddressesSetValidator(container.get_Masters(), adapter);
		adapter.addValidator(container,masterAddressValidator);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer)
	 */
	public void installValidatorsImpl(DnsZoneDataContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardPage1DataContainer)
	 */
	public void installValidatorsImpl(DnsForwardZoneWizardPage1DataContainer container) {
		adapter.addValidator(container,new RequiredFieldValidator(container.get_usr_Name(),adapter));
	}
	
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsZoneWizardSummaryDataContainer)
	 */
	public void installValidatorsImpl(
			DnsForwardZoneWizardSummaryDataContainer container) {

	}


	public void installValidatorsImpl(DnsServiceTracingDataContainer container) {
		
	}

	public void installValidatorsImpl(DnsSlaveZoneWizardPage1DataContainer container) {
		RequiredFieldValidator requiredValidator = new RequiredFieldValidator(container.get_usr_Name(),adapter);
		ZoneNameValidator zoneNameValidator = new ZoneNameValidator(container.get_usr_Name(),adapter);
		MasterAddressesSetValidator masterAddressValidator = new MasterAddressesSetValidator(container.get_Masters(), adapter);
		requiredValidator.addChild(zoneNameValidator);
		requiredValidator.addChild(masterAddressValidator);
		adapter.addValidator(container,requiredValidator);
	}

	public void installValidatorsImpl(DnsSlaveZoneWizardSummaryDataContainer container) {
		
	}

	public void installValidatorsImpl(DnsZoneTracingContainer container) {
		
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer)
	 */
	public void installValidatorsImpl(
			DnsResourceRecordWizardSummaryDataContainer container) {

	}
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer)
	 */
	public void installValidatorsImpl(
			DnsMasterZoneWizardSummaryDataContainer container) {

	}
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterInstallValidatorsIf#installValidatorsImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
	 */
	public void installValidatorsImpl(
			DnsAddressMatchListWizardSummaryDataContainer container) {

	}

	public void installValidatorsImpl(DnsForwarderDataContainer container) {
		//do nothing - is a base object
		
	}

	public void installValidatorsImpl(DnsTTLDataContainer container) {
		//do nothing - is a base object
	}

	public void installValidatorsImpl(DnsAddMasterAddressDataContainer container) {
		//do nothing - is a base object
	}

	public void installValidatorsImpl(DnsReverseZoneWizardSummaryDataContainer container) {
		//do nothing - is a summary page
	}

	public void installValidatorsImpl(DnsResourceRecordForReverseZoneWizardDataContainer container) {
		//do nothing - is on a summary page
	}

	public void installValidatorsImpl(DnsResourceRecordListContainer container) {
		ResourceRecordListValidator validator = new ResourceRecordListValidator(adapter,container);
		adapter.addValidator(container,validator);
	}

	public void installValidatorsImpl(DnsResourceRecordListItemContainer container) {
	}

	public void installValidatorsImpl(DnsSoaContainer container) {
	}

	public void installValidatorsImpl(DnsMasterDataContainer container) {
	}

	public void installValidatorsImpl(DnsMastersForServiceDataContainer container) {
		MasterAddressesSetValidator masterAddressValidator = new MasterAddressesSetValidator(container.get_Masters(), adapter);
		adapter.addValidator(container,masterAddressValidator);
	}

	public void installValidatorsImpl(DnsMastersWizardPage1DataContainer container) {
		RequiredFieldValidator requiredValidator = new RequiredFieldValidator(container.get_Name(),adapter);
		MasterAddressesSetValidator masterAddressValidator = new MasterAddressesSetValidator(container.get_Masters(), adapter);
		requiredValidator.addChild(masterAddressValidator);
		adapter.addValidator(container,requiredValidator);
	}

	public void installValidatorsImpl(DnsMastersWizardSummaryDataContainer container) {
	}

	public void installValidatorsImpl(DnsStubZoneDataContainer container) {
	}

	public void installValidatorsImpl(DnsStubZoneWizardPage1DataContainer container) {
		RequiredFieldValidator requiredValidator = new RequiredFieldValidator(container.get_usr_Name(),adapter);
		ZoneNameValidator zoneNameValidator = new ZoneNameValidator(container.get_usr_Name(),adapter);
		MasterAddressesSetValidator masterAddressValidator = new MasterAddressesSetValidator(container.get_Masters(), adapter);
		requiredValidator.addChild(zoneNameValidator);
		requiredValidator.addChild(masterAddressValidator);
		adapter.addValidator(container,requiredValidator);
	}

	public void installValidatorsImpl(DnsStubZoneWizardSummaryDataContainer container) {
	}

	public void installValidatorsImpl(DnsForwardersForServiceDataContainer container) {
	}

			
}
