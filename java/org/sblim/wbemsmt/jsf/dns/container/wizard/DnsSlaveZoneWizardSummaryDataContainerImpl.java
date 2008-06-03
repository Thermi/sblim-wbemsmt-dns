/** 
 * DnsSlaveZoneWizardSummaryDataContainerImpl.java
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
 * Description: Summary-Page of SlaveZone-Wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsSlaveZoneWizardSummaryDataContainerImpl extends
        org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_IpAdressses;

    public DnsSlaveZoneWizardSummaryDataContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsSlaveZoneWizardSummaryDataContainer.caption",
                "DnsSlaveZoneWizardSummaryDataContainer.subTitle", false);

        addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent) get_usr_Name());
        addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent) get_usr_IpAdressses());

        setFooter(getPanelForCustomLayout(), "DnsSlaveZoneWizardSummaryDataContainer.footerText");
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
            String label = bundle.getString("DnsSlaveZoneWizardSummaryDataContainer.Name");
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
     * DataType UNSIGNED_INT16
     * UIType LIST
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_IpAdressses() {
        if (ic_usr_IpAdressses == null) {
            String label = bundle.getString("DnsSlaveZoneWizardSummaryDataContainer.IpAdressses");
            String binding = bindingPrefix + "_usr_IpAdressses.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            boolean readOnly = true;
            ic_usr_IpAdressses = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFListComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_IpAdressses;
    }

    public void reload() {
        super.reload();
        if (ic_usr_Name != null) {
            ic_usr_Name.setLabelText(bundle
                    .getString("DnsSlaveZoneWizardSummaryDataContainer.Name"));
        }
        if (ic_usr_IpAdressses != null) {
            ic_usr_IpAdressses.setLabelText(bundle
                    .getString("DnsSlaveZoneWizardSummaryDataContainer.IpAdressses"));
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
        fields.add(get_usr_IpAdressses());
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
        DnsSlaveZoneWizardSummaryDataContainerImpl source = (DnsSlaveZoneWizardSummaryDataContainerImpl) sourceContainer;

        get_usr_Name().copyFrom(source.get_usr_Name());
        get_usr_IpAdressses().copyFrom(source.get_usr_IpAdressses());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}