/** 
  * AddressMatchListWizardContainer.java
  *
  * 
  * Â© Copyright IBM Corp.  2009,2006,2007
  *
  * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: org.sblim.wbemsmt.dcg.generator.WizardGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/wizardContainer.vm
  *
  * Contributors: 
  *   Prashanth Karnam<prkarnam@in.ibm.com>
  * 
  * Description: WizardContainer for 
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
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.DataContainer;
	
	public class AddressMatchListWizardContainer extends AbstractWizardContainerBase implements IWizardContainer {

	org.sblim.wbemsmt.tools.wizard.WizardContainerUtil util = new AddressMatchListWizardContainerUtil();
	static Logger logger = Logger.getLogger(AddressMatchListWizardContainer.class.getName());
	
			public static final String WIZARD_PANEL_PAGE1 = "page1";
    		public static final String WIZARD_PANEL_SUMMARY = "summary";
    
	private final AddressMatchListWizardContainerPanels panels;
	
	public AddressMatchListWizardContainer(AbstractBaseCimAdapter adapter, AddressMatchListWizardContainerPanels panels) {
		super(adapter);
		this.panels = panels;
		hmPages = new HashMap<String, DataContainer>();
		stepList = new WizardStepList();
	}
	
	public void initWizardContainer() throws WbemsmtException {
		logger.fine("initWizardContainer");
		
    	    		hmPages.put(WIZARD_PANEL_PAGE1,panels.getPage1()); 
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
		if (pageName.equals(WIZARD_PANEL_PAGE1)) {
			return true;
		}
		else return false;
	}

	public void cleanUP(String pageName) 
	{
		//cleanup is done in the adapter
	}

	
	public boolean isValid(String propertyName, Object value, Vector<Object> result) {
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

	public Object getPage(String actualPanelName) throws WbemsmtException {

    				if (WIZARD_PANEL_PAGE1.equals(actualPanelName))
			{
				return panels.getPage1();
			}
        			if (WIZARD_PANEL_SUMMARY.equals(actualPanelName))
			{
				return panels.getSummary();
			}
        		
		throw new WbemsmtException(WbemsmtException.ERR_WIZARD_LOGIC,"For WizardPage " + actualPanelName + " no Implementation was found");
	}
	
}