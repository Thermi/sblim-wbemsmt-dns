/**
 * EditSlaveZoneListenerEditBeanTabAcl.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED
 * UNDER THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR
 * DISTRIBUTION OF THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a
 * current copy of the Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.jsf.JSFPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/jsf/editBean.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: generated Class
 */

package org.sblim.wbemsmt.jsf.dns.listener;

import javax.faces.component.*;
import javax.faces.component.html.*;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import org.sblim.wbemsmt.bl.tree.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.jsf.*;
import org.sblim.wbemsmt.tools.resources.*; // import org.sblim.wbemsmt.tools.input.jsf.*;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.messages.*;

import org.apache.myfaces.custom.div.Div;

public class EditSlaveZoneListenerEditBeanTabAcl extends EditBean {

    private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl currentEditContainer1;

    private org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter1 = null;

    private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl currentEditContainer2;

    private org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter2 = null;

    private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl currentEditContainer3;

    private org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter3 = null;

    private org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl currentEditContainer4;

    private org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter4 = null;

    private HtmlPanelGrid panel;

    public EditSlaveZoneListenerEditBeanTabAcl() {
        super(ResourceBundleManager.getResourceBundle(new String[] { "messages", "messagesDns" },
                LocaleManager.getCurrent(FacesContext.getCurrentInstance()).getCurrentLocale()));
    }

    public String save() throws WbemsmtException {
        saveResult = new MessageList();
        MessageList result = null;

        int successCount = 0;

        //Saving Container DnsAllowTransferForZoneDataContainer
        if (!saveResult.hasErrors()) {
            adapter1.validateValues(currentEditContainer1);
            result = currentEditContainer1.getMessagesList();

            if (!result.hasErrors()) {
                successCount++;
                adapter1.save(currentEditContainer1);
                //update the container and children objects
                currentEditContainer1.updateControls();
            }

            //Get the infos afte storing the values
            result = currentEditContainer1.getMessagesList();

            saveResult.addAll(result);
        }

        //Saving Container DnsAllowQueryForZoneDataContainer
        if (!saveResult.hasErrors()) {
            adapter2.validateValues(currentEditContainer2);
            result = currentEditContainer2.getMessagesList();

            if (!result.hasErrors()) {
                successCount++;
                adapter2.save(currentEditContainer2);
                //update the container and children objects
                currentEditContainer2.updateControls();
            }

            //Get the infos afte storing the values
            result = currentEditContainer2.getMessagesList();

            saveResult.addAll(result);
        }

        //Saving Container DnsAllowNotifyForZoneDataContainer
        if (!saveResult.hasErrors()) {
            adapter3.validateValues(currentEditContainer3);
            result = currentEditContainer3.getMessagesList();

            if (!result.hasErrors()) {
                successCount++;
                adapter3.save(currentEditContainer3);
                //update the container and children objects
                currentEditContainer3.updateControls();
            }

            //Get the infos afte storing the values
            result = currentEditContainer3.getMessagesList();

            saveResult.addAll(result);
        }

        //Saving Container DnsAllowUpdateForZoneDataContainer
        if (!saveResult.hasErrors()) {
            adapter4.validateValues(currentEditContainer4);
            result = currentEditContainer4.getMessagesList();

            if (!result.hasErrors()) {
                successCount++;
                adapter4.save(currentEditContainer4);
                //update the container and children objects
                currentEditContainer4.updateControls();
            }

            //Get the infos afte storing the values
            result = currentEditContainer4.getMessagesList();

            saveResult.addAll(result);
        }

        //reloadAdapters();

        super.clearEditBeansModified();
        return PAGE_EDIT;
    }

