/** 
  * DnsStubZoneDataContainerImpl.java
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
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;




import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsStubZoneDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forward;

    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveForwarder;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewForwarder;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddForwarder;

    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_NewForwarderType;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;

    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Masters;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveMasterEntry;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewMasterEntry;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddNewMasterEntry;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddPredefinedMaster;

    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_PredefinedMasters;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_TTL;

    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveTTL;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ZoneFile;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_UseGlobalForwarders;

    	
		
			DnsStubZoneDataContainerImplLayouter layouter = null;
		
		public DnsStubZoneDataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsStubZoneDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String expressionPrefix) throws WbemsmtException  {

			
				super(adapter,expressionPrefix, "DnsStubZoneDataContainer.caption",false);
				
				
		
				
    			
    				layouter = new DnsStubZoneDataContainerImplLayouter();
			//layout is done in the edit-method of the Editbean
			//layouter.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getPanelForCustomLayout(),"DnsStubZoneDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType UNSIGNED_INT8
		* UIType RADIOBUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forward() {
    		if (ic_Forward == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.Forward");
				String binding = expressionPrefix + "_Forward.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt8StringConverter();
				boolean readOnly = false;
    			ic_Forward = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFRadioButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_Forward;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST_WITH_MULTISELECT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forwarders() {
    		if (ic_Forwarders == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.Forwarders");
				String binding = expressionPrefix + "_Forwarders.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_Forwarders = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_Forwarders;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveForwarder() {
    		if (ic_usr_RemoveForwarder == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.removeForwarder");
				String binding = expressionPrefix + "_usr_RemoveForwarder.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveForwarder = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_RemoveForwarder;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewForwarder() {
    		if (ic_usr_NewForwarder == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.newForwarder");
				String binding = expressionPrefix + "_usr_NewForwarder.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_NewForwarder = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_NewForwarder;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddForwarder() {
    		if (ic_usr_AddForwarder == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.addForwarder");
				String binding = expressionPrefix + "_usr_AddForwarder.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddForwarder = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_AddForwarder;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType COMBOBOX
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_NewForwarderType() {
    		if (ic_usr_NewForwarderType == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.newForwarderType");
				String binding = expressionPrefix + "_usr_NewForwarderType.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_usr_NewForwarderType = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_NewForwarderType;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name() {
    		if (ic_Name == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.Name");
				String binding = expressionPrefix + "_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_Name;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST_WITH_MULTISELECT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Masters() {
    		if (ic_Masters == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.masters");
				String binding = expressionPrefix + "_Masters.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_Masters = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_Masters;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveMasterEntry() {
    		if (ic_usr_RemoveMasterEntry == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.removeMasterEntry");
				String binding = expressionPrefix + "_usr_RemoveMasterEntry.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveMasterEntry = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_RemoveMasterEntry;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewMasterEntry() {
    		if (ic_usr_NewMasterEntry == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.newMasterEntry");
				String binding = expressionPrefix + "_usr_NewMasterEntry.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_NewMasterEntry = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_NewMasterEntry;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddNewMasterEntry() {
    		if (ic_usr_AddNewMasterEntry == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.addNewMasterEntry");
				String binding = expressionPrefix + "_usr_AddNewMasterEntry.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddNewMasterEntry = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_AddNewMasterEntry;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddPredefinedMaster() {
    		if (ic_usr_AddPredefinedMaster == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.addPredefinedMaster");
				String binding = expressionPrefix + "_usr_AddPredefinedMaster.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_AddPredefinedMaster = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_AddPredefinedMaster;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST_WITH_MULTISELECT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_PredefinedMasters() {
    		if (ic_usr_PredefinedMasters == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.predefinedMasters");
				String binding = expressionPrefix + "_usr_PredefinedMasters.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.multiplevalue.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_usr_PredefinedMasters = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMultiListComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_PredefinedMasters;
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
				String label = bundle.getString("DnsStubZoneDataContainer.TTL");
				String binding = expressionPrefix + "_TTL.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_TTL = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("DnsStubZoneDataContainer.TTLUnit");
				String binding = expressionPrefix + "_usr_TTLUnit.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			ic_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("DnsStubZoneDataContainer.removeTTL");
				String binding = expressionPrefix + "_usr_RemoveTTL.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_RemoveTTL;
    	}
			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ZoneFile() {
    		if (ic_ZoneFile == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.ZoneFile");
				String binding = expressionPrefix + "_ZoneFile.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_ZoneFile = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_ZoneFile;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_UseGlobalForwarders() {
    		if (ic_usr_UseGlobalForwarders == null)
    		{
				String label = bundle.getString("DnsStubZoneDataContainer.useGlobalForwarders");
				String binding = expressionPrefix + "_usr_UseGlobalForwarders.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_UseGlobalForwarders = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_UseGlobalForwarders;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_Forward != null)
    		{
				ic_Forward.setLabelText(bundle.getString("DnsStubZoneDataContainer.Forward"));
    		}
	    		if (ic_Forwarders != null)
    		{
				ic_Forwarders.setLabelText(bundle.getString("DnsStubZoneDataContainer.Forwarders"));
    		}
	    		if (ic_usr_RemoveForwarder != null)
    		{
				ic_usr_RemoveForwarder.setLabelText(bundle.getString("DnsStubZoneDataContainer.removeForwarder"));
    		}
	    		if (ic_usr_NewForwarder != null)
    		{
				ic_usr_NewForwarder.setLabelText(bundle.getString("DnsStubZoneDataContainer.newForwarder"));
    		}
	    		if (ic_usr_AddForwarder != null)
    		{
				ic_usr_AddForwarder.setLabelText(bundle.getString("DnsStubZoneDataContainer.addForwarder"));
    		}
	    		if (ic_usr_NewForwarderType != null)
    		{
				ic_usr_NewForwarderType.setLabelText(bundle.getString("DnsStubZoneDataContainer.newForwarderType"));
    		}
	    		if (ic_Name != null)
    		{
				ic_Name.setLabelText(bundle.getString("DnsStubZoneDataContainer.Name"));
    		}
	    		if (ic_Masters != null)
    		{
				ic_Masters.setLabelText(bundle.getString("DnsStubZoneDataContainer.masters"));
    		}
	    		if (ic_usr_RemoveMasterEntry != null)
    		{
				ic_usr_RemoveMasterEntry.setLabelText(bundle.getString("DnsStubZoneDataContainer.removeMasterEntry"));
    		}
	    		if (ic_usr_NewMasterEntry != null)
    		{
				ic_usr_NewMasterEntry.setLabelText(bundle.getString("DnsStubZoneDataContainer.newMasterEntry"));
    		}
	    		if (ic_usr_AddNewMasterEntry != null)
    		{
				ic_usr_AddNewMasterEntry.setLabelText(bundle.getString("DnsStubZoneDataContainer.addNewMasterEntry"));
    		}
	    		if (ic_usr_AddPredefinedMaster != null)
    		{
				ic_usr_AddPredefinedMaster.setLabelText(bundle.getString("DnsStubZoneDataContainer.addPredefinedMaster"));
    		}
	    		if (ic_usr_PredefinedMasters != null)
    		{
				ic_usr_PredefinedMasters.setLabelText(bundle.getString("DnsStubZoneDataContainer.predefinedMasters"));
    		}
	    		if (ic_TTL != null)
    		{
				ic_TTL.setLabelText(bundle.getString("DnsStubZoneDataContainer.TTL"));
    		}
	    		if (ic_usr_TTLUnit != null)
    		{
				ic_usr_TTLUnit.setLabelText(bundle.getString("DnsStubZoneDataContainer.TTLUnit"));
    		}
	    		if (ic_usr_RemoveTTL != null)
    		{
				ic_usr_RemoveTTL.setLabelText(bundle.getString("DnsStubZoneDataContainer.removeTTL"));
    		}
	    		if (ic_ZoneFile != null)
    		{
				ic_ZoneFile.setLabelText(bundle.getString("DnsStubZoneDataContainer.ZoneFile"));
    		}
	    		if (ic_usr_UseGlobalForwarders != null)
    		{
				ic_usr_UseGlobalForwarders.setLabelText(bundle.getString("DnsStubZoneDataContainer.useGlobalForwarders"));
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
    				fields.add(get_Forward());
    				fields.add(get_Forwarders());
    				fields.add(get_usr_RemoveForwarder());
    				fields.add(get_usr_NewForwarder());
    				fields.add(get_usr_AddForwarder());
    				fields.add(get_usr_NewForwarderType());
    				fields.add(get_Name());
    				fields.add(get_Masters());
    				fields.add(get_usr_RemoveMasterEntry());
    				fields.add(get_usr_NewMasterEntry());
    				fields.add(get_usr_AddNewMasterEntry());
    				fields.add(get_usr_AddPredefinedMaster());
    				fields.add(get_usr_PredefinedMasters());
    				fields.add(get_TTL());
    				fields.add(get_usr_TTLUnit());
    				fields.add(get_usr_RemoveTTL());
    				fields.add(get_ZoneFile());
    				fields.add(get_usr_UseGlobalForwarders());
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
	    		       DnsStubZoneDataContainerImpl source = (DnsStubZoneDataContainerImpl)sourceContainer;
		    		    
    	    		   get_Forward().copyFrom(source.get_Forward());
		        		   get_Forwarders().copyFrom(source.get_Forwarders());
		        		   get_usr_RemoveForwarder().copyFrom(source.get_usr_RemoveForwarder());
		        		   get_usr_NewForwarder().copyFrom(source.get_usr_NewForwarder());
		        		   get_usr_AddForwarder().copyFrom(source.get_usr_AddForwarder());
		        		   get_usr_NewForwarderType().copyFrom(source.get_usr_NewForwarderType());
		        		   get_Name().copyFrom(source.get_Name());
		        		   get_Masters().copyFrom(source.get_Masters());
		        		   get_usr_RemoveMasterEntry().copyFrom(source.get_usr_RemoveMasterEntry());
		        		   get_usr_NewMasterEntry().copyFrom(source.get_usr_NewMasterEntry());
		        		   get_usr_AddNewMasterEntry().copyFrom(source.get_usr_AddNewMasterEntry());
		        		   get_usr_AddPredefinedMaster().copyFrom(source.get_usr_AddPredefinedMaster());
		        		   get_usr_PredefinedMasters().copyFrom(source.get_usr_PredefinedMasters());
		        		   get_TTL().copyFrom(source.get_TTL());
		        		   get_usr_TTLUnit().copyFrom(source.get_usr_TTLUnit());
		        		   get_usr_RemoveTTL().copyFrom(source.get_usr_RemoveTTL());
		        		   get_ZoneFile().copyFrom(source.get_ZoneFile());
		        		   get_usr_UseGlobalForwarders().copyFrom(source.get_usr_UseGlobalForwarders());
		    		
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}