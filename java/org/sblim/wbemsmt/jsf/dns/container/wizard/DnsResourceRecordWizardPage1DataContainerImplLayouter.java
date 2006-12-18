 /** 
  * DnsResourceRecordWizardPage1DataContainerImplLayouter.java
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
  * Description: Layouter for DNS Resource record wizard (first page)
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.wizard;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsResourceRecordWizardPage1DataContainerImplLayouter extends
		DnsLayouter {

	public void layout(HtmlPanelGrid parent, DnsResourceRecordWizardPage1DataContainerImpl panel1, WbemSmtResourceBundle bundle) {
		
		//parent.setColumns(2);
		
		addComponent(parent, (LabeledJSFInputComponent) panel1.get_usr_Name());
		addComponent(parent, (LabeledJSFInputComponent) panel1.get_usr_Type());
		
	}

}
