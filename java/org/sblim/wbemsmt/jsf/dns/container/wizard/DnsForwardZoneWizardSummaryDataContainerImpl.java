/** 
  * DnsForwardZoneWizardSummaryDataContainerImpl.java
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
  * Description: Overview of wizard for forward zones
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.wizard;

import org.sblim.wbemsmt.exception.*;
import java.util.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsForwardZoneWizardSummaryDataContainerImpl extends org.sblim.wbemsmt.tools.wizard.jsf.WizardBasePanel implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Forward;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_Forwarders;
    	
		
			DnsForwardZoneWizardSummaryDataContainerImplLayouter layouter = null;
		
		public DnsForwardZoneWizardSummaryDataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsForwardZoneWizardSummaryDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsForwardZoneWizardSummaryDataContainer.caption","DnsForwardZoneWizardSummaryDataContainer.subTitle");
				
				
    			
    				layouter = new DnsForwardZoneWizardSummaryDataContainerImplLayouter();//.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getInputFieldContainer(),"DnsForwardZoneWizardSummaryDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
    		if (ic_usr_Name == null)
    		{
				String label = bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Name");
				String binding = bindingPrefix + "_usr_Name.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_usr_Name = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_usr_Name;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Forward() {
    		if (ic_Forward == null)
    		{
				String label = bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Forward");
				String binding = bindingPrefix + "_Forward.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Forward = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_Forward;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forwarders() {
    		if (ic_Forwarders == null)
    		{
				String label = bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Forwarders");
				String binding = bindingPrefix + "_Forwarders.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.UnsignedInt16StringConverter();
				boolean readOnly = true;
    			ic_Forwarders = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFListComponent(parent,label,binding,converter, readOnly);
				;
    		}
    		return ic_Forwarders;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_usr_Name != null)
    		{
				ic_usr_Name.setLabelText(bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Name"));
    		}
	    		if (ic_Forward != null)
    		{
				ic_Forward.setLabelText(bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Forward"));
    		}
	    		if (ic_Forwarders != null)
    		{
				ic_Forwarders.setLabelText(bundle.getString("DnsForwardZoneWizardSummaryDataContainer.Forwarders"));
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
    				fields.add(get_usr_Name());
    				fields.add(get_Forward());
    				fields.add(get_Forwarders());
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
		DnsForwardZoneWizardSummaryDataContainerImpl source = (DnsForwardZoneWizardSummaryDataContainerImpl)sourceContainer;
	
    	    		get_usr_Name().setValue(source.get_usr_Name().getValue());
		    		get_Forward().setValue(source.get_Forward().getValue());
		    		get_Forwarders().setValue(source.get_Forwarders().getValue());
				
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}