/** 
  * DnsResourceRecordListContainer.java
  *
  * 
  * Â© Copyright IBM Corp.  2009,2006,2007
  *
  * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm
  *
  * Contributors: 
  *   Prashanth Karnam<prkarnam@in.ibm.com>
  * 
  * Description: Container with a List of ResourceRecords
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsResourceRecordListContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer
{
	/** 
	 * Constants for Fields and Roles
	 **/
			public static final String FIELD_USR_SELECTALL = "usr_SelectAll" ;
			public static final String FIELD_USR_DELETE = "usr_Delete" ;
				public static final String ROLE_RESOURCERECORDS = "resourceRecords";
	
	
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType BOOLEAN<br>
		* UIType CHECKBOX_WITH_CLICKEVENT<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_SelectAll();
			
		/**
		* <br>
		* DataType ACTION<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Delete();
	
	
	/** 
	 * Linked DataContainers
	 **/
			
				
		/**
		* 
		* linked container DnsResourceRecordListItemContainer
		*/

				
		public java.util.List<DnsResourceRecordListItemContainer> getResourceRecords();
		
		
	   		
	   /**
		* Header for:
		* 
		* linked container DnsResourceRecordListItemContainer
		*/
		public  org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainerHeader getResourceRecordsHeader();
		
			
}