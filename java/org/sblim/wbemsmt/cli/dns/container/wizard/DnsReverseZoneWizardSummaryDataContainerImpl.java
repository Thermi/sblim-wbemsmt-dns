/** 
 * DnsReverseZoneWizardSummaryDataContainerImpl.java
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
 * Description: Summary of ReverseZone-Wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns.container.wizard;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsReverseZoneWizardSummaryDataContainerImpl extends BaseDataContainer
        implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer,
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainerHeader {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ResourceRecordFile;

    private java.util.List icResourceRecords = new java.util.ArrayList();

    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Type;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Value;

    public DnsReverseZoneWizardSummaryDataContainerImpl(AbstractBaseCimAdapter adapter)
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
                    "DnsReverseZoneWizardSummaryDataContainer.name");
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

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ResourceRecordFile() {
        if (ic_ResourceRecordFile == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsReverseZoneWizardSummaryDataContainer.ResourceRecordFile");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_ResourceRecordFile = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, null, converter);
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
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordForReverseZoneWizardDataContainer.Name");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            icResourceRecordsHeader_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_Name;
    }

    /**
     * Header for field Type
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Type() {
        if (icResourceRecordsHeader_Type == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordForReverseZoneWizardDataContainer.Type");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            icResourceRecordsHeader_Type = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_Type;
    }

    /**
     * Header for field Value
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Value() {
        if (icResourceRecordsHeader_Value == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordForReverseZoneWizardDataContainer.Value");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            icResourceRecordsHeader_Value = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_Value;
    }

    public void trace(java.io.PrintWriter printStream, String listOptions, boolean title) {
        if (title) {
            printStream.println(getAdapter().getBundle().getString(
                    "DnsReverseZoneWizardSummaryDataContainer.caption"));
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
            if (get_ResourceRecordFile().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_ResourceRecordFile())
                        .getValue();
                printStream.println(get_ResourceRecordFile().getLabelText() + ": " + value);
            }
        }

        if (showChilds(listOptions)) {
            traceChilds(printStream, listOptions, title);
        }
    }

    public void traceChilds(java.io.PrintWriter printStream, String listOptions, boolean title) {
        List listresourceRecords = getResourceRecords();
        printStream.println();
        printStream.println(getAdapter().getBundle().getString(
                "DnsReverseZoneWizardSummaryDataContainer.role.resourceRecords")
                + " "
                + getAdapter().getBundle().getString("items.found",
                        new Object[] { new Integer(listresourceRecords.size()) }));
        for (int i = 0; i < listresourceRecords.size(); i++) {
            BaseDataContainer child = (BaseDataContainer) listresourceRecords.get(i);
            printStream.println();
            printStream.println(getAdapter().getBundle().getString("item") + ": " + (i + 1) + " "
                    + getAdapter().getBundle().getString("of") + " " + listresourceRecords.size());
            child.trace(printStream, listOptions, false);
        }

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