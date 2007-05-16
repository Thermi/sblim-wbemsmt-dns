/** 
  * DnsSoaContainer.java
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
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsSoaContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_SERVER = "Server" ;
			public static final String FIELD_CONTACT = "Contact" ;
			public static final String FIELD_SERIALNUMBER = "SerialNumber" ;
			public static final String FIELD_REFRESH = "Refresh" ;
			public static final String FIELD_RETRY = "Retry" ;
			public static final String FIELD_EXPIRE = "Expire" ;
			public static final String FIELD_NEGATIVECACHINGTTL = "NegativeCachingTTL" ;
			public static final String FIELD_USR_TTLUNIT = "usr_TTLUnit" ;
			public static final String FIELD_USR_SETSERIALNUMBER = "usr_SetSerialNumber" ;
		
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMasterZone.get_Server<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Server();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMasterZone.get_Contact<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Contact();
			
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
		* Relation to FCO: Linux_DnsMasterZone.get_Refresh<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Refresh();
			
		/**
		* <br>
		* DataType UNSIGNED_INT32<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMasterZone.get_Retry<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Retry();
			
		/**
		* <br>
		* DataType UNSIGNED_INT32<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMasterZone.get_Expire<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Expire();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMasterZone.get_NegativeCachingTTL<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_NegativeCachingTTL();
			
		/**
		* <br>
		* DataType UNSIGNED_INT16<br>
		* UIType COMBOBOX<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_TTLUnit();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_SetSerialNumber();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
	
}