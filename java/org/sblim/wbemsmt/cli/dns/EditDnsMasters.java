/** 
  * EditDnsMasters.java
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

public class EditDnsMasters extends CimCommand {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"EditDnsMasters.hostname.argValue",true,false,"EditDnsMasters.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","EditDnsMasters.port.argValue",false,false,"EditDnsMasters.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","EditDnsMasters.namespace.argValue",false,false,"EditDnsMasters.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"EditDnsMasters.user.argValue",true,false,"EditDnsMasters.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"EditDnsMasters.password.argValue",true,false,"EditDnsMasters.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","EditDnsMasters.publickeyfile.argValue",false,false,"EditDnsMasters.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","EditDnsMasters.privatekeyfile.argValue",false,false,"EditDnsMasters.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"EditDnsMasters.dnsServiceName.argValue",true,false,"EditDnsMasters.dnsServiceName.argDescription");
	
			/**
		 * 
		 */
		public static final OptionDefinition KEY_mastersName = new OptionDefinition("mastersName",null,"DnsMastersForServiceDataContainer.Name.argValue",true,true,"DnsMastersForServiceDataContainer.Name.argDescription");
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

	
	public EditDnsMasters(java.util.Locale locale)
	{
		super("EditDnsMasters", new String[]{"messages","messagesDns"},locale);
	}
	
	public void execute(String[] args) throws WbemSmtException {
		
	    Options options = createOptions(OPTIONS, bundle);

		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		//do the real processing
		System.out.println("\n" + bundle.getString("editing",new Object[]{bundle.getString("DnsMastersForServiceDataContainer.caption")}));
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
			
			CliDataLoader loader = new EditDnsMastersLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsMastersForServiceDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsMastersForServiceDataContainerImpl(adapter);
						
        				
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
			System.out.println("\n" + bundle.getString("edited", new Object[]{bundle.getString("DnsMastersForServiceDataContainer.caption")}));

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
	private void setKeyValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer dc) throws WbemSmtException {
    	    		    			    				setValue(cmd,dc.get_Name(),KEY_mastersName);
    			    			    			    				    				    				    				    				    				    					}	
	
	/**
	 * Set all Values that are not read-Only
	 **/
	private void setValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer dc) throws WbemSmtException {
    																				setMultiValue(adapter.getBundle(),cmd,dc.get_Masters(),KEY_masters);
																															setValue(cmd,dc.get_usr_NewMasterEntry(),KEY_newMasterEntry);
																																																										setMultiValue(adapter.getBundle(),cmd,dc.get_usr_PredefinedMasters(),KEY_predefinedMasters);
									
		//The Buttons
    																							if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveMasterEntry(),KEY_removeMasterEntry)) return;
																									if (!pressButton(cmd,adapter,dc,dc.get_usr_AddNewMasterEntry(),KEY_addNewMasterEntry)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddPredefinedMaster(),KEY_addPredefinedMaster)) return;
																	}	
}