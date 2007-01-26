/** 
  * EditDnsSoaRecord.java
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

public class EditDnsSoaRecord extends CimCommand {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"EditDnsSoaRecord.hostname.argValue",true,false,"EditDnsSoaRecord.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","EditDnsSoaRecord.port.argValue",false,false,"EditDnsSoaRecord.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","EditDnsSoaRecord.namespace.argValue",false,false,"EditDnsSoaRecord.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"EditDnsSoaRecord.user.argValue",true,false,"EditDnsSoaRecord.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"EditDnsSoaRecord.password.argValue",true,false,"EditDnsSoaRecord.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","EditDnsSoaRecord.publickeyfile.argValue",false,false,"EditDnsSoaRecord.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","EditDnsSoaRecord.privatekeyfile.argValue",false,false,"EditDnsSoaRecord.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"EditDnsSoaRecord.dnsServiceName.argValue",true,false,"EditDnsSoaRecord.dnsServiceName.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_zoneName = new OptionDefinition("zoneName",null,"EditDnsSoaRecord.zoneName.argValue",true,false,"EditDnsSoaRecord.zoneName.argDescription");
	
			/**
		 * ${option.getOption().getComment()}
		 */
		public static final OptionDefinition KEY_server = new OptionDefinition("server",null,"DnsSoaContainer.Server.argValue",false,false,"DnsSoaContainer.Server.argDescription");
			/**
		 * ${option.getOption().getComment()}
		 */
		public static final OptionDefinition KEY_contact = new OptionDefinition("contact",null,"DnsSoaContainer.Contact.argValue",false,false,"DnsSoaContainer.Contact.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_serialNumber = new OptionDefinition("serialNumber",null,"DnsSoaContainer.SerialNumber.argValue",false,false,"DnsSoaContainer.SerialNumber.argDescription");
			/**
		 * ${option.getOption().getComment()}
		 */
		public static final OptionDefinition KEY_refresh = new OptionDefinition("refresh",null,"DnsSoaContainer.Refresh.argValue",false,false,"DnsSoaContainer.Refresh.argDescription");
			/**
		 * ${option.getOption().getComment()}
		 */
		public static final OptionDefinition KEY_retry = new OptionDefinition("retry",null,"DnsSoaContainer.Retry.argValue",false,false,"DnsSoaContainer.Retry.argDescription");
			/**
		 * ${option.getOption().getComment()}
		 */
		public static final OptionDefinition KEY_expire = new OptionDefinition("expire",null,"DnsSoaContainer.Expire.argValue",false,false,"DnsSoaContainer.Expire.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_negativeCachingTTL = new OptionDefinition("negativeCachingTTL",null,"DnsSoaContainer.NegativeCachingTTL.argValue",false,false,"DnsSoaContainer.NegativeCachingTTL.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_ttlUnit = new OptionDefinition("ttlUnit",null,"DnsSoaContainer.TTLUnit.argValue",false,false,"DnsSoaContainer.TTLUnit.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_setSerialNumber = new OptionDefinition("setSerialNumber",null,null,false,false,"DnsSoaContainer.setSerialNumber.argDescription");
		
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
    	    	KEY_zoneName,
    	    	    	KEY_server,
    	    	KEY_contact,
    	    	KEY_serialNumber,
    	    	KEY_refresh,
    	    	KEY_retry,
    	    	KEY_expire,
    	    	KEY_negativeCachingTTL,
    	    	KEY_ttlUnit,
    	    	KEY_setSerialNumber,
    			KEY_locale,
	};

		
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public EditDnsSoaRecord(java.util.Locale locale)
	{
		super("EditDnsSoaRecord", new String[]{"messages","messagesDns"},locale);
	}
	
	public void execute(String[] args) throws WbemSmtException {
		
	    Options options = createOptions(OPTIONS, bundle);

		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		//do the real processing
		System.out.println("\n" + bundle.getString("editing",new Object[]{bundle.getString("DnsSoaContainer.caption")}));
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
			
			CliDataLoader loader = new EditDnsSoaRecordLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsSoaContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsSoaContainerImpl(adapter);
						
        				
			setKeyValues(cmd,adapter,dc);

			adapter.updateControls(dc);
			adapter.setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);
			
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
			System.out.println("\n" + bundle.getString("edited", new Object[]{bundle.getString("DnsSoaContainer.caption")}));

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
	private void setKeyValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer dc) throws WbemSmtException {
    	    				    				    				    				    				    				    				    				    					}	
	
	/**
	 * Set all Values that are not read-Only
	 **/
	private void setValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer dc) throws WbemSmtException {
    										setValue(cmd,dc.get_Server(),KEY_server);
																						setValue(cmd,dc.get_Contact(),KEY_contact);
																						setValue(cmd,dc.get_SerialNumber(),KEY_serialNumber);
																						setValue(cmd,dc.get_Refresh(),KEY_refresh);
																						setValue(cmd,dc.get_Retry(),KEY_retry);
																						setValue(cmd,dc.get_Expire(),KEY_expire);
																						setValue(cmd,dc.get_NegativeCachingTTL(),KEY_negativeCachingTTL);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_usr_TTLUnit(),KEY_ttlUnit);
																								
		//The Buttons
    																																																																																		if (!pressButton(cmd,adapter,dc,dc.get_usr_SetSerialNumber(),KEY_setSerialNumber)) return;
								}	
}