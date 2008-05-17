/** 
 * DnsHintZoneDataContainerImpl.java
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
 * Description: Container for DNSHintZones
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsHintZoneDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel
        implements org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_TTL;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveTTL;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ZoneFile;

    DnsHintZoneDataContainerImplLayouter layouter = null;

    public DnsHintZoneDataContainerImplLayouter getLayouter() {
        return layouter;
    }

    public DnsHintZoneDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,
            String bindingPrefix) throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsHintZoneDataContainer.caption", false);

        layouter = new DnsHintZoneDataContainerImplLayouter();
        //layout is done in the edit-method of the Editbean
        //layouter.layout(getPanelForCustomLayout(),this,bundle);

        setFooter(getPanelForCustomLayout(), "DnsHintZoneDataContainer.footerText");
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType STRING
     * UIType LABEL
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
        if (ic_Name == null) {
            String label = bundle.getString("DnsHintZoneDataContainer.Name");
            String binding = bindingPrefix + "_Name.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent, label,
                    binding, converter, readOnly);
            ;
        }

        return ic_Name;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_TTL() {
        if (ic_TTL == null) {
            String label = bundle.getString("DnsHintZoneDataContainer.TTL");
            String binding = bindingPrefix + "_TTL.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_TTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_TTL;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType COMBOBOX
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_TTLUnit() {
        if (ic_usr_TTLUnit == null) {
            String label = bundle.getString("DnsHintZoneDataContainer.TTLUnit");
            String binding = bindingPrefix + "_usr_TTLUnit.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_TTLUnit;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveTTL() {
        if (ic_usr_RemoveTTL == null) {
            String label = bundle.getString("DnsHintZoneDataContainer.removeTTL");
            String binding = bindingPrefix + "_usr_RemoveTTL.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_usr_RemoveTTL;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ZoneFile() {
        if (ic_ZoneFile == null) {
            String label = bundle.getString("DnsHintZoneDataContainer.ZoneFile");
            String binding = bindingPrefix + "_ZoneFile.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_ZoneFile = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_ZoneFile;
    }

    public void reload() {
        super.reload();
        if (ic_Name != null) {
            ic_Name.setLabelText(bundle.getString("DnsHintZoneDataContainer.Name"));
        }
        if (ic_TTL != null) {
            ic_TTL.setLabelText(bundle.getString("DnsHintZoneDataContainer.TTL"));
        }
        if (ic_usr_TTLUnit != null) {
            ic_usr_TTLUnit.setLabelText(bundle.getString("DnsHintZoneDataContainer.TTLUnit"));
        }
        if (ic_usr_RemoveTTL != null) {
            ic_usr_RemoveTTL.setLabelText(bundle.getString("DnsHintZoneDataContainer.removeTTL"));
        }
        if (ic_ZoneFile != null) {
            ic_ZoneFile.setLabelText(bundle.getString("DnsHintZoneDataContainer.ZoneFile"));
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
        fields.add(get_Name());
        fields.add(get_TTL());
        fields.add(get_usr_TTLUnit());
        fields.add(get_usr_RemoveTTL());
        fields.add(get_ZoneFile());
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
        DnsHintZoneDataContainerImpl source = (DnsHintZoneDataContainerImpl) sourceContainer;

        get_Name().setValue(source.get_Name().getValue());
        get_TTL().setValue(source.get_TTL().getValue());
        get_usr_TTLUnit().setValue(source.get_usr_TTLUnit().getValue());
        get_usr_RemoveTTL().setValue(source.get_usr_RemoveTTL().getValue());
        get_ZoneFile().setValue(source.get_ZoneFile().getValue());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}