/** 
  * CreateDnsReverseZone.java
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
  * @template: ./tools-dcg/templates/cmd/createCommand.vm
  *
  * Contributors: 
  * 
  * Description: Class for creating objects
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.GnuParser;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.BaseDataContainer;
import org.sblim.wbemsmt.bl.adapter.CimAdapterFactory;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.exception.UpdateControlsException;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.tools.cli.*;
import org.sblim.wbemsmt.tools.wizard.cli.*;

public class CreateDnsReverseZone extends CimCommand implements ContainerUpdater {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"CreateDnsReverseZone.hostname.argValue",true,false,"CreateDnsReverseZone.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","CreateDnsReverseZone.port.argValue",false,false,"CreateDnsReverseZone.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","CreateDnsReverseZone.namespace.argValue",false,false,"CreateDnsReverseZone.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"CreateDnsReverseZone.user.argValue",true,false,"CreateDnsReverseZone.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"CreateDnsReverseZone.password.argValue",true,false,"CreateDnsReverseZone.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","CreateDnsReverseZone.publickeyfile.argValue",false,false,"CreateDnsReverseZone.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","CreateDnsReverseZone.privatekeyfile.argValue",false,false,"CreateDnsReverseZone.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"CreateDnsReverseZone.dnsServiceName.argValue",true,false,"CreateDnsReverseZone.dnsServiceName.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_zoneNameToReverse = new OptionDefinition("zoneNameToReverse",null,"CreateDnsReverseZone.zoneNameToReverse.argValue",true,false,"CreateDnsReverseZone.zoneNameToReverse.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_ipAddress = new OptionDefinition("ipAddress",null,"DnsReverseZoneWizardPage1DataContainer.ipAddress.argValue",true,false,"DnsReverseZoneWizardPage1DataContainer.ipAddress.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_resourceRecordToUse = new OptionDefinition("resourceRecordToUse",null,"DnsReverseZoneWizardPage1DataContainer.resourceRecordNotUsed.argValue",false,false,"DnsReverseZoneWizardPage1DataContainer.resourceRecordNotUsed.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addResourceRecord = new OptionDefinition("addResourceRecord",null,null,false,false,"DnsReverseZoneWizardPage1DataContainer.addResourceRecord.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addAllResourceRecords = new OptionDefinition("addAllResourceRecords",null,null,false,false,"DnsReverseZoneWizardPage1DataContainer.addAllResourceRecords.argDescription");
		
public static final OptionDefinition KEY_locale = new OptionDefinition("locale","en","locale",false,false,"locale");	
	
	private static final OptionDefinition[] OPTIONS = new OptionDefinition []
	{
    	    	KEY_GLOBAL_hostname,
    	    	KEY_GLOBAL_port,
    	    	KEY_GLOBAL_namespace,
    	    	KEY_GLOBAL_user,
    	    	KEY_GLOBAL_password,
    	    	KEY_GLOBAL_publickeyfile,
    	    	KEY_GLOBAL_privatekeyfile,
    	    	KEY_GLOBAL_dnsServiceName,
    	    	KEY_zoneNameToReverse,
    	    	KEY_ipAddress,
    	    	KEY_resourceRecordToUse,
    	    	KEY_addResourceRecord,
    	    	KEY_addAllResourceRecords,
    			KEY_locale,
	};

	
	
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public CreateDnsReverseZone(java.util.Locale locale)
	{
		super("CreateDnsReverseZone", new String[]{"messages","messagesDns"},locale);
	}

	public void execute(String[] args) throws WbemSmtException {

	    Options options = createOptions(OPTIONS, bundle);
		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		System.out.println("\n" + bundle.getString("creating", new Object[]{bundle.getString("createReverseZoneWizard.caption")}));
		//do the real processing
		try {
			
 
			
			CommandLineParser parser = new GnuParser();
			
			//check if the password is the only argument that is missing and query the user if thats the case
			args = super.checkPassword(parser,options,args,KEY_GLOBAL_hostname,KEY_GLOBAL_user,KEY_GLOBAL_password);
			
			cmd = parser.parse( options, args);
			adapter = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,this);
			adapter.setBundle(bundle);
			adapter.setCimClient(getCimClient(cmd, 
				KEY_GLOBAL_hostname,
				KEY_GLOBAL_port,
				KEY_GLOBAL_namespace,
				KEY_GLOBAL_user,
				KEY_GLOBAL_password,
				KEY_GLOBAL_publickeyfile,
				KEY_GLOBAL_privatekeyfile));
				
			adapter.loadInitial(adapter.getCimClient());
			
			CliDataLoader loader = new CreateDnsReverseZoneLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.wizard.CreateReverseZoneWizard wizard = new org.sblim.wbemsmt.cli.dns.wizard.CreateReverseZoneWizard((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) adapter);
			wizard.startWizard();
			
			while (!wizard.getContainer().isLast(wizard.getContainer().getCurrentPageName()))
			{
				BaseDataContainer dataContainer = wizard.getCurrentPanel();
				if (true == false);
								else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer) setCommandLineValues(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)dataContainer);
								else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer) setCommandLineValues(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer)dataContainer);
								else {
					logger.severe(dataContainer.getClass().getName() + " cannot be handled from command class "  + this.getClass().getName());
										throw new WbemSmtException(bundle.getString("internal.error"));
				}

				MessageList result = MessageList.init(dataContainer);					
				if (result.hasErrors())
				{
    					traceErrors(result);
    					return;
				}
				else
				{
					traceMessages("additional.messages",result);
					result.clear();
				}
				
				wizard.next(this);
				result = wizard.getCurrentPanel().getMessagesList();

				if (result != null)
				{
					if (result.hasErrors())
					{
    					traceErrors("validation.error",result);
    					return;
					}
					else
					{
						traceMessages("additional.messages",result);
						dataContainer.getMessagesList().clear();
					}
				}
			}			
			
			BaseDataContainer lastPanel = wizard.getCurrentPanel();
			wizard.finish();

			if (true == false);
						else if (lastPanel instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer) ((CreateDnsReverseZoneLoader)loader).loadTracingObject(bundle,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer)lastPanel);
						else {
				logger.severe("Cannot loadTracingObject for " + lastPanel.getClass().getName());
				throw new WbemSmtException(bundle.getString("internal.error"));
			}
			
			org.sblim.wbemsmt.cli.dns.container.wizard.DnsReverseZoneWizardSummaryDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsReverseZoneWizardSummaryDataContainerImpl(adapter);

						int count = 0;
						
        	    		
			count = adapter.count(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer.class);
			dc.getResourceRecords().clear();
			for (int i=0; i < count; i++) {
				org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainerImpl child = new org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainerImpl(adapter);
				dc.getResourceRecords().add(child);
			}
        				
			adapter.updateControls(dc);
			System.out.println("\n" + bundle.getString("createdObject") + ":\n");
			dc.trace(System.out);
			
		System.out.println("\n" + bundle.getString("created", new Object[]{bundle.getString("createReverseZoneWizard.caption")}));
		
		}
		catch (Exception e)
		{
			super.handleException(e,args,options,KEY_GLOBAL_password);
		}
	}
    
	public void prepareForUpdateControls(DataContainer dataContainer) throws UpdateControlsException
	{
		if (true == false);
				else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer) updateContainerChilds(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer)dataContainer);
				else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer) updateContainerChilds(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer)dataContainer);
				else {

				logger.severe("Cannot setValues for Container " + dataContainer.getClass().getName());
				throw new UpdateControlsException("Cannot setValues for Container " + dataContainer.getClass().getName());
		}
	}
	
			
	private void updateContainerChilds(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer dc) throws UpdateControlsException {
		
		try
		{
    		//update the child-containers
    		
			    		
        			}
		catch (Exception e)
		{
				throw new UpdateControlsException(bundle.getString("internal.error"),e);
		}
		
		
	}
	
	private void setCommandLineValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer dc) throws WbemSmtException {
		//set the values
											setValue(cmd,dc.get_usr_IpAddress(),KEY_ipAddress);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_usr_ResourceRecordNotUsed(),KEY_resourceRecordToUse);
																																							
		//The Buttons
    																												if (!pressButton(cmd,adapter,dc,dc.get_usr_AddResourceRecord(),KEY_addResourceRecord)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddAllResourceRecords(),KEY_addAllResourceRecords)) return;
									
	}	

			
	private void updateContainerChilds(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer dc) throws UpdateControlsException {
		
		try
		{
    		//update the child-containers
    		
						int count = 0;
			    		
        	    		
    		count = adapter.count(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer.class);
    		dc.getResourceRecords().clear();
    		for (int i=0; i < count; i++) {
    			org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainerImpl child = new org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordForReverseZoneWizardDataContainerImpl(adapter);
    			dc.getResourceRecords().add(child);
    		}
					}
		catch (Exception e)
		{
				throw new UpdateControlsException(bundle.getString("internal.error"),e);
		}
		
		
	}
	
	private void setCommandLineValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer dc) throws WbemSmtException {
		//set the values
				
		//The Buttons
    			
	}	

	}