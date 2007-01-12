/** 
  * DnsSlaveZoneWizardPage1DataContainerImpl.java
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
  * Description: Page 1 of SlaveZone-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;

public class DnsSlaveZoneWizardPage1DataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardPage1DataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Masters;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveMasterEntry;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewMasterEntry;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddNewMasterEntry;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddPredefinedMaster;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_PredefinedMasters;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    	
		
			DnsSlaveZoneWizardPage1DataContainerImplLayouter layouter = null;
		
		public DnsSlaveZoneWizardPage1DataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsSlaveZoneWizardPage1DataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsSlaveZoneWizardPage1DataContainer.caption","DnsSlaveZoneWizardPage1DataContainer.subTitle");
				
				
    			
    				layouter = new DnsSlaveZoneWizardPage1DataContainerImplLayouter();//.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getInputFieldContainer(),"DnsSlaveZoneWizardPage1DataContainer.footerText");
		adapter.initContainer(this);
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
				String label = bundle.getString("DnsSlaveZoneWizardPage1DataContainer.masters");
				String binding = bindingPrefix + "_Masters.item";
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
				String label = bundle.getString("DnsSlaveZoneWizardPage1DataContainer.removeMasterEntry");
				String binding = bindingPrefix + "_usr_RemoveMasterEntry.item";
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
				String label = bundle.getString("DnsSlaveZoneWizardPage1DataContainer.newMasterEntry");
				String binding = bindingPrefix + "_usr_NewMasterEntry.item";
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
				String label = bundle.getString("DnsSlaveZoneWizardPage1DataContainer.addNewMasterEntry");
				String binding = bindingPrefix + "_usr_AddNewMasterEntry.item";
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
				String label = bundle.getString("DnsSlaveZoneWizardPage1DataContainer.addPredefinedMaster");
				String binding = bindingPrefix + "_usr_AddPredefinedMaster.item";
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
				String label = bundle.getString("DnsSlaveZoneWizardPage1DataContainer.predefinedMasters");
				String binding = bindingPrefix + "_usr_PredefinedMasters.item";
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

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
    		if (ic_usr_Name == null)
    		{
				String label = bundle.getString("DnsSlaveZoneWizardPage1DataContainer.Name");
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
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_Masters != null)
    		{
				ic_Masters.setLabelText(bundle.getString("DnsSlaveZoneWizardPage1DataContainer.masters"));
    		}
	    		if (ic_usr_RemoveMasterEntry != null)
    		{
				ic_usr_RemoveMasterEntry.setLabelText(bundle.getString("DnsSlaveZoneWizardPage1DataContainer.removeMasterEntry"));
    		}
	    		if (ic_usr_NewMasterEntry != null)
    		{
				ic_usr_NewMasterEntry.setLabelText(bundle.getString("DnsSlaveZoneWizardPage1DataContainer.newMasterEntry"));
    		}
	    		if (ic_usr_AddNewMasterEntry != null)
    		{
				ic_usr_AddNewMasterEntry.setLabelText(bundle.getString("DnsSlaveZoneWizardPage1DataContainer.addNewMasterEntry"));
    		}
	    		if (ic_usr_AddPredefinedMaster != null)
    		{
				ic_usr_AddPredefinedMaster.setLabelText(bundle.getString("DnsSlaveZoneWizardPage1DataContainer.addPredefinedMaster"));
    		}
	    		if (ic_usr_PredefinedMasters != null)
    		{
				ic_usr_PredefinedMasters.setLabelText(bundle.getString("DnsSlaveZoneWizardPage1DataContainer.predefinedMasters"));
    		}
	    		if (ic_usr_Name != null)
    		{
				ic_usr_Name.setLabelText(bundle.getString("DnsSlaveZoneWizardPage1DataContainer.Name"));
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
    				fields.add(get_Masters());
    				fields.add(get_usr_RemoveMasterEntry());
    				fields.add(get_usr_NewMasterEntry());
    				fields.add(get_usr_AddNewMasterEntry());
    				fields.add(get_usr_AddPredefinedMaster());
    				fields.add(get_usr_PredefinedMasters());
    				fields.add(get_usr_Name());
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
		DnsSlaveZoneWizardPage1DataContainerImpl source = (DnsSlaveZoneWizardPage1DataContainerImpl)sourceContainer;
	
    	    		get_Masters().setValue(source.get_Masters().getValue());
		    		get_usr_RemoveMasterEntry().setValue(source.get_usr_RemoveMasterEntry().getValue());
		    		get_usr_NewMasterEntry().setValue(source.get_usr_NewMasterEntry().getValue());
		    		get_usr_AddNewMasterEntry().setValue(source.get_usr_AddNewMasterEntry().getValue());
		    		get_usr_AddPredefinedMaster().setValue(source.get_usr_AddPredefinedMaster().getValue());
		    		get_usr_PredefinedMasters().setValue(source.get_usr_PredefinedMasters().getValue());
		    		get_usr_Name().setValue(source.get_usr_Name().getValue());
				
    	    	
	}

	
}