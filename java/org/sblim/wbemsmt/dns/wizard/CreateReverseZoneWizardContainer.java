/** 
  * CreateReverseZoneWizardContainer.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.WizardGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/wizardContainer.vm
  *
  * Contributors: 
  * 
  * Description: WizardContainer for Wizard for ReverseZones
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.wizard;

import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Logger;

import org.sblim.wbemsmt.tools.wizard.WizardStepList;
import org.sblim.wbemsmt.tools.wizard.container.AbstractWizardContainerBase;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
	
	public class CreateReverseZoneWizardContainer extends AbstractWizardContainerBase implements IWizardContainer {

	org.sblim.wbemsmt.tools.wizard.WizardContainerUtil util = new CreateReverseZoneWizardContainerUtil();
	static Logger logger = Logger.getLogger(CreateReverseZoneWizardContainer.class.getName());
	
			public static final String WIZARD_PANEL_MAIN = "main";
    		public static final String WIZARD_PANEL_SUMMARY = "summary";
    
	private final CreateReverseZoneWizardContainerPanels panels;
	
	public CreateReverseZoneWizardContainer(AbstractBaseCimAdapter adapter, CreateReverseZoneWizardContainerPanels panels) {
		super(adapter);
		this.panels = panels;
		hmPages = new HashMap();
		stepList = new WizardStepList();
	}
	
	public void initWizardContainer() throws WbemSmtException {
		logger.fine("initWizardContainer");
		
    	    		hmPages.put(WIZARD_PANEL_MAIN,panels.getMain()); 
            		hmPages.put(WIZARD_PANEL_SUMMARY,panels.getSummary()); 
        		util.addInitialWizardSteps(this,stepList,hmPages);
	}
	
	public String getNextWizardPageName()
	{
		String nextPanelName = util.getNextPanel(getCurrentPageName(),hmPages);
		util.updateWizardStepList(nextPanelName,stepList);
		return nextPanelName;
	}
	
	public boolean isLast(String pageName) {
    			if (pageName.equals(WIZARD_PANEL_SUMMARY)) {
			return true;
		}
        		else return false;
	}

	public boolean isFirst(String pageName) {
		if (pageName.equals(WIZARD_PANEL_MAIN)) {
			return true;
		}
		else return false;
	}

	public void cleanUP(String pageName) 
	{
		//cleanup is done in the adapter
	}

	
	public boolean isValid(String propertyName, Object value, Vector result) {
		//validation is done in the adapter
		return true;
	}

	protected void buildSummaryText() {
		//wizard has no summary - fields are updated in the adapter
	}
	
	public void postWizardFinish() {
	
	}

	public void preWizardFinish() throws Exception {
		
	}

	public Object getPage(String actualPanelName) throws WbemSmtException {

    				if (WIZARD_PANEL_MAIN.equals(actualPanelName))
			{
				return panels.getMain();
			}
        			if (WIZARD_PANEL_SUMMARY.equals(actualPanelName))
			{
				return panels.getSummary();
			}
        		
		throw new WbemSmtException("For WizardPage " + actualPanelName + " no Implementation was found");
	}
	
}