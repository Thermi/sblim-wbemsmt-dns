 /** 
  * DnsHintZoneDataContainerImplLayouter.java
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
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_ZoneFile());
		new TTLLayouter().addTTL(panelForCustomLayout,container,DEFAULT_PANEL_WIDTH);
	}

}
