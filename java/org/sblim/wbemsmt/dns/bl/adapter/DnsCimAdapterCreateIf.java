/** 
  * DnsCimAdapterCreateIf.java
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
  * @template: ./tools-dcg/templates/adapterInterfaceCreate.vm
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
	 * This is the interface containing only the Create-Methods for the delegate
	 **/

public interface DnsCimAdapterCreateIf extends CreateDelegatee
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
	
		
}