 /** 
  * DnsAllowNotifyACLForZoneDataContainerImplLayouter.java
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
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer;
import org.sblim.wbemsmt.jsf.dns.layouter.DnsACLLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;


public class DnsAllowQueryForZoneDataContainerImplLayouter extends
		DnsACLLayouter {

	public void layout(HtmlPanelGrid panelForCustomLayout, DnsAllowQueryForZoneDataContainer container, WbemSmtResourceBundle bundle) {
		super.layout(panelForCustomLayout, container, bundle, (LabeledJSFInputComponent) container.get_usr_UseGlobalAddressMatchList());
	}
	

}
