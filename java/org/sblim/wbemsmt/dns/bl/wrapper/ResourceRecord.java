 /** 
  * ResourceRecord.java
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
  * Description: wrapper for ResourceRecord
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecordsForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecordsForZoneHelper;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ObjectDeletionException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.util.StringTokenizer;

public class ResourceRecord extends DnsBusinessObject {


	static Logger logger = Logger.getLogger(ResourceRecord.class.getName());

	public static final String TYPE_A = "A";
	public static final String TYPE_MX = "MX";
	public static final String TYPE_NS = "NS";
	public static final String TYPE_PTR = "PTR";
	public static final String TYPE_CNAME = "CNAME";
	public static final String TYPE_UNKNOWN = "Unknown";

	public final static String[] TYPES = {"Unknown","A","AAAA","A6","AFSDB","APL","CERT","CNAME","DNAME","GPOS","HINFO","ISDN","KEY","KX","LOC","MX","NAPTR","NSAP","NS","NXT","PTR","PX","RP","RT","SIG","SRV","TXT","WKS","X25"};
	
	
	protected final Zone parent;
	private Linux_DnsResourceRecord fco;

	private boolean usedInWizard = false;
	private boolean deleted = false;

	/**
	 * 
	 */
	public ResourceRecord(Zone parent, Linux_DnsResourceRecord resourceRecord, DnsCimAdapter adapter) {
		super(adapter);
		this.parent = parent;
		this.fco = resourceRecord;
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(fco.getCimObjectPath());
	}

	/**
	 * Get the wrapped fco
	 * @return
	 */
	public Linux_DnsResourceRecord getFco() {
		return fco;
	}
	
	public void setFco(Linux_DnsResourceRecord fco) {
		this.fco = fco;
	}

	public boolean equals(String name, String type, String value) {
		return fco.get_Name().equals(name) && fco.get_Type().equals(type) && fco.get_Value().equals(value);
	}

	public MessageList save(DnsResourceRecordDataContainer container) throws ObjectSaveException {
		String name = (String) container.get_Name().getConvertedControlValue();
		String type = ResourceRecord.getTypeOfIndex((UnsignedInt16) container.get_Type());
		String value = (String) container.get_Value().getConvertedControlValue();
		UnsignedInt8 family = (UnsignedInt8) container.get_Family().getConvertedControlValue();

		save(name,type,value,family);
		
		fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
		fco = (Linux_DnsResourceRecord) FcoHelper.save(fco,container.getAdapter().getCimClient());
		return null;	
	}

	public MessageList save(DnsResourceRecordListItemContainer container, boolean firstInFamilyIsNull) throws ObjectSaveException {
		
		String name = (String) container.get_Name().getConvertedControlValue();
		String type = ResourceRecord.getTypeOfIndex((UnsignedInt16) container.get_Type().getConvertedControlValue());
		String value = (String) container.get_Value().getConvertedControlValue();
		UnsignedInt8 family;
		if (!firstInFamilyIsNull)
		{
			family = (UnsignedInt8) container.get_Family().getConvertedControlValue();
		}
		else
		{
			family = (UnsignedInt8) container.get_Family().getConvertedControlValue();
			if (family.intValue() == 0)
			{
				family = null;
			}
			else
			{
				family = new UnsignedInt8((short)(family.shortValue()-1));
			}
		}

		save(name,type,value,family);

		fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
		fco = (Linux_DnsResourceRecord) FcoHelper.save(fco,container.getAdapter().getCimClient());
		return null;	
	}
	
	/**
	 * 
	 * @param name
	 * @param type
	 * @param value
	 * @param family
	 * @return true if the key attributes where changed and the old resourcerecord was deleted and the new was created
	 * @throws ObjectSaveException
	 */
	public boolean save(String name, String type, String value, UnsignedInt8 family) throws ObjectSaveException
	{
		
		if (!fco.get_Name().equals(name)
			|| !fco.get_Type().equals(type)
			|| !fco.get_Value().equals(value)
		)
		//delete the old resource record and create a new one
		{
			try {
				//delete the old resource record
				parent.getResourceRecords().deleteResourceRecord(this);
				delete();
				//create the new abd reuse the old record object
				fco = ((DnsBusinessObject)parent).createResourceRecord(parent.getLinux_DnsZone(), name, type, family, value);
				setFco(fco);
				setDeleted(false);
				parent.getResourceRecords().addResourceRecord(this);
				parent.getResourceRecords().reloadListValues();
				adapter.setMarkedForReload();
				
			} catch (Exception e) {
				throw new ObjectSaveException(e);
			}
			return true;
		}
		else
		{
			//just update the fco - the save is done later5
			fco.set_Family(family);
			return false;
		}
	}

	public void updateControls(DnsResourceRecordDataContainer container) {
		
		container.get_Name().setControlValue(fco.get_Name());
		updateTTLDataContainer(adapter,fco.get_TTL(), container);
		container.get_Type().setControlValue(ResourceRecord.getIndexByTypeName(fco.get_Type()));
		container.get_Family().setControlValue(fco.get_Family());
		
		boolean isMx = fco.get_Type().equals(ResourceRecord.TYPE_MX);
		container.get_Priority().getProperties().setVisible(isMx);
		
		if (isMx)
		{
			String[] values = new StringTokenizer(fco.get_Value()," ").asArray(true,false);
			if (values.length == 2)
			{
				container.get_Value().setControlValue(values[0]);
				container.get_Priority().setControlValue(values[1]);
			}
			else
			{
				logger.warning("Value for mx resource record " + fco + "should contain two strings as value separated by a space");
				container.get_Value().setControlValue(fco.get_Value());
			}
		}
		else
		{
			container.get_Value().setControlValue(fco.get_Value());
		}
		
		container.setKey(new CimObjectKey(fco));
		
	}

	public boolean isUsedInWizard() {
		return usedInWizard;
	}

	public void setUsedInWizard(boolean usedInWizard) {
		this.usedInWizard = usedInWizard;
	}

	public void delete() throws ObjectDeletionException
	{
		FcoHelper.delete(fco,adapter.getCimClient(),true);
		deleted = true;
		
		if (DnsCimAdapter.DUMMY_MODE)
		{
			try {
				String fcoPath = fco.getCimObjectPath().toString();
				ArrayList list = Linux_DnsResourceRecordsForZoneHelper.enumerateInstanceNames(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					CIMObjectPath path = (CIMObjectPath) iter.next();
					
					String resourceRecordPath = path.getKey(Linux_DnsResourceRecordsForZone.CIM_PROPERTY_LINUX_DNSRESOURCERECORD).getValue().getValue().toString(); 
					
					if (resourceRecordPath.equals(fcoPath))
					{
						Linux_DnsResourceRecordsForZone assoc = (Linux_DnsResourceRecordsForZone) FcoHelper.reload(Linux_DnsResourceRecordsForZoneHelper.class,path,adapter.getCimClient());
						FcoHelper.delete(assoc,adapter.getCimClient());
						return;
					}
				}
				throw new ObjectDeletionException("Resource Record " + fco + " was not deleted, becaue the record was not found",fco);
			} catch (ModelLoadException e) {
				throw new ObjectDeletionException(e);
			}
		}
		
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void updateModel(DnsResourceRecordDataContainer container) {
		
		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			fco.set_TTL(null);
		}
		
	}
	
	public static UnsignedInt16 getIndexByTypeName(String name)
	{
		for (int i = 0; i < TYPES.length; i++) {
			String type = TYPES[i];
			if (type.equalsIgnoreCase(name))
			{
				return new UnsignedInt16(i);
			}
		}
		
		logger.warning("ResourceRecord-Type " + name + " is not supported."); 
		return null;
	}
	
	public static String getTypeOfIndex(UnsignedInt16 index)
	{
		if (index != null)
		{
			return TYPES[index.intValue()];
		}
		return null;
	}

	public static String checkTypeIsValid(DataContainer container, String type) {
		for (int i = 0; i < TYPES.length; i++) {
			String type1 = TYPES[i];
			if (type1.equalsIgnoreCase(type))
			{
				return type;
			}
		}
		logger.warning("ResourceRecord-Type " + type + " is not supported.");
		MessageList.init(container).addWarning(container.getAdapter().getBundle().getString("record.type.not.supported",new Object[]{type}));
		return TYPE_UNKNOWN; 
	}
	

}
