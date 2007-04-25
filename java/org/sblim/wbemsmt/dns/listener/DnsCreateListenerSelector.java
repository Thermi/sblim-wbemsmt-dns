 /** 
  * SambaCreateListenerSelector.java
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
  * Description: Selector for all create aciton which are independent of the selected node
  * 
  */
package org.sblim.wbemsmt.dns.listener;

import java.util.List;

import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.CimAdapterFactory;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageUtil;
import org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelectorForCreate;
import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsService;
import org.sblim.wbemsmt.exception.ObjectNotFoundException;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.tasklauncher.CIMInstanceNode;

/**
 * @author Bauschert
 *
 */
public class DnsCreateListenerSelector implements TaskLauncherTreeNodeSelectorForCreate {

	private AbstractBaseCimAdapter adapter;

	public void select(ITaskLauncherTreeNode treeNode, AbstractBaseCimAdapter cimAdapter, String createId) throws ObjectNotFoundException {
		
		ITaskLauncherTreeNode parent = treeNode;
		try {
			while ( ! (parent instanceof CIMInstanceNode && ((CIMInstanceNode)parent).getCimInstance().getClassName().equals(Linux_DnsService.CIM_CLASS_NAME))
					&& parent.findInstanceNodes(Linux_DnsService.CIM_CLASS_NAME).size() != 1
					&& parent.getParent() != null 
					&& parent.getParent() != parent)
			{
				parent = parent.getParent();
			}
		
			List list = parent.findInstanceNodes(Linux_DnsService.CIM_CLASS_NAME);
			
			if (list.size() == 1)
			{
				CIMInstanceNode node = (CIMInstanceNode) list.get(0);
				this.adapter = CimAdapterFactory.getInstance().getAdapter(DnsCimAdapter.class, node.getCimClient());
				this.adapter.select(this.adapter.getKeyByTreeNode(node));
			}
			else
			{
				MessageUtil.addMessage(DnsErrCodes.MSG_CANNOT_SELECT_SERVICE, Message.ERROR, DnsCimAdapter.RESOURCE_BUNDLE_NAMES, "cannot.select.service");
			}
			
			
		} catch (WbemSmtException e) {
			throw new ObjectNotFoundException("Cannot find SambaService with node " + treeNode.getInfo(),e); 
		}
		
	}

	public boolean execute() {
		return adapter != null;
	}

	public AbstractBaseCimAdapter getAdapter() {
		return adapter;
	}

}
