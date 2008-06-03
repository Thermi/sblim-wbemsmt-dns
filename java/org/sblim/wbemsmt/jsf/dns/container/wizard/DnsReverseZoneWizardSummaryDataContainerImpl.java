/** 
 * DnsReverseZoneWizardSummaryDataContainerImpl.java
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
 * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/jsf/containerImpl.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: Summary of ReverseZone-Wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

//imports for that field of a linked container with occurence = MANY
import org.sblim.wbemsmt.tools.jsf.MultiLinePanel;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsReverseZoneWizardSummaryDataContainerImpl extends
        org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel
        implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer,
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainerHeader {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ResourceRecordFile;

    private java.util.List icResourceRecords = new java.util.ArrayList();

    private MultiLinePanel resourceRecordsPanel;
    private int resourceRecordsCount;

    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Type;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Value;

    public DnsReverseZoneWizardSummaryDataContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsReverseZoneWizardSummaryDataContainer.caption",
                "DnsReverseZoneWizardSummaryDataContainer.subTitle", false);

        addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent) get_usr_Name());
        addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent) get_ResourceRecordFile());

        setFooter(getPanelForCustomLayout(), "DnsReverseZoneWizardSummaryDataContainer.footerText");
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType STRING
     * UIType LABEL
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
        if (ic_usr_Name == null) {
            String label = bundle.getString("DnsReverseZoneWizardSummaryDataContainer.name");
            String binding = bindingPrefix + "_usr_Name.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = true;
            ic_usr_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_usr_Name;
    }

    /**
     * 
     * DataType STRING
     * UIType LABEL
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ResourceRecordFile() {
        if (ic_ResourceRecordFile == null) {
            String label = bundle
                    .getString("DnsReverseZoneWizardSummaryDataContainer.ResourceRecordFile");
            String binding = bindingPrefix + "_ResourceRecordFile.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = true;
            ic_ResourceRecordFile = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_ResourceRecordFile;
    }

    /**
     * 
     * linked container DnsResourceRecordForReverseZoneWizardDataContainer
     */
    public java.util.List getResourceRecords() {
        return icResourceRecords;
    }

    public MultiLinePanel getResourceRecordsPanel() {
        if (resourceRecordsPanel == null) {
            resourceRecordsPanel = new ResourceRecordsPanel(
                    adapter,
                    bindingPrefix, // the prefix for binding values
                    "#{" + bindingPrefix + "resourceRecordsPanel", // binding for Title
                    "DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainer.caption", //Key for title
                    org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl.COLS);
            addResourceRecordsHeader();
        }

        return resourceRecordsPanel;
    }

    static class ResourceRecordsPanel extends MultiLinePanel {
        public ResourceRecordsPanel(AbstractBaseCimAdapter adapter, String bindingPrefix,
                String bindigForTitle, String keyForTitle, int cols) {
            super(adapter, bindingPrefix, bindigForTitle, keyForTitle, "resourceRecords", cols);
        }

        protected String getOrientationOfColumnAsCss(int column) {
            return org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl.orientationOfColumnAsCss[column];
        }
    }

    private void addResourceRecords(
            org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl child) {

        getResourceRecords().add(child);
        getResourceRecordsPanel().addComponents(child.getComponents());

        //((LabeledJSFInputComponent)getResourceRecords_NameHeader()).getDependentChildFields().add(child.get_Name());
        //((LabeledJSFInputComponent)getResourceRecords_TypeHeader()).getDependentChildFields().add(child.get_Type());
        //((LabeledJSFInputComponent)getResourceRecords_ValueHeader()).getDependentChildFields().add(child.get_Value());
    }

    private void clearResourceRecords() {
        getResourceRecords().clear();
    }

    /**
     * 
     * Get the ResourceRecords for the UI repesentation
     */
    public java.util.List getResourceRecordsForUI() {

        List result = new ArrayList();
        result.addAll(icResourceRecords);

        while (result.size() < MIN_TABLE_LENGTH) {
            try {
                org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl item = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl(
                        (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) adapter, bindingPrefix,
                        result.size());
                DataContainerUtil.setVisibilityOfFields(item, false);
                result.add(item);
            }
            catch (WbemsmtException e) {
                e.printStackTrace();
            }
        }

        resourceRecordsPanel.setList(result);

        return result;
    }

    /**
     * manages the style for whole footer which is displayed if there are no entries in the table or if there is a custom panel in it
     * @return
     */
    public String getResourceRecordsFooterClass() {
        return "multiLineRowHeader center "
                + (icResourceRecords.size() == 0
                        || getResourceRecordsPanel().isHavingCustomFooter() ? "visible "
                        : "hidden ");
    }

    /**
     * manages the style for the label which is displayed if there are no entries in the table
     * @return
     */
    public String getResourceRecordsAvailableFooterClass() {
        return icResourceRecords.size() > 0 ? " hidden " : " visible ";
    }

    private void addResourceRecordsHeader() {
        getResourceRecordsPanel().setHeader(getResourceRecordsHeaderComponents(),
                getResourceRecordsFieldNames());
    }

    private LabeledJSFInputComponent[] getResourceRecordsHeaderComponents() {
        return new LabeledJSFInputComponent[] {
                (LabeledJSFInputComponent) getResourceRecordsHeader_Name(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_Type(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_Value(), };
    }

    private String[] getResourceRecordsFieldNames() {
        return new String[] { "_Name", "_Type", "_Value", };
    }

    /**
     * Header for:
     * 
     * linked container DnsResourceRecordForReverseZoneWizardDataContainer
     */
    public org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainerHeader getResourceRecordsHeader() {
        return this;
    }

    /**
     * Header for field Name
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Name() {
        if (icResourceRecordsHeader_Name == null) {
            String label = bundle
                    .getString("DnsResourceRecordForReverseZoneWizardDataContainer.Name");
            String binding = bindingPrefix + "resourceRecordsHeader_Name.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = true;
            icResourceRecordsHeader_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent) icResourceRecordsHeader_Name)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent) icResourceRecordsHeader_Name)
                .setHeader(true);

        return icResourceRecordsHeader_Name;
    }

    /**
     * Header for field Type
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Type() {
        if (icResourceRecordsHeader_Type == null) {
            String label = bundle
                    .getString("DnsResourceRecordForReverseZoneWizardDataContainer.Type");
            String binding = bindingPrefix + "resourceRecordsHeader_Type.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = true;
            icResourceRecordsHeader_Type = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent) icResourceRecordsHeader_Type)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent) icResourceRecordsHeader_Type)
                .setHeader(true);

        return icResourceRecordsHeader_Type;
    }

    /**
     * Header for field Value
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Value() {
        if (icResourceRecordsHeader_Value == null) {
            String label = bundle
                    .getString("DnsResourceRecordForReverseZoneWizardDataContainer.Value");
            String binding = bindingPrefix + "resourceRecordsHeader_Value.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = true;
            icResourceRecordsHeader_Value = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent) icResourceRecordsHeader_Value)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent) icResourceRecordsHeader_Value)
                .setHeader(true);

        return icResourceRecordsHeader_Value;
    }

    public void reload() {
        super.reload();
        if (ic_usr_Name != null) {
            ic_usr_Name.setLabelText(bundle
                    .getString("DnsReverseZoneWizardSummaryDataContainer.name"));
        }
        if (ic_ResourceRecordFile != null) {
            ic_ResourceRecordFile.setLabelText(bundle
                    .getString("DnsReverseZoneWizardSummaryDataContainer.ResourceRecordFile"));
        }
    }

    public String[] getResourceBundleNames() {
        return new String[] { "messages", "messagesDns" };
    }

    public void countAndCreateChildren() throws WbemsmtException {

        try {
            int count = adapter
                    .count(
                            "resourceRecords",
                            org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer.class,
                            this);
            if (count != resourceRecordsCount) {
                resourceRecordsCount = count;
                clearResourceRecords();
                for (int i = 0; i < count; i++) {
                    addResourceRecords(new org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl(
                            (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) adapter,
                            bindingPrefix, i));
                }
            }
            getResourceRecordsPanel().setList(getResourceRecords());
        }
        catch (WbemsmtException e) {
            throw new WbemsmtException(WbemsmtException.ERR_INIT_CONTAINER, e);
        }
    }

    /**
     * count and create childrens
     * @throws WbemsmtException
     */
    public void updateControls() throws WbemsmtException {
        countAndCreateChildren();
        adapter.updateControls(this);

        getResourceRecordsPanel().updateRows();
    }

    /**
     * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
     * @return
     */
    public List getFields() {
        List fields = new ArrayList();
        fields.add(get_usr_Name());
        fields.add(get_ResourceRecordFile());
        return fields;
    }

    /**
     * Return a list of all associated childContainers. A childContainer is a DataContainer
     * @return
     */
    public List getChildContainers() {
        List childs = new ArrayList();
        childs.addAll(getResourceRecords());
        return childs;

    }

    public void copyFrom(DataContainer sourceContainer) throws WbemsmtException {
        DnsReverseZoneWizardSummaryDataContainerImpl source = (DnsReverseZoneWizardSummaryDataContainerImpl) sourceContainer;

        get_usr_Name().copyFrom(source.get_usr_Name());
        get_ResourceRecordFile().copyFrom(source.get_ResourceRecordFile());

        List targetListForResourceRecords = (List) getResourceRecords();
        List sourceListForResourceRecords = (List) source.getResourceRecords();
        if (sourceListForResourceRecords.size() != targetListForResourceRecords.size()) {
            throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                    "The Lists are not from same size. Source is "
                            + sourceListForResourceRecords.size() + " and target is "
                            + targetListForResourceRecords.size());
        }
        for (int ii = 0; ii < sourceListForResourceRecords.size(); ii++) {
            ((DataContainer) targetListForResourceRecords.get(ii))
                    .copyFrom(((DataContainer) sourceListForResourceRecords.get(ii)));
        }

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}