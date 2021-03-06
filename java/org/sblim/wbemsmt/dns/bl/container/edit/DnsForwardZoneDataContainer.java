/**
 * DnsForwardZoneDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE
 * TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS
 * FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the
 * Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Container for DNS ForwardZones generated
 *            Class
 */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsForwardZoneDataContainer extends
        org.sblim.wbemsmt.dns.bl.container.edit.DnsZoneDataContainer,
        org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_USR_USEGLOBALFORWARDERS = "usr_UseGlobalForwarders";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_UseGlobalForwarders();

    /** 
     * Linked DataContainers
     **/

}