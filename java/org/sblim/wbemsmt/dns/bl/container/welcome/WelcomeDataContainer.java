/**
 * WelcomeDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE TER MS
 * OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the Common
 * Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.welcome;

public interface WelcomeDataContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_USR_WELCOMETEXT = "usr_WelcomeText";
    public static final String FIELD_USR_DNSPICTURE = "usr_DnsPicture";
    public static final String FIELD_USR_MEMO = "usr_Memo";
    public static final String FIELD_USR_LINKCREATEMASTERZONE = "usr_LinkCreateMasterzone";
    public static final String FIELD_USR_LINKCREATESLAVEZONE = "usr_LinkCreateSlavezone";
    public static final String FIELD_USR_LINKCREATEFORWARDZONE = "usr_LinkCreateForwardzone";
    public static final String FIELD_USR_LINKCREATEADDRESSMATCHLIST = "usr_LinkCreateAddressmatchlist";
    public static final String FIELD_USR_LINKCREATEMASTERS = "usr_LinkCreateMasters";
    public static final String FIELD_USR_ACTIONS = "usr_Actions";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_WelcomeText();

    /**
     * <br>
     * DataType PICTUREDATA<br>
     * UIType PICTURE<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_DnsPicture();

    /**
     * <br>
     * DataType MEMODATA<br>
     * UIType MEMO<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Memo();

    /**
     * <br>
     * DataType LINKDATA<br>
     * UIType LINK<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateMasterzone();

    /**
     * <br>
     * DataType LINKDATA<br>
     * UIType LINK<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateSlavezone();

    /**
     * <br>
     * DataType LINKDATA<br>
     * UIType LINK<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateForwardzone();

    /**
     * <br>
     * DataType LINKDATA<br>
     * UIType LINK<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateAddressmatchlist();

    /**
     * <br>
     * DataType LINKDATA<br>
     * UIType LINK<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_LinkCreateMasters();

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Actions();

    /** 
     * Linked DataContainers
     **/

}