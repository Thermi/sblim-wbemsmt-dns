/** 
 * DnsReverseZoneWizardPage1DataContainerImpl.java
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
 * Description: Page 1 of ReverseZone-Wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsReverseZoneWizardPage1DataContainerImpl extends
        org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_IpAddress;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_ResourceRecordUsed;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveResourceRecord;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_ResourceRecordNotUsed;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddResourceRecord;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddAllResourceRecords;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveAllResourceRecords;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_IpPresets;

    DnsReverseZoneWizardPage1DataContainerImplLayouter layouter = null;

    public DnsReverseZoneWizardPage1DataContainerImplLayouter getLayouter() {
        return layouter;
    }

    public DnsReverseZoneWizardPage1DataContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsReverseZoneWizardPage1DataContainer.caption",
                "DnsReverseZoneWizardPage1DataContainer.subTitle", false);

        layouter = new DnsReverseZoneWizardPage1DataContainerImplLayouter();
        //layout is done in the edit-method of the Editbean
        //layouter.layout(getPanelForCustomLayout(),this,bundle);

        setFooter(getPanelForCustomLayout(), "DnsReverseZoneWizardPage1DataContainer.footerText");
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_IpAddress() {
        if (ic_usr_IpAddress == null) {
            String label = bundle.getString("DnsReverseZoneWizardPage1DataContainer.ipAddress");
            String binding = bindingPrefix + "_usr_IpAddress.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_IpAddress = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_IpAddress;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST_WITH_MULTISELECT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_ResourceRecordUsed() {
        if (ic_usr_ResourceRecordUsed == null) {
            String label = bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.resourceRecordUsed");
            String binding = bindingPrefix + "_usr_ResourceRecordUsed.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_usr_ResourceRecordUsed = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_ResourceRecordUsed;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveResourceRecord() {
        if (ic_usr_RemoveResourceRecord == null) {
            String label = bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.removeResourceRecord");
            String binding = bindingPrefix + "_usr_RemoveResourceRecord.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_RemoveResourceRecord = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_RemoveResourceRecord;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST_WITH_MULTISELECT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_ResourceRecordNotUsed() {
        if (ic_usr_ResourceRecordNotUsed == null) {
            String label = bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.resourceRecordNotUsed");
            String binding = bindingPrefix + "_usr_ResourceRecordNotUsed.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_usr_ResourceRecordNotUsed = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_ResourceRecordNotUsed;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddResourceRecord() {
        if (ic_usr_AddResourceRecord == null) {
            String label = bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.addResourceRecord");
            String binding = bindingPrefix + "_usr_AddResourceRecord.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_AddResourceRecord = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_AddResourceRecord;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddAllResourceRecords() {
        if (ic_usr_AddAllResourceRecords == null) {
            String label = bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.addAllResourceRecords");
            String binding = bindingPrefix + "_usr_AddAllResourceRecords.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_AddAllResourceRecords = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_AddAllResourceRecords;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveAllResourceRecords() {
        if (ic_usr_RemoveAllResourceRecords == null) {
            String label = bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.removeAllResourceRecords");
            String binding = bindingPrefix + "_usr_RemoveAllResourceRecords.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_RemoveAllResourceRecords = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_RemoveAllResourceRecords;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType COMBOBOX_WITH_ONCHANGEEVENT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_IpPresets() {
        if (ic_usr_IpPresets == null) {
            String label = bundle.getString("DnsReverseZoneWizardPage1DataContainer.ipPresets");
            String binding = bindingPrefix + "_usr_IpPresets.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_usr_IpPresets = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxActionComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_IpPresets;
    }

    public void reload() {
        super.reload();
        if (ic_usr_IpAddress != null) {
            ic_usr_IpAddress.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.ipAddress"));
        }
        if (ic_usr_ResourceRecordUsed != null) {
            ic_usr_ResourceRecordUsed.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.resourceRecordUsed"));
        }
        if (ic_usr_RemoveResourceRecord != null) {
            ic_usr_RemoveResourceRecord.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.removeResourceRecord"));
        }
        if (ic_usr_ResourceRecordNotUsed != null) {
            ic_usr_ResourceRecordNotUsed.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.resourceRecordNotUsed"));
        }
        if (ic_usr_AddResourceRecord != null) {
            ic_usr_AddResourceRecord.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.addResourceRecord"));
        }
        if (ic_usr_AddAllResourceRecords != null) {
            ic_usr_AddAllResourceRecords.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.addAllResourceRecords"));
        }
        if (ic_usr_RemoveAllResourceRecords != null) {
            ic_usr_RemoveAllResourceRecords.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.removeAllResourceRecords"));
        }
        if (ic_usr_IpPresets != null) {
            ic_usr_IpPresets.setLabelText(bundle
                    .getString("DnsReverseZoneWizardPage1DataContainer.ipPresets"));
        }
    }

    public String[] getResourceBundleNames() {
        return new String[] { "messages", "messagesDns" };
    }

    public void countAndCreateChildren() throws WbemsmtException {

    }

    /**
     * count and create childrens
     * @throws WbemsmtException
     */
    public void updateControls() throws WbemsmtException {
        countAndCreateChildren();
        adapter.updateControls(this);

    }

    /**
     * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
     * @return
     */
    public List getFields() {
        List fields = new ArrayList();
        fields.add(get_usr_IpAddress());
        fields.add(get_usr_ResourceRecordUsed());
        fields.add(get_usr_RemoveResourceRecord());
        fields.add(get_usr_ResourceRecordNotUsed());
        fields.add(get_usr_AddResourceRecord());
        fields.add(get_usr_AddAllResourceRecords());
        fields.add(get_usr_RemoveAllResourceRecords());
        fields.add(get_usr_IpPresets());
        return fields;
    }

    /**
     * Return a list of all associated childContainers. A childContainer is a DataContainer
     * @return
     */
    public List getChildContainers() {
        List childs = new ArrayList();
        return childs;

    }

    public void copyFrom(DataContainer sourceContainer) throws WbemsmtException {
        DnsReverseZoneWizardPage1DataContainerImpl source = (DnsReverseZoneWizardPage1DataContainerImpl) sourceContainer;

        get_usr_IpAddress().copyFrom(source.get_usr_IpAddress());
        get_usr_ResourceRecordUsed().copyFrom(source.get_usr_ResourceRecordUsed());
        get_usr_RemoveResourceRecord().copyFrom(source.get_usr_RemoveResourceRecord());
        get_usr_ResourceRecordNotUsed().copyFrom(source.get_usr_ResourceRecordNotUsed());
        get_usr_AddResourceRecord().copyFrom(source.get_usr_AddResourceRecord());
        get_usr_AddAllResourceRecords().copyFrom(source.get_usr_AddAllResourceRecords());
        get_usr_RemoveAllResourceRecords().copyFrom(source.get_usr_RemoveAllResourceRecords());
        get_usr_IpPresets().copyFrom(source.get_usr_IpPresets());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}