/** 
  * DnsMasterDataContainer.java
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
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsMasterDataContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_NAME = "Name" ;
			public static final String FIELD_MASTERELEMENTTYPE = "MasterElementType" ;
			public static final String FIELD_MASTERELEMENT = "MasterElement" ;
		
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMaster.get_Name<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMaster.get_MasterElementType<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_MasterElementType();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Linux_DnsMaster.get_MasterElement<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_MasterElement();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
	
}