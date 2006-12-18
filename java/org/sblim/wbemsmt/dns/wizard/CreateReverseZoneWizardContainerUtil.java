 /** 
  * CreateReverseZoneWizardContainerUtil.java
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
  * Description: Wizard container util for creating a ReverseZone
  * 
  */
package org.sblim.wbemsmt.dns.wizard;

import java.util.HashMap;
import java.util.Map;

import org.sblim.wbemsmt.tools.wizard.WizardContainerUtil;
import org.sblim.wbemsmt.tools.wizard.WizardStepList;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;

public class CreateReverseZoneWizardContainerUtil extends WizardContainerUtil {


	static final String[] panelNames = new String[]{
		CreateReverseZoneWizardContainer.WIZARD_PANEL_MAIN,
		CreateReverseZoneWizardContainer.WIZARD_PANEL_SUMMARY
	};	
	
	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.wizard.WizardContainerUtil#getNextPanel(java.lang.String, java.util.Map)
	 */
	public String getNextPanel(String currentPageName, Map hmPages) {
		return super.getNextPanelDefault(currentPageName,panelNames);		
	}
	
	public void addInitialWizardSteps(IWizardContainer wizardContainer, WizardStepList stepList, HashMap hmPages) {
		super.addInitialWizardStepsDefault(wizardContainer, stepList, panelNames);
	}
	
}
