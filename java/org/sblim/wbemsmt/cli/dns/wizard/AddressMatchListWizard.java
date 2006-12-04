/** 
  * AddressMatchListWizard.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: ./tools-dcg/templates/cmd/wizardClass.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.wizard;

import java.util.*;
import java.util.logging.Logger;

import org.sblim.wbemsmt.bl.adapter.DataContainer;

import org.sblim.wbemsmt.tools.resources.ResourceBundleManager;
import org.sblim.wbemsmt.tools.wizard.adapter.IPageWizardAdapter;
import org.sblim.wbemsmt.tools.wizard.cli.*;
import org.sblim.wbemsmt.tools.wizard.container.IWizardContainer;
import org.sblim.wbemsmt.exception.WbemSmtException;

public class AddressMatchListWizard extends CliWizardBase implements IPageWizardAdapter {

	static Logger logger = Logger.getLogger(AddressMatchListWizard.class.getName());
	private org.sblim.wbemsmt.dns.wizard.AddressMatchListWizardContainer container = null;
	
	public AddressMatchListWizard(final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter) {
		super(adapter,ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},Locale.getDefault()));
		this.container = new org.sblim.wbemsmt.dns.wizard.AddressMatchListWizardContainer (new org.sblim.wbemsmt.dns.wizard.AddressMatchListWizardContainerPanels()
 			{
            					public Object getPage1()  throws WbemSmtException {
					DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsAddressMatchListWizardPage1DataContainerImpl(adapter);
					return dc;
				}
            					public Object getSummary()  throws WbemSmtException {
					DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsAddressMatchListWizardSummaryDataContainerImpl(adapter);
					return dc;
				}
            	 			});
		super.initialize();
 		try {
 			super.initWizard((IWizardContainer)container, this);
 		} catch (Exception ex) {
 			ex.printStackTrace();
 			return;
 		}
 		logger.fine("Wizard initialized");
	}
	
	public void cleanUPPage(String panelName) {
		//cleanup is done in the adapter
	}
	
	public IWizardContainer getWizardContainer()
	{
		return container;
	}
}