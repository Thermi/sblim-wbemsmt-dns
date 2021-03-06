 /** 
  * StubZoneList.java
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
  * Description: List of dns StubZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.StubZone;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim221.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.MasterZone
 */

public class StubZoneList extends ObjectList  {

	public StubZone getStubZone(CimObjectKey key)
	{
		return (StubZone)get(key);
	}
	
	public StubZone getStubZone(CIMObjectPath path)
	{
		return getStubZone(new CimObjectKey(path));
	}

	public StubZone getStubZone(CIM_ManagedElement element)
	{
		return getStubZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addStubZone(StubZone sz) throws WbemsmtException
	{
		put(sz);
	}
	
	protected Object getKey(Object value) {
		StubZone sz = (StubZone) value;
		return sz.getStubZone().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		StubZone sz = (StubZone) value;
		return sz.getStubZone();
	}

	public StubZone getStubZone(int i) throws WbemsmtException {
		return (StubZone) getList().get(i);
	}
}
