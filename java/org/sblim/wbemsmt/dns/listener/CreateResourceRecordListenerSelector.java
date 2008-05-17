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
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tasklauncher.CIMInstanceNode;

/**
 * @author Bauschert
 *
 */
public class CreateResourceRecordListenerSelector implements
		TaskLauncherTreeNodeSelectorForCreate {

	private AbstractBaseCimAdapter adapter;

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelector#select(org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode, org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter, java.lang.String)
	 */
	public void select(ITaskLauncherTreeNode treeNode,
			AbstractBaseCimAdapter adapter, String editPanelId)
			throws WbemsmtException {
		
		String className = treeNode instanceof CIMInstanceNode ? ((CIMInstanceNode)treeNode).getCimInstance().getClassName() : null;
		boolean isZone = Linux_DnsMasterZone.CIM_CLASS_NAME.equals(className)
						 || Linux_DnsSlaveZone.CIM_CLASS_NAME.equals(className)
						 || Linux_DnsStubZone.CIM_CLASS_NAME.equals(className)
						 || Linux_DnsHintZone.CIM_CLASS_NAME.equals(className)
						 || Linux_DnsForwardZone.CIM_CLASS_NAME.equals(className)
						 || Linux_DnsZone.CIM_CLASS_NAME.equals(className);
		
		
		
		
		if (adapter == null || !isZone)
		{
			MessageUtil.addMessage(DnsErrCodes.MSG_NO_ZONE_SELECTED, Message.ERROR, DnsCimAdapter.RESOURCE_BUNDLE_NAMES, "no.zone.selected");			
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
