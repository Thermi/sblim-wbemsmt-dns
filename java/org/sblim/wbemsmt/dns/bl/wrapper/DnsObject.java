 /** 
  * DnsObject.java
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
  * Description: Base class for dns wrapper objects
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;

public class DnsObject {

	protected Logger logger = Logger.getLogger(DnsBusinessObject.class.getName());
	protected final DnsCimAdapter adapter;

	public DnsObject(DnsCimAdapter adapter) {
		this.adapter = adapter;
	}

	protected Object getFirstChild(CIMClient cc, Class mustReturnThis, List list, boolean silent, boolean createIfNotExists) throws ModelLoadException {
		if (!silent && list.size() != 1)
		{
			logger.severe("Cannot get Element of Type " + mustReturnThis.getName() + " beause not exact one element was found in List. Found: " + list.size());
			throw new ModelLoadException("Cannot load data model");
		}
		
		if (!silent && list.get(0) == null)
		{
			logger.severe("Cannot get Element of Type " + mustReturnThis.getName() + " beause first element was null");
			throw new ModelLoadException("Cannot load data model");
		}
	
		if (!silent && !list.get(0).getClass().equals(mustReturnThis) && !(list.get(0) instanceof CIMObjectPath) )
		{
			logger.severe("Cannot get Element of Type " + mustReturnThis.getName() + " beause first element is not from type " + mustReturnThis.getName() + " is of type " + list.get(0).getClass());
			throw new ModelLoadException("Cannot load data model");
		}
		
		if (list.size() == 0 && createIfNotExists)
		{
			try {
				return mustReturnThis.newInstance();
			} catch (Exception e) {
				throw new ModelLoadException(e);
			}
		}
		
		if (silent && list.size() == 0)
		{
			return null;
		}
		else
		{
			Object o = list.get(0);
			if (o instanceof CIMObjectPath)
			{
				CIMObjectPath path = (CIMObjectPath) o;
				String helper = mustReturnThis.getName() + "Helper";
				CIM_ManagedElement fco = null;
				try {
					Class clsHelper = Class.forName(helper);
					Method method = clsHelper.getMethod("getInstance",new Class[]{CIMClient.class,CIMObjectPath.class});
					fco = (CIM_ManagedElement) method.invoke(null,new Object[]{cc,path});
					return fco;
				} catch (Exception e) {
					throw new ModelLoadException(fco, e);
				}
			}
			else
			{
				return o;
			}
		}
	
	}

}
