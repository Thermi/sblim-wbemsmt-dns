/** 
  * CreateStubZoneWizardContainerPanels.java
  *

 
 * (C) Copyright IBM Corp. 2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE COMMON PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Common Public License from
  * http://www.opensource.org/licenses/cpl1.0.php
  *
  * @author: org.sblim.wbemsmt.dcg.generator.WizardGenerator
  * @template: ./tools-dcg/templates/wizardContainerPanels.vm
  *
  * Contributors: 
  * 
  * Description: Panels for Wizard for StubZones
  * 
  * generated Class
  */

package org.sblim.wbemsmt.dns.wizard;

import org.sblim.wbemsmt.exception.WbemSmtException;

public interface CreateStubZoneWizardContainerPanels {

            					public Object getMain() throws WbemSmtException;
            					public Object getOverview() throws WbemSmtException;
            	
}