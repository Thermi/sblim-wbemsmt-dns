 /** 
  * DnsCimAdapterCountDelegatee.java
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
  * Description: Delegatee for Counting objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.exception.CountException;

public class DnsCimAdapterCountDelegatee implements DnsCimAdapterCountIf {

	private final DnsCimAdapter adapter;


	public DnsCimAdapterCountDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	public int countImpl_DnsResourceRecordDataContainer() throws CountException {
		return adapter.getSelectedZone().getResourceRecords().size();
	}

	public int countImpl_DnsResourceRecordForReverseZoneWizardDataContainer() throws CountException {
		return adapter.getReverseZoneWizard().getCreatedRecords().size();	
	}

	public int countImpl_DnsResourceRecordListItemContainer() throws CountException {
		return adapter.getSelectedZone().getResourceRecords().size();
	}

}
