/** 
  * EditDnsSlaveZoneAllowTransfer.java
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

public class EditDnsSlaveZoneAllowTransfer extends CimCommand {

			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition("hostname",null,"EditDnsSlaveZoneAllowTransfer.hostname.argValue",true,false,"EditDnsSlaveZoneAllowTransfer.hostname.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition("port","5988","EditDnsSlaveZoneAllowTransfer.port.argValue",false,false,"EditDnsSlaveZoneAllowTransfer.port.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition("namespace","/root/cimv2","EditDnsSlaveZoneAllowTransfer.namespace.argValue",false,false,"EditDnsSlaveZoneAllowTransfer.namespace.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition("user",null,"EditDnsSlaveZoneAllowTransfer.user.argValue",true,false,"EditDnsSlaveZoneAllowTransfer.user.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition("password",null,"EditDnsSlaveZoneAllowTransfer.password.argValue",true,false,"EditDnsSlaveZoneAllowTransfer.password.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition("publickeyfile","none","EditDnsSlaveZoneAllowTransfer.publickeyfile.argValue",false,false,"EditDnsSlaveZoneAllowTransfer.publickeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition("privatekeyfile","none","EditDnsSlaveZoneAllowTransfer.privatekeyfile.argValue",false,false,"EditDnsSlaveZoneAllowTransfer.privatekeyfile.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition("dnsServiceName",null,"EditDnsSlaveZoneAllowTransfer.dnsServiceName.argValue",true,false,"EditDnsSlaveZoneAllowTransfer.dnsServiceName.argDescription");
			/**
		 * 
		 */
		public static final OptionDefinition KEY_zoneName = new OptionDefinition("zoneName",null,"EditDnsSlaveZoneAllowTransfer.zoneName.argValue",true,false,"EditDnsSlaveZoneAllowTransfer.zoneName.argDescription");
	
			/**
		 * 
		 */
		public static final OptionDefinition KEY_useGlobalAddressMatchList = new OptionDefinition("useGlobalAddressMatchList",null,null,false,false,"DnsAllowTransferForZoneDataContainer.useGlobalAddressMatchList.argDescription");
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
    	    	KEY_zoneName,
    	    	    	KEY_useGlobalAddressMatchList,
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

	
	public EditDnsSlaveZoneAllowTransfer(java.util.Locale locale)
	{
		super("EditDnsSlaveZoneAllowTransfer", new String[]{"messages","messagesDns"},locale);
	}
	
	public void execute(String[] args) throws WbemSmtException {
		
	    Options options = createOptions(OPTIONS, bundle);

		if (args.length == 1 && (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h") ))
		{
			showUsage(options);
			return;
		}
		
		//do the real processing
		System.out.println("\n" + bundle.getString("editing",new Object[]{bundle.getString("DnsAllowTransferForZoneDataContainer.caption")}));
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
			
			CliDataLoader loader = new EditDnsSlaveZoneAllowTransferLoader();
			loader.load(bundle,adapter, cmd);
			
			org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl(adapter);
						
        				
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
			System.out.println("\n" + bundle.getString("edited", new Object[]{bundle.getString("DnsAllowTransferForZoneDataContainer.caption")}));

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
	private void setKeyValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer dc) throws WbemSmtException {
    	    				    				    				    				    				    				    				    				    					}	
	
	/**
	 * Set all Values that are not read-Only
	 **/
	private void setValues(CommandLine cmd,AbstractBaseCimAdapter adapter, org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer dc) throws WbemSmtException {
    																															setMultiValue(adapter.getBundle(),cmd,dc.get_AddressList(),KEY_addressList);
																																					setMultiValue(adapter.getBundle(),cmd,dc.get_usr_UserAddresses(),KEY_userAddresses);
																setValue(cmd,dc.get_usr_NewAddress(),KEY_newAddress);
																																																																											
		//The Buttons
    										if (!pressButton(cmd,adapter,dc,dc.get_usr_UseGlobalAddressMatchList(),KEY_useGlobalAddressMatchList)) return;
																									if (!pressButton(cmd,adapter,dc,dc.get_usr_RemoveAddress(),KEY_removeAddress)) return;
																																		if (!pressButton(cmd,adapter,dc,dc.get_usr_AddPredefinedAddress(),KEY_addPredefinedAddress)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddNewAddress(),KEY_addNewAddress)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddressUp(),KEY_addressUp)) return;
																if (!pressButton(cmd,adapter,dc,dc.get_usr_AddressDown(),KEY_addressDown)) return;
								}	
}