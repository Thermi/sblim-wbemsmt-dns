/** 
 * DnsResourceRecordWizardPage1DataContainerImpl.java
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
 * Description: Main page of resourceRecord Wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsResourceRecordWizardPage1DataContainerImpl extends
        org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_Type;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;

    DnsResourceRecordWizardPage1DataContainerImplLayouter layouter = null;

    public DnsResourceRecordWizardPage1DataContainerImplLayouter getLayouter() {
        return layouter;
    }

    public DnsResourceRecordWizardPage1DataContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsResourceRecordWizardPage1DataContainer.caption",
                "DnsResourceRecordWizardPage1DataContainer.subTitle", false);

        layouter = new DnsResourceRecordWizardPage1DataContainerImplLayouter();
        //layout is done in the edit-method of the Editbean
        //layouter.layout(getPanelForCustomLayout(),this,bundle);

        setFooter(getPanelForCustomLayout(), "DnsResourceRecordWizardPage1DataContainer.footerText");
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType COMBOBOX
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_Type() {
        if (ic_usr_Type == null) {
            String label = bundle.getString("DnsResourceRecordWizardPage1DataContainer.Type");
            String binding = bindingPrefix + "_usr_Type.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_usr_Type = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,
                    label, binding, converter, readOnly);
            ic_usr_Type.setRequired(true);
            ;
        }

        return ic_usr_Type;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
        if (ic_usr_Name == null) {
            String label = bundle.getString("DnsResourceRecordWizardPage1DataContainer.Name");
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

    public void reload() {
        super.reload();
        if (ic_usr_Type != null) {
            ic_usr_Type.setLabelText(bundle
                    .getString("DnsResourceRecordWizardPage1DataContainer.Type"));
        }
        if (ic_usr_Name != null) {
            ic_usr_Name.setLabelText(bundle
                    .getString("DnsResourceRecordWizardPage1DataContainer.Name"));
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
        fields.add(get_usr_Type());
        fields.add(get_usr_Name());
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
        DnsResourceRecordWizardPage1DataContainerImpl source = (DnsResourceRecordWizardPage1DataContainerImpl) sourceContainer;

        get_usr_Type().copyFrom(source.get_usr_Type());
        get_usr_Name().copyFrom(source.get_usr_Name());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}