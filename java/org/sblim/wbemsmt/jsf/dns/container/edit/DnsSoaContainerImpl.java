/** 
  * DnsSoaContainerImpl.java
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
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;

public class DnsSoaContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Server;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Contact;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_SerialNumber;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Refresh;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Retry;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Expire;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_NegativeCachingTTL;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_SetSerialNumber;
    	
		
			DnsSoaContainerImplLayouter layouter = null;
		
		public DnsSoaContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsSoaContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsSoaContainer.caption");
				
				
    			
    				layouter = new DnsSoaContainerImplLayouter();//.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getInputFieldContainer(),"DnsSoaContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Server() {
    		if (ic_Server == null)
    		{
				String label = bundle.getString("DnsSoaContainer.Server");
				String binding = bindingPrefix + "_Server.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Server = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_Contact == null)
    		{
				String label = bundle.getString("DnsSoaContainer.Contact");
				String binding = bindingPrefix + "_Contact.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Contact = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_SerialNumber == null)
    		{
				String label = bundle.getString("DnsSoaContainer.SerialNumber");
				String binding = bindingPrefix + "_SerialNumber.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_SerialNumber = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_Refresh == null)
    		{
				String label = bundle.getString("DnsSoaContainer.Refresh");
				String binding = bindingPrefix + "_Refresh.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
				boolean readOnly = false;
    			ic_Refresh = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_Retry == null)
    		{
				String label = bundle.getString("DnsSoaContainer.Retry");
				String binding = bindingPrefix + "_Retry.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
				boolean readOnly = false;
    			ic_Retry = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_Expire == null)
    		{
				String label = bundle.getString("DnsSoaContainer.Expire");
				String binding = bindingPrefix + "_Expire.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
				boolean readOnly = false;
    			ic_Expire = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_NegativeCachingTTL == null)
    		{
				String label = bundle.getString("DnsSoaContainer.NegativeCachingTTL");
				String binding = bindingPrefix + "_NegativeCachingTTL.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_NegativeCachingTTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_TTLUnit == null)
    		{
				String label = bundle.getString("DnsSoaContainer.TTLUnit");
				String binding = bindingPrefix + "_usr_TTLUnit.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
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
    		if (ic_usr_SetSerialNumber == null)
    		{
				String label = bundle.getString("DnsSoaContainer.setSerialNumber");
				String binding = bindingPrefix + "_usr_SetSerialNumber.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_SetSerialNumber = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_usr_SetSerialNumber;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_Server != null)
    		{
				ic_Server.setLabelText(bundle.getString("DnsSoaContainer.Server"));
    		}
	    		if (ic_Contact != null)
    		{
				ic_Contact.setLabelText(bundle.getString("DnsSoaContainer.Contact"));
    		}
	    		if (ic_SerialNumber != null)
    		{
				ic_SerialNumber.setLabelText(bundle.getString("DnsSoaContainer.SerialNumber"));
    		}
	    		if (ic_Refresh != null)
    		{
				ic_Refresh.setLabelText(bundle.getString("DnsSoaContainer.Refresh"));
    		}
	    		if (ic_Retry != null)
    		{
				ic_Retry.setLabelText(bundle.getString("DnsSoaContainer.Retry"));
    		}
	    		if (ic_Expire != null)
    		{
				ic_Expire.setLabelText(bundle.getString("DnsSoaContainer.Expire"));
    		}
	    		if (ic_NegativeCachingTTL != null)
    		{
				ic_NegativeCachingTTL.setLabelText(bundle.getString("DnsSoaContainer.NegativeCachingTTL"));
    		}
	    		if (ic_usr_TTLUnit != null)
    		{
				ic_usr_TTLUnit.setLabelText(bundle.getString("DnsSoaContainer.TTLUnit"));
    		}
	    		if (ic_usr_SetSerialNumber != null)
    		{
				ic_usr_SetSerialNumber.setLabelText(bundle.getString("DnsSoaContainer.setSerialNumber"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	
}