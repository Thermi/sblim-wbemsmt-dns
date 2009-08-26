 /** 
  * MasterAddressesSetValidator.java
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
  * Description: Checks if masterAddresses are set
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.sblim.wbemsmt.bl.messages.Message;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.exception.WbemsmtException;
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

	public void validateElement(MessageList result) throws WbemsmtException {

		
		if (component.getValues() == null || component.getValues().length == 0)
		{
			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_NO_MASTER_ADDRESSES, "validator.noMasterAddresses",new Object[]{component.getLabelText()});
			result.addMessage(new Message(DnsErrCodes.MSG_NO_MASTER_ADDRESSES, Message.ERROR,msg,component));
			return;
		}
	}

}
