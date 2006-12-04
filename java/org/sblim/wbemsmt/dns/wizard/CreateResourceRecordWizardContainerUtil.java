 /** 
  * CreateResourceRecordWizardContainerUtil.java
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
  * Description: Wizard container util for creating a ResourceRecord
  * 
  */
package org.sblim.wbemsmt.dns.wizard;

import java.util.Map;

import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.tools.wizard.WizardContainerUtil;

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
}
