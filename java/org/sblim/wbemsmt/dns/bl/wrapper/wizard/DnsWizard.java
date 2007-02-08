 /** 
  * SambaWizard.java
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
  * Description: Wrapper for Wrapper Object for Samba Wizards
  * 
  */


package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject;
import org.sblim.wbemsmt.exception.ModelLoadException;

public class DnsWizard extends DnsBusinessObject {

	public DnsWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	public void loadChilds(CIMClient cimClient) throws ModelLoadException {
		//do nothing per defautl - wizards have no childs
	}

	public CimObjectKey getCimObjectKey() {
		return null;
	}

}
