 /** 
  * HintZoneList.java
  *
  * (C) Copyright IBM Corp. 2005
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
  * Description: List of dns HintZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.HintZone;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.HintZone
 */

public class HintZoneList extends ObjectList  {

	public HintZone getHintZone(CimObjectKey key)
	{
		return (HintZone)objectsByCimObjectKey.get(key);
	}
	
	public HintZone getHintZone(CIMObjectPath path)
	{
		return getHintZone(new CimObjectKey(path));
	}

	public HintZone getHintZone(CIM_ManagedElement element)
	{
		return getHintZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addHintZone(HintZone hz)
	{
		objectsByCimObjectKey.put(hz.getCimObjectKey(),hz);
	}
	
	protected String getKey(Object value) {
		HintZone rr = (HintZone) value;
		return rr.getHintZone().get_Name();
	}
	
	protected Object getFco(Object value) {
		HintZone rr = (HintZone) value;
		return rr.getHintZone();
	}

	public HintZone getHintZone(int i) {
		return (HintZone) getList().get(i);
	}
}
