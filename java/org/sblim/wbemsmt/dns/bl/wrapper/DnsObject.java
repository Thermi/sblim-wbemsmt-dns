 /** 
  * DnsObject.java
  *
  * ï¿½ Copyright IBM Corp. 2005
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
  * Description: Base class for dns wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.logging.Logger;

import org.sblim.wbemsmt.bl.WbemsmtBusinessObject;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;

public class DnsObject extends WbemsmtBusinessObject{

	protected Logger logger = Logger.getLogger(DnsBusinessObject.class.getName());
	protected final DnsCimAdapter adapter;

	public DnsObject(DnsCimAdapter adapter) {
		super(adapter);
		this.adapter = adapter;
	}
}
