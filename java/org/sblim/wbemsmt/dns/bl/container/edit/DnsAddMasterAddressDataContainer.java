/**
 * DnsAddMasterAddressDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED
 * UNDER THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR
 * DISTRIBUTION OF THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a
 * current copy of the Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Container for the fields needed to add Master
 *            IP Addresses generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsAddMasterAddressDataContainer extends
        org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_MASTERS = "Masters";
    public static final String FIELD_USR_REMOVEMASTERENTRY = "usr_RemoveMasterEntry";
    public static final String FIELD_USR_NEWMASTERENTRY = "usr_NewMasterEntry";
    public static final String FIELD_USR_ADDNEWMASTERENTRY = "usr_AddNewMasterEntry";
    public static final String FIELD_USR_ADDPREDEFINEDMASTER = "usr_AddPredefinedMaster";
    public static final String FIELD_USR_PREDEFINEDMASTERS = "usr_PredefinedMasters";

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
     * Linked DataContainers
     **/

}