 /** 
  * DnsCimAdapterSaveDelegatee.java
  *
  * © Copyright IBM Corp.  2009,2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: Delegatee for savong objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class DnsCimAdapterSaveDelegatee implements DnsCimAdapterSaveIf {

	private final DnsCimAdapter adapter;

	public DnsCimAdapterSaveDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public MessageList saveImpl(
			DnsAllowNotifyForServiceDataContainer container)
			throws WbemsmtException {
		
		return adapter.getDnsService().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public MessageList saveImpl(
			DnsAllowQueryForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public MessageList saveImpl(
			DnsAllowRecursionForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public MessageList saveImpl(
			DnsAllowTransferForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public MessageList saveImpl(DnsBlackholeForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public MessageList saveImpl(DnsAllowNotifyForZoneDataContainer container) throws WbemsmtException {
		
		if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().save(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().save(container);
		}
		else
		{
			throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Cannot save container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public MessageList saveImpl(DnsAllowQueryForZoneDataContainer container) throws WbemsmtException {
		if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().save(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().save(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().save(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().save(container);
		}
		else {
			throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Cannot save container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}



	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public MessageList saveImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws WbemsmtException {
		if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().save(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().save(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().save(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().save(container);
		} else {
			throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Cannot save container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public MessageList saveImpl(DnsAllowUpdateForZoneDataContainer container)
			throws WbemsmtException {
		if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().save(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().save(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().save(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().save(container);
		}
		else
		{
			throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Cannot save container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public MessageList saveImpl(DnsConfigurationDataContainer container)
			throws WbemsmtException {
		return adapter.getDnsService().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public MessageList saveImpl(DnsForwardZoneDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedForwardZone().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public MessageList saveImpl(DnsHintZoneDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedHintZone().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public MessageList saveImpl(DnsMasterZoneDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedMasterZone().save(container);
	}
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public MessageList saveImpl(DnsReverseZoneDataContainer container)
	throws WbemsmtException {
		return adapter.getSelectedReverseZone().save(container);
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public MessageList saveImpl(DnsSlaveZoneDataContainer container)
	throws WbemsmtException {
		return adapter.getSelectedSlaveZone().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public MessageList saveImpl(DnsResourceRecordDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedResourceRecord().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public MessageList saveImpl(DnsServiceOperationsDataContainer container)
			throws WbemsmtException {
		return adapter.getDnsService().save(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterSaveIf#saveImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public MessageList saveImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedAddressMatchList().save(container);
	}

	public MessageList saveImpl(DnsResourceRecordForReverseZoneWizardDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		//DnsResourceRecordForReverseZoneWizardDataContainer is not saved 
		return null;
	}

	public MessageList saveImpl(DnsResourceRecordListContainer container) throws WbemsmtException {
		return adapter.getSelectedZone().save(container);
	}

	public MessageList saveImpl(DnsResourceRecordListItemContainer container) throws WbemsmtException {
		return null;
	}

	public MessageList saveImpl(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		return adapter.getSelectedZone().save(container,fco);
	}

	public MessageList saveImpl(DnsSoaContainer container) throws WbemsmtException {
		
		if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().save(container);
		}
		else if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().save(container);
		}
		else throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Selected zone is no masterZone or ReverseZone");
	}

	public MessageList saveImpl(DnsMastersForServiceDataContainer container) throws WbemsmtException {
		return adapter.getSelectedMasters().save(container);
	}

	public MessageList saveImpl(DnsStubZoneDataContainer container) throws WbemsmtException {
		return adapter.getSelectedStubZone().save(container);
	}

	public MessageList saveImpl(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().save(container);
	}

}
