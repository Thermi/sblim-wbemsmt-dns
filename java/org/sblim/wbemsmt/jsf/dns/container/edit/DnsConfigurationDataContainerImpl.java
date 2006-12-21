/** 
  * DnsConfigurationDataContainerImpl.java
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
  * Description: Container for DNSService Configuration
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;

public class DnsConfigurationDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ConfigurationFile;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ConfigurationDirectory;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_PortNumber;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveDirectory;
    	
		
			DnsConfigurationDataContainerImplLayouter layouter = null;
		
		public DnsConfigurationDataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsConfigurationDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsConfigurationDataContainer.caption");
				
				
    			
    				layouter = new DnsConfigurationDataContainerImplLayouter();//.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getInputFieldContainer(),"DnsConfigurationDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ConfigurationFile() {
    		if (ic_ConfigurationFile == null)
    		{
				String label = bundle.getString("DnsConfigurationDataContainer.ConfigurationFile");
				String binding = bindingPrefix + "_ConfigurationFile.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_ConfigurationFile = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_ConfigurationFile;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ConfigurationDirectory() {
    		if (ic_ConfigurationDirectory == null)
    		{
				String label = bundle.getString("DnsConfigurationDataContainer.ConfigurationDirectory");
				String binding = bindingPrefix + "_ConfigurationDirectory.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_ConfigurationDirectory = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_ConfigurationDirectory;
    	}
			/**
		* 
		* DataType UNSIGNED_INT32
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_PortNumber() {
    		if (ic_PortNumber == null)
    		{
				String label = bundle.getString("DnsConfigurationDataContainer.PortNumber");
				String binding = bindingPrefix + "_PortNumber.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt32StringConverter();
				boolean readOnly = false;
    			ic_PortNumber = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_PortNumber;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveDirectory() {
    		if (ic_usr_RemoveDirectory == null)
    		{
				String label = bundle.getString("DnsConfigurationDataContainer.removeDirectory");
				String binding = bindingPrefix + "_usr_RemoveDirectory.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveDirectory = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_usr_RemoveDirectory;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_ConfigurationFile != null)
    		{
				ic_ConfigurationFile.setLabelText(bundle.getString("DnsConfigurationDataContainer.ConfigurationFile"));
    		}
	    		if (ic_ConfigurationDirectory != null)
    		{
				ic_ConfigurationDirectory.setLabelText(bundle.getString("DnsConfigurationDataContainer.ConfigurationDirectory"));
    		}
	    		if (ic_PortNumber != null)
    		{
				ic_PortNumber.setLabelText(bundle.getString("DnsConfigurationDataContainer.PortNumber"));
    		}
	    		if (ic_usr_RemoveDirectory != null)
    		{
				ic_usr_RemoveDirectory.setLabelText(bundle.getString("DnsConfigurationDataContainer.removeDirectory"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	
}