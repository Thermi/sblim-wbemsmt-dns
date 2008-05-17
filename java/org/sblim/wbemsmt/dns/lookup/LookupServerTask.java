 /** 
  * LookupServerTask.java
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
  * Description: Class to lookup the serverside DNS implementation 
  * 
  */
package org.sblim.wbemsmt.dns.lookup;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsService;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.lookup.Lookup;

public class LookupServerTask implements Lookup {

	static Logger logger = Logger.getLogger(LookupServerTask.class.getName()); 
	
	public boolean lookup(WBEMClient cimClient, String namespace) {
		
		try {
			new Linux_DnsService(cimClient,namespace);
			return true;
		} catch (WbemsmtException e) {
			logger.log(Level.SEVERE,"Cannot lookup dns task on server " + namespace,e);
			return false;
		}
	}

}
