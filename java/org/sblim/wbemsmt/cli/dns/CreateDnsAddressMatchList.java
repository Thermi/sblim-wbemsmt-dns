/** 
  * CreateDnsAddressMatchList.java
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

public class CreateDnsAddressMatchList extends CimCommand implements ContainerUpdater {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"CreateDnsAddressMatchList.hostname.argValue",true,false,"CreateDnsAddressMatchList.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","CreateDnsAddressMatchList.port.argValue",false,false,"CreateDnsAddressMatchList.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","CreateDnsAddressMatchList.namespace.argValue",false,false,"CreateDnsAddressMatchList.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"CreateDnsAddressMatchList.user.argValue",true,false,"CreateDnsAddressMatchList.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"CreateDnsAddressMatchList.password.argValue",true,false,"CreateDnsAddressMatchList.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","CreateDnsAddressMatchList.publickeyfile.argValue",false,false,"CreateDnsAddressMatchList.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","CreateDnsAddressMatchList.privatekeyfile.argValue",false,false,"CreateDnsAddressMatchList.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"CreateDnsAddressMatchList.dnsServiceName.argValue",true,false,"CreateDnsAddressMatchList.dnsServiceName.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_matchListName = new OptionDefinition("matchListName",null,"DnsAddressMatchListWizardPage1DataContainer.Name.argValue",true,false,"DnsAddressMatchListWizardPage1DataContainer.Name.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addressList = new OptionDefinition("addressList",null,"DnsAddressMatchListDataContainer.AddressList.argValue",false,false,"DnsAddressMatchListDataContainer.AddressList.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_removeAddress = new OptionDefinition("removeAddress",null,null,false,false,"DnsAddressMatchListDataContainer.removeAddress.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_userAddresses = new OptionDefinition("userAddresses",null,"DnsAddressMatchListDataContainer.userAddresses.argValue",false,false,"DnsAddressMatchListDataContainer.userAddresses.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_newAddress = new OptionDefinition("newAddress",null,"DnsAddressMatchListDataContainer.newAddress.argValue",false,false,"DnsAddressMatchListDataContainer.newAddress.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addPredefinedAddress = new OptionDefinition("addPredefinedAddress",null,null,false,false,"DnsAddressMatchListDataContainer.addPredefinedAddress.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addNewAddress = new OptionDefinition("addNewAddress",null,null,false,false,"DnsAddressMatchListDataContainer.addNewAddress.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addressUp = new OptionDefinition("addressUp",null,null,false,false,"DnsAddressMatchListDataContainer.addressUp.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addressDown = new OptionDefinition("addressDown",null,null,false,false,"DnsAddressMatchListDataContainer.addressDown.argDescription");
		
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
    	    	KEY_matchListName,
    	    	KEY_addressList,
    	    	KEY_removeAddress,
    	    	KEY_userAddresses,
    	    	KEY_newAddress,
    	    	KEY_addPredefinedAddress,
    	    	KEY_addNewAddress,
    	    	KEY_addressUp,
    	    	KEY_addressDown,
    			KEY_locale,
	};

	
	
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public CreateDnsAddressMatchList(java.util.Locale locale)
	{
		super("CreateDnsAddressMatchList", new String[]{"messages","messagesDns"},locale);
	}

	public void execute(String[] args) throws WbemSmtException {

	    Options options = createOptions(OPTIONS, bundle);
		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		System.out.println("\n" + bundle.getString("creating", new Object[]{bundle.getString("AddressMatchListWizard.caption")}));
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
			
			CliDataLoader loader = new CreateDnsAddressMatchListLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.wizard.AddressMatchListWizard wizard = new org.sblim.wbemsmt.cli.dns.wizard.AddressMatchListWizard((org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) adapter);
			wizard.startWizard();
			
			while (!wizard.getContainer().isLast(wizard.getContainer().getCurrentPageName()))
			{
				BaseDataContainer dataContainer = wizard.getCurrentPanel();
				if (true == false);
								else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer) setCommandLineValues(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)dataContainer);
								else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer) setCommandLineValues(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)dataContainer);
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
						else if (lastPanel instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer) ((CreateDnsAddressMatchListLoader)loader).loadTracingObject(bundle,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)lastPanel);
						else {
				logger.severe("Cannot loadTracingObject for " + lastPanel.getClass().getName());
				throw new WbemSmtException(bundle.getString("internal.error"));
			}
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsAddressMatchListDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAddressMatchListDataContainerImpl(adapter);

						
        				
			adapter.updateControls(dc);
			System.out.println("\n" + bundle.getString("createdObject") + ":\n");
			dc.trace(System.out);
			
		System.out.println("\n" + bundle.getString("created", new Object[]{bundle.getString("AddressMatchListWizard.caption")}));
		
		}
		catch (Exception e)
		{
			super.handleException(e,args,options,KEY_GLOBAL_password);
		}
	}
    
	public void prepareForUpdateControls(DataContainer dataContainer) throws UpdateControlsException
	{
		if (true == false);
				else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer) updateContainerChilds(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)dataContainer);
				else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer) updateContainerChilds(cmd,adapter,(org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)dataContainer);
				else {

				logger.severe("Cannot setValues for Container " + dataContainer.getClass().getName());
				throw new UpdateControlsException("Cannot setValues for Container " + dataContainer.getClass().getName());
		}
	}
	
			
	private void updateContainerChilds(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer dc) throws UpdateControlsException {
		
		try
		{
    		//update the child-containers
    		
			    		
        			}
		catch (Exception e)
		{
				throw new UpdateControlsException(bundle.getString("internal.error"),e);
		}
		
		
	}
	
	private void setCommandLineValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer dc) throws WbemSmtException {
		//set the values
											setValue(cmd,dc.get_Name(),KEY_matchListName);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_AddressList(),KEY_addressList);
																																					setMultiValue(adapter.getBundle(),cmd,dc.get_usr_UserAddresses(),KEY_userAddresses);
																setValue(cmd,dc.get_usr_NewAddress(),KEY_newAddress);
																																																																											
		//The Buttons
    																												if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveAddress(),KEY_removeAddress)) return;
																																		if (!pressButton(cmd,adapter,dc,dc.get_usr_AddPredefinedAddress(),KEY_addPredefinedAddress)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddNewAddress(),KEY_addNewAddress)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddressUp(),KEY_addressUp)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddressDown(),KEY_addressDown)) return;
									
	}	

			
	private void updateContainerChilds(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer dc) throws UpdateControlsException {
		
		try
		{
    		//update the child-containers
    		
			    		
        			}
		catch (Exception e)
		{
				throw new UpdateControlsException(bundle.getString("internal.error"),e);
		}
		
		
	}
	
	private void setCommandLineValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer dc) throws WbemSmtException {
		//set the values
				
		//The Buttons
    			
	}	

	}