/** 
  * DnsReverseZoneDataContainerImpl.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/cmd/containerImpl.vm
  *
  * Contributors: 
  *   Prashanth Karnam<prkarnam@in.ibm.com>
  * 
  * Description: Container for DNS Reverse Zones
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.edit;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsReverseZoneDataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Name;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forward;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveForwarder;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewForwarder;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddForwarder;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_NewForwarderType;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_TTL;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_TTLUnit;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveTTL;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_ZoneFile;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_UseGlobalForwarders;
    	
		
	public DnsReverseZoneDataContainerImpl(AbstractBaseCimAdapter adapter) throws  WbemsmtException {
		super();
		setAdapter(adapter);
    			adapter.initContainer(this);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.Name");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,null,converter);
    		}
    		return ic_Name;
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.Forward");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt8StringArrayConverter();
    			ic_Forward = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.Forwarders");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
    			ic_Forwarders = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.removeForwarder");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_RemoveForwarder = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.newForwarder");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_NewForwarder = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.addForwarder");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_AddForwarder = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.newForwarderType");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			ic_usr_NewForwarderType = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
    		}
    		return ic_usr_NewForwarderType;
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.TTL");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_TTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.TTLUnit");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			ic_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.removeTTL");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.ZoneFile");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_ZoneFile = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,null,converter);
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
				String label = getAdapter().getBundle().getString("DnsReverseZoneDataContainer.useGlobalForwarders");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_UseGlobalForwarders = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
    		}
    		return ic_usr_UseGlobalForwarders;
    	}
		
	
		
	public void trace(java.io.PrintWriter 	printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(getAdapter().getBundle().getString("DnsReverseZoneDataContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
			   			   			if (get_Name().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Name()).getValue();
        				printStream.println(get_Name().getLabelText() + ": " + value);
   			}
   			   			   			if (get_Forward().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Forward()).getValue();
        				printStream.println(get_Forward().getLabelText() + ": " + value);
   			}
   			   			   			if (get_Forwarders().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Forwarders()).getValue();
        				printStream.println(get_Forwarders().getLabelText() + ": " + value);
   			}
   			   			   			if (get_usr_NewForwarder().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_NewForwarder()).getValue();
        				printStream.println(get_usr_NewForwarder().getLabelText() + ": " + value);
   			}
   			   			   			if (get_usr_NewForwarderType().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_NewForwarderType()).getValue();
        				printStream.println(get_usr_NewForwarderType().getLabelText() + ": " + value);
   			}
   			   			   			if (get_TTL().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_TTL()).getValue();
        				printStream.println(get_TTL().getLabelText() + ": " + value);
   			}
   			   			   			if (get_usr_TTLUnit().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_TTLUnit()).getValue();
        				printStream.println(get_usr_TTLUnit().getLabelText() + ": " + value);
   			}
   			   			   			if (get_ZoneFile().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_ZoneFile()).getValue();
        				printStream.println(get_ZoneFile().getLabelText() + ": " + value);
   			}
   					}

		if (showChilds(listOptions))
		{
			traceChilds(printStream,listOptions,title);
		}
	}
	
	public void traceChilds(java.io.PrintWriter printStream, String listOptions, boolean title)
	{
    			
			
	}
	
	
 
	/**
	 * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
	 * @return
	 */
	public List<LabeledBaseInputComponentIf> getFields()
	{
		List<LabeledBaseInputComponentIf> fields = new ArrayList<LabeledBaseInputComponentIf>();
    				fields.add(get_Name());
    				fields.add(get_Forward());
    				fields.add(get_Forwarders());
    				fields.add(get_usr_RemoveForwarder());
    				fields.add(get_usr_NewForwarder());
    				fields.add(get_usr_AddForwarder());
    				fields.add(get_usr_NewForwarderType());
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
	    		       DnsReverseZoneDataContainerImpl source = (DnsReverseZoneDataContainerImpl)sourceContainer;
		    		    
    	    		   get_Name().copyFrom(source.get_Name());
		        		   get_Forward().copyFrom(source.get_Forward());
		        		   get_Forwarders().copyFrom(source.get_Forwarders());
		        		   get_usr_RemoveForwarder().copyFrom(source.get_usr_RemoveForwarder());
		        		   get_usr_NewForwarder().copyFrom(source.get_usr_NewForwarder());
		        		   get_usr_AddForwarder().copyFrom(source.get_usr_AddForwarder());
		        		   get_usr_NewForwarderType().copyFrom(source.get_usr_NewForwarderType());
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