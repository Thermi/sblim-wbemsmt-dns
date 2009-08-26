 /** 
  * DnsConfigurationDataContainerImplLayouter.java
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
  * Description: layouter for DNS Configuration Panel
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.edit;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.dns.layouter.DnsLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DnsConfigurationDataContainerImplLayouter extends DnsLayouter {

	//;	
	
	public void layout(HtmlPanelGrid parent, DnsConfigurationDataContainerImpl container, WbemSmtResourceBundle bundle) {
		
		addComponent(parent, (LabeledJSFInputComponent) container.get_ConfigurationFile());
		
		
		LabeledJSFInputComponent directory = ((LabeledJSFInputComponent) container.get_ConfigurationDirectory());
		LabeledJSFInputComponent directoryButton = ((LabeledJSFInputComponent) container.get_usr_RemoveDirectory());

		HtmlPanelGrid directoryGrid = createTable(2, "0", "0");
		directoryGrid.getChildren().add(directory.getComponentPanel());
		directoryGrid.getChildren().add(directoryButton.getComponentPanel());
		
		
		parent.getChildren().add(directory.getLabelPanel());
		parent.getChildren().add(directoryGrid);
		
		
		addComponent(parent, (LabeledJSFInputComponent) container.get_PortNumber());
		
	}

}
