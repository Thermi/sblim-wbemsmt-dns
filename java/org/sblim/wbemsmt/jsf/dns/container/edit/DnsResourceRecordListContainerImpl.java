/** 
  * DnsResourceRecordListContainerImpl.java
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
  * Description: Container with a List of ResourceRecords
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;

public class DnsResourceRecordListContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_SelectAll;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Delete;
    			private java.util.List icResourceRecords = new java.util.ArrayList();
	
		
			DnsResourceRecordListContainerImplLayouter layouter = null;
		
		public DnsResourceRecordListContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public DnsResourceRecordListContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

				super(adapter,bindingPrefix, "DnsResourceRecordListContainer.caption");
				
				
    			
    				layouter = new DnsResourceRecordListContainerImplLayouter();//.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getInputFieldContainer(),"DnsResourceRecordListContainer.footerText");
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

	
}