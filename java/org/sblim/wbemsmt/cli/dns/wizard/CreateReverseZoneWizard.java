/**
 * CreateReverseZoneWizard.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE TER
 * MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the Common
 * Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/cmd/wizardClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Wizard for ReverseZones generated Class
 */

package org.sblim.wbemsmt.cli.dns.wizard;

import java.util.*;
import java.util.logging.Logger;

import org.sblim.wbemsmt.bl.adapter.DataContainer;

import org.sblim.wbemsmt.tools.resources.ResourceBundleManager;
import org.sblim.wbemsmt.tools.wizard.adapter.IPageWizardAdapter;
import org.sblim.wbemsmt.tools.wizard.cli.*;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class CreateReverseZoneWizard extends CliWizardBase implements IPageWizardAdapter {

    static Logger logger = Logger.getLogger(CreateReverseZoneWizard.class.getName());
    private org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainer container = null;

    public CreateReverseZoneWizard(final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter) {
        super(adapter, ResourceBundleManager.getResourceBundle(new String[] { "messages",
                "messagesDns" }, Locale.getDefault()));
        this.container = new org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainer(adapter,
                new org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainerPanels() {
                    public DataContainer getMain() throws WbemsmtException {
                        DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsReverseZoneWizardPage1DataContainerImpl(
                                adapter);
                        return dc;
                    }

                    public DataContainer getSummary() throws WbemsmtException {
                        DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsReverseZoneWizardSummaryDataContainerImpl(
                                adapter);
                        return dc;
                    }
                });
        super.initialize();
        try {
            super.initWizard((IWizardContainer) container, this);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        logger.fine("Wizard initialized");
    }

    public void cleanUPPage(String panelName) {
        //cleanup is done in the adapter
    }

    public IWizardContainer getWizardContainer() {
        return container;
    }
}