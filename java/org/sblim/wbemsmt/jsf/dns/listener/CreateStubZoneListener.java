/** 
  * CreateStubZoneListener.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
  * @template: ./tools-dcg/templates/jsf/createListener.vm
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
import org.sblim.wbemsmt.tools.beans.BeanNameConstants;
import org.sblim.wbemsmt.tools.wizard.jsf.IWizardController;
import org.sblim.wbemsmt.bl.help.HelpManager;

public class CreateStubZoneListener extends TaskLauncherContextMenuEventListenerImpl {

	public String processEvent(TaskLauncherTreeNodeEvent event) throws org.sblim.wbemsmt.exception.WbemSmtException {
		FacesContext fc = FacesContext.getCurrentInstance();
        IWizardController wizardController = (IWizardController)BeanNameConstants.OBJECT_ACTION_CONTROLLER.asValueBinding(fc).getValue(fc);

		//set the currentListener as topic for the help
        final HelpManager helpManager = (HelpManager)BeanNameConstants.HELP_MANAGER.asValueBinding(fc).getValue(fc);
		helpManager.setMode(HelpManager.MODE_CREATE);
		helpManager.setCurrentTopic("dns","CreateStubZoneListener");
		

		ITaskLauncherTreeNode treeNode = event.getTreeNode();

		org.sblim.wbem.client.CIMClient cimClient = treeNode.getCimClient();
		
		org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter = 
			(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
			.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

		TaskLauncherTreeNodeSelector selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
		selector.select(treeNode,adapter,"createStubZone");

		org.sblim.wbemsmt.jsf.dns.wizard.CreateStubZoneWizard wizard = new org.sblim.wbemsmt.jsf.dns.wizard.CreateStubZoneWizard(adapter);
		wizard.startWizard();
		wizardController.setCurrentWizard(wizard);
		
		return "wizardPage";
	}
}