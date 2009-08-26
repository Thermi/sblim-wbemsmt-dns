 /** 
  * ShareList.java
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
  * Description: List of dns MasterZone wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.MasterZone;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim221.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.MasterZone
 */

public class MasterZoneList extends ObjectList  {

	
	public MasterZone getMasterZone(CimObjectKey key)
	{
		return (MasterZone)get(key);
	}
	
	public MasterZone getMasterZone(CIMObjectPath path)
	{
		return getMasterZone(new CimObjectKey(path));
	}

	public MasterZone getMasterZone(CIM_ManagedElement element)
	{
		return getMasterZone(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addMasterZone(MasterZone mz) throws WbemsmtException
	{
		put(mz);
	}
	
	protected Object getKey(Object value) {
		MasterZone mz = (MasterZone) value;
		return mz.getMasterZone().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		MasterZone mz = (MasterZone) value;
		return mz.getMasterZone();
	}

	public MasterZone getMasterZone(int i) throws WbemsmtException {
		return (MasterZone) getList().get(i);
	}
}
