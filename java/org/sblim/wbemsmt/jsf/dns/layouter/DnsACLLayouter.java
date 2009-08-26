 /** 
  * DnsACLLayouter.java
  *
  * © Copyright IBM Corp.  2009,2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: Layouter for DNS ACLs
  * 
  */
package org.sblim.wbemsmt.jsf.dns.layouter;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsACLLayouter extends DnsLayouter{

	String widthButtons = "width:200px";
	
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

		HtmlPanelGrid grid = createTable(2, "0", "5");
		panelForCustomLayout.getChildren().add(grid);
		
		grid.setColumns(2);
		grid.setCellpadding("0");
		grid.setCellspacing("0");
		grid.setWidth("80%");
		grid.setColumnClasses("topAlignment,topAlignment");
		
			LabeledJSFInputComponent newAddressTextField = (LabeledJSFInputComponent) container.get_usr_NewAddress();
		newAddressTextField.addStyleSheetElement(widthButtons);
		
		LabeledJSFInputComponent addNewButton = (LabeledJSFInputComponent) container.get_usr_AddNewAddress();
		addNewButton.addStyleSheetElement(widthButtons);
		
		LabeledJSFInputComponent usedAddresses = (LabeledJSFInputComponent) container.get_AddressList();
		usedAddresses.addStyleSheetElement(widthButtons);
		
		LabeledJSFInputComponent addPredefinedButton = (LabeledJSFInputComponent) container.get_usr_AddPredefinedAddress();
		addPredefinedButton.addStyleSheetElement(widthButtons);
		
		LabeledJSFInputComponent removeButton = (LabeledJSFInputComponent) container.get_usr_RemoveAddress();
		removeButton.addStyleSheetElement(widthButtons);

		LabeledJSFInputComponent upButton = (LabeledJSFInputComponent) container.get_usr_AddressUp();
		upButton.addStyleSheetElement("width:60px");

		LabeledJSFInputComponent downButton = (LabeledJSFInputComponent) container.get_usr_AddressDown();
		downButton.addStyleSheetElement("width:60px");

		LabeledJSFInputComponent notUsedAddresses = (LabeledJSFInputComponent) container.get_usr_UserAddresses();
		notUsedAddresses.addStyleSheetElement(widthButtons);

		//add one dummy row
		HtmlOutputText label = getLabel("<br>");
		label.setEscape(false);
		grid.getChildren().add(label);
		grid.getChildren().add(getDummyLabel());

		//row 1 (optional with Name of AddressList
		if (name != null)
		{
			grid.getChildren().add(((LabeledJSFInputComponent) name).getLabelPanel());
			grid.getChildren().add(getDummyLabel());
			grid.getChildren().add(((LabeledJSFInputComponent) name).getComponentPanel());
			grid.getChildren().add(getDummyLabel());
			label = getLabel("<br>");
			label.setEscape(false);
			grid.getChildren().add(label);
			grid.getChildren().add(getDummyLabel());
		}

		HtmlPanelGrid inputGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		inputGrid.setCellpadding("0");
		inputGrid.setCellspacing("0");
		inputGrid.setColumns(1);

		inputGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_NewAddress()).getLabelPanel());
		inputGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_NewAddress()).getComponentPanel());
		inputGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_AddNewAddress()).getComponentPanel());
		label = getLabel("<br>");
		label.setEscape(false);
		inputGrid.getChildren().add(label);
		inputGrid.getChildren().add(((LabeledJSFInputComponent) container.get_usr_UserAddresses()).getLabelPanel());
		inputGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_UserAddresses()).getComponentPanel());
		inputGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_AddPredefinedAddress()).getComponentPanel());

		HtmlPanelGrid upDownGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		upDownGrid.setColumns(1);
		upDownGrid.setCellpadding("0");
		upDownGrid.setCellspacing("0");
		upDownGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_AddressUp()).getComponentPanel());
		upDownGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_AddressDown()).getComponentPanel());

		
		HtmlPanelGrid usedAddressesGrid = (HtmlPanelGrid) super.create(HtmlPanelGrid.COMPONENT_TYPE);
		usedAddressesGrid.setColumns(2);
		usedAddressesGrid.setCellpadding("0");
		usedAddressesGrid.setCellspacing("0");
		usedAddressesGrid.setColumnClasses("topAlignment,topAlignment");
		
		usedAddressesGrid.getChildren().add(((LabeledJSFInputComponent) container.get_AddressList()).getLabelPanel());
		usedAddressesGrid.getChildren().add(getDummyLabel());
		
		usedAddressesGrid.getChildren().add(((LabeledJSFInputComponent)container.get_AddressList()).getComponentPanel());
		usedAddressesGrid.getChildren().add(upDownGrid);
		
		usedAddressesGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_RemoveAddress()).getComponentPanel());
		usedAddressesGrid.getChildren().add(getDummyLabel());

		//add the grids to the outer grid
		grid.getChildren().add(inputGrid);
		grid.getChildren().add(usedAddressesGrid);
		
		
		if (useGlobal != null)
		{
			useGlobal.addStyleSheetElement(widthButtons);
			
			label = getLabel("<br>");
			label.setEscape(false);			
			grid.getChildren().add(label);
			grid.getChildren().add(getDummyLabel());
			grid.getChildren().add(useGlobal.getComponentPanel());
			grid.getChildren().add(getDummyLabel());
		}		
		
		
		
		
	}
	
}
