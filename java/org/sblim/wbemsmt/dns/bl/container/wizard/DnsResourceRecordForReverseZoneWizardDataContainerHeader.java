/** 
 * DnsReverseZoneWizardSummaryDataContainer.java
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
 * @template: org/sblim/wbemsmt/dcg/templates/headerClass.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: Summary of ReverseZone-Wizard
 * 
 * Header for:
 * 
 * linked container DnsResourceRecordForReverseZoneWizardDataContainer
 */

package org.sblim.wbemsmt.dns.bl.container.wizard;

public interface DnsResourceRecordForReverseZoneWizardDataContainerHeader {
    /**
     * Header for
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Name<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Name();

    /**
     * Header for
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Type<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Type();

    /**
     * Header for
     * <br>
     * DataType STRING<br>
     * UIType LABEL<br>
     * Relation to FCO: Value<br>
     */
    public org.sblim.wbemsmt.tools.input.LabeledBaseHeaderComponentIf getResourceRecordsHeader_Value();
}