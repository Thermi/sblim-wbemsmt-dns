/**
 * DnsResourceRecordDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER
 * THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF
 * THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of
 * the Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Container for ResourceRecords generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsResourceRecordDataContainer extends
        org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_TYPE = "Type";
    public static final String FIELD_FAMILY = "Family";
    public static final String FIELD_VALUE = "Value";
    public static final String FIELD_PRIORITY = "Priority";

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
     * DataType UNSIGNED_INT16<br>
     * UIType COMBOBOX<br>
     * Relation to FCO: Type<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Type();

    /**
     * <br>
     * DataType UNSIGNED_INT8<br>
     * UIType COMBOBOX<br>
     * Relation to FCO: Family<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_Family();

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Value<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Value();

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Value<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Priority();

    /** 
     * Linked DataContainers
     **/

}