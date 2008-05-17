/** 
 * DnsCimAdapterCreateIf.java
 *
 * 
 * © Copyright IBM Corp. 2006,2007
 *
 * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE COMMON PUBLIC LICENSE
 * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
 *
 * You can obtain a current copy of the Common Public License from
 * http://www.opensource.org/licenses/cpl1.0.php
 *
 * @author: org.sblim.wbemsmt.dcg.generator.AdapterStubGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/adapterInterfaceCreate.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: 
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.adapter.*;

import org.sblim.wbemsmt.exception.WbemsmtException;

/** 
 * This is the interface containing only the Create-Methods for the delegate
 **/

public interface DnsCimAdapterCreateIf extends CreateDelegatee {

    public static final String[] RESOURCE_BUNDLE_NAMES = new String[] { "messages", "messagesDns" };

    /** 
     * Create-Methods
     **/
    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer container)
            throws WbemsmtException;

    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer container)
            throws WbemsmtException;

    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardSummaryDataContainer container)
            throws WbemsmtException;

    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer container)
            throws WbemsmtException;

    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer container)
            throws WbemsmtException;

    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer container)
            throws WbemsmtException;

    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer container)
            throws WbemsmtException;

    public void createImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer container)
            throws WbemsmtException;

}