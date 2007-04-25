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

import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ObjectRevertException;

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
			throws ObjectRevertException {
		
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowQueryForServiceDataContainer container) throws ObjectRevertException {
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionACLForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowRecursionForServiceDataContainer container) throws ObjectRevertException {
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowTransferForServiceDataContainer container) throws ObjectRevertException {
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeACLForServiceDataContainer)
	 */
	public MessageList revertImpl(DnsBlackholeForServiceDataContainer container) throws ObjectRevertException {
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyACLForZoneDataContainer)
	 */
	public MessageList revertImpl(DnsAllowNotifyForZoneDataContainer container) throws ObjectRevertException {
		
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
			throw new  ObjectRevertException("Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryACLForZoneDataContainer)
	 */
	public MessageList revertImpl(DnsAllowQueryForZoneDataContainer container) throws ObjectRevertException {
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
			throw new  ObjectRevertException("Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}



	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferACLForZoneDataContainer)
	 */
	public MessageList revertImpl(
			DnsAllowTransferForZoneDataContainer container)
			throws ObjectRevertException {
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
			throw new  ObjectRevertException("Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateACLForZoneDataContainer)
	 */
	public MessageList revertImpl(DnsAllowUpdateForZoneDataContainer container)
			throws ObjectRevertException {
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
			throw new  ObjectRevertException("Cannot revert container - selected zone " + adapter.getSelectedZone() + " not supported");
		}
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer)
	 */
	public MessageList revertImpl(DnsConfigurationDataContainer container)
			throws ObjectRevertException {
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardZoneDataContainer)
	 */
	public MessageList revertImpl(DnsForwardZoneDataContainer container)
			throws ObjectRevertException {
		return adapter.getSelectedForwardZone().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsHintZoneDataContainer)
	 */
	public MessageList revertImpl(DnsHintZoneDataContainer container)
			throws ObjectRevertException {
		return adapter.getSelectedHintZone().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer)
	 */
	public MessageList revertImpl(DnsMasterZoneDataContainer container)
			throws ObjectRevertException {
		return adapter.getSelectedMasterZone().revert(container);
	}
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer)
	 */
	public MessageList revertImpl(DnsReverseZoneDataContainer container)
	throws ObjectRevertException {
		return adapter.getSelectedReverseZone().revert(container);
	}


	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsSlaveZoneDataContainer)
	 */
	public MessageList revertImpl(DnsSlaveZoneDataContainer container)
	throws ObjectRevertException {
		return adapter.getSelectedSlaveZone().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer)
	 */
	public MessageList revertImpl(DnsResourceRecordDataContainer container)
			throws ObjectRevertException {
		return adapter.getSelectedResourceRecord().revert(container);
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer)
	 */
	public MessageList revertImpl(DnsServiceOperationsDataContainer container)
			throws ObjectRevertException {
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterRevertIf#revertImpl(org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListForServiceDataContainer)
	 */
	public MessageList revertImpl(
			DnsAddressMatchListForServiceDataContainer container)
			throws ObjectRevertException {
		return adapter.getSelectedAddressMatchList().revert(container);
	}

	public MessageList revertImpl(DnsResourceRecordForReverseZoneWizardDataContainer container, Linux_DnsResourceRecord fco) throws ObjectRevertException {
		//DnsResourceRecordForReverseZoneWizardDataContainer is not revertd 
		return null;
	}

	public MessageList revertImpl(DnsResourceRecordListContainer container) throws ObjectRevertException {
		return adapter.getSelectedZone().revert(container);
	}

	public MessageList revertImpl(DnsResourceRecordListItemContainer container) throws ObjectRevertException {
		return null;
	}

	public MessageList revertImpl(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws ObjectRevertException {
		return adapter.getSelectedZone().revert(container,fco);
	}

	public MessageList revertImpl(DnsSoaContainer container) throws ObjectRevertException {
		
		if (adapter.getSelectedReverseZone() != null)
		{
			return adapter.getSelectedReverseZone().revert(container);
		}
		else if (adapter.getSelectedMasterZone() != null)
		{
			return adapter.getSelectedMasterZone().revert(container);
		}
		else throw new ObjectRevertException("Selected zone is no masterZone or ReverseZone");
	}

	public MessageList revertImpl(DnsMastersForServiceDataContainer container) throws ObjectRevertException {
		return adapter.getSelectedMasters().revert(container);
	}

	public MessageList revertImpl(DnsStubZoneDataContainer container) throws ObjectRevertException {
		return adapter.getSelectedStubZone().revert(container);
	}

	public MessageList revertImpl(DnsForwardersForServiceDataContainer container) throws ObjectRevertException {
		try {
			return adapter.getDnsService().revert(container);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
	}

}
