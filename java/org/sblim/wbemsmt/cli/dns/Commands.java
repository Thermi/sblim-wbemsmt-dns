/** 
  * Commands.java
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
  * @template: ./tools-dcg/templates/cmd/commands.vm
  *
  * Contributors: 
  * 
  * Description: Class containing the mapping between Commands and the Commandlet
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns;

public class Commands extends org.sblim.wbemsmt.tools.cli.Commands {
	
	public Commands()
	{
    			
		addCommand("DeleteDnsMasterZone",org.sblim.wbemsmt.cli.dns.DeleteDnsMasterZone.class);    			
		addCommand("DeleteDnsSlaveZone",org.sblim.wbemsmt.cli.dns.DeleteDnsSlaveZone.class);    			
		addCommand("DeleteDnsStubZone",org.sblim.wbemsmt.cli.dns.DeleteDnsStubZone.class);    			
		addCommand("DeleteDnsForwardZone",org.sblim.wbemsmt.cli.dns.DeleteDnsForwardZone.class);    			
		addCommand("DeleteDnsReverseZone",org.sblim.wbemsmt.cli.dns.DeleteDnsReverseZone.class);    			
		addCommand("DeleteDnsAddressMatchList",org.sblim.wbemsmt.cli.dns.DeleteDnsAddressMatchList.class);    			
		addCommand("DeleteDnsMasters",org.sblim.wbemsmt.cli.dns.DeleteDnsMasters.class);    			
		addCommand("DeleteDnsResourceRecord",org.sblim.wbemsmt.cli.dns.DeleteDnsResourceRecord.class);    			
		addCommand("ListDnsZone",org.sblim.wbemsmt.cli.dns.ListDnsZone.class);    			
		addCommand("ListDnsAddressMatchList",org.sblim.wbemsmt.cli.dns.ListDnsAddressMatchList.class);    			
		addCommand("ListDnsMasters",org.sblim.wbemsmt.cli.dns.ListDnsMasters.class);    			
		addCommand("ListDnsResourceRecord",org.sblim.wbemsmt.cli.dns.ListDnsResourceRecord.class);    			
		addCommand("ListDnsServiceStatus",org.sblim.wbemsmt.cli.dns.ListDnsServiceStatus.class);    			
		addCommand("ListDnsServiceConfiguration",org.sblim.wbemsmt.cli.dns.ListDnsServiceConfiguration.class);    			
		addCommand("CreateDnsMasterZone",org.sblim.wbemsmt.cli.dns.CreateDnsMasterZone.class);    			
		addCommand("CreateDnsSlaveZone",org.sblim.wbemsmt.cli.dns.CreateDnsSlaveZone.class);    			
		addCommand("CreateDnsStubZone",org.sblim.wbemsmt.cli.dns.CreateDnsStubZone.class);    			
		addCommand("CreateDnsForwardZone",org.sblim.wbemsmt.cli.dns.CreateDnsForwardZone.class);    			
		addCommand("CreateDnsReverseZone",org.sblim.wbemsmt.cli.dns.CreateDnsReverseZone.class);    			
		addCommand("CreateDnsResourceRecord",org.sblim.wbemsmt.cli.dns.CreateDnsResourceRecord.class);    			
		addCommand("CreateDnsAddressMatchList",org.sblim.wbemsmt.cli.dns.CreateDnsAddressMatchList.class);    			
		addCommand("CreateDnsMasters",org.sblim.wbemsmt.cli.dns.CreateDnsMasters.class);    			
		addCommand("EditDnsMasterZone",org.sblim.wbemsmt.cli.dns.EditDnsMasterZone.class);    			
		addCommand("EditDnsMasterZoneAllowTransfer",org.sblim.wbemsmt.cli.dns.EditDnsMasterZoneAllowTransfer.class);    			
		addCommand("EditDnsMasterZoneAllowQuery",org.sblim.wbemsmt.cli.dns.EditDnsMasterZoneAllowQuery.class);    			
		addCommand("EditDnsMasterZoneAllowUpdate",org.sblim.wbemsmt.cli.dns.EditDnsMasterZoneAllowUpdate.class);    			
		addCommand("EditDnsSoaRecord",org.sblim.wbemsmt.cli.dns.EditDnsSoaRecord.class);    			
		addCommand("EditDnsSlaveZone",org.sblim.wbemsmt.cli.dns.EditDnsSlaveZone.class);    			
		addCommand("EditDnsSlaveZoneAllowTransfer",org.sblim.wbemsmt.cli.dns.EditDnsSlaveZoneAllowTransfer.class);    			
		addCommand("EditDnsSlaveZoneAllowQuery",org.sblim.wbemsmt.cli.dns.EditDnsSlaveZoneAllowQuery.class);    			
		addCommand("EditDnsSlaveZoneAllowNotify",org.sblim.wbemsmt.cli.dns.EditDnsSlaveZoneAllowNotify.class);    			
		addCommand("EditDnsSlaveZoneAllowUpdate",org.sblim.wbemsmt.cli.dns.EditDnsSlaveZoneAllowUpdate.class);    			
		addCommand("EditDnsStubZone",org.sblim.wbemsmt.cli.dns.EditDnsStubZone.class);    			
		addCommand("EditDnsStubZoneAllowTransfer",org.sblim.wbemsmt.cli.dns.EditDnsStubZoneAllowTransfer.class);    			
		addCommand("EditDnsStubZoneAllowQuery",org.sblim.wbemsmt.cli.dns.EditDnsStubZoneAllowQuery.class);    			
		addCommand("EditDnsStubZoneAllowNotify",org.sblim.wbemsmt.cli.dns.EditDnsStubZoneAllowNotify.class);    			
		addCommand("EditDnsStubZoneAllowUpdate",org.sblim.wbemsmt.cli.dns.EditDnsStubZoneAllowUpdate.class);    			
		addCommand("EditDnsResourceRecord",org.sblim.wbemsmt.cli.dns.EditDnsResourceRecord.class);    			
		addCommand("EditDnsServiceConfiguration",org.sblim.wbemsmt.cli.dns.EditDnsServiceConfiguration.class);    			
		addCommand("EditDnsForwardersForService",org.sblim.wbemsmt.cli.dns.EditDnsForwardersForService.class);    			
		addCommand("EditDnsServiceStatus",org.sblim.wbemsmt.cli.dns.EditDnsServiceStatus.class);    			
		addCommand("EditDnsServiceAllowNotify",org.sblim.wbemsmt.cli.dns.EditDnsServiceAllowNotify.class);    			
		addCommand("EditDnsServiceAllowQuery",org.sblim.wbemsmt.cli.dns.EditDnsServiceAllowQuery.class);    			
		addCommand("EditDnsServiceAllowTransfer",org.sblim.wbemsmt.cli.dns.EditDnsServiceAllowTransfer.class);    			
		addCommand("EditDnsServiceAllowRecursion",org.sblim.wbemsmt.cli.dns.EditDnsServiceAllowRecursion.class);    			
		addCommand("EditDnsServiceBlackhole",org.sblim.wbemsmt.cli.dns.EditDnsServiceBlackhole.class);    			
		addCommand("EditDnsHintZone",org.sblim.wbemsmt.cli.dns.EditDnsHintZone.class);    			
		addCommand("EditDnsForwardZone",org.sblim.wbemsmt.cli.dns.EditDnsForwardZone.class);    			
		addCommand("EditDnsReverseZone",org.sblim.wbemsmt.cli.dns.EditDnsReverseZone.class);    			
		addCommand("EditDnsReverseZoneAllowTransfer",org.sblim.wbemsmt.cli.dns.EditDnsReverseZoneAllowTransfer.class);    			
		addCommand("EditDnsReverseZoneAllowQuery",org.sblim.wbemsmt.cli.dns.EditDnsReverseZoneAllowQuery.class);    			
		addCommand("EditDnsReverseZoneAllowUpdate",org.sblim.wbemsmt.cli.dns.EditDnsReverseZoneAllowUpdate.class);    			
		addCommand("EditDnsAddressMatchList",org.sblim.wbemsmt.cli.dns.EditDnsAddressMatchList.class);    			
		addCommand("EditDnsMasters",org.sblim.wbemsmt.cli.dns.EditDnsMasters.class);    			
	}
}