 /** 
  * TTLLayouter.java
  *
  * © Copyright IBM Corp. 2005
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
  * Description: layouter for TTL 
  * 
  */
package org.sblim.wbemsmt.jsf.dns.layouter;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;

public class TTLLayouter extends DnsLayouter {

	public void addTTL(HtmlPanelGrid parent, DnsTTLDataContainer container, String width) {
		
		LabeledBaseInputComponentIf get_TTL = container.get_TTL();
		LabeledStringArrayInputComponentIf get_usr_TTLUnit = container.get_usr_TTLUnit();

		HtmlOutputText label = getLabel("<br>");
		label.setEscape(false);
		parent.getChildren().add(label);
		parent.getChildren().add(super.getDummyLabel());

		label = getLabelWithBoundValue("DNS","title.ttl");
		label.setStyle("font-weight:bold");
		label.setEscape(false);
		parent.getChildren().add(label);
		parent.getChildren().add(super.getDummyLabel());

		
		addTTL(parent, get_TTL, get_usr_TTLUnit,container.get_usr_RemoveTTL());
		
	}

	public void addTTL(HtmlPanelGrid parent, DnsSoaContainer container, String width) {
		
		LabeledBaseInputComponentIf get_TTL = container.get_NegativeCachingTTL();
		LabeledStringArrayInputComponentIf get_usr_TTLUnit = container.get_usr_TTLUnit();
		addTTL(parent, get_TTL, get_usr_TTLUnit,null);
		
	}

	private void addTTL(HtmlPanelGrid parent, LabeledBaseInputComponentIf get_TTL, LabeledStringArrayInputComponentIf get_usr_TTLUnit, LabeledBaseInputComponentIf removeTTL ) {
		
		
		
		HtmlPanelGrid compGrid = (HtmlPanelGrid) createTable(removeTTL == null ? 2 : 3, "0", "0");
		
		compGrid.getChildren().add(((LabeledJSFInputComponent)get_TTL).getComponentPanel());
		compGrid.getChildren().add(((LabeledJSFInputComponent)get_usr_TTLUnit).getComponentPanel());
		if (removeTTL != null)
		{
			compGrid.getChildren().add(((LabeledJSFInputComponent)removeTTL).getComponentPanel());
		}
		
		parent.getChildren().add(((LabeledJSFInputComponent)get_TTL).getLabelPanel());
		parent.getChildren().add(compGrid);
	}

}
