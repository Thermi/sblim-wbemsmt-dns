/**
 * DnsResourceRecordWizardPage2TypeMxDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE
 * IS PROVIDED UNDER THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR
 * DISTRIBUTION OF THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a
 * current copy of the Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Page 2 of ResourceRecord-Wizard for defining
 *            MX-typed Records generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.wizard;

public interface DnsResourceRecordWizardPage2TypeMxDataContainer extends
        org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_USR_VALUE = "usr_Value";
    public static final String FIELD_USR_PRIORITY = "usr_Priority";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType STRING<br>
     * UIType TEXTFIELD<br>
     * Relation to FCO: Value<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Value();

    /**
     * <br>
     * DataType STRING<br>
     * UIType TEXTFIELD<br>
     * Relation to FCO: <br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Priority();

    /** 
     * Linked DataContainers
     **/

}