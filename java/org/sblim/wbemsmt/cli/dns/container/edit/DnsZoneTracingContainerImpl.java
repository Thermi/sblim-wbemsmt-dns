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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: ./tools-dcg/templates/cmd/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: Container for Tracing a Zone
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.edit;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
//import org.sblim.wbemsmt.tools.converter.*;
//import org.sblim.wbemsmt.tools.converter.test.*;
//import org.sblim.wbemsmt.tools.input.*;
//import org.sblim.wbemsmt.tools.input.test.*;
import org.sblim.wbemsmt.tools.resources.*;
import org.sblim.wbemsmt.exception.*;

public class DnsZoneTracingContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer {

	protected static WbemSmtResourceBundle bundle = ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},Locale.getDefault());

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
		
	public DnsZoneTracingContainerImpl(AbstractBaseCimAdapter adapter) throws InitContainerException {
		super();
		setAdapter(adapter);
    	    	icAllowNotifyAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl(adapter);
    	    	icAllowQueryAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl(adapter);
    	    	icAllowTransferAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl(adapter);
    	    	icAllowUpdateAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl(adapter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_ResourceRecordFile = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_Contact = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
    			ic_Expire = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_Server = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_SerialNumber = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
    			ic_Retry = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
    			ic_Forward = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_Forwarders = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_MasterAddresses = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DoubleStringConverter();
    			ic_TTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			ic_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DoubleStringConverter();
    			ic_NegativeCaching_TTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			ic_usr_NegativeCaching_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
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

		
	public void trace(java.io.PrintStream printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(bundle.getString("DnsZoneTracingContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
						if (get_Name().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Name()).getValue();
				printStream.println(get_Name().getLabelText() + ": " + value);
			}
						if (get_ResourceRecordFile().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_ResourceRecordFile()).getValue();
				printStream.println(get_ResourceRecordFile().getLabelText() + ": " + value);
			}
						if (get_Contact().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Contact()).getValue();
				printStream.println(get_Contact().getLabelText() + ": " + value);
			}
						if (get_Expire().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Expire()).getValue();
				printStream.println(get_Expire().getLabelText() + ": " + value);
			}
						if (get_Server().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Server()).getValue();
				printStream.println(get_Server().getLabelText() + ": " + value);
			}
						if (get_SerialNumber().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_SerialNumber()).getValue();
				printStream.println(get_SerialNumber().getLabelText() + ": " + value);
			}
						if (get_Retry().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Retry()).getValue();
				printStream.println(get_Retry().getLabelText() + ": " + value);
			}
						if (get_Forward().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Forward()).getValue();
				printStream.println(get_Forward().getLabelText() + ": " + value);
			}
						if (get_Forwarders().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Forwarders()).getValue();
				printStream.println(get_Forwarders().getLabelText() + ": " + value);
			}
						if (get_usr_MasterAddresses().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_MasterAddresses()).getValue();
				printStream.println(get_usr_MasterAddresses().getLabelText() + ": " + value);
			}
						if (get_TTL().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_TTL()).getValue();
				printStream.println(get_TTL().getLabelText() + ": " + value);
			}
						if (get_TTLUnit().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_TTLUnit()).getValue();
				printStream.println(get_TTLUnit().getLabelText() + ": " + value);
			}
						if (get_NegativeCaching_TTL().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_NegativeCaching_TTL()).getValue();
				printStream.println(get_NegativeCaching_TTL().getLabelText() + ": " + value);
			}
						if (get_usr_NegativeCaching_TTLUnit().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_NegativeCaching_TTLUnit()).getValue();
				printStream.println(get_usr_NegativeCaching_TTLUnit().getLabelText() + ": " + value);
			}
					}

		if (showChilds(listOptions))
		{
			traceChilds(printStream,listOptions,title);
		}
	}
	
	public void traceChilds(java.io.PrintStream printStream, String listOptions, boolean title)
	{
    		        		printStream.println();
        		printStream.println(bundle.getString("DnsZoneTracingContainer.role.resourceRecords"));
        		List listresourceRecords = getResourceRecords();
        		for (int i = 0; i < listresourceRecords.size(); i++) {
        			BaseDataContainer child = (BaseDataContainer)listresourceRecords.get(i);
        			printStream.println();
        			printStream.println(bundle.getString("item") + ": " + (i+1) + " " + bundle.getString("of") + " " + listresourceRecords.size());
        			child.trace(printStream,listOptions,false);
        		}
    			
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl childallowNotifyAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl)getAllowNotifyAcl();
        		printStream.println();
        		printStream.println("allowNotifyAcl");
            	childallowNotifyAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl childallowQueryAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl)getAllowQueryAcl();
        		printStream.println();
        		printStream.println("allowQueryAcl");
            	childallowQueryAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl childallowTransferAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl)getAllowTransferAcl();
        		printStream.println();
        		printStream.println("allowTransferAcl");
            	childallowTransferAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl childallowUpdateAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl)getAllowUpdateAcl();
        		printStream.println();
        		printStream.println("allowUpdateAcl");
            	childallowUpdateAcl.trace(printStream,listOptions,false);
			
	}
	
}