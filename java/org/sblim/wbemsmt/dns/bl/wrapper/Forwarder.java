 /** 
  * IpAddress.java
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
  * Description: wrapper for a slave's ip address to find the master
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import javax.cim.CIMObjectPath;
import javax.cim.CIMProperty;
import javax.cim.UnsignedInteger8;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class Forwarder extends DnsBusinessObject {

	private boolean existsOnServer = false;
	private boolean existsOnClient = false;
	private final String forwarder;
	private final UnsignedInteger8 type;
	

	/**
	 * @param zone must be set if existsOnServer = true
	 */
	public Forwarder(String forwarder, UnsignedInteger8 type, DnsCimAdapter adapter,boolean existsOnServer,boolean existsOnClient) {
		super(adapter);
		this.forwarder = forwarder;
		this.type = type;
		this.existsOnServer = existsOnServer;
		this.existsOnClient = existsOnClient;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() throws WbemsmtException {
			CIMProperty[] keys = new CIMProperty[1];
			keys[0] = Linux_DnsForwarders.create_key_Name(adapter.getCimClient(),adapter.getNamespace(), forwarder + type.intValue());
			return new CimObjectKey(new CIMObjectPath(Linux_DnsForwarders.CIM_CLASS_NAME,adapter.getNamespace(), keys));
	}

	public boolean isExistsOnServer() {
		return existsOnServer;
	}

	public void setExistsOnServer(boolean existsOnServer) {
		this.existsOnServer = existsOnServer;
	}

	public boolean isExistsOnClient() {
		return existsOnClient;
	}

	public void setExistsOnClient(boolean existsOnClient) {
		this.existsOnClient = existsOnClient;
	}

	public String getDisplayString() {
		return forwarder;
	}

	public String getForwarder() {
		return forwarder;
	}

	public UnsignedInteger8 getType() {
		return type;
	}
	
	
	
	
	

}
