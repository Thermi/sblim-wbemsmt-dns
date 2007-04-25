/** 
  * DnsCimAdapterInitWizardIf.java
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
  * @template: ./tools-dcg/templates/adapterInterfaceInitWizard.vm
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
	 * This is the interface containing only the initWizard-Methods for the delegate
	 **/

public interface DnsCimAdapterInitWizardIf extends InitWizardDelegatee
{

	public static final String[] RESOURCE_BUNDLE_NAMES = new String[]{"messages","messagesDns"};

	/** 
	 * UpdateControls-Methods
	 **/
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.AddressMatchListWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.MasterWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.CreateForwardZoneWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.CreateMasterZoneWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.CreateSlaveZoneWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
			
public void initWizardImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer container,org.sblim.wbemsmt.dns.wizard.CreateStubZoneWizardContainer wizardContainer, String currentPagename) throws org.sblim.wbemsmt.exception.InitWizardException;
	}