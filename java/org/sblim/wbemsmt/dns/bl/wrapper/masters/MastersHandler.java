package org.sblim.wbemsmt.dns.bl.wrapper.masters;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.cim.UnsignedInteger16;
import javax.cim.UnsignedInteger8;

import org.apache.commons.lang.StringUtils;
import org.sblim.wbemsmt.bl.messages.Message;
import org.sblim.wbemsmt.bl.messages.MessageList;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAddMasterAddressDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardPage1DataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsMastersWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.container.wizard.DnsStubZoneWizardSummaryDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForZone;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsZone;
import org.sblim.wbemsmt.dns.bl.validator.MastersElementValidator;
import org.sblim.wbemsmt.dns.bl.wrapper.MasterItem;
import org.sblim.wbemsmt.dns.bl.wrapper.Masters;
import org.sblim.wbemsmt.dns.bl.wrapper.NameFactory;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MasterItemList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MastersList;
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf;

public class MastersHandler {

	
	private Linux_DnsMasters masters;
	private MasterItemList usedItems = null;
	private MasterItemList predefinedItems = null;
	private DnsCimAdapter adapter;

	Logger logger = Logger.getLogger(this.getClass().getName());
	private boolean usedForPredefining;
	
	//name of the masters directive - only != null if it is a master of the options-section
	private String mastersName = null;
	private Linux_DnsZone zone;

	public MastersHandler(DnsCimAdapter adapter, Linux_DnsMasters masters,boolean usedForPredefining, Linux_DnsZone zone) {
		this.adapter = adapter;
		this.masters = masters;
		this.usedForPredefining = usedForPredefining;
		this.zone = zone;
		if (usedForPredefining && masters != null)
		{
			this.mastersName = masters.get_key_Name();
		}
	}


	public MasterItemList getUsedItems() throws WbemsmtException {
		if (usedItems == null || usedItems.isReloadFromServer())
		{
			usedItems = new MasterItemList();
			if (masters.get_MasterElement().length != masters.get_MasterElementType().length)
			{
				throw new WbemsmtException(WbemsmtException.ERR_LOADING_MODEL,"The Arrays masterElement and MasterElementType-Array of Object " + masters.toString() + " having not the same size");
			}
			
			for (int i=0; i < masters.get_MasterElement().length; i++)
			{
				usedItems.addMasterItem(new MasterItem(masters.get_MasterElement()[i],masters.get_MasterElementType()[i],adapter,usedForPredefining));
			}
		}
		return usedItems;
	}
	
	public MasterItemList getPredefinedItems() throws WbemsmtException {
		if (predefinedItems == null || predefinedItems.isReloadFromServer())
		{
			predefinedItems = new MasterItemList();
			MastersList mastersList = adapter.getDnsService().getMastersList();
			for (int i=0; i < mastersList.size(); i++)
			{
				Masters masters = mastersList.getMasters(i);
				String fcosMastersName = masters.getFco().get_key_Name();
				//if the predefined is not part of the used masters add the item
				if (getUsedItems().getMasterItemByName(fcosMastersName) == null && !fcosMastersName.equals(mastersName))
				{
					predefinedItems.addMasterItem(new MasterItem(fcosMastersName,Linux_DnsMasters.PROPERTY_MASTERELEMENTTYPE.VALUE_MAP_ENTRY_3_FOR_VALUE_ENTRY_NestedMaster,adapter,true));
				}
			}
		}
		return predefinedItems;
	}


	/**
	 * Saves only if it is a valid ciminstance. Otherwise the modified instance is returned.
	 * The attributes MasterElement and MasterElementType are modified
	 * @return
	 * @throws WbemsmtException
	 */
	public Linux_DnsMasters save() throws WbemsmtException {
		
		
		if (!masters.isFromServer() && usedItems.size() > 0)
        {
        	if (!usedForPredefining)
        	{
        		if (masters.get_key_Name() == null)
        		{
        			masters.set_key_Name(NameFactory.createName(Linux_DnsMastersForZone.class, zone.get_key_Name()));
        		}
        		masters.set_key_InstanceID(DnsCimAdapter.DEFAULT_INSTANCE_ID);
        		
        		masters = (Linux_DnsMasters) adapter.getFcoHelper().create(masters, adapter.getCimClient());
        		createAssociation(masters, zone);
        	}
        }		
        
        List ipList = new ArrayList();
        List typeList = new ArrayList();
        
        for (int i=0; i < usedItems.size(); i++)
        {
        	MasterItem ip = usedItems.getMasterItem(i);
        	ipList.add(ip.getIp());
        	typeList.add(ip.getType());
        }
        
        masters.set_MasterElement((String[]) ipList.toArray(new String[ipList.size()]));
        masters.set_MasterElementType((UnsignedInteger8[]) typeList.toArray(new UnsignedInteger8[typeList.size()]));
        
        usedItems.setReloadFromServer(true);
        if (masters.isFromServer())
        {
        	masters = (Linux_DnsMasters) adapter.getFcoHelper().save(masters, adapter.getCimClient());
        }
        return masters;
	}
	
