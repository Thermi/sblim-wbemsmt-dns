 /** 
  * CreateResourceRecordWizardContainerUtil.java
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
  * Description: Wizard container util for creating a ResourceRecord
  * 
  */
package org.sblim.wbemsmt.dns.wizard;

import java.util.HashMap;
import java.util.Map;

import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.tools.wizard.WizardContainerUtil;
import org.sblim.wbemsmt.tools.wizard.WizardStep;
import org.sblim.wbemsmt.tools.wizard.WizardStepList;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;

public class CreateResourceRecordWizardContainerUtil extends
		WizardContainerUtil {

	static final String[] panelNames = new String[]{
		CreateResourceRecordWizardContainer.WIZARD_PANEL_MAIN,
		CreateResourceRecordWizardContainer.WIZARD_PANEL_OVERVIEW
	};

	/**
	 * 
	 */
	public CreateResourceRecordWizardContainerUtil() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.wizard.WizardContainerUtil#getNextPanel(java.lang.String, java.util.Map)
	 */
	public String getNextPanel(String currentPageName, Map hmPages) {
		
		if (currentPageName.equals(CreateResourceRecordWizardContainer.WIZARD_PANEL_MAIN))
		{
			DnsResourceRecordWizardPage1DataContainer page1 = (DnsResourceRecordWizardPage1DataContainer) hmPages.get(currentPageName);
		
			//Check if the user selected MX as record type
			if (ResourceRecord.TYPE_MX.equals(ResourceRecord.getTypeOfIndex((UnsignedInt16) page1.get_usr_Type().getConvertedControlValue())))
			{
				return CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEMX;
			}
			else
			{
				return CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEOTHER;
			}
		} else if (currentPageName.equals(CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEMX)
				|| currentPageName.equals(CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEOTHER)
				|| currentPageName.equals(CreateResourceRecordWizardContainer.WIZARD_PANEL_OVERVIEW)
		)
		{
			return CreateResourceRecordWizardContainer.WIZARD_PANEL_OVERVIEW;
		}
		
		return super.getNextPanelDefault(currentPageName,panelNames);
	}
	
	public void addInitialWizardSteps(IWizardContainer wizardContainer, WizardStepList stepList, HashMap hmPages) {

		stepList.addWizardStep(new WizardStep(wizardContainer, CreateResourceRecordWizardContainer.WIZARD_PANEL_MAIN));
		//add a step which is just for grouping the following two
		stepList.addWizardStep(new WizardStep(wizardContainer, "type",wizardContainer.getAdapter(),"recordWizard.step.recordType"));
		//add two steps at level 2
		stepList.addWizardStep(new WizardStep(wizardContainer, 2,CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEMX));
		stepList.addWizardStep(new WizardStep(wizardContainer, 2,CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEOTHER));
		stepList.addWizardStep(new WizardStep(wizardContainer, CreateResourceRecordWizardContainer.WIZARD_PANEL_OVERVIEW));

	}

	public void updateWizardStepList(String newPageName, WizardStepList stepList) {
		if (CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEMX.equals(newPageName))
		{
			stepList.getWizardStep(CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEOTHER).setVisited(false);
		}
		else if (CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEOTHER.equals(newPageName))
		{
			stepList.getWizardStep(CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEMX).setVisited(false);
		}
	}
	
	
	
}
