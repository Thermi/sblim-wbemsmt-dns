/** 
  * DeleteDnsAddressMatchList.java
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
  * @template: ./tools-dcg/templates/cmd/deleteCommand.vm
  *
  * Contributors: 
  * 
  * Description: Class for  deleteting objects
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.*;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.CimAdapterFactory;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.tools.cli.*;

public class DeleteDnsAddressMatchList extends CimCommand {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"DeleteDnsAddressMatchList.hostname.argValue",true,false,"DeleteDnsAddressMatchList.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","DeleteDnsAddressMatchList.port.argValue",false,false,"DeleteDnsAddressMatchList.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","DeleteDnsAddressMatchList.namespace.argValue",false,false,"DeleteDnsAddressMatchList.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"DeleteDnsAddressMatchList.user.argValue",true,false,"DeleteDnsAddressMatchList.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"DeleteDnsAddressMatchList.password.argValue",true,false,"DeleteDnsAddressMatchList.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","DeleteDnsAddressMatchList.publickeyfile.argValue",false,false,"DeleteDnsAddressMatchList.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","DeleteDnsAddressMatchList.privatekeyfile.argValue",false,false,"DeleteDnsAddressMatchList.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"DeleteDnsAddressMatchList.dnsServiceName.argValue",true,false,"DeleteDnsAddressMatchList.dnsServiceName.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_matchListName = new OptionDefinition("matchListName",null,"DnsAddressMatchListForServiceDataContainer.Name.argValue",true,true,"DnsAddressMatchListForServiceDataContainer.Name.argDescription");
	
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
    			KEY_locale,
	};

		
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public DeleteDnsAddressMatchList(java.util.Locale locale)
	{
		super("DeleteDnsAddressMatchList", new String[]{"messages","messagesDns"},locale);
	}
	
	public void execute(String[] args) throws WbemSmtException {
		
	    Options options = createOptions(OPTIONS, bundle);

		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		//do the real processing
		System.out.println("\n" + bundle.getString("deleting",new Object[]{bundle.getString("DnsAddressMatchListForServiceDataContainer.caption")}));
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
			
			CliDataLoader loader = new DeleteDnsAddressMatchListLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsAddressMatchListForServiceDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAddressMatchListForServiceDataContainerImpl(adapter);
			
						
        				
			adapter.updateControls(dc);
			
			dc.trace(System.out);
			
			if (getConfirmation())
			{
    			adapter.delete();
    			System.out.println("\n" + bundle.getString("deleted",new Object[]{bundle.getString("DnsAddressMatchListForServiceDataContainer.caption")}));
			}
			else
			{
    			System.out.println("\n" + bundle.getString("not.deleted",new Object[]{bundle.getString("DnsAddressMatchListForServiceDataContainer.caption")}));
			}
			
		
		}
		catch (Exception e)
		{
			super.handleException(e,args,options,KEY_GLOBAL_password);
		}
	}
}