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


import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.CimAdapterFactory;
import org.sblim.wbemsmt.bl.welcome.*;
import org.sblim.wbemsmt.exception.WbemSmtException;

import org.sblim.wbemsmt.tools.jsf.EditBasePanel;


public class WelcomeListener implements JsfWelcomeListener {

		   	public EditBasePanel createEditBasePanel(String bindingPrefix, CIMClient cimClient) throws WbemSmtException
   	{
   	   try
   	   {
   	       org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter = 
	         					   (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter)CimAdapterFactory.getInstance()
            					.getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,FacesContext.getCurrentInstance(),cimClient);
   	       //create container
          			org.sblim.wbemsmt.jsf.dns.container.welcome.WelcomeDataContainerImpl container = new org.sblim.wbemsmt.jsf.dns.container.welcome.WelcomeDataContainerImpl(adapter,bindingPrefix);
     				     container.getPanelForCustomLayout().setStyleClass("mainTable");

     				     adapter.updateControls(container);

          	     				     
     				     
          return container;
      		} catch (Exception e) {
          throw new WbemSmtException("Cannot process Event with listener " + getClass().getName(),e);
      		} 
   }
   
	   public org.sblim.wbemsmt.bl.welcome.WelcomeListener getListenerByPlType() throws WbemSmtException {
      		return this;
   	}
}