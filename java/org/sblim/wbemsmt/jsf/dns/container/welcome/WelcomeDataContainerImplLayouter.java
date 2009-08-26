 /** 
  * WelcomeDataContainerImplLayouter.java
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
  * Description: Layouter for welcome page
  * 
  */
package org.sblim.wbemsmt.jsf.dns.container.welcome;

import javax.faces.component.html.HtmlPanelGrid;

import org.sblim.wbemsmt.jsf.layout.JsfLayouter;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFInputComponent;
import org.sblim.wbemsmt.tools.input.jsf.LabeledJSFPictureComponent;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

/**
 * @author Bauschert
 *
 */
public class WelcomeDataContainerImplLayouter extends JsfLayouter {

	public void layout(HtmlPanelGrid panelForCustomLayout, WelcomeDataContainerImpl container, WbemSmtResourceBundle bundle) {
		LabeledJSFPictureComponent picture = (LabeledJSFPictureComponent) container.get_usr_DnsPicture();
		panelForCustomLayout.getChildren().add(picture.getComponentPanel());
		addComponent(panelForCustomLayout, (LabeledJSFInputComponent) container.get_usr_WelcomeText());
		LabeledJSFInputComponent actions = (LabeledJSFInputComponent) container.get_usr_Actions();
		LabeledJSFInputComponent createMz = (LabeledJSFInputComponent) container.get_usr_LinkCreateMasterzone();
		LabeledJSFInputComponent createFz = (LabeledJSFInputComponent) container.get_usr_LinkCreateForwardzone();
		LabeledJSFInputComponent createSz = (LabeledJSFInputComponent) container.get_usr_LinkCreateSlavezone();
		LabeledJSFInputComponent createMatchlist = (LabeledJSFInputComponent) container.get_usr_LinkCreateAddressmatchlist();
		LabeledJSFInputComponent createMasters = (LabeledJSFInputComponent) container.get_usr_LinkCreateMasters();

		addComponent(panelForCustomLayout, actions);
		panelForCustomLayout.getChildren().add(createMz.getComponentPanel());
		panelForCustomLayout.getChildren().add(createSz.getComponentPanel());
		panelForCustomLayout.getChildren().add(createFz.getComponentPanel());
		panelForCustomLayout.getChildren().add(createMatchlist.getComponentPanel());
		panelForCustomLayout.getChildren().add(createMasters.getComponentPanel());
		addComponent(panelForCustomLayout, (LabeledJSFInputComponent) container.get_usr_Memo());	}

}
