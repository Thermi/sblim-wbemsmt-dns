 /** 
  * ResourceRecordHandler.java
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
  * Description: Handler for ResourceRecords
  * 
  */
package org.sblim.wbemsmt.dns.bl.resourcerecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.cim.UnsignedInteger8;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsResourceRecordListItemContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject;
import org.sblim.wbemsmt.dns.bl.wrapper.ResourceRecord;
import org.sblim.wbemsmt.dns.bl.wrapper.Zone;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.input.ActionComponent;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;

public class ResourceRecordHandler {
	private DnsCimAdapter adapter;
	private final Zone zone;
	
	public ResourceRecordHandler(DnsCimAdapter adapter,Zone zone) {
		super();
		this.adapter = adapter;
		this.zone = zone;
	}

	public void updateModel(DnsResourceRecordListContainer container) throws WbemsmtException {
		
		boolean deleted = false;
		
		if (adapter.getUpdateTrigger() == container.get_usr_SelectAll())
		{
			boolean select = ((Boolean)container.get_usr_SelectAll().getConvertedControlValue()).booleanValue();
			for (int i=0; i < container.getResourceRecords().size(); i++)
			{
				DnsResourceRecordListItemContainer item = (DnsResourceRecordListItemContainer) container.getResourceRecords().get(i);
				item.get_usr_DeleteRecord().setControlValue(new Boolean(select));
			}
		}
		else if (adapter.getUpdateTrigger() == container.get_usr_Delete())
		{
			for (int i=0; i < container.getResourceRecords().size(); i++)
			{
				DnsResourceRecordListItemContainer item = (DnsResourceRecordListItemContainer) container.getResourceRecords().get(i);
				boolean delete = ((Boolean)item.get_usr_DeleteRecord().getConvertedControlValue()).booleanValue();
				if (delete)
				{
					delete(item,i);
					deleted = true;
				}
			}
		}

		//force a reload
		if (deleted)
		{
			zone.setResourceRecords(null);
		}
		
	}

	public void delete(DnsResourceRecordListItemContainer container, int idx) throws WbemsmtException {
			ResourceRecord resourceRecord = zone.getResourceRecords().getResourceRecord(idx);
            resourceRecord.delete();
            adapter.setMarkedForReload();
            adapter.setPathOfTreeNode(adapter.getSelectedZone().getLinux_DnsZone().getCimObjectPath());
	}

	public void updateControls(DnsResourceRecordListItemContainer container) {
	}

	public void updateControls(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord recordFco) throws WbemsmtException {

		
		try {
            boolean deleted = zone.getResourceRecords().getResourceRecord(recordFco.getCimObjectPath()).isDeleted();
            
            //used for later finding the correct record
            container.setKey(new CimObjectKey(recordFco.getCimObjectPath()));
            
            if (!deleted)
            {
            	String[] units = new String[4];
            	units[0] = adapter.getBundle().getString("ttl.unit." + DnsBusinessObject.MULTI_COMBO_VALUES[0]);
            	units[1] = adapter.getBundle().getString("ttl.unit." + DnsBusinessObject.MULTI_COMBO_VALUES[1]);
            	units[2] = adapter.getBundle().getString("ttl.unit." + DnsBusinessObject.MULTI_COMBO_VALUES[2]);
            	units[3] = adapter.getBundle().getString("ttl.unit." + DnsBusinessObject.MULTI_COMBO_VALUES[3]);
            
            	container.get_Name().setControlValue(recordFco.get_key_Name());

            	DnsBusinessObject.updateTTLDataContainer(adapter,recordFco.get_TTL(), container.get_TTL(),container.get_usr_TTLUnit());
            	
            
            	List<String> family = new ArrayList<String>();
            	family.add(adapter.getBundle().getString("no.family"));
            	family.addAll(Arrays.asList(Linux_DnsResourceRecord.PROPERTY_FAMILY.VALUE_ENTRIES_FOR_DISPLAY));
            	
            	
            	container.get_Family().setValues((String[]) family.toArray(new String[family.size()]));
            	container.get_Family().setControlValue(new UnsignedInteger8((short)(recordFco.get_Family().intValue() + 1)));
            	
            	container.get_Type().setValues(ResourceRecord.TYPES);
            	container.get_Type().setControlValue(ResourceRecord.getIndexByTypeName(recordFco.get_key_Type()));
            	
            	container.get_Value().setControlValue(recordFco.get_key_Value());
            	
            	container.get_Name().getProperties().setSize(LabeledBaseInputComponentIf.SIZE_S);
            	container.get_Value().getProperties().setSize(LabeledBaseInputComponentIf.SIZE_S);
            	container.get_TTL().getProperties().setSize(LabeledBaseInputComponentIf.SIZE_S);
            	
            }
        }
        catch (NumberFormatException e) {
            throw new WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS, e);
        }
		

		
		
		
	}

	public void updateControls(DnsResourceRecordListContainer container ) throws WbemsmtException {
		boolean enabled = zone.getResourceRecords().getResourceRecordsDeleted(false).size() > 0;
        container.get_usr_Delete().getProperties().setReadOnly(!enabled);
        container.get_usr_SelectAll().getProperties().setReadOnly(!enabled);
        container.get_usr_Delete().getProperties().setVisible(enabled);
        container.get_usr_SelectAll().getProperties().setVisible(enabled);

        ((ActionComponent)container.get_usr_Delete()).setNeedConfirmation(true);
        ((ActionComponent)container.get_usr_Delete()).setShowWait(true);
        ((ActionComponent)container.get_usr_Delete()).setWaitText(container.getAdapter().getBundle().getString("deleting.records"));
        
        adapter.updateControls(container.getResourceRecords(), zone.getResourceRecords().getFCOs());
	}

	public MessageList save(DnsResourceRecordListContainer container) throws WbemsmtException {
		
		//because the save action creates/deletes objects and modifies the resource record list we copy the items
		
		return adapter.save(container.getResourceRecords(), zone.getResourceRecords().getFCOs());
	}

	public MessageList revert(DnsResourceRecordListContainer container) throws WbemsmtException {
		return adapter.revert(container.getResourceRecords(), zone.getResourceRecords().getFCOs());
	}

	public MessageList save(DnsResourceRecordListItemContainer container, Linux_DnsResourceRecord fco) throws WbemsmtException {
		
		MessageList list = MessageList.init(container);
        
        ResourceRecord record = zone.getResourceRecords().getResourceRecord(fco.getCimObjectPath());
        if (!record.isDeleted())
        {
        	record.save(container,true);
        	fco.setCimInstance(record.getFco().getCimInstance());
        }
        return list;
	}
}
