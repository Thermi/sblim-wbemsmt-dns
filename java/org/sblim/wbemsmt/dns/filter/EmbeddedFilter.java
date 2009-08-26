 /** 
  * EmbeddedFilter.java
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
  * Description: Filter for the DNS tree used in embedded mode
  * 
  */
package org.sblim.wbemsmt.dns.filter;

import java.util.logging.Level;

import org.sblim.wbemsmt.tasklauncher.customtreeconfig.EventListenerDocument.EventListener;
import org.sblim.wbemsmt.tasklauncher.customtreeconfig.TreenodeDocument.Treenode;


public class EmbeddedFilter extends org.sblim.wbemsmt.filter.EmbeddedFilter {

	public Treenode filter(Treenode root) {
		try {
			EventListener initAdapterListener = root.getTreenodeArray(0).getEventListenerArray(0);
			//Node with the service
			Treenode serviceNode = root.getTreenodeArray(0).getTreenodeArray(0);
			serviceNode.addNewEventListener().set(initAdapterListener.copy());
			
			root.addNewTreenode().set(serviceNode.copy());
			//remove the node with the taskname
			root.removeTreenode(0);
			return root;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Cannot filter Treemodel",e);
			return null;
		}
	}
	
}
