/** 
  * DnsMastersWizardPage1DataContainer.java
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
  * Description: Page 1 of AddressMatchList-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.wizard;

public interface DnsMastersWizardPage1DataContainer extends org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_MASTERS = "Masters" ;
			public static final String FIELD_USR_REMOVEMASTERENTRY = "usr_RemoveMasterEntry" ;
			public static final String FIELD_USR_NEWMASTERENTRY = "usr_NewMasterEntry" ;
			public static final String FIELD_USR_ADDNEWMASTERENTRY = "usr_AddNewMasterEntry" ;
			public static final String FIELD_USR_ADDPREDEFINEDMASTER = "usr_AddPredefinedMaster" ;
			public static final String FIELD_USR_PREDEFINEDMASTERS = "usr_PredefinedMasters" ;
			public static final String FIELD_NAME = "Name" ;
		
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType LIST_WITH_MULTISELECT<br>
		* Relation to FCO: Linux_DnsSetting.get_Forwarders<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Masters();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveMasterEntry();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_NewMasterEntry();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddNewMasterEntry();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddPredefinedMaster();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType LIST_WITH_MULTISELECT<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_PredefinedMasters();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMaster.get_Name<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
	
}