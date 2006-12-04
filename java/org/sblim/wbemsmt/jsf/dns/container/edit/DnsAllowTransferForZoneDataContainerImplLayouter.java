 /** 
  * DnsAllowNotifyACLForZoneDataContainerImplLayouter.java
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
  * Description: Layouter for DNS AddressMAtchLists
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer;
import org.sblim.wbemsmt.jsf.dns.layouter.DnsACLLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;


public class DnsAllowTransferForZoneDataContainerImplLayouter extends
		DnsACLLayouter {


	public void layout(HtmlPanelGrid panelForCustomLayout, DnsAllowTransferForZoneDataContainer container, WbemSmtResourceBundle bundle) {
		super.layout(panelForCustomLayout, container, bundle, (LabeledJSFInputComponent) container.get_usr_UseGlobalAddressMatchList());
	}
	
}
