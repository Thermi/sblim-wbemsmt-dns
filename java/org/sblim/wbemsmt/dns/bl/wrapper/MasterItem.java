 /** 
  * IpAddress.java
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
  * Description: wrapper for a slave's ip address to find the master
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import javax.cim.CIMObjectPath;
import javax.cim.CIMProperty;
import javax.cim.UnsignedInteger8;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class MasterItem extends DnsBusinessObject {

	private final String ip;
	private final UnsignedInteger8 type;
	private boolean predefined = false;

	/**
	 * @param zone must be set if existsOnServer = true
	 * @throws WbemsmtException 
	 */
	public MasterItem(String ip, UnsignedInteger8 type, DnsCimAdapter adapter,boolean predefined) throws WbemsmtException {
		super(adapter);
		this.ip = ip;
		this.type = type;
		this.predefined = predefined;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() throws WbemsmtException {
		CIMProperty[] keys = new CIMProperty[1];
		keys[0] = Linux_DnsMasters.create_key_Name(adapter.getCimClient(), adapter.getNamespace(), ip + type.intValue());
		return new CimObjectKey(new CIMObjectPath(Linux_DnsMasters.CIM_CLASS_NAME,adapter.getNamespace(), keys));
	}

	public String getDisplayString() {
		return ip;
	}

	public String getIp() {
		return ip;
	}

	public UnsignedInteger8 getType() {
		return type;
	}

	public boolean isPredefined() {
		return predefined;
	}

	public void setPredefined(boolean predefined) {
		this.predefined = predefined;
	}
	
	
	
	
	

}
