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
  * Description: Layouter for Masters
  * 
  */
package org.sblim.wbemsmt.jsf.dns.layouter;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectManyListbox;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

public class MasterAddressesLayouter extends DnsLayouter {

	public void addMasterAddress(HtmlPanelGrid panelForCustomLayout, DnsAddMasterAddressDataContainer container, String width, LabeledJSFInputComponent nameForMasters, boolean addHeader ) {
		
		panelForCustomLayout.setCellpadding("0");
		panelForCustomLayout.setCellspacing("0");
		panelForCustomLayout.setWidth("80%");

		if (addHeader)
		{
			HtmlOutputText label = getLabel("<br>");
			label.setEscape(false);
			panelForCustomLayout.getChildren().add(label);
			panelForCustomLayout.getChildren().add(super.getDummyLabel());
			
			label = getLabelWithBoundValue("DNS","title.masters");
			label.setEscape(false);
			label.setStyle("font-weight:bold");
			panelForCustomLayout.getChildren().add(label);
			panelForCustomLayout.getChildren().add(super.getDummyLabel());
		}
		

		
		
		HtmlInputText newAddressTextField = (HtmlInputText) ((LabeledJSFInputComponent) container.get_usr_NewMasterEntry()).getComponentPanel();
		newAddressTextField.setStyle(width);
		
		HtmlCommandButton addNewButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_AddNewMasterEntry()).getComponentPanel();
		addNewButton.setStyle(width);
		
		HtmlSelectManyListbox usedAddresses = (HtmlSelectManyListbox) ((LabeledJSFInputComponent) container.get_Masters()).getComponentPanel();
		usedAddresses.setStyle(width);
		
		HtmlCommandButton addPredefinedButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_AddPredefinedMaster()).getComponentPanel();
		addPredefinedButton.setStyle(width);
		
		HtmlCommandButton removeButton = (HtmlCommandButton) ((LabeledJSFInputComponent) container.get_usr_RemoveMasterEntry()).getComponentPanel();
		removeButton.setStyle(width);

		HtmlSelectManyListbox notUsedAddresses = (HtmlSelectManyListbox) ((LabeledJSFInputComponent) container.get_usr_PredefinedMasters()).getComponentPanel();
		notUsedAddresses.setStyle(width);
		
		//add one dummy row
		HtmlOutputText label = getLabel("<br>");
		label.setEscape(false);
		panelForCustomLayout.getChildren().add(label);
		panelForCustomLayout.getChildren().add(getDummyLabel());

		//row 1 (optional with Name of Masters)
		if (nameForMasters != null)
		{
			panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) nameForMasters).getLabelPanel());
			panelForCustomLayout.getChildren().add(getDummyLabel());
			panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) nameForMasters).getComponentPanel());
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

		inputGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_NewMasterEntry()).getLabelPanel());
		inputGrid.getChildren().add(newAddressTextField);
		inputGrid.getChildren().add(addNewButton);
		label = getLabel("<br>");
		label.setEscape(false);
		inputGrid.getChildren().add(label);
		inputGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_PredefinedMasters()).getLabelPanel());
		inputGrid.getChildren().add(notUsedAddresses);
		inputGrid.getChildren().add(addPredefinedButton);

		HtmlPanelGrid usedAddressesGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		usedAddressesGrid.setColumns(1);
		usedAddressesGrid.setCellpadding("0");
		usedAddressesGrid.setCellspacing("0");

		usedAddressesGrid.getChildren().add(((LabeledJSFInputComponent) container.get_Masters()).getLabelPanel());
		usedAddressesGrid.getChildren().add(usedAddresses);
		usedAddressesGrid.getChildren().add(removeButton);

		//add the grids to the outer grid
		panelForCustomLayout.getChildren().add(inputGrid);
		panelForCustomLayout.getChildren().add(usedAddressesGrid);

	}


}
