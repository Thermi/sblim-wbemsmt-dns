/** 
  * CreateResourceRecordWizard.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/cmd/wizardClass.vm
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

public class CreateResourceRecordWizard extends CliWizardBase implements IPageWizardAdapter {

	static Logger logger = Logger.getLogger(CreateResourceRecordWizard.class.getName());
	private org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainer container = null;
	
	public CreateResourceRecordWizard(final org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter adapter) {
		super(adapter,ResourceBundleManager.getResourceBundle(new String[]{"messages","messagesDns"},Locale.getDefault()));
		this.container = new org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainer (adapter, new org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainerPanels()
 			{
            					public Object getMain()  throws WbemSmtException {
					DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsResourceRecordWizardPage1DataContainerImpl(adapter);
					return dc;
				}
            					public Object getOverview()  throws WbemSmtException {
					DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.wizard.DnsResourceRecordWizardSummaryDataContainerImpl(adapter);
					return dc;
				}
            					public Object getTypeMx()  throws WbemSmtException {
					DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordWizardPage2TypeMxDataContainerImpl(adapter);
					return dc;
				}
            					public Object getTypeOther()  throws WbemSmtException {
					DataContainer dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsResourceRecordWizardPage2TypeOtherDataContainerImpl(adapter);
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