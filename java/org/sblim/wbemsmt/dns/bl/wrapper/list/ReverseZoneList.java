 /** 
  * ReverseZoneList.java
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
  * Description: List of dns ReverseZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.ReverseZone;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.ReverseZone
 */

public class ReverseZoneList extends ObjectList  {

	public ReverseZone getReverseZone(CimObjectKey key)
	{
		return (ReverseZone)get(key);
	}
	
	public ReverseZone getReverseZone(CIMObjectPath path)
	{
		return getReverseZone(new CimObjectKey(path));
	}

	public ReverseZone getReverseZone(CIM_ManagedElement element)
	{
		return getReverseZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addReverseZone(ReverseZone rz) throws WbemsmtException
	{
		put(rz);
	}
	
	protected Object getKey(Object value) {
		ReverseZone rr = (ReverseZone) value;
		return rr.getReverseZone().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		ReverseZone rr = (ReverseZone) value;
		return rr.getReverseZone();
	}

	public ReverseZone getReverseZone(int i) throws WbemsmtException {
		return (ReverseZone) getList().get(i);
	}
}
