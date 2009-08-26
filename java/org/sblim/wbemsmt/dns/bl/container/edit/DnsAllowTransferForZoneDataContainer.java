/**
 * DnsAllowTransferForZoneDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED
 * UNDER THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR
 * DISTRIBUTION OF THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a
 * current copy of the Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Datacontainer for allowTransfer of a zone
 *            generated Class
 */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsAllowTransferForZoneDataContainer extends
        org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String FIELD_USR_USEGLOBALADDRESSMATCHLIST = "usr_UseGlobalAddressMatchList";

    /** 
     * Defined Fields
     **/

    /**
     * <br>
     * DataType ACTION<br>
     * UIType BUTTON<br>
     * Relation to FCO: userdefined<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_UseGlobalAddressMatchList();

    /** 
     * Linked DataContainers
     **/

}