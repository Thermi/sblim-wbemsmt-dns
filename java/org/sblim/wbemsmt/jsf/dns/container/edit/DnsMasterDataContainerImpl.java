/** 
  * DnsMasterDataContainerImpl.java
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
  * Description: ${container.getDescription()}
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;

public class DnsMasterDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_MasterElementType;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_MasterElement;
    	
		
	
	public DnsMasterDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {
		super(adapter,bindingPrefix, "DnsMasterDataContainer.caption");
		
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Name());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_MasterElementType());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_MasterElement());
        					
		setFooter(getInputFieldContainer(),"DnsMasterDataContainer.footerText");
		adapter.initContainer(this);
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
				String label = bundle.getString("DnsMasterDataContainer.Name");
				String binding = bindingPrefix + "_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_Name;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_MasterElementType() {
    		if (ic_MasterElementType == null)
    		{
				String label = bundle.getString("DnsMasterDataContainer.MasterElementType");
				String binding = bindingPrefix + "_MasterElementType.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_MasterElementType = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_MasterElementType;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_MasterElement() {
    		if (ic_MasterElement == null)
    		{
				String label = bundle.getString("DnsMasterDataContainer.MasterElement");
				String binding = bindingPrefix + "_MasterElement.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_MasterElement = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_MasterElement;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsMasterDataContainer.Name"));
    		}
	    		if (ic_MasterElementType != null)
    		{
				ic_MasterElementType.setLabelText(bundle.getString("DnsMasterDataContainer.MasterElementType"));
    		}
	    		if (ic_MasterElement != null)
    		{
				ic_MasterElement.setLabelText(bundle.getString("DnsMasterDataContainer.MasterElement"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	
}