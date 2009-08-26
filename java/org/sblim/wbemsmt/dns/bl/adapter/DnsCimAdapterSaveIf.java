/**
 * DnsCimAdapterSaveIf.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE TER MS
 * OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the Common
 * Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.AdapterStubGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/adapterInterfaceSave.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: generated Class
 */

package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.adapter.*;

import org.sblim.wbemsmt.exception.WbemsmtException;

/*
 * This is the interface containing only the Save-Methods for the delegate
 */

public interface DnsCimAdapterSaveIf extends SaveDelegatee {

    /** 
     * Save-Methods
     **/
    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container)
            throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container,
            org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco) throws WbemsmtException;

    public org.sblim.wbemsmt.bl.messages.MessageList saveImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer container,
            org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco) throws WbemsmtException;

}