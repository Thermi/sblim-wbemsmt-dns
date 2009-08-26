 /** 
  * SambaWizard.java
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
  * Description: Wrapper for Wrapper Object for Samba Wizards
  * 
  */


package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class DnsWizard extends DnsBusinessObject {

	public DnsWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	public void loadChilds(WBEMClient cimClient) throws WbemsmtException {
		//do nothing per defautl - wizards have no childs
	}

	public CimObjectKey getCimObjectKey() {
		return null;
	}

}
