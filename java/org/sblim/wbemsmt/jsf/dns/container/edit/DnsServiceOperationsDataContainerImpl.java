/** 
  * DnsServiceOperationsDataContainerImpl.java
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
  * Description: Container for Operations within DNS Service
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;

public class DnsServiceOperationsDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_RunAsRoot;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Restart;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_invoke_Start;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_invoke_Stop;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Status;
    	
		
	
	public DnsServiceOperationsDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsServiceOperationsDataContainer.caption");
				
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_RunAsRoot());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Restart());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_invoke_Start());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_invoke_Stop());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Status());
        					
		setFooter(getInputFieldContainer(),"DnsServiceOperationsDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType BOOLEAN
		* UIType CHECKBOX
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_RunAsRoot() {
    		if (ic_RunAsRoot == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.RunAsRoot");
				String binding = bindingPrefix + "_RunAsRoot.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_RunAsRoot = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_RunAsRoot;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Restart() {
    		if (ic_usr_Restart == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.restart");
				String binding = bindingPrefix + "_usr_Restart.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Restart = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_usr_Restart;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Start() {
    		if (ic_invoke_Start == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.start");
				String binding = bindingPrefix + "_invoke_Start.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_invoke_Start = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_invoke_Start;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Stop() {
    		if (ic_invoke_Stop == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.stop");
				String binding = bindingPrefix + "_invoke_Stop.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_invoke_Stop = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_invoke_Stop;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Status() {
    		if (ic_Status == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.Status");
				String binding = bindingPrefix + "_Status.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Status = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_Status;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_RunAsRoot != null)
    		{
				ic_RunAsRoot.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.RunAsRoot"));
    		}
	    		if (ic_usr_Restart != null)
    		{
				ic_usr_Restart.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.restart"));
    		}
	    		if (ic_invoke_Start != null)
    		{
				ic_invoke_Start.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.start"));
    		}
	    		if (ic_invoke_Stop != null)
    		{
				ic_invoke_Stop.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.stop"));
    		}
	    		if (ic_Status != null)
    		{
				ic_Status.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.Status"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	
}