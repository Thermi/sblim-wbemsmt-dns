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
		
		if (container.getResourceRecords().size() > 0)
		{
			MultiLineBasePanel multiLineBasePanel = ((MultiLineBasePanel)container.getResourceRecords().get(0));
			HtmlPanelGrid recordGrid = multiLineBasePanel.getInputFieldContainer();
			//parent.getChildren().add(recordGrid);
			
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			addComponent(recordGrid, (LabeledJSFInputComponent) container.get_usr_SelectAll());
			
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(getDummyLabel());
			recordGrid.getChildren().add(((LabeledJSFInputComponent)container.get_usr_Delete()).getComponentPanel());
			
			multiLineBasePanel.updateRows(2);
		}
		else
		{
			parent.getChildren().add(super.getLabelWithBoundValue("DNS", "no.resource.records.found"));
		}
		
	}

}
