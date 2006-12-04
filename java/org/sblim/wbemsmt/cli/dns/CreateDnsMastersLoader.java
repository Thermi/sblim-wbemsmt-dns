 /** 
  * CreateDnsMastersLoader.java
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
  * Description: Loader for creating a Masters
  * 
  */
package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.CommandLine;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer;
import org.sblim.wbemsmt.exception.ObjectNotFoundException;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class CreateDnsMastersLoader extends DnsDataLoader {

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.cli.CliDataLoader#load(org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle, org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter, org.apache.commons.cli.CommandLine)
	 */
	public void load(WbemSmtResourceBundle bundle,
			AbstractBaseCimAdapter adapter, CommandLine cmd)
			throws ObjectNotFoundException {
				this.cmd = cmd;
		// do nothing
	}

	
	public void loadTracingObject(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, DnsMastersWizardSummaryDataContainer container) throws ObjectNotFoundException {

		String name = (String) container.get_Name().getConvertedControlValue();
		selectMasters(bundle, adapter, name);
	
	}


}
