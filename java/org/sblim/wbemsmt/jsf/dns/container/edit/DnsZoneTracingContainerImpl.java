/** 
  * DnsZoneTracingContainerImpl.java
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
  * Description: Container for Tracing a Zone
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsZoneTracingContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer {

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
	
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer icAllowNotifyAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer icAllowQueryAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer icAllowTransferAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer icAllowUpdateAcl = null;
		
	
	public DnsZoneTracingContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsZoneTracingContainer.caption");
				
				String childBindingPrefix = null;
				
    				childBindingPrefix = this.bindingPrefix + "allowNotifyAcl.";
    		icAllowNotifyAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "allowQueryAcl.";
    		icAllowQueryAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "allowTransferAcl.";
    		icAllowTransferAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "allowUpdateAcl.";
    		icAllowUpdateAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Name());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_ResourceRecordFile());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Contact());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Expire());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Server());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_SerialNumber());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Retry());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Forward());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Forwarders());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_MasterAddresses());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_TTL());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_TTLUnit());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_NegativeCaching_TTL());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_NegativeCaching_TTLUnit());
        					
		setFooter(getInputFieldContainer(),"DnsZoneTracingContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
    		if (ic_Name == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.Name");
				String binding = bindingPrefix + "_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_ResourceRecordFile == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.ResourceRecordFile");
				String binding = bindingPrefix + "_ResourceRecordFile.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_ResourceRecordFile = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_Contact == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.Contact");
				String binding = bindingPrefix + "_Contact.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Contact = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_Expire == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.Expire");
				String binding = bindingPrefix + "_Expire.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
				boolean readOnly = true;
    			ic_Expire = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_Server == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.Server");
				String binding = bindingPrefix + "_Server.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Server = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_SerialNumber == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.SerialNumber");
				String binding = bindingPrefix + "_SerialNumber.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_SerialNumber = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_Retry == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.Retry");
				String binding = bindingPrefix + "_Retry.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
				boolean readOnly = true;
    			ic_Retry = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_Forward == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.Forward");
				String binding = bindingPrefix + "_Forward.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = true;
    			ic_Forward = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_Forwarders == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.Forwarders");
				String binding = bindingPrefix + "_Forwarders.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Forwarders = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_usr_MasterAddresses == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.masterAddresses");
				String binding = bindingPrefix + "_usr_MasterAddresses.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_usr_MasterAddresses = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_TTL == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.TTL");
				String binding = bindingPrefix + "_TTL.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DoubleStringConverter();
				boolean readOnly = true;
    			ic_TTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_TTLUnit == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.TTLUnit");
				String binding = bindingPrefix + "_TTLUnit.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = true;
    			ic_TTLUnit = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_NegativeCaching_TTL == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.NegativeCaching_TTL");
				String binding = bindingPrefix + "_NegativeCaching_TTL.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DoubleStringConverter();
				boolean readOnly = true;
    			ic_NegativeCaching_TTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
    		if (ic_usr_NegativeCaching_TTLUnit == null)
    		{
				String label = bundle.getString("DnsZoneTracingContainer.NegativeCaching_TTLUnit");
				String binding = bindingPrefix + "_usr_NegativeCaching_TTLUnit.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = true;
    			ic_usr_NegativeCaching_TTLUnit = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_usr_NegativeCaching_TTLUnit;
    	}
		
			
		/**
		* 
		* linked container DnsResourceRecordDataContainer
		*/
		public java.util.List getResourceRecords()
		{
			return icResourceRecords;
		}

	
			
		/**
		* 
		* linked container DnsAllowNotifyForZoneDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer getAllowNotifyAcl()
		{
			return icAllowNotifyAcl;
		}

			
		/**
		* 
		* linked container DnsAllowQueryForZoneDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer getAllowQueryAcl()
		{
			return icAllowQueryAcl;
		}

			
		/**
		* 
		* linked container DnsAllowTransferForZoneDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer getAllowTransferAcl()
		{
			return icAllowTransferAcl;
		}

			
		/**
		* 
		* linked container DnsAllowUpdateForZoneDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer getAllowUpdateAcl()
		{
			return icAllowUpdateAcl;
		}

		
	public void reload()
	{
		super.reload();
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsZoneTracingContainer.Name"));
    		}
	    		if (ic_ResourceRecordFile != null)
    		{
				ic_ResourceRecordFile.setLabelText(bundle.getString("DnsZoneTracingContainer.ResourceRecordFile"));
    		}
	    		if (ic_Contact != null)
    		{
				ic_Contact.setLabelText(bundle.getString("DnsZoneTracingContainer.Contact"));
    		}
	    		if (ic_Expire != null)
    		{
				ic_Expire.setLabelText(bundle.getString("DnsZoneTracingContainer.Expire"));
    		}
	    		if (ic_Server != null)
    		{
				ic_Server.setLabelText(bundle.getString("DnsZoneTracingContainer.Server"));
    		}
	    		if (ic_SerialNumber != null)
    		{
				ic_SerialNumber.setLabelText(bundle.getString("DnsZoneTracingContainer.SerialNumber"));
    		}
	    		if (ic_Retry != null)
    		{
				ic_Retry.setLabelText(bundle.getString("DnsZoneTracingContainer.Retry"));
    		}
	    		if (ic_Forward != null)
    		{
				ic_Forward.setLabelText(bundle.getString("DnsZoneTracingContainer.Forward"));
    		}
	    		if (ic_Forwarders != null)
    		{
				ic_Forwarders.setLabelText(bundle.getString("DnsZoneTracingContainer.Forwarders"));
    		}
	    		if (ic_usr_MasterAddresses != null)
    		{
				ic_usr_MasterAddresses.setLabelText(bundle.getString("DnsZoneTracingContainer.masterAddresses"));
    		}
	    		if (ic_TTL != null)
    		{
				ic_TTL.setLabelText(bundle.getString("DnsZoneTracingContainer.TTL"));
    		}
	    		if (ic_TTLUnit != null)
    		{
				ic_TTLUnit.setLabelText(bundle.getString("DnsZoneTracingContainer.TTLUnit"));
    		}
	    		if (ic_NegativeCaching_TTL != null)
    		{
				ic_NegativeCaching_TTL.setLabelText(bundle.getString("DnsZoneTracingContainer.NegativeCaching_TTL"));
    		}
	    		if (ic_usr_NegativeCaching_TTLUnit != null)
    		{
				ic_usr_NegativeCaching_TTLUnit.setLabelText(bundle.getString("DnsZoneTracingContainer.NegativeCaching_TTLUnit"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	
 
	/**
	 * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
	 * @return
	 */
	public List getFields()
	{
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
	public List getChildContainers()
	{
		List childs = new ArrayList();
    	    		childs.addAll(getResourceRecords());
    	    	    		childs.add(getAllowNotifyAcl());
		    		childs.add(getAllowQueryAcl());
		    		childs.add(getAllowTransferAcl());
		    		childs.add(getAllowUpdateAcl());
				return childs;
	
	}
	
	public void copyFrom(DataContainer sourceContainer)
	{
		DnsZoneTracingContainerImpl source = (DnsZoneTracingContainerImpl)sourceContainer;
	
    	    		get_Name().setValue(source.get_Name().getValue());
		    		get_ResourceRecordFile().setValue(source.get_ResourceRecordFile().getValue());
		    		get_Contact().setValue(source.get_Contact().getValue());
		    		get_Expire().setValue(source.get_Expire().getValue());
		    		get_Server().setValue(source.get_Server().getValue());
		    		get_SerialNumber().setValue(source.get_SerialNumber().getValue());
		    		get_Retry().setValue(source.get_Retry().getValue());
		    		get_Forward().setValue(source.get_Forward().getValue());
		    		get_Forwarders().setValue(source.get_Forwarders().getValue());
		    		get_usr_MasterAddresses().setValue(source.get_usr_MasterAddresses().getValue());
		    		get_TTL().setValue(source.get_TTL().getValue());
		    		get_TTLUnit().setValue(source.get_TTLUnit().getValue());
		    		get_NegativeCaching_TTL().setValue(source.get_NegativeCaching_TTL().getValue());
		    		get_usr_NegativeCaching_TTLUnit().setValue(source.get_usr_NegativeCaching_TTLUnit().getValue());
				
    	    		List targetListForResourceRecords = (List) getResourceRecords();
    		List sourceListForResourceRecords = (List) source.getResourceRecords();
    		if (sourceListForResourceRecords.size() != targetListForResourceRecords.size())
    		{
    			throw new IllegalArgumentException("The Lists are not from same size. Source is " + sourceListForResourceRecords.size() + " and target is " + targetListForResourceRecords.size() );
    		}
			for (int ii=0; ii < sourceListForResourceRecords.size(); ii++)
			{
				((DataContainer) targetListForResourceRecords.get(ii)).copyFrom(((DataContainer) sourceListForResourceRecords.get(ii)));
			}
			
    	    	    		getAllowNotifyAcl().copyFrom(source.getAllowNotifyAcl());
		    		getAllowQueryAcl().copyFrom(source.getAllowQueryAcl());
		    		getAllowTransferAcl().copyFrom(source.getAllowTransferAcl());
		    		getAllowUpdateAcl().copyFrom(source.getAllowUpdateAcl());
			}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}