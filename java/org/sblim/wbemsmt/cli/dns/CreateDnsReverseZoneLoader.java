 /** 
  * CreateDnsReverseZoneLoader.java
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
  * Description: Loader for creating a ReverseZone
  * 
  */
package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.CommandLine;
import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.exception.ObjectNotFoundException;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class CreateDnsReverseZoneLoader extends DnsDataLoader {

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.cli.CliDataLoader#load(org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle, org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter, org.apache.commons.cli.CommandLine)
	 */
	public void load(WbemSmtResourceBundle bundle,
			AbstractBaseCimAdapter adapter, CommandLine cmd)
			throws ObjectNotFoundException {
		this.cmd = cmd;
		
		String zoneName = cmd.getOptionValue(CreateDnsReverseZone.KEY_zoneNameToReverse.getLongKey());
		selectZone(bundle,adapter,zoneName, false);
	}

	
	public void loadTracingObject(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, DnsReverseZoneWizardSummaryDataContainer container) throws ObjectNotFoundException {
		selectReverseZone(bundle,adapter,(String) container.get_usr_Name().getConvertedControlValue());
	}
}
