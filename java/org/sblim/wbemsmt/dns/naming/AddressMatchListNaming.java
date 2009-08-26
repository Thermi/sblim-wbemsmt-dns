 /** 
  * AddressMatchListNaming.java
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
  * Description: Naming for AddressMatchLists
  * 
  */
package org.sblim.wbemsmt.dns.naming;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.cim.CIMInstance;
import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.fco.AbstractWbemsmtFco;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.tasklauncher.naming.CIMInstanceNaming;
import org.sblim.wbemsmt.util.StringTokenizer;

public class AddressMatchListNaming extends CIMInstanceNaming {

	static Logger logger = Logger.getLogger(AddressMatchListNaming.class.getName());
	
	/**
	 * 
	 */
	public AddressMatchListNaming() {
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tasklauncher.naming.CIMInstanceNaming#getDisplayString(org.sblim.wbem.cim.CIMInstance)
	 */
	public String getDisplayString(CIMInstance cimInstance, WBEMClient cimClient) {
		String name = (String) cimInstance.getProperty(Linux_DnsMasters.PROPERTY_NAME.NAME).getValue();
		try {
			String[] array = new StringTokenizer(name,NameFactory.SEPARATOR).asArray(true, false);
			return array[1];
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Cannot get DisplayString for name " + name, e);
			return name;
		}
	}
	
	public String getDisplayString(AbstractWbemsmtFco cimObject, WBEMClient cimClient) {
		return getDisplayString(cimObject.getCimInstance(), cimClient);
	}
	

}
