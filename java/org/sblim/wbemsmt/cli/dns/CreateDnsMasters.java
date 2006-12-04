/** 
  * CreateDnsMasters.java
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

public class CreateDnsMasters extends CimCommand implements ContainerUpdater {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"CreateDnsMasters.hostname.argValue",true,false,"CreateDnsMasters.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","CreateDnsMasters.port.argValue",false,false,"CreateDnsMasters.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","CreateDnsMasters.namespace.argValue",false,false,"CreateDnsMasters.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"CreateDnsMasters.user.argValue",true,false,"CreateDnsMasters.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"CreateDnsMasters.password.argValue",true,false,"CreateDnsMasters.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","CreateDnsMasters.publickeyfile.argValue",false,false,"CreateDnsMasters.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","CreateDnsMasters.privatekeyfile.argValue",false,false,"CreateDnsMasters.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"CreateDnsMasters.dnsServiceName.argValue",true,false,"CreateDnsMasters.dnsServiceName.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_mastersName = new OptionDefinition("mastersName",null,"DnsMastersWizardPage1DataContainer.Name.argValue",true,false,"DnsMastersWizardPage1DataContainer.Name.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_masters = new OptionDefinition("masters",null,"DnsAddMasterAddressDataContainer.masters.argValue",false,false,"DnsAddMasterAddressDataContainer.masters.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_removeMasterEntry = new OptionDefinition("removeMasterEntry",null,null,false,false,"DnsAddMasterAddressDataContainer.removeMasterEntry.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_newMasterEntry = new OptionDefinition("newMasterEntry",null,"DnsAddMasterAddressDataContainer.newMasterEntry.argValue",false,false,"DnsAddMasterAddressDataContainer.newMasterEntry.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addNewMasterEntry = new OptionDefinition("addNewMasterEntry",null,null,false,false,"DnsAddMasterAddressDataContainer.addNewMasterEntry.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addPredefinedMaster = new OptionDefinition("addPredefinedMaster",null,null,false,false,"DnsAddMasterAddressDataContainer.addPredefinedMaster.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_predefinedMasters = new OptionDefinition("predefinedMasters",null,"DnsAddMasterAddressDataContainer.predefinedMasters.argValue",false,false,"DnsAddMasterAddressDataContainer.predefinedMasters.argDescription");
		
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
    	    	KEY_mastersName,
    	    	KEY_masters,
    	    	KEY_removeMasterEntry,
    	    	KEY_newMasterEntry,
    	    	KEY_addNewMasterEntry,
    	    	KEY_addPredefinedMaster,
    	    	KEY_predefinedMasters,
    			KEY_locale,
	};

	
	
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public CreateDnsMasters(java.util.Locale locale)
	{
		super("CreateDnsMasters", new String[]{"messages","messagesDns"},locale);
	}

	public void execute(String[] args) throws WbemSmtException {

	    Options options = createOptions(OPTIONS, bundle);
		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		System.out.println("\n" + bundle.getString("creating", new Object[]{bundle.getString("MasterWizard.caption")}));
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
			
			CliDataLoader loader = new CreateDnsMastersLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.wizard.MasterWizard wizard = new org.sblim.wbemsmt.cli.dns.wizard.MasterWizard((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) adapter);
			wizard.startWizard();
			
			while (!wizard.getContainer().isLast(wizard.getContainer().getCurrentPageName()))
			{
				BaseDataContainer dataContainer = wizard.getCurrentPanel();
				if (true == false);
								else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer) setCommandLineValues(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer)dataContainer);
								else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer) setCommandLineValues(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer)dataContainer);
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
						else if (lastPanel instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer) ((CreateDnsMastersLoader)loader).loadTracingObject(bundle,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer)lastPanel);
						else {
				logger.severe("Cannot loadTracingObject for " + lastPanel.getClass().getName());
				throw new WbemSmtException(bundle.getString("internal.error"));
			}
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsMasterDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsMasterDataContainerImpl(adapter);

						
        				
			adapter.updateControls(dc);
			System.out.println("\n" + bundle.getString("createdObject") + ":\n");
			dc.trace(System.out);
			
		System.out.println("\n" + bundle.getString("created", new Object[]{bundle.getString("MasterWizard.caption")}));
		
		}
		catch (Exception e)
		{
			super.handleException(e,args,options,KEY_GLOBAL_password);
		}
	}
    
	public void prepareForUpdateControls(DataContainer dataContainer) throws UpdateControlsException
	{
		if (true == false);
				else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer) updateContainerChilds(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer)dataContainer);
				else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer) updateContainerChilds(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer)dataContainer);
				else {

				logger.severe("Cannot setValues for Container " + dataContainer.getClass().getName());
				throw new UpdateControlsException("Cannot setValues for Container " + dataContainer.getClass().getName());
		}
	}
	
			
	private void updateContainerChilds(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer dc) throws UpdateControlsException {
		
		try
		{
    		//update the child-containers
    		
			    		
        			}
		catch (Exception e)
		{
				throw new UpdateControlsException(bundle.getString("internal.error"),e);
		}
		
		
	}
	
	private void setCommandLineValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer dc) throws WbemSmtException {
		//set the values
											setValue(cmd,dc.get_Name(),KEY_mastersName);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_Masters(),KEY_masters);
																															setValue(cmd,dc.get_usr_NewMasterEntry(),KEY_newMasterEntry);
																																																										setMultiValue(adapter.getBundle(),cmd,dc.get_usr_PredefinedMasters(),KEY_predefinedMasters);
									
		//The Buttons
    																												if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveMasterEntry(),KEY_removeMasterEntry)) return;
																									if (!pressButton(cmd,adapter,dc,dc.get_usr_AddNewMasterEntry(),KEY_addNewMasterEntry)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddPredefinedMaster(),KEY_addPredefinedMaster)) return;
																		
	}	

			
	private void updateContainerChilds(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer dc) throws UpdateControlsException {
		
		try
		{
    		//update the child-containers
    		
			    		
        			}
		catch (Exception e)
		{
				throw new UpdateControlsException(bundle.getString("internal.error"),e);
		}
		
		
	}
	
	private void setCommandLineValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer dc) throws WbemSmtException {
		//set the values
				
		//The Buttons
    			
	}	

	}