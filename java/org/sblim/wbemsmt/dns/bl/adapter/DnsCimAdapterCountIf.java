/** 
 * DnsCimAdapterCountIf.java
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
 * @template: org/sblim/wbemsmt/dcg/templates/adapterInterfaceCount.vm
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
 * This is the interface containing only the Count-Methods for the delegate
 **/

public interface DnsCimAdapterCountIf extends CountDelegatee {

    public static final String[] RESOURCE_BUNDLE_NAMES = new String[] { "messages", "messagesDns" };

    /** 
     * Count-Methods
     **/
    public int countImpl_ResourceRecords(Class childClass,
            org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer parent)
            throws WbemsmtException;

    public int countImpl_ResourceRecords(Class childClass,
            org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer parent)
            throws WbemsmtException;

    public int countImpl_ResourceRecords(
            Class childClass,
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer parent)
            throws WbemsmtException;

}