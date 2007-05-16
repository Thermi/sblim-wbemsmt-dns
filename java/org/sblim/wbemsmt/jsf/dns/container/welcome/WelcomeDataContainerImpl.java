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
  * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/jsf/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.welcome;

import org.sblim.wbemsmt.exception.*;
import java.util.*;




import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class WelcomeDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.welcome.WelcomeDataContainer {

			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_WelcomeText;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_DnsPicture;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Memo;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateMasterzone;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateSlavezone;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateForwardzone;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateAddressmatchlist;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_LinkCreateMasters;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Actions;
    	
		
			WelcomeDataContainerImplLayouter layouter = null;
		
		public WelcomeDataContainerImplLayouter getLayouter()
		{
			return layouter;
		}	
	
	public WelcomeDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

			
				super(adapter,bindingPrefix, "WelcomeDataContainer.caption",false);
				
				
    			
    				layouter = new WelcomeDataContainerImplLayouter();
			layouter.layout(getPanelForCustomLayout(),this,bundle);
				
		setFooter(getPanelForCustomLayout(),"WelcomeDataContainer.footerText");
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
				String label = bundle.getString("WelcomeDataContainer.welcomeText");
				String binding = bindingPrefix + "_usr_WelcomeText.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_usr_WelcomeText = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.dnsPicture");
				String binding = bindingPrefix + "_usr_DnsPicture.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.jsf.PictureDataConverter();
				boolean readOnly = false;
    			ic_usr_DnsPicture = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFPictureComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.memo");
				String binding = bindingPrefix + "_usr_Memo.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.jsf.MemoDataConverter();
				boolean readOnly = false;
    			ic_usr_Memo = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFMemoComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.linkCreateMasterzone");
				String binding = bindingPrefix + "_usr_LinkCreateMasterzone.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.jsf.LinkDataConverter();
				boolean readOnly = false;
    			ic_usr_LinkCreateMasterzone = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLinkComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.linkCreateSlavezone");
				String binding = bindingPrefix + "_usr_LinkCreateSlavezone.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.jsf.LinkDataConverter();
				boolean readOnly = false;
    			ic_usr_LinkCreateSlavezone = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLinkComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.linkCreateForwardzone");
				String binding = bindingPrefix + "_usr_LinkCreateForwardzone.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.jsf.LinkDataConverter();
				boolean readOnly = false;
    			ic_usr_LinkCreateForwardzone = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLinkComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.linkCreateAddressmatchlist");
				String binding = bindingPrefix + "_usr_LinkCreateAddressmatchlist.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.jsf.LinkDataConverter();
				boolean readOnly = false;
    			ic_usr_LinkCreateAddressmatchlist = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLinkComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.linkCreateMasters");
				String binding = bindingPrefix + "_usr_LinkCreateMasters.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.jsf.LinkDataConverter();
				boolean readOnly = false;
    			ic_usr_LinkCreateMasters = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLinkComponent(parent,label,binding,converter, readOnly);
				;
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
				String label = bundle.getString("WelcomeDataContainer.actions");
				String binding = bindingPrefix + "_usr_Actions.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Actions = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_Actions;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_usr_WelcomeText != null)
    		{
				ic_usr_WelcomeText.setLabelText(bundle.getString("WelcomeDataContainer.welcomeText"));
    		}
	    		if (ic_usr_DnsPicture != null)
    		{
				ic_usr_DnsPicture.setLabelText(bundle.getString("WelcomeDataContainer.dnsPicture"));
    		}
	    		if (ic_usr_Memo != null)
    		{
				ic_usr_Memo.setLabelText(bundle.getString("WelcomeDataContainer.memo"));
    		}
	    		if (ic_usr_LinkCreateMasterzone != null)
    		{
				ic_usr_LinkCreateMasterzone.setLabelText(bundle.getString("WelcomeDataContainer.linkCreateMasterzone"));
    		}
	    		if (ic_usr_LinkCreateSlavezone != null)
    		{
				ic_usr_LinkCreateSlavezone.setLabelText(bundle.getString("WelcomeDataContainer.linkCreateSlavezone"));
    		}
	    		if (ic_usr_LinkCreateForwardzone != null)
    		{
				ic_usr_LinkCreateForwardzone.setLabelText(bundle.getString("WelcomeDataContainer.linkCreateForwardzone"));
    		}
	    		if (ic_usr_LinkCreateAddressmatchlist != null)
    		{
				ic_usr_LinkCreateAddressmatchlist.setLabelText(bundle.getString("WelcomeDataContainer.linkCreateAddressmatchlist"));
    		}
	    		if (ic_usr_LinkCreateMasters != null)
    		{
				ic_usr_LinkCreateMasters.setLabelText(bundle.getString("WelcomeDataContainer.linkCreateMasters"));
    		}
	    		if (ic_usr_Actions != null)
    		{
				ic_usr_Actions.setLabelText(bundle.getString("WelcomeDataContainer.actions"));
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