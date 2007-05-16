/** 
  * DnsResourceRecordDataContainer_AsResourceRecords_InDnsZoneTracingContainerImpl.java
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
  * @template: org/sblim/wbemsmt/dcg/templates/jsf/containerImplMultiLine.vm
  *
  * Contributors: 
  * 
  * Description: Container for ResourceRecords
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import java.util.*;
import org.sblim.wbemsmt.tools.input.jsf.*;
import org.sblim.wbemsmt.tools.input.*;
import org.sblim.wbemsmt.exception.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;


	
public class DnsResourceRecordDataContainer_AsResourceRecords_InDnsZoneTracingContainerImpl extends org.sblim.wbemsmt.tools.jsf.MultiLineBasePanel2 implements org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_TTL;
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveTTL;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Type;
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Family;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Value;
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Priority;
		
	public static final int COLS = 8;
	
	public static String[] orientationOfColumnAsCss = new String[]{
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    				"left",
    		
	};
	
	
	
	public DnsResourceRecordDataContainer_AsResourceRecords_InDnsZoneTracingContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix,int index) throws InitContainerException {
	    super(adapter,bindingPrefix,index);
		adapter.initContainer(this);
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
				String label = bundle.getString("DnsResourceRecordDataContainer.TTL");
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
				String label = bundle.getString("DnsResourceRecordDataContainer.TTLUnit");
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
				String label = bundle.getString("DnsResourceRecordDataContainer.removeTTL");
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
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
    		if (ic_Name == null)
    		{
				String label = bundle.getString("DnsResourceRecordDataContainer.Name");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Name.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)ic_Name).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}

						
    		return ic_Name;
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
				String label = bundle.getString("DnsResourceRecordDataContainer.Type");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Type.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_Type = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)ic_Type).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}

						
    		return ic_Type;
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
				String label = bundle.getString("DnsResourceRecordDataContainer.Family");
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
		* DataType STRING
		* UIType LABEL
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Value() {
    		if (ic_Value == null)
    		{
				String label = bundle.getString("DnsResourceRecordDataContainer.Value");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Value.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Value = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)ic_Value).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}

						
    		return ic_Value;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly false
		* Orientation LEFT
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Priority() {
    		if (ic_Priority == null)
    		{
				String label = bundle.getString("DnsResourceRecordDataContainer.Priority");
				String binding = bindingPrefix + "resourceRecords["+ index +"]._Priority.item";
				logger.fine("Using binding " + binding);
				DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Priority = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent)ic_Priority).setOrientation( LabeledBaseInputComponentIf.LEFT );
    		}

						
    		return ic_Priority;
    	}
		

	/**
	 * @return all the Components
	 */
	public LabeledJSFInputComponent[] getComponents() {
		return new LabeledJSFInputComponent[]{
						(LabeledJSFInputComponent)get_TTL(),
						(LabeledJSFInputComponent)get_usr_TTLUnit(),
						(LabeledJSFInputComponent)get_usr_RemoveTTL(),
						(LabeledJSFInputComponent)get_Name(),
						(LabeledJSFInputComponent)get_Type(),
						(LabeledJSFInputComponent)get_Family(),
						(LabeledJSFInputComponent)get_Value(),
						(LabeledJSFInputComponent)get_Priority(),
					};
	}
	
	
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_TTL != null)
    		{
				ic_TTL.setLabelText(bundle.getString("DnsResourceRecordDataContainer.TTL"));
    		}
	    		if (ic_usr_TTLUnit != null)
    		{
				ic_usr_TTLUnit.setLabelText(bundle.getString("DnsResourceRecordDataContainer.TTLUnit"));
    		}
	    		if (ic_usr_RemoveTTL != null)
    		{
				ic_usr_RemoveTTL.setLabelText(bundle.getString("DnsResourceRecordDataContainer.removeTTL"));
    		}
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsResourceRecordDataContainer.Name"));
    		}
	    		if (ic_Type != null)
    		{
				ic_Type.setLabelText(bundle.getString("DnsResourceRecordDataContainer.Type"));
    		}
	    		if (ic_Family != null)
    		{
				ic_Family.setLabelText(bundle.getString("DnsResourceRecordDataContainer.Family"));
    		}
	    		if (ic_Value != null)
    		{
				ic_Value.setLabelText(bundle.getString("DnsResourceRecordDataContainer.Value"));
    		}
	    		if (ic_Priority != null)
    		{
				ic_Priority.setLabelText(bundle.getString("DnsResourceRecordDataContainer.Priority"));
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
    				fields.add(get_TTL());
    				fields.add(get_usr_TTLUnit());
    				fields.add(get_usr_RemoveTTL());
    				fields.add(get_Name());
    				fields.add(get_Type());
    				fields.add(get_Family());
    				fields.add(get_Value());
    				fields.add(get_Priority());
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
		DnsResourceRecordDataContainer_AsResourceRecords_InDnsZoneTracingContainerImpl source = (DnsResourceRecordDataContainer_AsResourceRecords_InDnsZoneTracingContainerImpl)sourceContainer;
	
    	    		get_TTL().setValue(source.get_TTL().getValue());
		    		get_usr_TTLUnit().setValue(source.get_usr_TTLUnit().getValue());
		    		get_usr_RemoveTTL().setValue(source.get_usr_RemoveTTL().getValue());
		    		get_Name().setValue(source.get_Name().getValue());
		    		get_Type().setValue(source.get_Type().getValue());
		    		get_Family().setValue(source.get_Family().getValue());
		    		get_Value().setValue(source.get_Value().getValue());
		    		get_Priority().setValue(source.get_Priority().getValue());
				
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		
	
	
	
}