/** 
  * DnsStubZoneWizardPage1DataContainerImpl.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: ./tools-dcg/templates/cmd/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: Page 1 of SlaveZone-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.wizard;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
//import org.sblim.wbemsmt.tools.converter.*;
//import org.sblim.wbemsmt.tools.converter.test.*;
//import org.sblim.wbemsmt.tools.input.*;
//import org.sblim.wbemsmt.tools.input.test.*;
import org.sblim.wbemsmt.tools.resources.*;
import org.sblim.wbemsmt.exception.*;

public class DnsStubZoneWizardPage1DataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardPage1DataContainer {

	protected static WbemSmtResourceBundle bundle = ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},Locale.getDefault());

			private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Masters;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_RemoveMasterEntry;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_NewMasterEntry;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddNewMasterEntry;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_AddPredefinedMaster;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_PredefinedMasters;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    	
		
	public DnsStubZoneWizardPage1DataContainerImpl(AbstractBaseCimAdapter adapter) throws InitContainerException {
		super();
		setAdapter(adapter);
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
				String label = bundle.getString("DnsStubZoneWizardPage1DataContainer.masters");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
    			ic_Masters = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
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
				String label = bundle.getString("DnsStubZoneWizardPage1DataContainer.removeMasterEntry");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_RemoveMasterEntry = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				String label = bundle.getString("DnsStubZoneWizardPage1DataContainer.newMasterEntry");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_NewMasterEntry = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				String label = bundle.getString("DnsStubZoneWizardPage1DataContainer.addNewMasterEntry");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_AddNewMasterEntry = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				String label = bundle.getString("DnsStubZoneWizardPage1DataContainer.addPredefinedMaster");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_AddPredefinedMaster = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
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
				String label = bundle.getString("DnsStubZoneWizardPage1DataContainer.predefinedMasters");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.multiplevalue.UnsignedInt16StringArrayConverter();
    			ic_usr_PredefinedMasters = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
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
				String label = bundle.getString("DnsStubZoneWizardPage1DataContainer.Name");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_Name;
    	}
		
	
		
	public void trace(java.io.PrintStream printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(bundle.getString("DnsStubZoneWizardPage1DataContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
						if (get_Masters().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_Masters()).getValue();
				printStream.println(get_Masters().getLabelText() + ": " + value);
			}
						if (get_usr_NewMasterEntry().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_NewMasterEntry()).getValue();
				printStream.println(get_usr_NewMasterEntry().getLabelText() + ": " + value);
			}
						if (get_usr_PredefinedMasters().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_PredefinedMasters()).getValue();
				printStream.println(get_usr_PredefinedMasters().getLabelText() + ": " + value);
			}
						if (get_usr_Name().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_Name()).getValue();
				printStream.println(get_usr_Name().getLabelText() + ": " + value);
			}
					}

		if (showChilds(listOptions))
		{
			traceChilds(printStream,listOptions,title);
		}
	}
	
	public void traceChilds(java.io.PrintStream printStream, String listOptions, boolean title)
	{
    			
			
	}
	
}