package org.sblim.wbemsmt.dns.bl.wrapper;

import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectDeletionException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public interface Zone {
	public ResourceRecordList getResourceRecords();
	public void setResourceRecords(ResourceRecordList resourceRecordList);
	public void loadChilds(CIMClient cimClient) throws ModelLoadException;
	public String getName();
	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco)  throws UpdateControlsException ;
	public void updateControls(DnsZoneTracingContainer container) throws UpdateControlsException;
	public Linux_DnsZone getLinux_DnsZone();
	public void delete(Linux_DnsZone fco)  throws ObjectDeletionException ;

	public void updateModel(DnsResourceRecordListContainer container) throws ModelUpdateException;
	public void updateControls(DnsResourceRecordListItemContainer container) throws UpdateControlsException;;
	public void updateControls(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord recordFco) throws UpdateControlsException;;
	public void updateControls(DnsResourceRecordListContainer container) throws UpdateControlsException;
	public MessageList save(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco)  throws ObjectSaveException;
	public MessageList save(DnsResourceRecordListContainer container) throws ObjectSaveException;
	
	/**
	 * have to be implemented only if the zone is having a SOA-Record and a serial number to be modified
	 * @param container 
	 * @throws ObjectSaveException
	 */
	public void updateSerialNumber(DnsSoaContainer container);
	
	/**
	 * Have to be implemented only if the zone is having resourceRecords
	 * @param container
	 * @throws ModelUpdateException
	 */
	public void updateModel(DnsResourceRecordListItemContainer container) throws ModelUpdateException ;
	
	/**
	 * Have to be implemented only if the zone is having a soarecord
	 * @param container
	 * @throws ModelUpdateException
	 */
	public void resetTTL(DnsSoaContainer container);
}
