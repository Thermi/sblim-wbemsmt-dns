/** 
  * WelcomeDataContainerImpl.java
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
  * @template: ./tools-dcg/templates/cmd/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.welcome;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;


public class WelcomeDataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.welcome.WelcomeDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_WelcomeText;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_DnsPicture;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Memo;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateMasterzone;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateSlavezone;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateForwardzone;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateAddressmatchlist;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateMasters;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Actions;
    	
		
	public WelcomeDataContainerImpl(AbstractBaseCimAdapter adapter) throws InitContainerException {
		super();
		setAdapter(adapter);
    			adapter.initContainer(this);
	}

			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_WelcomeText() {
    		if (ic_usr_WelcomeText == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.welcomeText");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_WelcomeText = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_WelcomeText;
    	}
			/**
		* 
		* DataType PICTUREDATA
		* UIType PICTURE
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_DnsPicture() {
    		if (ic_usr_DnsPicture == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.dnsPicture");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.cli.NotSupportedConverter();
    			ic_usr_DnsPicture = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_DnsPicture;
    	}
			/**
		* 
		* DataType MEMODATA
		* UIType MEMO
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Memo() {
    		if (ic_usr_Memo == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.memo");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.cli.MemoDataConverter();
    			ic_usr_Memo = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_Memo;
    	}
			/**
		* 
		* DataType LINKDATA
		* UIType LINK
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateMasterzone() {
    		if (ic_usr_LinkCreateMasterzone == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.linkCreateMasterzone");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.cli.NotSupportedConverter();
    			ic_usr_LinkCreateMasterzone = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_LinkCreateMasterzone;
    	}
			/**
		* 
		* DataType LINKDATA
		* UIType LINK
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateSlavezone() {
    		if (ic_usr_LinkCreateSlavezone == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.linkCreateSlavezone");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.cli.NotSupportedConverter();
    			ic_usr_LinkCreateSlavezone = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_LinkCreateSlavezone;
    	}
			/**
		* 
		* DataType LINKDATA
		* UIType LINK
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateForwardzone() {
    		if (ic_usr_LinkCreateForwardzone == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.linkCreateForwardzone");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.cli.NotSupportedConverter();
    			ic_usr_LinkCreateForwardzone = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_LinkCreateForwardzone;
    	}
			/**
		* 
		* DataType LINKDATA
		* UIType LINK
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateAddressmatchlist() {
    		if (ic_usr_LinkCreateAddressmatchlist == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.linkCreateAddressmatchlist");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.cli.NotSupportedConverter();
    			ic_usr_LinkCreateAddressmatchlist = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_LinkCreateAddressmatchlist;
    	}
			/**
		* 
		* DataType LINKDATA
		* UIType LINK
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateMasters() {
    		if (ic_usr_LinkCreateMasters == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.linkCreateMasters");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.cli.NotSupportedConverter();
    			ic_usr_LinkCreateMasters = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_LinkCreateMasters;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Actions() {
    		if (ic_usr_Actions == null)
    		{
				String label = getAdapter().getBundle().getString("WelcomeDataContainer.actions");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_Actions = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,"",converter);
    		}
    		return ic_usr_Actions;
    	}
		
	
		
	public void trace(java.io.PrintWriter 	printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(getAdapter().getBundle().getString("WelcomeDataContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
			   			   			if (get_usr_WelcomeText().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_WelcomeText()).getValue();
        				printStream.println(get_usr_WelcomeText().getLabelText() + ": " + value);
   			}
   			   			   				//Field _usr_DnsPicture not supported for cli
   			   			   			if (get_usr_Memo().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_Memo()).getValue();
        				printStream.println(get_usr_Memo().getLabelText() + ": " + value);
   			}
   			   			   				//Field _usr_LinkCreateMasterzone not supported for cli
   			   			   				//Field _usr_LinkCreateSlavezone not supported for cli
   			   			   				//Field _usr_LinkCreateForwardzone not supported for cli
   			   			   				//Field _usr_LinkCreateAddressmatchlist not supported for cli
   			   			   				//Field _usr_LinkCreateMasters not supported for cli
   			   			   			if (get_usr_Actions().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_Actions()).getValue();
        				printStream.println(get_usr_Actions().getLabelText() + ": " + value);
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
	public List getFields()
	{
		List fields = new ArrayList();
    				fields.add(get_usr_WelcomeText());
    				fields.add(get_usr_DnsPicture());
    				fields.add(get_usr_Memo());
    				fields.add(get_usr_LinkCreateMasterzone());
    				fields.add(get_usr_LinkCreateSlavezone());
    				fields.add(get_usr_LinkCreateForwardzone());
    				fields.add(get_usr_LinkCreateAddressmatchlist());
    				fields.add(get_usr_LinkCreateMasters());
    				fields.add(get_usr_Actions());
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
		WelcomeDataContainerImpl source = (WelcomeDataContainerImpl)sourceContainer;
	
    	    		get_usr_WelcomeText().setValue(source.get_usr_WelcomeText().getValue());
		    		get_usr_DnsPicture().setValue(source.get_usr_DnsPicture().getValue());
		    		get_usr_Memo().setValue(source.get_usr_Memo().getValue());
		    		get_usr_LinkCreateMasterzone().setValue(source.get_usr_LinkCreateMasterzone().getValue());
		    		get_usr_LinkCreateSlavezone().setValue(source.get_usr_LinkCreateSlavezone().getValue());
		    		get_usr_LinkCreateForwardzone().setValue(source.get_usr_LinkCreateForwardzone().getValue());
		    		get_usr_LinkCreateAddressmatchlist().setValue(source.get_usr_LinkCreateAddressmatchlist().getValue());
		    		get_usr_LinkCreateMasters().setValue(source.get_usr_LinkCreateMasters().getValue());
		    		get_usr_Actions().setValue(source.get_usr_Actions().getValue());
				
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		
}