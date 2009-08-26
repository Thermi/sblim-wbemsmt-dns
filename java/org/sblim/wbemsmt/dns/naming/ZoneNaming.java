 /** 
  * ZoneNaming.java
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
  * Description: Naming for Zones
  * 
  */
package org.sblim.wbemsmt.dns.naming;

import java.util.logging.Logger;

import javax.cim.CIMInstance;
import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.fco.AbstractWbemsmtFco;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.tasklauncher.naming.CIMInstanceNaming;
import org.sblim.wbemsmt.tools.runtime.RuntimeUtil;

public class ZoneNaming extends CIMInstanceNaming {

	static Logger logger = Logger.getLogger(ZoneNaming.class.getName());
	
	/**
	 * 
	 */
	public ZoneNaming() {
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tasklauncher.naming.CIMInstanceNaming#getDisplayString(org.sblim.wbem.cim.CIMInstance)
	 */
	public String getDisplayString(CIMInstance cimInstance, WBEMClient cimClient) {
		String separator = "\n";
		int maxlength = 30;
		if (RuntimeUtil.getInstance().isJSF())
		{
			separator = "<br>";
		}
		
		StringBuffer sb = new StringBuffer();
		
		String name = (String) cimInstance.getProperty(Linux_DnsZone.PROPERTY_NAME.NAME).getValue();
		while (name.length() > maxlength)
		{
			sb.append(name.substring(0,maxlength));
			sb.append(separator);
			name = name.substring(maxlength);
		}
		sb.append(name);

		return sb.toString();
	}

	public String getDisplayString(AbstractWbemsmtFco cimObject, WBEMClient cimClient) {
		return getDisplayString(cimObject.getCimInstance(), cimClient);
	}

}
