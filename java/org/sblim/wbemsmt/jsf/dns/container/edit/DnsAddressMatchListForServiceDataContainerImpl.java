/** 
  * DnsAddressMatchListForServiceDataContainerImpl.java
  *

 
 * (C) Copyright IBM Corp. 2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE COMMON PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Common Public License from
  * http://www.opensource.org/licenses/cpl1.0.php
  *
  * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
  * @template: ./tools-dcg/templates/jsf/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: userdefined AddressMatchList
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;

public class DnsAddressMatchListForServiceDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_AddressList;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_UserAddresses;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddPredefinedAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddNewAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddressUp;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddressDown;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
    	
		
			DnsAddressMatchListForServiceDataContainerImplLayouter layouter = null;
		
		public DnsAddressMatchListForServiceDataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsAddressMatchListForServiceDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {
		super(adapter,bindingPrefix, "DnsAddressMatchListForServiceDataContainer.caption");
		
				
    			
    				layouter = new DnsAddressMatchListForServiceDataContainerImplLayouter();//.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getInputFieldContainer(),"DnsAddressMatchListForServiceDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST_WITH_MULTISELECT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_AddressList() {
    		if (ic_AddressList == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.AddressList");
				String binding = bindingPrefix + "_AddressList.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_AddressList = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_RemoveAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.removeAddress");
				String binding = bindingPrefix + "_usr_RemoveAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_UserAddresses == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.userAddresses");
				String binding = bindingPrefix + "_usr_UserAddresses.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_usr_UserAddresses = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_NewAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.newAddress");
				String binding = bindingPrefix + "_usr_NewAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_NewAddress = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddPredefinedAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.addPredefinedAddress");
				String binding = bindingPrefix + "_usr_AddPredefinedAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddPredefinedAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddNewAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.addNewAddress");
				String binding = bindingPrefix + "_usr_AddNewAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddNewAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddressUp == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.addressUp");
				String binding = bindingPrefix + "_usr_AddressUp.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddressUp = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddressDown == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.addressDown");
				String binding = bindingPrefix + "_usr_AddressDown.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddressDown = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_usr_AddressDown;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
    		if (ic_Name == null)
    		{
				String label = bundle.getString("DnsAddressMatchListForServiceDataContainer.Name");
				String binding = bindingPrefix + "_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_Name;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_AddressList != null)
    		{
				ic_AddressList.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.AddressList"));
    		}
	    		if (ic_usr_RemoveAddress != null)
    		{
				ic_usr_RemoveAddress.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.removeAddress"));
    		}
	    		if (ic_usr_UserAddresses != null)
    		{
				ic_usr_UserAddresses.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.userAddresses"));
    		}
	    		if (ic_usr_NewAddress != null)
    		{
				ic_usr_NewAddress.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.newAddress"));
    		}
	    		if (ic_usr_AddPredefinedAddress != null)
    		{
				ic_usr_AddPredefinedAddress.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.addPredefinedAddress"));
    		}
	    		if (ic_usr_AddNewAddress != null)
    		{
				ic_usr_AddNewAddress.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.addNewAddress"));
    		}
	    		if (ic_usr_AddressUp != null)
    		{
				ic_usr_AddressUp.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.addressUp"));
    		}
	    		if (ic_usr_AddressDown != null)
    		{
				ic_usr_AddressDown.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.addressDown"));
    		}
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsAddressMatchListForServiceDataContainer.Name"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	
}