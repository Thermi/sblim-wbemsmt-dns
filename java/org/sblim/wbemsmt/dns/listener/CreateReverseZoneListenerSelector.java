 /** 
  * CreateResourceRecordListenerSelector.java
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
  * Description: Selector checks if the selected node is a zone before calling the adapter
  * 
  */
package org.sblim.wbemsmt.dns.listener;

import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageUtil;
import org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelectorForCreate;
import org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector;
import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone;
import org.sblim.wbemsmt.exception.ObjectNotFoundException;
import org.sblim.wbemsmt.tasklauncher.CIMInstanceNode;

/**
 * @author Bauschert
 *
 */
public class CreateReverseZoneListenerSelector implements
		TaskLauncherTreeNodeSelectorForCreate {

	private AbstractBaseCimAdapter adapter;

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelector#select(org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode, org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter, java.lang.String)
	 */
	public void select(ITaskLauncherTreeNode treeNode,
			AbstractBaseCimAdapter adapter, String editPanelId)
			throws ObjectNotFoundException {
		
		String className = treeNode instanceof CIMInstanceNode ? ((CIMInstanceNode)treeNode).getCimInstance().getClassName() : null;
		boolean isMasterzone = Linux_DnsMasterZone.CIM_CLASS_NAME.equals(className);
		
		
		if (adapter == null || !isMasterzone)
		{
			MessageUtil.addMessage(DnsErrCodes.MSG_NO_MASTERZONE_SELECTED, Message.ERROR, DnsCimAdapter.RESOURCE_BUNDLE_NAMES, "no.masterzone.selected");			
		}
		else
		{
			this.adapter = adapter;
			new CurrentTaskLauncherTreeNodeSelector().select(treeNode, adapter, editPanelId);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelectorForCreate#execute()
	 */
	public boolean execute() {
		return adapter != null;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelectorForCreate#getAdapter()
	 */
	public AbstractBaseCimAdapter getAdapter() {
		return adapter;
	}
	

}
