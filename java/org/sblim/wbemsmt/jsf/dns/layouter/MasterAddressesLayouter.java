 /** 
  * MasterAddressesLayouter.java
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
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: Layouter for Masters
  * 
  */
package org.sblim.wbemsmt.jsf.dns.layouter;

import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

public class MasterAddressesLayouter extends DnsLayouter {

	public void addMasterAddress(HtmlPanelGrid panelForCustomLayout, DnsAddMasterAddressDataContainer container, String width, LabeledJSFInputComponent nameForMasters, boolean addHeader ) {
		
		
		//overwrite the width
		width = "width:150px";
		
		HtmlPanelGrid  outerTable = panelForCustomLayout;
		int cols = panelForCustomLayout.getColumns();
		
		panelForCustomLayout  = createTable(2, "0", "0");
		
		panelForCustomLayout.setCellpadding("0");
		panelForCustomLayout.setCellspacing("0");
		panelForCustomLayout.setWidth("20%");
		panelForCustomLayout.setColumnClasses("topAlignment,topAlignment");

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
		

		
		
		LabeledJSFInputComponent newAddressTextField = (LabeledJSFInputComponent) container.get_usr_NewMasterEntry();
		newAddressTextField.addStyleSheetElement(width);
		
		LabeledJSFInputComponent addNewButton = (LabeledJSFInputComponent) container.get_usr_AddNewMasterEntry();
		addNewButton.addStyleSheetElement(width);
		
		LabeledJSFInputComponent usedAddresses = (LabeledJSFInputComponent) container.get_Masters();
		usedAddresses.addStyleSheetElement(width);
		
		LabeledJSFInputComponent addPredefinedButton = (LabeledJSFInputComponent) container.get_usr_AddPredefinedMaster();
		addPredefinedButton.addStyleSheetElement(width);
		
		LabeledJSFInputComponent removeButton = (LabeledJSFInputComponent) container.get_usr_RemoveMasterEntry();
		removeButton.addStyleSheetElement(width);

		LabeledJSFInputComponent notUsedAddresses = (LabeledJSFInputComponent) container.get_usr_PredefinedMasters();
		notUsedAddresses.addStyleSheetElement(width);
		
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
		inputGrid.getChildren().add(newAddressTextField.getComponentPanel());
		inputGrid.getChildren().add(addNewButton.getComponentPanel());
		label = getLabel("<br>");
		label.setEscape(false);
		inputGrid.getChildren().add(label);
		inputGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_PredefinedMasters()).getLabelPanel());
		inputGrid.getChildren().add(notUsedAddresses.getComponentPanel());
		inputGrid.getChildren().add(addPredefinedButton.getComponentPanel());

		HtmlPanelGrid usedAddressesGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		usedAddressesGrid.setColumns(1);
		usedAddressesGrid.setCellpadding("0");
		usedAddressesGrid.setCellspacing("0");

		usedAddressesGrid.getChildren().add(((LabeledJSFInputComponent) container.get_Masters()).getLabelPanel());
		usedAddressesGrid.getChildren().add(usedAddresses.getComponentPanel());
		usedAddressesGrid.getChildren().add(removeButton.getComponentPanel());

		//add the grids to the outer grid
		panelForCustomLayout.getChildren().add(inputGrid);
		panelForCustomLayout.getChildren().add(usedAddressesGrid);

		//we created a new Table - add the old table
		//and add some dummy columns if there is more than one column
		outerTable.getChildren().add(panelForCustomLayout);
		for (int i=0; i < cols-1; i++)
		{
			outerTable.getChildren().add(create(HtmlOutputLabel.COMPONENT_TYPE));
		}
		


	}


}
