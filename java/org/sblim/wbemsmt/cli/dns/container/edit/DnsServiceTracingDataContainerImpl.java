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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/cmd/containerImpl.vm
  *
  * Contributors: 
  * 
  * Description: Container for Tracing the DNService
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.edit;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsServiceTracingDataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer
	{
		
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer icAllowNotifyAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer icAllowQueryAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer icAllowTransferAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer icAllowRecursionAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer icBlackholeAcl = null;
			private org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer icConfiguration = null;
		
	public DnsServiceTracingDataContainerImpl(AbstractBaseCimAdapter adapter) throws InitContainerException {
		super();
		setAdapter(adapter);
    	    	icAllowNotifyAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForServiceDataContainerImpl(adapter);
    	    	icAllowQueryAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForServiceDataContainerImpl(adapter);
    	    	icAllowTransferAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForServiceDataContainerImpl(adapter);
    	    	icAllowRecursionAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowRecursionForServiceDataContainerImpl(adapter);
    	    	icBlackholeAcl = new org.sblim.wbemsmt.cli.dns.container.edit.DnsBlackholeForServiceDataContainerImpl(adapter);
    	    	icConfiguration = new org.sblim.wbemsmt.cli.dns.container.edit.DnsConfigurationDataContainerImpl(adapter);
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

		
	public void trace(java.io.PrintWriter 	printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(getAdapter().getBundle().getString("DnsServiceTracingDataContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
					}

		if (showChilds(listOptions))
		{
			traceChilds(printStream,listOptions,title);
		}
	}
	
	public void traceChilds(java.io.PrintWriter printStream, String listOptions, boolean title)
	{
    			
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForServiceDataContainerImpl childallowNotifyAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowNotifyForServiceDataContainerImpl)getAllowNotifyAcl();
        		printStream.println();
        		printStream.println("allowNotifyAcl");
            	childallowNotifyAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForServiceDataContainerImpl childallowQueryAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowQueryForServiceDataContainerImpl)getAllowQueryAcl();
        		printStream.println();
        		printStream.println("allowQueryAcl");
            	childallowQueryAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForServiceDataContainerImpl childallowTransferAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForServiceDataContainerImpl)getAllowTransferAcl();
        		printStream.println();
        		printStream.println("allowTransferAcl");
            	childallowTransferAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowRecursionForServiceDataContainerImpl childallowRecursionAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowRecursionForServiceDataContainerImpl)getAllowRecursionAcl();
        		printStream.println();
        		printStream.println("allowRecursionAcl");
            	childallowRecursionAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsBlackholeForServiceDataContainerImpl childblackholeAcl = (org.sblim.wbemsmt.cli.dns.container.edit.DnsBlackholeForServiceDataContainerImpl)getBlackholeAcl();
        		printStream.println();
        		printStream.println("blackholeAcl");
            	childblackholeAcl.trace(printStream,listOptions,false);
			        
        		org.sblim.wbemsmt.cli.dns.container.edit.DnsConfigurationDataContainerImpl childconfiguration = (org.sblim.wbemsmt.cli.dns.container.edit.DnsConfigurationDataContainerImpl)getConfiguration();
        		printStream.println();
        		printStream.println("configuration");
            	childconfiguration.trace(printStream,listOptions,false);
			
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