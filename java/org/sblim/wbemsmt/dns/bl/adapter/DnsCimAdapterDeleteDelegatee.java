 /** 
  * DnsCimAdapterDeleteDelegatee.java
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
  * Description: Delegatee for delete actions
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsHintZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsReverseZoneWrapper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsSlaveZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsStubZone;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class DnsCimAdapterDeleteDelegatee implements DnsCimAdapterDeleteIf {

	private final DnsCimAdapter adapter;


	public DnsCimAdapterDeleteDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterDeleteIf#deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList)
	 */
	public void deleteImpl(Linux_DnsAddressMatchList fco)
			throws WbemsmtException {
		
		adapter.getSelectedAddressMatchList().delete();
		adapter.setMarkedForReload();

	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterDeleteIf#deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsHintZone)
	 */
	public void deleteImpl(Linux_DnsHintZone fco)
			throws WbemsmtException {
		adapter.getSelectedZone().delete(fco);
		adapter.setMarkedForReload();
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterDeleteIf#deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsHintZone)
	 */
	public void deleteImpl(Linux_DnsForwardZone fco)
			throws WbemsmtException {
		adapter.getSelectedZone().delete(fco);
		adapter.setMarkedForReload();
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterDeleteIf#deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone)
	 */
	public void deleteImpl(Linux_DnsMasterZone fco)
			throws WbemsmtException {
		adapter.getSelectedZone().delete(fco);
		adapter.setMarkedForReload();
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterDeleteIf#deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord)
	 */
	public void deleteImpl(Linux_DnsResourceRecord fco)
			throws WbemsmtException {
		adapter.getSelectedResourceRecord().delete();
		adapter.setMarkedForReload();
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterDeleteIf#deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsReverseZoneWrapper)
	 */
	public void deleteImpl(Linux_DnsReverseZoneWrapper fco)
			throws WbemsmtException {

		adapter.getSelectedReverseZone().delete(fco);
		adapter.setMarkedForReload();
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapterDeleteIf#deleteImpl(org.sblim.wbemsmt.dns.bl.fco.Linux_DnsSlaveZone)
	 */
	public void deleteImpl(Linux_DnsSlaveZone fco)
			throws WbemsmtException {
		adapter.getSelectedZone().delete(fco);
		adapter.setMarkedForReload();
	}

	public void deleteImpl(Linux_DnsStubZone fco) throws WbemsmtException {
		adapter.getSelectedZone().delete(fco);
		adapter.setMarkedForReload();
	}

	public void deleteImpl(Linux_DnsMasters fco) throws WbemsmtException {
		adapter.getSelectedMasters().delete();
		adapter.setMarkedForReload();
	}


}
