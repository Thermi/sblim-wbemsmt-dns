 /** 
  * ForwarderList.java
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
  * Description: List of dns Forwarders wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import java.util.logging.Level;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.Forwarder;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.MasterZone
 */

public class ForwarderList extends ObjectList  {

	public Forwarder getForwarder(CimObjectKey key)
	{
		return (Forwarder)get(key);
	}
	
	public Forwarder getForwarder(CIMObjectPath path)
	{
		return getForwarder(new CimObjectKey(path));
	}

	public Forwarder getForwarder(CIM_ManagedElement element)
	{
		return getForwarder(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addForwarder(Forwarder sz) throws WbemsmtException
	{
		put(sz);
	}
	
	protected Object getKey(Object value) {
		Forwarder forwarder = (Forwarder) value;
		return forwarder.getForwarder();
	}
	
	protected Object getFco(Object value) {
		return null;
	}

	public Forwarder getForwarder(int i) throws WbemsmtException {
		return (Forwarder) getList().get(i);
	}

	/**
	 * Searches for that Forwarderes shown on the screen and returns the address on position i
	 * @param i starts at 0
	 * @return null if position i is larger than the amount of addresses found on the screen 
	 * @throws WbemsmtException 
	 */
	public Forwarder getForwarderOnClient(int i) throws WbemsmtException {
		
		int foundIdx = -1;
		
		for (int ii=0; ii < size(); ii++)
		{
			if (getForwarder(ii).isExistsOnClient())
			{
				foundIdx++;
			}
			if (foundIdx == i)
			{
				return getForwarder(ii);
			}
		}
		
		return null;
	}

	/**
	 * Get the ip Address by the the name (the Address itself), check only those existing on the client
	 * @param forwarder
	 * @return
	 * @throws WbemsmtException 
	 */
	public Forwarder getForwarderOnClientByName(String forwarderIp) throws WbemsmtException {
		for (int ii=0; ii < size(); ii++)
		{
			Forwarder forwarder = getForwarder(ii);
			if (forwarder.isExistsOnClient() && forwarder.getForwarder().equals(forwarderIp))
			{
				return forwarder;				
			}
		}
		
		return null;
	}

	/**
	 * removes all Object which are not existent on the client
	 * @throws WbemsmtException 
	 *
	 */

	public void removeIfNotExistsOnClient() throws WbemsmtException {
		for (int i = 0; i < size(); i++) {
			Forwarder forwarder = getForwarder(i);
			if (!forwarder.isExistsOnClient())
			{
				remove(forwarder.getCimObjectKey());
			}
		}
		reloadListValues();
	}

	public String toString()
	{
		try {
            removeIfNotExistsOnClient();
            String[] array = getNameArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
            	String forwarder = array[i];
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
	
	
}
