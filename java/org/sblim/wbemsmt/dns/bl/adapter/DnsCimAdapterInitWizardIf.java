/**
 * DnsCimAdapterInitWizardIf.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE
 * TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS
 * FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the
 * Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.AdapterStubGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/adapterInterfaceInitWizard.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: generated Class
 */

package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.adapter.*;

import org.sblim.wbemsmt.exception.WbemsmtException;

/*
 * This is the interface containing only the initWizard-Methods for the delegate
 */

public interface DnsCimAdapterInitWizardIf extends InitWizardDelegatee {

    public static final String[] RESOURCE_BUNDLE_NAMES = new String[] { "messages", "messagesDns" };

    /** 
     * UpdateControls-Methods
     **/

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.AddressMatchListWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.MasterWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.CreateForwardZoneWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.CreateMasterZoneWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.CreateSlaveZoneWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;

    public void initWizardImpl(
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer container,
            org.sblim.wbemsmt.dns.wizard.CreateStubZoneWizardContainer wizardContainer,
            String currentPagename) throws WbemsmtException;
}