 /** 
  * DnsStubZoneWizardPage1DataContainerImplLayouter.java
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
  * Description: Layouter for Stub zone wizard page 1
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.wizard;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.jsf.dns.layouter.MasterAddressesLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsStubZoneWizardPage1DataContainerImplLayouter extends DnsLayouter {
	
	public void layout(HtmlPanelGrid panelForCustomLayout, DnsStubZoneWizardPage1DataContainerImpl container, WbemSmtResourceBundle bundle) {
		
		//panelForCustomLayout.setColumns(2);
		
		addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_usr_Name());
		new MasterAddressesLayouter().addMasterAddress(panelForCustomLayout,container,DEFAULT_PANEL_WIDTH,null, true);
		//addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_PortForMaster());
		//addComponent(panelForCustomLayout,(LabeledJSFInputComponent) container.get_SecurityKeyForMaster());
		
		
	}

}
