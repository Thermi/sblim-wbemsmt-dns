 /** 
  * MastersList.java
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
  * Description: List of dns Masters wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.Masters;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim221.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.Masters
 */

public class MastersList extends ObjectList  {

	public Masters getMasters(CimObjectKey key)
	{
		return (Masters)get(key);
	}
	
	public Masters getMasters(CIMObjectPath path)
	{
		return getMasters(new CimObjectKey(path));
	}

	public Masters getMasters(CIM_ManagedElement element)
	{
		return getMasters(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addMasters(Masters addressMatchList) throws WbemsmtException
	{
		put(addressMatchList);
	}
	
	protected Object getKey(Object value) {
		Masters rr = (Masters) value;
		return rr.getFco().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		Masters rr = (Masters) value;
		return rr.getFco();
	}

	public Masters getMasters(int i) throws WbemsmtException {
		return (Masters) getList().get(i);
	}

	public Masters getMastersByListName(String listName) throws WbemsmtException {
		return (Masters) getObjectsByName().get(listName);
	}
}
