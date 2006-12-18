 /** 
  * DnsHintZoneDataContainerImplLayouter.java
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
  * Description: layouter for a hint zone
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.jsf.dns.layouter.TTLLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsHintZoneDataContainerImplLayouter extends DnsLayouter {

	;	
	
	public void layout(HtmlPanelGrid panelForCustomLayout, DnsHintZoneDataContainerImpl container, WbemSmtResourceBundle bundle) {
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_Name());
		new TTLLayouter().addTTL(panelForCustomLayout,container,DEFAULT_PANEL_WIDTH);
	}

}
