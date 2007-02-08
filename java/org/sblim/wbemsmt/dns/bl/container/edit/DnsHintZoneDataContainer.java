/** 
  * DnsHintZoneDataContainer.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
  * @template: ./tools-dcg/templates/containerClass.vm
  *
  * Contributors: 
  * 
  * Description: Container for DNSHintZones
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsHintZoneDataContainer extends org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer, org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_ZONEFILE = "ZoneFile" ;
		
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsHintZone.get_ZoneFile<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ZoneFile();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
	
}