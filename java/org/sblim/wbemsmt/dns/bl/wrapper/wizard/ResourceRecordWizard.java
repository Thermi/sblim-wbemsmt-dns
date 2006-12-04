 /** 
  * ResourceRecordWizard.java
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
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: Wrapper for creating ResourceRecords
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeMxDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardPage2TypeOtherDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.dns.wizard.CreateResourceRecordWizardContainer;
import org.sblim.wbemsmt.exception.InitWizardException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;

public class ResourceRecordWizard extends DnsWizard {

	private DnsResourceRecordWizardPage1DataContainer page1;
	private DnsResourceRecordWizardPage2TypeMxDataContainer page2mx;
	private DnsResourceRecordWizardPage2TypeOtherDataContainer page2other;
	private LabeledBaseInputComponentIf valueField;
	private LabeledBaseInputComponentIf priorityField;
	/**
	 * @param adapter
	 */
	public ResourceRecordWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	public void create(DnsResourceRecordWizardSummaryDataContainer container) throws ObjectSaveException {

		String value;
		if (ResourceRecord.TYPE_MX.equals(ResourceRecord.getTypeOfIndex((UnsignedInt16) page1.get_usr_Type().getConvertedControlValue()) ))
		{
			value = page2mx.get_usr_Priority().getConvertedControlValue() + " " + page2mx.get_usr_Value().getConvertedControlValue();
		}
		else
		{
			value = (String) page2other.get_usr_Value().getConvertedControlValue();
		}
		
		Linux_DnsResourceRecord record = super.createResourceRecord(adapter.getSelectedZone().getLinux_DnsZone(),
								   (String) page1.get_usr_Name().getConvertedControlValue(),
								   ResourceRecord.getTypeOfIndex((UnsignedInt16) page1.get_usr_Type().getConvertedControlValue()),
								   new UnsignedInt8((short)Linux_DnsResourceRecord.FAMILY_INTERNET),
								   value);

		container.setKey(new CimObjectKey(record));
		
		adapter.setMarkedForReload();
	}

	public LabeledBaseInputComponentIf getNameField() {
		return page1.get_usr_Name();
	}

	public LabeledBaseInputComponentIf getTypeField() {
		return page1.get_usr_Type();
	}

	public LabeledBaseInputComponentIf getValueField() {
		return valueField;
	}

	public LabeledBaseInputComponentIf getPriorityField() {
		return priorityField;
	}

	public void updateControls(DnsResourceRecordWizardPage1DataContainer container) {
		this.page1 = container;
		container.get_usr_Type().setValues(ResourceRecord.TYPES);
	}

	public void updateControls(DnsResourceRecordWizardSummaryDataContainer container) {

		container.get_usr_Name().setControlValue(page1.get_usr_Name().getConvertedControlValue());
		container.get_usr_Type().setControlValue(ResourceRecord.getTypeOfIndex((UnsignedInt16) page1.get_usr_Type().getConvertedControlValue()));

		container.get_usr_Value().setControlValue(valueField.getConvertedControlValue());
		boolean isMx = ResourceRecord.TYPE_MX.equals(page1.get_usr_Type().getConvertedControlValue());
		
		container.get_usr_Priority().getProperties().setVisible(isMx);
		if (isMx)
		{
			container.get_usr_Priority().setControlValue(priorityField.getConvertedControlValue());
		}
		
	}

	public void updateControls(DnsResourceRecordWizardPage2TypeMxDataContainer container) {
		page2mx = container;
		valueField = container.get_usr_Value();
		priorityField = container.get_usr_Priority();
	}

	public void updateControls(DnsResourceRecordWizardPage2TypeOtherDataContainer container) {
		page2other = container;
		valueField = container.get_usr_Value();
	}

	public void updateModel(DnsResourceRecordWizardPage1DataContainer container) {
	}

	public void updateModel(DnsResourceRecordWizardPage2TypeOtherDataContainer container) {
		//do nothing
	}

	public void updateModel(DnsResourceRecordWizardPage2TypeMxDataContainer container) {
		//do nothing
	}

	public void init(DnsResourceRecordWizardPage1DataContainer container, CreateResourceRecordWizardContainer wizardContainer) throws InitWizardException {
		try {
			container.get_usr_Type().setControlValue(null);
			container.get_usr_Name().setControlValue("");
			DnsResourceRecordWizardPage2TypeMxDataContainer mx = (DnsResourceRecordWizardPage2TypeMxDataContainer) wizardContainer.getPage(CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEMX);
			if (mx != null)
			{
				mx.get_usr_Priority().setControlValue("");
				mx.get_usr_Value().setControlValue("");
			}
			DnsResourceRecordWizardPage2TypeOtherDataContainer other = (DnsResourceRecordWizardPage2TypeOtherDataContainer) wizardContainer.getPage(CreateResourceRecordWizardContainer.WIZARD_PANEL_TYPEOTHER);
			if (other != null)
			{
				other.get_usr_Value().setControlValue("");
			}
		} catch (WbemSmtException e) {
			throw new InitWizardException(e);
		}
	}

}
