/** 
  * EditDnsResourceRecord.java
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

public class EditDnsResourceRecord extends CimCommand {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"EditDnsResourceRecord.hostname.argValue",true,false,"EditDnsResourceRecord.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","EditDnsResourceRecord.port.argValue",false,false,"EditDnsResourceRecord.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","EditDnsResourceRecord.namespace.argValue",false,false,"EditDnsResourceRecord.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"EditDnsResourceRecord.user.argValue",true,false,"EditDnsResourceRecord.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"EditDnsResourceRecord.password.argValue",true,false,"EditDnsResourceRecord.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","EditDnsResourceRecord.publickeyfile.argValue",false,false,"EditDnsResourceRecord.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","EditDnsResourceRecord.privatekeyfile.argValue",false,false,"EditDnsResourceRecord.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"EditDnsResourceRecord.dnsServiceName.argValue",true,false,"EditDnsResourceRecord.dnsServiceName.argDescription");
			/**
		 * Zone name to select the right zone
		 */
		public static final OptionDefinition KEY_zoneName = new OptionDefinition("zoneName",null,"EditDnsResourceRecord.zoneName.argValue",true,false,"EditDnsResourceRecord.zoneName.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_recordNameToSelect = new OptionDefinition("recordNameToSelect",null,"EditDnsResourceRecord.recordNameToSelect.argValue",true,false,"EditDnsResourceRecord.recordNameToSelect.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_recordTypeToSelect = new OptionDefinition("recordTypeToSelect",null,"EditDnsResourceRecord.recordTypeToSelect.argValue",true,false,"EditDnsResourceRecord.recordTypeToSelect.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_recordValueToSelect = new OptionDefinition("recordValueToSelect",null,"EditDnsResourceRecord.recordValueToSelect.argValue",true,false,"EditDnsResourceRecord.recordValueToSelect.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_mxPriorityToSelect = new OptionDefinition("mxPriorityToSelect",null,"EditDnsResourceRecord.mxPriorityToSelect.argValue",true,false,"EditDnsResourceRecord.mxPriorityToSelect.argDescription");
	
			/**
		 * 
		 */
		public static final OptionDefinition KEY_recordName = new OptionDefinition("recordName",null,"DnsResourceRecordDataContainer.Name.argValue",false,false,"DnsResourceRecordDataContainer.Name.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_recordType = new OptionDefinition("recordType",null,"DnsResourceRecordDataContainer.Type.argValue",false,false,"DnsResourceRecordDataContainer.Type.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_recordFamily = new OptionDefinition("recordFamily",null,"DnsResourceRecordDataContainer.Family.argValue",false,false,"DnsResourceRecordDataContainer.Family.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_recordValue = new OptionDefinition("recordValue",null,"DnsResourceRecordDataContainer.Value.argValue",false,false,"DnsResourceRecordDataContainer.Value.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_mxPriority = new OptionDefinition("mxPriority",null,"DnsResourceRecordDataContainer.Priority.argValue",false,false,"DnsResourceRecordDataContainer.Priority.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_ttl = new OptionDefinition("ttl",null,"DnsTTLDataContainer.TTL.argValue",false,false,"DnsTTLDataContainer.TTL.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_ttlUnit = new OptionDefinition("ttlUnit",null,"DnsTTLDataContainer.TTLUnit.argValue",false,false,"DnsTTLDataContainer.TTLUnit.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_removeTTL = new OptionDefinition("removeTTL",null,null,false,false,"DnsTTLDataContainer.removeTTL.argDescription");
		
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
    	    	KEY_recordNameToSelect,
    	    	KEY_recordTypeToSelect,
    	    	KEY_recordValueToSelect,
    	    	KEY_mxPriorityToSelect,
    	    	    	KEY_recordName,
    	    	KEY_recordType,
    	    	KEY_recordFamily,
    	    	KEY_recordValue,
    	    	KEY_mxPriority,
    	    	KEY_ttl,
    	    	KEY_ttlUnit,
    	    	KEY_removeTTL,
    			KEY_locale,
	};

		
 
 CommandLine cmd = null;
	AbstractBaseCimAdapter adapter = null;

	
	public EditDnsResourceRecord(java.util.Locale locale)
	{
		super("EditDnsResourceRecord", new String[]{"messages","messagesDns"},locale);
	}
	
	public void execute(String[] args) throws WbemSmtException {
		
	    Options options = createOptions(OPTIONS, bundle);

		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		//do the real processing
		System.out.println("\n" + bundle.getString("editing",new Object[]{bundle.getString("DnsResourceRecordDataContainer.caption")}));
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
			
			CliDataLoader loader = new EditDnsResourceRecordLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordDataContainerImpl(adapter);
						
        				
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
			System.out.println("\n" + bundle.getString("edited", new Object[]{bundle.getString("DnsResourceRecordDataContainer.caption")}));

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
	private void setKeyValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer dc) throws WbemSmtException {
    	    				    				    				    				    				    				    				    					}	
	
	/**
	 * Set all Values that are not read-Only
	 **/
	private void setValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer dc) throws WbemSmtException {
    										setValue(cmd,dc.get_Name(),KEY_recordName);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_Type(),KEY_recordType);
																						setMultiValue(adapter.getBundle(),cmd,dc.get_Family(),KEY_recordFamily);
																setValue(cmd,dc.get_Value(),KEY_recordValue);
																						setValue(cmd,dc.get_Priority(),KEY_mxPriority);
																						setValue(cmd,dc.get_TTL(),KEY_ttl);
																												setMultiValue(adapter.getBundle(),cmd,dc.get_usr_TTLUnit(),KEY_ttlUnit);
																								
		//The Buttons
    																																																																									if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveTTL(),KEY_removeTTL)) return;
								}	
}