/** 
 * DnsServiceOperationsDataContainer.java
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
 * Description: Container for Operations within DNS Service
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsServiceOperationsDataContainer extends
        org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_RUNASROOT = "RunAsRoot";
    public static final String FIELD_USR_RESTART = "usr_Restart";
    public static final String FIELD_INVOKE_START = "invoke_Start";
    public static final String FIELD_INVOKE_STOP = "invoke_Stop";
    public static final String FIELD_STATUS = "Status";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType BOOLEAN<br>
     * UIType CHECKBOX<br>
     * Relation to FCO: RunAsRoot<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_RunAsRoot();

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Restart();

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: startService<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Start();

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: stopService<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_invoke_Stop();

    /**
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Linux_DnsService.get_Status<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_Status();

    /** 
     * Linked DataContainers
     **/

}