/** 
 * DnsReverseZoneWizardPage1DataContainer.java
 *
 * 
 * © Copyright IBM Corp. 2006,2007
 *
 * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE COMMON PUBLIC LICENSE
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
 *   michael.bauschert@de.ibm.com
 * 
 * Description: Page 1 of ReverseZone-Wizard
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.wizard;

public interface DnsReverseZoneWizardPage1DataContainer extends
        org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_USR_IPADDRESS = "usr_IpAddress";
    public static final String FIELD_USR_RESOURCERECORDUSED = "usr_ResourceRecordUsed";
    public static final String FIELD_USR_REMOVERESOURCERECORD = "usr_RemoveResourceRecord";
    public static final String FIELD_USR_RESOURCERECORDNOTUSED = "usr_ResourceRecordNotUsed";
    public static final String FIELD_USR_ADDRESOURCERECORD = "usr_AddResourceRecord";
    public static final String FIELD_USR_ADDALLRESOURCERECORDS = "usr_AddAllResourceRecords";
    public static final String FIELD_USR_REMOVEALLRESOURCERECORDS = "usr_RemoveAllResourceRecords";
    public static final String FIELD_USR_IPPRESETS = "usr_IpPresets";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType STRING<br>
     * UIType TEXTFIELD<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_IpAddress();

    /**
     * <br>
     * DataType UNSIGNED_INT16<br>
     * UIType LIST_WITH_MULTISELECT<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_ResourceRecordUsed();

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveResourceRecord();

    /**
     * <br>
     * DataType UNSIGNED_INT16<br>
     * UIType LIST_WITH_MULTISELECT<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_ResourceRecordNotUsed();

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddResourceRecord();

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_AddAllResourceRecords();

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveAllResourceRecords();

    /**
     * <br>
     * DataType UNSIGNED_INT16<br>
     * UIType COMBOBOX_WITH_ONCHANGEEVENT<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_IpPresets();

    /** 
     * Linked DataContainers
     **/

}