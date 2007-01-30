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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: ./tools-dcg/templates/cmd/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: Container with a List of ResourceRecords
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.edit;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
//import org.sblim.wbemsmt.tools.converter.*;
//import org.sblim.wbemsmt.tools.converter.test.*;
//import org.sblim.wbemsmt.tools.input.*;
//import org.sblim.wbemsmt.tools.input.test.*;
import org.sblim.wbemsmt.tools.resources.*;
import org.sblim.wbemsmt.exception.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;


public class DnsResourceRecordListContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer {

	protected static WbemSmtResourceBundle bundle = ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},Locale.getDefault());

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_SelectAll;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Delete;
    			private java.util.List icResourceRecords = new java.util.ArrayList();
	
		
	public DnsResourceRecordListContainerImpl(AbstractBaseCimAdapter adapter) throws InitContainerException {
		super();
		setAdapter(adapter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.BooleanStringConverter();
    			ic_usr_SelectAll = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,"",converter);
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
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_Delete = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,"",converter);
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

	
		
	public void trace(java.io.PrintStream printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(bundle.getString("DnsResourceRecordListContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
						if (get_usr_SelectAll().isVisible())
			{
				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_SelectAll()).getValue();
				printStream.println(get_usr_SelectAll().getLabelText() + ": " + value);
			}
					}

		if (showChilds(listOptions))
		{
			traceChilds(printStream,listOptions,title);
		}
	}
	
	public void traceChilds(java.io.PrintStream printStream, String listOptions, boolean title)
	{
    		        		printStream.println();
        		printStream.println(bundle.getString("DnsResourceRecordListContainer.role.resourceRecords"));
        		List listresourceRecords = getResourceRecords();
        		for (int i = 0; i < listresourceRecords.size(); i++) {
        			BaseDataContainer child = (BaseDataContainer)listresourceRecords.get(i);
        			printStream.println();
        			printStream.println(bundle.getString("item") + ": " + (i+1) + " " + bundle.getString("of") + " " + listresourceRecords.size());
        			child.trace(printStream,listOptions,false);
        		}
    			
			
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