 /** 
  * ForwardZoneList.java
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
  * Description: List of dns ForwardZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.ForwardZone;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim221.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.ForwardZone
 */

public class ForwardZoneList extends ObjectList  {

	public ForwardZone getForwardZone(CimObjectKey key)
	{
		return (ForwardZone)get(key);
	}
	
	public ForwardZone getForwardZone(CIMObjectPath path)
	{
		return getForwardZone(new CimObjectKey(path));
	}

	public ForwardZone getForwardZone(CIM_ManagedElement element)
	{
		return getForwardZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addForwardZone(ForwardZone fz) throws WbemsmtException
	{
		put(fz);
	}
	
	protected Object getKey(Object value) {
		ForwardZone rr = (ForwardZone) value;
		return rr.getForwardZone().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		ForwardZone rr = (ForwardZone) value;
		return rr.getForwardZone();
	}

	public ForwardZone getForwardZone(int i) throws WbemsmtException {
		return (ForwardZone) getList().get(i);
	}
}
