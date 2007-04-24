/** 
  * WelcomeListener.java
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
  * @template: ./tools-dcg/templates/jsf/welcomeListener.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.jsf.dns.listener;

import javax.faces.context.FacesContext;
import javax.faces.component.html.*;

import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.welcome.*;
import org.sblim.wbemsmt.exception.WbemSmtException;
import javax.faces.component.UIComponentBase;

public class WelcomeListener implements JsfWelcomeListener {

	HtmlPanelGrid panel;
	DataContainer dataContainer;

		   	public void create(String bindingPrefix, CIMClient cimClient) throws WbemSmtException
   	{
   	   try
   	   {
   	       org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter = 
	         					   (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
            					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);
   	       //create container
          			org.sblim.wbemsmt.jsf.dns.container.welcome.WelcomeDataContainerImpl container = new org.sblim.wbemsmt.jsf.dns.container.welcome.WelcomeDataContainerImpl(adapter,bindingPrefix);
     				     container.getPanelForCustomLayout().setStyleClass("mainTable");
	
				this.dataContainer = container;
				panel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);

				HtmlPanelGrid containerPanel = (HtmlPanelGrid)container.getInputFieldContainer();

				//update the child objects
            	    			
				
    			adapter.updateControls(container);
    			
    			HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
				childEditFields.setStyleClass("childTable");
    			

				//add the single childs
								
				//add the childs with occurence list
            					
				containerPanel.getChildren().add(childEditFields);
				UIComponentBase panelToAdd = null;
									panelToAdd = containerPanel;
								
    			
				panel.getChildren().add(panelToAdd);

          					                			container.getLayouter().layout(container.getPanelForCustomLayout(),container ,adapter.getBundle());
          	     				     
     				     
      		} catch (Exception e) {
          throw new WbemSmtException("Cannot process Event with listener " + getClass().getName(),e);
      		} 
   }
   
	   public org.sblim.wbemsmt.bl.welcome.WelcomeListener getListenerByPlType() throws WbemSmtException {
      		return this;
   	}
   	
	public UIComponentBase getPanel()
	{
		return panel;
	}
	
	public DataContainer getContainer()
	{
		return dataContainer;
	}
}