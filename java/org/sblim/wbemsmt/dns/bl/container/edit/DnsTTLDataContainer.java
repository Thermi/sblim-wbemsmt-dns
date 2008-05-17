/** 
 * DnsTTLDataContainer.java
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
 * Description: Container for the fields needed to define TTL
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsTTLDataContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_TTL = "TTL";
    public static final String FIELD_USR_TTLUNIT = "usr_TTLUnit";
    public static final String FIELD_USR_REMOVETTL = "usr_RemoveTTL";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType STRING<br>
     * UIType TEXTFIELD<br>
     * Relation to FCO: Linux_DnsSetting.get_TTL<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_TTL();

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
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_RemoveTTL();

    /** 
     * Linked DataContainers
     **/

}