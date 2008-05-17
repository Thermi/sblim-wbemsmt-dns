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
  * Description: Validator for the name of address matchlists
  * 
  */
package org.sblim.wbemsmt.dns.bl.validator;

import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.wrapper.AddressMatchList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.AddressMatchListList;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.validator.Validator;

public class AddressMatchListNameValidator  extends Validator {

	private LabeledBaseInputComponentIf component;
	private final DnsCimAdapter dnsCimAdapter;

	/**
	 * 
	 */
	public AddressMatchListNameValidator(LabeledBaseInputComponentIf component,DnsCimAdapter adapter) {
		super(adapter);
		this.component = component;
		dnsCimAdapter = adapter;
	}

	protected LabeledBaseInputComponentIf[] getComponents() {
		return new LabeledBaseInputComponentIf[]{component};
	}

	public void validateElement(MessageList result) throws WbemsmtException {

		AddressMatchListList addressMatchLists = dnsCimAdapter.getDnsService().getAddressMatchListList();
        
        for (int i=0; i < addressMatchLists.size(); i++) {
        	AddressMatchList matchList = addressMatchLists.getAddressMatchList(i);
        	if (matchList.getFco().get_key_Name().equals(component.getConvertedControlValue()))
        	{
        		String msg = adapter.getBundle().getString(DnsErrCodes.MSG_MATCHLIST_EXISTS, "validator.matchListExists",new Object[]{component.getConvertedControlValue()});
        		result.addMessage(new Message(DnsErrCodes.MSG_MATCHLIST_EXISTS,Message.ERROR, msg,component));
        		return;
        	}
        }
	}

}
