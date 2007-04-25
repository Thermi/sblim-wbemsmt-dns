 /** 
  * AssociatedObjectsLoader.java
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
  * Description: Callback-Interface for loading the associated ACL objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.acl;

import java.util.List;


public interface AssociatedObjectsLoader {
	
	/**
	 * 
	 * @param index
	 * @return a list with CIMObjectPath-Instances of the associated objects or a list with the instances of the associated objects
	 * @see AclHandler#IDX_BLACKHOLE
	 * @see AclHandler#IDX_NOTIFY
	 * @see AclHandler#IDX_QUERY
	 * @see AclHandler#IDX_RECURSION
	 * @see AclHandler#IDX_TRANSFER
	 * @see AclHandler#IDX_UPDATE
	 * @see AclHandler#IDX_USER
	 */
	public List load(int index);
	

}
