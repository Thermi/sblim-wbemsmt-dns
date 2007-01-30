/** 
  * DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl.java
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
  * @template: ./tools-dcg/templates/jsf/containerImplMultiLine.vm
  *
  * Contributors: 
  * 
  * Description: ResourceRecord within the ReverseZone Wizard (on the Overview page)
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import java.util.*;
import org.sblim.wbemsmt.tools.input.jsf.*;
import org.sblim.wbemsmt.tools.input.*;
import org.sblim.wbemsmt.exception.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;


	
public class DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.MultiLineBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Type;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Value;
		
	private static String[] orientationOfColumnAsCss = new String[]{
    				"left",
    				"left",
    				"left",
    		
	};
	
	
	
	private final int index;
	
//	public DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl(String bindingPrefix, org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,int index) throws InitContainerException {
//		this(adapter,bindingPrefix,index, null);
//	}
	
	public DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix,int index, HtmlPanelGrid grid) throws InitContainerException {
	    super(adapter,
			  bindingPrefix, // the prefix for binding values
			  "#{" +  bindingPrefix + "resourceRecords["+ index +"]", // binding for Title
			  "DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainer.caption", //Key for title
			  3,grid);
		this.index = index;
		addComponents(new LabeledJSFInputComponent[]{
					(LabeledJSFInputComponent)get_Name(),
			
					(LabeledJSFInputComponent)get_Type(),
			
					(LabeledJSFInputComponent)get_Value(),
			
				});
		if (first)
		{
			//setFooter(getInputFieldContainer(),"#{localeManager.bundle['dns'].DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl_footerText}","DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl.footerText");
			//setFooter(getInputFieldContainer(),"DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl.footerText");
			String binding = "#{" +  bindingPrefix + "resourceRecords["+ index +"].footerText}";
			setFooter(getOuterPanel(),"DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainer.footerText",binding);
		}
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
    		if (ic_Name == null)
    		{
				String label = bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Name");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Name.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)ic_Name).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_Name;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Type() {
    		if (ic_Type == null)
    		{
				String label = bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Type");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Type.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Type = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)ic_Type).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_Type;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Value() {
    		if (ic_Value == null)
    		{
				String label = bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Value");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Value.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Value = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)ic_Value).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_Value;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Name"));
    		}
	    		if (ic_Type != null)
    		{
				ic_Type.setLabelText(bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Type"));
    		}
	    		if (ic_Value != null)
    		{
				ic_Value.setLabelText(bundle.getString("DnsResourceRecordForReverseZoneWizardDataContainer.Value"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}
	
	protected String getOrientationOfColumnAsCss(int column) {
		return orientationOfColumnAsCss[column];
	}
	

	
 
	/**
	 * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
	 * @return
	 */
	public List getFields()
	{
		List fields = new ArrayList();
    				fields.add(get_Name());
    				fields.add(get_Type());
    				fields.add(get_Value());
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
		DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl source = (DnsResourceRecordForReverseZoneWizardDataContainer_AsResourceRecords_InDnsReverseZoneWizardSummaryDataContainerImpl)sourceContainer;
	
    	    		get_Name().setValue(source.get_Name().getValue());
		    		get_Type().setValue(source.get_Type().getValue());
		    		get_Value().setValue(source.get_Value().getValue());
				
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		
	
	
	
}