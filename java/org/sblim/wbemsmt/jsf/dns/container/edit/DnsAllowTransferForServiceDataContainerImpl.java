/** 
 * DnsAllowTransferForServiceDataContainerImpl.java
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
 * Description: Datacontainer for AllowTransfer of the service
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsAllowTransferForServiceDataContainerImpl extends
        org.sblim.wbemsmt.tools.jsf.EditBasePanel implements
        org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer {
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_AddressList;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveAddress;
    private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_UserAddresses;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewAddress;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddPredefinedAddress;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddNewAddress;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddressUp;
    private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddressDown;

    DnsAllowTransferForServiceDataContainerImplLayouter layouter = null;

    public DnsAllowTransferForServiceDataContainerImplLayouter getLayouter() {
        return layouter;
    }

    public DnsAllowTransferForServiceDataContainerImpl(
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter, String bindingPrefix)
            throws WbemsmtException {

        super(adapter, bindingPrefix, "DnsAllowTransferForServiceDataContainer.caption", false);

        layouter = new DnsAllowTransferForServiceDataContainerImplLayouter();
        //layout is done in the edit-method of the Editbean
        //layouter.layout(getPanelForCustomLayout(),this,bundle);

        setFooter(getPanelForCustomLayout(), "DnsAllowTransferForServiceDataContainer.footerText");
        adapter.initContainer(this);
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST_WITH_MULTISELECT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_AddressList() {
        if (ic_AddressList == null) {
            String label = bundle.getString("DnsAllowTransferForServiceDataContainer.AddressList");
            String binding = bindingPrefix + "_AddressList.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_AddressList = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_AddressList;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveAddress() {
        if (ic_usr_RemoveAddress == null) {
            String label = bundle
                    .getString("DnsAllowTransferForServiceDataContainer.removeAddress");
            String binding = bindingPrefix + "_usr_RemoveAddress.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_RemoveAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_usr_RemoveAddress;
    }

    /**
     * 
     * DataType UNSIGNED_INT16
     * UIType LIST_WITH_MULTISELECT
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_UserAddresses() {
        if (ic_usr_UserAddresses == null) {
            String label = bundle
                    .getString("DnsAllowTransferForServiceDataContainer.userAddresses");
            String binding = bindingPrefix + "_usr_UserAddresses.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
            boolean readOnly = false;
            ic_usr_UserAddresses = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_UserAddresses;
    }

    /**
     * 
     * DataType STRING
     * UIType TEXTFIELD
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewAddress() {
        if (ic_usr_NewAddress == null) {
            String label = bundle.getString("DnsAllowTransferForServiceDataContainer.newAddress");
            String binding = bindingPrefix + "_usr_NewAddress.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_NewAddress = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_NewAddress;
    }

    /**
     * Add the Adress selected in the userAddresses-ListBox
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddPredefinedAddress() {
        if (ic_usr_AddPredefinedAddress == null) {
            String label = bundle
                    .getString("DnsAllowTransferForServiceDataContainer.addPredefinedAddress");
            String binding = bindingPrefix + "_usr_AddPredefinedAddress.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_AddPredefinedAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(
                    parent, label, binding, converter, readOnly);
            ;
        }

        return ic_usr_AddPredefinedAddress;
    }

    /**
     * Add the Adress entered in the textField for a new Address
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddNewAddress() {
        if (ic_usr_AddNewAddress == null) {
            String label = bundle
                    .getString("DnsAllowTransferForServiceDataContainer.addNewAddress");
            String binding = bindingPrefix + "_usr_AddNewAddress.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_AddNewAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_usr_AddNewAddress;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddressUp() {
        if (ic_usr_AddressUp == null) {
            String label = bundle.getString("DnsAllowTransferForServiceDataContainer.addressUp");
            String binding = bindingPrefix + "_usr_AddressUp.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_AddressUp = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_usr_AddressUp;
    }

    /**
     * 
     * DataType ACTION
     * UIType BUTTON
     * ReadOnly false
     */

    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddressDown() {
        if (ic_usr_AddressDown == null) {
            String label = bundle.getString("DnsAllowTransferForServiceDataContainer.addressDown");
            String binding = bindingPrefix + "_usr_AddressDown.item";
            logger.fine("Using binding " + binding);
            org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
            org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
            boolean readOnly = false;
            ic_usr_AddressDown = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,
                    label, binding, converter, readOnly);
            ;
        }

        return ic_usr_AddressDown;
    }

    public void reload() {
        super.reload();
        if (ic_AddressList != null) {
            ic_AddressList.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.AddressList"));
        }
        if (ic_usr_RemoveAddress != null) {
            ic_usr_RemoveAddress.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.removeAddress"));
        }
        if (ic_usr_UserAddresses != null) {
            ic_usr_UserAddresses.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.userAddresses"));
        }
        if (ic_usr_NewAddress != null) {
            ic_usr_NewAddress.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.newAddress"));
        }
        if (ic_usr_AddPredefinedAddress != null) {
            ic_usr_AddPredefinedAddress.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.addPredefinedAddress"));
        }
        if (ic_usr_AddNewAddress != null) {
            ic_usr_AddNewAddress.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.addNewAddress"));
        }
        if (ic_usr_AddressUp != null) {
            ic_usr_AddressUp.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.addressUp"));
        }
        if (ic_usr_AddressDown != null) {
            ic_usr_AddressDown.setLabelText(bundle
                    .getString("DnsAllowTransferForServiceDataContainer.addressDown"));
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
        fields.add(get_AddressList());
        fields.add(get_usr_RemoveAddress());
        fields.add(get_usr_UserAddresses());
        fields.add(get_usr_NewAddress());
        fields.add(get_usr_AddPredefinedAddress());
        fields.add(get_usr_AddNewAddress());
        fields.add(get_usr_AddressUp());
        fields.add(get_usr_AddressDown());
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
        DnsAllowTransferForServiceDataContainerImpl source = (DnsAllowTransferForServiceDataContainerImpl) sourceContainer;

        get_AddressList().copyFrom(source.get_AddressList());
        get_usr_RemoveAddress().copyFrom(source.get_usr_RemoveAddress());
        get_usr_UserAddresses().copyFrom(source.get_usr_UserAddresses());
        get_usr_NewAddress().copyFrom(source.get_usr_NewAddress());
        get_usr_AddPredefinedAddress().copyFrom(source.get_usr_AddPredefinedAddress());
        get_usr_AddNewAddress().copyFrom(source.get_usr_AddNewAddress());
        get_usr_AddressUp().copyFrom(source.get_usr_AddressUp());
        get_usr_AddressDown().copyFrom(source.get_usr_AddressDown());

    }

    public boolean isModified() {
        return DataContainerUtil.isModified(this);
    }

}