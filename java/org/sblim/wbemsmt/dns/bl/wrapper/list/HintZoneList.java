 /** 
  * HintZoneList.java
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
  * Description: List of dns HintZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.HintZone;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim221.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.HintZone
 */

public class HintZoneList extends ObjectList  {

	public HintZone getHintZone(CimObjectKey key)
	{
		return (HintZone)get(key);
	}
	
	public HintZone getHintZone(CIMObjectPath path)
	{
		return getHintZone(new CimObjectKey(path));
	}

	public HintZone getHintZone(CIM_ManagedElement element)
	{
		return getHintZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addHintZone(HintZone hz) throws WbemsmtException
	{
		put(hz);
	}
	
	protected Object getKey(Object value) {
		HintZone rr = (HintZone) value;
		return rr.getHintZone().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		HintZone rr = (HintZone) value;
		return rr.getHintZone();
	}

	public HintZone getHintZone(int i) throws WbemsmtException {
		return (HintZone) getList().get(i);
	}
}
