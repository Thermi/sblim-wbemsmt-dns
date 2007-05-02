 /** 
  * ReverseZoneWizard.java
  *
  * © Copyright IBM Corp. 2005
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
  * Description: Wrapper for creating ReverseZones
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.wizard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsMasterZoneDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsResourceRecordForReverseZoneWizardDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsReverseZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecordsForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;
import org.sblim.wbemsmt.util.StringTokenizer;

public class ReverseZoneWizard extends DnsWizard {

	List createdRecords = new ArrayList();
	private DnsReverseZoneWizardPage1DataContainer page1;
	private String zoneName;
	private String zoneFilename;
	private String ipPrefix;
	private String[] ipArray;
	private String ipAddress = "";
	
	/**
	 * @param adapter
	 */
	public ReverseZoneWizard(DnsCimAdapter adapter) {
		super(adapter);
	}

	public void updateControls(DnsReverseZoneWizardPage1DataContainer container) {
		this.page1 = container;
		ResourceRecordList resourceRecords = adapter.getSelectedZone().getResourceRecords();
		container.get_usr_ResourceRecordUsed().setValues(resourceRecords.getResourceRecordsForWizard(true).getNameArray());
		container.get_usr_ResourceRecordNotUsed().setValues(resourceRecords.getResourceRecordsForWizard(false).getNameArray());
		
		ResourceRecordList a_Records = resourceRecords.getResourceRecordsByType(ResourceRecord.TYPE_A);
		
		ipArray = new String[a_Records.size()];
		for (int i=0; i < a_Records.size(); i++)
		{
			ipArray[i] = a_Records.getResourceRecord(i).getFco().get_Value();
		}
		
		container.get_usr_IpPresets().setValues(ipArray);
		if (ipArray.length == 1 && ipAddress.equals(""))
		{
			ipAddress = ipArray[0];
		}
		container.get_usr_IpAddress().setControlValue(ipAddress);
	}

	public void updateControls(DnsReverseZoneWizardSummaryDataContainer container) throws UpdateControlsException {
		
		container.get_usr_Name().setControlValue(zoneName);
		container.get_ResourceRecordFile().setControlValue(zoneFilename);
		adapter.updateControls(container.getResourceRecords(),createdRecords);
	}

	public void updateControls(DnsMasterZoneDataContainer container, Linux_DnsMasterZone fco) throws UpdateControlsException {
		try {
			adapter.getDnsService().getMasterZoneList().getMasterZone(fco.getCimObjectPath()).updateControls(container);
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	public void updateControls(DnsResourceRecordForReverseZoneWizardDataContainer container, Linux_DnsResourceRecord fco) {
		container.get_Type().setControlValue(fco.get_Type());
		container.get_Name().setControlValue(fco.get_Name());
		container.get_Value().setControlValue(fco.get_Value());
	}


	public void updateModel(DnsReverseZoneWizardPage1DataContainer container) {
		this.page1 = container;

		ipAddress = (String) this.page1.get_usr_IpAddress().getConvertedControlValue();
		
		if (adapter.getUpdateTrigger() == container.get_usr_AddResourceRecord())
		{
			List indexList = (List) container.get_usr_ResourceRecordNotUsed().getConvertedControlValue();
			for (int i = indexList.size()-1; i >= 0; i--) {
				UnsignedInt16 idx = (UnsignedInt16) indexList.get(i);
				if (idx != null)
				{
					ResourceRecord rr = adapter.getSelectedZone().getResourceRecords().getResourceRecordForReverseZoneWizard(idx.intValue(),false);
					if (rr != null)
					{
						rr.setUsedInWizard(true);
					}
				}
			}
			container.get_usr_ResourceRecordNotUsed().setControlValue(new ArrayList());
		}
		else if (adapter.getUpdateTrigger() == container.get_usr_RemoveResourceRecord())
		{
			List indexList = (List) container.get_usr_ResourceRecordUsed().getConvertedControlValue();
			for (int i = indexList.size()-1; i >= 0; i--) {
				UnsignedInt16 idx = (UnsignedInt16) indexList.get(i);
				if (idx != null)
				{
					ResourceRecord rr = adapter.getSelectedZone().getResourceRecords().getResourceRecordForReverseZoneWizard(idx.intValue(),true);
					if (rr != null)
					{
						rr.setUsedInWizard(false);
					}
				}
			}
			container.get_usr_ResourceRecordUsed().setControlValue(new ArrayList());
		}
		else if (adapter.getUpdateTrigger() == container.get_usr_AddAllResourceRecords())
		{
			ResourceRecordList resourceRecordList = adapter.getSelectedZone().getResourceRecords();
			for ( int i=0; i < resourceRecordList.size(); i++ ) {
				ResourceRecord rr = (ResourceRecord) resourceRecordList.getResourceRecord(i);
				rr.setUsedInWizard(true);
			}
		}
		else if (adapter.getUpdateTrigger() == container.get_usr_RemoveAllResourceRecords())
		{
			ResourceRecordList resourceRecordList = adapter.getSelectedZone().getResourceRecords();
			for ( int i=0; i < resourceRecordList.size(); i++ ) {
				ResourceRecord rr = (ResourceRecord) resourceRecordList.getResourceRecord(i);
				rr.setUsedInWizard(false);
			}
		}
		else if (adapter.getUpdateTrigger() == container.get_usr_IpPresets())
		{
			if (container.get_usr_IpPresets().getConvertedControlValue() != null)
			{
				int idx = ((UnsignedInt16)container.get_usr_IpPresets().getConvertedControlValue()).intValue();
				if (idx < ipArray.length)
				{
					ipAddress = ipArray[idx];
					page1.get_usr_IpAddress().setControlValue(ipAddress); 
				}
			}
		}
		else  //next-Button
		{
			String enteredIp = (String) page1.get_usr_IpAddress().getConvertedControlValue();
			if (enteredIp.endsWith("."))
			{
				enteredIp = enteredIp.substring(0,enteredIp.length()-1);
			}
			
			String[] array = new StringTokenizer(enteredIp,".").asArray(true,false);
			StringBuffer sbName = new StringBuffer();
			StringBuffer sbFile = new StringBuffer();
			
			for (int i = 0; i < array.length; i++) {
				String ipValue = array[i];

				if (sbName.length() > 0)
				{
					sbName.insert(0,".");
					sbFile.append(".");
				}
				sbName.insert(0,ipValue);
				sbFile.append(ipValue);
			} 
			zoneName = sbName.toString() + ".in-addr.arpa";
			ipPrefix = sbFile.toString();
			zoneFilename = ipPrefix + ".rev";
			
			createdRecords.clear();
			ResourceRecordList records = adapter.getSelectedZone().getResourceRecords();
			for ( int i=0; i < records.size(); i++ ) {
				ResourceRecord rr = (ResourceRecord) records.getResourceRecord(i);
				if (rr.isUsedInWizard())
				{
					if (ResourceRecord.TYPE_A.equals(rr.getFco().get_Type())) {
						
						//get the old Ip
						String completeIp = rr.getFco().get_Value();
						//cut of the first part of the ipAddress
						String prefix = ipPrefix + ".";
						
						//should be normal this is tested by the validator
						if (completeIp.startsWith(prefix))
						{
							String lastDigits = completeIp.substring(prefix.length());
							array = new StringTokenizer(lastDigits,".").asArray(true,false);
							sbName = new StringBuffer();

							//reverse the address
							for (int ii = 0; ii < array.length; ii++) {
								String ipValue = array[ii];

								if (sbName.length() > 0)
								{
									sbName.insert(0,".");
								}
								sbName.insert(0,ipValue);
							} 
							
							Linux_DnsResourceRecord newRR = new Linux_DnsResourceRecord();
							//reversed part of the address is the name
							newRR.set_ZoneName(zoneName);
							newRR.set_Name(sbName.toString());
							//the value is the fill qualiified name
							newRR.set_Value(rr.getFco().get_Name() + "." + adapter.getSelectedZone().getName() + ".");
							newRR.set_Family(rr.getFco().get_Family());
							newRR.set_Type(ResourceRecord.TYPE_PTR);
							newRR.set_TTL(rr.getFco().get_TTL());
							createdRecords.add(newRR);
						}
						
					} else {
						Linux_DnsResourceRecord newRR = new Linux_DnsResourceRecord();
						newRR.set_ZoneName(zoneName);
						newRR.set_Name(rr.getFco().get_Name());
						newRR.set_Value(rr.getFco().get_Value());
						newRR.set_Family(rr.getFco().get_Family());
						newRR.set_Type(rr.getFco().get_Type());
						newRR.set_TTL(rr.getFco().get_TTL());
						createdRecords.add(newRR);
					}
				}
			}
		}
	}

	public void create(DnsReverseZoneWizardSummaryDataContainer container)  throws ObjectSaveException {

		Linux_DnsMasterZone zone = new Linux_DnsMasterZone();
		zone.set_Name(zoneName);
		zone.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
		zone.set_Type(new UnsignedInt8((short)Linux_DnsZone.TYPE_MASTER));
		zone.set_ZoneFile(zoneFilename);
		zone.set_SerialNumber(getInitialSerialNumber());
		
		zone = (Linux_DnsMasterZone) adapter.getFcoHelper().create(zone,adapter.getCimClient());

		if (DnsCimAdapter.DUMMY_MODE)
		{
			try {
				super.createAclAssociations(zone,adapter.getDnsService().getFco());
			} catch (ModelLoadException e) {
				throw new ObjectSaveException(e);
			}			
		}
		
		for (Iterator iter = createdRecords.iterator(); iter.hasNext();) {
			Linux_DnsResourceRecord record = (Linux_DnsResourceRecord) iter.next();
			record.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
			record = (Linux_DnsResourceRecord) adapter.getFcoHelper().create(record,adapter.getCimClient());
			
			//TODO do we need to create the association between resource records a and zones in RealMode
			if (DnsCimAdapter.DUMMY_MODE)
			{
				Vector keys = new Vector();
				keys.add(CIMPropertyBuilder.create(Linux_DnsResourceRecordsForZone.CIM_PROPERTY_LINUX_DNSZONE,zone));
				keys.add(CIMPropertyBuilder.create(Linux_DnsResourceRecordsForZone.CIM_PROPERTY_LINUX_DNSRESOURCERECORD,record));
				adapter.getFcoHelper().create(Linux_DnsResourceRecordsForZone.class,adapter.getCimClient(),keys);
			}
		}
		
		createForwarders(zone);
		
		adapter.setMarkedForReload();
		adapter.setPathOfTreeNode(zone.getCimObjectPath());

	}
	

	public List getCreatedRecords() {
		return createdRecords;
	}

	public void init() {
		ResourceRecordList resourceRecords = adapter.getSelectedZone().getResourceRecords();
		for (int i=0; i < resourceRecords.size(); i++)
		{
			resourceRecords.getResourceRecord(i).setUsedInWizard(false);
		}
		zoneName = "";
		zoneFilename = "";
		ipPrefix = "";
		ipAddress = "";
	}
	
	
	
}
