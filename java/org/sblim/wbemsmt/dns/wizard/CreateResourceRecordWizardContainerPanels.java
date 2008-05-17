/** 
 * CreateResourceRecordWizardContainerPanels.java
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
 * @author: org.sblim.wbemsmt.dcg.generator.WizardGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/wizardContainerPanels.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: Panels for 
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.wizard;

import org.sblim.wbemsmt.exception.WbemsmtException;

public interface CreateResourceRecordWizardContainerPanels {

    public Object getMain() throws WbemsmtException;

    public Object getOverview() throws WbemsmtException;

    public Object getTypeMx() throws WbemsmtException;

    public Object getTypeOther() throws WbemsmtException;

}