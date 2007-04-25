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

import java.util.Vector;

import org.sblim.wbem.cim.CIMDataType;
import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;

public class Forwarder extends DnsBusinessObject {

	private boolean existsOnServer = false;
	private boolean existsOnClient = false;
	private final String forwarder;
	private final UnsignedInt8 type;
	

	/**
	 * @param zone must be set if existsOnServer = true
	 * @throws org.sblim.wbemsmt.exception.ModelLoadException 
	 */
	public Forwarder(String forwarder, UnsignedInt8 type, DnsCimAdapter adapter,boolean existsOnServer,boolean existsOnClient) {
		super(adapter);
		this.forwarder = forwarder;
		this.type = type;
		this.existsOnServer = existsOnServer;
		this.existsOnClient = existsOnClient;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
			Vector keys = new Vector();
			keys.add(CIMPropertyBuilder.create(Linux_DnsForwarders.CIM_PROPERTY_NAME,forwarder + type.intValue(),CIMDataType.STRING));
			return new CimObjectKey(new CIMObjectPath(Linux_DnsForwarders.CIM_CLASS_NAME,keys));
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

	public UnsignedInt8 getType() {
		return type;
	}
	
	
	
	
	

}
