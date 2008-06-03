/** 
 * DnsMastersForServiceDataContainerImpl.java
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
 * Description: userdefined Masters
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns.container.edit;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsMastersForServiceDataContainerImpl extends BaseDataContainer implements
        org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Masters;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveMasterEntry;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewMasterEntry;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddNewMasterEntry;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddPredefinedMaster;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_PredefinedMasters;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;

    public DnsMastersForServiceDataContainerImpl(AbstractBaseCimAdapter adapter)
            throws WbemsmtException {
        super();
        setAdapter(adapter);
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST_WITH_MULTISELECT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Masters() {
        if (ic_Masters == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.masters");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
            ic_Masters = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, null, converter);
        }
        return ic_Masters;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveMasterEntry() {
        if (ic_usr_RemoveMasterEntry == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.removeMasterEntry");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_RemoveMasterEntry = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(
                    this, label, null, converter);
        }
        return ic_usr_RemoveMasterEntry;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewMasterEntry() {
        if (ic_usr_NewMasterEntry == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.newMasterEntry");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_NewMasterEntry = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(
                    this, label, null, converter);
        }
        return ic_usr_NewMasterEntry;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddNewMasterEntry() {
        if (ic_usr_AddNewMasterEntry == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.addNewMasterEntry");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_AddNewMasterEntry = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(
                    this, label, null, converter);
        }
        return ic_usr_AddNewMasterEntry;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddPredefinedMaster() {
        if (ic_usr_AddPredefinedMaster == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.addPredefinedMaster");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_usr_AddPredefinedMaster = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(
                    this, label, null, converter);
        }
        return ic_usr_AddPredefinedMaster;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST_WITH_MULTISELECT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_PredefinedMasters() {
        if (ic_usr_PredefinedMasters == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.predefinedMasters");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
            ic_usr_PredefinedMasters = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, null, converter);
        }
        return ic_usr_PredefinedMasters;
    }

    /**
     * 
     * DataType STRING
     * UIType LABEL
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
        if (ic_Name == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.Name");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this, label,
                    null, converter);
        }
        return ic_Name;
    }

    public void trace(java.io.PrintWriter printStream, String listOptions, boolean title) {
        if (title) {
            printStream.println(getAdapter().getBundle().getString(
                    "DnsMastersForServiceDataContainer.caption"));
        }

        if (showKey(listOptions)) {
            String key = getKey() != null ? getKey().toString() : "-";
            printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
        }

        if (showInstance(listOptions)) {
            if (get_Masters().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Masters())
                        .getValue();
                printStream.println(get_Masters().getLabelText() + ": " + value);
            }
            if (get_usr_NewMasterEntry().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_NewMasterEntry())
                        .getValue();
                printStream.println(get_usr_NewMasterEntry().getLabelText() + ": " + value);
            }
            if (get_usr_PredefinedMasters().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_usr_PredefinedMasters())
                        .getValue();
                printStream.println(get_usr_PredefinedMasters().getLabelText() + ": " + value);
            }
            if (get_Name().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_Name())
                        .getValue();
                printStream.println(get_Name().getLabelText() + ": " + value);
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
        fields.add(get_Masters());
        fields.add(get_usr_RemoveMasterEntry());
        fields.add(get_usr_NewMasterEntry());
        fields.add(get_usr_AddNewMasterEntry());
        fields.add(get_usr_AddPredefinedMaster());
        fields.add(get_usr_PredefinedMasters());
        fields.add(get_Name());
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
        DnsMastersForServiceDataContainerImpl source = (DnsMastersForServiceDataContainerImpl) sourceContainer;

        get_Masters().copyFrom(source.get_Masters());
        get_usr_RemoveMasterEntry().copyFrom(source.get_usr_RemoveMasterEntry());
        get_usr_NewMasterEntry().copyFrom(source.get_usr_NewMasterEntry());
        get_usr_AddNewMasterEntry().copyFrom(source.get_usr_AddNewMasterEntry());
        get_usr_AddPredefinedMaster().copyFrom(source.get_usr_AddPredefinedMaster());
        get_usr_PredefinedMasters().copyFrom(source.get_usr_PredefinedMasters());
        get_Name().copyFrom(source.get_Name());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }
}