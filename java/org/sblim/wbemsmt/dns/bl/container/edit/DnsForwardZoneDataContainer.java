/** 
  * DnsForwardZoneDataContainer.java
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
  * Description: Container for DNS ForwardZones
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsForwardZoneDataContainer extends org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer, org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_NAME = "Name" ;
			public static final String FIELD_FORWARD = "Forward" ;
			public static final String FIELD_FORWARDERS = "Forwarders" ;
			public static final String FIELD_USR_REMOVEFORWARDER = "usr_RemoveForwarder" ;
			public static final String FIELD_USR_NEWFORWARDER = "usr_NewForwarder" ;
			public static final String FIELD_USR_ADDFORWARDER = "usr_AddForwarder" ;
			public static final String FIELD_USR_NEWFORWARDERTYPE = "usr_NewForwarderType" ;
			public static final String FIELD_USR_USEGLOBALFORWARDERS = "usr_UseGlobalForwarders" ;
		
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType LABEL<br>
		* Relation to FCO: Linux_DnsZone.get_Name<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name();
			
		/**
		* <br>
		* DataType UNSIGNED_INT8<br>
		* UIType RADIOBUTTON<br>
		* Relation to FCO: Linux_DnsSetting.get_Forward<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forward();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType LIST_WITH_MULTISELECT<br>
		* Relation to FCO: Linux_DnsSetting.get_Forwarders<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Forwarders();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveForwarder();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewForwarder();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddForwarder();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType COMBOBOX<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_NewForwarderType();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_UseGlobalForwarders();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
	
}