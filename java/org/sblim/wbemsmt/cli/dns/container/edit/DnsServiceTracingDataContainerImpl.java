/** 
  * DnsServiceTracingDataContainerImpl.java
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
  * Description: Container for Tracing the DNService
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

public class DnsServiceTracingDataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer {

	protected static WbemSmtResourceBundle bundle = ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},Locale.getDefault());

		
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

		
	public void trace(java.io.PrintStream printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(bundle.getString("DnsServiceTracingDataContainer.caption"));
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
	
	public void traceChilds(java.io.PrintStream printStream, String listOptions, boolean title)
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
	
}