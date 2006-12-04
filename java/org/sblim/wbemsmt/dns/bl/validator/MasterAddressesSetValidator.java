 /** 
  * MasterAddressesSetValidator.java
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
  * Description: Checks if masterAddresses are set
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.exception.ValidationException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf;
import org.sblim.wbemsmt.tools.validator.Validator;

public class MasterAddressesSetValidator  extends Validator {

	private LabeledStringArrayInputComponentIf component;

	/**
	 * 
	 */
	public MasterAddressesSetValidator(LabeledStringArrayInputComponentIf component,DnsCimAdapter adapter) {
		super(adapter);
		this.component = component;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{component};
	}

	public void validateElement(MessageList result) throws ValidationException {

		
		if (component.getValues() == null || component.getValues().length == 0)
		{
			String msg = adapter.getBundle().getString("validator.noMasterAddresses",new Object[]{component.getLabelText()});
			result.addError(msg,component);
			return;
		}
	}

}
