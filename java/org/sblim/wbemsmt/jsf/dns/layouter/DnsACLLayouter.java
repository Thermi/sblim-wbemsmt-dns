 /** 
  * DnsACLLayouter.java
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
  * Description: Layouter for DNS ACLs
  * 
  */
package org.sblim.wbemsmt.jsf.dns.layouter;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectManyListbox;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsACLLayouter extends DnsLayouter{

	;

	/**
	 * 
	 */
	public DnsACLLayouter() {
		super();
	}

	public void layout(HtmlPanelGrid panelForCustomLayout, DnsAddressMatchListDataContainer container, WbemSmtResourceBundle bundle) {
		layoutImpl(panelForCustomLayout,container,null,bundle,null);
	}	

	public void layout(HtmlPanelGrid panelForCustomLayout, DnsAddressMatchListDataContainer container, WbemSmtResourceBundle bundle,LabeledJSFInputComponent useGlobal) {
		layoutImpl(panelForCustomLayout,container,null,bundle,useGlobal);
	}	

	protected void layoutImpl(HtmlPanelGrid panelForCustomLayout, DnsAddressMatchListDataContainer container, LabeledJSFInputComponent name, WbemSmtResourceBundle bundle, LabeledJSFInputComponent useGlobal) {
		
		//first col is holding the input field, second the used addresses
		panelForCustomLayout.setColumns(2);
		panelForCustomLayout.setCellpadding("0");
		panelForCustomLayout.setCellspacing("0");
		panelForCustomLayout.setWidth("80%");
		
		HtmlInputText newAddressTextField = (HtmlInputText) ((LabeledJSFInputComponent) container.get_usr_NewAddress()).getComponent();
		newAddressTextField.setStyle(DnsACLLayouter.DEFAULT_PANEL_WIDTH);
		
		HtmlCommandButton addNewButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_AddNewAddress()).getComponent();
		addNewButton.setStyle(DnsACLLayouter.DEFAULT_PANEL_WIDTH);
		
		HtmlSelectManyListbox usedAddresses = (HtmlSelectManyListbox) ((LabeledJSFInputComponent) container.get_AddressList()).getComponent();
		usedAddresses.setStyle(DnsACLLayouter.DEFAULT_PANEL_WIDTH);
		
		HtmlCommandButton addPredefinedButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_AddPredefinedAddress()).getComponent();
		addPredefinedButton.setStyle(DnsACLLayouter.DEFAULT_PANEL_WIDTH);
		
		HtmlCommandButton removeButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_RemoveAddress()).getComponent();
		removeButton.setStyle(DnsACLLayouter.DEFAULT_PANEL_WIDTH);

		HtmlCommandButton upButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_AddressUp()).getComponent();
		upButton.setStyle("width:60px");

		HtmlCommandButton downButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_AddressDown()).getComponent();
		downButton.setStyle("width:60px");

		HtmlSelectManyListbox notUsedAddresses = (HtmlSelectManyListbox) ((LabeledJSFInputComponent) container.get_usr_UserAddresses()).getComponent();
		notUsedAddresses.setStyle(DnsACLLayouter.DEFAULT_PANEL_WIDTH);
		
		//add one dummy row
		HtmlOutputText label = getLabel("<br>");
		label.setEscape(false);
		panelForCustomLayout.getChildren().add(label);
		panelForCustomLayout.getChildren().add(getDummyLabel());

		//row 1 (optional with Name of AddressList
		if (name != null)
		{
			panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) name).getLabel());
			panelForCustomLayout.getChildren().add(getDummyLabel());
			panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) name).getComponent());
			panelForCustomLayout.getChildren().add(getDummyLabel());
			label = getLabel("<br>");
			label.setEscape(false);
			panelForCustomLayout.getChildren().add(label);
			panelForCustomLayout.getChildren().add(getDummyLabel());
		}

		HtmlPanelGrid inputGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		inputGrid.setCellpadding("0");
		inputGrid.setCellspacing("0");
		inputGrid.setColumns(1);

		inputGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_NewAddress()).getLabel());
		inputGrid.getChildren().add(newAddressTextField);
		inputGrid.getChildren().add(addNewButton);
		label = getLabel("<br>");
		label.setEscape(false);
		inputGrid.getChildren().add(label);
		inputGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_UserAddresses()).getLabel());
		inputGrid.getChildren().add(notUsedAddresses);
		inputGrid.getChildren().add(addPredefinedButton);

		label = getLabel("<br><br><br>");
		label.setEscape(false);

		HtmlPanelGrid upDownGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		upDownGrid.setColumns(1);
		upDownGrid.setCellpadding("0");
		upDownGrid.setCellspacing("0");
		upDownGrid.getChildren().add(upButton);
		upDownGrid.getChildren().add(label);
		upDownGrid.getChildren().add(downButton);

		
		HtmlPanelGrid usedAddressesGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		usedAddressesGrid.setColumns(2);
		usedAddressesGrid.setCellpadding("0");
		usedAddressesGrid.setCellspacing("0");
		
		usedAddressesGrid.getChildren().add(((LabeledJSFInputComponent) container.get_AddressList()).getLabel());
		usedAddressesGrid.getChildren().add(getDummyLabel());
		
		usedAddressesGrid.getChildren().add(usedAddresses);
		usedAddressesGrid.getChildren().add(upDownGrid);
		
		usedAddressesGrid.getChildren().add(removeButton);
		usedAddressesGrid.getChildren().add(getDummyLabel());

		//add the grids to the outer grid
		panelForCustomLayout.getChildren().add(inputGrid);
		panelForCustomLayout.getChildren().add(usedAddressesGrid);
		
		
		if (useGlobal != null)
		{
			label = getLabel("<br>");
			label.setEscape(false);			
			panelForCustomLayout.getChildren().add(label);
			panelForCustomLayout.getChildren().add(getDummyLabel());
			panelForCustomLayout.getChildren().add(useGlobal.getComponent());
			panelForCustomLayout.getChildren().add(getDummyLabel());
		}		
		
		
		
		
	}
	
}