    public void edit(ITaskLauncherTreeNode treeNode) throws WbemsmtException {

        String expressionPrefix = null;
        HtmlPanelGrid childEditFields = null;
        Div div = null;
        panel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication().createComponent(
                HtmlPanelGrid.COMPONENT_TYPE);
        panel.setWidth("100%");
        panel.setCellspacing("0");
        panel.setCellpadding("0");

        UIComponentBase addToThis = panel;

        TaskLauncherTreeNodeSelector selector = null;
        //CimObjectKey key = null;
        HtmlPanelGrid containerPanel = null;
        javax.wbem.client.WBEMClient cimClient = null;

        //This panel is added to container representing the tab. It's the ajaxPanel or the Panel containing the container and it's childs
        UIPanel panelToAdd = null;

        cimClient = treeNode.getCimClient();

        adapter1 = (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) CimAdapterFactory.getInstance()
                .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,
                        FacesContext.getCurrentInstance(), cimClient);

        selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
        selector.select(treeNode, adapter1, "editDnsSlaveZoneAllowTransfer");

        adapter1.setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);

        //ADD THE FIELDS FOR CONTAINER DnsAllowTransferForZoneDataContainer in EditPanel ${editPanel.getId()}

        expressionPrefix = "objectActionController.editBeans['TabAcl'].containers[0].";

        //create cotainner
        currentEditContainer1 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowTransferForZoneDataContainerImpl(
                adapter1, expressionPrefix);
        currentEditContainer1.getPanelForCustomLayout().setStyleClass("mainTable");
        containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        containerPanel.getChildren().add(currentEditContainer1.getInputFieldContainer());
        containerPanel.setWidth("100%");
        containerPanel.setCellspacing("0");
        containerPanel.setCellpadding("0");

        //update the child objects

        //update the container and children objects
        currentEditContainer1.updateControls();

        childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        childEditFields.setStyleClass("childTable");

        //add the single childs

        //add the childs with occurence list

        div = (Div) FacesContext.getCurrentInstance().getApplication().createComponent(
                Div.COMPONENT_TYPE);
        div.setStyleClass("divWrappingChildTable");
        div.getChildren().add(childEditFields);

        containerPanel.getChildren().add(div);

        panelToAdd = containerPanel;

        addToThis.getChildren().add(panelToAdd);

        containers.add(currentEditContainer1);

        currentEditContainer1.getLayouter().layout(currentEditContainer1.getPanelForCustomLayout(),
                currentEditContainer1, bundle);

        addFooter(panel, "objectActionController.editBeans['TabAcl'].");

        cimClient = treeNode.getCimClient();

        adapter2 = (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) CimAdapterFactory.getInstance()
                .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,
                        FacesContext.getCurrentInstance(), cimClient);

        selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
        selector.select(treeNode, adapter2, "editDnsSlaveZoneAllowQuery");

        adapter2.setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);

        //ADD THE FIELDS FOR CONTAINER DnsAllowQueryForZoneDataContainer in EditPanel ${editPanel.getId()}

        expressionPrefix = "objectActionController.editBeans['TabAcl'].containers[1].";

        //create cotainner
        currentEditContainer2 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowQueryForZoneDataContainerImpl(
                adapter2, expressionPrefix);
        currentEditContainer2.getPanelForCustomLayout().setStyleClass("mainTable");
        containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        containerPanel.getChildren().add(currentEditContainer2.getInputFieldContainer());
        containerPanel.setWidth("100%");
        containerPanel.setCellspacing("0");
        containerPanel.setCellpadding("0");

        //update the child objects

        //update the container and children objects
        currentEditContainer2.updateControls();

        childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        childEditFields.setStyleClass("childTable");

        //add the single childs

        //add the childs with occurence list

        div = (Div) FacesContext.getCurrentInstance().getApplication().createComponent(
                Div.COMPONENT_TYPE);
        div.setStyleClass("divWrappingChildTable");
        div.getChildren().add(childEditFields);

        containerPanel.getChildren().add(div);

        panelToAdd = containerPanel;

        addToThis.getChildren().add(panelToAdd);

        containers.add(currentEditContainer2);

        currentEditContainer2.getLayouter().layout(currentEditContainer2.getPanelForCustomLayout(),
                currentEditContainer2, bundle);

        addFooter(panel, "objectActionController.editBeans['TabAcl'].");

        cimClient = treeNode.getCimClient();

        adapter3 = (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) CimAdapterFactory.getInstance()
                .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,
                        FacesContext.getCurrentInstance(), cimClient);

        selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
        selector.select(treeNode, adapter3, "editDnsSlaveZoneAllowNotify");

        adapter3.setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);

        //ADD THE FIELDS FOR CONTAINER DnsAllowNotifyForZoneDataContainer in EditPanel ${editPanel.getId()}

        expressionPrefix = "objectActionController.editBeans['TabAcl'].containers[2].";

        //create cotainner
        currentEditContainer3 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowNotifyForZoneDataContainerImpl(
                adapter3, expressionPrefix);
        currentEditContainer3.getPanelForCustomLayout().setStyleClass("mainTable");
        containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        containerPanel.getChildren().add(currentEditContainer3.getInputFieldContainer());
        containerPanel.setWidth("100%");
        containerPanel.setCellspacing("0");
        containerPanel.setCellpadding("0");

        //update the child objects

        //update the container and children objects
        currentEditContainer3.updateControls();

        childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        childEditFields.setStyleClass("childTable");

        //add the single childs

        //add the childs with occurence list

        div = (Div) FacesContext.getCurrentInstance().getApplication().createComponent(
                Div.COMPONENT_TYPE);
        div.setStyleClass("divWrappingChildTable");
        div.getChildren().add(childEditFields);

        containerPanel.getChildren().add(div);

        panelToAdd = containerPanel;

        addToThis.getChildren().add(panelToAdd);

        containers.add(currentEditContainer3);

        currentEditContainer3.getLayouter().layout(currentEditContainer3.getPanelForCustomLayout(),
                currentEditContainer3, bundle);

        addFooter(panel, "objectActionController.editBeans['TabAcl'].");

        cimClient = treeNode.getCimClient();

        adapter4 = (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) CimAdapterFactory.getInstance()
                .getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,
                        FacesContext.getCurrentInstance(), cimClient);

        selector = new org.sblim.wbemsmt.bl.tree.CurrentTaskLauncherTreeNodeSelector();
        selector.select(treeNode, adapter4, "editDnsSlaveZoneAllowUpdate");

        adapter4.setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);

        //ADD THE FIELDS FOR CONTAINER DnsAllowUpdateForZoneDataContainer in EditPanel ${editPanel.getId()}

        expressionPrefix = "objectActionController.editBeans['TabAcl'].containers[3].";

        //create cotainner
        currentEditContainer4 = new org.sblim.wbemsmt.jsf.dns.container.edit.DnsAllowUpdateForZoneDataContainerImpl(
                adapter4, expressionPrefix);
        currentEditContainer4.getPanelForCustomLayout().setStyleClass("mainTable");
        containerPanel = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        containerPanel.getChildren().add(currentEditContainer4.getInputFieldContainer());
        containerPanel.setWidth("100%");
        containerPanel.setCellspacing("0");
        containerPanel.setCellpadding("0");

        //update the child objects

        //update the container and children objects
        currentEditContainer4.updateControls();

        childEditFields = (HtmlPanelGrid) FacesContext.getCurrentInstance().getApplication()
                .createComponent(HtmlPanelGrid.COMPONENT_TYPE);
        childEditFields.setStyleClass("childTable");

        //add the single childs

        //add the childs with occurence list

        div = (Div) FacesContext.getCurrentInstance().getApplication().createComponent(
                Div.COMPONENT_TYPE);
        div.setStyleClass("divWrappingChildTable");
        div.getChildren().add(childEditFields);

        containerPanel.getChildren().add(div);

        panelToAdd = containerPanel;

        addToThis.getChildren().add(panelToAdd);

        containers.add(currentEditContainer4);

        currentEditContainer4.getLayouter().layout(currentEditContainer4.getPanelForCustomLayout(),
                currentEditContainer4, bundle);

        addFooter(panel, "objectActionController.editBeans['TabAcl'].");

        //Creating no OK/Cancel-Button because saving single Tabs is disabled (EditAction.saveSinglePanels)

    }

    public HtmlPanelGrid getPanel() {
        return panel;
    }

    //do nothing but to fullfill the java beans properties convention
    public void setPanel(HtmlPanelGrid grid) {
    }

    public void reload() {
        super.reload();
    }
}