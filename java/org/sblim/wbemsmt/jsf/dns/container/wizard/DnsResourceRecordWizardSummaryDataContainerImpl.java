/** 
  * DnsResourceRecordWizardSummaryDataContainerImpl.java
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
  * Description: Overview of the ResourceRecords wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;




import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsResourceRecordWizardSummaryDataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Type;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Value;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Priority;

    	
		
	
	public DnsResourceRecordWizardSummaryDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String expressionPrefix) throws WbemsmtException  {

			
				super(adapter,expressionPrefix, "DnsResourceRecordWizardSummaryDataContainer.caption","DnsResourceRecordWizardSummaryDataContainer.subTitle",false);
				
				
		
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Name());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Type());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Value());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Priority());
        					
		setFooter(getPanelForCustomLayout(),"DnsResourceRecordWizardSummaryDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
    		if (ic_usr_Name == null)
    		{
				String label = bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Name");
				String binding = expressionPrefix + "_usr_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_usr_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_Name;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Type() {
    		if (ic_usr_Type == null)
    		{
				String label = bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Type");
				String binding = expressionPrefix + "_usr_Type.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_usr_Type = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_Type;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Value() {
    		if (ic_usr_Value == null)
    		{
				String label = bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Value");
				String binding = expressionPrefix + "_usr_Value.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_usr_Value = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_Value;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Priority() {
    		if (ic_usr_Priority == null)
    		{
				String label = bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Priority");
				String binding = expressionPrefix + "_usr_Priority.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_usr_Priority = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_Priority;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_usr_Name != null)
    		{
				ic_usr_Name.setLabelText(bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Name"));
    		}
	    		if (ic_usr_Type != null)
    		{
				ic_usr_Type.setLabelText(bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Type"));
    		}
	    		if (ic_usr_Value != null)
    		{
				ic_usr_Value.setLabelText(bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Value"));
    		}
	    		if (ic_usr_Priority != null)
    		{
				ic_usr_Priority.setLabelText(bundle.getString("DnsResourceRecordWizardSummaryDataContainer.Priority"));
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
    				fields.add(get_usr_Type());
    				fields.add(get_usr_Value());
    				fields.add(get_usr_Priority());
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
	    		       DnsResourceRecordWizardSummaryDataContainerImpl source = (DnsResourceRecordWizardSummaryDataContainerImpl)sourceContainer;
		    		    
    	    		   get_usr_Name().copyFrom(source.get_usr_Name());
		        		   get_usr_Type().copyFrom(source.get_usr_Type());
		        		   get_usr_Value().copyFrom(source.get_usr_Value());
		        		   get_usr_Priority().copyFrom(source.get_usr_Priority());
		    		
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}