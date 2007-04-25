/** 
  * DnsCimAdapterCountIf.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.AdapterStubGenerator
  * @template: ./tools-dcg/templates/adapterInterfaceCount.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.adapter;

import org.sblim.wbemsmt.bl.adapter.*;

	/** 
	 * This is the interface containing only the Count-Methods for the delegate
	 **/

public interface DnsCimAdapterCountIf extends CountDelegatee
{

	public static final String[] RESOURCE_BUNDLE_NAMES = new String[]{"messages","messagesDns"};

	/** 
	 * Count-Methods
	 **/
	public int countImpl_DnsResourceRecordDataContainer() throws org.sblim.wbemsmt.exception.CountException;
	public int countImpl_DnsResourceRecordForReverseZoneWizardDataContainer() throws org.sblim.wbemsmt.exception.CountException;
	public int countImpl_DnsResourceRecordListItemContainer() throws org.sblim.wbemsmt.exception.CountException;
			
}