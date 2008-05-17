 /** 
  * ReverseZoneNameValidator.java
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
  * Description: Validator for the name of a zones
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import javax.cim.UnsignedInteger16;

import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.Zone;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.IpAddressFieldValidator;
import org.sblim.wbemsmt.tools.validator.Validator;
import org.sblim.wbemsmt.util.StringTokenizer;
import org.sblim.wbemsmt.util.StringUtil;

public class ResourceRecordValidator  extends Validator {

	private final DnsCimAdapter dnsCimAdapter;
	private LabeledBaseInputComponentIf[] fields = new LabeledBaseInputComponentIf[]{};

	/**
	 * 
	 */
	public ResourceRecordValidator(DnsCimAdapter adapter) {
		super(adapter);
		dnsCimAdapter = adapter;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return fields;
	}

	public void validateElement(MessageList result) throws WbemsmtException {

		LabeledBaseInputComponentIf nameField = dnsCimAdapter.getResourceRecordWizard().getNameField();
        LabeledBaseInputComponentIf typeField = dnsCimAdapter.getResourceRecordWizard().getTypeField();
        LabeledBaseInputComponentIf valueField = dnsCimAdapter.getResourceRecordWizard().getValueField();
        LabeledBaseInputComponentIf prioField = dnsCimAdapter.getResourceRecordWizard().getPriorityField();
        fields = new LabeledBaseInputComponentIf[]{nameField,typeField,valueField,prioField};
        
        String name = (String)nameField.getConvertedControlValue();
        String typeString = ResourceRecord.getTypeOfIndex((UnsignedInteger16)typeField.getConvertedControlValue());
        
        //check if the field values are okay
        boolean ok = checkFieldValues(dnsCimAdapter, result,nameField,typeField,valueField);
        
        if (ok)
        {
        	//last check if the reord already exists
        	Zone zone = dnsCimAdapter.getSelectedZone();
        	ResourceRecordList resourceRecords;
            resourceRecords = zone.getResourceRecords();
            boolean isMax = ResourceRecord.TYPE_MX.equals(typeString);
        	
        	int size = resourceRecords.size();
        	
            for (int i=0; resourceRecords != null && i < size; i++) {
        		ResourceRecord rr = resourceRecords.getResourceRecord(i);
        		
        		String valueString = isMax ? (String)valueField.getConvertedControlValue() + " " + (String)prioField.getConvertedControlValue() : (String)valueField.getConvertedControlValue();
        		
        		if (rr.equals(name,
        				typeString,
        					  valueString
        					))
        		{
        			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_RECORD_EXISTS, "validator.resourceRecordExists",new Object[]{nameField.getConvertedControlValue(),typeString,valueField.getConvertedControlValue()});
        			result.addMessage(new Message(DnsErrCodes.MSG_RECORD_EXISTS,Message.ERROR,msg,nameField));
        			return;
        		}
        	}
        }
		
		
	}

	public static boolean checkFieldValues(DnsCimAdapter adapter, MessageList result, LabeledBaseInputComponentIf nameField, LabeledBaseInputComponentIf typeField, LabeledBaseInputComponentIf valueField) {
		
		String name = (String)nameField.getConvertedControlValue();
		String typeString = ResourceRecord.getTypeOfIndex((UnsignedInteger16)typeField.getConvertedControlValue());
		String value = (String)valueField.getConvertedControlValue();

		if (StringUtil.containsWhitespaces(name))
		{
			String msg = adapter.getBundle().getString(DnsErrCodes.RECORD_NAME_HAS_WHITESPACE,"validator.name.has.whitespace",new Object[]{nameField.getLabelText(),name});
			result.addMessage(new Message(DnsErrCodes.RECORD_NAME_HAS_WHITESPACE,Message.ERROR, msg,new LabeledBaseInputComponentIf[]{nameField}));
			return false;
		}
		
		//joe        IN      A      192.168.254.3
		//ftp        IN      CNAME  server1
		//           IN      MX     30  mail.example.net.
		//2.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.2.0.0.0         IN      PTR     www.example.com.
		//74            IN      PTR     fred.example.com.
		//example.com.        IN      NS      ns1.example.com.
		if (ResourceRecord.TYPE_A.equals(typeString))
		{
			if (isIp(adapter,null,nameField, name) || ! isIp(adapter,null,valueField, value))
			{
				String msg = adapter.getBundle().getString(DnsErrCodes.TYPE_A,"validator.format.record.type.a",new Object[]{nameField.getLabelText(),valueField.getLabelText()});
				result.addMessage(new Message(DnsErrCodes.TYPE_A,Message.ERROR, msg,new LabeledBaseInputComponentIf[]{nameField,valueField}));
				return false;
			}
		}
		else if (ResourceRecord.TYPE_CNAME.equals(typeString))
		{
			if (isIp(adapter,null,nameField, name) || isIp(adapter,null,valueField, value))
			{
				String msg = adapter.getBundle().getString(DnsErrCodes.TYPE_CNAME,"validator.format.record.type.cname",new Object[]{nameField.getLabelText(),valueField.getLabelText()});
				result.addMessage(new Message(DnsErrCodes.TYPE_CNAME,Message.ERROR, msg,new LabeledBaseInputComponentIf[]{nameField,valueField}));
				return false;
			}
		}
		else if (ResourceRecord.TYPE_MX.equals(typeString))
		{
			if (isIp(adapter,null,nameField, name) || isIp(adapter,null,valueField, value))
			{
				String msg = adapter.getBundle().getString(DnsErrCodes.TYPE_MX,"validator.format.record.type.mx",new Object[]{nameField.getLabelText(),valueField.getLabelText()});
				result.addMessage(new Message(DnsErrCodes.TYPE_MX,Message.ERROR, msg,new LabeledBaseInputComponentIf[]{nameField,valueField}));
				return false;
			}
		}
		else if (ResourceRecord.TYPE_PTR.equals(typeString))
		{
			if (!value.endsWith(".") || value.startsWith(".") || !hasIpValues(adapter,result, nameField, name))
			{
				String msg = adapter.getBundle().getString(DnsErrCodes.TYPE_PTR,"validator.format.record.type.ptr",new Object[]{nameField.getLabelText(),valueField.getLabelText()});
				result.addMessage(new Message(DnsErrCodes.TYPE_PTR,Message.ERROR, msg,new LabeledBaseInputComponentIf[]{nameField,valueField}));
				return false;
			}
		}
		else if (ResourceRecord.TYPE_NS.equals(typeString))
		{
			if (isIp(adapter,null,nameField, name) || isIp(adapter,null,valueField, value)
				
				) 
			{
				String msg = adapter.getBundle().getString(DnsErrCodes.TYPE_NS,"validator.format.record.type.ns",new Object[]{nameField.getLabelText(),valueField.getLabelText()});
				result.addMessage(new Message(DnsErrCodes.TYPE_NS,Message.ERROR, msg,new LabeledBaseInputComponentIf[]{nameField,valueField}));
				return false;
			}
		}
		return true;
	}

	private static boolean isIp(DnsCimAdapter adapter, MessageList messageList, LabeledBaseInputComponentIf nameField, String name) {
		if (messageList == null)
		{
			messageList = new MessageList();
		}
		return IpAddressFieldValidator.validateIpAddress(messageList, name, adapter, nameField);
	}

	private static boolean hasIpValues(DnsCimAdapter adapter, MessageList messageList, LabeledBaseInputComponentIf field, String value) {
		if (messageList == null)
		{
			messageList = new MessageList();
		}
		String[] values = new StringTokenizer(value,".").asArray(false, true);
		return IpAddressFieldValidator.validateIpValues(messageList, value, adapter, field,values);
	}
	
	
}
