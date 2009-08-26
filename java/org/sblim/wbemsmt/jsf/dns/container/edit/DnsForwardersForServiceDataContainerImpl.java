/** 
  * DnsForwardersForServiceDataContainerImpl.java
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

public class DnsForwardersForServiceDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forward;

    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveForwarder;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewForwarder;

    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddForwarder;

    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_NewForwarderType;

    	
		
			DnsForwardersForServiceDataContainerImplLayouter layouter = null;
		
		public DnsForwardersForServiceDataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsForwardersForServiceDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String expressionPrefix) throws WbemsmtException  {

			
				super(adapter,expressionPrefix, "DnsForwardersForServiceDataContainer.caption",false);
				
				
		
				
    			
    				layouter = new DnsForwardersForServiceDataContainerImplLayouter();
			//layout is done in the edit-method of the Editbean
			//layouter.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getPanelForCustomLayout(),"DnsForwardersForServiceDataContainer.footerText");
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
				String label = bundle.getString("DnsForwardersForServiceDataContainer.Forward");
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
				String label = bundle.getString("DnsForwardersForServiceDataContainer.Forwarders");
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
				String label = bundle.getString("DnsForwardersForServiceDataContainer.removeForwarder");
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
				String label = bundle.getString("DnsForwardersForServiceDataContainer.newForwarder");
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
				String label = bundle.getString("DnsForwardersForServiceDataContainer.addForwarder");
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
				String label = bundle.getString("DnsForwardersForServiceDataContainer.newForwarderType");
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
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_Forward != null)
    		{
				ic_Forward.setLabelText(bundle.getString("DnsForwardersForServiceDataContainer.Forward"));
    		}
	    		if (ic_Forwarders != null)
    		{
				ic_Forwarders.setLabelText(bundle.getString("DnsForwardersForServiceDataContainer.Forwarders"));
    		}
	    		if (ic_usr_RemoveForwarder != null)
    		{
				ic_usr_RemoveForwarder.setLabelText(bundle.getString("DnsForwardersForServiceDataContainer.removeForwarder"));
    		}
	    		if (ic_usr_NewForwarder != null)
    		{
				ic_usr_NewForwarder.setLabelText(bundle.getString("DnsForwardersForServiceDataContainer.newForwarder"));
    		}
	    		if (ic_usr_AddForwarder != null)
    		{
				ic_usr_AddForwarder.setLabelText(bundle.getString("DnsForwardersForServiceDataContainer.addForwarder"));
    		}
	    		if (ic_usr_NewForwarderType != null)
    		{
				ic_usr_NewForwarderType.setLabelText(bundle.getString("DnsForwardersForServiceDataContainer.newForwarderType"));
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
	    		       DnsForwardersForServiceDataContainerImpl source = (DnsForwardersForServiceDataContainerImpl)sourceContainer;
		    		    
    	    		   get_Forward().copyFrom(source.get_Forward());
		        		   get_Forwarders().copyFrom(source.get_Forwarders());
		        		   get_usr_RemoveForwarder().copyFrom(source.get_usr_RemoveForwarder());
		        		   get_usr_NewForwarder().copyFrom(source.get_usr_NewForwarder());
		        		   get_usr_AddForwarder().copyFrom(source.get_usr_AddForwarder());
		        		   get_usr_NewForwarderType().copyFrom(source.get_usr_NewForwarderType());
		    		
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}