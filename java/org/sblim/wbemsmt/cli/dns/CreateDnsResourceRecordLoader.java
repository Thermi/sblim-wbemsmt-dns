 /** 
  * CreateDnsResourceRecordLoader.java
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
  * Description: Loader for creating a ResourceRecord
  * 
  */
package org.sblim.wbemsmt.cli.dns;

import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.cli.CimCommandValues;
import org.sblim.wbemsmt.tools.cli.CliUtil;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class CreateDnsResourceRecordLoader extends DnsDataLoader {

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.cli.CliDataLoader#load(org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle, org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter, org.apache.commons.cli.CommandLine)
	 */
	public void load(WbemSmtResourceBundle bundle,
			AbstractBaseCimAdapter adapter, CimCommandValues commandValues)
			throws WbemsmtException {

		this.commandValues = commandValues;
		String name = CliUtil.getOption(commandValues,CreateDnsResourceRecord.KEY_zoneName);
		selectZone(bundle, adapter, name, true);
	}

	
	public void loadTracingObject(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, DnsResourceRecordWizardSummaryDataContainer container) throws WbemsmtException {

		String zoneName = CliUtil.getOption(commandValues,CreateDnsResourceRecord.KEY_zoneName);
		String recordName = CliUtil.getOption(commandValues,CreateDnsResourceRecord.KEY_recordName);
		String recordValue = CliUtil.getOption(commandValues,CreateDnsResourceRecord.KEY_recordValue);
		String recordPrio = CliUtil.getOption(commandValues,CreateDnsResourceRecord.KEY_priority);
		String recordType = CliUtil.getOption(commandValues,CreateDnsResourceRecord.KEY_recordType);
		selectResourceRecord(bundle, adapter, zoneName,recordName, recordValue, recordPrio,recordType);
	
	}
}
