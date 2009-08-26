 /** 
  * DnsCimAdapterCountDelegatee.java
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
  * Description: Delegatee for Counting objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneTracingContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class DnsCimAdapterCountDelegatee implements DnsCimAdapterCountIf {

	private final DnsCimAdapter adapter;


	public DnsCimAdapterCountDelegatee(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	public int countImpl_ResourceRecords(Class<?> cls, DnsZoneTracingContainer container) throws WbemsmtException {
        return adapter.getSelectedZone().getResourceRecords().size();
	}

	public int countImpl_ResourceRecords(Class<?> cls, DnsReverseZoneWizardSummaryDataContainer container) throws WbemsmtException {
		return adapter.getReverseZoneWizard().getCreatedRecords().size();	
	}

	public int countImpl_ResourceRecords(Class<?> cls, DnsResourceRecordListContainer parent) throws WbemsmtException {
        return adapter.getSelectedZone().getResourceRecords().size();
	}

}
