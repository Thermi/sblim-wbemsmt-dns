/** 
  * EditMasterZoneListenerEditBeanTabAcl.java
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

public class EditMasterZoneListenerEditBeanTabAcl extends EditBean {
	
	    
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl currentEditContainer1;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter1 = null;
		
		
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl currentEditContainer2;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter2 = null;
		
		
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl currentEditContainer3;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter3 = null;
		
		
		private HtmlPanelGrid panel;
	   
	    public EditMasterZoneListenerEditBeanTabAcl()
		{
			super(ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},LocaleManager.getCurrent(FacesContext.getCurrentInstance()).getCurrentLocale()));		
		}

		public String save() throws ValidationException, ObjectSaveException
		{
			saveResult = new MessageList();
						MessageList result = null;
						
			
			
								int successCount = 0;
								
									
					//Saving Container DnsAllowTransferForZoneDataContainer
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
							
								
									
					//Saving Container DnsAllowQueryForZoneDataContainer
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
							
								
									
					//Saving Container DnsAllowUpdateForZoneDataContainer
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
										
						
			return PAGE_EDIT;
		}
		
		public void edit(ITaskLauncherTreeNode treeNode) throws ObjectNotFoundException, UpdateControlsException, CountException, InitContainerException
		{
		
			String bindingPrefix = null;
			HtmlPanelGrid childEditFields = null;
						panel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);			
			panel.setWidth("100%");
			panel.setCellspacing("0");
			panel.setCellpadding("0");
			
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
				selector.select(treeNode,adapter1,"editDnsMasterZoneAllowTransfer");

				adapter1 .setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);				
				
				//ADD THE FIELDS FOR CONTAINER DnsAllowTransferForZoneDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[0].";

				//create cotainner
    			currentEditContainer1 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl(adapter1,bindingPrefix);
				currentEditContainer1.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer1.getInputFieldContainer());
				containerPanel.setWidth("100%");
    			containerPanel.setCellspacing("0");
    			containerPanel.setCellpadding("0");
    			
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
            					
				addFooter(panel,"objectActionController.editBeans['TabAcl'].");
				
			
								
				cimClient = treeNode.getCimClient();
				
				adapter2 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter2,"editDnsMasterZoneAllowQuery");

				adapter2 .setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);				
				
				//ADD THE FIELDS FOR CONTAINER DnsAllowQueryForZoneDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[1].";

				//create cotainner
    			currentEditContainer2 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl(adapter2,bindingPrefix);
				currentEditContainer2.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer2.getInputFieldContainer());
				containerPanel.setWidth("100%");
    			containerPanel.setCellspacing("0");
    			containerPanel.setCellpadding("0");
    			
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
            					
				addFooter(panel,"objectActionController.editBeans['TabAcl'].");
				
			
								
				cimClient = treeNode.getCimClient();
				
				adapter3 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter3,"editDnsMasterZoneAllowUpdate");

				adapter3 .setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);				
				
				//ADD THE FIELDS FOR CONTAINER DnsAllowUpdateForZoneDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['TabAcl'].containers[2].";

				//create cotainner
    			currentEditContainer3 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl(adapter3,bindingPrefix);
				currentEditContainer3.getInputFieldContainer().setStyleClass("mainTable");
				containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				containerPanel.getChildren().add(currentEditContainer3.getInputFieldContainer());
				containerPanel.setWidth("100%");
    			containerPanel.setCellspacing("0");
    			containerPanel.setCellpadding("0");
    			
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
            					
				addFooter(panel,"objectActionController.editBeans['TabAcl'].");
				
			
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
	   
    	public String revert() throws ObjectRevertException
    	{
    	        
    					adapter1 .revert(currentEditContainer1 );
    		    
    					adapter2 .revert(currentEditContainer2 );
    		    
    					adapter3 .revert(currentEditContainer3 );
    		
			try
			{
    	        
    					adapter1 .updateControls(currentEditContainer1 );
			    
    					adapter2 .updateControls(currentEditContainer2 );
			    
    					adapter3 .updateControls(currentEditContainer3 );
						} catch (UpdateControlsException e)
			{
				throw new ObjectRevertException("Cannot updateControls after Reverting the changes",e);
			}
			
			
			return EditBean.PAGE_EDIT;
    	}
	   
		
}