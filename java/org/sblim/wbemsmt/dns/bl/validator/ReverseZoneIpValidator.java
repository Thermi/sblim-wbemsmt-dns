 /** 
  * ReverseZoneIpValidator.java
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
  * Description: Validator to validate the entered ip for a new reverse zone
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.sblim.wbemsmt.bl.messages.Message;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.Validator;

public class ReverseZoneIpValidator extends Validator {

	private final LabeledBaseInputComponentIf ipAddressField;
	private final DnsCimAdapter dnsAdapter;

	public ReverseZoneIpValidator(LabeledBaseInputComponentIf ipAddressField, DnsCimAdapter adapter) {
		super(adapter);
		this.ipAddressField = ipAddressField;
		dnsAdapter = adapter;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.validator.Validator#getComponents()
	 */
	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{ipAddressField};
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.tools.validator.Validator#validateElement(org.sblim.wbemsmt.bl.adapter.MessageList)
	 */
	public void validateElement(MessageList result) throws WbemsmtException {
	
		ResourceRecordList resourceRecords = dnsAdapter.getSelectedZone().getResourceRecords().getResourceRecordsForWizard(true);
        
        String enteredIp = (String) ipAddressField.getConvertedControlValue();
        int size = resourceRecords.size();
        for (int i = 0; i < size; i++) {
        	ResourceRecord record = resourceRecords.getResourceRecord(i);
        	if (record.getFco().get_key_Type().equals(ResourceRecord.TYPE_A))
        	{
        		if (!record.getFco().get_key_Value().startsWith(enteredIp))
        		{
        			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_REVERSE_ZONE_IP, "validator.reverseZoneIp",new Object[]{enteredIp,record.getFco().get_key_Name(),record.getFco().get_key_Value()});
        			result.addMessage(new Message(DnsErrCodes.MSG_REVERSE_ZONE_IP,Message.ERROR, msg,ipAddressField));
        		}
        	}
        	
        }

	}

}
