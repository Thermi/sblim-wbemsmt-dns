 /** 

  * DnsReverseZoneWizardPage1DataContainerImplLayouter.java
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
  * Description: Layouter for reverse zone wizard
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.wizard;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.ResourceRecordLayouter;
import org.sblim.wbemsmt.jsf.layout.JsfLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsReverseZoneWizardPage1DataContainerImplLayouter extends
		JsfLayouter {

	private static final String WIDTH = "width:200px";

	public void layout(HtmlPanelGrid parent, DnsReverseZoneWizardPage1DataContainerImpl container, WbemSmtResourceBundle bundle) {
		
		parent.setColumns(2);
		
		addComponent(parent, (LabeledJSFInputComponent) container.get_usr_IpPresets());
		addComponent(parent, (LabeledJSFInputComponent) container.get_usr_IpAddress());
		
		new ResourceRecordLayouter().addResourceRecords(parent, container, WIDTH);
	}

}
