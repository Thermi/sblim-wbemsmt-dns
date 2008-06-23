package org.sblim.wbemsmt.dns.bl.wrapper;

import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.WbemsmtException;

public interface Zone {
	public ResourceRecordList getResourceRecords() throws WbemsmtException;
	public void setResourceRecords(ResourceRecordList resourceRecordList);
	public void loadChilds(WBEMClient cimClient) throws WbemsmtException;
	public String getName();
	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco)  throws WbemsmtException ;
	public void updateControls(DnsZoneTracingContainer container) throws WbemsmtException;
	public Linux_DnsZone getLinux_DnsZone();
	public void delete(Linux_DnsZone fco)  throws WbemsmtException ;

	public void updateModel(DnsResourceRecordListContainer container) throws WbemsmtException;
	public void updateControls(DnsResourceRecordListItemContainer container) throws WbemsmtException;;
	public void updateControls(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord recordFco) throws WbemsmtException;;
	public void updateControls(DnsResourceRecordListContainer container) throws WbemsmtException;
	public MessageList save(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco)  throws WbemsmtException;
	public MessageList save(DnsResourceRecordListContainer container) throws WbemsmtException;
	
	/**
	 * have to be implemented only if the zone is having a SOA-Record and a serial number to be modified
	 * @param container 
	 * @throws WbemsmtException
	 */
	public void updateSerialNumber(DnsSoaContainer container);
	
	/**
	 * Have to be implemented only if the zone is having resourceRecords
	 * @param container
	 * @throws WbemsmtException
	 */
	public void updateModel(DnsResourceRecordListItemContainer container) throws WbemsmtException ;
	
	/**
	 * Have to be implemented only if the zone is having a soarecord
	 * @param container
	 * @throws WbemsmtException
	 */
	public void resetTTL(DnsSoaContainer container);
	public MessageList revert(DnsResourceRecordListContainer container) throws WbemsmtException ;
	public MessageList revert(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException;
}
