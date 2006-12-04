 /** 
  * DnsResourceRecordListContainerImplLayouter.java
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
  * Description: Layouter for ResourceRecords-List
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.jsf.MultiLineBasePanel;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsResourceRecordListContainerImplLayouter extends DnsLayouter {

	public void layout(HtmlPanelGrid parent, DnsResourceRecordListContainerImpl container, WbemSmtResourceBundle bundle) {
		
		parent.setColumns(1);
		
		if (container.getResourceRecords().size() > 0)
		{
			HtmlPanelGrid recordGrid = ((MultiLineBasePanel)container.getResourceRecords().get(0)).getInputFieldContainer();
			parent.getChildren().add(recordGrid);
			
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			addComponent(recordGrid, (LabeledJSFInputComponent) container.get_usr_SelectAll());
			
			HtmlPanelGrid buttonGrid = super.createTable(2,"0","0");
			buttonGrid.setColumnClasses("fill100,fill0");
			buttonGrid.getChildren().add(getDummyLabel());
			buttonGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_Delete()).getComponent());
			parent.getChildren().add(buttonGrid);
		}
		else
		{
			parent.getChildren().add(super.getLabelWithBoundValue("DNS", "no.resource.records.found"));
		}
		
	}

}
