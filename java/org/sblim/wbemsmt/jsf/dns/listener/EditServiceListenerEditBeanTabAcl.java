/** 
  * EditServiceListenerEditBeanTabAcl.java
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
  * @template: ./tools-dcg/templates/jsf/editBean.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.listener;

import javax.faces.component.html.*;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.jsf.*;
import org.sblim.wbemsmt.tools.resources.*;
//import org.sblim.wbemsmt.tools.input.jsf.*;
import org.sblim.wbemsmt.bl.adapter.*;

public class EditServiceListenerEditBeanTabAcl extends EditBean {
	
	    
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowNotifyForServiceDataContainerImpl currentEditContainer1;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter1 = null;
		
		
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForServiceDataContainerImpl currentEditContainer2;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter2 = null;
		
		
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForServiceDataContainerImpl currentEditContainer3;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter3 = null;
		
		
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowRecursionForServiceDataContainerImpl currentEditContainer4;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter4 = null;
		
		
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsBlackholeForServiceDataContainerImpl currentEditContainer5;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter5 = null;
		
		
		private HtmlPanelGrid panel;
	   
	    public EditServiceListenerEditBeanTabAcl()
		{
			super(ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},LocaleManager.getCurrent(FacesContext.getCurrentInstance()).getCurrentLocale()));		
		}

		public String save() throws ValidationException, ObjectSaveException
		{
			saveResult = new MessageList();
						MessageList result = null;
						
			
			
								int successCount = 0;
								
									
					//Saving Container DnsAllowNotifyForServiceDataContainer
    				if (!saveResult.hasErrors())
    				{
        				adapter1.validateValues(currentEditContainer1);
        				result = currentEditContainer1.getMessagesList();
    					    					
        				if (!result.hasErrors())
        				{
        					successCount++;
            				adapter1.save(currentEditContainer1);
    						try {
                				//update the child objects
                				                				
                            	    							adapter1.updateControls(currentEditContainer1);
    						} catch (Exception e) {
    							throw new ObjectSaveException("Canot update Model after saving data",e);
    						}
            			}
        				
						//Get the infos afte storing the values
        				result = currentEditContainer1.getMessagesList();
    					
    					    					
        				saveResult.addAll(result);
    				}
							
								
									
					//Saving Container DnsAllowQueryForServiceDataContainer
    				if (!saveResult.hasErrors())
    				{
        				adapter2.validateValues(currentEditContainer2);
        				result = currentEditContainer2.getMessagesList();
    					    					
        				if (!result.hasErrors())
        				{
        					successCount++;
            				adapter2.save(currentEditContainer2);
    						try {
                				//update the child objects
                				                				
                            	    							adapter2.updateControls(currentEditContainer2);
    						} catch (Exception e) {
    							throw new ObjectSaveException("Canot update Model after saving data",e);
    						}
            			}
        				
						//Get the infos afte storing the values
        				result = currentEditContainer2.getMessagesList();
    					
    					    					
        				saveResult.addAll(result);
    				}
							
								
									
					//Saving Container DnsAllowTransferForServiceDataContainer
    				if (!saveResult.hasErrors())
    				{
        				adapter3.validateValues(currentEditContainer3);
        				result = currentEditContainer3.getMessagesList();
    					    					
        				if (!result.hasErrors())
        				{
        					successCount++;
            				adapter3.save(currentEditContainer3);
    						try {
                				//update the child objects
                				                				
                            	    							adapter3.updateControls(currentEditContainer3);
    						} catch (Exception e) {
    							throw new ObjectSaveException("Canot update Model after saving data",e);
    						}
            			}
        				
						//Get the infos afte storing the values
        				result = currentEditContainer3.getMessagesList();
    					
    					    					
        				saveResult.addAll(result);
    				}
							
								
									
					//Saving Container DnsAllowRecursionForServiceDataContainer
    				if (!saveResult.hasErrors())
    				{
        				adapter4.validateValues(currentEditContainer4);
        				result = currentEditContainer4.getMessagesList();
    					    					
        				if (!result.hasErrors())
        				{
        					successCount++;
            				adapter4.save(currentEditContainer4);
    						try {
                				//update the child objects
                				                				
                            	    							adapter4.updateControls(currentEditContainer4);
    						} catch (Exception e) {
    							throw new ObjectSaveException("Canot update Model after saving data",e);
    						}
            			}
        				
						//Get the infos afte storing the values
        				result = currentEditContainer4.getMessagesList();
    					
    					    					
        				saveResult.addAll(result);
    				}
							
								
									
					//Saving Container DnsBlackholeForServiceDataContainer
    				if (!saveResult.hasErrors())
    				{
        				adapter5.validateValues(currentEditContainer5);
        				result = currentEditContainer5.getMessagesList();
    					    					
        				if (!result.hasErrors())
        				{
        					successCount++;
            				adapter5.save(currentEditContainer5);
    						try {
                				//update the child objects
                				                				
                            	    							adapter5.updateControls(currentEditContainer5);
    						} catch (Exception e) {
    							throw new ObjectSaveException("Canot update Model after saving data",e);
    						}
            			}
        				
						//Get the infos afte storing the values
        				result = currentEditContainer5.getMessagesList();
    					
    					    					
        				saveResult.addAll(result);
    				}
										
						
			return PAGE_EDIT;
		}
		
		public void edit(ITaskLauncherTreeNode treeNode) throws ObjectNotFoundException, UpdateControlsException, CountException, InitContainerException
		{
		
			String bindingPrefix = null;
			HtmlPanelGrid childEditFields = null;
						panel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);			
			panel.setWidth("100%");
			
			UIComponentBase addToThis = panel;
			
						TaskLauncherTreeNodeSelector selector = null;
			//CimObjectKey key = null;
			HtmlPanelGrid containerPanel = null;
			org.sblim.wbem.client.CIMClient cimClient = null;
	
			
								
				cimClient = treeNode.getCimClient();
				
				adapter1 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter1,"editDnsServiceAllowNotify");

				
				
				//ADD THE FIELDS FOR CONTAINER DnsAllowNotifyForServiceDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[0].";

				//create cotainner
    			currentEditContainer1 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowNotifyForServiceDataContainerImpl(adapter1,bindingPrefix);
				currentEditContainer1.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer1.getInputFieldContainer());
				containerPanel.setWidth("100%");
				containerPanel.setStyle("border-width:1px;border-color=#99CCFF;margin-bottom:10px");
				//containerPanel.setStyleClass("outerTable");

				//update the child objects
								
            	    			
				
    			adapter1.updateControls(currentEditContainer1);
    			
    			childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				childEditFields.setStyleClass("childTable");
    			

				//add the single childs
								
				//add the childs with occurence list
            					
				addToThis.getChildren().add(containerPanel);
				containerPanel.getChildren().add(childEditFields);
				containers.add(currentEditContainer1);
				
            						currentEditContainer1.getLayouter().layout(currentEditContainer1.getInputFieldContainer(),currentEditContainer1 ,bundle);
            					
				
			
								
				cimClient = treeNode.getCimClient();
				
				adapter2 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter2,"editDnsServiceAllowQuery");

				
				
				//ADD THE FIELDS FOR CONTAINER DnsAllowQueryForServiceDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[1].";

				//create cotainner
    			currentEditContainer2 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForServiceDataContainerImpl(adapter2,bindingPrefix);
				currentEditContainer2.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer2.getInputFieldContainer());
				containerPanel.setWidth("100%");
				containerPanel.setStyle("border-width:1px;border-color=#99CCFF;margin-bottom:10px");
				//containerPanel.setStyleClass("outerTable");

				//update the child objects
								
            	    			
				
    			adapter2.updateControls(currentEditContainer2);
    			
    			childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				childEditFields.setStyleClass("childTable");
    			

				//add the single childs
								
				//add the childs with occurence list
            					
				addToThis.getChildren().add(containerPanel);
				containerPanel.getChildren().add(childEditFields);
				containers.add(currentEditContainer2);
				
            						currentEditContainer2.getLayouter().layout(currentEditContainer2.getInputFieldContainer(),currentEditContainer2 ,bundle);
            					
				
			
								
				cimClient = treeNode.getCimClient();
				
				adapter3 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter3,"editDnsServiceAllowTransfer");

				
				
				//ADD THE FIELDS FOR CONTAINER DnsAllowTransferForServiceDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[2].";

				//create cotainner
    			currentEditContainer3 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForServiceDataContainerImpl(adapter3,bindingPrefix);
				currentEditContainer3.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer3.getInputFieldContainer());
				containerPanel.setWidth("100%");
				containerPanel.setStyle("border-width:1px;border-color=#99CCFF;margin-bottom:10px");
				//containerPanel.setStyleClass("outerTable");

				//update the child objects
								
            	    			
				
    			adapter3.updateControls(currentEditContainer3);
    			
    			childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				childEditFields.setStyleClass("childTable");
    			

				//add the single childs
								
				//add the childs with occurence list
            					
				addToThis.getChildren().add(containerPanel);
				containerPanel.getChildren().add(childEditFields);
				containers.add(currentEditContainer3);
				
            						currentEditContainer3.getLayouter().layout(currentEditContainer3.getInputFieldContainer(),currentEditContainer3 ,bundle);
            					
				
			
								
				cimClient = treeNode.getCimClient();
				
				adapter4 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter4,"editDnsServiceAllowRecursion");

				
				
				//ADD THE FIELDS FOR CONTAINER DnsAllowRecursionForServiceDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[3].";

				//create cotainner
    			currentEditContainer4 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowRecursionForServiceDataContainerImpl(adapter4,bindingPrefix);
				currentEditContainer4.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer4.getInputFieldContainer());
				containerPanel.setWidth("100%");
				containerPanel.setStyle("border-width:1px;border-color=#99CCFF;margin-bottom:10px");
				//containerPanel.setStyleClass("outerTable");

				//update the child objects
								
            	    			
				
    			adapter4.updateControls(currentEditContainer4);
    			
    			childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				childEditFields.setStyleClass("childTable");
    			

				//add the single childs
								
				//add the childs with occurence list
            					
				addToThis.getChildren().add(containerPanel);
				containerPanel.getChildren().add(childEditFields);
				containers.add(currentEditContainer4);
				
            						currentEditContainer4.getLayouter().layout(currentEditContainer4.getInputFieldContainer(),currentEditContainer4 ,bundle);
            					
				
			
								
				cimClient = treeNode.getCimClient();
				
				adapter5 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter5,"editDnsServiceBlackhole");

				
				
				//ADD THE FIELDS FOR CONTAINER DnsBlackholeForServiceDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[4].";

				//create cotainner
    			currentEditContainer5 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsBlackholeForServiceDataContainerImpl(adapter5,bindingPrefix);
				currentEditContainer5.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer5.getInputFieldContainer());
				containerPanel.setWidth("100%");
				containerPanel.setStyle("border-width:1px;border-color=#99CCFF;margin-bottom:10px");
				//containerPanel.setStyleClass("outerTable");

				//update the child objects
								
            	    			
				
    			adapter5.updateControls(currentEditContainer5);
    			
    			childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				childEditFields.setStyleClass("childTable");
    			

				//add the single childs
								
				//add the childs with occurence list
            					
				addToThis.getChildren().add(containerPanel);
				containerPanel.getChildren().add(childEditFields);
				containers.add(currentEditContainer5);
				
            						currentEditContainer5.getLayouter().layout(currentEditContainer5.getInputFieldContainer(),currentEditContainer5 ,bundle);
            					
				
			
						//Creating no OK/Cancel-Button because saving single Tabs is disabled (EditAction.saveSinglePanels)
						
		}
		
		public HtmlPanelGrid getPanel()
		{
			return panel;
		}        

		//do nothing but to fullfill the java beans properties convention
		public void setPanel(HtmlPanelGrid grid)
		{
		}
		
       public void reload()
       {
	       super.reload();
       }
		
}