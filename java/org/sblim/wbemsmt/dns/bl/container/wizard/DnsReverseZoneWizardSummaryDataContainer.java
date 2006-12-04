/** 
  * DnsReverseZoneWizardSummaryDataContainer.java
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
  * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
  * @template: ./tools-dcg/templates/containerClass.vm
  *
  * Contributors: 
  * 
  * Description: Summary of ReverseZone-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.wizard;

public interface DnsReverseZoneWizardSummaryDataContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_USR_NAME = "usr_Name" ;
			public static final String FIELD_RESOURCERECORDFILE = "ResourceRecordFile" ;
				public static final String ROLE_RESOURCERECORDS = "resourceRecords";
	
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsZone.get_ResourceRecordFile<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ResourceRecordFile();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
			
		/**
		* 
		* linked container DnsResourceRecordForReverseZoneWizardDataContainer
		*/

		public java.util.List getResourceRecords();

	
}