/** 
  * DnsServiceDataContainer.java
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
  * @template: templates/containerClass.vm
  *
  * Contributors: 
  * 
  * Description: 
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsServiceDataContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer
{
	/** 
	 * Defined Fields
	 **/
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType TEXTFIELD<br>
		* Relation to FCO: Name<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name();
			
		/**
		* <br>
		* DataType BOOLEAN<br>
		* UIType CHECKBOX<br>
		* Relation to FCO: RunAsRoot<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_RunAsRoot();
			
		/**
		* <br>
		* DataType BOOLEAN<br>
		* UIType CHECKBOX<br>
		* Relation to FCO: Started<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Started();
			
		/**
		* <br>
		* DataType STRING<br>
		* UIType BUTTON<br>
		* Relation to FCO: userdefined<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Restart();
			
		/**
		* <br>
		* DataType UNSIGNED_INT32<br>
		* UIType BUTTON<br>
		* Relation to FCO: startService<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Start();
			
		/**
		* <br>
		* DataType UNSIGNED_INT32<br>
		* UIType BUTTON<br>
		* Relation to FCO: stopService<br>
		*/
		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Stop();
	
	
	/** 
	 * Linked DataContainers
	 **/
	 
	
	
}