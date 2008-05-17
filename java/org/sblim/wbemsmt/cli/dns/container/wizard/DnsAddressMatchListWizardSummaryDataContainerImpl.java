/** 
 * DnsAddressMatchListWizardSummaryDataContainerImpl.java
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
 * Description: Summary of AddressMatchList-Wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns.container.wizard;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsAddressMatchListWizardSummaryDataContainerImpl extends BaseDataContainer implements
        org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_AddressList;

    public DnsAddressMatchListWizardSummaryDataContainerImpl(AbstractBaseCimAdapter adapter)
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

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
        if (ic_Name == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsAddressMatchListWizardSummaryDataContainer.Name");
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            ic_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this, label,
                    "", converter);
        }
        return ic_Name;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST
     * ReadOnly true
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_AddressList() {
        if (ic_AddressList == null) {
            String label = getAdapter().getBundle().getString(
                    "DnsAddressMatchListWizardSummaryDataContainer.AddressList");
            org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
            ic_AddressList = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(
                    this, label, "", converter);
        }
        return ic_AddressList;
    }

    public void trace(java.io.PrintWriter printStream, String listOptions, boolean title) {
        if (title) {
            printStream.println(getAdapter().getBundle().getString(
                    "DnsAddressMatchListWizardSummaryDataContainer.caption"));
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
            if (get_AddressList().isVisible()) {
                Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf) get_AddressList())
                        .getValue();
                printStream.println(get_AddressList().getLabelText() + ": " + value);
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
        fields.add(get_Name());
        fields.add(get_AddressList());
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
        DnsAddressMatchListWizardSummaryDataContainerImpl source = (DnsAddressMatchListWizardSummaryDataContainerImpl) sourceContainer;

        get_Name().setValue(source.get_Name().getValue());
        get_AddressList().setValue(source.get_AddressList().getValue());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }
}