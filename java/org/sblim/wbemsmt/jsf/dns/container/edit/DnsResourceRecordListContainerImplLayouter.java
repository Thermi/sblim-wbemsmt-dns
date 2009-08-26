 /** 
  * DnsResourceRecordListContainerImplLayouter.java
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
  * Description: Layouter for ResourceRecords-List
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlPanelGroup;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsResourceRecordListContainerImplLayouter extends DnsLayouter {

	public void layout(HtmlPanelGrid parent, DnsResourceRecordListContainerImpl container, WbemSmtResourceBundle bundle) {
		
		HtmlPanelGroup recordsPanel = container.getResourceRecordsPanel().getCustomFooter();

		HtmlOutputText label = getLabel("<br>");
		label.setEscape(false);
		HtmlPanelGrid grid = createTable(1, "0", "0");

		addComponent(grid, (LabeledJSFInputComponent) container.get_usr_SelectAll());
		grid.getChildren().add(label);
		grid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_Delete()).getComponentPanel());
		
		recordsPanel.getChildren().add(grid);
	}

}
