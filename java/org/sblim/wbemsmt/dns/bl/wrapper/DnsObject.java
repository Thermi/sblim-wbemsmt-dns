 /** 
  * DnsObject.java
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
  * Description: Base class for dns wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.logging.Logger;

import org.sblim.wbemsmt.bl.wrapper.WbemsmtBusinessObject;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;

public abstract class DnsObject extends WbemsmtBusinessObject{

	protected Logger logger = Logger.getLogger(DnsBusinessObject.class.getName());
	protected final DnsCimAdapter adapter;

	public DnsObject(DnsCimAdapter adapter) {
		super(adapter);
		this.adapter = adapter;
	}
}
