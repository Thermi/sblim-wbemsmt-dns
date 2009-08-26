 /** 
  * DnsForwardersForServiceDataContainerImplLayouter.java
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
  * Description: layouter for global forwarders
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.jsf.dns.layouter.ForwarderLayouter;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsForwardersForServiceDataContainerImplLayouter extends DnsLayouter {

	;	
	
	public void layout(HtmlPanelGrid panelForCustomLayout, DnsForwardersForServiceDataContainerImpl container, WbemSmtResourceBundle bundle) {
		new ForwarderLayouter().addForwarder(panelForCustomLayout,container,DEFAULT_PANEL_WIDTH, false, null);
	}

}
