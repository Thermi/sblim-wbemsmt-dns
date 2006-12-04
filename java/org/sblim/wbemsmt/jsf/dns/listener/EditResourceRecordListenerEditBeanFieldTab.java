/** 
  * EditResourceRecordListenerEditBeanFieldTab.java
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
  * @template: templates/jsf/editBean.vm
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

public class EditResourceRecordListenerEditBeanFieldTab extends EditBean {
	
	    
					
		private org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordDataContainerImpl currentEditContainer1;
		
		private	org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter1 = null;
		
		
		private HtmlPanelGrid panel;
	   
	    public EditResourceRecordListenerEditBeanFieldTab()
		{
			super(ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},LocaleManager.getCurrent(FacesContext.getCurrentInstance()).getCurrentLocale()));		
		}

		public String save() throws ValidationException, ObjectSaveException
		{
			saveResult = new MessageList();
						MessageList result = null;
						
			
			
								int successCount = 0;
								
									
					//Saving Container DnsResourceRecordDataContainer
    				if (!saveResult.hasErrors())
    				{
        				adapter1.validateValues(currentEditContainer1);
        				result = currentEditContainer1.getMessagesList();
    					        				addErrors(bundle.getString("validation.error"),result,bundle);
    					    					
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
    					
    					            				if (result.hasErrors())
            				{
            					addErrors(bundle.getString("save.error"),result,bundle);
            				}
            				else if (result.hasWarning())
            				{
            					addErrors(bundle.getString("save.warning"),result,bundle);
            				}
            				else if (result.hasInfo())
            				{
            					addErrors(bundle.getString("save.info"),result,bundle);
            				}
    					    					
        				saveResult.addAll(result);
    				}
										    			
				if (successCount == 1)
    			{
        				addInfo(bundle.getString("save.success"));
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
			
							//HtmlForm form = (HtmlForm) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlForm.COMPONENT_TYPE);
				//panel.getChildren().add(form);
				//addToThis = form;
						TaskLauncherTreeNodeSelector selector = null;
			//CimObjectKey key = null;
			HtmlPanelGrid containerPanel = null;
			org.sblim.wbem.client.CIMClient cimClient = null;
	
			
								
				cimClient = treeNode.getCimClient();
				
				adapter1 = 
					(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);

				selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
				selector.select(treeNode,adapter1,"editResourceRecords");

				
				
				//ADD THE FIELDS FOR CONTAINER DnsResourceRecordDataContainer in EditPanel ${editPanel.getId()}
				
				
				bindingPrefix = "objectActionController.editBeans['fieldTab'].containers[0].";

				//create cotainner
    			currentEditContainer1 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordDataContainerImpl(adapter1,bindingPrefix);
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
				
            					
				
			
						addOKCancel(addToThis,"objectActionController.editBeans['fieldTab'].");
						
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