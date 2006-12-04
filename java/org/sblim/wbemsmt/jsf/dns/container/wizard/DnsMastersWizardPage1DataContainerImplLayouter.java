 /** 
  * DnsAddressMatchListWizardPage1DataContainerImplLayouter.java
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
  * Description: Layouter for page1 of the masters wizard
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.wizard;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsACLLayouter;
import org.sblim.wbemsmt.jsf.dns.layouter.MasterAddressesLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsMastersWizardPage1DataContainerImplLayouter extends
		DnsACLLayouter {

	;	
	
	public void layout(HtmlPanelGrid parent, DnsMastersWizardPage1DataContainerImpl container, WbemSmtResourceBundle bundle) {
		
		parent.setColumns(2);
		new MasterAddressesLayouter().addMasterAddress(parent, container, DEFAULT_PANEL_WIDTH,(LabeledJSFInputComponent) container.get_Name(), true);
		
	}
}
