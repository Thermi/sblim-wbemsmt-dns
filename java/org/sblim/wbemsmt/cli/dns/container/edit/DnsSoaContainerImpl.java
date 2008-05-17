/** 
 * DnsSoaContainerImpl.java
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
 * Description: 
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns.container.edit;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsSoaContainerImpl extends BaseDataContainer implements
        org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Server;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Contact;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_SerialNumber;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Refresh;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Retry;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Expire;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_NegativeCachingTTL;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_SetSerialNumber;

    public DnsSoaContainerImpl(AbstractBaseCimAdapter adapter) throws WbemsmtException {
        super();
        setAdapter(adapter);
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Server() {
        if (ic_Server == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.Server");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Server = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, "", converter);
        }
        return ic_Server;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Contact() {
        if (ic_Contact == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.Contact");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Contact = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, "", converter);
        }
        return ic_Contact;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_SerialNumber() {
        if (ic_SerialNumber == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.SerialNumber");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_SerialNumber = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return ic_SerialNumber;
    }

    /**
     * 
     * DataType UNSIGNED_INT32
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Refresh() {
        if (ic_Refresh == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.Refresh");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
            ic_Refresh = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, "", converter);
        }
        return ic_Refresh;
    }

    /**
     * 
     * DataType UNSIGNED_INT32
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Retry() {
        if (ic_Retry == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.Retry");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
            ic_Retry = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, "", converter);
        }
        return ic_Retry;
    }

    /**
     * 
     * DataType UNSIGNED_INT32
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Expire() {
        if (ic_Expire == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.Expire");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
            ic_Expire = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,
                    label, "", converter);
        }
        return ic_Expire;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_NegativeCachingTTL() {
        if (ic_NegativeCachingTTL == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.NegativeCachingTTL");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_NegativeCachingTTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, "", converter);
        }
        return ic_NegativeCachingTTL;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType COMBOBOX
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_TTLUnit() {
        if (ic_usr_TTLUnit == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.TTLUnit");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
            ic_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, "", converter);
        }
        return ic_usr_TTLUnit;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_SetSerialNumber() {
        if (ic_usr_SetSerialNumber == null) {
            String label = getAdapter().getBundle().getString("DnsSoaContainer.setSerialNumber");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_SetSerialNumber = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(
                    this, label, "", converter);
        }
        return ic_usr_SetSerialNumber;
    }

    public void trace(java.io.PrintWriter printStream, String listOptions, boolean title) {
        if (title) {
            printStream.println(getAdapter().getBundle().getString("DnsSoaContainer.caption"));
        }

        if (showKey(listOptions)) {
            String key = getKey() != null ? getKey().toString() : "-";
            printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
        }

        if (showInstance(listOptions)) {
            if (get_Server().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Server())
                        .getValue();
                printStream.println(get_Server().getLabelText() + ": " + value);
            }
            if (get_Contact().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Contact())
                        .getValue();
                printStream.println(get_Contact().getLabelText() + ": " + value);
            }
            if (get_SerialNumber().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_SerialNumber())
                        .getValue();
                printStream.println(get_SerialNumber().getLabelText() + ": " + value);
            }
            if (get_Refresh().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Refresh())
                        .getValue();
                printStream.println(get_Refresh().getLabelText() + ": " + value);
            }
            if (get_Retry().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Retry())
                        .getValue();
                printStream.println(get_Retry().getLabelText() + ": " + value);
            }
            if (get_Expire().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Expire())
                        .getValue();
                printStream.println(get_Expire().getLabelText() + ": " + value);
            }
            if (get_NegativeCachingTTL().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_NegativeCachingTTL())
                        .getValue();
                printStream.println(get_NegativeCachingTTL().getLabelText() + ": " + value);
            }
            if (get_usr_TTLUnit().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_TTLUnit())
                        .getValue();
                printStream.println(get_usr_TTLUnit().getLabelText() + ": " + value);
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
        fields.add(get_Server());
        fields.add(get_Contact());
        fields.add(get_SerialNumber());
        fields.add(get_Refresh());
        fields.add(get_Retry());
        fields.add(get_Expire());
        fields.add(get_NegativeCachingTTL());
        fields.add(get_usr_TTLUnit());
        fields.add(get_usr_SetSerialNumber());
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
        DnsSoaContainerImpl source = (DnsSoaContainerImpl) sourceContainer;

        get_Server().setValue(source.get_Server().getValue());
        get_Contact().setValue(source.get_Contact().getValue());
        get_SerialNumber().setValue(source.get_SerialNumber().getValue());
        get_Refresh().setValue(source.get_Refresh().getValue());
        get_Retry().setValue(source.get_Retry().getValue());
        get_Expire().setValue(source.get_Expire().getValue());
        get_NegativeCachingTTL().setValue(source.get_NegativeCachingTTL().getValue());
        get_usr_TTLUnit().setValue(source.get_usr_TTLUnit().getValue());
        get_usr_SetSerialNumber().setValue(source.get_usr_SetSerialNumber().getValue());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }
}