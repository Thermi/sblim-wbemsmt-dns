/** 
  * DnsTTLDataContainerImpl.java
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
  * Description: Container for the fields needed to define TTL
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;

public class DnsTTLDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_TTL;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveTTL;
    	
		
	
	public DnsTTLDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {
		super(adapter,bindingPrefix, "DnsTTLDataContainer.caption");
		
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_TTL());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_TTLUnit());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_RemoveTTL());
        					
		setFooter(getInputFieldContainer(),"DnsTTLDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_TTL() {
    		if (ic_TTL == null)
    		{
				String label = bundle.getString("DnsTTLDataContainer.TTL");
				String binding = bindingPrefix + "_TTL.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_TTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_TTL;
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
				String label = bundle.getString("DnsTTLDataContainer.TTLUnit");
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

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveTTL() {
    		if (ic_usr_RemoveTTL == null)
    		{
				String label = bundle.getString("DnsTTLDataContainer.removeTTL");
				String binding = bindingPrefix + "_usr_RemoveTTL.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
    		}
    		return ic_usr_RemoveTTL;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_TTL != null)
    		{
				ic_TTL.setLabelText(bundle.getString("DnsTTLDataContainer.TTL"));
    		}
	    		if (ic_usr_TTLUnit != null)
    		{
				ic_usr_TTLUnit.setLabelText(bundle.getString("DnsTTLDataContainer.TTLUnit"));
    		}
	    		if (ic_usr_RemoveTTL != null)
    		{
				ic_usr_RemoveTTL.setLabelText(bundle.getString("DnsTTLDataContainer.removeTTL"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	
}