 /** 
  * ForwardUnknownValidator.java
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
  * Description: Validates if the forward is unknown and the user have not choosen to overwrite this value
  * in that case a warning is given
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ValidationException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf;
import org.sblim.wbemsmt.tools.validator.Validator;

public class ForwardUnknownValidator  extends Validator {

	private LabeledStringArrayInputComponentIf component;
	private final boolean service;
	private final DnsCimAdapter adapter2;

	/**
	 * 
	 */
	public ForwardUnknownValidator(LabeledStringArrayInputComponentIf forward,DnsCimAdapter adapter, boolean service) {
		super(adapter);
		this.component = forward;
		adapter2 = adapter;
		this.service = service;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{component};
	}

	public void validateElement(MessageList result) throws ValidationException {

		DnsBusinessObject dnsObject = null;
		if (service)
		{
			try {
				dnsObject = adapter2.getDnsService();
			} catch (ModelLoadException e) {
				throw new ValidationException(e);
			}
		}
		else
		{
			dnsObject = (DnsBusinessObject) adapter2.getSelectedZone();
		}
		
		if (component.getConvertedControlValue() == null && dnsObject.isUnknownForwarder())
		{
			result.addMessage(Message.create(DnsErrCodes.MSGDEF_UNKNOWN_FORWARD_AND_NO_FORWARD_SET, adapter.getBundle()));
			return;
		}
	}

}
