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

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectManyListbox;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

public class ForwarderLayouter extends DnsLayouter {

	public void addForwarder(HtmlPanelGrid panelForCustomLayout, DnsForwarderDataContainer container, String width, boolean addHeader, LabeledJSFInputComponent useGlobal) {


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
		
		//labels for Forwarders
		panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) container.get_usr_NewForwarder()).getLabel());
		panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) container.get_Forwarders()).getLabel());
		
		//fields for Forwarders
		LabeledJSFInputComponent addButton = (LabeledJSFInputComponent) container.get_usr_AddForwarder();
		LabeledJSFInputComponent removeButton = (LabeledJSFInputComponent) container.get_usr_RemoveForwarder();
		
		addButton.addStyleSheetElement(width);
		removeButton.addStyleSheetElement(width);

		
		HtmlSelectManyListbox usedAddresses = (HtmlSelectManyListbox) ((LabeledJSFInputComponent) container.get_Forwarders()).getComponent();
		HtmlInputText newAddress = (HtmlInputText) ((LabeledJSFInputComponent) container.get_usr_NewForwarder()).getComponent();

		usedAddresses.setStyle(width);
		newAddress.setStyle(width);

		panelForCustomLayout.getChildren().add(newAddress);
		panelForCustomLayout.getChildren().add(usedAddresses);

		panelForCustomLayout.getChildren().add(addButton.getComponent());
		panelForCustomLayout.getChildren().add(removeButton.getComponent());

		if (useGlobal != null)
		{
			HtmlOutputText label = getLabel("<br>");
			label.setEscape(false);			
			panelForCustomLayout.getChildren().add(label);
			panelForCustomLayout.getChildren().add(getDummyLabel());
			panelForCustomLayout.getChildren().add(useGlobal.getComponent());
			panelForCustomLayout.getChildren().add(getDummyLabel());
			
		}
		
		
	}

	public void addForwarderForSummary(HtmlPanelGrid panelForCustomLayout, DnsForwarderDataContainer container, String width) {


		
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
