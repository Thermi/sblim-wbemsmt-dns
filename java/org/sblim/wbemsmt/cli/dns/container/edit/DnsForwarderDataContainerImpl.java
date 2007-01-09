/** 
  * DnsForwarderDataContainerImpl.java
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
  * Description: Container for the fields needed to define a forwarder
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

public class DnsForwarderDataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer {

	protected static WbemSmtResourceBundle bundle = ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},Locale.getDefault());

			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forward;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveForwarder;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewForwarder;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddForwarder;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_NewForwarderType;
    	
		
	public DnsForwarderDataContainerImpl(AbstractBaseCimAdapter adapter) throws InitContainerException {
		super();
		setAdapter(adapter);
    			adapter.initContainer(this);
	}

			/**
		* 
		* DataType UNSIGNED_INT8
		* UIType RADIOBUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forward() {
    		if (ic_Forward == null)
    		{
				String label = bundle.getString("DnsForwarderDataContainer.Forward");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt8StringArrayConverter();
    			ic_Forward = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
    		}
    		return ic_Forward;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST_WITH_MULTISELECT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forwarders() {
    		if (ic_Forwarders == null)
    		{
				String label = bundle.getString("DnsForwarderDataContainer.Forwarders");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
    			ic_Forwarders = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
    		}
    		return ic_Forwarders;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveForwarder() {
    		if (ic_usr_RemoveForwarder == null)
    		{
				String label = bundle.getString("DnsForwarderDataContainer.removeForwarder");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_RemoveForwarder = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,"",converter);
    		}
    		return ic_usr_RemoveForwarder;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewForwarder() {
    		if (ic_usr_NewForwarder == null)
    		{
				String label = bundle.getString("DnsForwarderDataContainer.newForwarder");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_NewForwarder = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_NewForwarder;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddForwarder() {
    		if (ic_usr_AddForwarder == null)
    		{
				String label = bundle.getString("DnsForwarderDataContainer.addForwarder");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_AddForwarder = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,"",converter);
    		}
    		return ic_usr_AddForwarder;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType COMBOBOX
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_NewForwarderType() {
    		if (ic_usr_NewForwarderType == null)
    		{
				String label = bundle.getString("DnsForwarderDataContainer.newForwarderType");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			ic_usr_NewForwarderType = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
    		}
    		return ic_usr_NewForwarderType;
    	}
		
	
		
	public void trace(java.io.PrintStream printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(bundle.getString("DnsForwarderDataContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
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
						if (get_usr_NewForwarder().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_NewForwarder()).getValue();
				printStream.println(get_usr_NewForwarder().getLabelText() + ": " + value);
			}
						if (get_usr_NewForwarderType().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_NewForwarderType()).getValue();
				printStream.println(get_usr_NewForwarderType().getLabelText() + ": " + value);
			}
					}

		if (showChilds(listOptions))
		{
			traceChilds(printStream,listOptions,title);
		}
	}
	
	public void traceChilds(java.io.PrintStream printStream, String listOptions, boolean title)
	{
    			
			
	}
	
}