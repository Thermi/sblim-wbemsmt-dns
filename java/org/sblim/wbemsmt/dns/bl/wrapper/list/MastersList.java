 /** 
  * MastersList.java
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
  * Description: List of dns Masters wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.Masters;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.Masters
 */

public class MastersList extends ObjectList  {

	public Masters getMasters(CimObjectKey key)
	{
		return (Masters)objectsByCimObjectKey.get(key);
	}
	
	public Masters getMasters(CIMObjectPath path)
	{
		return getMasters(new CimObjectKey(path));
	}

	public Masters getMasters(CIM_ManagedElement element)
	{
		return getMasters(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addMasters(Masters addressMatchList)
	{
		objectsByCimObjectKey.put(addressMatchList.getCimObjectKey(),addressMatchList);
	}
	
	protected String getKey(Object value) {
		Masters rr = (Masters) value;
		return rr.getFco().get_Name();
	}
	
	protected Object getFco(Object value) {
		Masters rr = (Masters) value;
		return rr.getFco();
	}

	public Masters getMasters(int i) {
		return (Masters) getList().get(i);
	}

	public Masters getMastersByListName(String listName) {
		return (Masters) getObjectsByName().get(listName);
	}
}
