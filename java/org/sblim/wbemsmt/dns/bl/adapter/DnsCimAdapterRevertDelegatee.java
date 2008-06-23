 /** 
  * DnsCimAdapterRevertDelegatee.java
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
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: Delegatee for reverting objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class DnsCimAdapterRevertDelegatee implements DnsCimAdapterRevertIf {

	private final DnsCimAdapter adapter;

	public DnsCimAdapterRevertDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#RevertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowNotifyForServiceDataContainer container)
			throws WbemsmtException {
		
		return adapter.getDnsService().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowQueryForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowRecursionForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowTransferForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public MessageList revertImpl(DnsBlackholeForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public MessageList revertImpl(DnsAllowNotifyForZoneDataContainer container) throws WbemsmtException {
		
		if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().revert(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().revert(container);
		}
		else
		{
			throw new WbemsmtException(WbemsmtException.ERR_REVERT_OBJECT,"Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public MessageList revertImpl(DnsAllowQueryForZoneDataContainer container) throws WbemsmtException {
		if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().revert(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().revert(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().revert(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().revert(container);
		}
		else {
			throw new WbemsmtException(WbemsmtException.ERR_REVERT_OBJECT,"Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}



	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws WbemsmtException {
		if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().revert(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().revert(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().revert(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().revert(container);
		} else {
			throw new WbemsmtException(WbemsmtException.ERR_REVERT_OBJECT,"Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public MessageList revertImpl(DnsAllowUpdateForZoneDataContainer container)
			throws WbemsmtException {
		if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().revert(container);
		}
		else if (adapter.getSelectedSlaveZone() != null)
		{
			return adapter.getSelectedSlaveZone().revert(container);
		}
		else if (adapter.getSelectedStubZone() != null)
		{
			return adapter.getSelectedStubZone().revert(container);
		}
		else if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().revert(container);
		}
		else
		{
			throw new WbemsmtException(WbemsmtException.ERR_REVERT_OBJECT,"Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public MessageList revertImpl(DnsConfigurationDataContainer container)
			throws WbemsmtException {
		return adapter.getDnsService().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public MessageList revertImpl(DnsForwardZoneDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedForwardZone().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public MessageList revertImpl(DnsHintZoneDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedHintZone().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public MessageList revertImpl(DnsMasterZoneDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedMasterZone().revert(container);
	}
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public MessageList revertImpl(DnsReverseZoneDataContainer container)
	throws WbemsmtException {
		return adapter.getSelectedReverseZone().revert(container);
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public MessageList revertImpl(DnsSlaveZoneDataContainer container)
	throws WbemsmtException {
		return adapter.getSelectedSlaveZone().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public MessageList revertImpl(DnsResourceRecordDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedResourceRecord().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public MessageList revertImpl(DnsServiceOperationsDataContainer container)
			throws WbemsmtException {
		return adapter.getDnsService().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws WbemsmtException {
		return adapter.getSelectedAddressMatchList().revert(container);
	}

	public MessageList revertImpl(DnsResourceRecordForReverseZoneWizardDataContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		//DnsResourceRecordForReverseZoneWizardDataContainer is not revertd 
		return null;
	}

	public MessageList revertImpl(DnsResourceRecordListContainer container) throws WbemsmtException {
		return adapter.getSelectedZone().revert(container);
	}

	public MessageList revertImpl(DnsResourceRecordListItemContainer container) throws WbemsmtException {
		return null;
	}

	public MessageList revertImpl(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		return adapter.getSelectedZone().revert(container,fco);
	}

	public MessageList revertImpl(DnsSoaContainer container) throws WbemsmtException {
		
		if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().revert(container);
		}
		else if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().revert(container);
		}
		else throw new WbemsmtException(WbemsmtException.ERR_REVERT_OBJECT,"Selected zone is no masterZone or ReverseZone");
	}

	public MessageList revertImpl(DnsMastersForServiceDataContainer container) throws WbemsmtException {
		return adapter.getSelectedMasters().revert(container);
	}

	public MessageList revertImpl(DnsStubZoneDataContainer container) throws WbemsmtException {
		return adapter.getSelectedStubZone().revert(container);
	}

	public MessageList revertImpl(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		return adapter.getDnsService().revert(container);
	}

}
