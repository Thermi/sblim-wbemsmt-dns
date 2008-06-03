/** 
 * DnsZoneTracingContainerImpl.java
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
 * Description: Container for Tracing a Zone
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns.container.edit;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsZoneTracingContainerImpl extends BaseDataContainer implements
        org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer,
        org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainerHeader {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ResourceRecordFile;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Contact;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Expire;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Server;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_SerialNumber;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Retry;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Forward;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Forwarders;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_MasterAddresses;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_TTL;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_TTLUnit;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_NegativeCaching_TTL;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_NegativeCaching_TTLUnit;

    private java.util.List icResourceRecords = new java.util.ArrayList();

    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_TTL;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_TTLUnit;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_RemoveTTL;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Name;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Type;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Family;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Value;
    private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Priority;

    private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer icAllowNotifyAcl = null;
    private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer icAllowQueryAcl = null;
    private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer icAllowTransferAcl = null;
    private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer icAllowUpdateAcl = null;

    public DnsZoneTracingContainerImpl(AbstractBaseCimAdapter adapter) throws WbemsmtException {
        super();
        setAdapter(adapter);
        icAllowNotifyAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl(
                adapter);
        icAllowQueryAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl(
                adapter);
        icAllowTransferAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl(
                adapter);
        icAllowUpdateAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl(
                adapter);
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
        if (ic_Name == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.Name");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this, label,
                    null, converter);
        }
        return ic_Name;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ResourceRecordFile() {
        if (ic_ResourceRecordFile == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsZoneTracingContainer.ResourceRecordFile");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_ResourceRecordFile = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, null, converter);
        }
        return ic_ResourceRecordFile;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Contact() {
        if (ic_Contact == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.Contact");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Contact = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_Contact;
    }

    /**
     * 
     * DataType UNSIGNED_INT32
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Expire() {
        if (ic_Expire == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.Expire");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
            ic_Expire = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_Expire;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Server() {
        if (ic_Server == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.Server");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Server = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_Server;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_SerialNumber() {
        if (ic_SerialNumber == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsZoneTracingContainer.SerialNumber");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_SerialNumber = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, null, converter);
        }
        return ic_SerialNumber;
    }

    /**
     * 
     * DataType UNSIGNED_INT32
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Retry() {
        if (ic_Retry == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.Retry");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
            ic_Retry = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_Retry;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Forward() {
        if (ic_Forward == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.Forward");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
            ic_Forward = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_Forward;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Forwarders() {
        if (ic_Forwarders == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.Forwarders");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Forwarders = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, null, converter);
        }
        return ic_Forwarders;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_MasterAddresses() {
        if (ic_usr_MasterAddresses == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsZoneTracingContainer.masterAddresses");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_MasterAddresses = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, null, converter);
        }
        return ic_usr_MasterAddresses;
    }

    /**
     * 
     * DataType DOUBLE
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_TTL() {
        if (ic_TTL == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.TTL");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DoubleStringConverter();
            ic_TTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this, label,
                    null, converter);
        }
        return ic_TTL;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType COMBOBOX
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_TTLUnit() {
        if (ic_TTLUnit == null) {
            String label = getAdapter().getBundle().getString("DnsZoneTracingContainer.TTLUnit");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
            ic_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, null, converter);
        }
        return ic_TTLUnit;
    }

    /**
     * 
     * DataType DOUBLE
     * UIType TEXTFIELD
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_NegativeCaching_TTL() {
        if (ic_NegativeCaching_TTL == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsZoneTracingContainer.NegativeCaching_TTL");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DoubleStringConverter();
            ic_NegativeCaching_TTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, null, converter);
        }
        return ic_NegativeCaching_TTL;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType COMBOBOX
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_NegativeCaching_TTLUnit() {
        if (ic_usr_NegativeCaching_TTLUnit == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsZoneTracingContainer.NegativeCaching_TTLUnit");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
            ic_usr_NegativeCaching_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, null, converter);
        }
        return ic_usr_NegativeCaching_TTLUnit;
    }

    /**
     * 
     * linked container DnsResourceRecordDataContainer
     */
    public java.util.List getResourceRecords() {
        return icResourceRecords;
    }

    /**
     * Header for:
     * 
     * linked container DnsResourceRecordDataContainer
     */
    public org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainerHeader getResourceRecordsHeader() {
        return this;
    }

    /**
     * Header for field TTL
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_TTL() {
        if (icResourceRecordsHeader_TTL == null) {
            String label = getAdapter().getBundle().getString("DnsResourceRecordDataContainer.TTL");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            icResourceRecordsHeader_TTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_TTL;
    }

    /**
     * Header for field TTLUnit
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_TTLUnit() {
        if (icResourceRecordsHeader_usr_TTLUnit == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordDataContainer.TTLUnit");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
            icResourceRecordsHeader_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_usr_TTLUnit;
    }

    /**
     * Header for field removeTTL
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_RemoveTTL() {
        if (icResourceRecordsHeader_usr_RemoveTTL == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordDataContainer.removeTTL");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            icResourceRecordsHeader_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_usr_RemoveTTL;
    }

    /**
     * Header for field Name
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Name() {
        if (icResourceRecordsHeader_Name == null) {
            String label = getAdapter().getBundle()
                    .getString("DnsResourceRecordDataContainer.Name");
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
            String label = getAdapter().getBundle()
                    .getString("DnsResourceRecordDataContainer.Type");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
            icResourceRecordsHeader_Type = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_Type;
    }

    /**
     * Header for field Family
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Family() {
        if (icResourceRecordsHeader_Family == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordDataContainer.Family");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt8StringArrayConverter();
            icResourceRecordsHeader_Family = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_Family;
    }

    /**
     * Header for field Value
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Value() {
        if (icResourceRecordsHeader_Value == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordDataContainer.Value");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            icResourceRecordsHeader_Value = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_Value;
    }

    /**
     * Header for field Priority
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Priority() {
        if (icResourceRecordsHeader_Priority == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsResourceRecordDataContainer.Priority");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            icResourceRecordsHeader_Priority = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return icResourceRecordsHeader_Priority;
    }

    /**
     * 
     * linked container DnsAllowNotifyForZoneDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer getAllowNotifyAcl() {
        return icAllowNotifyAcl;
    }

    /**
     * 
     * linked container DnsAllowQueryForZoneDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer getAllowQueryAcl() {
        return icAllowQueryAcl;
    }

    /**
     * 
     * linked container DnsAllowTransferForZoneDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer getAllowTransferAcl() {
        return icAllowTransferAcl;
    }

    /**
     * 
     * linked container DnsAllowUpdateForZoneDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer getAllowUpdateAcl() {
        return icAllowUpdateAcl;
    }

    public void trace(java.io.PrintWriter printStream, String listOptions, boolean title) {
        if (title) {
            printStream.println(getAdapter().getBundle().getString(
                    "DnsZoneTracingContainer.caption"));
        }

        if (showKey(listOptions)) {
            String key = getKey() != null ? getKey().toString() : "-";
            printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
        }

        if (showInstance(listOptions)) {
            if (get_Name().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Name())
                        .getValue();
                printStream.println(get_Name().getLabelText() + ": " + value);
            }
            if (get_ResourceRecordFile().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_ResourceRecordFile())
                        .getValue();
                printStream.println(get_ResourceRecordFile().getLabelText() + ": " + value);
            }
            if (get_Contact().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Contact())
                        .getValue();
                printStream.println(get_Contact().getLabelText() + ": " + value);
            }
            if (get_Expire().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Expire())
                        .getValue();
                printStream.println(get_Expire().getLabelText() + ": " + value);
            }
            if (get_Server().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Server())
                        .getValue();
                printStream.println(get_Server().getLabelText() + ": " + value);
            }
            if (get_SerialNumber().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_SerialNumber())
                        .getValue();
                printStream.println(get_SerialNumber().getLabelText() + ": " + value);
            }
            if (get_Retry().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Retry())
                        .getValue();
                printStream.println(get_Retry().getLabelText() + ": " + value);
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
            if (get_usr_MasterAddresses().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_MasterAddresses())
                        .getValue();
                printStream.println(get_usr_MasterAddresses().getLabelText() + ": " + value);
            }
            if (get_TTL().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_TTL())
                        .getValue();
                printStream.println(get_TTL().getLabelText() + ": " + value);
            }
            if (get_TTLUnit().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_TTLUnit())
                        .getValue();
                printStream.println(get_TTLUnit().getLabelText() + ": " + value);
            }
            if (get_NegativeCaching_TTL().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_NegativeCaching_TTL())
                        .getValue();
                printStream.println(get_NegativeCaching_TTL().getLabelText() + ": " + value);
            }
            if (get_usr_NegativeCaching_TTLUnit().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_NegativeCaching_TTLUnit())
                        .getValue();
                printStream
                        .println(get_usr_NegativeCaching_TTLUnit().getLabelText() + ": " + value);
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
                "DnsZoneTracingContainer.role.resourceRecords")
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

        org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl childallowNotifyAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl) getAllowNotifyAcl();
        printStream.println();
        printStream.println("allowNotifyAcl");
        childallowNotifyAcl.trace(printStream, listOptions, false);

        org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl childallowQueryAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl) getAllowQueryAcl();
        printStream.println();
        printStream.println("allowQueryAcl");
        childallowQueryAcl.trace(printStream, listOptions, false);

        org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl childallowTransferAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl) getAllowTransferAcl();
        printStream.println();
        printStream.println("allowTransferAcl");
        childallowTransferAcl.trace(printStream, listOptions, false);

        org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl childallowUpdateAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl) getAllowUpdateAcl();
        printStream.println();
        printStream.println("allowUpdateAcl");
        childallowUpdateAcl.trace(printStream, listOptions, false);

    }

    /**
     * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
     * @return
     */
    public List getFields() {
        List fields = new ArrayList();
        fields.add(get_Name());
        fields.add(get_ResourceRecordFile());
        fields.add(get_Contact());
        fields.add(get_Expire());
        fields.add(get_Server());
        fields.add(get_SerialNumber());
        fields.add(get_Retry());
        fields.add(get_Forward());
        fields.add(get_Forwarders());
        fields.add(get_usr_MasterAddresses());
        fields.add(get_TTL());
        fields.add(get_TTLUnit());
        fields.add(get_NegativeCaching_TTL());
        fields.add(get_usr_NegativeCaching_TTLUnit());
        return fields;
    }

    /**
     * Return a list of all associated childContainers. A childContainer is a DataContainer
     * @return
     */
    public List getChildContainers() {
        List childs = new ArrayList();
        childs.addAll(getResourceRecords());
        childs.add(getAllowNotifyAcl());
        childs.add(getAllowQueryAcl());
        childs.add(getAllowTransferAcl());
        childs.add(getAllowUpdateAcl());
        return childs;

    }

    public void copyFrom(DataContainer sourceContainer) throws WbemsmtException {
        DnsZoneTracingContainerImpl source = (DnsZoneTracingContainerImpl) sourceContainer;

        get_Name().copyFrom(source.get_Name());
        get_ResourceRecordFile().copyFrom(source.get_ResourceRecordFile());
        get_Contact().copyFrom(source.get_Contact());
        get_Expire().copyFrom(source.get_Expire());
        get_Server().copyFrom(source.get_Server());
        get_SerialNumber().copyFrom(source.get_SerialNumber());
        get_Retry().copyFrom(source.get_Retry());
        get_Forward().copyFrom(source.get_Forward());
        get_Forwarders().copyFrom(source.get_Forwarders());
        get_usr_MasterAddresses().copyFrom(source.get_usr_MasterAddresses());
        get_TTL().copyFrom(source.get_TTL());
        get_TTLUnit().copyFrom(source.get_TTLUnit());
        get_NegativeCaching_TTL().copyFrom(source.get_NegativeCaching_TTL());
        get_usr_NegativeCaching_TTLUnit().copyFrom(source.get_usr_NegativeCaching_TTLUnit());

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

        getAllowNotifyAcl().copyFrom(source.getAllowNotifyAcl());
        getAllowQueryAcl().copyFrom(source.getAllowQueryAcl());
        getAllowTransferAcl().copyFrom(source.getAllowTransferAcl());
        getAllowUpdateAcl().copyFrom(source.getAllowUpdateAcl());
    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }
}