	public void updateIpAddressList(DnsStubZoneWizardSummaryDataContainer container)  throws WbemsmtException{
		updateIpAddressList(null, container.get_usr_IpAdressses());
	}
	
	public void updateIpAddressList(DnsMastersForServiceDataContainer container)  throws WbemsmtException{
		updateIpAddressList(container.get_usr_PredefinedMasters(), container.get_Masters());
	}

	public void updateIpAddressList(DnsMastersWizardSummaryDataContainer container)  throws WbemsmtException{
		updateIpAddressList(null, container.get_AddressList());
	}
	
	public void updateIpAddressList(DnsMastersWizardPage1DataContainer container)  throws WbemsmtException{
		updateIpAddressList(container.get_usr_PredefinedMasters(), container.get_Masters());
	}

	public void updateIpAddressList(DnsSlaveZoneWizardSummaryDataContainer container)  throws WbemsmtException{
		updateIpAddressList(null, container.get_usr_IpAdressses());
	}
	
	public void updateIpAddressList(DnsAddMasterAddressDataContainer container)  throws WbemsmtException{
		updateIpAddressList(container.get_usr_PredefinedMasters(), container.get_Masters());
	}

	public void updateIpAddressList(LabeledStringArrayInputComponentIf predefinedMasterAddresses, LabeledStringArrayInputComponentIf usedMasterAddresses) throws WbemsmtException {
		getUsedItems().reloadListValues();
        List listForUI = new ArrayList();
        for (int i=0; i < getUsedItems().size(); i++)
        {
        	MasterItem ip = getUsedItems().getMasterItem(i);
        	listForUI.add(ip.getDisplayString());				
        }
        usedMasterAddresses.setValues((String[]) listForUI.toArray(new String[listForUI.size()]));
        usedMasterAddresses.setControlValue(null);

        if (predefinedMasterAddresses != null)
        {
        	getPredefinedItems().reloadListValues();
        	listForUI = new ArrayList();
        	for (int i=0; i < getPredefinedItems().size(); i++)
        	{
        		MasterItem ip = getPredefinedItems().getMasterItem(i);
        		listForUI.add(ip.getDisplayString());				
        	}
        	predefinedMasterAddresses.setValues((String[]) listForUI.toArray(new String[listForUI.size()]));
        	predefinedMasterAddresses.setControlValue(null);
        }
		
	
	}

