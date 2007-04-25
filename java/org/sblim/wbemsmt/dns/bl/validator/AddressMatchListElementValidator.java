 /** 
  * AddressMatchListElementValidator.java
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
  * Description: Checks if the AddressMatchListElement is okay
  * 
  * -> If the value starts with 'key' the value is not validated. Sind keys are not supported by the Model the client cannot validate against them
  * -> If the value not starts with 'key' the value must be
  *      - a predefined matchList
  *      - ipAddress
  *      - IpAddress-Prefix 
  *      all three with optional !
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.apache.commons.lang.StringUtils;
import org.sblim.wbemsmt.bl.MessageNumber;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.AddressMatchList;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ValidationException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.IpAddressFieldValidator;
import org.sblim.wbemsmt.tools.validator.Validator;
import org.sblim.wbemsmt.util.StringTokenizer;

public class AddressMatchListElementValidator  extends Validator {

	private LabeledBaseInputComponentIf component;
	private final DnsCimAdapter dnsCimAdapter;
	boolean headerAdded = false;
	private boolean isPredefindAddressMatchList;

	/**
	 * 
	 */
	public AddressMatchListElementValidator(LabeledBaseInputComponentIf component,DnsCimAdapter adapter) {
		super(adapter);
		this.component = component;
		dnsCimAdapter = adapter;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{component};
	}

	public void validateElement(MessageList result) throws ValidationException {

		headerAdded = false;
		isPredefindAddressMatchList = false;
		
		String value = (String) component.getConvertedControlValue();
		
		if (StringUtils.isNotEmpty(value))
		{
			value = value.trim();

			if (value.startsWith("!"))
			{
				value = value.substring(1).trim();
			}

			//validate only values without key
			if (!value.startsWith("key "))
			{
				try {
					AddressMatchList addressMatchList = dnsCimAdapter.getDnsService().getAddressMatchListList().getAddressMatchListByListName(value);
					isPredefindAddressMatchList = addressMatchList != null;
					if (isPredefindAddressMatchList)
					{
						return;
					}
					
					//check if it's a global defined matchList

					addressMatchList = dnsCimAdapter.getDnsService().getAddressMatchListList().getAddressMatchListByListName(value);
					
					if (addressMatchList == null)
					{
						int indexOfSlash = value.indexOf("/");
						//only Ip-Prefixes can contain a slash
						if (indexOfSlash > -1 )
						{
							String ipPrefix = value.substring(0,indexOfSlash);
							
							IpAddressFieldValidator.validateIpValues(result, ipPrefix, adapter, component, new StringTokenizer(ipPrefix,".",false).asArray(true, true));
							
							String ipNetMask = value.substring(indexOfSlash+1);
							try {
								int mask = Integer.parseInt(ipNetMask);
								if (mask > 255)
								{
									addError(DnsErrCodes.MSG_NETMASK_LARGER_255,result, adapter.getBundle().getString(DnsErrCodes.MSG_NETMASK_LARGER_255,"AddressMatchListElementValidator.netMaskLargerThan255"));
								}
							} catch (NumberFormatException e) {
								addError(DnsErrCodes.MSG_NETMASK_NO_INT, result, adapter.getBundle().getString(DnsErrCodes.MSG_NETMASK_NO_INT, "AddressMatchListElementValidator.netMaskNoInt"));
							}
						}
						else
						{
							if (!IpAddressFieldValidator.validateIpAddress(result, value, adapter, component))
							{
								addHeader(result);
							}
						}
					}
				} catch (ModelLoadException e) {
					throw new ValidationException(e);
				}
				
			}
			
		}
	}
	
	private void addError(MessageNumber messageNumber, MessageList list, String msg)
	{
		if (!headerAdded)
		{
			addHeader(list);
		}
		list.addMessage(new Message(messageNumber,Message.ERROR, msg,component));
	}

	private void addHeader(MessageList list) {
		String msg = adapter.getBundle().getString("AddressMatchListElementValidator.wrongSyntax");
		list.addMessage(new Message(DnsErrCodes.MSG_WRONGS_SYNTAX,Message.ERROR, msg,component));
		headerAdded = true;
	}

	public boolean isPredefindAddressMatchList() {
		return isPredefindAddressMatchList;
	}


	
}
