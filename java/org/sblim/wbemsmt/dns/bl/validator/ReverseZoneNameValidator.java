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
  * Description: Validator for the name of a reverse zone
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.filter.DnsZoneNameFilter;
import org.sblim.wbemsmt.exception.ValidationException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.Validator;

public class ReverseZoneNameValidator  extends Validator {

	private LabeledBaseInputComponentIf component;

	/**
	 * 
	 */
	public ReverseZoneNameValidator(LabeledBaseInputComponentIf component,AbstractBaseCimAdapter adapter) {
		super(adapter);
		this.component = component;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{component};
	}

	public void validateElement(MessageList result) throws ValidationException {

		//using the same filter like the tree for getting the reverse zones
		DnsZoneNameFilter filter = new DnsZoneNameFilter(true);
		
		if (!filter.accept((String)component.getConvertedControlValue()))
		{
			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_REVERSE_ZONE_NAME, "validator.nameForReverseZone",new Object[]{component.getConvertedControlValue()});
			result.addMessage(new Message(DnsErrCodes.MSG_REVERSE_ZONE_NAME, Message.ERROR, msg,component));
		}
		
	}

}
