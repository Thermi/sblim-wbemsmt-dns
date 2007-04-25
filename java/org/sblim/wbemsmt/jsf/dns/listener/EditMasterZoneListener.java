/** 
  * EditMasterZoneListener.java
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
  * @template: ./tools-dcg/templates/jsf/editListener.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.listener;

import java.util.*;
import javax.faces.context.FacesContext;

import org.sblim.wbemsmt.tasklauncher.event.jsf.*;
import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.bl.tree.TaskLauncherTreeNodeEvent;
import org.sblim.wbemsmt.tools.beans.BeanNameConstants;
import org.sblim.wbemsmt.tools.jsf.*;
import org.sblim.wbemsmt.tools.resources.*;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.webapp.jsf.ObjectActionControllerBean;
import org.sblim.wbemsmt.bl.help.HelpManager;

public class EditMasterZoneListener extends JsfEditListener {

	public String processEvent(TaskLauncherTreeNodeEvent event) throws WbemSmtException {

			ITaskLauncherTreeNode treeNode = event.getTreeNode();

			
			FacesContext fc = FacesContext.getCurrentInstance();
			Locale locale = LocaleManager.getCurrent(FacesContext.getCurrentInstance()).getCurrentLocale();
        	bundle = ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},locale);
            final ObjectActionControllerBean oac = (ObjectActionControllerBean)BeanNameConstants.OBJECT_ACTION_CONTROLLER.asValueBinding(fc).getValue(fc);
			
			//set the currentListener as topic for the help
            final HelpManager helpManager = (HelpManager)BeanNameConstants.HELP_MANAGER.asValueBinding(fc).getValue(fc);
			helpManager.setMode(HelpManager.MODE_EDIT);
			helpManager.setCurrentTopic("dns","EditMasterZoneListener");
			
			EditBean bean = null;

			Boolean revert = event.getBooleanParameter(TaskLauncherTreeNodeEvent.PARAM_REVERT);
			
			if (oac.getCurrentEditListener() != null && revert != null && revert.booleanValue())
			{
				oac.getCurrentEditListener().revert(false);
			}

    		oac.clearEditBeans();
			
			
							TabbedPane tabbedPane = new TabbedPane(bundle);
				String bundleKey;
						
			
	        
							
				//ADD THE CONTAINERS IN TAB TabMasterZone			
    			bean = new org.sblim.wbemsmt.jsf.dns.listener.EditMasterZoneListenerEditBeanTabMasterZone();
				editBeans.add(bean);
    			bean.edit(treeNode);
    			oac.addEditBean("TabMasterZone",bean);
        		bundleKey = "tab.TabMasterZone";
        		tabbedPane.addTab("TabMasterZone",bundleKey,bean.getPanel());
    						
				//ADD THE CONTAINERS IN TAB TabAcl			
    			bean = new org.sblim.wbemsmt.jsf.dns.listener.EditMasterZoneListenerEditBeanTabAcl();
				editBeans.add(bean);
    			bean.edit(treeNode);
    			oac.addEditBean("TabAcl",bean);
        		bundleKey = "tab.TabAcl";
        		tabbedPane.addTab("TabAcl",bundleKey,bean.getPanel());
    						
				//ADD THE CONTAINERS IN TAB TabSOA			
    			bean = new org.sblim.wbemsmt.jsf.dns.listener.EditMasterZoneListenerEditBeanTabSOA();
				editBeans.add(bean);
    			bean.edit(treeNode);
    			oac.addEditBean("TabSOA",bean);
        		bundleKey = "tab.TabSOA";
        		tabbedPane.addTab("TabSOA",bundleKey,bean.getPanel());
    						
				//ADD THE CONTAINERS IN TAB TabResourceRecords			
    			bean = new org.sblim.wbemsmt.jsf.dns.listener.EditMasterZoneListenerEditBeanTabResourceRecords();
				editBeans.add(bean);
    			bean.edit(treeNode);
    			oac.addEditBean("TabResourceRecords",bean);
        		bundleKey = "tab.TabResourceRecords";
        		tabbedPane.addTab("TabResourceRecords",bundleKey,bean.getPanel());
    		    			
							boolean createOKRevertButtons = ! false && true;
    			tabbedPane.create(createOKRevertButtons);
				oac.setCurrentEditor(tabbedPane.getPanel());
    			oac.setSelectedTabIndex(0);
				oac.setTabbedPane(tabbedPane);
						oac.setCurrentEditListener(this);
			
			return "editPage";		
	}
}