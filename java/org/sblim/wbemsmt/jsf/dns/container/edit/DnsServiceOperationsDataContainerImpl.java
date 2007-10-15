/** 
  * DnsServiceOperationsDataContainerImpl.java
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
  * Description: Container for Operations within DNS Service
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;




import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsServiceOperationsDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_RunAsRoot;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Restart;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_invoke_Start;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_invoke_Stop;
    		private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_Status;
    	
		
	
	public DnsServiceOperationsDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

			
				super(adapter,bindingPrefix, "DnsServiceOperationsDataContainer.caption",false);
				
				
		
				
    			
    	    		        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_RunAsRoot());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_usr_Restart());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_invoke_Start());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_invoke_Stop());
        	        		addComponent((org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent)get_Status());
        					
		setFooter(getPanelForCustomLayout(),"DnsServiceOperationsDataContainer.footerText");
		adapter.initContainer(this);
	}
	

			/**
		* 
		* DataType BOOLEAN
		* UIType CHECKBOX
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_RunAsRoot() {
    		if (ic_RunAsRoot == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.RunAsRoot");
				String binding = bindingPrefix + "_RunAsRoot.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_RunAsRoot = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFCheckboxComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_RunAsRoot;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Restart() {
    		if (ic_usr_Restart == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.restart");
				String binding = bindingPrefix + "_usr_Restart.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_usr_Restart = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_usr_Restart;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Start() {
    		if (ic_invoke_Start == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.start");
				String binding = bindingPrefix + "_invoke_Start.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_invoke_Start = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_invoke_Start;
    	}
			/**
		* 
		* DataType ACTION
		* UIType BUTTON
		* ReadOnly false
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Stop() {
    		if (ic_invoke_Stop == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.stop");
				String binding = bindingPrefix + "_invoke_Stop.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = false;
    			ic_invoke_Stop = new org.sblim.wbemsmt.tools.input.jsf.JSFButtonComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_invoke_Stop;
    	}
			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Status() {
    		if (ic_Status == null)
    		{
				String label = bundle.getString("DnsServiceOperationsDataContainer.Status");
				String binding = bindingPrefix + "_Status.item";
				logger.fine("Using binding " + binding);
				org.sblim.wbemsmt.bl.adapter.DataContainer parent = this;
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
				boolean readOnly = true;
    			ic_Status = new org.sblim.wbemsmt.tools.input.jsf.LabeledJSFLabelComponent(parent,label,binding,converter, readOnly);
				;
    		}
			
						
    		return ic_Status;
    	}
		
	
		
	public void reload()
	{
		super.reload();
	    		if (ic_RunAsRoot != null)
    		{
				ic_RunAsRoot.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.RunAsRoot"));
    		}
	    		if (ic_usr_Restart != null)
    		{
				ic_usr_Restart.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.restart"));
    		}
	    		if (ic_invoke_Start != null)
    		{
				ic_invoke_Start.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.start"));
    		}
	    		if (ic_invoke_Stop != null)
    		{
				ic_invoke_Stop.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.stop"));
    		}
	    		if (ic_Status != null)
    		{
				ic_Status.setLabelText(bundle.getString("DnsServiceOperationsDataContainer.Status"));
    		}
		}

	public String[] getResourceBundleNames() {
		return new String[]{"messages","messagesDns"};
	}

	public void countAndCreateChildren() throws InitContainerException {
	
    		}


	/**
	 * count and create childrens
	 * @throws UpdateControlsException
	 */
	public void updateControls() throws UpdateControlsException {
		try {
			countAndCreateChildren();
			adapter.updateControls(this);
		
					} catch (InitContainerException e) {
			throw new UpdateControlsException(e);
		}
	}

	
 
	/**
	 * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
	 * @return
	 */
	public List getFields()
	{
		List fields = new ArrayList();
    				fields.add(get_RunAsRoot());
    				fields.add(get_usr_Restart());
    				fields.add(get_invoke_Start());
    				fields.add(get_invoke_Stop());
    				fields.add(get_Status());
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
		DnsServiceOperationsDataContainerImpl source = (DnsServiceOperationsDataContainerImpl)sourceContainer;
	
    	    		get_RunAsRoot().setValue(source.get_RunAsRoot().getValue());
		    		get_usr_Restart().setValue(source.get_usr_Restart().getValue());
		    		get_invoke_Start().setValue(source.get_invoke_Start().getValue());
		    		get_invoke_Stop().setValue(source.get_invoke_Stop().getValue());
		    		get_Status().setValue(source.get_Status().getValue());
				
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}