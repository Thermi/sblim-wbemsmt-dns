/** 
  * EditServiceListener.java
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
import java.util.logging.*;
import javax.faces.context.FacesContext;

import org.sblim.wbemsmt.tasklauncher.event.*;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.bl.tree.TaskLauncherTreeNodeEvent;
import org.sblim.wbemsmt.tools.beans.BeanNameConstants;
import org.sblim.wbemsmt.tools.jsf.*;
import org.sblim.wbemsmt.tools.resources.*;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.webapp.jsf.ObjectActionControllerBean;

public class EditServiceListener extends TaskLauncherContextMenuEventListenerImpl implements EditListener {

    private static final Logger logger = Logger.getLogger("org.sblim.wbemsmt.jsf.dns.listener");

	private List editBeans = new ArrayList();

	WbemSmtResourceBundle bundle = null;
	
	public String processEvent(TaskLauncherTreeNodeEvent event) throws WbemSmtException {

			ITaskLauncherTreeNode treeNode = event.getTreeNode();

			
			FacesContext fc = FacesContext.getCurrentInstance();
			Locale locale = LocaleManager.getCurrent(FacesContext.getCurrentInstance()).getCurrentLocale();
        	bundle = ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},locale);
            final ObjectActionControllerBean oac = (ObjectActionControllerBean)BeanNameConstants.OBJECT_ACTION_CONTROLLER.asValueBinding(fc).getValue(fc);
			EditBean bean = null;
			

							TabbedPane tabbedPane = new TabbedPane(bundle);
				String bundleKey;
						
			
	        
							
				//ADD THE CONTAINERS IN TAB TabConfiguration			
    			bean = new org.sblim.wbemsmt.jsf.dns.listener.EditServiceListenerEditBeanTabConfiguration();
				editBeans.add(bean);
    			bean.edit(treeNode);
    			oac.addEditBean("TabConfiguration",bean);
        		bundleKey = "tab.TabConfiguration";
        		tabbedPane.addTab("TabConfiguration",bundleKey,bean.getPanel());
    						
				//ADD THE CONTAINERS IN TAB TabOperations			
    			bean = new org.sblim.wbemsmt.jsf.dns.listener.EditServiceListenerEditBeanTabOperations();
				editBeans.add(bean);
    			bean.edit(treeNode);
    			oac.addEditBean("TabOperations",bean);
        		bundleKey = "tab.TabOperations";
        		tabbedPane.addTab("TabOperations",bundleKey,bean.getPanel());
    						
				//ADD THE CONTAINERS IN TAB TabAcl			
    			bean = new org.sblim.wbemsmt.jsf.dns.listener.EditServiceListenerEditBeanTabAcl();
				editBeans.add(bean);
    			bean.edit(treeNode);
    			oac.addEditBean("TabAcl",bean);
        		bundleKey = "tab.TabAcl";
        		tabbedPane.addTab("TabAcl",bundleKey,bean.getPanel());
    		    			
							boolean createOKCancelButtons = ! false && true;
    			tabbedPane.create(createOKCancelButtons);
				oac.setCurrentEditor(tabbedPane.getPanel());
    			oac.setSelectedTabIndex(0);
				oac.setTabbedPane(tabbedPane);
						oac.setCurrentEditListener(this);
			
			return "editPage";		
	}
	
	public String cancel()
	{
		return EditBean.PAGE_START;
	}
	
	public String save()
	{
		boolean foundErrors = false;

		MessageList messages = new MessageList();
		
		//stop if the first editBean reports errors
		for (int i=0; i < editBeans.size() && !foundErrors; i++)
		{
			try
			{
    			EditBean bean = (EditBean)editBeans.get(i);
    			bean.save();
				messages.addAll(bean.getSaveResult());
    			foundErrors = messages.hasErrors();
			}
			catch (Exception e)
			{
				logger.log(Level.SEVERE,"Cannot save",e);
				org.sblim.wbemsmt.tools.jsf.JsfUtil.handleException(e);
				return EditBean.PAGE_EDIT;
			}
		}
		
		EditBean.handleSaveResult(bundle,messages);
		EditBean.reloadAdapters(editBeans);
						
		return EditBean.PAGE_EDIT;
		
	}
}