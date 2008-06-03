/** 
 * DnsForwardZoneWizardPage1DataContainerImpl.java
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
 * Description: Main Page of wizard for forward zones
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsForwardZoneWizardPage1DataContainerImpl extends
        org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardPage1DataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forward;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveForwarder;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewForwarder;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddForwarder;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_NewForwarderType;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_UseGlobalForwarders;

    DnsForwardZoneWizardPage1DataContainerImplLayouter layouter = null;

    public DnsForwardZoneWizardPage1DataContainerImplLayouter getLayouter() {
        return layouter;
    }

    public DnsForwardZoneWizardPage1DataContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsForwardZoneWizardPage1DataContainer.caption",
                "DnsForwardZoneWizardPage1DataContainer.subTitle", false);

        layouter = new DnsForwardZoneWizardPage1DataContainerImplLayouter();
        //layout is done in the edit-method of the Editbean
        //layouter.layout(getPanelForCustomLayout(),this,bundle);

        setFooter(getPanelForCustomLayout(), "DnsForwardZoneWizardPage1DataContainer.footerText");
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType UNSIGNED_INT8
     * UIType RADIOBUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forward() {
        if (ic_Forward == null) {
            String label = bundle.getString("DnsForwardZoneWizardPage1DataContainer.Forward");
            String binding = bindingPrefix + "_Forward.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt8StringConverter();
            boolean readOnly = false;
            ic_Forward = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFRadioButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_Forward;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST_WITH_MULTISELECT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forwarders() {
        if (ic_Forwarders == null) {
            String label = bundle.getString("DnsForwardZoneWizardPage1DataContainer.Forwarders");
            String binding = bindingPrefix + "_Forwarders.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_Forwarders = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_Forwarders;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveForwarder() {
        if (ic_usr_RemoveForwarder == null) {
            String label = bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.removeForwarder");
            String binding = bindingPrefix + "_usr_RemoveForwarder.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_RemoveForwarder = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_RemoveForwarder;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewForwarder() {
        if (ic_usr_NewForwarder == null) {
            String label = bundle.getString("DnsForwardZoneWizardPage1DataContainer.newForwarder");
            String binding = bindingPrefix + "_usr_NewForwarder.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_NewForwarder = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_NewForwarder;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddForwarder() {
        if (ic_usr_AddForwarder == null) {
            String label = bundle.getString("DnsForwardZoneWizardPage1DataContainer.addForwarder");
            String binding = bindingPrefix + "_usr_AddForwarder.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_AddForwarder = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_usr_AddForwarder;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType COMBOBOX
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_NewForwarderType() {
        if (ic_usr_NewForwarderType == null) {
            String label = bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.newForwarderType");
            String binding = bindingPrefix + "_usr_NewForwarderType.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_usr_NewForwarderType = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_NewForwarderType;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
        if (ic_usr_Name == null) {
            String label = bundle.getString("DnsForwardZoneWizardPage1DataContainer.Name");
            String binding = bindingPrefix + "_usr_Name.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ic_usr_Name.setRequired(true);
            ;
        }

        return ic_usr_Name;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_UseGlobalForwarders() {
        if (ic_usr_UseGlobalForwarders == null) {
            String label = bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.useGlobalForwarders");
            String binding = bindingPrefix + "_usr_UseGlobalForwarders.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_UseGlobalForwarders = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_UseGlobalForwarders;
    }

    public void reload() {
        super.reload();
        if (ic_Forward != null) {
            ic_Forward.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.Forward"));
        }
        if (ic_Forwarders != null) {
            ic_Forwarders.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.Forwarders"));
        }
        if (ic_usr_RemoveForwarder != null) {
            ic_usr_RemoveForwarder.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.removeForwarder"));
        }
        if (ic_usr_NewForwarder != null) {
            ic_usr_NewForwarder.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.newForwarder"));
        }
        if (ic_usr_AddForwarder != null) {
            ic_usr_AddForwarder.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.addForwarder"));
        }
        if (ic_usr_NewForwarderType != null) {
            ic_usr_NewForwarderType.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.newForwarderType"));
        }
        if (ic_usr_Name != null) {
            ic_usr_Name.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.Name"));
        }
        if (ic_usr_UseGlobalForwarders != null) {
            ic_usr_UseGlobalForwarders.setLabelText(bundle
                    .getString("DnsForwardZoneWizardPage1DataContainer.useGlobalForwarders"));
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
        fields.add(get_Forward());
        fields.add(get_Forwarders());
        fields.add(get_usr_RemoveForwarder());
        fields.add(get_usr_NewForwarder());
        fields.add(get_usr_AddForwarder());
        fields.add(get_usr_NewForwarderType());
        fields.add(get_usr_Name());
        fields.add(get_usr_UseGlobalForwarders());
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
        DnsForwardZoneWizardPage1DataContainerImpl source = (DnsForwardZoneWizardPage1DataContainerImpl) sourceContainer;

        get_Forward().copyFrom(source.get_Forward());
        get_Forwarders().copyFrom(source.get_Forwarders());
        get_usr_RemoveForwarder().copyFrom(source.get_usr_RemoveForwarder());
        get_usr_NewForwarder().copyFrom(source.get_usr_NewForwarder());
        get_usr_AddForwarder().copyFrom(source.get_usr_AddForwarder());
        get_usr_NewForwarderType().copyFrom(source.get_usr_NewForwarderType());
        get_usr_Name().copyFrom(source.get_usr_Name());
        get_usr_UseGlobalForwarders().copyFrom(source.get_usr_UseGlobalForwarders());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}