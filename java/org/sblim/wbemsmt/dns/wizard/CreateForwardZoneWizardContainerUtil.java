 /** 
  * CreateForwardZoneWizardContainerUtil.java
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
  * Description: Wizard container util for creating a ForwardZone
  * 
  */
package org.sblim.wbemsmt.dns.wizard;

import java.util.Map;

import org.sblim.wbemsmt.tools.wizard.WizardContainerUtil;

public class CreateForwardZoneWizardContainerUtil extends WizardContainerUtil {

	static final String[] panelNames = new String[]{
		CreateForwardZoneWizardContainer.WIZARD_PANEL_MAIN,
		CreateForwardZoneWizardContainer.WIZARD_PANEL_OVERVIEW
	};

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.wizard.WizardContainerUtil#getNextPanel(java.lang.String, java.util.Map)
	 */
	public String getNextPanel(String currentPageName, Map hmPages) {
		return super.getNextPanelDefault(currentPageName,panelNames);
	}

}
