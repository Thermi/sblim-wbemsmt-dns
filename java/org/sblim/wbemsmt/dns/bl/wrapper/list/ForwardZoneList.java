 /** 
  * ForwardZoneList.java
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
  * Description: List of dns ForwardZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.ForwardZone;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.ForwardZone
 */

public class ForwardZoneList extends ObjectList  {

	public ForwardZone getForwardZone(CimObjectKey key)
	{
		return (ForwardZone)objectsByCimObjectKey.get(key);
	}
	
	public ForwardZone getForwardZone(CIMObjectPath path)
	{
		return getForwardZone(new CimObjectKey(path));
	}

	public ForwardZone getForwardZone(CIM_ManagedElement element)
	{
		return getForwardZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addForwardZone(ForwardZone fz)
	{
		objectsByCimObjectKey.put(fz.getCimObjectKey(),fz);
	}
	
	protected Object getKey(Object value) {
		ForwardZone rr = (ForwardZone) value;
		return rr.getForwardZone().get_Name();
	}
	
	protected Object getFco(Object value) {
		ForwardZone rr = (ForwardZone) value;
		return rr.getForwardZone();
	}

	public ForwardZone getForwardZone(int i) {
		return (ForwardZone) getList().get(i);
	}
}
