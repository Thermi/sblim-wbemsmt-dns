/** 
 * DeleteSlaveZoneListener.java
 *
 * 
 * © Copyright IBM Corp. 2006,2007
 *
 * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE COMMON PUBLIC LICENSE
 * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
 *
 * You can obtain a current copy of the Common Public License from
 * http://www.opensource.org/licenses/cpl1.0.php
 *
 * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/jsf/deleteListener.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: 
 * 
 * generated Class
 */

package org.sblim.wbemsmt.jsf.dns.listener;

import javax.faces.context.FacesContext;

import org.sblim.wbemsmt.tools.beans.BeanNameConstants;
import org.sblim.wbemsmt.bl.adapter.CimAdapterFactory;
import org.sblim.wbemsmt.bl.adapter.TaskLauncherTreeNodeSelector;
import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.bl.tree.ITreeSelector;
import org.sblim.wbemsmt.bl.tree.TaskLauncherTreeNodeEvent;
import org.sblim.wbemsmt.tasklauncher.event.jsf.*;
import org.sblim.wbemsmt.exception.*;

public class DeleteSlaveZoneListener extends JsfDeleteListener {

    public String processEvent(TaskLauncherTreeNodeEvent event) throws WbemsmtException {
        ITaskLauncherTreeNode treeNode = event.getTreeNode();

        javax.wbem.client.WBEMClient cimClient = treeNode.getCimClient();

        org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter = (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) CimAdapterFactory
                .getInstance().getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,
                        FacesContext.getCurrentInstance(), cimClient);

        TaskLauncherTreeNodeSelector selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
        selector.select(treeNode, adapter, "deleteSlaveZone");

        adapter.delete();
        adapter.reload();
        ITreeSelector treeSelectorBean = (ITreeSelector) BeanNameConstants.TREE_SELECTOR
                .getBoundValue(FacesContext.getCurrentInstance());
        treeSelectorBean.setSelectedTaskLauncherTreeNode(null);

        clearEditBeans();

        return "start";
    }
}