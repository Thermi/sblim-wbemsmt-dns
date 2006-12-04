 /** 
  * ResourceRecordList.java
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
  * Description: List of resource records
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper.list;

import java.util.Iterator;
import java.util.List;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.wrapper.ObjectList;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * @see org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord
 */

public class ResourceRecordList extends ObjectList  {

	public ResourceRecord getResourceRecord(CimObjectKey key)
	{
		return (ResourceRecord)objectsByCimObjectKey.get(key);
	}
	
	public ResourceRecord getResourceRecord(CIMObjectPath path)
	{
		return getResourceRecord(new CimObjectKey(path));
	}

	public ResourceRecord getResourceRecord(CIM_ManagedElement element)
	{
		return getResourceRecord(new CimObjectKey(element.getCimObjectPath()));
	}

	public void addResourceRecord(ResourceRecord rr)
	{
		objectsByCimObjectKey.put(rr.getCimObjectKey(),rr);
	}
	
	protected String getKey(Object value) {
		ResourceRecord rr = (ResourceRecord) value;
		return rr.getFco().get_Name();
	}
	
	protected Object getFco(Object value) {
		ResourceRecord rr = (ResourceRecord) value;
		return rr.getFco();
	}

	public ResourceRecord getResourceRecord(int i) {
		return (ResourceRecord) getList().get(i);
	}
	
	public ResourceRecordList getResourceRecordsForWizard(boolean used)
	{
		List allRecords = getList();
		ResourceRecordList result = new ResourceRecordList();
		for (Iterator iter = allRecords.iterator(); iter.hasNext();) {
			ResourceRecord rr = (ResourceRecord) iter.next();
			if (!rr.isDeleted() && rr.isUsedInWizard() == used)
			{
				result.addResourceRecord(rr);
			}
		}
		return result;
	}

	public void addAll(ResourceRecordList resourceRecords) {
		for (int i=0; i < resourceRecords.size();i++)
		{
			addResourceRecord(resourceRecords.getResourceRecord(i));
		}
		
	}

	/**
	 * Gets the used/not ResourceRecord on position idx for the reverseZone Wizard 
	 * @param index
	 * @param used
	 * @return
	 */
	public ResourceRecord getResourceRecordForReverseZoneWizard(int index, boolean used) {
		int foundIdx = -1;
		
		for (int ii=0; ii < size(); ii++)
		{
			if (getResourceRecord(ii).isUsedInWizard() == used)
			{
				foundIdx++;
			}
			if (foundIdx == index)
			{
				return getResourceRecord(ii);
			}
		}
		
		return null;
	}


	public ResourceRecordList getResourceRecordsByType(int type) {
		return getResourceRecordsByType("" + type);
	}
	
	public ResourceRecordList getResourceRecordsByType(String type) {

		ResourceRecordList result = new ResourceRecordList();
		
		for (int ii=0; ii < size(); ii++)
		{
			if (getResourceRecord(ii).getFco().get_Type().equals(type))
			{
				result.addResourceRecord(getResourceRecord(ii));
			}
		}
		return result;
	}

	public ResourceRecordList getResourceRecordsDeleted(boolean deleted) {
		List allRecords = getList();
		ResourceRecordList result = new ResourceRecordList();
		for (Iterator iter = allRecords.iterator(); iter.hasNext();) {
			ResourceRecord rr = (ResourceRecord) iter.next();
			if (rr.isDeleted() == deleted)
			{
				result.addResourceRecord(rr);
			}
		}
		return result;
	}

	public void deleteResourceRecord(ResourceRecord record) {
		objectsByCimObjectKey.remove(new CimObjectKey(record.getFco()));
		reloadListValues();
	}

}
