/** 
  * DnsMasterZoneWizardPage1DataContainerImpl.java
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
  * Description: Main Page of the MasterzoneWizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

public class DnsMasterZoneWizardPage1DataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Server;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_IpAdress;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Contact;
    	
		
	
	public DnsMasterZoneWizardPage1DataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsMasterZoneWizardPage1DataContainer.caption","DnsMasterZoneWizardPage1DataContainer.subTitle");
				
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Name());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Server());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_IpAdress());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Contact());
        					
		setFooter(getInputFieldContainer(),"DnsMasterZoneWizardPage1DataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
    		if (ic_usr_Name == null)
    		{
				String label = bundle.getString("DnsMasterZoneWizardPage1DataContainer.Name");
				String binding = bindingPrefix + "_usr_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_usr_Name.setRequired(true);
				;
    		}
    		return ic_usr_Name;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Server() {
    		if (ic_usr_Server == null)
    		{
				String label = bundle.getString("DnsMasterZoneWizardPage1DataContainer.Server");
				String binding = bindingPrefix + "_usr_Server.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Server = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_usr_Server.setRequired(true);
				;
    		}
    		return ic_usr_Server;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_IpAdress() {
    		if (ic_usr_IpAdress == null)
    		{
				String label = bundle.getString("DnsMasterZoneWizardPage1DataContainer.IpAdress");
				String binding = bindingPrefix + "_usr_IpAdress.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_IpAdress = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_usr_IpAdress.setRequired(true);
				;
    		}
    		return ic_usr_IpAdress;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Contact() {
    		if (ic_usr_Contact == null)
    		{
				String label = bundle.getString("DnsMasterZoneWizardPage1DataContainer.Contact");
				String binding = bindingPrefix + "_usr_Contact.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Contact = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_usr_Contact.setRequired(true);
				;
    		}
    		return ic_usr_Contact;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_usr_Name != null)
    		{
				ic_usr_Name.setLabelText(bundle.getString("DnsMasterZoneWizardPage1DataContainer.Name"));
    		}
	    		if (ic_usr_Server != null)
    		{
				ic_usr_Server.setLabelText(bundle.getString("DnsMasterZoneWizardPage1DataContainer.Server"));
    		}
	    		if (ic_usr_IpAdress != null)
    		{
				ic_usr_IpAdress.setLabelText(bundle.getString("DnsMasterZoneWizardPage1DataContainer.IpAdress"));
    		}
	    		if (ic_usr_Contact != null)
    		{
				ic_usr_Contact.setLabelText(bundle.getString("DnsMasterZoneWizardPage1DataContainer.Contact"));
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
    				fields.add(get_usr_Name());
    				fields.add(get_usr_Server());
    				fields.add(get_usr_IpAdress());
    				fields.add(get_usr_Contact());
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

	
}