/**
 * CreateReverseZoneWizard.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE TER
 * MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the Common
 * Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/jsf/wizardClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Wizard for ReverseZones generated Class
 */

package org.sblim.wbemsmt.jsf.dns.wizard;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import org.sblim.wbemsmt.tools.resources.LocaleManager;
import org.sblim.wbemsmt.tools.resources.ResourceBundleManager;
import org.sblim.wbemsmt.tools.wizard.adapter.IPageWizardAdapter;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;
import org.sblim.wbemsmt.tools.wizard.jsf.JSFWizardBase;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.apache.myfaces.custom.div.Div;

public class CreateReverseZoneWizard extends JSFWizardBase implements IPageWizardAdapter {

    private org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainer container = null;

    String binding = "objectActionController.currentWizard.currentPanel.";

    org.sblim.wbemsmt.jsf.dns.container.wizard.DnsReverseZoneWizardPage1DataContainerImpl panel1 = null;
    org.sblim.wbemsmt.jsf.dns.container.wizard.DnsReverseZoneWizardSummaryDataContainerImpl panel2 = null;

    final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter;

    public CreateReverseZoneWizard(final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter) {
        super(adapter, ResourceBundleManager.getResourceBundle(new String[] { "messages",
                "messagesDns" }, LocaleManager.getCurrent(FacesContext.getCurrentInstance())
                .getCurrentLocale()), "CreateReverseZoneWizard.title");
        this.adapter = adapter;
        this.container = new org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainer(adapter,
                new org.sblim.wbemsmt.dns.wizard.CreateReverseZoneWizardContainerPanels() {
                    //update the child objects

                    public DataContainer getMain() throws WbemsmtException {
                        //Workaround for Bug https://issues.apache.org/jira/browse/MYFACES-1438
                        //Create the panel everytime the panel is needed 
                        //if (panel1!= null)
                        //{
                        //	return panel1;
                        //}

                        try {
                            panel1 = new org.sblim.wbemsmt.jsf.dns.container.wizard.DnsReverseZoneWizardPage1DataContainerImpl(
                                    adapter, binding);
                            panel1.countAndCreateChildren();

                            HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext
                                    .getCurrentInstance().getApplication().createComponent(
                                            HtmlPanelGrid.COMPONENT_TYPE);
                            childEditFields.setStyleClass("childTable");

                            //add the single childs

                            //add the childs with occurence list

                            Div div = (Div) FacesContext.getCurrentInstance().getApplication()
                                    .createComponent(Div.COMPONENT_TYPE);
                            div.setStyleClass("divWrappingChildTable");
                            div.getChildren().add(childEditFields);

                            panel1.getChildPanel().getChildren().add(div);

                            panel1.getLayouter().layout(panel1.getPanelForCustomLayout(), panel1,
                                    bundle);

                            return panel1;
                        }
                        catch (Exception e) {
                            throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                                    "Cannot process Wizard createReverseZoneWizard", e);
                        }
                    }

                    //update the child objects

                    public DataContainer getSummary() throws WbemsmtException {
                        //Workaround for Bug https://issues.apache.org/jira/browse/MYFACES-1438
                        //Create the panel everytime the panel is needed 
                        //if (panel2!= null)
                        //{
                        //	return panel2;
                        //}

                        try {
                            panel2 = new org.sblim.wbemsmt.jsf.dns.container.wizard.DnsReverseZoneWizardSummaryDataContainerImpl(
                                    adapter, binding);
                            panel2.countAndCreateChildren();

                            HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext
                                    .getCurrentInstance().getApplication().createComponent(
                                            HtmlPanelGrid.COMPONENT_TYPE);
                            childEditFields.setStyleClass("childTable");

                            //add the single childs

                            //add the childs with occurence list
                            {

                                HtmlPanelGrid childPanel = panel2.getResourceRecordsPanel()
                                        .getOuterPanel();
                                childPanel
                                        .setId(org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent
                                                .asJsfId("summaryChild_resourceRecords"));
                                childEditFields.getChildren().add(childPanel);
                            }

                            Div div = (Div) FacesContext.getCurrentInstance().getApplication()
                                    .createComponent(Div.COMPONENT_TYPE);
                            div.setStyleClass("divWrappingChildTable");
                            div.getChildren().add(childEditFields);

                            panel2.getChildPanel().getChildren().add(div);

                            return panel2;
                        }
                        catch (Exception e) {
                            throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                                    "Cannot process Wizard createReverseZoneWizard", e);
                        }
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

    public boolean savePageValues(String actualPanelName) {
        //save pageValues is done in the JSFWizardBase.next-Method, delegating the call to the adapter
        return true;
    }

    public IWizardContainer getWizardContainer() {
        return container;
    }

    public void setSummaryText(String nextPanelName) {
        //adapter-based wizards having no SummaryText
        //if wanted a method like getSummaryText shoule be imlemented in AbstractBaseCimAdapter
    }

    public String wizardComplete() {
        //everything necessary for completion is done in the Adaper
        return "";
    }

    public void reload() {
        //do nothing
    }

    //Workaround for a bug within myFaces - Everytime a new panel is created the childs are created also

    public void countAndCreateChilds(DataContainer dataContainer) throws WbemsmtException {
        if (dataContainer instanceof org.sblim.wbemsmt.jsf.dns.container.wizard.DnsReverseZoneWizardPage1DataContainerImpl) {
            //update the child objects
            try {
                panel1.updateControls();

                HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance()
                        .getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
                childEditFields.setStyleClass("childTable");

                //add the childs with occurence list
                panel1.getChildPanel().getChildren().clear();

                Div div = (Div) FacesContext.getCurrentInstance().getApplication().createComponent(
                        Div.COMPONENT_TYPE);
                div.setStyleClass("divWrappingChildTable");
                div.getChildren().add(childEditFields);

                panel1.getChildPanel().getChildren().add(div);
            }
            catch (Exception e) {
                throw new WbemsmtException(WbemsmtException.ERR_WIZARD_LOGIC,
                        "Cannot process Wizard createReverseZoneWizard", e);
            }
        }
        if (dataContainer instanceof org.sblim.wbemsmt.jsf.dns.container.wizard.DnsReverseZoneWizardSummaryDataContainerImpl) {
            //update the child objects
            try {
                panel2.updateControls();

                HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance()
                        .getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
                childEditFields.setStyleClass("childTable");

                //add the childs with occurence list
                {

                    HtmlPanelGrid childPanel = panel2.getResourceRecordsPanel().getOuterPanel();
                    childPanel.setId(org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent
                            .asJsfId("summaryChild_resourceRecords"));
                    childEditFields.getChildren().add(childPanel);
                }
                panel2.getChildPanel().getChildren().clear();

                Div div = (Div) FacesContext.getCurrentInstance().getApplication().createComponent(
                        Div.COMPONENT_TYPE);
                div.setStyleClass("divWrappingChildTable");
                div.getChildren().add(childEditFields);

                panel2.getChildPanel().getChildren().add(div);
            }
            catch (Exception e) {
                throw new WbemsmtException(WbemsmtException.ERR_WIZARD_LOGIC,
                        "Cannot process Wizard createReverseZoneWizard", e);
            }
        }
    }

    public String getFinishText() {
        return bundle.getString("CreateReverseZoneWizard.finishText", bundle
                .getString("wizard.finishText"));
    }

    public String getJavaScriptWaitStatement() {
        String text = bundle.getString("CreateReverseZoneWizard.createWaitText", bundle
                .getString("wizard.createWaitText"));
        return org.sblim.wbemsmt.tools.jsf.JavascriptUtil.getShowWaitCall(text);
    }
}