/** 
  * DnsAddressMatchListDataContainer.java
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
  * Description: Container for a AddressMatchList (Baseclass for specific ACLs)
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsAddressMatchListDataContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_ADDRESSLIST = "AddressList" ;
			public static final String FIELD_USR_REMOVEADDRESS = "usr_RemoveAddress" ;
			public static final String FIELD_USR_USERADDRESSES = "usr_UserAddresses" ;
			public static final String FIELD_USR_NEWADDRESS = "usr_NewAddress" ;
			public static final String FIELD_USR_ADDPREDEFINEDADDRESS = "usr_AddPredefinedAddress" ;
			public static final String FIELD_USR_ADDNEWADDRESS = "usr_AddNewAddress" ;
			public static final String FIELD_USR_ADDRESSUP = "usr_AddressUp" ;
			public static final String FIELD_USR_ADDRESSDOWN = "usr_AddressDown" ;
		
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType LIST_WITH_MULTISELECT<br>
		* Relation to FCO: Linux_DnsAddressMatchList.get_AddressList<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_AddressList();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveAddress();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType LIST_WITH_MULTISELECT<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_UserAddresses();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewAddress();
			
		/**
		* Add the Adress selected in the userAddresses-ListBox<br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddPredefinedAddress();
			
		/**
		* Add the Adress entered in the textField for a new Address<br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddNewAddress();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddressUp();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddressDown();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
	
}