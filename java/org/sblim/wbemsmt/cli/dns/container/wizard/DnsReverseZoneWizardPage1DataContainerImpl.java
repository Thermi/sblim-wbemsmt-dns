/** 
  * DnsReverseZoneWizardPage1DataContainerImpl.java
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
  * Description: Page 1 of ReverseZone-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.wizard;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsReverseZoneWizardPage1DataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_IpAddress;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_ResourceRecordUsed;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveResourceRecord;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_ResourceRecordNotUsed;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddResourceRecord;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddAllResourceRecords;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveAllResourceRecords;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_IpPresets;
    	
		
	public DnsReverseZoneWizardPage1DataContainerImpl(AbstractBaseCimAdapter adapter) throws  WbemsmtException {
		super();
		setAdapter(adapter);
    			adapter.initContainer(this);
	}

			/**
		* 
		* DataType STRING
		* UIType TEXTFIELD
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_IpAddress() {
    		if (ic_usr_IpAddress == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.ipAddress");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_IpAddress = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,null,converter);
    		}
    		return ic_usr_IpAddress;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST_WITH_MULTISELECT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_ResourceRecordUsed() {
    		if (ic_usr_ResourceRecordUsed == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.resourceRecordUsed");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
    			ic_usr_ResourceRecordUsed = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
    		}
    		return ic_usr_ResourceRecordUsed;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveResourceRecord() {
    		if (ic_usr_RemoveResourceRecord == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.removeResourceRecord");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_RemoveResourceRecord = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
    		}
    		return ic_usr_RemoveResourceRecord;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST_WITH_MULTISELECT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_ResourceRecordNotUsed() {
    		if (ic_usr_ResourceRecordNotUsed == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.resourceRecordNotUsed");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
    			ic_usr_ResourceRecordNotUsed = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
    		}
    		return ic_usr_ResourceRecordNotUsed;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddResourceRecord() {
    		if (ic_usr_AddResourceRecord == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.addResourceRecord");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_AddResourceRecord = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
    		}
    		return ic_usr_AddResourceRecord;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddAllResourceRecords() {
    		if (ic_usr_AddAllResourceRecords == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.addAllResourceRecords");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_AddAllResourceRecords = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
    		}
    		return ic_usr_AddAllResourceRecords;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveAllResourceRecords() {
    		if (ic_usr_RemoveAllResourceRecords == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.removeAllResourceRecords");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_RemoveAllResourceRecords = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,null,converter);
    		}
    		return ic_usr_RemoveAllResourceRecords;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType COMBOBOX_WITH_ONCHANGEEVENT
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_IpPresets() {
    		if (ic_usr_IpPresets == null)
    		{
				String label = getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.ipPresets");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			ic_usr_IpPresets = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
    		}
    		return ic_usr_IpPresets;
    	}
		
	
		
	public void trace(java.io.PrintWriter 	printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(getAdapter().getBundle().getString("DnsReverseZoneWizardPage1DataContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
			   			   			if (get_usr_IpAddress().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_IpAddress()).getValue();
        				printStream.println(get_usr_IpAddress().getLabelText() + ": " + value);
   			}
   			   			   			if (get_usr_ResourceRecordUsed().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_ResourceRecordUsed()).getValue();
        				printStream.println(get_usr_ResourceRecordUsed().getLabelText() + ": " + value);
   			}
   			   			   			if (get_usr_ResourceRecordNotUsed().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_ResourceRecordNotUsed()).getValue();
        				printStream.println(get_usr_ResourceRecordNotUsed().getLabelText() + ": " + value);
   			}
   			   			   			if (get_usr_IpPresets().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_IpPresets()).getValue();
        				printStream.println(get_usr_IpPresets().getLabelText() + ": " + value);
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
    				fields.add(get_usr_IpAddress());
    				fields.add(get_usr_ResourceRecordUsed());
    				fields.add(get_usr_RemoveResourceRecord());
    				fields.add(get_usr_ResourceRecordNotUsed());
    				fields.add(get_usr_AddResourceRecord());
    				fields.add(get_usr_AddAllResourceRecords());
    				fields.add(get_usr_RemoveAllResourceRecords());
    				fields.add(get_usr_IpPresets());
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
	    		       DnsReverseZoneWizardPage1DataContainerImpl source = (DnsReverseZoneWizardPage1DataContainerImpl)sourceContainer;
		    		    
    	    		   get_usr_IpAddress().copyFrom(source.get_usr_IpAddress());
		        		   get_usr_ResourceRecordUsed().copyFrom(source.get_usr_ResourceRecordUsed());
		        		   get_usr_RemoveResourceRecord().copyFrom(source.get_usr_RemoveResourceRecord());
		        		   get_usr_ResourceRecordNotUsed().copyFrom(source.get_usr_ResourceRecordNotUsed());
		        		   get_usr_AddResourceRecord().copyFrom(source.get_usr_AddResourceRecord());
		        		   get_usr_AddAllResourceRecords().copyFrom(source.get_usr_AddAllResourceRecords());
		        		   get_usr_RemoveAllResourceRecords().copyFrom(source.get_usr_RemoveAllResourceRecords());
		        		   get_usr_IpPresets().copyFrom(source.get_usr_IpPresets());
		    		
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		
}