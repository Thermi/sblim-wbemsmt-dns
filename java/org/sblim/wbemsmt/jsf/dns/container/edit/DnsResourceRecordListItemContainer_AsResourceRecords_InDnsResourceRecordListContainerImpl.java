/** 
  * DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl.java
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
  * Description: One ResourceRecord in a List of Records
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


	
public class DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl extends org.sblim.wbemsmt.tools.jsf.MultiLineBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_TTL;
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveTTL;
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Family;
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Type;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Value;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_DeleteRecord;
		
	private static String[] orientationOfColumnAsCss = new String[]{
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    		
	};
	
	
	
	private final int index;
	
//	public DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl(String bindingPrefix, org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,int index) throws InitContainerException {
//		this(adapter,bindingPrefix,index, null);
//	}
	
	public DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix,int index, HtmlPanelGrid grid) throws InitContainerException {
	    super(adapter,
			  bindingPrefix, // the prefix for binding values
			  "#{" +  bindingPrefix + "resourceRecords["+ index +"]", // binding for Title
			  "DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainer.caption", //Key for title
			  8,grid);
		this.index = index;
		addComponents(new LabeledJSFInputComponent[]{
					(LabeledJSFInputComponent)get_Name(),
			
					(LabeledJSFInputComponent)get_TTL(),
			
					(LabeledJSFInputComponent)get_usr_TTLUnit(),
			
					(LabeledJSFInputComponent)get_usr_RemoveTTL(),
			
					(LabeledJSFInputComponent)get_Family(),
			
					(LabeledJSFInputComponent)get_Type(),
			
					(LabeledJSFInputComponent)get_Value(),
			
					(LabeledJSFInputComponent)get_usr_DeleteRecord(),
			
				});
		if (first)
		{
			//setFooter(getInputFieldContainer(),"#{localeManager.bundle['dns'].DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl_footerText}","DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl.footerText");
			//setFooter(getInputFieldContainer(),"DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl.footerText");
			String binding = "#{" +  bindingPrefix + "resourceRecords["+ index +"].footerText}";
			setFooter(getOuterPanel(),"DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainer.footerText",binding);
		}
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
    		if (ic_Name == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Name");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Name.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_Name.setRequired(true);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)ic_Name).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_Name;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_TTL() {
    		if (ic_TTL == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.TTL");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._TTL.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_TTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)ic_TTL).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_TTL;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType COMBOBOX
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_TTLUnit() {
    		if (ic_usr_TTLUnit == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.TTLUnit");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._usr_TTLUnit.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)ic_usr_TTLUnit).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_usr_TTLUnit;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveTTL() {
    		if (ic_usr_RemoveTTL == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.removeTTL");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._usr_RemoveTTL.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent)ic_usr_RemoveTTL).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_usr_RemoveTTL;
    	}
			/**
		* 
		* DataType UNSIGNED_INT8
		* UIType COMBOBOX
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Family() {
    		if (ic_Family == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Family");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Family.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt8StringConverter();
				boolean readOnly = false;
    			ic_Family = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)ic_Family).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_Family;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType COMBOBOX
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Type() {
    		if (ic_Type == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Type");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Type.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_Type = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
								ic_Type.setRequired(true);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)ic_Type).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_Type;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Value() {
    		if (ic_Value == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Value");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Value.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Value = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
								ic_Value.setRequired(true);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)ic_Value).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_Value;
    	}
			/**
		* 
		* DataType BOOLEAN
		* UIType CHECKBOX
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_DeleteRecord() {
    		if (ic_usr_DeleteRecord == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.deleteRecord");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._usr_DeleteRecord.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_DeleteRecord = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent)ic_usr_DeleteRecord).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}
    		return ic_usr_DeleteRecord;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.Name"));
    		}
	    		if (ic_TTL != null)
    		{
				ic_TTL.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.TTL"));
    		}
	    		if (ic_usr_TTLUnit != null)
    		{
				ic_usr_TTLUnit.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.TTLUnit"));
    		}
	    		if (ic_usr_RemoveTTL != null)
    		{
				ic_usr_RemoveTTL.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.removeTTL"));
    		}
	    		if (ic_Family != null)
    		{
				ic_Family.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.Family"));
    		}
	    		if (ic_Type != null)
    		{
				ic_Type.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.Type"));
    		}
	    		if (ic_Value != null)
    		{
				ic_Value.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.Value"));
    		}
	    		if (ic_usr_DeleteRecord != null)
    		{
				ic_usr_DeleteRecord.setLabelText(bundle.getString("DnsResourceRecordListItemContainer.deleteRecord"));
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
    				fields.add(get_TTL());
    				fields.add(get_usr_TTLUnit());
    				fields.add(get_usr_RemoveTTL());
    				fields.add(get_Family());
    				fields.add(get_Type());
    				fields.add(get_Value());
    				fields.add(get_usr_DeleteRecord());
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
		DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl source = (DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl)sourceContainer;
	
    	    		get_Name().setValue(source.get_Name().getValue());
		    		get_TTL().setValue(source.get_TTL().getValue());
		    		get_usr_TTLUnit().setValue(source.get_usr_TTLUnit().getValue());
		    		get_usr_RemoveTTL().setValue(source.get_usr_RemoveTTL().getValue());
		    		get_Family().setValue(source.get_Family().getValue());
		    		get_Type().setValue(source.get_Type().getValue());
		    		get_Value().setValue(source.get_Value().getValue());
		    		get_usr_DeleteRecord().setValue(source.get_usr_DeleteRecord().getValue());
				
    	    	
	}
	
	
	
}