/** 
 * DnsResourceRecordListContainerImpl.java
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
 * Description: Container with a List of ResourceRecords
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

//imports for that field of a linked container with occurence = MANY
import org.sblim.wbemsmt.tools.jsf.MultiLinePanel;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsResourceRecordListContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel
        implements org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer,
        org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainerHeader {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_SelectAll;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Delete;

    private java.util.List icResourceRecords = new java.util.ArrayList();

    private MultiLinePanel resourceRecordsPanel;
    private int resourceRecordsCount;

    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_DeleteRecord;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_TTL;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_TTLUnit;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_RemoveTTL;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Family;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Type;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Value;

    DnsResourceRecordListContainerImplLayouter layouter = null;

    public DnsResourceRecordListContainerImplLayouter getLayouter() {
        return layouter;
    }

    public DnsResourceRecordListContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsResourceRecordListContainer.caption", false);

        layouter = new DnsResourceRecordListContainerImplLayouter();
        //layout is done in the edit-method of the Editbean
        //layouter.layout(getPanelForCustomLayout(),this,bundle);

        setFooter(getPanelForCustomLayout(), "DnsResourceRecordListContainer.footerText");
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType BOOLEAN
     * UIType CHECKBOX_WITH_CLICKEVENT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_SelectAll() {
        if (ic_usr_SelectAll == null) {
            String label = bundle.getString("DnsResourceRecordListContainer.selectAll");
            String binding = bindingPrefix + "_usr_SelectAll.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_SelectAll = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxActionComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_SelectAll;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Delete() {
        if (ic_usr_Delete == null) {
            String label = bundle.getString("DnsResourceRecordListContainer.delete");
            String binding = bindingPrefix + "_usr_Delete.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_Delete = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent, label,
                    binding, converter, readOnly);
            ;
        }

        return ic_usr_Delete;
    }

    /**
     * 
     * linked container DnsResourceRecordListItemContainer
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
                    "DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainer.caption", //Key for title
                    org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl.COLS);
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
            return org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl.orientationOfColumnAsCss[column];
        }
    }

    private void addResourceRecords(
            org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl child) {

        getResourceRecords().add(child);
        getResourceRecordsPanel().addComponents(child.getComponents());

        //((LabeledJSFInputComponent)getResourceRecords_usr_DeleteRecordHeader()).getDependentChildFields().add(child.get_usr_DeleteRecord());
        //((LabeledJSFInputComponent)getResourceRecords_NameHeader()).getDependentChildFields().add(child.get_Name());
        //((LabeledJSFInputComponent)getResourceRecords_TTLHeader()).getDependentChildFields().add(child.get_TTL());
        //((LabeledJSFInputComponent)getResourceRecords_usr_TTLUnitHeader()).getDependentChildFields().add(child.get_usr_TTLUnit());
        //((LabeledJSFInputComponent)getResourceRecords_usr_RemoveTTLHeader()).getDependentChildFields().add(child.get_usr_RemoveTTL());
        //((LabeledJSFInputComponent)getResourceRecords_FamilyHeader()).getDependentChildFields().add(child.get_Family());
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
                org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl item = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl(
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
                (LabeledJSFInputComponent) getResourceRecordsHeader_usr_DeleteRecord(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_Name(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_TTL(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_usr_TTLUnit(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_usr_RemoveTTL(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_Family(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_Type(),
                (LabeledJSFInputComponent) getResourceRecordsHeader_Value(), };
    }

    private String[] getResourceRecordsFieldNames() {
        return new String[] { "_usr_DeleteRecord", "_Name", "_TTL", "_usr_TTLUnit",
                "_usr_RemoveTTL", "_Family", "_Type", "_Value", };
    }

    /**
     * Header for:
     * 
     * linked container DnsResourceRecordListItemContainer
     */
    public org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainerHeader getResourceRecordsHeader() {
        return this;
    }

    /**
     * Header for field deleteRecord
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_DeleteRecord() {
        if (icResourceRecordsHeader_usr_DeleteRecord == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.deleteRecord");
            String binding = bindingPrefix + "resourceRecordsHeader_usr_DeleteRecord.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_usr_DeleteRecord = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent) icResourceRecordsHeader_usr_DeleteRecord)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent) icResourceRecordsHeader_usr_DeleteRecord)
                .setHeader(true);

        return icResourceRecordsHeader_usr_DeleteRecord;
    }

    /**
     * Header for field Name
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Name() {
        if (icResourceRecordsHeader_Name == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.Name");
            String binding = bindingPrefix + "resourceRecordsHeader_Name.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent) icResourceRecordsHeader_Name)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent) icResourceRecordsHeader_Name)
                .setHeader(true);

        return icResourceRecordsHeader_Name;
    }

    /**
     * Header for field TTL
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_TTL() {
        if (icResourceRecordsHeader_TTL == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.TTL");
            String binding = bindingPrefix + "resourceRecordsHeader_TTL.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_TTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent) icResourceRecordsHeader_TTL)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent) icResourceRecordsHeader_TTL)
                .setHeader(true);

        return icResourceRecordsHeader_TTL;
    }

    /**
     * Header for field TTLUnit
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_TTLUnit() {
        if (icResourceRecordsHeader_usr_TTLUnit == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.TTLUnit");
            String binding = bindingPrefix + "resourceRecordsHeader_usr_TTLUnit.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent) icResourceRecordsHeader_usr_TTLUnit)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent) icResourceRecordsHeader_usr_TTLUnit)
                .setHeader(true);

        return icResourceRecordsHeader_usr_TTLUnit;
    }

    /**
     * Header for field removeTTL
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_RemoveTTL() {
        if (icResourceRecordsHeader_usr_RemoveTTL == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.removeTTL");
            String binding = bindingPrefix + "resourceRecordsHeader_usr_RemoveTTL.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent) icResourceRecordsHeader_usr_RemoveTTL)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent) icResourceRecordsHeader_usr_RemoveTTL)
                .setHeader(true);

        return icResourceRecordsHeader_usr_RemoveTTL;
    }

    /**
     * Header for field Family
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Family() {
        if (icResourceRecordsHeader_Family == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.Family");
            String binding = bindingPrefix + "resourceRecordsHeader_Family.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt8StringConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_Family = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent) icResourceRecordsHeader_Family)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent) icResourceRecordsHeader_Family)
                .setHeader(true);

        return icResourceRecordsHeader_Family;
    }

    /**
     * Header for field Type
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Type() {
        if (icResourceRecordsHeader_Type == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.Type");
            String binding = bindingPrefix + "resourceRecordsHeader_Type.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_Type = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent) icResourceRecordsHeader_Type)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent) icResourceRecordsHeader_Type)
                .setHeader(true);

        return icResourceRecordsHeader_Type;
    }

    /**
     * Header for field Value
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Value() {
        if (icResourceRecordsHeader_Value == null) {
            String label = bundle.getString("DnsResourceRecordListItemContainer.Value");
            String binding = bindingPrefix + "resourceRecordsHeader_Value.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            icResourceRecordsHeader_Value = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent) icResourceRecordsHeader_Value)
                    .setOrientation(org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf.LEFT);
        }
        ((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent) icResourceRecordsHeader_Value)
                .setHeader(true);

        return icResourceRecordsHeader_Value;
    }

    public void reload() {
        super.reload();
        if (ic_usr_SelectAll != null) {
            ic_usr_SelectAll.setLabelText(bundle
                    .getString("DnsResourceRecordListContainer.selectAll"));
        }
        if (ic_usr_Delete != null) {
            ic_usr_Delete.setLabelText(bundle.getString("DnsResourceRecordListContainer.delete"));
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
                            org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer.class,
                            this);
            if (count != resourceRecordsCount) {
                resourceRecordsCount = count;
                clearResourceRecords();
                for (int i = 0; i < count; i++) {
                    addResourceRecords(new org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl(
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
        fields.add(get_usr_SelectAll());
        fields.add(get_usr_Delete());
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
        DnsResourceRecordListContainerImpl source = (DnsResourceRecordListContainerImpl) sourceContainer;

        get_usr_SelectAll().copyFrom(source.get_usr_SelectAll());
        get_usr_Delete().copyFrom(source.get_usr_Delete());

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