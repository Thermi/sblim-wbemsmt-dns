/** 
 * DnsResourceRecordWizardSummaryDataContainerImpl.java
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
 * Description: Overview of the ResourceRecords wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns.container.wizard;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsResourceRecordWizardSummaryDataContainerImpl extends BaseDataContainer implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Type;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Value;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Priority;

    public DnsResourceRecordWizardSummaryDataContainerImpl(AbstractBaseCimAdapter adapter)
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
                    "DnsResourceRecordWizardSummaryDataContainer.Name");
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

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Type() {
        if (ic_usr_Type == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordWizardSummaryDataContainer.Type");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_Type = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_usr_Type;
    }

    /**
     * 
     * DataType STRING
     * UIType LABEL
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Value() {
        if (ic_usr_Value == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordWizardSummaryDataContainer.Value");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_Value = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_usr_Value;
    }

    /**
     * 
     * DataType STRING
     * UIType LABEL
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Priority() {
        if (ic_usr_Priority == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordWizardSummaryDataContainer.Priority");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_Priority = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, null, converter);
        }
        return ic_usr_Priority;
    }

    public void trace(java.io.PrintWriter printStream, String listOptions, boolean title) {
        if (title) {
            printStream.println(getAdapter().getBundle().getString(
                    "DnsResourceRecordWizardSummaryDataContainer.caption"));
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
            if (get_usr_Type().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_Type())
                        .getValue();
                printStream.println(get_usr_Type().getLabelText() + ": " + value);
            }
            if (get_usr_Value().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_Value())
                        .getValue();
                printStream.println(get_usr_Value().getLabelText() + ": " + value);
            }
            if (get_usr_Priority().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_Priority())
                        .getValue();
                printStream.println(get_usr_Priority().getLabelText() + ": " + value);
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
        fields.add(get_usr_Type());
        fields.add(get_usr_Value());
        fields.add(get_usr_Priority());
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
        DnsResourceRecordWizardSummaryDataContainerImpl source = (DnsResourceRecordWizardSummaryDataContainerImpl) sourceContainer;

        get_usr_Name().copyFrom(source.get_usr_Name());
        get_usr_Type().copyFrom(source.get_usr_Type());
        get_usr_Value().copyFrom(source.get_usr_Value());
        get_usr_Priority().copyFrom(source.get_usr_Priority());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }
}