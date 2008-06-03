/** 
 * DnsForwardZoneWizardSummaryDataContainerImpl.java
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
 * Description: Overview of wizard for forward zones
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsForwardZoneWizardSummaryDataContainerImpl extends
        org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Forward;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;

    DnsForwardZoneWizardSummaryDataContainerImplLayouter layouter = null;

    public DnsForwardZoneWizardSummaryDataContainerImplLayouter getLayouter() {
        return layouter;
    }

    public DnsForwardZoneWizardSummaryDataContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsForwardZoneWizardSummaryDataContainer.caption",
                "DnsForwardZoneWizardSummaryDataContainer.subTitle", false);

        layouter = new DnsForwardZoneWizardSummaryDataContainerImplLayouter();
        //layout is done in the edit-method of the Editbean
        //layouter.layout(getPanelForCustomLayout(),this,bundle);

        setFooter(getPanelForCustomLayout(), "DnsForwardZoneWizardSummaryDataContainer.footerText");
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
            String label = bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Name");
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

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Forward() {
        if (ic_Forward == null) {
            String label = bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Forward");
            String binding = bindingPrefix + "_Forward.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = true;
            ic_Forward = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_Forward;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forwarders() {
        if (ic_Forwarders == null) {
            String label = bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Forwarders");
            String binding = bindingPrefix + "_Forwarders.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = true;
            ic_Forwarders = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFListComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_Forwarders;
    }

    public void reload() {
        super.reload();
        if (ic_usr_Name != null) {
            ic_usr_Name.setLabelText(bundle
                    .getString("DnsForwardZoneWizardSummaryDataContainer.Name"));
        }
        if (ic_Forward != null) {
            ic_Forward.setLabelText(bundle
                    .getString("DnsForwardZoneWizardSummaryDataContainer.Forward"));
        }
        if (ic_Forwarders != null) {
            ic_Forwarders.setLabelText(bundle
                    .getString("DnsForwardZoneWizardSummaryDataContainer.Forwarders"));
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
        fields.add(get_usr_Name());
        fields.add(get_Forward());
        fields.add(get_Forwarders());
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
        DnsForwardZoneWizardSummaryDataContainerImpl source = (DnsForwardZoneWizardSummaryDataContainerImpl) sourceContainer;

        get_usr_Name().copyFrom(source.get_usr_Name());
        get_Forward().copyFrom(source.get_Forward());
        get_Forwarders().copyFrom(source.get_Forwarders());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}