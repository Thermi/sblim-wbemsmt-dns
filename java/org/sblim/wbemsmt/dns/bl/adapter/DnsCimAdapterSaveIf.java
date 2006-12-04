/** 
  * DnsCimAdapterSaveIf.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.AdapterStubGenerator
  * @template: ./tools-dcg/templates/adapterInterfaceSave.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.adapter.*;

	/** 
	 * This is the interface containing only the Save-Methods for the delegate
	 **/

public interface DnsCimAdapterSaveIf extends SaveDelegatee
{

	/** 
	 * Save-Methods
	 **/
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsStubZoneDataContainer container)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer container, org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
	public MessageList saveImpl(org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer container, org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord fco)  throws org.sblim.wbemsmt.exception.ObjectSaveException;
		
}