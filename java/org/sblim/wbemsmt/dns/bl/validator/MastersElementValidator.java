 /** 
  * MastersElementValidator.java
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
  * Description: Checks if the MastersElement is okay
  * 
  * Validation if the entered value is a predefined masters or a ip address.
  * After the IpAddress the definition of [port portnumber] and [key keyvalue].
  * The portnumber is validated the keyvalue not.
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.apache.commons.lang.StringUtils;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.Masters;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ValidationException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.IpAddressFieldValidator;
import org.sblim.wbemsmt.tools.validator.Validator;

public class MastersElementValidator  extends Validator {

	private LabeledBaseInputComponentIf component;
	private final DnsCimAdapter dnsCimAdapter;
	private boolean isPredefinedMaster;

	/**
	 * 
	 */
	public MastersElementValidator(LabeledBaseInputComponentIf component,DnsCimAdapter adapter) {
		super(adapter);
		this.component = component;
		dnsCimAdapter = adapter;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{component};
	}

	public void validateElement(MessageList result) throws ValidationException {

		isPredefinedMaster = false;
		
		String value = (String) component.getConvertedControlValue();
		
		if (StringUtils.isNotEmpty(value))
		{
			value = value.trim();
			
			Masters masters = null;
			try {
				masters = dnsCimAdapter.getDnsService().getMastersList().getMastersByListName(value);
			} catch (ModelLoadException e1) {
				throw new ValidationException(e1);
			}
			isPredefinedMaster = masters != null;
			if (isPredefinedMaster)
			{
				return;
			}

			
			int indexOfKey = value.indexOf("key");
			int indexOfPort = value.indexOf("port");
			if (indexOfKey > -1 && indexOfPort > -1 && indexOfKey < indexOfPort)
			{
				addError(result, adapter.getBundle().getString("MastersElementValidator.wrongSyntax"));
				return;
			}
			else
			{
				if (indexOfPort > -1)
				{
					String portString = value.substring(indexOfPort,indexOfKey > -1 ? indexOfKey : value.length()).trim();
					if (portString.endsWith("port"))
					{
						addError(result, adapter.getBundle().getString("MastersElementValidator.wrongSyntax"));
						return;
					}
					else
					{
						portString = portString.substring("port".length()+1).trim();
					}
					try {
						Integer.parseInt(portString);
					} catch (NumberFormatException e) {
						addError(result, adapter.getBundle().getString("MastersElementValidator.portIsNoNumber", new Object[]{portString}));
						return;
					}
				}
				
				String ipString = value.substring(0,indexOfPort > -1 ? indexOfPort : indexOfKey > -1 ? indexOfKey : value.length()).trim();
				IpAddressFieldValidator.validateIpAddress(result, ipString, adapter, component);
			}
		}
	}
	
	private void addError(MessageList list, String msg)
	{
		list.addError(msg,component);
	}

	public boolean isPredefinedMaster() {
		return isPredefinedMaster;
	}


	
}
