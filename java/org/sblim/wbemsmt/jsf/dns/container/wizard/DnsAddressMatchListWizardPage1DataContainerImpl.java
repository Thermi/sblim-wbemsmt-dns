/** 
  * DnsAddressMatchListWizardPage1DataContainerImpl.java
  *

 
  * © Copyright IBM Corp. 2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE COMMON PUBLIC LICENSE
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
  * 
  * Description: Page 1 of AddressMatchList-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;




import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsAddressMatchListWizardPage1DataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_AddressList;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_UserAddresses;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddPredefinedAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddNewAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddressUp;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddressDown;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
    	
		
			DnsAddressMatchListWizardPage1DataContainerImplLayouter layouter = null;
		
		public DnsAddressMatchListWizardPage1DataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsAddressMatchListWizardPage1DataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

			
				super(adapter,bindingPrefix, "DnsAddressMatchListWizardPage1DataContainer.caption","DnsAddressMatchListWizardPage1DataContainer.subTitle",false);
				
				
		
				
    			
    				layouter = new DnsAddressMatchListWizardPage1DataContainerImplLayouter();
			//layout is done in the edit-method of the Editbean
			//layouter.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getPanelForCustomLayout(),"DnsAddressMatchListWizardPage1DataContainer.footerText");
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
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.AddressList");
				String binding = bindingPrefix + "_AddressList.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_AddressList = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_RemoveAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.removeAddress");
				String binding = bindingPrefix + "_usr_RemoveAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_UserAddresses == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.userAddresses");
				String binding = bindingPrefix + "_usr_UserAddresses.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_usr_UserAddresses = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_NewAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.newAddress");
				String binding = bindingPrefix + "_usr_NewAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_NewAddress = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddPredefinedAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addPredefinedAddress");
				String binding = bindingPrefix + "_usr_AddPredefinedAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddPredefinedAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddNewAddress == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addNewAddress");
				String binding = bindingPrefix + "_usr_AddNewAddress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddNewAddress = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddressUp == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addressUp");
				String binding = bindingPrefix + "_usr_AddressUp.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddressUp = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_AddressDown == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addressDown");
				String binding = bindingPrefix + "_usr_AddressDown.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddressDown = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_AddressDown;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
    		if (ic_Name == null)
    		{
				String label = bundle.getString("DnsAddressMatchListWizardPage1DataContainer.Name");
				String binding = bindingPrefix + "_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_Name.setRequired(true);
				;
    		}
			
						
    		return ic_Name;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_AddressList != null)
    		{
				ic_AddressList.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.AddressList"));
    		}
	    		if (ic_usr_RemoveAddress != null)
    		{
				ic_usr_RemoveAddress.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.removeAddress"));
    		}
	    		if (ic_usr_UserAddresses != null)
    		{
				ic_usr_UserAddresses.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.userAddresses"));
    		}
	    		if (ic_usr_NewAddress != null)
    		{
				ic_usr_NewAddress.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.newAddress"));
    		}
	    		if (ic_usr_AddPredefinedAddress != null)
    		{
				ic_usr_AddPredefinedAddress.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addPredefinedAddress"));
    		}
	    		if (ic_usr_AddNewAddress != null)
    		{
				ic_usr_AddNewAddress.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addNewAddress"));
    		}
	    		if (ic_usr_AddressUp != null)
    		{
				ic_usr_AddressUp.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addressUp"));
    		}
	    		if (ic_usr_AddressDown != null)
    		{
				ic_usr_AddressDown.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.addressDown"));
    		}
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsAddressMatchListWizardPage1DataContainer.Name"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	public void countAndCreateChildren() throws InitContainerException {
	
    		}


	/**
	 * count and create childrens
	 * @throws UpdateControlsException
	 */
	public void updateControls() throws UpdateControlsException {
		try {
			countAndCreateChildren();
			adapter.updateControls(this);
		
					} catch (InitContainerException e) {
			throw new UpdateControlsException(e);
		}
	}

	
 
	/**
	 * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
	 * @return
	 */
	public List getFields()
	{
		List fields = new ArrayList();
    				fields.add(get_AddressList());
    				fields.add(get_usr_RemoveAddress());
    				fields.add(get_usr_UserAddresses());
    				fields.add(get_usr_NewAddress());
    				fields.add(get_usr_AddPredefinedAddress());
    				fields.add(get_usr_AddNewAddress());
    				fields.add(get_usr_AddressUp());
    				fields.add(get_usr_AddressDown());
    				fields.add(get_Name());
    			return fields;
	}

	/**
	 * Return a list of all associated childContainers. A childContainer is a DataContainer
	 * @return
	 */
	public List getChildContainers()
	{
		List childs = new ArrayList();
    	    			return childs;
	
	}
	
	public void copyFrom(DataContainer sourceContainer)
	{
		DnsAddressMatchListWizardPage1DataContainerImpl source = (DnsAddressMatchListWizardPage1DataContainerImpl)sourceContainer;
	
    	    		get_AddressList().setValue(source.get_AddressList().getValue());
		    		get_usr_RemoveAddress().setValue(source.get_usr_RemoveAddress().getValue());
		    		get_usr_UserAddresses().setValue(source.get_usr_UserAddresses().getValue());
		    		get_usr_NewAddress().setValue(source.get_usr_NewAddress().getValue());
		    		get_usr_AddPredefinedAddress().setValue(source.get_usr_AddPredefinedAddress().getValue());
		    		get_usr_AddNewAddress().setValue(source.get_usr_AddNewAddress().getValue());
		    		get_usr_AddressUp().setValue(source.get_usr_AddressUp().getValue());
		    		get_usr_AddressDown().setValue(source.get_usr_AddressDown().getValue());
		    		get_Name().setValue(source.get_Name().getValue());
				
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}