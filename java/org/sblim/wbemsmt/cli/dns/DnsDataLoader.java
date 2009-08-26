 /** 
  * DnsDataLoader.java
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
  * Description: base class for loading dns objects
  * 
  */
package org.sblim.wbemsmt.cli.dns;

import java.util.List;

import javax.cim.CIMObjectPath;

import org.sblim.wbemsmt.bl.adapter.AbstractBaseCimAdapter;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.Zone;
import org.sblim.wbemsmt.dns.filter.DnsZoneNameFilter;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.cli.CimCommandValues;
import org.sblim.wbemsmt.tools.cli.CliDataLoader;
import org.sblim.wbemsmt.tools.resources.WbemSmtResourceBundle;

public abstract class DnsDataLoader implements CliDataLoader {

	protected CimCommandValues commandValues;

	protected void selectZone(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName, boolean creationOfResourceRecord) throws WbemsmtException {
		
		try {

			//using the same filter like the tree for getting the reverse zones
			DnsZoneNameFilter filter = new DnsZoneNameFilter(true);
			
			List<CIMObjectPath> instances = Linux_DnsZoneHelper.enumerateInstanceNames(adapter.getCimClient(), adapter.getNamespace(), true);

			//throws WbemsmtException if no matchin path element was found
			CIMObjectPath path = adapter.getFcoHelper().getPath(instances,
					new String[]{Linux_DnsZone.PROPERTY_INSTANCEID.NAME,Linux_DnsZone.PROPERTY_NAME.NAME},
					new Object[]{DnsCimAdapter.DEFAULT_INSTANCE_ID,zoneName});

			
			Linux_DnsZone zone = (Linux_DnsZone) adapter.getFcoHelper().reload(Linux_DnsZoneHelper.class, path, adapter.getCimClient());
			if (filter.accept(zone.getCimInstance(), adapter.getCimClient()))
			{
				selectReverseZone(bundle,adapter,zoneName);
			}
			else if (zone instanceof Linux_DnsForwardZone && creationOfResourceRecord)
			{
				throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,adapter.getBundle().getString("forwardzone.having.no.resourcerecord"));
			}
			else
			{
				selectZone(zone.getClass(), zoneName, adapter, bundle);
			}
			
		} catch (Exception e) {
			throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,bundle.getString("zone.not.found",new Object[]{zoneName}),e);
		}
		
	}

	protected void selectMasterZone(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName) throws WbemsmtException {
		Class<?> zoneClass = Linux_DnsMasterZone.class;
		selectZone(zoneClass, zoneName, adapter, bundle);
	}
	protected void selectSlaveZone(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName) throws WbemsmtException {
		Class<?> zoneClass = Linux_DnsSlaveZone.class;
		selectZone(zoneClass, zoneName, adapter, bundle);
	}
	protected void selectStubZone(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName) throws WbemsmtException {
		Class<?> zoneClass = Linux_DnsStubZone.class;
		selectZone(zoneClass, zoneName, adapter, bundle);
	}
	protected void selectHintZone(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName) throws WbemsmtException {
		Class<?> zoneClass = Linux_DnsHintZone.class;
		selectZone(zoneClass, zoneName, adapter, bundle);
	}
	protected void selectForwardZone(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName) throws WbemsmtException {
		Class<?> zoneClass = Linux_DnsForwardZone.class;
		selectZone(zoneClass, zoneName, adapter, bundle);
	}
	protected void selectReverseZone(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName) throws WbemsmtException {
		//if a reverse zone can be from other type first check the type and the determine the zoneClass
		Class<?> zoneClass = Linux_DnsMasterZone.class;
		selectZone(zoneClass, zoneName, adapter, bundle);
	}
	
	private void selectZone(Class<?> zoneClass, String zoneName, AbstractBaseCimAdapter adapter, WbemSmtResourceBundle bundle) throws WbemsmtException {
		try {
			CimObjectKey keyService = getServiceKey(adapter, getServiceName());
			CIMObjectPath pathZone = adapter.getFcoHelper().getPath(zoneClass,adapter.getNamespace(),"Name",zoneName,adapter.getCimClient());
			if (pathZone != null)
			{
				CimObjectKey key = new CimObjectKey(pathZone);
				keyService.setNextKey(key);
				adapter.select(keyService);
				return;
			}
			else
			{
				throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND, bundle.getString("zone.not.found",new Object[]{zoneName}));
			}
		} catch (WbemsmtException e) {
			throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,bundle.getString("zone.not.found",new Object[]{zoneName}),e);
		}
	}
	
	protected void selectAddressMatchList(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String listName) throws WbemsmtException {
		try {
			
			CimObjectKey keyService = getServiceKey(adapter, getServiceName());
			
			listName = NameFactory.createName(Linux_DnsAddressMatchListsForService.class, listName);
			
			CIMObjectPath pathService = adapter.getFcoHelper().getPath(Linux_DnsAddressMatchList.class,adapter.getNamespace(),new String[]{"Name"},new Object[]{listName}, adapter.getCimClient());
			if (pathService != null)
			{
				CimObjectKey key = new CimObjectKey(pathService);
				keyService.setNextKey(key);
				adapter.select(keyService);
				return;
			}
			else
			{
				throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,bundle.getString("addressMatchList.not.found",new Object[]{listName}));
			}
		} catch (WbemsmtException e) {
			throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,bundle.getString("addressMatchList.not.found",new Object[]{listName}),e);
		}
	}

	protected void selectMasters(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String mastersName) throws WbemsmtException {
		try {
			
			CimObjectKey keyService = getServiceKey(adapter, getServiceName());

			mastersName = NameFactory.createName(Linux_DnsMastersForService.class, mastersName);
			
			CIMObjectPath pathService = adapter.getFcoHelper().getPath(Linux_DnsMasters.class,adapter.getNamespace(),new String[]{"Name"},new Object[]{mastersName}, adapter.getCimClient());
			if (pathService != null)
			{
				CimObjectKey key = new CimObjectKey(pathService);
				keyService.setNextKey(key);
				adapter.select(keyService);
				return;
			}
			else
			{
				throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,bundle.getString("masters.not.found",new Object[]{mastersName}));
			}
		} catch (WbemsmtException e) {
			throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,bundle.getString("masters.not.found",new Object[]{mastersName}),e);
		}
	}

	protected void selectResourceRecord(WbemSmtResourceBundle bundle, AbstractBaseCimAdapter adapter, String zoneName, String recordName, String recordValue, String recordPrio, String recordType) throws WbemsmtException {
		try {
			CimObjectKey keyService = getServiceKey(adapter, getServiceName());			
			
			Zone zone = ((DnsCimAdapter)adapter).getZone(getServiceName(),zoneName);
			
			if (zone.getLinux_DnsZone().get_Type().intValue() == Linux_DnsZone.PROPERTY_TYPE.VALUE_MAP_ENTRY_4_FOR_VALUE_ENTRY_Forward.intValue())
			{
				throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,adapter.getBundle().getString("forwardzone.having.no.resourcerecord"));
			}
			
			if (recordType.equals(ResourceRecord.TYPE_MX))
			{
				recordValue = recordPrio + " " + recordValue;
			}
			
			List<CIMObjectPath> records = zone.getLinux_DnsZone().getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZoneNames(adapter.getCimClient());
			CIMObjectPath pathRecord = adapter.getFcoHelper().getPath(records,
					new String[]{Linux_DnsResourceRecord.PROPERTY_ZONENAME.NAME,Linux_DnsResourceRecord.PROPERTY_NAME.NAME,Linux_DnsResourceRecord.PROPERTY_VALUE.NAME,Linux_DnsResourceRecord.PROPERTY_TYPE.NAME},
					new Object[]{zoneName,recordName,recordValue,recordType});

			CimObjectKey keyZone = new CimObjectKey(zone.getLinux_DnsZone().getCimObjectPath());
			CimObjectKey keyRecord = new CimObjectKey(pathRecord);
			keyService.setNextKey(keyZone);
			keyZone.setNextKey(keyRecord);
			adapter.select(keyService);
		} catch (Exception e) {
			throw new WbemsmtException(WbemsmtException.ERR_OBJECT_NOT_FOUND,bundle.getString("recordInZone.not.found",new Object[]{zoneName,recordName}),e);
		}
	}
	
	private final String getServiceName()
	{
		return commandValues.getOptionValue(GlobalArguments.KEY_GLOBAL_dnsServiceName.getLongKey());
	}

	private CimObjectKey getServiceKey(AbstractBaseCimAdapter adapter, String serviceName) throws WbemsmtException {
		return new CimObjectKey(((DnsCimAdapter) adapter).getDnsService(serviceName).getFco().getCimObjectPath());
	}
	
}
