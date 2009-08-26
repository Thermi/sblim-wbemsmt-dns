 /** 
  * DnsAddressMatchListWizardPage1DataContainerImplLayouter.java
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
  * Description: Layouter for DNS AddressMAtchLists
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.wizard;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsACLLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsAddressMatchListWizardPage1DataContainerImplLayouter extends
		DnsACLLayouter {

	public void layout(HtmlPanelGrid panelForCustomLayout, DnsAddressMatchListWizardPage1DataContainerImpl container, WbemSmtResourceBundle bundle) {
		super.layoutImpl(panelForCustomLayout,container,(LabeledJSFInputComponent)container.get_Name(),bundle,null);
	}
}
