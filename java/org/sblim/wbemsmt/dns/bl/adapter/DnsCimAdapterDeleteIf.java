/** 
 * DnsCimAdapterDeleteIf.java
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
 * @template: org/sblim/wbemsmt/dcg/templates/adapterInterfaceDelete.vm
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
 * This is the interface containing only the Delete-Methods for the delegate
 **/

public interface DnsCimAdapterDeleteIf extends DeleteDelegatee {

    public static final String[] RESOURCE_BUNDLE_NAMES = new String[] { "messages", "messagesDns" };

    /** 
     * Delete-Methods
     **/
    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardZone fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsHintZone fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsReverseZoneWrapper fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsSlaveZone fco)
            throws WbemsmtException;

    public void deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsStubZone fco)
            throws WbemsmtException;
}