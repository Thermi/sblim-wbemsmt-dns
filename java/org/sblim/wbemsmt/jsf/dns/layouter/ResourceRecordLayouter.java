 /** 
  * MasterAddressesLayouter.java
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
  * Description: Layouter for ResourceRecords
  * 
  */
package org.sblim.wbemsmt.jsf.dns.layouter;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

public class ResourceRecordLayouter extends DnsLayouter {

	public void addResourceRecords(HtmlPanelGrid panelForCustomLayout, DnsReverseZoneWizardPage1DataContainer container, String width) {


		
		HtmlOutputText label = getLabel("<br>");
		label.setEscape(false);
		panelForCustomLayout.getChildren().add(label);
		panelForCustomLayout.getChildren().add(super.getDummyLabel());

		label = getLabelWithBoundValue("DNS","title.resourceRecords");
		label.setEscape(false);
		label.setStyle("font-weight:bold");
		panelForCustomLayout.getChildren().add(label);
		panelForCustomLayout.getChildren().add(super.getDummyLabel());

		//labels for Records
		panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) container.get_usr_ResourceRecordNotUsed()).getLabelPanel());
		panelForCustomLayout.getChildren().add(((LabeledJSFInputComponent) container.get_usr_ResourceRecordUsed()).getLabelPanel());
		
		//fields for Records
		LabeledJSFInputComponent addButton = (LabeledJSFInputComponent) container.get_usr_AddResourceRecord();
		LabeledJSFInputComponent addAllButton = (LabeledJSFInputComponent) container.get_usr_AddAllResourceRecords();
		LabeledJSFInputComponent removeButton = (LabeledJSFInputComponent) container.get_usr_RemoveResourceRecord();
		LabeledJSFInputComponent removeAllButton = (LabeledJSFInputComponent) container.get_usr_RemoveAllResourceRecords();

		addButton.addStyleSheetElement(width);
		addAllButton.addStyleSheetElement(width);
		removeButton.addStyleSheetElement(width);
		removeAllButton.addStyleSheetElement(width);

		
		LabeledJSFInputComponent notUsedRecords = (LabeledJSFInputComponent) container.get_usr_ResourceRecordNotUsed();
		LabeledJSFInputComponent usedRecords = (LabeledJSFInputComponent) container.get_usr_ResourceRecordUsed();

		notUsedRecords.addStyleSheetElement(width);
		usedRecords.addStyleSheetElement(width);

		panelForCustomLayout.getChildren().add(notUsedRecords.getComponentPanel());
		panelForCustomLayout.getChildren().add(usedRecords.getComponentPanel());

		panelForCustomLayout.getChildren().add(addButton.getComponentPanel());
		panelForCustomLayout.getChildren().add(removeButton.getComponentPanel());
	
		panelForCustomLayout.getChildren().add(addAllButton.getComponentPanel());
		panelForCustomLayout.getChildren().add(removeAllButton.getComponentPanel());
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
