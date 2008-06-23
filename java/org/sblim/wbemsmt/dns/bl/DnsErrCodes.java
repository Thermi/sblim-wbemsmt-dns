 /** 
  * ErrCodes.java
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
  * Description: ErrorCodes for the Dns Task
  * 
  */
package org.sblim.wbemsmt.dns.bl;

import org.sblim.wbemsmt.bl.messages.ErrCodes;
import org.sblim.wbemsmt.bl.messages.Message;
import org.sblim.wbemsmt.bl.messages.MessageDefinition;
import org.sblim.wbemsmt.bl.messages.MessageNumber;

/**
 * @author Bauschert
 *
 */
public class DnsErrCodes {

	/**
	 * Validator
	 */
	public final static String SUBSYS_DNS = "DNS";

	/**
	 * Messages for DNS
	 */
	public static final MessageNumber MSG_WRONGS_SYNTAX = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,1);
	public static final MessageNumber MSG_NETMASK_NO_INT = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,2);
	public static final MessageNumber MSG_NETMASK_LARGER_255 = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,3);
	public static final MessageNumber MSG_MATCHLIST_EXISTS = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,4);
	public static final MessageNumber MSG_NO_MASTER_ADDRESSES = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,5);
	public static final MessageNumber MSG_WRONG_SYNTAX = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,6);
	public static final MessageNumber MSG_PORT_NO_NUMBER = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,7);
	public static final MessageNumber MSG_CANNOT_CONVERT_TTL = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,8);
	public static final MessageNumber MSG_RECORD_EXISTS_MORE_THAN_ONCE = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,9);
	public static final MessageNumber MSG_RECORD_EXISTS = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,10);

	public static final MessageNumber RECORD_NAME_HAS_WHITESPACE  = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,11);
	public static final MessageNumber TYPE_A  = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,12);
	public static final MessageNumber TYPE_CNAME  = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,13);
	public static final MessageNumber TYPE_MX  = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,14);
	public static final MessageNumber TYPE_PTR  = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,15);
	public static final MessageNumber TYPE_NS  = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,16);

	public static final MessageNumber MSG_REVERSE_ZONE_IP = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,17);
	public static final MessageNumber MSG_REVERSE_ZONE_NAME = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,18);
	public static final MessageNumber MSG_REVERSE_ZONE_EXISTS = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,19);

	public static final MessageNumber MSG_START_NOT_EXECUTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,20);
	public static final MessageNumber MSG_STOP_NOT_EXECUTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,21);

	public static final MessageNumber MSG_START_EXECUTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,22);
	public static final MessageNumber MSG_STOP_EXECUTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,23);

	public static final MessageNumber MSG_VALUE_NOT_ADDED_TO_FWD = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,24);
	public static final MessageNumber MSG_CONTACT_CONVERTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,25);
	public static final MessageNumber MSG_RECORD_TYPE_NOT_SUPPORTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,26);
	public static final MessageNumber MSG_VALUE_NOT_ADDED_TO_ACL = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,27);
	public static final MessageNumber MSG_VALUE_NOT_ADDED_TO_IP = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,28);
	public static final MessageNumber MSG_VALUE_NOT_ADDED_TO_IP_EMPTY_IP = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,29);
	public static final MessageNumber MSG_VALUE_NOT_ADDED_TO_MASTER = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,30);
	
	public static final MessageNumber MSG_CANNOT_SELECT_SERVICE = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,31);
	public static final MessageNumber MSG_NO_ZONE_SELECTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,32);
	public static final MessageNumber MSG_NO_MASTERZONE_SELECTED = new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,33);
	
	public static final MessageDefinition MSGDEF_UNKNOWN_FORWARD_AND_NO_FORWARD_SET = new MessageDefinition(new MessageNumber(ErrCodes.COMPONENT,SUBSYS_DNS,34),Message.WARNING,"unknown.forward.and.no.forward.set");

	
}
