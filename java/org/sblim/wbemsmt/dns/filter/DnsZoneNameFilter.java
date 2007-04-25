 /** 
  * DnsZoneNameFilter.java
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
  * Description: Filtering by the name of the Zone (Instances of Linux_DnsZone)
  * 
  */
package org.sblim.wbemsmt.dns.filter;

import java.util.logging.Logger;

import org.sblim.wbem.cim.CIMInstance;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.tasklauncher.filter.CIMInstanceFilter;

public class DnsZoneNameFilter extends CIMInstanceFilter {

	private static final String[] REV_SUFFIXES = new String[]{".in-addr.arpa",".ip6.arpa",".ip6.int"};
	private static Logger logger = Logger.getLogger(DnsZoneNameFilter.class.getName());
	public static final String INCLUDE_REVERSE_ZONE = "includeReverseZone";

	public DnsZoneNameFilter(boolean includeReverseZone)
	{
		addParameter(INCLUDE_REVERSE_ZONE, ""+ includeReverseZone);
	}
	
	public DnsZoneNameFilter()
	{
		
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tasklauncher.filter.CIMInstanceFilter#accept(org.sblim.wbem.cim.CIMInstance)
	 */
	public boolean accept(CIMInstance cimInstance, CIMClient cimClient) {
		String zoneName = (String) cimInstance.getProperty(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue();
		return accept(zoneName);
	}

	public boolean accept(String zoneName) {
		boolean includeReverseZone = "true".equalsIgnoreCase(getParameter("includeReverseZone"));
		boolean isReverseZone = false;
		
		for (int i = 0; i < REV_SUFFIXES.length && !isReverseZone; i++) {
			isReverseZone = zoneName.toLowerCase().endsWith(DnsZoneNameFilter.REV_SUFFIXES[i]);
		}
		
		
		boolean result = includeReverseZone == isReverseZone;
		
		logger.fine("Zone " + zoneName + " accepted " + result);
		
		return result;
	}

}
