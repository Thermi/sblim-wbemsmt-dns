 /** 
  * ReverseZoneNameValidator.java
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
  * Description: Validates the complete list including the items;
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.ValidationException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.Validator;

public class ResourceRecordListValidator  extends Validator {

	private final DnsCimAdapter dnsCimAdapter;
	private LabeledBaseInputComponentIf[] fields = new LabeledBaseInputComponentIf[]{};
	private final DnsResourceRecordListContainer container;

	/**
	 * @param container 
	 * 
	 */
	public ResourceRecordListValidator(DnsCimAdapter adapter, DnsResourceRecordListContainer container) {
		super(adapter);
		dnsCimAdapter = adapter;
		this.container = container;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return fields;
	}

	public void validateElement(MessageList result) throws ValidationException {

		List addFields = new ArrayList();
		ResourceRecordList resourceRecords2 = dnsCimAdapter.getSelectedZone().getResourceRecords();
		
		Map keys = new HashMap();
		
		for (int i=0; i < resourceRecords2.size(); i++)
		{
			ResourceRecord record = resourceRecords2.getResourceRecord(i);
			if (!record.isDeleted())
			{
				DnsResourceRecordListItemContainer item =  (DnsResourceRecordListItemContainer) container.getResourceRecords().get(i);
				LabeledBaseInputComponentIf nameField = item.get_Name();
				LabeledBaseInputComponentIf typeField = item.get_Type();
				LabeledBaseInputComponentIf valueField = item.get_Value();
				LabeledBaseInputComponentIf ttlField = item.get_TTL();
				
				
				addFields.add(nameField);
				addFields.add(typeField);
				addFields.add(valueField);
				addFields.add(ttlField);

				//check the ttl
				String ttl = null;
				try {
					ttl = (String) ttlField.getConvertedControlValue();
					if (!DnsCimAdapter.NOT_SET.equals(ttl))
					{
						ttl = ttl.replaceAll(",", ".");
						Double.parseDouble(ttl);
					}
				} catch (NumberFormatException e) {
					String msg = container.getAdapter().getBundle().getString("cannot.convert.ttl",new Object[]{ttl,ttlField.getLabelText(),DnsCimAdapter.NOT_SET});
					result.addError(msg,ttlField);
				}
				
				
				
				//check if the values are okay
				ResourceRecordValidator.checkFieldValues(dnsCimAdapter,result,nameField,typeField,valueField);				

				String name = (String)nameField.getConvertedControlValue();
				String type = ResourceRecord.getTypeOfIndex((UnsignedInt16)typeField.getConvertedControlValue());
				String value = (String)valueField.getConvertedControlValue();

				List fields = new ArrayList();
				fields.add(nameField);
				fields.add(valueField);
				fields.add(typeField);
				
				String key = name + type + value;
				if (keys.containsKey(key))
				{
					List fieldsFromMap = (List) keys.get(key);
					fields.addAll(fieldsFromMap);
					
					String msg = adapter.getBundle().getString("record.exist.more.than.one.time",new Object[]{nameField.getLabelText(),typeField.getLabelText(), valueField.getLabelText(),name,type,value});
					result.addError(msg,(LabeledBaseInputComponentIf[]) fields.toArray(new LabeledBaseInputComponentIf[fields.size()]));
				}
				keys.put(key,fields);
			}
		}
		
		fields = (LabeledBaseInputComponentIf[]) addFields.toArray(new LabeledBaseInputComponentIf[addFields.size()]);
	}

	
}
