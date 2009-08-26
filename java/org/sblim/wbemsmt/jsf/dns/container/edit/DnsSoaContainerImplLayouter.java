 /** 
  * DnsSoaContainerImplLayouter.java
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
  * Description: lAYOUTER FOR SOA Record
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.jsf.dns.layouter.TTLLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsSoaContainerImplLayouter extends DnsLayouter {

	;

	public void layout(HtmlPanelGrid panelForCustomLayout, DnsSoaContainerImpl container, WbemSmtResourceBundle bundle) {

		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Server());
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Contact());

		LabeledJSFInputComponent serialNumber = ((LabeledJSFInputComponent) container.get_SerialNumber());
		LabeledJSFInputComponent serialNumberButton = ((LabeledJSFInputComponent) container.get_usr_SetSerialNumber());
		
		HtmlPanelGrid grid = createTable(2, "0", "0");
		grid.getChildren().add(serialNumber.getComponentPanel());
		grid.getChildren().add(serialNumberButton.getComponentPanel());
		
		panelForCustomLayout.getChildren().add(serialNumber.getLabelPanel());
		panelForCustomLayout.getChildren().add(grid);
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Refresh());
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Retry());
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Expire());
		
		new TTLLayouter().addTTL(panelForCustomLayout, container, DEFAULT_PANEL_WIDTH);
	}

}
