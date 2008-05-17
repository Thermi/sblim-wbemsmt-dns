 /** 
  * SlaveZoneList.java
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
  * Description: List of dns SlaveZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.SlaveZone;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.MasterZone
 */

public class SlaveZoneList extends ObjectList  {

	public SlaveZone getSlaveZone(CimObjectKey key)
	{
		return (SlaveZone)get(key);
	}
	
	public SlaveZone getSlaveZone(CIMObjectPath path)
	{
		return getSlaveZone(new CimObjectKey(path));
	}

	public SlaveZone getSlaveZone(CIM_ManagedElement element)
	{
		return getSlaveZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addSlaveZone(SlaveZone sz) throws WbemsmtException
	{
		put(sz);
	}
	
	protected Object getKey(Object value) {
		SlaveZone sz = (SlaveZone) value;
		return sz.getSlaveZone().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		SlaveZone sz = (SlaveZone) value;
		return sz.getSlaveZone();
	}

	public SlaveZone getSlaveZone(int i) throws WbemsmtException {
		return (SlaveZone) getList().get(i);
	}
}
