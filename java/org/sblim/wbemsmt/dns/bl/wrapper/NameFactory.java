 /** 
  * NameFactory.java
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
  * Description: Factory for creating name attributes for masters, addressMatchLists and Forwarders
  * 
  * 
  * There is a specific syntax required for the 'Name' of the ACL/Forwarders/Masters :
  * location::[sub-location::]attribute-name
  * 
  * location: global | zone | options
  * sub-location: <zone-name> | <masters-name> | <addressmatchlist-name> 
  * attribute-name: allow-notify | allow-query | allow-recursion | allow-update | allow-transfer | blackhole | masters | forwarders | userdefined
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.exception.WbemsmtException;

public class NameFactory {

	public static final String SEPARATOR = "::";

	public static final String LOCATION_OPTIONS = "options";
	public static final String LOCATION_ZONE = "zone";
	public static final String LOCATION_GLOBAL = "global";

	public static final String ATTRIBUTE_NAME_ALLOW_NOTIFY = "allow-notify";
	public static final String ATTRIBUTE_NAME_ALLOW_QUERY = "allow-query";
	public static final String ATTRIBUTE_NAME_ALLOW_TRANSFER = "allow-transfer";
	public static final String ATTRIBUTE_NAME_ALLOW_RECURSION = "allow-recursion";
	public static final String ATTRIBUTE_NAME_ALLOW_UPDATE = "allow-update";
	public static final String ATTRIBUTE_NAME_ACL = "acl";
	public static final String ATTRIBUTE_NAME_BLACKHOLE = "blackhole";
	public static final String ATTRIBUTE_NAME_MASTERS = "masters";
	public static final String ATTRIBUTE_NAME_FORWARDERS = "forwarders";
	
	/**
	 * 
	 * @param associationClass The class of the association to which the element belongs for which a name is created 
	 * @param cimElementName The name of the Masters-Entry,Zone or AddressMatchList
	 * @return
	 * @throws WbemsmtException
	 */
	public static String createName(Class associationClass, String cimElementName) throws WbemsmtException {
			
			//FOR SERVICE
			if (Linux_DnsForwardersForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_OPTIONS,null,ATTRIBUTE_NAME_FORWARDERS);
			}
			else if (Linux_DnsMastersForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_GLOBAL,cimElementName,ATTRIBUTE_NAME_MASTERS);
			}
			else if (Linux_DnsAddressMatchListsForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_GLOBAL,cimElementName,ATTRIBUTE_NAME_ACL);
			}
			else if (Linux_DnsAllowNotifyForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_OPTIONS,null,ATTRIBUTE_NAME_ALLOW_NOTIFY);
			}
			else if (Linux_DnsAllowQueryForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_OPTIONS,null,ATTRIBUTE_NAME_ALLOW_QUERY);
			}
			else if (Linux_DnsAllowTransferForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_OPTIONS,null,ATTRIBUTE_NAME_ALLOW_TRANSFER);
			}
			else if (Linux_DnsAllowRecursionForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_OPTIONS,null,ATTRIBUTE_NAME_ALLOW_RECURSION);
			}
			else if (Linux_DnsBlackholeForService.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_OPTIONS,null,ATTRIBUTE_NAME_BLACKHOLE);
			}
			
			//FOR ZONE
			else if (Linux_DnsForwardersForZone.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_ZONE,cimElementName,ATTRIBUTE_NAME_FORWARDERS);
			}
			else if (Linux_DnsMastersForZone.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_ZONE,cimElementName,ATTRIBUTE_NAME_MASTERS);
			}
			else if (Linux_DnsAllowNotifyForZone.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_ZONE,cimElementName,ATTRIBUTE_NAME_ALLOW_NOTIFY);
			}
			else if (Linux_DnsAllowQueryForZone.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_ZONE,cimElementName,ATTRIBUTE_NAME_ALLOW_QUERY);
			}
			else if (Linux_DnsAllowTransferForZone.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_ZONE,cimElementName,ATTRIBUTE_NAME_ALLOW_TRANSFER);
			}
			else if (Linux_DnsAllowUpdateForZone.class.isAssignableFrom(associationClass))
			{
				return create(LOCATION_ZONE,cimElementName,ATTRIBUTE_NAME_ALLOW_UPDATE);
			}
			
			throw new WbemsmtException(WbemsmtException.ERR_CREATE_OBJECT,"Cannot get Name for class " + associationClass.getName());
	}
 

	private static String create(String location, String subLocation, String attributeName) {
		if (subLocation != null)
		{
			return location + SEPARATOR + subLocation + SEPARATOR + attributeName;
		}
		else
		{
			return location + SEPARATOR + attributeName;
		}
	}

}
