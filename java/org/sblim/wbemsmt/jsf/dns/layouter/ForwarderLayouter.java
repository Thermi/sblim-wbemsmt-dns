 /** 
  * MasterAddressesLayouter.java
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
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: Layouter for Forwarder
  * 
  */
package org.sblim.wbemsmt.jsf.dns.layouter;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

public class ForwarderLayouter extends DnsLayouter {

	public void addForwarder(HtmlPanelGrid panelForCustomLayout, DnsForwarderDataContainer container, String width, boolean addHeader, LabeledJSFInputComponent useGlobal) {

		
		String widthButtons = "width:160px";

		if (addHeader)
		{
			HtmlOutputText label = getLabel("<br>");
			label.setEscape(false);
			panelForCustomLayout.getChildren().add(label);
			panelForCustomLayout.getChildren().add(super.getDummyLabel());
			
			label = getLabelWithBoundValue("DNS","title.forwarder");
			label.setEscape(false);
			label.setStyle("font-weight:bold");
			panelForCustomLayout.getChildren().add(label);
			panelForCustomLayout.getChildren().add(super.getDummyLabel());
		}
		

		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Forward());
		
		HtmlPanelGrid forwardersGrid = createTable(2, "0", "5");
		forwardersGrid.setColumnClasses("topAlignment,topAlignment");
		panelForCustomLayout.getChildren().add(forwardersGrid);
		
		
		//labels for Forwarders
		forwardersGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_NewForwarder()).getLabelPanel());
		forwardersGrid.getChildren().add(((LabeledJSFInputComponent) container.get_Forwarders()).getLabelPanel());
		
		//fields for Forwarders
		LabeledJSFInputComponent addButton = (LabeledJSFInputComponent) container.get_usr_AddForwarder();
		LabeledJSFInputComponent removeButton = (LabeledJSFInputComponent) container.get_usr_RemoveForwarder();
		
		addButton.addStyleSheetElement(widthButtons);
		removeButton.addStyleSheetElement(widthButtons);

		
		LabeledJSFInputComponent usedAddresses = (LabeledJSFInputComponent) container.get_Forwarders();
		LabeledJSFInputComponent newAddress = (LabeledJSFInputComponent) container.get_usr_NewForwarder();

		usedAddresses.addStyleSheetElement(widthButtons);
		newAddress.addStyleSheetElement(widthButtons);

		forwardersGrid.getChildren().add(newAddress.getComponentPanel());
		forwardersGrid.getChildren().add(usedAddresses.getComponentPanel());

		forwardersGrid.getChildren().add(addButton.getComponentPanel());
		forwardersGrid.getChildren().add(removeButton.getComponentPanel());

		if (useGlobal != null)
		{
			useGlobal.addStyleSheetElement(widthButtons);
			
			HtmlOutputText label = getLabel("<br>");
			label.setEscape(false);			
			forwardersGrid.getChildren().add(label);
			forwardersGrid.getChildren().add(getDummyLabel());
			forwardersGrid.getChildren().add(useGlobal.getComponentPanel());
			forwardersGrid.getChildren().add(getDummyLabel());
		}
	}

	public void addForwarderForSummary(HtmlPanelGrid panelForCustomLayout, DnsForwardZoneWizardSummaryDataContainer container, String width) {


		
		HtmlOutputText label = getLabel("<br>");
		label.setEscape(false);
		panelForCustomLayout.getChildren().add(label);
		panelForCustomLayout.getChildren().add(super.getDummyLabel());

		label = getLabelWithBoundValue("DNS","title.forwarder");
		label.setEscape(false);
		label.setStyle("font-weight:bold");
		panelForCustomLayout.getChildren().add(label);
		panelForCustomLayout.getChildren().add(super.getDummyLabel());

		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Forward());
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Forwarders());
	
	}	

}
