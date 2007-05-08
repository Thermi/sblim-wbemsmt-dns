 /** 
  * AddressMatchListList.java
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
  * Description: List of dns AddressMatchList wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.AddressMatchList;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.AddressMatchList
 */

public class AddressMatchListList extends ObjectList  {

	public AddressMatchList getAddressMatchList(CimObjectKey key)
	{
		return (AddressMatchList)objectsByCimObjectKey.get(key);
	}
	
	public AddressMatchList getAddressMatchList(CIMObjectPath path)
	{
		return getAddressMatchList(new CimObjectKey(path));
	}

	public AddressMatchList getAddressMatchList(CIM_ManagedElement element)
	{
		return getAddressMatchList(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addAddressMatchList(AddressMatchList addressMatchList)
	{
		objectsByCimObjectKey.put(addressMatchList.getCimObjectKey(),addressMatchList);
	}
	
	protected Object getKey(Object value) {
		AddressMatchList rr = (AddressMatchList) value;
		return rr.getFco().get_Name();
	}
	
	protected Object getFco(Object value) {
		AddressMatchList rr = (AddressMatchList) value;
		return rr.getFco();
	}

	public AddressMatchList getAddressMatchList(int i) {
		return (AddressMatchList) getList().get(i);
	}

	public AddressMatchList getAddressMatchListByListName(String listName) {
		return (AddressMatchList) getObjectsByName().get(listName);
	}
}
