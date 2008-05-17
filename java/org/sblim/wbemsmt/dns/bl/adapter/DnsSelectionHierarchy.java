 /** 
  * SambaSelectionHierarchy.java
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
  * Description: Selection Hierarchy of Samba Objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.adapter.SelectionHierarchy;
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.dns.bl.wrapper.*;

public class DnsSelectionHierarchy extends SelectionHierarchy {

	private DnsCimAdapter adapter;

	public Linux_DnsMasterZone getLinux_DnsMasterZone() {
		return (Linux_DnsMasterZone) get(0);
	}
	public Linux_DnsSlaveZone getLinux_DnsSlaveZone() {
		return (Linux_DnsSlaveZone) get(0);
	}
	public Linux_DnsStubZone getLinux_DnsStubZone() {
		return (Linux_DnsStubZone) get(0);
	}
	public Linux_DnsHintZone getLinux_DnsHintZone() {
		return (Linux_DnsHintZone) get(0);
	}
	public Linux_DnsForwardZone getLinux_DnsForwardZone() {
		return (Linux_DnsForwardZone) get(0);
	}
	public Linux_DnsReverseZoneWrapper getLinux_DnsReverseZone() {
		return (Linux_DnsReverseZoneWrapper) get(0);
	}
	public Linux_DnsAddressMatchList getLinux_DnsAddressMatchList() {
		return (Linux_DnsAddressMatchList) get(0);
	}
	public Linux_DnsMasters getLinux_DnsMasters() {
		return (Linux_DnsMasters) get(0);
	}
	public Linux_DnsResourceRecord getLinux_DnsResourceRecord() {
		return (Linux_DnsResourceRecord) get(1);
	}

	public void add(MasterZone zone) {
		cleanup(0);
		adapter.setSelectedMasterZone(zone);
		push(zone.getMasterZone());
	}
	public void add(SlaveZone zone) {
		cleanup(0);
		adapter.setSelectedSlaveZone(zone);
		push(zone.getSlaveZone());
	}

	public void add(StubZone zone) {
		cleanup(0);
		adapter.setSelectedStubZone(zone);
		push(zone.getStubZone());
	}
	
	public void add(HintZone zone) {
		cleanup(0);
		adapter.setSelectedHintZone(zone);
		push(zone.getHintZone());
	}
	public void add(ForwardZone zone) {
		cleanup(0);
		adapter.setSelectedForwardZone(zone);
		push(zone.getForwardZone());
	}
	public void add(ReverseZone zone) {
		cleanup(0);
		adapter.setSelectedReverseZone(zone);
		push(zone.getReverseZone());
	}
	public void add(AddressMatchList matchList) {
		cleanup(0);
		adapter.setSelectedAddressMatchList(matchList);
		push(matchList.getFco());
	}

	public void add(Masters masters) {
		cleanup(0);
		adapter.setSelectedMasters(masters);
		push(masters.getFco());
	}

	public void add(ResourceRecord resourceRecord) {
		cleanup(1);
		adapter.setSelectedResourceRecord(resourceRecord);
		push(resourceRecord.getFco());
	}


	private void cleanup(int currentLevel) {
		while (size() > currentLevel)
		{
			pop();
		}
	}
	public void setAdapter(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

}
