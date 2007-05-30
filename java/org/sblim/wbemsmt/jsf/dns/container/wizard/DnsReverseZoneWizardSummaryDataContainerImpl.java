/** 
  * DnsReverseZoneWizardSummaryDataContainerImpl.java
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
  * @template: org/sblim/wbemsmt/dcg/templates/jsf/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: Summary of ReverseZone-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

//imports for that field of a linked container with occurence = MANY
import org.sblim.wbemsmt.tools.jsf.MultiLinePanel;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsReverseZoneWizardSummaryDataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ResourceRecordFile;
    			
				private java.util.List icResourceRecords = new java.util.ArrayList();
		
		private MultiLinePanel resourceRecordsPanel;

				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_NameHeader;
				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_TypeHeader;
				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_ValueHeader;
				
	
		
	
	public DnsReverseZoneWizardSummaryDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

			
				super(adapter,bindingPrefix, "DnsReverseZoneWizardSummaryDataContainer.caption","DnsReverseZoneWizardSummaryDataContainer.subTitle",false);
				
				
		
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Name());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_ResourceRecordFile());
        					
		setFooter(getPanelForCustomLayout(),"DnsReverseZoneWizardSummaryDataContainer.footerText");
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
				String label = bundle.getString("DnsReverseZoneWizardSummaryDataContainer.name");
				String binding = bindingPrefix + "_usr_Name.item";
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

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ResourceRecordFile() {
    		if (ic_ResourceRecordFile == null)
    		{
				String label = bundle.getString("DnsReverseZoneWizardSummaryDataContainer.ResourceRecordFile");
				String binding = bindingPrefix + "_ResourceRecordFile.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_ResourceRecordFile = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_ResourceRecordFile;
    	}
		
			
				
		/**
		* 
		* linked container DnsResourceRecordForReverseZoneWizardDataContainer
		*/
		public java.util.List getResourceRecords()
		{
						return icResourceRecords;
		}
		
		public MultiLinePanel getResourceRecordsPanel()
		{
			if (resourceRecordsPanel == null)
			{
  			   resourceRecordsPanel = new ResourceRecordsPanel(adapter,bindingPrefix, // the prefix for binding values
							  "#{" +  bindingPrefix + "resourceRecordsPanel", // binding for Title
							  "DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainer.caption", //Key for title
							  org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl.COLS);
			}		
			
			return resourceRecordsPanel;
		}

		static class ResourceRecordsPanel extends MultiLinePanel
		{
			public ResourceRecordsPanel(AbstractBaseCimAdapter adapter, String bindingPrefix, String bindigForTitle, String keyForTitle, int cols) {
				super(adapter, bindingPrefix, bindigForTitle, keyForTitle, cols);
			}
	
			protected String getOrientationOfColumnAsCss(int column) {
				return org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl.orientationOfColumnAsCss[column];
			}
		}

	public void addResourceRecords(org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl child) {

		getResourceRecords().add(child);
		getResourceRecordsPanel().addComponents(child.getComponents());
		
					((LabeledJSFInputComponent)getResourceRecords_NameHeader()).getDependentChildFields().add(child.get_Name());
					((LabeledJSFInputComponent)getResourceRecords_TypeHeader()).getDependentChildFields().add(child.get_Type());
					((LabeledJSFInputComponent)getResourceRecords_ValueHeader()).getDependentChildFields().add(child.get_Value());
		
		
	}

	public void clearResourceRecords() {
		getResourceRecords().clear();
		getResourceRecordsPanel().getInputFieldContainer().getChildren().clear();
					((LabeledJSFInputComponent)getResourceRecords_NameHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_TypeHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_ValueHeader()).getDependentChildFields().clear();
			}

	public void addResourceRecordsHeader() {
		getResourceRecordsPanel().setHeader(getResourceRecordsHeaderComponents());
	}
	
	private LabeledJSFInputComponent[] getResourceRecordsHeaderComponents() {
		return new LabeledJSFInputComponent[]{
							(LabeledJSFInputComponent)getResourceRecords_NameHeader(),
							(LabeledJSFInputComponent)getResourceRecords_TypeHeader(),
							(LabeledJSFInputComponent)getResourceRecords_ValueHeader(),
						};
	}

			/**
   		 * Header for field Name
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_NameHeader() {
    		if (icResourceRecords_NameHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Name");
				String binding = bindingPrefix + "resourceRecords_NameHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			icResourceRecords_NameHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)icResourceRecords_NameHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)icResourceRecords_NameHeader).setHeader(true);
			
    		return icResourceRecords_NameHeader;
    	}
			/**
   		 * Header for field Type
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_TypeHeader() {
    		if (icResourceRecords_TypeHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Type");
				String binding = bindingPrefix + "resourceRecords_TypeHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			icResourceRecords_TypeHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)icResourceRecords_TypeHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)icResourceRecords_TypeHeader).setHeader(true);
			
    		return icResourceRecords_TypeHeader;
    	}
			/**
   		 * Header for field Value
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_ValueHeader() {
    		if (icResourceRecords_ValueHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Value");
				String binding = bindingPrefix + "resourceRecords_ValueHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			icResourceRecords_ValueHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)icResourceRecords_ValueHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)icResourceRecords_ValueHeader).setHeader(true);
			
    		return icResourceRecords_ValueHeader;
    	}
	
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_usr_Name != null)
    		{
				ic_usr_Name.setLabelText(bundle.getString("DnsReverseZoneWizardSummaryDataContainer.name"));
    		}
	    		if (ic_ResourceRecordFile != null)
    		{
				ic_ResourceRecordFile.setLabelText(bundle.getString("DnsReverseZoneWizardSummaryDataContainer.ResourceRecordFile"));
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
    				fields.add(get_ResourceRecordFile());
    			return fields;
	}

	/**
	 * Return a list of all associated childContainers. A childContainer is a DataContainer
	 * @return
	 */
	public List getChildContainers()
	{
		List childs = new ArrayList();
    	    		childs.addAll(getResourceRecords());
    	    			return childs;
	
	}
	
	public void copyFrom(DataContainer sourceContainer)
	{
		DnsReverseZoneWizardSummaryDataContainerImpl source = (DnsReverseZoneWizardSummaryDataContainerImpl)sourceContainer;
	
    	    		get_usr_Name().setValue(source.get_usr_Name().getValue());
		    		get_ResourceRecordFile().setValue(source.get_ResourceRecordFile().getValue());
				
    	    		List targetListForResourceRecords = (List) getResourceRecords();
    		List sourceListForResourceRecords = (List) source.getResourceRecords();
    		if (sourceListForResourceRecords.size() != targetListForResourceRecords.size())
    		{
    			throw new IllegalArgumentException("The Lists are not from same size. Source is " + sourceListForResourceRecords.size() + " and target is " + targetListForResourceRecords.size() );
    		}
			for (int ii=0; ii < sourceListForResourceRecords.size(); ii++)
			{
				((DataContainer) targetListForResourceRecords.get(ii)).copyFrom(((DataContainer) sourceListForResourceRecords.get(ii)));
			}
			
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}