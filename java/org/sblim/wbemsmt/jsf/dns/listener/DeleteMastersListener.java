/** 
  * DeleteMastersListener.java
  *

 
 * (C) Copyright IBM Corp. 2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE COMMON PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Common Public License from
  * http://www.opensource.org/licenses/cpl1.0.php
  *
  * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
  * @template: ./tools-dcg/templates/jsf/deleteListener.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.listener;

import javax.faces.context.FacesContext;

import org.sblim.wbemsmt.tasklauncher.event.TaskLauncherContextMenuEventListenerImpl;
import org.sblim.wbemsmt.bl.adapter.CimAdapterFactory;
import org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelector;
import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.bl.tree.TaskLauncherTreeNodeEvent;


public class DeleteMastersListener extends TaskLauncherContextMenuEventListenerImpl {

	public String processEvent(TaskLauncherTreeNodeEvent event) throws org.sblim.wbemsmt.exception.WbemSmtException {
				ITaskLauncherTreeNode treeNode = event.getTreeNode();

				org.sblim.wbem.client.CIMClient cimClient = treeNode.getCimClient();

				org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);


				TaskLauncherTreeNodeSelector selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
    			selector.select(treeNode,adapter,"deleteMasters");
				
								adapter.delete();
				adapter.reload();
								
				return "start";
	}
}