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
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.exception.ModelLoadException;

public class MasterItem extends DnsBusinessObject {

	private final String ip;
	private final UnsignedInt8 type;
	private boolean predefined = false;

	/**
	 * @param zone must be set if existsOnServer = true
	 * @throws ModelLoadException 
	 */
	public MasterItem(String ip, UnsignedInt8 type, DnsCimAdapter adapter,boolean predefined) throws ModelLoadException {
		super(adapter);
		this.ip = ip;
		this.type = type;
		this.predefined = predefined;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
		Vector keys = new Vector();
		keys.add(CIMPropertyBuilder.create(Linux_DnsMasters.CIM_PROPERTY_NAME,ip + type.intValue(),CIMDataType.STRING));
		return new CimObjectKey(new CIMObjectPath(Linux_DnsMasters.CIM_CLASS_NAME,keys));
	}

	public String getDisplayString() {
		return ip;
	}

	public String getIp() {
		return ip;
	}

	public UnsignedInt8 getType() {
		return type;
	}

	public boolean isPredefined() {
		return predefined;
	}

	public void setPredefined(boolean predefined) {
		this.predefined = predefined;
	}
	
	
	
	
	

}
