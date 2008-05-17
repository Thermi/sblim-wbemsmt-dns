 /** 
  * MasterList.java
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
  * Description: List of dns Master wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import java.util.logging.Level;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.MasterItem;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.MasterZone
 */

public class MasterItemList extends ObjectList  {

	public MasterItem getMasterItem(CimObjectKey key)
	{
		return (MasterItem)get(key);
	}
	
	public MasterItem getMasterItem(CIMObjectPath path)
	{
		return getMasterItem(new CimObjectKey(path));
	}

	public MasterItem getMasterItem(CIM_ManagedElement element)
	{
		return getMasterItem(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addMasterItem(MasterItem sz) throws WbemsmtException
	{
		put(sz);
	}
	
	protected Object getKey(Object value) {
		MasterItem ip = (MasterItem) value;
		return ip.getIp();
	}
	
	protected Object getFco(Object value) {
		return null;
	}

	public MasterItem getMasterItem(int i) throws WbemsmtException {
		return (MasterItem) getList().get(i);
	}

	/**
	 * Get the ip Address by the the name (the Address itself), check only those existing on the client
	 * @param newAddress
	 * @return
	 * @throws WbemsmtException 
	 */
	public MasterItem getMasterItemByName(String newAddress) throws WbemsmtException {
		for (int ii=0; ii < size(); ii++)
		{
			MasterItem ip = getMasterItem(ii);
			if (ip.getIp().equals(newAddress))
			{
				return ip;				
			}
		}
		
		return null;
	}
	
	public String toString()
	{
		try {
            String[] forwarders = getNameArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < forwarders.length; i++) {
            	String forwarder = forwarders[i];
            	if (sb.length() > 0) sb.append("; ");
            	sb.append(forwarder);
            }
            
            return sb.toString();
        }
        catch (WbemsmtException e) {
            logger.log(Level.SEVERE,"To string is not possible " + e);
            return super.toString();
        }
	}

	public void remove(MasterItem masterItem) throws WbemsmtException {
		remove(masterItem.getCimObjectKey());
	}	
	
}
