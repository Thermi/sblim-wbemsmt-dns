 /** 
  * StubZoneList.java
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
  * Description: List of dns StubZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.StubZone;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


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

	public void addStubZone(StubZone sz)
	{
		put(sz);
	}
	
	protected Object getKey(Object value) {
		StubZone sz = (StubZone) value;
		return sz.getStubZone().get_Name();
	}
	
	protected Object getFco(Object value) {
		StubZone sz = (StubZone) value;
		return sz.getStubZone();
	}

	public StubZone getStubZone(int i) {
		return (StubZone) getList().get(i);
	}
}
