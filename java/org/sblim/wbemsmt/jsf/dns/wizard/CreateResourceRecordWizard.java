/** 
  * CreateResourceRecordWizard.java
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
  * @template: ./tools-dcg/templates/jsf/wizardClass.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.wizard;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

//import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
//import org.sblim.wbemsmt.tools.jsf.MultiLineBasePanel;
import org.sblim.wbemsmt.tools.resources.LocaleManager;
import org.sblim.wbemsmt.tools.resources.ResourceBundleManager;
import org.sblim.wbemsmt.tools.wizard.adapter.IPageWizardAdapter;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;
import org.sblim.wbemsmt.tools.wizard.jsf.JSFWizardBase;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.bl.adapter.DataContainer;

public class CreateResourceRecordWizard extends JSFWizardBase implements IPageWizardAdapter {

	private org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainer container = null;
	
	String binding = "objectActionController.currentWizard.currentPanel.";
	
		org.sblim.wbemsmt.jsf.dns.container.wizard.DnsResourceRecordWizardPage1DataContainerImpl panel1 = null;
		org.sblim.wbemsmt.jsf.dns.container.wizard.DnsResourceRecordWizardSummaryDataContainerImpl panel2 = null;
		org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordWizardPage2TypeMxDataContainerImpl panel3 = null;
		org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordWizardPage2TypeOtherDataContainerImpl panel4 = null;
		
	final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter;
	
	public CreateResourceRecordWizard(final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter) {
		super(adapter,ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},LocaleManager.getCurrent(FacesContext.getCurrentInstance()).getCurrentLocale()),"CreateResourceRecordWizard.title");
		this.adapter = adapter;
		this.container = new org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainer (adapter,new org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainerPanels()
 			{
            						//update the child objects
    				
					public Object getMain() throws WbemSmtException
					{
						//Workaround for Bug https://issues.apache.org/jira/browse/MYFACES-1438
						//Create the panel everytime the panel is needed 
						//if (panel1!= null)
						//{
						//	return panel1;
						//}
					
						try
						{
							    						panel1= new org.sblim.wbemsmt.jsf.dns.container.wizard.DnsResourceRecordWizardPage1DataContainerImpl(adapter,binding);
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            
            				//add the single childs
            				            				
            				//add the childs with occurence list
                        	            				panel1.getChildPanel().getChildren().add(childEditFields);
							
															panel1.getLayouter().layout(panel1.getPanelForCustomLayout(), panel1 ,bundle);
							
        					return panel1;
						}
						catch (Exception e)
						{
							throw new WbemSmtException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            						//update the child objects
    				
					public Object getOverview() throws WbemSmtException
					{
						//Workaround for Bug https://issues.apache.org/jira/browse/MYFACES-1438
						//Create the panel everytime the panel is needed 
						//if (panel2!= null)
						//{
						//	return panel2;
						//}
					
						try
						{
							    						panel2= new org.sblim.wbemsmt.jsf.dns.container.wizard.DnsResourceRecordWizardSummaryDataContainerImpl(adapter,binding);
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            
            				//add the single childs
            				            				
            				//add the childs with occurence list
                        	            				panel2.getChildPanel().getChildren().add(childEditFields);
							
							
        					return panel2;
						}
						catch (Exception e)
						{
							throw new WbemSmtException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            						//update the child objects
    				
					public Object getTypeMx() throws WbemSmtException
					{
						//Workaround for Bug https://issues.apache.org/jira/browse/MYFACES-1438
						//Create the panel everytime the panel is needed 
						//if (panel3!= null)
						//{
						//	return panel3;
						//}
					
						try
						{
							    						panel3= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordWizardPage2TypeMxDataContainerImpl(adapter,binding);
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            
            				//add the single childs
            				            				
            				//add the childs with occurence list
                        	            				panel3.getChildPanel().getChildren().add(childEditFields);
							
							
        					return panel3;
						}
						catch (Exception e)
						{
							throw new WbemSmtException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            						//update the child objects
    				
					public Object getTypeOther() throws WbemSmtException
					{
						//Workaround for Bug https://issues.apache.org/jira/browse/MYFACES-1438
						//Create the panel everytime the panel is needed 
						//if (panel4!= null)
						//{
						//	return panel4;
						//}
					
						try
						{
							    						panel4= new org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordWizardPage2TypeOtherDataContainerImpl(adapter,binding);
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            
            				//add the single childs
            				            				
            				//add the childs with occurence list
                        	            				panel4.getChildPanel().getChildren().add(childEditFields);
							
							
        					return panel4;
						}
						catch (Exception e)
						{
							throw new WbemSmtException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            	 			});
		super.initialize();
 		try {
 			super.initWizard((IWizardContainer)container, this);
 		} catch (Exception ex) {
 			ex.printStackTrace();
 			return;
 		}
 		logger.fine("Wizard initialized");
	}
	
	public void cleanUPPage(String panelName) {
		//cleanup is done in the adapter
	}

	
    public boolean savePageValues(String actualPanelName) {
    	//save pageValues is done in the JSFWizardBase.next-Method, delegating the call to the adapter
    	return true;
    }
	
	public IWizardContainer getWizardContainer()
	{
		return container;
	}
	

    public void setSummaryText(String nextPanelName) {
    	//adapter-based wizards having no SummaryText
    	//if wanted a method like getSummaryText shoule be imlemented in AbstractBaseCimAdapter
    }
    
   public String wizardComplete() {
	   //everything necessary for completion is done in the Adaper
	   return "";
   }
   
   public void reload()
   {
     //do nothing
   }

   
   //Workaround for a bug within myFaces - Everytime a new panel is created the childs are created also
   
	public void countAndCreateChilds(DataContainer dataContainer) throws UpdateControlsException {
            						if (dataContainer instanceof org.sblim.wbemsmt.jsf.dns.container.wizard.DnsResourceRecordWizardPage1DataContainerImpl)
					{
        				    					//update the child objects
        										try
						{
							
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            				//add the childs with occurence list
                        								panel1.getChildPanel().getChildren().clear();
            				panel1.getChildPanel().getChildren().add(childEditFields);
						}
						catch (Exception e)
						{
							throw new UpdateControlsException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            						if (dataContainer instanceof org.sblim.wbemsmt.jsf.dns.container.wizard.DnsResourceRecordWizardSummaryDataContainerImpl)
					{
        				    					//update the child objects
        										try
						{
							
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            				//add the childs with occurence list
                        								panel2.getChildPanel().getChildren().clear();
            				panel2.getChildPanel().getChildren().add(childEditFields);
						}
						catch (Exception e)
						{
							throw new UpdateControlsException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            						if (dataContainer instanceof org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordWizardPage2TypeMxDataContainerImpl)
					{
        				    					//update the child objects
        										try
						{
							
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            				//add the childs with occurence list
                        								panel3.getChildPanel().getChildren().clear();
            				panel3.getChildPanel().getChildren().add(childEditFields);
						}
						catch (Exception e)
						{
							throw new UpdateControlsException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            						if (dataContainer instanceof org.sblim.wbemsmt.jsf.dns.container.edit.DnsResourceRecordWizardPage2TypeOtherDataContainerImpl)
					{
        				    					//update the child objects
        										try
						{
							
                                					
    						HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            				childEditFields.setStyleClass("childTable");
                			
            				//add the childs with occurence list
                        								panel4.getChildPanel().getChildren().clear();
            				panel4.getChildPanel().getChildren().add(childEditFields);
						}
						catch (Exception e)
						{
							throw new UpdateControlsException("Cannot process Wizard createResourceRecordWizard",e);
						}
    				}
            		}   
	
	public String getFinishText()
	{
		return bundle.getString("CreateResourceRecordWizard.finishText",bundle.getString("wizard.finishText"));
	}
	
	public String getJavaScriptWaitStatement()
	{
		String text = bundle.getString("CreateResourceRecordWizard.createWaitText",bundle.getString("wizard.createWaitText"));
		return org.sblim.wbemsmt.tools.jsf.JavascriptUtil.getShowWaitCall(text);
	}
}