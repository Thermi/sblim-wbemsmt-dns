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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/cmd/containerImpl.vm
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
import org.sblim.wbemsmt.exception.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsResourceRecordListContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer
			, org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainerHeader		
	{
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_SelectAll;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Delete;
    			
		
		private java.util.List icResourceRecords = new java.util.ArrayList();

				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_DeleteRecord;
				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Name;
				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_TTL;
				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_TTLUnit;
				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_usr_RemoveTTL;
				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Family;
				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Type;
				private org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf icResourceRecordsHeader_Value;
		
	
		
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
				String label = getAdapter().getBundle().getString("DnsResourceRecordListContainer.selectAll");
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
				String label = getAdapter().getBundle().getString("DnsResourceRecordListContainer.delete");
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

   	       /**
		* Header for:
		* 
		* linked container DnsResourceRecordListItemContainer
		*/
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainerHeader getResourceRecordsHeader()
		{
			return this;
		}

				/**
   		 * Header for field deleteRecord
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_DeleteRecord() {
    		if (icResourceRecordsHeader_usr_DeleteRecord == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.deleteRecord");
			    org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.BooleanStringConverter();
    			icResourceRecordsHeader_usr_DeleteRecord = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_usr_DeleteRecord;
    	    }
				/**
   		 * Header for field Name
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Name() {
    		if (icResourceRecordsHeader_Name == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.Name");
			    org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			icResourceRecordsHeader_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_Name;
    	    }
				/**
   		 * Header for field TTL
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_TTL() {
    		if (icResourceRecordsHeader_TTL == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.TTL");
			    org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			icResourceRecordsHeader_TTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_TTL;
    	    }
				/**
   		 * Header for field TTLUnit
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_TTLUnit() {
    		if (icResourceRecordsHeader_usr_TTLUnit == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.TTLUnit");
			    org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			icResourceRecordsHeader_usr_TTLUnit = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_usr_TTLUnit;
    	    }
				/**
   		 * Header for field removeTTL
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_usr_RemoveTTL() {
    		if (icResourceRecordsHeader_usr_RemoveTTL == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.removeTTL");
			    org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			icResourceRecordsHeader_usr_RemoveTTL = new org.sblim.wbemsmt.tools.input.test.LabeledTestActionComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_usr_RemoveTTL;
    	    }
				/**
   		 * Header for field Family
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Family() {
    		if (icResourceRecordsHeader_Family == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.Family");
			    org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt8StringArrayConverter();
    			icResourceRecordsHeader_Family = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_Family;
    	    }
				/**
   		 * Header for field Type
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Type() {
    		if (icResourceRecordsHeader_Type == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.Type");
			    org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			icResourceRecordsHeader_Type = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_Type;
    	    }
				/**
   		 * Header for field Value
		 */
		public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Value() {
    		if (icResourceRecordsHeader_Value == null)
    		{
    			String label = getAdapter().getBundle().getString("DnsResourceRecordListItemContainer.Value");
			    org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			icResourceRecordsHeader_Value = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
			}
    		return icResourceRecordsHeader_Value;
    	    }
		

	
		
	public void trace(java.io.PrintWriter 	printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(getAdapter().getBundle().getString("DnsResourceRecordListContainer.caption"));
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
	
	public void traceChilds(java.io.PrintWriter printStream, String listOptions, boolean title)
	{
    		        		List listresourceRecords = getResourceRecords();
        		printStream.println();
        		printStream.println(getAdapter().getBundle().getString("DnsResourceRecordListContainer.role.resourceRecords") + " " + getAdapter().getBundle().getString("items.found", new Object[]{new Integer(listresourceRecords.size())}));
        		for (int i = 0; i < listresourceRecords.size(); i++) {
        			BaseDataContainer child = (BaseDataContainer)listresourceRecords.get(i);
        			printStream.println();
        			printStream.println(getAdapter().getBundle().getString("item") + ": " + (i+1) + " " + getAdapter().getBundle().getString("of") + " " + listresourceRecords.size());
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