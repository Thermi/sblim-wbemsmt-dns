 /** 
  * CreateForwardZoneWizardContainerUtil.java
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
  * Description: Wizard container util for creating a ForwardZone
  * 
  */
package org.sblim.wbemsmt.dns.wizard;

import java.util.HashMap;
import java.util.Map;

import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.tools.wizard.WizardContainerUtil;
import org.sblim.wbemsmt.tools.wizard.WizardStepList;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;

public class CreateForwardZoneWizardContainerUtil extends WizardContainerUtil {

	static final String[] panelNames = new String[]{
		CreateForwardZoneWizardContainer.WIZARD_PANEL_MAIN,
		CreateForwardZoneWizardContainer.WIZARD_PANEL_OVERVIEW
	};

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.wizard.WizardContainerUtil#getNextPanel(java.lang.String, java.util.Map)
	 */
	public String getNextPanel(String currentPageName, Map<String, DataContainer> hmPages) {
		return super.getNextPanelDefault(currentPageName,panelNames);
	}

	public void addInitialWizardSteps(IWizardContainer wizardContainer, WizardStepList stepList, HashMap<String, DataContainer> hmPages) {
		super.addInitialWizardStepsDefault(wizardContainer, stepList, panelNames);
	}
	
}