	public void updateAddressModel(DnsAddMasterAddressDataContainer container) throws WbemsmtException {
		MessageList list = MessageList.init(container);

        if (adapter.getUpdateTrigger() == container.get_usr_AddNewMasterEntry())
        {
        	String newAddress = (String) container.get_usr_NewMasterEntry().getConvertedControlValue();

        	if (StringUtils.isNotEmpty(newAddress))
        	{
        		
        		MastersElementValidator validator = new MastersElementValidator(container.get_usr_NewMasterEntry(),adapter);
        		list.addAll(validator.validate());
        		if (!validator.isValidationOK())
        		{
        			return;
        		}
        		
        		
        		boolean found = usedItems.getMasterItemByName(newAddress) != null;
        		
        		
        		if (!found)
        		{
        			if (validator.isPredefinedMaster())
        			{
        				MasterItem predefinedMasterItem = predefinedItems.getMasterItemByName(newAddress);
        				if (predefinedMasterItem != null)
        				{
        					predefinedItems.remove(predefinedMasterItem);
        					MasterItem item = new MasterItem(newAddress,Linux_DnsMasters.PROPERTY_MASTERELEMENTTYPE.VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_IPv4,adapter,validator.isPredefinedMaster());
        					usedItems.addMasterItem(item);
        					container.get_Masters().setModified(true);

        				}
        				else
        				{
        					String msg = adapter.getBundle().getString(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_IP,"value.not.added.to.ip",new Object[]{newAddress});
        					list.addMessage(new Message(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_IP,Message.WARNING,msg));
        					
        				}
        			}
        			else
        			{
        				MasterItem item = new MasterItem(newAddress,Linux_DnsMasters.PROPERTY_MASTERELEMENTTYPE.VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_IPv4,adapter,validator.isPredefinedMaster());
        				usedItems.addMasterItem(item);
        				container.get_Masters().setModified(true);
        			}
        			
        		}
        		else
        		{
        			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_IP,"value.not.added.to.ip",new Object[]{newAddress});
        			list.addMessage(new Message(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_IP,Message.WARNING,msg));
        		}
        		container.get_usr_NewMasterEntry().setControlValue("");
        		updateIpAddressList(container);
        	}
        	else
        	{
        		String msg = adapter.getBundle().getString(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_IP_EMPTY_IP,"value.not.added.to.ip.empty.ip",new Object[]{container.get_usr_NewMasterEntry().getLabelText()});
        		list.addMessage(new Message(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_IP_EMPTY_IP,Message.WARNING,msg));
        	}
        }
        else if (adapter.getUpdateTrigger() == container.get_usr_AddPredefinedMaster())
        {

        	List indexList = (List) container.get_usr_PredefinedMasters().getConvertedControlValue();
        	
        	for (int i = indexList.size() - 1; i >= 0; i--) {
        		UnsignedInteger16 index = (UnsignedInteger16)indexList.get(i);
        		MasterItem predefinedMasterItem = predefinedItems.getMasterItem(index.intValue());
        		boolean found = usedItems.getMasterItemByName(predefinedMasterItem.getIp()) != null;
        		
        		if (!found)
        		{
        			predefinedMasterItem.setPredefined(true);
        			usedItems.addMasterItem(predefinedMasterItem);
        			predefinedItems.remove(predefinedMasterItem);
        			container.get_Masters().setModified(true);
        		}
        		else
        		{
        			String msg = adapter.getBundle().getString(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_MASTER,"value.not.added.to.master",new Object[]{predefinedMasterItem.getIp()});
        			list.addMessage(new Message(DnsErrCodes.MSG_VALUE_NOT_ADDED_TO_MASTER,Message.WARNING,msg));
        		}
        		updateIpAddressList(container);
        	}
        	//reset the values
        	container.get_usr_PredefinedMasters().setControlValue(new ArrayList());
        }
        else if (adapter.getUpdateTrigger() == container.get_usr_RemoveMasterEntry())
        {
        	List indexList = (List) container.get_Masters().getConvertedControlValue();
        	for (int i = indexList.size() - 1; i >= 0; i--) {
        		UnsignedInteger16 index = (UnsignedInteger16) indexList.get(i);
        		MasterItem ipAddressToRemove = usedItems.getMasterItem(index.intValue());
        		usedItems.remove(ipAddressToRemove);
        		if (ipAddressToRemove.isPredefined())
        		{
        			predefinedItems.addMasterItem(ipAddressToRemove);
        		}
        		container.get_Masters().setModified(true);
        	}
        	updateIpAddressList(container);
        }
        
        predefinedItems.reloadListValues();
        usedItems.reloadListValues();
	}


	public void createAssociation(Linux_DnsMasters masters, Linux_DnsZone zone) throws WbemsmtException {
		
		if (DnsCimAdapter.DUMMY_MODE)
        {
            Linux_DnsMastersForZone assoc = new Linux_DnsMastersForZone(adapter.getCimClient(),adapter.getNamespace());
            assoc.set_GroupComponent_Linux_DnsZone(zone);
            assoc.set_PartComponent_Linux_DnsMasters(masters);
            adapter.getFcoHelper().create(assoc, adapter.getCimClient());               		
        }
	}


	public Linux_DnsZone getZone() {
		return zone;
	}


	public void setZone(Linux_DnsZone zone) {
		this.zone = zone;
	}

	

}
