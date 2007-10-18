/** 
  * EditDnsStubZone.java
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
  * @template: org/sblim/wbemsmt/dcg/templates/cmd/editCommand.vm
  *
  * Contributors: 
  * 
  * Description: Class for editing objects
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.*;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.cli.*;

public class EditDnsStubZone extends CimCommand {

	
 
 
	//All Options that are local and defined for this command
			/**
   		 *  --zoneFile
		 */
		public static final OptionDefinition KEY_zoneFile = new OptionDefinition(null,"zoneFile",null,"DnsStubZoneDataContainer.ZoneFile.argValue",false,false,"DnsStubZoneDataContainer.ZoneFile.argDescription");
			/**
   		 *  --useGlobalForwarders
		 */
		public static final OptionDefinition KEY_useGlobalForwarders = new OptionDefinition(null,"useGlobalForwarders",null,null,false,false,"DnsStubZoneDataContainer.useGlobalForwarders.argDescription");
			/**
   		 *  --forward
		 */
		public static final OptionDefinition KEY_forward = new OptionDefinition(null,"forward",null,"DnsForwarderDataContainer.Forward.argValue",false,false,"DnsForwarderDataContainer.Forward.argDescription");
			/**
   		 *  --forwarders
		 */
		public static final OptionDefinition KEY_forwarders = new OptionDefinition(null,"forwarders",null,"DnsForwarderDataContainer.Forwarders.argValue",false,false,"DnsForwarderDataContainer.Forwarders.argDescription");
			/**
   		 *  --removeForwarder
		 */
		public static final OptionDefinition KEY_removeForwarder = new OptionDefinition(null,"removeForwarder",null,null,false,false,"DnsForwarderDataContainer.removeForwarder.argDescription");
			/**
   		 *  --newForwarder
		 */
		public static final OptionDefinition KEY_newForwarder = new OptionDefinition(null,"newForwarder",null,"DnsForwarderDataContainer.newForwarder.argValue",false,false,"DnsForwarderDataContainer.newForwarder.argDescription");
			/**
   		 *  --addForwarder
		 */
		public static final OptionDefinition KEY_addForwarder = new OptionDefinition(null,"addForwarder",null,null,false,false,"DnsForwarderDataContainer.addForwarder.argDescription");
			/**
   		 *  --newForwarderType
		 */
		public static final OptionDefinition KEY_newForwarderType = new OptionDefinition(null,"newForwarderType",null,"DnsForwarderDataContainer.newForwarderType.argValue",false,false,"DnsForwarderDataContainer.newForwarderType.argDescription");
			/**
   		 * used for selection:  --zoneName
		 */
		public static final OptionDefinition KEY_zoneName = new OptionDefinition(null,"zoneName",null,"DnsZoneDataContainer.Name.argValue",false,false,"DnsZoneDataContainer.Name.argDescription");
			/**
   		 *  --masters
		 */
		public static final OptionDefinition KEY_masters = new OptionDefinition(null,"masters",null,"DnsAddMasterAddressDataContainer.masters.argValue",false,false,"DnsAddMasterAddressDataContainer.masters.argDescription");
			/**
   		 *  --removeMasterEntry
		 */
		public static final OptionDefinition KEY_removeMasterEntry = new OptionDefinition(null,"removeMasterEntry",null,null,false,false,"DnsAddMasterAddressDataContainer.removeMasterEntry.argDescription");
			/**
   		 *  --newMasterEntry
		 */
		public static final OptionDefinition KEY_newMasterEntry = new OptionDefinition(null,"newMasterEntry",null,"DnsAddMasterAddressDataContainer.newMasterEntry.argValue",false,false,"DnsAddMasterAddressDataContainer.newMasterEntry.argDescription");
			/**
   		 *  --addNewMasterEntry
		 */
		public static final OptionDefinition KEY_addNewMasterEntry = new OptionDefinition(null,"addNewMasterEntry",null,null,false,false,"DnsAddMasterAddressDataContainer.addNewMasterEntry.argDescription");
			/**
   		 *  --addPredefinedMaster
		 */
		public static final OptionDefinition KEY_addPredefinedMaster = new OptionDefinition(null,"addPredefinedMaster",null,null,false,false,"DnsAddMasterAddressDataContainer.addPredefinedMaster.argDescription");
			/**
   		 *  --predefinedMasters
		 */
		public static final OptionDefinition KEY_predefinedMasters = new OptionDefinition(null,"predefinedMasters",null,"DnsAddMasterAddressDataContainer.predefinedMasters.argValue",false,false,"DnsAddMasterAddressDataContainer.predefinedMasters.argDescription");
			/**
   		 *  --ttl
		 */
		public static final OptionDefinition KEY_ttl = new OptionDefinition(null,"ttl",null,"DnsTTLDataContainer.TTL.argValue",false,false,"DnsTTLDataContainer.TTL.argDescription");
			/**
   		 *  --ttlUnit
		 */
		public static final OptionDefinition KEY_ttlUnit = new OptionDefinition(null,"ttlUnit",null,"DnsTTLDataContainer.TTLUnit.argValue",false,false,"DnsTTLDataContainer.TTLUnit.argDescription");
			/**
   		 *  --removeTTL
		 */
		public static final OptionDefinition KEY_removeTTL = new OptionDefinition(null,"removeTTL",null,null,false,false,"DnsTTLDataContainer.removeTTL.argDescription");
		
	//All Options that are global and task-related
			/**
   		 * required, used for selection:  --dnsServiceName
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition(null,"dnsServiceName",null,"dnsServiceName.argValue",true,false,"dnsServiceName.argDescription");
	
	// Global Communication Options
			/**
   		 *  --hostname
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition(null,"hostname",null,"hostname.argValue",false,false,"hostname.argDescription");
			/**
   		 *  --port, default: 5988
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition(null,"port","5988","port.argValue",false,false,"port.argDescription");
			/**
   		 *  --namespace, default: /root/cimv2
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition(null,"namespace","/root/cimv2","namespace.argValue",false,false,"namespace.argDescription");
			/**
   		 *  --user
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition(null,"user",null,"user.argValue",false,false,"user.argDescription");
			/**
   		 *  --password
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition(null,"password",null,"password.argValue",false,false,"password.argDescription");
			/**
   		 *  --publickeyfile
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition(null,"publickeyfile",null,"publickeyfile.argValue",false,false,"publickeyfile.argDescription");
			/**
   		 *  --privatekeyfile
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition(null,"privatekeyfile",null,"privatekeyfile.argValue",false,false,"privatekeyfile.argDescription");
	
	// Global Common Options
			/**
   		 *  -L --locale, default: en
		 */
		public static final OptionDefinition KEY_GLOBAL_locale = new OptionDefinition("L","locale","en","locale.argValue",false,false,"locale.argDescription");
			/**
   		 *  -?
		 */
		public static final OptionDefinition KEY_GLOBAL_QUESTION_MARK_ = new OptionDefinition("?",null,null,null,false,false,"?.argDescription");
			/**
   		 *  -h --help
		 */
		public static final OptionDefinition KEY_GLOBAL_help = new OptionDefinition("h","help",null,null,false,false,"help.argDescription");
	
	private static final OptionDefinition[] LOCAL_OPTIONS = new OptionDefinition []
	{
    	    	KEY_zoneFile,
    	    	KEY_useGlobalForwarders,
    	    	KEY_forward,
    	    	KEY_forwarders,
    	    	KEY_removeForwarder,
    	    	KEY_newForwarder,
    	    	KEY_addForwarder,
    	    	KEY_newForwarderType,
    	    	KEY_zoneName,
    	    	KEY_masters,
    	    	KEY_removeMasterEntry,
    	    	KEY_newMasterEntry,
    	    	KEY_addNewMasterEntry,
    	    	KEY_addPredefinedMaster,
    	    	KEY_predefinedMasters,
    	    	KEY_ttl,
    	    	KEY_ttlUnit,
    	    	KEY_removeTTL,
    		};

	private static final OptionDefinition[] GLOBAL_TASK_OPTIONS = new OptionDefinition []
	{
    	    	KEY_GLOBAL_dnsServiceName,
    		};

	private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS = new OptionDefinition []
	{
    	    	KEY_GLOBAL_hostname,
    	    	KEY_GLOBAL_port,
    	    	KEY_GLOBAL_namespace,
    	    	KEY_GLOBAL_user,
    	    	KEY_GLOBAL_password,
    	    	KEY_GLOBAL_publickeyfile,
    	    	KEY_GLOBAL_privatekeyfile,
    		};

	private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMON_OPTIONS = new OptionDefinition []
	{
    	    	KEY_GLOBAL_locale,
    	    	KEY_GLOBAL_QUESTION_MARK_,
    	    	KEY_GLOBAL_help,
    		};

		
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public EditDnsStubZone(java.util.Locale locale)
	{
		super("EditDnsStubZone", new String[]{"messages","messagesDns"},locale);
	}
	
	public void execute(CimCommandValues values) throws WbemSmtException {
		
		//do the real processing
		try {
			
 
			commandValues = values;
			cmd = values.getCommandLine();

			Options options = values.getOptions();
			
			//first handle the help options and then the parseException
			//if the user wants help parsing the args will fail (due to missing required args)
			//and so the helpOptions should be handled first
			
    		if (   hasOption(values.getArgs(), "-" + KEY_GLOBAL_QUESTION_MARK_.getShortKey())
			    || hasOption(values.getArgs(), "-" + KEY_GLOBAL_help.getShortKey()) )
    		{
    			showUsage(values.getOut(), options);
    			return;
    		}			
    		else if ( hasOption(values.getArgs(), "--" + KEY_GLOBAL_help.getLongKey()) )
    		{
				//TODO add extendedHelp by loading a manpage or sth else
    			showUsage(values.getOut(), options);
    			return;
    		}			

			else if (values.getParseException() != null)
			{
				handleParseException(values,KEY_GLOBAL_password);
				return;
			}
			adapter = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,this);
			adapter.setBundle(bundle);
			adapter.setCimClient(values.getCimClient());
				
			adapter.loadInitial(adapter.getCimClient());
			
			values.getOut().println("\n" + bundle.getString("editing",new Object[]{bundle.getString("DnsStubZoneDataContainer.caption")}));

        	CliDataLoader loader = new EditDnsStubZoneLoader();
			loader.load(bundle,adapter, commandValues);
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsStubZoneDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsStubZoneDataContainerImpl(adapter);
						
        				
			setKeyValues(cmd,adapter,dc);

			adapter.updateControls(dc);
			adapter.setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);
			
			values.getOut().println("\n" + bundle.getString("before.edit"));
			dc.trace(values.getOut());

			setValues(cmd,adapter,dc);
			
			MessageList result = MessageList.init(dc);

			if (result.hasErrors())
			{
				Message caption = Message.create(ErrCodes.MSG_SAVE_ERROR, Message.ERROR,bundle, "save.error");
				traceMessages(caption,result);
				return;
			}
			else
			{
				Message caption = Message.create(ErrCodes.MSG_ADDITIONAL_MESSAGES, Message.ERROR,bundle, "additional.messages");
				traceMessages(caption,result);
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
					Message caption = Message.create(ErrCodes.MSG_SAVE_ERROR, Message.ERROR,bundle, "save.error");
					traceMessages(caption,result);
				}
				else if (result.hasWarning())
				{
					Message caption = Message.create(ErrCodes.MSG_SAVE_WARNING, Message.ERROR,bundle, "save.warning");
					traceMessages(caption,result);
				}
				else if (result.hasInfo())
				{
					Message caption = Message.create(ErrCodes.MSG_SAVE_INFO, Message.ERROR,bundle, "save.info");
					traceMessages(caption,result);
				}
			}
			else
			{
					Message caption = Message.create(ErrCodes.MSG_VALIDATION_ERROR, Message.ERROR,bundle, "validation.error");
					traceMessages(caption,result);
					return;
			}
			values.getOut().println("\n" + bundle.getString("edited", new Object[]{bundle.getString("DnsStubZoneDataContainer.caption")}));

			adapter.updateControls(dc);

			values.getOut().println("\n" + bundle.getString("after.edit"));
			dc.trace(values.getOut());
		
		}
		catch (Exception e)
		{
			super.handleException(e,values.getArgs(),values.getOptions(),KEY_GLOBAL_password);
		}
		finally
		{
			if (adapter != null) adapter.cleanup();
		}
	}
	
	/**
	 * Set all Values that are needed for selecting the right objects. This fields are used even if they are read-only
	 **/
	private void setKeyValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer dc) throws WbemSmtException {
    	    				    				    				    				    				    				    				    				    		    			    				setValue(cmd,dc.get_Name(),KEY_zoneName);
    			    			    			    				    				    				    				    				    				    				    				    				    					}	
	
	/**
	 * Set all Values that are not read-Only
	 **/
	private void setValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer dc) throws WbemSmtException {
    										setValue(cmd,dc.get_ZoneFile(),KEY_zoneFile);
																																											setMultiValue(adapter.getBundle(),cmd,dc.get_Forward(),KEY_forward);
																						setMultiValue(adapter.getBundle(),cmd,dc.get_Forwarders(),KEY_forwarders);
																															setValue(cmd,dc.get_usr_NewForwarder(),KEY_newForwarder);
																																											setMultiValue(adapter.getBundle(),cmd,dc.get_usr_NewForwarderType(),KEY_newForwarderType);
																setValue(cmd,dc.get_Name(),KEY_zoneName);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_Masters(),KEY_masters);
																															setValue(cmd,dc.get_usr_NewMasterEntry(),KEY_newMasterEntry);
																																																										setMultiValue(adapter.getBundle(),cmd,dc.get_usr_PredefinedMasters(),KEY_predefinedMasters);
																setValue(cmd,dc.get_TTL(),KEY_ttl);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_usr_TTLUnit(),KEY_ttlUnit);
																								
		//The Buttons
    																			if (!pressButton(cmd,adapter,dc,dc.get_usr_UseGlobalForwarders(),KEY_useGlobalForwarders)) return;
																																		if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveForwarder(),KEY_removeForwarder)) return;
																									if (!pressButton(cmd,adapter,dc,dc.get_usr_AddForwarder(),KEY_addForwarder)) return;
																																											if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveMasterEntry(),KEY_removeMasterEntry)) return;
																									if (!pressButton(cmd,adapter,dc,dc.get_usr_AddNewMasterEntry(),KEY_addNewMasterEntry)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddPredefinedMaster(),KEY_addPredefinedMaster)) return;
																																											if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveTTL(),KEY_removeTTL)) return;
								}	
	
	
 
			
	protected LoginOptionValues getLoginOptions() {
		return new LoginOptionValues(KEY_GLOBAL_hostname,KEY_GLOBAL_user,KEY_GLOBAL_password);
	}

	protected CimClientOptionValues getCimClientOptions() {
		
		return new CimClientOptionValues(KEY_GLOBAL_hostname,
				KEY_GLOBAL_port,
				KEY_GLOBAL_namespace,
				KEY_GLOBAL_user,
				KEY_GLOBAL_password,
				KEY_GLOBAL_publickeyfile,
				KEY_GLOBAL_privatekeyfile);
	}
	
	public Options getOptions() throws WbemSmtException {
		Options options = super.createOptions(LOCAL_OPTIONS, bundle);
		super.createOptions(options, GLOBAL_TASK_OPTIONS, bundle);
		super.createOptions(options, GLOBAL_WBEMSMT_COMMON_OPTIONS, bundle);
		super.createOptions(options, GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS, bundle);
		return options;
	}
	
	public Options getLocalOptions() throws WbemSmtException {
		Options options = super.createOptions(LOCAL_OPTIONS, bundle);
		return options;
	}

	public Options getGlobalWbemsmtCommonOptions() throws WbemSmtException {
		Options options = super.createOptions(GLOBAL_WBEMSMT_COMMON_OPTIONS, bundle);
		return options;
	}

	public Options getGlobalWbemsmtCommunicationOptions() throws WbemSmtException {
		Options options = super.createOptions(GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS, bundle);
		return options;
	}

	public Options getGlobalTaskOptions() throws WbemSmtException {
		Options options = super.createOptions(GLOBAL_TASK_OPTIONS, bundle);
		return options;
	}
	
}