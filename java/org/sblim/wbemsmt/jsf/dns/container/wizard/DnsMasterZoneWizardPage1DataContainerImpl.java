/** 
  * DnsMasterZoneWizardPage1DataContainerImpl.java
  *
  * 
  * Â© Copyright IBM Corp.  2009,2006,2007
  *
  * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/jsf/containerImpl.vm
  *
  * Contributors: 
  *   Prashanth Karnam<prkarnam@in.ibm.com>
  * 
  * Description: Main Page of the MasterzoneWizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;




import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsMasterZoneWizardPage1DataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsMasterZoneWizardPage1DataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Server;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_IpAdress;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Contact;

    	
		
	
	public DnsMasterZoneWizardPage1DataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String expressionPrefix) throws WbemsmtException  {

			
				super(adapter,expressionPrefix, "DnsMasterZoneWizardPage1DataContainer.caption","DnsMasterZoneWizardPage1DataContainer.subTitle",false);
				
				
		
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Name());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Server());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_IpAdress());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Contact());
        					
		setFooter(getPanelForCustomLayout(),"DnsMasterZoneWizardPage1DataContainer.footerText");
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
				String binding = expressionPrefix + "_usr_Name.item";
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
				String binding = expressionPrefix + "_usr_Server.item";
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
				String binding = expressionPrefix + "_usr_IpAdress.item";
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
				String binding = expressionPrefix + "_usr_Contact.item";
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

	public void countAndCreateChildren() throws WbemsmtException {
	
    		}


	/**
	 * count and create childrens
	 * @throws WbemsmtException
	 */
	public void updateControls() throws WbemsmtException {
			   countAndCreateChildren();
			   adapter.updateControls(this);
		
			   		}

	
 
	/**
	 * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
	 * @return
	 */
	public List<LabeledBaseInputComponentIf> getFields()
	{
		List<LabeledBaseInputComponentIf> fields = new ArrayList<LabeledBaseInputComponentIf>();
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
	public List<DataContainer> getChildContainers()
	{
		List<DataContainer> childs = new ArrayList<DataContainer>();
    	    			return childs;
	
	}
	
	public void copyFrom(DataContainer sourceContainer) throws WbemsmtException
	{
	    		       DnsMasterZoneWizardPage1DataContainerImpl source = (DnsMasterZoneWizardPage1DataContainerImpl)sourceContainer;
		    		    
    	    		   get_usr_Name().copyFrom(source.get_usr_Name());
		        		   get_usr_Server().copyFrom(source.get_usr_Server());
		        		   get_usr_IpAdress().copyFrom(source.get_usr_IpAdress());
		        		   get_usr_Contact().copyFrom(source.get_usr_Contact());
		    		
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}