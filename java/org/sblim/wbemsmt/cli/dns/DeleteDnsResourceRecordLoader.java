 /** 
  * DeleteDnsResourceRecordLoader.java
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
  * Description: Loader for creating a ResourceRecord
  * 
  */
package org.sblim.wbemsmt.cli.dns;

import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.cli.CimCommandValues;
import org.sblim.wbemsmt.tools.cli.CliUtil;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public class DeleteDnsResourceRecordLoader extends DnsDataLoader {

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.cli.CliDataLoader#load(org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle, org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter, org.apache.commons.cli.CommandLine)
	 */
	public void load(WbemSmtResourceBundle bundle,
			AbstractBaseCimAdapter adapter, CimCommandValues commandValues)
			throws WbemsmtException {
		this.commandValues = commandValues;

		String zoneName = CliUtil.getOption(commandValues,DeleteDnsResourceRecord.KEY_zoneName);
		String recordName = CliUtil.getOption(commandValues,DeleteDnsResourceRecord.KEY_recordNameToSelect);
		String recordValue = CliUtil.getOption(commandValues,DeleteDnsResourceRecord.KEY_recordValueToSelect);
		String recordPrio = CliUtil.getOption(commandValues,DeleteDnsResourceRecord.KEY_mxPriorityToSelect);
		String recordType = CliUtil.getOption(commandValues,DeleteDnsResourceRecord.KEY_recordTypeToSelect);
		selectResourceRecord(bundle, adapter, zoneName,recordName,recordValue,recordPrio,recordType);
	}


}
