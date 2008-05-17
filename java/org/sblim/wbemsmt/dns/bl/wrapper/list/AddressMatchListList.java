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

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.AddressMatchList;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.AddressMatchList
 */

public class AddressMatchListList extends ObjectList  {

	public AddressMatchList getAddressMatchList(CimObjectKey key)
	{
		return (AddressMatchList)get(key);
	}
	
	public AddressMatchList getAddressMatchList(CIMObjectPath path)
	{
		return getAddressMatchList(new CimObjectKey(path));
	}

	public AddressMatchList getAddressMatchList(CIM_ManagedElement element)
	{
		return getAddressMatchList(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addAddressMatchList(AddressMatchList addressMatchList) throws WbemsmtException
	{
		put(addressMatchList);
	}
	
	protected Object getKey(Object value) {
		AddressMatchList rr = (AddressMatchList) value;
		return rr.getFco().get_key_Name();
	}
	
	protected Object getFco(Object value) {
		AddressMatchList rr = (AddressMatchList) value;
		return rr.getFco();
	}

	public AddressMatchList getAddressMatchList(int i) throws WbemsmtException {
		return (AddressMatchList) getList().get(i);
	}

	public AddressMatchList getAddressMatchListByListName(String listName) throws WbemsmtException {
		return (AddressMatchList) getObjectsByName().get(listName);
	}
}
