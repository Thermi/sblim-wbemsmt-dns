 /** 
  * ResourceRecord.java
  *
  * © Copyright IBM Corp.  2009,2005
  *
  * THIS FILE IS PROVIDED UNDER THE TERMS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: Michael Bauschert <Michael.Bauschert@de.ibm.com>
  *
  * Contributors: 
  * 
  * Description: wrapper for ResourceRecord
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.cim.UnsignedInteger16;
import javax.cim.UnsignedInteger8;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.messages.Message;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecordsForZone;
import org.sblim.wbemsmt.exception.WbemsmtException;
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
		return fco.get_key_Name().equals(name) && fco.get_key_Type().equals(type) && fco.get_key_Value().equals(value);
	}

	public MessageList save(DnsResourceRecordDataContainer container) throws WbemsmtException {
		String name = (String) container.get_Name().getConvertedControlValue();
		String type = ResourceRecord.getTypeOfIndex((UnsignedInteger16) container.get_Type().getConvertedControlValue());
		String value = (String) container.get_Value().getConvertedControlValue();
		UnsignedInteger8 family = (UnsignedInteger8) container.get_Family().getConvertedControlValue();

		save(name,type,value,family);
		
		fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
		fco = (Linux_DnsResourceRecord) adapter.getFcoHelper().save(fco,container.getAdapter().getCimClient());
		return null;	
	}

	public MessageList save(DnsResourceRecordListItemContainer container, boolean firstInFamilyIsNull) throws WbemsmtException {
		
		String name = (String) container.get_Name().getConvertedControlValue();
		String type = ResourceRecord.getTypeOfIndex((UnsignedInteger16) container.get_Type().getConvertedControlValue());
		String value = (String) container.get_Value().getConvertedControlValue();
		UnsignedInteger8 family;
		if (!firstInFamilyIsNull)
		{
			family = (UnsignedInteger8) container.get_Family().getConvertedControlValue();
		}
		else
		{
			family = (UnsignedInteger8) container.get_Family().getConvertedControlValue();
			if (family.intValue() == 0)
			{
				family = null;
			}
			else
			{
				family = new UnsignedInteger8((short)(family.shortValue()-1));
			}
		}

		save(name,type,value,family);

		fco.set_TTL(getTTLAsInteger(container,fco.get_TTL()));
		fco = (Linux_DnsResourceRecord) adapter.getFcoHelper().save(fco,container.getAdapter().getCimClient());
		return null;	
	}
	
	/**
	 * 
	 * @param name
	 * @param type
	 * @param value
	 * @param family
	 * @return true if the key attributes where changed and the old resourcerecord was deleted and the new was created
	 * @throws WbemsmtException
	 */
	public boolean save(String name, String type, String value, UnsignedInteger8 family) throws WbemsmtException
	{
		
		if (!fco.get_key_Name().equals(name)
			|| !fco.get_key_Type().equals(type)
			|| !fco.get_key_Value().equals(value)
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
			} catch (Exception e) {
				throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,e);
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
		
		container.get_Name().setControlValue(fco.get_key_Name());
		updateTTLDataContainer(adapter,fco.get_TTL(), container);
		container.get_Type().setControlValue(ResourceRecord.getIndexByTypeName(fco.get_key_Type()));
		container.get_Family().setControlValue(fco.get_Family());
		
		boolean isMx = fco.get_key_Type().equals(ResourceRecord.TYPE_MX);
		container.get_Priority().getProperties().setVisible(isMx);
		
		if (isMx)
		{
			String[] values = new StringTokenizer(fco.get_key_Value()," ").asArray(true,false);
			if (values.length == 2)
			{
				container.get_Value().setControlValue(values[0]);
				container.get_Priority().setControlValue(values[1]);
			}
			else
			{
				logger.warning("Value for mx resource record " + fco + "should contain two strings as value separated by a space");
				container.get_Value().setControlValue(fco.get_key_Value());
			}
		}
		else
		{
			container.get_Value().setControlValue(fco.get_key_Value());
		}
		
		container.setKey(new CimObjectKey(fco.getCimObjectPath()));
		
	}

	public boolean isUsedInWizard() {
		return usedInWizard;
	}

	public void setUsedInWizard(boolean usedInWizard) {
		this.usedInWizard = usedInWizard;
	}

	public void delete() throws WbemsmtException
	{
		adapter.getFcoHelper().delete(fco,adapter.getCimClient(),true);
        if (DnsCimAdapter.DUMMY_MODE)
        {
            String fcoPath = fco.getCimObjectPath().toString();
            List<Linux_DnsResourceRecordsForZone> list = fco.getAssociations_Linux_DnsResourceRecordsForZone(adapter.getCimClient(), false, false, null, null);
            for (Iterator<Linux_DnsResourceRecordsForZone> iter = list.iterator(); iter.hasNext();) {
                Linux_DnsResourceRecordsForZone assoc = (Linux_DnsResourceRecordsForZone) iter.next();
                adapter.getFcoHelper().delete(assoc,adapter.getCimClient());
            }
        }

        deleted = true;
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
	
	public static UnsignedInteger16 getIndexByTypeName(String name)
	{
		for (int i = 0; i < TYPES.length; i++) {
			String type = TYPES[i];
			if (type.equalsIgnoreCase(name))
			{
				return new UnsignedInteger16(i);
			}
		}
		
		logger.warning("ResourceRecord-Type " + name + " is not supported."); 
		return null;
	}
	
	public static String getTypeOfIndex(UnsignedInteger16 index)
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
		String msg = container.getAdapter().getBundle().getString(DnsErrCodes.MSG_RECORD_TYPE_NOT_SUPPORTED,"record.type.not.supported",new Object[]{type});
		MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_RECORD_TYPE_NOT_SUPPORTED,Message.WARNING, msg));
		
		return TYPE_UNKNOWN; 
	}

	public MessageList revert(DnsResourceRecordDataContainer container) throws WbemsmtException {
		fco = (Linux_DnsResourceRecord) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}
	

}
