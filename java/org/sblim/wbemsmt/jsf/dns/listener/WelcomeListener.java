/**
 * WelcomeListener.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE TER MS OF
 * THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the Common
 * Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/jsf/welcomeListener.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: generated Class
 */

package org.sblim.wbemsmt.jsf.dns.listener;

import javax.faces.context.FacesContext;
import javax.faces.component.html.*;

import javax.wbem.client.WBEMClient;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.welcome.*;
import org.sblim.wbemsmt.exception.WbemsmtException;
import javax.faces.component.UIComponentBase;

import org.apache.myfaces.custom.div.Div;

public class WelcomeListener implements JsfWelcomeListener {

    HtmlPanelGrid panel;
    DataContainer dataContainer;

    public void create(String expressionPrefix, WBEMClient cimClient) throws WbemsmtException {
        try {
            org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter = (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) CimAdapterFactory
                    .getInstance().getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,
                            FacesContext.getCurrentInstance(), cimClient);
            //create container
            org.sblim.wbemsmt.jsf.dns.container.welcome.WelcomeDataContainerImpl container = new org.sblim.wbemsmt.jsf.dns.container.welcome.WelcomeDataContainerImpl(
                    adapter, expressionPrefix);
            container.getPanelForCustomLayout().setStyleClass("mainTable");

            //update the container and children objects
            container.updateControls();

            this.dataContainer = container;
            panel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                    .createComponent(HtmlPanelGrid.COMPONENT_TYPE);

            container.getLayouter().layout(container.getPanelForCustomLayout(), container,
                    adapter.getBundle());

            HtmlPanelGrid containerPanel = (HtmlPanelGrid) container.getInputFieldContainer();

            HtmlPanelGrid childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance()
                    .getApplication().createComponent(HtmlPanelGrid.COMPONENT_TYPE);
            childEditFields.setStyleClass("childTable");

            //add the single childs

            //add the childs with occurence list

            Div div = (Div) FacesContext.getCurrentInstance().getApplication().createComponent(
                    Div.COMPONENT_TYPE);
            div.setStyleClass("divWrappingChildTable");
            div.getChildren().add(childEditFields);

            containerPanel.getChildren().add(div);

            UIComponentBase panelToAdd = null;
            panelToAdd = containerPanel;

            panel.getChildren().add(panelToAdd);

        }
        catch (Exception e) {
            throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                    "Cannot process Event with listener " + getClass().getName(), e);
        }
    }

    public org.sblim.wbemsmt.bl.welcome.WelcomeListener getListenerByPlType()
            throws WbemsmtException {
        return this;
    }

    public UIComponentBase getPanel() {
        return panel;
    }

    public DataContainer getContainer() {
        return dataContainer;
    }
}