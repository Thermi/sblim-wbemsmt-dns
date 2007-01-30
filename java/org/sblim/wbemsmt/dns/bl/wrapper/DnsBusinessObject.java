 /** 
  * DnsBusinessObject.java
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
  * Description: Base class for objects wrapping dns business objects and their actions
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.sblim.wbem.cim.UnsignedInt16;
import org.sblim.wbem.cim.UnsignedInt32;
import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddressMatchListDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwarderDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsTTLDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsForwardZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchListHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowNotifyForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowNotifyForZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowQueryForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowQueryForZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowTransferForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowTransferForZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowUpdateForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAllowUpdateForZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardersForService;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardersForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardersForZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwardersHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasterZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecordHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecordsForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecordsForZoneHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsService;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsServiceSettingData;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsSlaveZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.resourcerecord.ResourceRecordHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectCreationException;
import org.sblim.wbemsmt.exception.ObjectDeletionException;
import org.sblim.wbemsmt.exception.ObjectRevertException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;
import org.sblim.wbemsmt.exception.ValidationException;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;
import org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf;
import org.sblim.wbemsmt.tools.resources.LocaleChangeListener;
import org.sblim.wbemsmt.tools.validator.IpAddressFieldValidator;

public abstract class DnsBusinessObject extends DnsObject {

	public abstract CimObjectKey getCimObjectKey();
	protected ResourceRecordHandler resourceRecordHandler;

	protected boolean forwarderExists;
	
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
	
	
	public void updateControls(DnsResourceRecordDataContainer container, Linux_DnsResourceRecord fco)  throws UpdateControlsException {
		container.get_Family().setValues(Linux_DnsResourceRecord.CIM_VALUEMAP_FAMILY);
		container.get_Family().setControlValue(fco.get_Family());
		
		container.get_Type().setControlValue(ResourceRecord.getIndexByTypeName(fco.get_Type()));
		
		container.get_Name().setControlValue(fco.get_Name());
		container.get_TTL().setControlValue(new Double(fco.get_TTL() != null ? fco.get_TTL().doubleValue() : 0));
		container.get_Value().setControlValue(fco.get_Value());
	}

	protected String[] getForwarders(ForwarderList forwarderList) {
		String[] result = forwarderList.getNameArray();
		if (result.length > 0)
		{
			forwarderExists = true;
		}
		return result; 
	}

	protected void updateForwarders(ForwarderList forwarderList, DnsForwarderDataContainer container, LabeledBaseInputComponentIf useGlobalButton) throws ModelUpdateException {
		if (adapter.getUpdateTrigger() == container.get_usr_AddForwarder())
		{
			String newForwarder = (String) container.get_usr_NewForwarder().getConvertedControlValue();
			if (StringUtils.isNotEmpty(newForwarder))
			{
				IpAddressFieldValidator validator = new IpAddressFieldValidator(container.get_usr_NewForwarder(),adapter);
				MessageList list = new MessageList();
				try {
					list = validator.validate();
				} catch (ValidationException e) {
					throw new ModelUpdateException(e);
				}
				if (!list.hasErrors())
				{
					if (forwarderList.getForwarderOnClientByName(newForwarder) == null)
					{
						forwarderList.addForwarder(new Forwarder(newForwarder,new UnsignedInt8((short)Linux_DnsForwarders.FORWARDERSELEMENTTYPE_IPV4),adapter,false,true));
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
				UnsignedInt16 index = (UnsignedInt16) indexList.get(i);
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


	public static UnsignedInt16 getTTLAsUnsignedInt16(DnsTTLDataContainer dataContainer, Number oldValue) {
		//the range of the 16bit values is checked by the validators
		Integer integer = getTTLAsInteger(dataContainer,oldValue);
		return new UnsignedInt16(integer.intValue());
	}

	public static Integer getTTLAsUnsignedInt32(DnsTTLDataContainer dataContainer, Number oldValue) {
		return getTTLASInteger(dataContainer,oldValue);
	}

	public static Integer getTTLASInteger(DnsTTLDataContainer dataContainer,Number oldValue) {
		return getTTLAsInteger(dataContainer,oldValue);
	}

	public static Integer getTTLAsInteger(DnsTTLDataContainer dataContainer, Number oldValue) {
		
		UnsignedInt16 index = (UnsignedInt16) dataContainer.get_usr_TTLUnit().getConvertedControlValue();
		if (index == null)
		{
			index = new UnsignedInt16(0);
		}
		
		return getTTLAsInteger(
				dataContainer, dataContainer.get_TTL(),
				(String) dataContainer.get_TTL().getConvertedControlValue(),
				MULTI_COMBO_VALUES[index.intValue()], oldValue
				);
	}
	
	public static Integer getTTLAsUnsignedInt32(DnsResourceRecordListItemContainer dataContainer, Integer oldValue) {
		return getTTLAsInteger(dataContainer,oldValue);
	}

	public static Integer getTTLAsInteger(DnsResourceRecordListItemContainer dataContainer, Integer oldValue) {
		
		UnsignedInt16 index = (UnsignedInt16) dataContainer.get_usr_TTLUnit().getConvertedControlValue();
		if (index == null)
		{
			index = new UnsignedInt16(0);
		}
		
		return getTTLAsInteger(
				dataContainer,dataContainer.get_TTL(),
				(String) dataContainer.get_TTL().getConvertedControlValue(),
				MULTI_COMBO_VALUES[index.intValue()], oldValue
				);
	}

	public static UnsignedInt32 getTTLAsUnsignedInt32(DnsSoaContainer dataContainer, Long oldValue) {
		Integer integer = getTTLAsInteger(dataContainer,oldValue);
		return new UnsignedInt32(integer.intValue());
	}
	
	public static Integer getTTLAsInteger(DnsSoaContainer dataContainer, Long oldValue) {
		
		UnsignedInt16 index = (UnsignedInt16) dataContainer.get_usr_TTLUnit().getConvertedControlValue();
		if (index == null)
		{
			index = new UnsignedInt16(0);
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

	public static void updateTTLDataContainer(final DnsCimAdapter adapter, UnsignedInt32 ttl, final DnsTTLDataContainer container) {
		updateTTLDataContainer(adapter,ttl != null ? new Double(ttl.doubleValue()) : null,container.get_TTL(),container.get_usr_TTLUnit());
	}

	public static void updateTTLDataContainer(final DnsCimAdapter adapter, Double ttl, final DnsTTLDataContainer container) {
		updateTTLDataContainer(adapter,ttl,container.get_TTL(),container.get_usr_TTLUnit());
	}
	
	public static void updateTTLDataContainer(final DnsCimAdapter adapter, Integer ttl, LabeledBaseInputComponentIf ttlField, final LabeledStringArrayInputComponentIf unitField) {
		updateTTLDataContainer(adapter, ttl != null ? new Double(ttl.doubleValue()) : null, ttlField,unitField);
	}
	
	public static void updateTTLDataContainer(final DnsCimAdapter adapter, UnsignedInt32 ttl, LabeledBaseInputComponentIf ttlField, final LabeledStringArrayInputComponentIf unitField) {
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
					unitField.setControlValue(new UnsignedInt16(i));
				}
			}
		}
		else
		{
			ttlField.setControlValue(DnsCimAdapter.NOT_SET);
			unitField.setControlValue(new UnsignedInt16(0));
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
	 * @throws ObjectSaveException
	 */
	protected Linux_DnsForwarders saveForwardersIps(ForwarderList forwarderList, Linux_DnsForwarders forwarder, Linux_DnsZone zone) throws ObjectSaveException {
		
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
			
			if (!forwarder.isValidCimInstance())
			{
				if (zone != null)
				{
					forwarder.set_Name(NameFactory.createName(Linux_DnsForwardersForZone.class, zone.get_Name()));
					forwarder.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
					forwarder = (Linux_DnsForwarders) FcoHelper.create(forwarder, adapter.getCimClient());
					createForwarderAssociation(zone, forwarder);
				}
				else
				{
					forwarder.set_Name(NameFactory.createName(Linux_DnsForwardersForService.class, null));
					forwarder.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
					forwarder = (Linux_DnsForwarders) FcoHelper.create(forwarder, adapter.getCimClient());
					createForwarderAssociation(zone, forwarder);
				}
			}

			forwarder.set_ForwardersElement((String[]) ipList.toArray(new String[ipList.size()]));
			forwarder.set_ForwardersElementType((UnsignedInt8[]) typeList.toArray(new UnsignedInt8[typeList.size()]));
			forwarderList.setReloadFromServer(true);
			
			if (forwarder.isValidCimInstance() && forwarder.isModified())
			{
				forwarder = (Linux_DnsForwarders) FcoHelper.save(forwarder, adapter.getCimClient());
			}
			
			return forwarder;
		}
		else
		{
			if (forwarder.isValidCimInstance())
			{
				try {
					FcoHelper.delete(forwarder, adapter.getCimClient());

					if (DnsCimAdapter.DUMMY_MODE)
					{
						List list = Linux_DnsForwardersForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
						for (Iterator iter = list.iterator(); iter.hasNext();) {
							Linux_DnsForwardersForZone forwardresForZoneAssoc = (Linux_DnsForwardersForZone) iter.next();
							if (forwardresForZoneAssoc.get_Linux_DnsZone().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
							{
								FcoHelper.delete(forwardresForZoneAssoc,adapter.getCimClient());
							}
						}
					}
					
				} catch (Exception e) {
					throw new ObjectSaveException(forwarder);
				}
			}
			return new Linux_DnsForwarders();
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
	
	public void createAclAssociations(Linux_DnsZone zone, Linux_DnsService service) throws ObjectCreationException {

		int type = zone.get_Type().intValue();
		int slave = Linux_DnsZone.TYPE_SLAVE;
		int stub = Linux_DnsZone.TYPE_STUB;
		int master = Linux_DnsZone.TYPE_MASTER;
		boolean notify = type == slave || type == stub;
		boolean transfer = type == slave || type == stub || type == master;
		boolean update = type == slave || type == stub || type == master;
		boolean query = type == slave || type == stub || type == master;
		
		if (notify) createAcl(zone, Linux_DnsAllowNotifyForZone.class);
		if (transfer) createAcl(zone, Linux_DnsAllowTransferForZone.class);
		if (update) createAcl(zone, Linux_DnsAllowUpdateForZone.class);
		if (query) createAcl(zone, Linux_DnsAllowQueryForZone.class);
	}

	private void createAcl(Linux_DnsZone zone, Class associationClass) throws ObjectCreationException {
		Linux_DnsAddressMatchList matchList = new Linux_DnsAddressMatchList();
		matchList.set_Name(NameFactory.createName(associationClass,zone.get_Name()));
		matchList.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
		matchList = (Linux_DnsAddressMatchList) FcoHelper.create(matchList,adapter.getCimClient());

		if (DnsCimAdapter.DUMMY_MODE)
		{
			Vector keysForAssociation = new Vector();
			keysForAssociation.add(CIMPropertyBuilder.create(Linux_DnsAllowNotifyForZone.CIM_PROPERTY_LINUX_DNSZONE,zone));
			keysForAssociation.add(CIMPropertyBuilder.create(Linux_DnsAllowNotifyForZone.CIM_PROPERTY_LINUX_DNSADDRESSMATCHLIST,matchList));
			FcoHelper.create(associationClass,adapter.getCimClient(),keysForAssociation);
		}
	}

	/**
	 * creates a resource Record Object
	 * @param zone the zone to which the record belongs
	 * @param name the name of the record
	 * @param type the type of the record
	 * @param family the family of the record
	 * @param value the value of the record
	 * @throws ObjectCreationException
	 */
	public Linux_DnsResourceRecord createResourceRecord(Linux_DnsZone zone, String name, String type, UnsignedInt8 family, String value) throws ObjectCreationException {
		Linux_DnsResourceRecord resourceRecord = new Linux_DnsResourceRecord();
		//TODO remove the try-catch which is a workaround for bug #40
		try {
			resourceRecord.set_ZoneName(zone.get_Name());
			resourceRecord.set_Name(name);
			resourceRecord.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
			resourceRecord.set_Type(type);
			resourceRecord.set_Family(family);
			resourceRecord.set_Value(value);
			resourceRecord = (Linux_DnsResourceRecord) FcoHelper.create(resourceRecord,adapter.getCimClient());

			//TODO do we need to create the association between resource records a and zones in RealMode
			if (DnsCimAdapter.DUMMY_MODE)
			{
				Vector keys = new Vector();
				keys.add(CIMPropertyBuilder.create(Linux_DnsResourceRecordsForZone.CIM_PROPERTY_LINUX_DNSZONE,zone));
				keys.add(CIMPropertyBuilder.create(Linux_DnsResourceRecordsForZone.CIM_PROPERTY_LINUX_DNSRESOURCERECORD,resourceRecord));
				FcoHelper.create(Linux_DnsResourceRecordsForZone.class,adapter.getCimClient(),keys);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resourceRecord;
	}
	
	protected Linux_DnsForwarders createForwarders(Linux_DnsZone zone) throws ObjectCreationException {
		Linux_DnsForwarders forwarders = new Linux_DnsForwarders();
		forwarders.set_Name(NameFactory.createName(Linux_DnsForwardersForZone.class,(String) zone.get_Name()));
		forwarders.set_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
		forwarders = (Linux_DnsForwarders) FcoHelper.create(forwarders,adapter.getCimClient());
	
		//TODO do we need to create the association between resource records a and zones in RealMode
		if (DnsCimAdapter.DUMMY_MODE)
		{
			Vector keys = new Vector();
			keys.add(CIMPropertyBuilder.create(Linux_DnsForwardersForZone.CIM_PROPERTY_LINUX_DNSZONE,zone));
			keys.add(CIMPropertyBuilder.create(Linux_DnsForwardersForZone.CIM_PROPERTY_LINUX_DNSFORWARDERS,forwarders));
			FcoHelper.create(Linux_DnsForwardersForZone.class,adapter.getCimClient(),keys);
			
		}
		return forwarders;
	}	
	
	public void delete(Linux_DnsZone zone) throws ObjectDeletionException
	{
		
		//TODO check if acls and resorce records are deleted in real mode
		if (DnsCimAdapter.DUMMY_MODE)
		{
			try {
				List list = Linux_DnsAllowNotifyForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowNotifyForZone acl = (Linux_DnsAllowNotifyForZone) iter.next();
					if (acl.get_Linux_DnsZone().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
					{
						Linux_DnsAddressMatchList aml = (Linux_DnsAddressMatchList) FcoHelper.reload(Linux_DnsAddressMatchListHelper.class, acl.get_Linux_DnsAddressMatchList(),adapter.getCimClient() );
						FcoHelper.delete(acl,adapter.getCimClient());
						FcoHelper.delete(aml,adapter.getCimClient());
					}
				}

				list = Linux_DnsAllowTransferForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowTransferForZone acl = (Linux_DnsAllowTransferForZone) iter.next();
					if (acl.get_Linux_DnsZone().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
					{
						Linux_DnsAddressMatchList aml = (Linux_DnsAddressMatchList) FcoHelper.reload(Linux_DnsAddressMatchListHelper.class, acl.get_Linux_DnsAddressMatchList(),adapter.getCimClient() );
						FcoHelper.delete(acl,adapter.getCimClient());
						FcoHelper.delete(aml,adapter.getCimClient());
					}
				}

				list = Linux_DnsAllowQueryForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowQueryForZone acl = (Linux_DnsAllowQueryForZone) iter.next();
					if (acl.get_Linux_DnsZone().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
					{
						Linux_DnsAddressMatchList aml = (Linux_DnsAddressMatchList) FcoHelper.reload(Linux_DnsAddressMatchListHelper.class, acl.get_Linux_DnsAddressMatchList(),adapter.getCimClient() );
						FcoHelper.delete(acl,adapter.getCimClient());
						FcoHelper.delete(aml,adapter.getCimClient());
					}
				}

				list = Linux_DnsAllowUpdateForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsAllowUpdateForZone acl = (Linux_DnsAllowUpdateForZone) iter.next();
					if (acl.get_Linux_DnsZone().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
					{
						Linux_DnsAddressMatchList aml = (Linux_DnsAddressMatchList) FcoHelper.reload(Linux_DnsAddressMatchListHelper.class, acl.get_Linux_DnsAddressMatchList(),adapter.getCimClient() );
						FcoHelper.delete(acl,adapter.getCimClient());
						FcoHelper.delete(aml,adapter.getCimClient());
					}
				}
				
				list = Linux_DnsResourceRecordsForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsResourceRecordsForZone recordAssoc = (Linux_DnsResourceRecordsForZone) iter.next();
					if (recordAssoc.get_Linux_DnsZone().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
					{
						Linux_DnsResourceRecord rr = (Linux_DnsResourceRecord) FcoHelper.reload(Linux_DnsResourceRecordHelper.class, recordAssoc.get_Linux_DnsResourceRecord(),adapter.getCimClient() );
						FcoHelper.delete(recordAssoc,adapter.getCimClient());
						FcoHelper.delete(rr,adapter.getCimClient());
					}
				}

				list = Linux_DnsMastersForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsMastersForZone mastersForSlaveAssoc = (Linux_DnsMastersForZone) iter.next();
					if (mastersForSlaveAssoc.get_Linux_DnsZone().getKey(Linux_DnsSlaveZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
					{
						Linux_DnsMasters ip = (Linux_DnsMasters) FcoHelper.reload(Linux_DnsMastersHelper.class, mastersForSlaveAssoc.get_Linux_DnsMasters(),adapter.getCimClient() );
						FcoHelper.delete(mastersForSlaveAssoc,adapter.getCimClient());
						FcoHelper.delete(ip,adapter.getCimClient());
					}
				}

				list = Linux_DnsForwardersForZoneHelper.enumerateInstances(adapter.getCimClient(),false);
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Linux_DnsForwardersForZone forwardresForZoneAssoc = (Linux_DnsForwardersForZone) iter.next();
					if (forwardresForZoneAssoc.get_Linux_DnsZone().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue().equals(zone.get_Name()))
					{
						Linux_DnsForwarders forwarders = (Linux_DnsForwarders) FcoHelper.reload(Linux_DnsForwardersHelper.class, forwardresForZoneAssoc.get_Linux_DnsForwarders(),adapter.getCimClient() );
						FcoHelper.delete(forwardresForZoneAssoc,adapter.getCimClient());
						FcoHelper.delete(forwarders,adapter.getCimClient());
					}
				}

				
			} catch (ModelLoadException e) {
				throw new ObjectDeletionException(e);
			}
		}
		FcoHelper.delete(zone,adapter.getCimClient(),true);
	}

	public void setForwarder(DnsForwarderDataContainer container, UnsignedInt8 forward) {
		container.get_Forward().setValues(new String[]{
				adapter.getBundle().getString("no.forwarder"),
				Linux_DnsServiceSettingData.CIM_VALUEMAP_FORWARD[Linux_DnsServiceSettingData.FORWARD_ONLY],
				Linux_DnsServiceSettingData.CIM_VALUEMAP_FORWARD[Linux_DnsServiceSettingData.FORWARD_FIRST]} );
		
		if (forward == null || forward.intValue() == Linux_DnsServiceSettingData.FORWARD_UNKNOWN)
		{
			container.get_Forward().setControlValue(new UnsignedInt8((short)0));
		}
		else
		{
			container.get_Forward().setControlValue(new UnsignedInt8((short)forward.intValue()));
		}
	}

	public void setForwarder(DnsForwardZoneWizardSummaryDataContainer container, UnsignedInt8 forward) {
		
		if (forward == null || forward.intValue() == Linux_DnsServiceSettingData.FORWARD_UNKNOWN)
		{
			container.get_Forward().setControlValue(Linux_DnsServiceSettingData.CIM_VALUEMAP_FORWARD[Linux_DnsServiceSettingData.FORWARD_UNKNOWN]);
		}
		else
		{
			container.get_Forward().setControlValue(Linux_DnsServiceSettingData.CIM_VALUEMAP_FORWARD[forward.intValue()]);
		}
	}

	public UnsignedInt8 getForwarder(DnsForwarderDataContainer container) {

		Object convertedControlValue = container.get_Forward().getConvertedControlValue();
		if (convertedControlValue != null)
		{
			UnsignedInt8 value = (UnsignedInt8) convertedControlValue;
			//index 0 is no forwarder
			if (value.intValue() == 0)
			{
				return null;
			}
			else
			{
				return new UnsignedInt8((short)(value.intValue()));
			}
		}
		else
		{
			return null;
		}

	}

	public void updateControls(DnsResourceRecordListContainer container) throws UpdateControlsException {
		resourceRecordHandler.updateControls(container);
	}

	public void updateControls(DnsResourceRecordListItemContainer container) {
		resourceRecordHandler.updateControls(container);
	}

	public void updateControls(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord recordFco) throws UpdateControlsException {
		resourceRecordHandler.updateControls(container,recordFco);
	}

	public void updateModel(DnsResourceRecordListContainer container) throws ModelUpdateException {
		resourceRecordHandler.updateModel(container);
	}
	
	public MessageList save(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws ObjectSaveException {
		return 	resourceRecordHandler.save(container,fco);
	}

	public MessageList revert(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws ObjectRevertException {
		try {
			fco = (Linux_DnsResourceRecord) FcoHelper.reload(fco, container.getAdapter().getCimClient());
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList save(DnsResourceRecordListContainer container) throws ObjectSaveException {
		return 	resourceRecordHandler.save(container);
	}

	public MessageList revert(DnsResourceRecordListContainer container) throws ObjectRevertException {
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

	public MessageList save(Linux_DnsMasterZone fco, DnsSoaContainer container) throws ObjectSaveException {

		MessageList messageList = MessageList.init(container);
		
		setValues(fco, container, messageList);

		FcoHelper.save(fco, adapter.getCimClient());
		
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
		fco.set_Expire((UnsignedInt32) container.get_Expire().getConvertedControlValue());
		fco.set_Retry((UnsignedInt32) container.get_Retry().getConvertedControlValue());
		fco.set_Refresh((UnsignedInt32) container.get_Refresh().getConvertedControlValue());
		fco.set_Server((String) container.get_Server().getConvertedControlValue());
		fco.set_NegativeCachingTTL(getTTLAsUnsignedInt32(container,new Long(fco.get_NegativeCachingTTL() != null ? fco.get_NegativeCachingTTL().intValue(): 0)));
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
	
	
	protected void addForwarderIps(Linux_DnsForwarders forwarder,ForwarderList forwarderList) throws ModelLoadException {
		String[] elements = forwarder.get_ForwardersElement();
		UnsignedInt8[] types = forwarder.get_ForwardersElementType();
		if (elements != null &&  types != null && elements.length != types.length)
		{
			throw new ModelLoadException("The Arrays ForwardersElement and ForwardersElementType-Array of Object " + forwarder.toString() + " having not the same size");
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
	 * @throws ObjectSaveException 
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
				logger.warning("SerialNumber " + serialNumber + " for zone " + fco.get_Name() + " was not valid a new was created.");
				serialNumber = todayString + initialVersionString;
				logger.warning("New SerialNumber for zone " + fco.get_Name() + " is " + serialNumber);
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
						logger.warning("Number of serial" + serialNumber + " for zone " + fco.get_Name() + " was not a number taking 1 as default.");
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
		
		logger.info("New SerialNumber " + serialNumber + " for zone " + fco.get_Name());
		
		fco.set_SerialNumber(serialNumber);
		soaContainer.get_SerialNumber().setControlValue(serialNumber);
		soaContainer.get_SerialNumber().setModified(true);

	}
	
	public String getInitialSerialNumber() throws ObjectSaveException
	{
		String serialNumber = FORMAT_FOR_SERIAL_NUMBER.format(new Date())
        					+ FORMAT_FOR_SERIAL_NUMBER_VERSION.format(1);
		
		return serialNumber;
	}
	
	protected void createForwarderAssociation(Linux_DnsZone zone, Linux_DnsForwarders forwardersFco) throws ObjectCreationException {
		if (DnsCimAdapter.DUMMY_MODE)
		{
			if (zone != null)
			{
				Vector keys = new Vector();
				keys.add(CIMPropertyBuilder.create(Linux_DnsForwardersForZone.CIM_PROPERTY_LINUX_DNSZONE, zone));
				keys.add(CIMPropertyBuilder.create(Linux_DnsForwardersForZone.CIM_PROPERTY_LINUX_DNSFORWARDERS, forwardersFco));
				FcoHelper.create(Linux_DnsForwardersForZone.class, adapter.getCimClient(), keys);
			}
			else
			{
				try {
					Vector keys = new Vector();
					keys.add(CIMPropertyBuilder.create(Linux_DnsForwardersForService.CIM_PROPERTY_LINUX_DNSSERVICE, adapter.getDnsService().getFco()));
					keys.add(CIMPropertyBuilder.create(Linux_DnsForwardersForService.CIM_PROPERTY_LINUX_DNSFORWARDERS, forwardersFco));
					FcoHelper.create(Linux_DnsForwardersForService.class, adapter.getCimClient(), keys);
				} catch (ModelLoadException e) {
					throw new ObjectCreationException(new Linux_DnsForwardersForService(),e);
				}
			}
			
		}
	}
	
	public void updateModel(DnsResourceRecordListItemContainer container) throws ModelUpdateException
	{
		if (adapter.getUpdateTrigger() == container.get_usr_RemoveTTL())
		{
			ResourceRecord resourceRecord = adapter.getSelectedZone().getResourceRecords().getResourceRecord(container.getKey());
			resourceRecord.getFco().set_TTL(null);
			try {
				updateControls(container, resourceRecord.getFco());
			} catch (UpdateControlsException e) {
				throw new ModelUpdateException(e);
			}
		}
	}
	
	public final void resetTTL(DnsSoaContainer container){}
	
}
