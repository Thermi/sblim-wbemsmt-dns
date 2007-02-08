/** 
  * DnsServiceTracingDataContainerImpl.java
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
  * @template: ./tools-dcg/templates/jsf/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: Container for Tracing the DNService
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.container.edit;

import org.sblim.wbemsmt.exception.*;
import java.util.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsServiceTracingDataContainerImpl extends org.sblim.wbemsmt.tools.jsf.EditBasePanel implements org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer {

		
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer icAllowNotifyAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer icAllowQueryAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer icAllowTransferAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer icAllowRecursionAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer icBlackholeAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer icConfiguration = null;
		
	
	public DnsServiceTracingDataContainerImpl(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter,String bindingPrefix) throws InitContainerException  {

			
				super(adapter,bindingPrefix, "DnsServiceTracingDataContainer.caption",false);
				
				String childBindingPrefix = null;
				
    				childBindingPrefix = this.bindingPrefix + "allowNotifyAcl.";
    		icAllowNotifyAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowNotifyForServiceDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "allowQueryAcl.";
    		icAllowQueryAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForServiceDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "allowTransferAcl.";
    		icAllowTransferAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForServiceDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "allowRecursionAcl.";
    		icAllowRecursionAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowRecursionForServiceDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "blackholeAcl.";
    		icBlackholeAcl 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsBlackholeForServiceDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    				childBindingPrefix = this.bindingPrefix + "configuration.";
    		icConfiguration 
				= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsConfigurationDataContainerImpl((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)org.sblim.wbemsmt.bl.adapter.CimAdapterFactory.getInstance()
                         				   .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,javax.faces.context.FacesContext.getCurrentInstance(),adapter.getCimClient())
					                     ,childBindingPrefix);
    			
    	    						
		setFooter(getPanelForCustomLayout(),"DnsServiceTracingDataContainer.footerText");
		adapter.initContainer(this);
	}
	

		
	
			
		/**
		* 
		* linked container DnsAllowNotifyForServiceDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer getAllowNotifyAcl()
		{
						return icAllowNotifyAcl;
		}

			
		/**
		* 
		* linked container DnsAllowQueryForServiceDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer getAllowQueryAcl()
		{
						return icAllowQueryAcl;
		}

			
		/**
		* 
		* linked container DnsAllowTransferForServiceDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer getAllowTransferAcl()
		{
						return icAllowTransferAcl;
		}

			
		/**
		* 
		* linked container DnsAllowRecursionForServiceDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer getAllowRecursionAcl()
		{
						return icAllowRecursionAcl;
		}

			
		/**
		* 
		* linked container DnsBlackholeForServiceDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer getBlackholeAcl()
		{
						return icBlackholeAcl;
		}

			
		/**
		* 
		* linked container DnsConfigurationDataContainer
		*/
		
		public org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer getConfiguration()
		{
						return icConfiguration;
		}

		
	public void reload()
	{
		super.reload();
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
    			return fields;
	}

	/**
	 * Return a list of all associated childContainers. A childContainer is a DataContainer
	 * @return
	 */
	public List getChildContainers()
	{
		List childs = new ArrayList();
    	    	    		childs.add(getAllowNotifyAcl());
		    		childs.add(getAllowQueryAcl());
		    		childs.add(getAllowTransferAcl());
		    		childs.add(getAllowRecursionAcl());
		    		childs.add(getBlackholeAcl());
		    		childs.add(getConfiguration());
				return childs;
	
	}
	
	public void copyFrom(DataContainer sourceContainer)
	{
		DnsServiceTracingDataContainerImpl source = (DnsServiceTracingDataContainerImpl)sourceContainer;
	
    			
    	    	    		getAllowNotifyAcl().copyFrom(source.getAllowNotifyAcl());
		    		getAllowQueryAcl().copyFrom(source.getAllowQueryAcl());
		    		getAllowTransferAcl().copyFrom(source.getAllowTransferAcl());
		    		getAllowRecursionAcl().copyFrom(source.getAllowRecursionAcl());
		    		getBlackholeAcl().copyFrom(source.getBlackholeAcl());
		    		getConfiguration().copyFrom(source.getConfiguration());
			}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		

	
}