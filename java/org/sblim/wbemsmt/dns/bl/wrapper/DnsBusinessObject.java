 /** 
  * DnsBusinessObject.java
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
  * Description: Base class for objects wrapping dns business objects and their actions
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.text.*;
import java.util.*;

import javax.cim.UnsignedInteger16;
import javax.cim.UnsignedInteger32;
import javax.cim.UnsignedInteger8;

import org.apache.commons.lang.StringUtils;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.AbstractWbemsmtFco;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.*;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.dns.bl.resourcerecord.ResourceRecordHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf;
import org.sblim.wbemsmt.tools.resources.LocaleChangeListener;
import org.sblim.wbemsmt.tools.validator.IpAddressFieldValidator;

public abstract class DnsBusinessObject extends DnsObject {

	public abstract CimObjectKey getCimObjectKey() throws WbemsmtException;
	protected ResourceRecordHandler resourceRecordHandler;

	/**
	 * true if the object is having forward ip addresses
	 */
	protected boolean forwarderExists;
	
	/**
	 * true if the forward attribute is unknown
	 */
	protected boolean unknownForwarder = false;
	
	
	private static final DateFormat FORMAT_FOR_SERIAL_NUMBER = new SimpleDateFormat("yyyyMMdd");
	private static final NumberFormat FORMAT_FOR_SERIAL_NUMBER_VERSION = new DecimalFormat("##00");
	
	public DnsBusinessObject(DnsCimAdapter adapter)
	{
		super(adapter);
	}
	
	final static Map MULTIPLIERS = new HashMap();
	static
	{
		MULTIPLIERS.put("S",new Integer(1));
		MULTIPLIERS.put("M",new Integer(60));
		MULTIPLIERS.put("H",new Integer(60*60));
		MULTIPLIERS.put("D",new Integer(60*60*24));
	}

	final static Map ALLOWED_DECIMALS = new HashMap();
	static
	{
		ALLOWED_DECIMALS.put("S",new Integer(0));
		ALLOWED_DECIMALS.put("M",new Integer(1));
		ALLOWED_DECIMALS.put("H",new Integer(2));
		ALLOWED_DECIMALS.put("D",new Integer(2));
	}
	
	final static String[] MULTI_TEST_ORDER = new String[]{"D","H","M","S"};
	public final static String[] MULTI_COMBO_VALUES = new String[]{"S","M","H","D"};
	
	
	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco)  throws WbemsmtException {
		container.get_Family().setValues(Linux_DnsResourceRecord.PROPERTY_FAMILY.VALUE_ENTRIES_FOR_DISPLAY);
		container.get_Family().setControlValue(fco.get_Family());
		
		container.get_Type().setControlValue(ResourceRecord.getIndexByTypeName(fco.get_key_Type()));
		
		container.get_Name().setControlValue(fco.get_key_Name());
		container.get_TTL().setControlValue(new Double(fco.get_TTL() != null ? fco.get_TTL().doubleValue() : 0));
		container.get_Value().setControlValue(fco.get_key_Value());
	}

	protected String[] getForwarders(ForwarderList forwarderList) throws WbemsmtException {
        String[] result = forwarderList.getNameArray();
        if (result.length > 0)
        {
        	forwarderExists = true;
        }
        return result;
	}

	protected void updateForwarders(ForwarderList forwarderList, DnsForwarderDataContainer container, LabeledBaseInputComponentIf useGlobalButton) throws WbemsmtException {
		if (adapter.getUpdateTrigger() == container.get_usr_AddForwarder())
        {
        	String newForwarder = (String) container.get_usr_NewForwarder().getConvertedControlValue();
        	if (StringUtils.isNotEmpty(newForwarder))
        	{
        		IpAddressFieldValidator validator = new IpAddressFieldValidator(container.get_usr_NewForwarder(),adapter);
        		MessageList list = new MessageList();
        		list = validator.validate();
        		if (!list.hasErrors())
        		{
        			if (forwarderList.getForwarderOnClientByName(newForwarder) == null)
        			{
        				forwarderList.addForwarder(new Forwarder(newForwarder,Linux_DnsForwarders.PROPERTY_FORWARDERSELEMENTTYPE.VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_IPv4,adapter,false,true));
        				container.get_Forwarders().setModified(true);
        				forwarderExists = true;
        			}
        			else
        			{
        				list = MessageList.init(container);
        				list.addMessage(Message.create(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_FWD,Message.WARNING, adapter.getBundle(),"value.not.added.to.forwarder",new Object[]{newForwarder}));
        			}
        			container.get_usr_NewForwarder().setControlValue("");
        		}
        		if (MessageList.init(container) != list)
        		{
        			MessageList.init(container).addAll(list);
        		}
        	}
        }
        else if (adapter.getUpdateTrigger() == container.get_usr_RemoveForwarder())
        {
        	List indexList = (List) container.get_Forwarders().getConvertedControlValue();
        	for (int i = indexList.size() - 1; i >= 0; i--) {
        		UnsignedInteger16 index = (UnsignedInteger16) indexList.get(i);
        		forwarderList.getForwarderOnClient(index.intValue()).setExistsOnClient(false);
        		container.get_Forwarders().setModified(true);
        	}
        	forwarderList.removeIfNotExistsOnClient();
        }
        else if (useGlobalButton != null && adapter.getUpdateTrigger() == useGlobalButton)
        {
            for (int i = forwarderList.size() - 1; i >= 0; i--) {
            	forwarderList.getForwarder(i).setExistsOnClient(false);
            }
        	forwarderList.removeIfNotExistsOnClient();
        	forwarderExists = false;
        	container.get_Forwarders().setModified(true);
        }
	}


	public static UnsignedInteger16 getTTLAsUnsignedInteger16(DnsTTLDataContainer dataContainer, Number oldValue) {
		//the range of the 16bit values is checked by the validators
		Integer integer = getTTLAsInteger(dataContainer,oldValue);
		return new UnsignedInteger16(integer.intValue());
	}

	public static Integer getTTLAsUnsignedInteger32(DnsTTLDataContainer dataContainer, Number oldValue) {
		return getTTLASInteger(dataContainer,oldValue);
	}

	public static Integer getTTLASInteger(DnsTTLDataContainer dataContainer,Number oldValue) {
		return getTTLAsInteger(dataContainer,oldValue);
	}

	public static Integer getTTLAsInteger(DnsTTLDataContainer dataContainer, Number oldValue) {
		
		UnsignedInteger16 index = (UnsignedInteger16) dataContainer.get_usr_TTLUnit().getConvertedControlValue();
		if (index == null)
		{
			index = new UnsignedInteger16(0);
		}
		
		return getTTLAsInteger(
				dataContainer, dataContainer.get_TTL(),
				(String) dataContainer.get_TTL().getConvertedControlValue(),
				MULTI_COMBO_VALUES[index.intValue()], oldValue
				);
	}
	
	public static Integer getTTLAsUnsignedInteger32(DnsResourceRecordListItemContainer dataContainer, Integer oldValue) {
		return getTTLAsInteger(dataContainer,oldValue);
	}

	public static Integer getTTLAsInteger(DnsResourceRecordListItemContainer dataContainer, Integer oldValue) {
		
		UnsignedInteger16 index = (UnsignedInteger16) dataContainer.get_usr_TTLUnit().getConvertedControlValue();
		if (index == null)
		{
			index = new UnsignedInteger16(0);
		}
		
		return getTTLAsInteger(
				dataContainer,dataContainer.get_TTL(),
				(String) dataContainer.get_TTL().getConvertedControlValue(),
				MULTI_COMBO_VALUES[index.intValue()], oldValue
				);
	}

	public static UnsignedInteger32 getTTLAsUnsignedInteger32(DnsSoaContainer dataContainer, Long oldValue) {
		Integer integer = getTTLAsInteger(dataContainer,oldValue);
		return new UnsignedInteger32(integer.intValue());
	}
	
	public static Integer getTTLAsInteger(DnsSoaContainer dataContainer, Long oldValue) {
		
		UnsignedInteger16 index = (UnsignedInteger16) dataContainer.get_usr_TTLUnit().getConvertedControlValue();
		if (index == null)
		{
			index = new UnsignedInteger16(0);
		}
		
		return getTTLAsInteger(
				dataContainer, dataContainer.get_NegativeCachingTTL(),
				(String) dataContainer.get_NegativeCachingTTL().getConvertedControlValue(),
				MULTI_COMBO_VALUES[index.intValue()], oldValue
				);	
	}

	/**
	 * 
	 * @param containerWithTTL
	 * @param ttlField
	 * @param ttl
	 * @param multiplierString
	 * @param oldValue
	 * @return if the value can be converted, the integer representation is return otherwise the old value is returned,
	 */
	public static Integer getTTLAsInteger(DataContainer containerWithTTL, LabeledBaseInputComponentIf ttlField, String ttl,String multiplierString, Number oldValue) {
		//get the multiplier
		Integer multiplier = null;
		if (StringUtils.isAlpha(multiplierString))
		{
			multiplier = (Integer) MULTIPLIERS.get(multiplierString);
			if (multiplier == null)
			{
				multiplier = new Integer(1);
			}
		}
		else
		{
			multiplier = new Integer(1);
		}

		
		if (ttl == null || ttl.equals(DnsCimAdapter.NOT_SET))
		{
			return null;
		}
		else
		{
			//multiply
			ttl = ttl.replaceAll(",", ".");
			try {
				return new Integer((int)(multiplier.intValue() * Double.parseDouble(ttl)));
			} catch (NumberFormatException e) {
				return oldValue != null ? new Integer(oldValue.intValue()) : null;
			}
		}
		
	}

	protected void updateTTLDataContainer(DnsCimAdapter adapter, Integer ttl, DnsTTLDataContainer container) {
		updateTTLDataContainer(adapter,ttl != null ? new Double(ttl.doubleValue()) : null,container.get_TTL(),container.get_usr_TTLUnit());
	}

	public static void updateTTLDataContainer(final DnsCimAdapter adapter, UnsignedInteger32 ttl, final DnsTTLDataContainer container) {
		updateTTLDataContainer(adapter,ttl != null ? new Double(ttl.doubleValue()) : null,container.get_TTL(),container.get_usr_TTLUnit());
	}

	public static void updateTTLDataContainer(final DnsCimAdapter adapter, Double ttl, final DnsTTLDataContainer container) {
		updateTTLDataContainer(adapter,ttl,container.get_TTL(),container.get_usr_TTLUnit());
	}
	
	public static void updateTTLDataContainer(final DnsCimAdapter adapter, Integer ttl, LabeledBaseInputComponentIf ttlField, final LabeledStringArrayInputComponentIf unitField) {
		updateTTLDataContainer(adapter, ttl != null ? new Double(ttl.doubleValue()) : null, ttlField,unitField);
	}
	
	public static void updateTTLDataContainer(final DnsCimAdapter adapter, UnsignedInteger32 ttl, LabeledBaseInputComponentIf ttlField, final LabeledStringArrayInputComponentIf unitField) {
		updateTTLDataContainer(adapter, ttl != null ? new Double(ttl.doubleValue()) : null, ttlField,unitField);
	}

	private static void updateTTLDataContainer(final DnsCimAdapter adapter, Double ttl, LabeledBaseInputComponentIf ttlField, final LabeledStringArrayInputComponentIf unitField) {
		
		initTTLUnitValues(unitField,adapter);
		adapter.addLocaleChangeListener(new LocaleChangeListener()
		{
			public void localeChanged(Locale newLocale) {
				initTTLUnitValues(unitField,adapter);
			}
		});
		
		if (ttl != null)
		{
			long value = ttl.longValue();
			
			boolean ready = false;
			int factor=1;
			
			String multiCharacter = "";
			for (int i = 0; i < MULTI_TEST_ORDER.length && ! ready; i++) {
				multiCharacter = MULTI_TEST_ORDER[i];
				factor = ((Integer) MULTIPLIERS.get(multiCharacter)).intValue();
				int  allowedDecimals = ((Integer) ALLOWED_DECIMALS.get(multiCharacter)).intValue();
				double result = value / ((double)factor);
				
				if (result * Math.pow(10d,allowedDecimals) % 1 == 0)
				{
					ready = true;
				}
			}
			double result = value / ((double)factor);
			ttlField.setControlValue("" + result);
			
			for (int i = 0; i < MULTI_COMBO_VALUES.length; i++) {
				String comboValue = MULTI_COMBO_VALUES[i];
				if (comboValue.equals(multiCharacter))
				{
					unitField.setControlValue(new UnsignedInteger16(i));
				}
			}
		}
		else
		{
			ttlField.setControlValue(DnsCimAdapter.NOT_SET);
			unitField.setControlValue(new UnsignedInteger16(0));
		}
		
	}

	private static void initTTLUnitValues(LabeledStringArrayInputComponentIf ttlUnit, DnsCimAdapter adapter) {
		String[] units = new String[4];
		units[0] = adapter.getBundle().getString("ttl.unit." + MULTI_COMBO_VALUES[0]);
		units[1] = adapter.getBundle().getString("ttl.unit." + MULTI_COMBO_VALUES[1]);
		units[2] = adapter.getBundle().getString("ttl.unit." + MULTI_COMBO_VALUES[2]);
		units[3] = adapter.getBundle().getString("ttl.unit." + MULTI_COMBO_VALUES[3]);
		ttlUnit.setValues(units);
	}
	
	/**
	 * 
	 * @param forwarderList
	 * @param forwarder
	 * @param zone if the zone is a masterZone the serialnumber is updated
	 * @return
	 * @throws WbemsmtException
	 */
	protected Linux_DnsForwarders saveForwardersIps(ForwarderList forwarderList, Linux_DnsForwarders forwarder, Linux_DnsZone zone) throws WbemsmtException {
		
		if (forwarderExists)
        {
        	List ipList = new ArrayList();
        	List typeList = new ArrayList();
        	
        	for (int i=0; i < forwarderList.size(); i++)
        	{
        		Forwarder fwdIp = forwarderList.getForwarder(i);

        		if (fwdIp.isExistsOnClient())
        		{
        			ipList.add(fwdIp.getForwarder());
        			typeList.add(fwdIp.getType());
        		}
        	}
        	
        	if (!forwarder.isFromServer())
        	{
        		if (zone != null)
        		{
        			forwarder.set_key_Name(NameFactory.createName(Linux_DnsForwardersForZone.class, zone.get_key_Name()));
        			forwarder.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
        			forwarder = (Linux_DnsForwarders) adapter.getFcoHelper().create(forwarder, adapter.getCimClient());
        			createForwarderAssociation(zone, forwarder);
        		}
        		else
        		{
        			forwarder.set_key_Name(NameFactory.createName(Linux_DnsForwardersForService.class, null));
        			forwarder.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
        			forwarder = (Linux_DnsForwarders) adapter.getFcoHelper().create(forwarder, adapter.getCimClient());
        			createForwarderAssociation(zone, forwarder);
        		}
        	}

        	forwarder.set_ForwardersElement((String[]) ipList.toArray(new String[ipList.size()]));
        	forwarder.set_ForwardersElementType((UnsignedInteger8[]) typeList.toArray(new UnsignedInteger8[typeList.size()]));
        	forwarderList.setReloadFromServer(true);
        	
        	if (forwarder.isFromServer() && forwarder.isModified())
        	{
        		forwarder = (Linux_DnsForwarders) adapter.getFcoHelper().save(forwarder, adapter.getCimClient());
        	}
        	
        	return forwarder;
        }
        else
        {
        	if (forwarder.isFromServer())
        	{
        		try {
        			adapter.getFcoHelper().delete(forwarder, adapter.getCimClient());

        			if (DnsCimAdapter.DUMMY_MODE)
        			{
        				List list = Linux_DnsForwardersForZoneHelper.enumerateInstances(adapter.getCimClient(),adapter.getNamespace(),false);
        				for (Iterator iter = list.iterator(); iter.hasNext();) {
        					Linux_DnsForwardersForZone forwardresForZoneAssoc = (Linux_DnsForwardersForZone) iter.next();
        					if (forwardresForZoneAssoc.get_GroupComponent_Linux_DnsZone(adapter.getCimClient()).get_key_Name().equals(zone.get_key_Name()))
        					{
        						adapter.getFcoHelper().delete(forwardresForZoneAssoc,adapter.getCimClient());
        					}
        				}
        			}
        			
        		} catch (Exception e) {
        			throw new WbemsmtException(WbemsmtException.ERR_SAVE_OBJECT,"Cannot save forwarders",new AbstractWbemsmtFco[]{forwarder});
        		}
        	}
        	return new Linux_DnsForwarders(adapter.getCimClient(),adapter.getNamespace());
        }
		
		
	}

	protected void show(DnsAddressMatchListDataContainer container, boolean show) {
		container.get_AddressList().getProperties().setVisible(show);
		container.get_usr_AddNewAddress().getProperties().setVisible(show);
		container.get_usr_AddPredefinedAddress().getProperties().setVisible(show);
		container.get_usr_NewAddress().getProperties().setVisible(show);
		container.get_usr_RemoveAddress().getProperties().setVisible(show);
		container.get_usr_UserAddresses().getProperties().setVisible(show);
		
	}
	
	public void createAclAssociations(Linux_DnsZone zone, Linux_DnsService service) throws WbemsmtException {

		int type = zone.get_Type().intValue();
		int slave = Linux_DnsZone.PROPERTY_TYPE.VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_Slave.intValue();
		int stub = Linux_DnsZone.PROPERTY_TYPE.VALUE_MAP_ENTRY_3_FOR_VALUE_ENTRY_Stub.intValue();
		int master = Linux_DnsZone.PROPERTY_TYPE.VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Master.intValue();
		boolean notify = type == slave || type == stub;
		boolean transfer = type == slave || type == stub || type == master;
		boolean update = type == slave || type == stub || type == master;
		boolean query = type == slave || type == stub || type == master;
		
		if (notify) createAcl(zone, Linux_DnsAllowNotifyForZone.class);
		if (transfer) createAcl(zone, Linux_DnsAllowTransferForZone.class);
		if (update) createAcl(zone, Linux_DnsAllowUpdateForZone.class);
		if (query) createAcl(zone, Linux_DnsAllowQueryForZone.class);
	}

	private void createAcl(Linux_DnsZone zone, Class associationClass) throws WbemsmtException {
		Linux_DnsAddressMatchList matchList = new Linux_DnsAddressMatchList(adapter.getCimClient(),adapter.getNamespace());
        matchList.set_key_Name(NameFactory.createName(associationClass,zone.get_key_Name()));
        matchList.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
        matchList = (Linux_DnsAddressMatchList) adapter.getFcoHelper().create(matchList,adapter.getCimClient());

        if (DnsCimAdapter.DUMMY_MODE)
        {
            Linux_DnsAllowNotifyForZone assoc = new Linux_DnsAllowNotifyForZone(adapter.getCimClient(),adapter.getNamespace());
            assoc.set_GroupComponent_Linux_DnsZone(zone);
            assoc.set_PartComponent_Linux_DnsAddressMatchList(matchList);
            adapter.getFcoHelper().create(assoc,adapter.getCimClient());
        }
	}

	/**
	 * creates a resource Record Object
	 * @param zone the zone to which the record belongs
	 * @param name the name of the record
	 * @param type the type of the record
	 * @param family the family of the record
	 * @param value the value of the record
	 * @throws WbemsmtException
	 */
	public Linux_DnsResourceRecord createResourceRecord(Linux_DnsZone zone, String name, String type, UnsignedInteger8 family, String value) throws WbemsmtException {
		Linux_DnsResourceRecord resourceRecord = new Linux_DnsResourceRecord(adapter.getCimClient(),adapter.getNamespace());
        resourceRecord.set_key_ZoneName(zone.get_key_Name());
        resourceRecord.set_key_Name(name);
        resourceRecord.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
        resourceRecord.set_key_Type(type);
        resourceRecord.set_Family(family);
        resourceRecord.set_key_Value(value);
        resourceRecord = (Linux_DnsResourceRecord) adapter.getFcoHelper().create(resourceRecord,adapter.getCimClient());

        if (DnsCimAdapter.DUMMY_MODE)
        {
            Linux_DnsResourceRecordsForZone assoc = new Linux_DnsResourceRecordsForZone(adapter.getCimClient(),adapter.getNamespace());
            assoc.set_GroupComponent_Linux_DnsZone(zone);
            assoc.set_PartComponent_Linux_DnsResourceRecord(resourceRecord);
            adapter.getFcoHelper().create(assoc, adapter.getCimClient());
        }
        return resourceRecord;
	}
	
	protected Linux_DnsForwarders createForwarders(Linux_DnsZone zone) throws WbemsmtException {
		Linux_DnsForwarders forwarders = new Linux_DnsForwarders(adapter.getCimClient(),adapter.getNamespace());
        forwarders.set_key_Name(NameFactory.createName(Linux_DnsForwardersForZone.class,(String) zone.get_key_Name()));
        forwarders.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
        forwarders = (Linux_DnsForwarders) adapter.getFcoHelper().create(forwarders,adapter.getCimClient());

        if (DnsCimAdapter.DUMMY_MODE)
        {
            Linux_DnsForwardersForZone assoc = new Linux_DnsForwardersForZone(adapter.getCimClient(),adapter.getNamespace());
            assoc.set_GroupComponent_Linux_DnsZone(zone);
            assoc.set_PartComponent_Linux_DnsForwarders(forwarders);
            adapter.getFcoHelper().create(assoc, adapter.getCimClient());			
        }
        return forwarders;
	}	
	
	public void delete(Linux_DnsZone zone) throws WbemsmtException
	{
		if (DnsCimAdapter.DUMMY_MODE)
		{
			try {
				List list =  zone.getAssociations_Linux_DnsAllowNotifyForZone(adapter.getCimClient(),false,false,null,null);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowNotifyForZone acl = (Linux_DnsAllowNotifyForZone) iter.next();
					Linux_DnsAddressMatchList aml = acl.get_PartComponent_Linux_DnsAddressMatchList(adapter.getCimClient());
					adapter.getFcoHelper().delete(acl,adapter.getCimClient());
					adapter.getFcoHelper().delete(aml,adapter.getCimClient());
				}

				list = zone.getAssociations_Linux_DnsAllowTransferForZone(adapter.getCimClient(),false,false,null,null);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowTransferForZone acl = (Linux_DnsAllowTransferForZone) iter.next();
					Linux_DnsAddressMatchList aml = acl.get_PartComponent_Linux_DnsAddressMatchList(adapter.getCimClient());
					adapter.getFcoHelper().delete(acl,adapter.getCimClient());
					adapter.getFcoHelper().delete(aml,adapter.getCimClient());
				}

				list = zone.getAssociations_Linux_DnsAllowQueryForZone(adapter.getCimClient(),false,false,null,null);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowQueryForZone acl = (Linux_DnsAllowQueryForZone) iter.next();
					Linux_DnsAddressMatchList aml = acl.get_PartComponent_Linux_DnsAddressMatchList(adapter.getCimClient());
					adapter.getFcoHelper().delete(acl,adapter.getCimClient());
					adapter.getFcoHelper().delete(aml,adapter.getCimClient());
				}

				list = zone.getAssociations_Linux_DnsAllowUpdateForZone(adapter.getCimClient(),false,false,null,null);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowUpdateForZone acl = (Linux_DnsAllowUpdateForZone) iter.next();
					Linux_DnsAddressMatchList aml = acl.get_PartComponent_Linux_DnsAddressMatchList(adapter.getCimClient());
					adapter.getFcoHelper().delete(acl,adapter.getCimClient());
					adapter.getFcoHelper().delete(aml,adapter.getCimClient());
				}
				
				list = zone.getAssociations_Linux_DnsResourceRecordsForZone(adapter.getCimClient(),false,false,null,null);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsResourceRecordsForZone recordAssoc = (Linux_DnsResourceRecordsForZone) iter.next();
					Linux_DnsResourceRecord rr = recordAssoc.get_PartComponent_Linux_DnsResourceRecord(adapter.getCimClient());
					adapter.getFcoHelper().delete(recordAssoc,adapter.getCimClient());
					adapter.getFcoHelper().delete(rr,adapter.getCimClient());
				}

				list = zone.getAssociations_Linux_DnsMastersForZone(adapter.getCimClient(),false,false,null,null);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsMastersForZone mastersForSlaveAssoc = (Linux_DnsMastersForZone) iter.next();
					Linux_DnsMasters ip = mastersForSlaveAssoc.get_PartComponent_Linux_DnsMasters(adapter.getCimClient());
					adapter.getFcoHelper().delete(mastersForSlaveAssoc,adapter.getCimClient());
					adapter.getFcoHelper().delete(ip,adapter.getCimClient());
				}

				list = zone.getAssociations_Linux_DnsForwardersForZone(adapter.getCimClient(),false,false,null,null);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsForwardersForZone forwardresForZoneAssoc = (Linux_DnsForwardersForZone) iter.next();
					Linux_DnsForwarders forwarders = forwardresForZoneAssoc.get_PartComponent_Linux_DnsForwarders(adapter.getCimClient());
					adapter.getFcoHelper().delete(forwardresForZoneAssoc,adapter.getCimClient());
					adapter.getFcoHelper().delete(forwarders,adapter.getCimClient());
				}

				
			} catch (Exception e) {
				throw new WbemsmtException(WbemsmtException.ERR_DELETE_OBJECT,e);
			}
		}
		adapter.getFcoHelper().delete(zone,adapter.getCimClient(),true);
	}

	public void setForwarderToContainer(DnsForwarderDataContainer container, UnsignedInteger8 forward) {
		container.get_Forward().setValues(new String[]{
				adapter.getBundle().getString("no.forwarder"),
				Linux_DnsServiceSettingData.PROPERTY_FORWARD.VALUE_ENTRY_Only,
				Linux_DnsServiceSettingData.PROPERTY_FORWARD.VALUE_ENTRY_First} );
		
		unknownForwarder = forward != null && forward.intValue() == Linux_DnsServiceSettingData.PROPERTY_FORWARD.VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown.intValue(); 
		
		if (forward == null)
		{
			container.get_Forward().setControlValue(new UnsignedInteger8((short)0));
		}
		else if (forward.intValue() == Linux_DnsServiceSettingData.PROPERTY_FORWARD.VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown.intValue())
		{
			container.get_Forward().setControlValue(null);
		}
		else
		{
			container.get_Forward().setControlValue(new UnsignedInteger8((short)forward.intValue()));
		}
	}

	public void setForwarderToContainer(DnsForwardZoneWizardSummaryDataContainer container, UnsignedInteger8 forward) {
		
		if (forward == null || forward.intValue() == Linux_DnsServiceSettingData.PROPERTY_FORWARD.VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown.intValue())
		{
			container.get_Forward().setControlValue(adapter.getBundle().getString("no.forwarder"));
		}
		else
		{
			container.get_Forward().setControlValue(Linux_DnsServiceSettingData.PROPERTY_FORWARD.VALUE_ENTRIES[forward.intValue()]);
		}
	}

	/**
	 * Returns the value of the forward
	 * @param container
	 * @return
	 * 
	 * If the user selected "no forwarder" null is returned
	 * if the user selected only/first the index for that values is returned
	 * if the forward is unknown and the user selected nothing unknown is returned 
	 * 
	 */
	public UnsignedInteger8 getForwarder(DnsForwarderDataContainer container) {

		
		if (isForwarderSet(container))
		{
			Object convertedControlValue = container.get_Forward().getConvertedControlValue();
			UnsignedInteger8 value = (UnsignedInteger8) convertedControlValue;
			//index 0 is no forwarder
			if (value.intValue() == 0)
			{
				return null;
			}
			else
			{
				return new UnsignedInteger8((short)(value.intValue()));
			}
		}
		else
		{
			if (unknownForwarder)
			{
				return Linux_DnsServiceSettingData.PROPERTY_FORWARD.VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown;
			}
			else
			{
				return null;
			}
		}
	}

	public boolean isForwarderSet (DnsForwarderDataContainer container) {
		Object convertedControlValue = container.get_Forward().getConvertedControlValue();
		return convertedControlValue != null;
	}
	
	
	public void updateControls(DnsResourceRecordListContainer container) throws WbemsmtException {
		resourceRecordHandler.updateControls(container);
	}

	public void updateControls(DnsResourceRecordListItemContainer container) {
		resourceRecordHandler.updateControls(container);
	}

	public void updateControls(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord recordFco) throws WbemsmtException {
		resourceRecordHandler.updateControls(container,recordFco);
	}

	public void updateModel(DnsResourceRecordListContainer container) throws WbemsmtException {
		resourceRecordHandler.updateModel(container);
	}
	
	public MessageList save(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		return 	resourceRecordHandler.save(container,fco);
	}

	public MessageList revert(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		fco = (Linux_DnsResourceRecord) adapter.getFcoHelper().reload(fco, container.getAdapter().getCimClient());
		return null;
	}

	public MessageList save(DnsResourceRecordListContainer container) throws WbemsmtException {
		return 	resourceRecordHandler.save(container);
	}

	public MessageList revert(DnsResourceRecordListContainer container) throws WbemsmtException {
		return 	resourceRecordHandler.revert(container);
	}

	public String checkContact(LabeledBaseInputComponentIf contactField, MessageList messageList) {
		
		String contact = (String) contactField.getConvertedControlValue();
		
		int indexOfAt = contact.indexOf("@");
		int indexOfPoint = contact.indexOf(".");
		if (indexOfAt > -1)
		{
			if (indexOfPoint < indexOfAt)
			{
				contact = contact.substring(0,indexOfAt).replaceAll("\\.", "\\\\.") + contact.substring(indexOfAt);
			}
			contact = contact.replaceAll("@", ".");
			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_CONTACT_CONVERTED,"contact.converted",new Object[]{contactField.getLabelText(), contact});
			messageList.addMessage(new Message(DnsErrCodes.MSG_CONTACT_CONVERTED,Message.WARNING, msg));
		}
		return contact;
	}

	public MessageList save(Linux_DnsMasterZone fco, DnsSoaContainer container) throws WbemsmtException {

		MessageList messageList = MessageList.init(container);
		
		setValues(fco, container, messageList);

		adapter.getFcoHelper().save(fco, adapter.getCimClient());
		
		return messageList;
	}

	/**
	 * Set the values of a SOA-Record
	 * @param fco
	 * @param container
	 * @param messageList
	 */
	protected void setValues(Linux_DnsMasterZone fco, DnsSoaContainer container, MessageList messageList) {
		fco.set_Contact(checkContact(container.get_Contact(),messageList));
		fco.set_Expire((UnsignedInteger32) container.get_Expire().getConvertedControlValue());
		fco.set_Retry((UnsignedInteger32) container.get_Retry().getConvertedControlValue());
		fco.set_Refresh((UnsignedInteger32) container.get_Refresh().getConvertedControlValue());
		fco.set_Server((String) container.get_Server().getConvertedControlValue());
		fco.set_NegativeCachingTTL(getTTLAsUnsignedInteger32(container,new Long(fco.get_NegativeCachingTTL() != null ? fco.get_NegativeCachingTTL().intValue(): 0)));
	}

	protected void updateControls(Linux_DnsMasterZone fco, DnsSoaContainer container) {
		container.get_Contact().setControlValue(fco.get_Contact());
		container.get_Expire().setControlValue(fco.get_Expire());
		container.get_Retry().setControlValue(fco.get_Retry());
		container.get_Refresh().setControlValue(fco.get_Refresh());
		container.get_SerialNumber().setControlValue(fco.get_SerialNumber());
		container.get_Server().setControlValue(fco.get_Server());
		updateTTLDataContainer(adapter,fco.get_NegativeCachingTTL(), container.get_NegativeCachingTTL(),container.get_usr_TTLUnit());

	}	
	
	
	protected void addForwarderIps(Linux_DnsForwarders forwarder,ForwarderList forwarderList) throws WbemsmtException {
		String[] elements = forwarder.get_ForwardersElement();
		UnsignedInteger8[] types = forwarder.get_ForwardersElementType();
		if (elements != null &&  types != null && elements.length != types.length)
		{
			throw new WbemsmtException(WbemsmtException.ERR_LOADING_MODEL,"The Arrays ForwardersElement and ForwardersElementType-Array of Object " + forwarder.toString() + " having not the same size");
		}
		
		for (int i=0; elements != null && i < elements.length; i++)
		{
			forwarderList.addForwarder(new Forwarder(elements[i],types[i],adapter,true,true));
		}
	}

	/**
	 * see http://de.wikipedia.org/wiki/SOA_Resource_Record how the serialnumber is created
	 * Behaviour is described also in http://www.ietf.org/rfc/rfc1912.txt
	 * @param fco
	 * @throws WbemsmtException 
	 */
	public void updateSerialNumber(Linux_DnsMasterZone fco, DnsSoaContainer soaContainer)
	{
		String todayString = FORMAT_FOR_SERIAL_NUMBER.format(new Date());
		String initialVersionString = FORMAT_FOR_SERIAL_NUMBER_VERSION.format(1);

		String serialNumber = (String) soaContainer.get_SerialNumber().getConvertedControlValue();
		if (serialNumber != null)
		{
			if (serialNumber.length() < 10)
			{
				logger.warning("SerialNumber " + serialNumber + " for zone " + fco.get_key_Name() + " was not valid a new was created.");
				serialNumber = todayString + initialVersionString;
				logger.warning("New SerialNumber for zone " + fco.get_key_Name() + " is " + serialNumber);
			}
			else
			{
				//Cut off the date (8 characters)
				String dateString = serialNumber.substring(0,8);
				String numberString = serialNumber.substring(8);
				if (dateString.equals(todayString))
				{
					try {
						Number number = FORMAT_FOR_SERIAL_NUMBER_VERSION.parse(numberString);
						numberString = FORMAT_FOR_SERIAL_NUMBER_VERSION.format(number.longValue() + 1);
					} catch (ParseException e) {
						logger.warning("Number of serial" + serialNumber + " for zone " + fco.get_key_Name() + " was not a number taking 1 as default.");
						numberString = initialVersionString;
					}
				}
				else
				{
					dateString = todayString;
					numberString = initialVersionString;
				}
				
				serialNumber = dateString + numberString;
			}
		}
		else
		{
			serialNumber = todayString + initialVersionString;
		}
		
		logger.info("New SerialNumber " + serialNumber + " for zone " + fco.get_key_Name());
		
		fco.set_SerialNumber(serialNumber);
		soaContainer.get_SerialNumber().setControlValue(serialNumber);
		soaContainer.get_SerialNumber().setModified(true);

	}
	
	public String getInitialSerialNumber() throws WbemsmtException
	{
		String serialNumber = FORMAT_FOR_SERIAL_NUMBER.format(new Date())
        					+ FORMAT_FOR_SERIAL_NUMBER_VERSION.format(1);
		
		return serialNumber;
	}
	
	protected void createForwarderAssociation(Linux_DnsZone zone, Linux_DnsForwarders forwardersFco) throws WbemsmtException {
		if (DnsCimAdapter.DUMMY_MODE)
		{
		    try {
    			if (zone != null)
    			{
    			    Linux_DnsForwardersForZone assoc = new Linux_DnsForwardersForZone(adapter.getCimClient(),adapter.getNamespace());
    			    assoc.set_GroupComponent_Linux_DnsZone(zone);
    			    assoc.set_PartComponent_Linux_DnsForwarders(forwardersFco);
    				adapter.getFcoHelper().create(assoc, adapter.getCimClient());
    			}
    			else
    			{
				    Linux_DnsForwardersForService assoc = new Linux_DnsForwardersForService(adapter.getCimClient(),adapter.getNamespace());
	                assoc.set_GroupComponent_Linux_DnsService(adapter.getDnsService().getFco());
	                assoc.set_PartComponent_Linux_DnsForwarders(forwardersFco);
	                adapter.getFcoHelper().create(assoc, adapter.getCimClient());
    			}
		    } catch (Exception e) {
		        throw new WbemsmtException(WbemsmtException.ERR_CREATE_OBJECT,e);
		    }
			
		}
	}
	
	public void updateModel(DnsResourceRecordListItemContainer container) throws WbemsmtException
	{
	    try {
    		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
    		{
    			ResourceRecord resourceRecord = adapter.getSelectedZone().getResourceRecords().getResourceRecord(container.getKey());
    			resourceRecord.getFco().set_TTL(null);
    				updateControls(container, resourceRecord.getFco());
    		}
	    } catch (Exception e) {
	        throw new WbemsmtException(WbemsmtException.ERR_UPDATING_MODEL,e);
	    }
	}
	
	public final void resetTTL(DnsSoaContainer container){}

	public boolean isUnknownForwarder() {
		return unknownForwarder;
	}
	
	
	
}
