/** 
 * CreateStubZoneWizard.java
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
 * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/cmd/wizardClass.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: Wizard for StubZones
 * 
 * generated Class
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

public class CreateStubZoneWizard extends CliWizardBase implements IPageWizardAdapter {

    static Logger logger = Logger.getLogger(CreateStubZoneWizard.class.getName());
    private org.sblim.wbemsmt.dns.wizard.CreateStubZoneWizardContainer container = null;

    public CreateStubZoneWizard(final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter) {
        super(adapter, ResourceBundleManager.getResourceBundle(new String[] { "messages",
                "messagesDns" }, Locale.getDefault()));
        this.container = new org.sblim.wbemsmt.dns.wizard.CreateStubZoneWizardContainer(adapter,
                new org.sblim.wbemsmt.dns.wizard.CreateStubZoneWizardContainerPanels() {
                    public Object getMain() throws WbemsmtException {
                        DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsStubZoneWizardPage1DataContainerImpl(
                                adapter);
                        return dc;
                    }

                    public Object getOverview() throws WbemsmtException {
                        DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsStubZoneWizardSummaryDataContainerImpl(
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