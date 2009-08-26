/**
 * DnsResourceRecordForReverseZoneWizardDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS
 * FILE IS PROVIDED UNDER THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE,
 * REPRODUCTION OR DISTRIBUTION OF THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You
 * can obtain a current copy of the Eclipse Public License from
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: ResourceRecord within the ReverseZone Wizard
 *            (on the Overview page) generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.wizard;

public interface DnsResourceRecordForReverseZoneWizardDataContainer extends
        org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_NAME = "Name";
    public static final String FIELD_TYPE = "Type";
    public static final String FIELD_VALUE = "Value";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Name<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Name();

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Type<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Type();

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Value<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Value();

    /** 
     * Linked DataContainers
     **/

}