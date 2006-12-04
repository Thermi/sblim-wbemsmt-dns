/** 
  * EditDnsForwardersForService.java
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
  * @template: ./tools-dcg/templates/cmd/editCommand.vm
  *
  * Contributors: 
  * 
  * Description: Class for editing objects
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.*;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.CimAdapterFactory;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.cli.*;

public class EditDnsForwardersForService extends CimCommand {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"EditDnsForwardersForService.hostname.argValue",true,false,"EditDnsForwardersForService.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","EditDnsForwardersForService.port.argValue",false,false,"EditDnsForwardersForService.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","EditDnsForwardersForService.namespace.argValue",false,false,"EditDnsForwardersForService.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"EditDnsForwardersForService.user.argValue",true,false,"EditDnsForwardersForService.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"EditDnsForwardersForService.password.argValue",true,false,"EditDnsForwardersForService.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","EditDnsForwardersForService.publickeyfile.argValue",false,false,"EditDnsForwardersForService.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","EditDnsForwardersForService.privatekeyfile.argValue",false,false,"EditDnsForwardersForService.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"EditDnsForwardersForService.dnsServiceName.argValue",true,false,"EditDnsForwardersForService.dnsServiceName.argDescription");
	
			/**
		 * 
		 */
		public static final OptionDefinition KEY_forward = new OptionDefinition("forward",null,"DnsForwarderDataContainer.Forward.argValue",false,false,"DnsForwarderDataContainer.Forward.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_forwarders = new OptionDefinition("forwarders",null,"DnsForwarderDataContainer.Forwarders.argValue",false,false,"DnsForwarderDataContainer.Forwarders.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_removeForwarder = new OptionDefinition("removeForwarder",null,null,false,false,"DnsForwarderDataContainer.removeForwarder.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_newForwarder = new OptionDefinition("newForwarder",null,"DnsForwarderDataContainer.newForwarder.argValue",false,false,"DnsForwarderDataContainer.newForwarder.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_addForwarder = new OptionDefinition("addForwarder",null,null,false,false,"DnsForwarderDataContainer.addForwarder.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_newForwarderType = new OptionDefinition("newForwarderType",null,"DnsForwarderDataContainer.newForwarderType.argValue",false,false,"DnsForwarderDataContainer.newForwarderType.argDescription");
		
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
    	    	    	KEY_forward,
    	    	KEY_forwarders,
    	    	KEY_removeForwarder,
    	    	KEY_newForwarder,
    	    	KEY_addForwarder,
    	    	KEY_newForwarderType,
    			KEY_locale,
	};

		
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public EditDnsForwardersForService(java.util.Locale locale)
	{
		super("EditDnsForwardersForService", new String[]{"messages","messagesDns"},locale);
	}
	
	public void execute(String[] args) throws WbemSmtException {
		
	    Options options = createOptions(OPTIONS, bundle);

		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		//do the real processing
		System.out.println("\n" + bundle.getString("editing",new Object[]{bundle.getString("DnsForwardersForServiceDataContainer.caption")}));
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
			
			CliDataLoader loader = new EditDnsForwardersForServiceLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsForwardersForServiceDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsForwardersForServiceDataContainerImpl(adapter);
						
        				
			setKeyValues(cmd,adapter,dc);

			adapter.updateControls(dc);
			
			System.out.println("\n" + bundle.getString("before.edit"));
			dc.trace(System.out);

			setValues(cmd,adapter,dc);
			
			MessageList result = MessageList.init(dc);

			if (result.hasErrors())
			{
				traceErrors("save.error",result);
				return;
			}
			else
			{
				traceMessages("additional.messages",result);
				result.clear();
			}
							

			adapter.validateValues(dc);
			result = dc.getMessagesList();
			if (!result.hasErrors())
			{
				adapter.save(dc);
				//Get the infos afte storing the values
				result = dc.getMessagesList();
				if (result.hasErrors())
				{
					traceErrors("save.error",result);
				}
				else if (result.hasWarning())
				{
					traceErrors("save.warning",result);
				}
				else if (result.hasInfo())
				{
					traceErrors("save.info",result);
				}
			}
			else
			{
					traceErrors("validation.error",result);
					return;
			}
			System.out.println("\n" + bundle.getString("edited", new Object[]{bundle.getString("DnsForwardersForServiceDataContainer.caption")}));

			adapter.updateControls(dc);

			System.out.println("\n" + bundle.getString("after.edit"));
			dc.trace(System.out);
		
		}
		catch (Exception e)
		{
			super.handleException(e,args,options,KEY_GLOBAL_password);
		}
	}
	
	/**
	 * Set all Values that are needed for selecting the right objects. This fields are used even if they are read-only
	 **/
	private void setKeyValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer dc) throws WbemSmtException {
    	    				    				    				    				    				    					}	
	
	/**
	 * Set all Values that are not read-Only
	 **/
	private void setValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer dc) throws WbemSmtException {
    																setMultiValue(adapter.getBundle(),cmd,dc.get_Forward(),KEY_forward);
																						setMultiValue(adapter.getBundle(),cmd,dc.get_Forwarders(),KEY_forwarders);
																															setValue(cmd,dc.get_usr_NewForwarder(),KEY_newForwarder);
																																											setMultiValue(adapter.getBundle(),cmd,dc.get_usr_NewForwarderType(),KEY_newForwarderType);
									
		//The Buttons
    																												if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveForwarder(),KEY_removeForwarder)) return;
																									if (!pressButton(cmd,adapter,dc,dc.get_usr_AddForwarder(),KEY_addForwarder)) return;
																	}	
}