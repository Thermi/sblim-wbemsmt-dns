/** 
 * DnsForwardZoneWizardSummaryDataContainerImpl.java
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
 * @template: org/sblim/wbemsmt/dcg/templates/cmd/containerImpl.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: Overview of wizard for forward zones
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns.container.wizard;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsForwardZoneWizardSummaryDataContainerImpl extends BaseDataContainer implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Forward;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;

    public DnsForwardZoneWizardSummaryDataContainerImpl(AbstractBaseCimAdapter adapter)
            throws WbemsmtException {
        super();
        setAdapter(adapter);
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
            String label = getAdapter().getBundle().getString(
                    "DnsForwardZoneWizardSummaryDataContainer.Name");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
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
            String label = getAdapter().getBundle().getString(
                    "DnsForwardZoneWizardSummaryDataContainer.Forward");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Forward = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
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
            String label = getAdapter().getBundle().getString(
                    "DnsForwardZoneWizardSummaryDataContainer.Forwarders");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
            ic_Forwarders = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, null, converter);
        }
        return ic_Forwarders;
    }

    public void trace(java.io.PrintWriter printStream, String listOptions, boolean title) {
        if (title) {
            printStream.println(getAdapter().getBundle().getString(
                    "DnsForwardZoneWizardSummaryDataContainer.caption"));
        }

        if (showKey(listOptions)) {
            String key = getKey() != null ? getKey().toString() : "-";
            printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
        }

        if (showInstance(listOptions)) {
            if (get_usr_Name().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_Name())
                        .getValue();
                printStream.println(get_usr_Name().getLabelText() + ": " + value);
            }
            if (get_Forward().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Forward())
                        .getValue();
                printStream.println(get_Forward().getLabelText() + ": " + value);
            }
            if (get_Forwarders().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Forwarders())
                        .getValue();
                printStream.println(get_Forwarders().getLabelText() + ": " + value);
            }
        }

        if (showChilds(listOptions)) {
            traceChilds(printStream, listOptions, title);
        }
    }

    public void traceChilds(java.io.PrintWriter printStream, String listOptions, boolean title) {

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