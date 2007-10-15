/** 
  * DnsZoneTracingContainer.java
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
  * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm
  *
  * Contributors: 
  * 
  * Description: Container for Tracing a Zone
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsZoneTracingContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_NAME = "Name" ;
			public static final String FIELD_RESOURCERECORDFILE = "ResourceRecordFile" ;
			public static final String FIELD_CONTACT = "Contact" ;
			public static final String FIELD_EXPIRE = "Expire" ;
			public static final String FIELD_SERVER = "Server" ;
			public static final String FIELD_SERIALNUMBER = "SerialNumber" ;
			public static final String FIELD_RETRY = "Retry" ;
			public static final String FIELD_FORWARD = "Forward" ;
			public static final String FIELD_FORWARDERS = "Forwarders" ;
			public static final String FIELD_USR_MASTERADDRESSES = "usr_MasterAddresses" ;
			public static final String FIELD_TTL = "TTL" ;
			public static final String FIELD_TTLUNIT = "TTLUnit" ;
			public static final String FIELD_NEGATIVECACHING_TTL = "NegativeCaching_TTL" ;
			public static final String FIELD_USR_NEGATIVECACHING_TTLUNIT = "usr_NegativeCaching_TTLUnit" ;
				public static final String ROLE_ALLOWNOTIFYACL = "allowNotifyAcl";
			public static final String ROLE_ALLOWQUERYACL = "allowQueryAcl";
			public static final String ROLE_ALLOWTRANSFERACL = "allowTransferAcl";
			public static final String ROLE_ALLOWUPDATEACL = "allowUpdateAcl";
			public static final String ROLE_RESOURCERECORDS = "resourceRecords";
	
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsZone.get_Name<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsZone.get_ResourceRecordFile<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_ResourceRecordFile();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Contact<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Contact();
			
		/**
		* <br>
		* DataType UNSIGNED_INT32<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Expire<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Expire();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Server<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Server();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMasterZone.get_SerialNumber<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_SerialNumber();
			
		/**
		* <br>
		* DataType UNSIGNED_INT32<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMasterZone.get_Retry<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Retry();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsSetting.get_Forward<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Forward();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsSetting.get_Forwarders<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Forwarders();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_MasterAddresses();
			
		/**
		* <br>
		* DataType DOUBLE<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsSetting.get_TTL<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_TTL();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType COMBOBOX<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_TTLUnit();
			
		/**
		* <br>
		* DataType DOUBLE<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: <br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_NegativeCaching_TTL();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType COMBOBOX<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_NegativeCaching_TTLUnit();
	
	
	/** 
	 * Linked DataContainers
	 **/
			
				
		/**
		* 
		* linked container DnsAllowNotifyForZoneDataContainer
		*/

		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForZoneDataContainer getAllowNotifyAcl();

	   			
				
		/**
		* 
		* linked container DnsAllowQueryForZoneDataContainer
		*/

		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForZoneDataContainer getAllowQueryAcl();

	   			
				
		/**
		* 
		* linked container DnsAllowTransferForZoneDataContainer
		*/

		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForZoneDataContainer getAllowTransferAcl();

	   			
				
		/**
		* 
		* linked container DnsAllowUpdateForZoneDataContainer
		*/

		public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowUpdateForZoneDataContainer getAllowUpdateAcl();

	   			
				
		/**
		* 
		* linked container DnsResourceRecordDataContainer
		*/

		public java.util.List getResourceRecords();

	   		
	   /**
		* Header for:
		* 
		* linked container DnsResourceRecordDataContainer
		*/
		public  org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainerHeader getResourceRecordsHeader();
		
			
}