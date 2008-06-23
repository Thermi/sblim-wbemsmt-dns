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

import java.util.Iterator;
import java.util.List;

import org.sblim.wbemsmt.bl.messages.Message;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.Zone;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.Validator;

public class ZoneNameValidator  extends Validator {

	private LabeledBaseInputComponentIf component;
	private final DnsCimAdapter dnsCimAdapter;

	/**
	 * 
	 */
	public ZoneNameValidator(LabeledBaseInputComponentIf component,DnsCimAdapter adapter) {
		super(adapter);
		this.component = component;
		dnsCimAdapter = adapter;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{component};
	}

	public void validateElement(MessageList result) throws WbemsmtException {

		List zones = dnsCimAdapter.getDnsService().getZoneList();
        
        for (Iterator iter = zones.iterator(); iter.hasNext();) {
        	Zone zone = (Zone) iter.next();
        	if (zone.getName().equals(component.getConvertedControlValue()))
        	{
        		String msg = adapter.getBundle().getString(DnsErrCodes.MSG_REVERSE_ZONE_EXISTS,"validator.zoneExists",new Object[]{component.getConvertedControlValue()});
        		result.addMessage(new Message(DnsErrCodes.MSG_REVERSE_ZONE_EXISTS, Message.ERROR, msg,component));
        		return;
        	}
        }
	}

}
