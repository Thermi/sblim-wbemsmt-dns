/** 
  * DnsResourceRecordListContainerImpl.java
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
  * Description: Container with a List of ResourceRecords
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;

//imports for that field of a linked container with occurence = MANY
import org.sblim.wbemsmt.tools.jsf.MultiLinePanel;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsResourceRecordListContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_SelectAll;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Delete;
    			
				private java.util.List icResourceRecords = new java.util.ArrayList();
		
		private MultiLinePanel resourceRecordsPanel;

				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_usr_DeleteRecordHeader;
				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_NameHeader;
				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_TTLHeader;
				private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf icResourceRecords_usr_TTLUnitHeader;
				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_usr_RemoveTTLHeader;
				private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf icResourceRecords_FamilyHeader;
				private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf icResourceRecords_TypeHeader;
				private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf icResourceRecords_ValueHeader;
				
	
		
			DnsResourceRecordListContainerImplLayouter layouter = null;
		
		public DnsResourceRecordListContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsResourceRecordListContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

			
				super(adapter,bindingPrefix, "DnsResourceRecordListContainer.caption",false);
				
				
    			
    				layouter = new DnsResourceRecordListContainerImplLayouter();
			layouter.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getPanelForCustomLayout(),"DnsResourceRecordListContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType BOOLEAN
		* UIType CHECKBOX_WITH_CLICKEVENT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_SelectAll() {
    		if (ic_usr_SelectAll == null)
    		{
				String label = bundle.getString("DnsResourceRecordListContainer.selectAll");
				String binding = bindingPrefix + "_usr_SelectAll.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_SelectAll = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxActionComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_SelectAll;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Delete() {
    		if (ic_usr_Delete == null)
    		{
				String label = bundle.getString("DnsResourceRecordListContainer.delete");
				String binding = bindingPrefix + "_usr_Delete.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Delete = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_Delete;
    	}
		
			
				
		/**
		* 
		* linked container DnsResourceRecordListItemContainer
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
							  "DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainer.caption", //Key for title
							  org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl.COLS);
			}		
			
			return resourceRecordsPanel;
		}

		static class ResourceRecordsPanel extends MultiLinePanel
		{
			public ResourceRecordsPanel(AbstractBaseCimAdapter adapter, String bindingPrefix, String bindigForTitle, String keyForTitle, int cols) {
				super(adapter, bindingPrefix, bindigForTitle, keyForTitle, cols);
			}
	
			protected String getOrientationOfColumnAsCss(int column) {
				return org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl.orientationOfColumnAsCss[column];
			}
		}

	public void addResourceRecords(org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordListItemContainer_AsResourceRecords_InDnsResourceRecordListContainerImpl child) {

		getResourceRecords().add(child);
		getResourceRecordsPanel().addComponents(child.getComponents());
		
					((LabeledJSFInputComponent)getResourceRecords_usr_DeleteRecordHeader()).getDependentChildFields().add(child.get_usr_DeleteRecord());
					((LabeledJSFInputComponent)getResourceRecords_NameHeader()).getDependentChildFields().add(child.get_Name());
					((LabeledJSFInputComponent)getResourceRecords_TTLHeader()).getDependentChildFields().add(child.get_TTL());
					((LabeledJSFInputComponent)getResourceRecords_usr_TTLUnitHeader()).getDependentChildFields().add(child.get_usr_TTLUnit());
					((LabeledJSFInputComponent)getResourceRecords_usr_RemoveTTLHeader()).getDependentChildFields().add(child.get_usr_RemoveTTL());
					((LabeledJSFInputComponent)getResourceRecords_FamilyHeader()).getDependentChildFields().add(child.get_Family());
					((LabeledJSFInputComponent)getResourceRecords_TypeHeader()).getDependentChildFields().add(child.get_Type());
					((LabeledJSFInputComponent)getResourceRecords_ValueHeader()).getDependentChildFields().add(child.get_Value());
		
		
	}

	public void clearResourceRecords() {
		getResourceRecords().clear();
		getResourceRecordsPanel().getInputFieldContainer().getChildren().clear();
					((LabeledJSFInputComponent)getResourceRecords_usr_DeleteRecordHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_NameHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_TTLHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_usr_TTLUnitHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_usr_RemoveTTLHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_FamilyHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_TypeHeader()).getDependentChildFields().clear();
					((LabeledJSFInputComponent)getResourceRecords_ValueHeader()).getDependentChildFields().clear();
			}

	public void addResourceRecordsHeader() {
		getResourceRecordsPanel().setHeader(getResourceRecordsHeaderComponents());
	}
	
	private LabeledJSFInputComponent[] getResourceRecordsHeaderComponents() {
		return new LabeledJSFInputComponent[]{
							(LabeledJSFInputComponent)getResourceRecords_usr_DeleteRecordHeader(),
							(LabeledJSFInputComponent)getResourceRecords_NameHeader(),
							(LabeledJSFInputComponent)getResourceRecords_TTLHeader(),
							(LabeledJSFInputComponent)getResourceRecords_usr_TTLUnitHeader(),
							(LabeledJSFInputComponent)getResourceRecords_usr_RemoveTTLHeader(),
							(LabeledJSFInputComponent)getResourceRecords_FamilyHeader(),
							(LabeledJSFInputComponent)getResourceRecords_TypeHeader(),
							(LabeledJSFInputComponent)getResourceRecords_ValueHeader(),
						};
	}

			/**
   		 * Header for field deleteRecord
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_usr_DeleteRecordHeader() {
    		if (icResourceRecords_usr_DeleteRecordHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.deleteRecord");
				String binding = bindingPrefix + "resourceRecords_usr_DeleteRecordHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			icResourceRecords_usr_DeleteRecordHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent)icResourceRecords_usr_DeleteRecordHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent)icResourceRecords_usr_DeleteRecordHeader).setHeader(true);
			
    		return icResourceRecords_usr_DeleteRecordHeader;
    	}
			/**
   		 * Header for field Name
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_NameHeader() {
    		if (icResourceRecords_NameHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Name");
				String binding = bindingPrefix + "resourceRecords_NameHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			icResourceRecords_NameHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)icResourceRecords_NameHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)icResourceRecords_NameHeader).setHeader(true);
			
    		return icResourceRecords_NameHeader;
    	}
			/**
   		 * Header for field TTL
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_TTLHeader() {
    		if (icResourceRecords_TTLHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.TTL");
				String binding = bindingPrefix + "resourceRecords_TTLHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			icResourceRecords_TTLHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)icResourceRecords_TTLHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)icResourceRecords_TTLHeader).setHeader(true);
			
    		return icResourceRecords_TTLHeader;
    	}
			/**
   		 * Header for field TTLUnit
		 */
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf getResourceRecords_usr_TTLUnitHeader() {
    		if (icResourceRecords_usr_TTLUnitHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.TTLUnit");
				String binding = bindingPrefix + "resourceRecords_usr_TTLUnitHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			icResourceRecords_usr_TTLUnitHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)icResourceRecords_usr_TTLUnitHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)icResourceRecords_usr_TTLUnitHeader).setHeader(true);
			
    		return icResourceRecords_usr_TTLUnitHeader;
    	}
			/**
   		 * Header for field removeTTL
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_usr_RemoveTTLHeader() {
    		if (icResourceRecords_usr_RemoveTTLHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.removeTTL");
				String binding = bindingPrefix + "resourceRecords_usr_RemoveTTLHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			icResourceRecords_usr_RemoveTTLHeader = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent)icResourceRecords_usr_RemoveTTLHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent)icResourceRecords_usr_RemoveTTLHeader).setHeader(true);
			
    		return icResourceRecords_usr_RemoveTTLHeader;
    	}
			/**
   		 * Header for field Family
		 */
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf getResourceRecords_FamilyHeader() {
    		if (icResourceRecords_FamilyHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Family");
				String binding = bindingPrefix + "resourceRecords_FamilyHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt8StringConverter();
				boolean readOnly = false;
    			icResourceRecords_FamilyHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)icResourceRecords_FamilyHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)icResourceRecords_FamilyHeader).setHeader(true);
			
    		return icResourceRecords_FamilyHeader;
    	}
			/**
   		 * Header for field Type
		 */
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf getResourceRecords_TypeHeader() {
    		if (icResourceRecords_TypeHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Type");
				String binding = bindingPrefix + "resourceRecords_TypeHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = false;
    			icResourceRecords_TypeHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)icResourceRecords_TypeHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFComboBoxComponent)icResourceRecords_TypeHeader).setHeader(true);
			
    		return icResourceRecords_TypeHeader;
    	}
			/**
   		 * Header for field Value
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf getResourceRecords_ValueHeader() {
    		if (icResourceRecords_ValueHeader == null)
    		{
				String label = bundle.getString("DnsResourceRecordListItemContainer.Value");
				String binding = bindingPrefix + "resourceRecords_ValueHeader.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			icResourceRecords_ValueHeader = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent(parent,label,binding,converter, readOnly);
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)icResourceRecords_ValueHeader).setOrientation( LabeledBaseInputComponentIf.LEFT );    		}
				((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputFieldComponent)icResourceRecords_ValueHeader).setHeader(true);
			
    		return icResourceRecords_ValueHeader;
    	}
	
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_usr_SelectAll != null)
    		{
				ic_usr_SelectAll.setLabelText(bundle.getString("DnsResourceRecordListContainer.selectAll"));
    		}
	    		if (ic_usr_Delete != null)
    		{
				ic_usr_Delete.setLabelText(bundle.getString("DnsResourceRecordListContainer.delete"));
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
    				fields.add(get_usr_SelectAll());
    				fields.add(get_usr_Delete());
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
		DnsResourceRecordListContainerImpl source = (DnsResourceRecordListContainerImpl)sourceContainer;
	
    	    		get_usr_SelectAll().setValue(source.get_usr_SelectAll().getValue());
		    		get_usr_Delete().setValue(source.get_usr_Delete().getValue());
				
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