/** 
  * DnsResourceRecordWizardPage2TypeMxDataContainerImpl.java
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
  * @template: ./tools-dcg/templates/jsf/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: Page 2 of ResourceRecord-Wizard for defining MX-typed Records
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsResourceRecordWizardPage2TypeMxDataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Value;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Priority;
    	
		
	
	public DnsResourceRecordWizardPage2TypeMxDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

			
				super(adapter,bindingPrefix, "DnsResourceRecordWizardPage2TypeMxDataContainer.caption","DnsResourceRecordWizardPage2TypeMxDataContainer.subTitle",false);
				
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Value());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Priority());
        					
		setFooter(getPanelForCustomLayout(),"DnsResourceRecordWizardPage2TypeMxDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Value() {
    		if (ic_usr_Value == null)
    		{
				String label = bundle.getString("DnsResourceRecordWizardPage2TypeMxDataContainer.Value");
				String binding = bindingPrefix + "_usr_Value.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Value = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_usr_Value.setRequired(true);
				;
    		}
			
						
    		return ic_usr_Value;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Priority() {
    		if (ic_usr_Priority == null)
    		{
				String label = bundle.getString("DnsResourceRecordWizardPage2TypeMxDataContainer.Priority");
				String binding = bindingPrefix + "_usr_Priority.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Priority = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_usr_Priority.setRequired(true);
				;
    		}
			
						
    		return ic_usr_Priority;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_usr_Value != null)
    		{
				ic_usr_Value.setLabelText(bundle.getString("DnsResourceRecordWizardPage2TypeMxDataContainer.Value"));
    		}
	    		if (ic_usr_Priority != null)
    		{
				ic_usr_Priority.setLabelText(bundle.getString("DnsResourceRecordWizardPage2TypeMxDataContainer.Priority"));
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
    				fields.add(get_usr_Value());
    				fields.add(get_usr_Priority());
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
		DnsResourceRecordWizardPage2TypeMxDataContainerImpl source = (DnsResourceRecordWizardPage2TypeMxDataContainerImpl)sourceContainer;
	
    	    		get_usr_Value().setValue(source.get_usr_Value().getValue());
		    		get_usr_Priority().setValue(source.get_usr_Priority().getValue());
				
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}