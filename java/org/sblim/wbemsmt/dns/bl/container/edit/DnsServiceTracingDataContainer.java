/**
 * DnsServiceTracingDataContainer.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER
 * THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF
 * THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of
 * the Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.DataContainerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/containerClass.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Container for Tracing the DNService generated
 *            Class
 */

package org.sblim.wbemsmt.dns.bl.container.edit;

public interface DnsServiceTracingDataContainer extends org.sblim.wbemsmt.bl.adapter.DataContainer {
    /** 
     * Constants for Fields and Roles
     **/
    public static final String ROLE_ALLOWNOTIFYACL = "allowNotifyAcl";
    public static final String ROLE_ALLOWQUERYACL = "allowQueryAcl";
    public static final String ROLE_ALLOWTRANSFERACL = "allowTransferAcl";
    public static final String ROLE_ALLOWRECURSIONACL = "allowRecursionAcl";
    public static final String ROLE_BLACKHOLEACL = "blackholeAcl";
    public static final String ROLE_CONFIGURATION = "configuration";

    /** 
     * Defined Fields
     **/

    /** 
     * Linked DataContainers
     **/

    /**
     * 
     * linked container DnsAllowNotifyForServiceDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer getAllowNotifyAcl();

    /**
     * 
     * linked container DnsAllowQueryForServiceDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer getAllowQueryAcl();

    /**
     * 
     * linked container DnsAllowTransferForServiceDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer getAllowTransferAcl();

    /**
     * 
     * linked container DnsAllowRecursionForServiceDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer getAllowRecursionAcl();

    /**
     * 
     * linked container DnsBlackholeForServiceDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer getBlackholeAcl();

    /**
     * 
     * linked container DnsConfigurationDataContainer
     */

    public org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer getConfiguration();

}