 /** 
  * DnsCimAdapter.java
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
  * Description: Adapter for Dns BusinessLogic
  * 
  */

package org.sblim.wbemsmt.dns.bl.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.tree.ICIMClassNode;
import org.sblim.wbemsmt.bl.tree.ICIMInstanceNode;
import org.sblim.wbemsmt.bl.tree.ITaskLauncherTreeNode;
import org.sblim.wbemsmt.dns.bl.fco.*;
import org.sblim.wbemsmt.dns.bl.wrapper.*;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ResourceRecordList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ReverseZoneList;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.AddressMatchListWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.DnsWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.ForwardZoneWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.MasterZoneWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.MastersWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.ResourceRecordWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.ReverseZoneWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.SlaveZoneWizard;
import org.sblim.wbemsmt.dns.bl.wrapper.wizard.StubZoneWizard;
import org.sblim.wbemsmt.dns.filter.DnsZoneNameFilter;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ObjectNotFoundException;
import org.sblim.wbemsmt.exception.WbemSmtException;
import org.sblim.wbemsmt.schema.cim29.tools.FcoHelper;
import org.sblim.wbemsmt.tools.resources.ResourceBundleManager;

public class DnsCimAdapter extends AbstractBaseCimAdapter {

	public static final String[] RESOURCE_BUNDLE_NAMES = new String[]{"messages","messagesDns"};
	public static final boolean DUMMY_MODE = false;
	public static final String DEFAULT_INSTANCE_ID = "named";
	public static final String NOT_SET = "NOT SET";
	
	private DnsSelectionHierarchy selectionHierarchy = new DnsSelectionHierarchy();

	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	DnsCimAdapterCreateIf createDelegatee = null;
	DnsCimAdapterUpdateControlsIf updateControlsDeletegatee = null;
	DnsCimAdapterUpdateModelIf updateModelDelegatee = null;
	DnsCimAdapterSaveIf saveDelegatee = null;
	DnsCimAdapterRevertIf revertDelegatee = null;
	DnsCimAdapterDeleteIf deleteDelegatee = null;
	DnsCimAdapterCountIf countDelegatee = null;
	DnsCimAdapterInstallValidatorsIf installValidatorsDelegatee = null;
	DnsCimAdapterInitWizardIf initWizardDelegatee = null;

	private DnsWizard activeWizard; 
	private MastersWizard mastersWizard; 
	private MasterZoneWizard masterZoneWizard; 
	private SlaveZoneWizard slaveZoneWizard; 
	private StubZoneWizard stubZoneWizard; 
	private ForwardZoneWizard forwardZoneWizard; 
	private ReverseZoneWizard reverseZoneWizard;
	private AddressMatchListWizard addressMatchListWizard;
	private ResourceRecordWizard resourceRecordWizard;
	
	
	private MasterZone selectedMasterZone;
	private SlaveZone selectedSlaveZone;
	private StubZone selectedStubZone;
	private HintZone selectedHintZone;
	private ForwardZone selectedForwardZone;
	private ReverseZone selectedReverseZone;
	private AddressMatchList selectedAddressMatchList;
	private Masters selectedMasters;
	private ResourceRecord selectedResourceRecord;
	private Service dnsService;
	private DnsZoneNameFilter onlyReverseZoneFilter;
	private InitContainerDelegatee initContainerDelegatee;
	private Zone selectedZone;
	
	public DnsCimAdapter(Locale locale) {
		super();
		
		//using the same onlyReverseZoneFilter like the tree for getting the reverse zones
		onlyReverseZoneFilter = new DnsZoneNameFilter(true);
		
		init(ResourceBundleManager.getResourceBundle(RESOURCE_BUNDLE_NAMES,locale),selectionHierarchy,new FcoHelper());
		selectionHierarchy.setAdapter(this);
		createDelegatee = new DnsCimAdapterCreateDelegatee(this);
		updateControlsDeletegatee = new DnsCimAdapterUpdateControlsDelegatee(this);
		updateModelDelegatee = new DnsCimAdapterUpdateModelDelegatee(this);
		saveDelegatee = new DnsCimAdapterSaveDelegatee(this);
		revertDelegatee = new DnsCimAdapterRevertDelegatee(this);
		deleteDelegatee = new DnsCimAdapterDeleteDelegatee(this);
		countDelegatee = new DnsCimAdapterCountDelegatee(this);
		installValidatorsDelegatee = new DnsCimAdapterInstallValidatorsDelegatee(this);
		initWizardDelegatee = new DnsCimAdapterInitWizardDelegatee(this);
		initContainerDelegatee = new DnsCimAdapterInitContainerDelegatee(this);

		mastersWizard = new MastersWizard(this);
		masterZoneWizard = new MasterZoneWizard(this);
		slaveZoneWizard = new SlaveZoneWizard(this);
		stubZoneWizard = new StubZoneWizard(this);
		forwardZoneWizard = new ForwardZoneWizard(this);
		reverseZoneWizard = new ReverseZoneWizard(this);
		addressMatchListWizard = new AddressMatchListWizard(this);
		resourceRecordWizard = new ResourceRecordWizard(this);
		
	}

	public void reLoad(CIMClient cimClient) throws ModelLoadException
	{
		loaded = false;
		load(cimClient);
	}

	public void load(CIMClient cimClient) throws ModelLoadException {
		
		if (loaded)
			return;

		this.cimClient = cimClient;
		
		initDnsService();
		
		ArrayList list = Linux_DnsMasterZoneHelper.enumerateInstances(cimClient,true);
		
		ReverseZoneList reverseZoneList = new ReverseZoneList();
		
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Linux_DnsMasterZone zone = (Linux_DnsMasterZone) iter.next();
			MasterZone wrapper = new MasterZone(zone,this);

			
			if (onlyReverseZoneFilter.accept(zone.getCimInstance(), this.cimClient)) {
				reverseZoneList.addReverseZone(new ReverseZone(new Linux_DnsReverseZoneWrapper(zone),wrapper,this));
			}
			else {
				dnsService.getMasterZoneList().addMasterZone(wrapper);
			}
			ArrayList associatedRecords = zone.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(cimClient,false,false,null);
			addResourceRecords(wrapper, associatedRecords);
		}
		
		list = Linux_DnsSlaveZoneHelper.enumerateInstances(cimClient,true);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Linux_DnsSlaveZone zone = (Linux_DnsSlaveZone) iter.next();
			SlaveZone wrapper = new SlaveZone(zone,this);
			dnsService.getSlaveZoneList().addSlaveZone(wrapper);
			ArrayList associatedRecords = zone.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(cimClient,false,false,null);
			addResourceRecords(wrapper, associatedRecords);
		}

		list = Linux_DnsStubZoneHelper.enumerateInstances(cimClient,true);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Linux_DnsStubZone zone = (Linux_DnsStubZone) iter.next();
			StubZone wrapper = new StubZone(zone,this);
			dnsService.getStubZoneList().addStubZone(wrapper);
			ArrayList associatedRecords = zone.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(cimClient,false,false,null);
			addResourceRecords(wrapper, associatedRecords);
		}

		list = Linux_DnsHintZoneHelper.enumerateInstances(cimClient,true);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Linux_DnsHintZone zone = (Linux_DnsHintZone) iter.next();
			HintZone wrapper = new HintZone(zone,this);
			dnsService.getHintZoneList().addHintZone(wrapper);
			ArrayList associatedRecords = zone.getAssociated_Linux_DnsResourceRecord_Linux_DnsResourceRecordsForZones(cimClient,false,false,null);
			addResourceRecords(wrapper, associatedRecords);
		}
		list = Linux_DnsForwardZoneHelper.enumerateInstances(cimClient,true);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Linux_DnsForwardZone zone = (Linux_DnsForwardZone) iter.next();
			ForwardZone wrapper = new ForwardZone(zone,this);
			dnsService.getForwardZoneList().addForwardZone(wrapper);
			//a forwardZone have no resourcerecords - set a empty list
			wrapper.setResourceRecords(new ResourceRecordList());
		}

		initAddressMatchLists();
		initMastersForService();
		
		loaded = true;
		
	}


	public void loadInitial(CIMClient cimClient) throws ModelLoadException {
		this.cimClient = cimClient;
		initDnsService();
		initAddressMatchLists();
		initMastersForService();
	}
	
	
	public void reLoad(ITaskLauncherTreeNode rootNode) throws ModelLoadException {
		loaded = false;
		load(rootNode);
	}

	public void load(ITaskLauncherTreeNode rootNode) throws ModelLoadException {
		try {
			
			if (loaded == true)
				return;
			this.cimClient = rootNode.getCimClient();
			
			this.rootNode = rootNode;
			
			initDnsService();

			List listWithNodes = rootNode.findInstanceNodes(Linux_DnsMasterZone.CIM_CLASS_NAME);
			for (Iterator iterServiceNodes = listWithNodes.iterator(); iterServiceNodes.hasNext();) {
				ICIMInstanceNode node = (ICIMInstanceNode) iterServiceNodes.next();

				Linux_DnsMasterZone fco = new Linux_DnsMasterZone(node.getCimInstance().getObjectPath(),node.getCimInstance());
				MasterZone wrapper = new MasterZone(fco,this);
				
				if (onlyReverseZoneFilter.accept(fco.getCimInstance(), this.cimClient)) {
					dnsService.getReverseZoneList().addReverseZone(new ReverseZone(new Linux_DnsReverseZoneWrapper(fco),wrapper,this));
				}
				else {
					dnsService.getMasterZoneList().addMasterZone(wrapper);
				}
//				addResourceRecords(wrapper);
				
			}

			listWithNodes = rootNode.findInstanceNodes(Linux_DnsSlaveZone.CIM_CLASS_NAME);
			for (Iterator iterServiceNodes = listWithNodes.iterator(); iterServiceNodes.hasNext();) {
				ICIMInstanceNode node = (ICIMInstanceNode) iterServiceNodes.next();

				Linux_DnsSlaveZone fco = new Linux_DnsSlaveZone(node.getCimInstance().getObjectPath(),node.getCimInstance());
				SlaveZone wrapper = new SlaveZone(fco,this);
				dnsService.getSlaveZoneList().addSlaveZone(wrapper);
//				addResourceRecords(wrapper);
				
			}
		
			listWithNodes = rootNode.findInstanceNodes(Linux_DnsStubZone.CIM_CLASS_NAME);
			for (Iterator iterServiceNodes = listWithNodes.iterator(); iterServiceNodes.hasNext();) {
				ICIMInstanceNode node = (ICIMInstanceNode) iterServiceNodes.next();

				Linux_DnsStubZone fco = new Linux_DnsStubZone(node.getCimInstance().getObjectPath(),node.getCimInstance());
				StubZone wrapper = new StubZone(fco,this);
				dnsService.getStubZoneList().addStubZone(wrapper);
//				addResourceRecords(wrapper);
				
			}

			listWithNodes = rootNode.findInstanceNodes(Linux_DnsForwardZone.CIM_CLASS_NAME);
			for (Iterator iterServiceNodes = listWithNodes.iterator(); iterServiceNodes.hasNext();) {
				ICIMInstanceNode node = (ICIMInstanceNode) iterServiceNodes.next();

				Linux_DnsForwardZone fco = new Linux_DnsForwardZone(node.getCimInstance().getObjectPath(),node.getCimInstance());
				ForwardZone wrapper = new ForwardZone(fco,this);
				dnsService.getForwardZoneList().addForwardZone(wrapper);
				//a forwardZone have no resourcerecords - set a empty list
				wrapper.setResourceRecords(new ResourceRecordList());
			}

			listWithNodes = rootNode.findInstanceNodes(Linux_DnsHintZone.CIM_CLASS_NAME);
			for (Iterator iterServiceNodes = listWithNodes.iterator(); iterServiceNodes.hasNext();) {
				ICIMInstanceNode node = (ICIMInstanceNode) iterServiceNodes.next();

				Linux_DnsHintZone fco = new Linux_DnsHintZone(node.getCimInstance().getObjectPath(),node.getCimInstance());
				HintZone wrapper = new HintZone(fco,this);
				dnsService.getHintZoneList().addHintZone(wrapper);
//				addResourceRecords(wrapper);
			}

			listWithNodes = rootNode.findInstanceNodes(Linux_DnsAddressMatchList.CIM_CLASS_NAME);
			for (Iterator iterServiceNodes = listWithNodes.iterator(); iterServiceNodes.hasNext();) {
				ICIMInstanceNode node = (ICIMInstanceNode) iterServiceNodes.next();

				Linux_DnsAddressMatchList fco = new Linux_DnsAddressMatchList(node.getCimInstance().getObjectPath(),node.getCimInstance());
				AddressMatchList wrapper = new AddressMatchList(fco,this);
				dnsService.getAddressMatchListList().addAddressMatchList(wrapper);
			}

			dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("none",this));
			dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("any",this));
			dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("localhost",this));
			dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("localnets",this));

			listWithNodes = rootNode.findInstanceNodes(Linux_DnsMasters.CIM_CLASS_NAME);
			for (Iterator iterServiceNodes = listWithNodes.iterator(); iterServiceNodes.hasNext();) {
				ICIMInstanceNode node = (ICIMInstanceNode) iterServiceNodes.next();

				Linux_DnsMasters fco = new Linux_DnsMasters(node.getCimInstance().getObjectPath(),node.getCimInstance());
				Masters wrapper = new Masters(fco,this);
				dnsService.getMastersList().addMasters(wrapper);
			}
			
			loaded = true;
			
			

		} catch (WbemSmtException e) {
			throw new ModelLoadException(e);
		}
	}

	private void initDnsService() throws ModelLoadException {
		ArrayList serviceList = Linux_DnsServiceHelper.enumerateInstances(cimClient,true);
		if (serviceList.size() != 1)
		{
			throw new ModelLoadException("Expected one Linux_DnsService and Linux_DnsServiceHelper.enumerateInstances returns " + serviceList.size());
		}
		else
		{
			dnsService = new Service((Linux_DnsService) serviceList.get(0),this);
		}
	}

	private void initAddressMatchLists() throws ModelLoadException {
		
		
		ArrayList list = getDnsService().getFco().getAssociated_Linux_DnsAddressMatchList_Linux_DnsAddressMatchListsForServices(cimClient, false, false, null);
		//ArrayList list = Linux_DnsAddressMatchListsForServiceHelper.enumerateInstances(cimClient,true);

		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Linux_DnsAddressMatchList addressMatchList = (Linux_DnsAddressMatchList) iter.next();
			AddressMatchList wrapper = new AddressMatchList(addressMatchList,this);
			dnsService.getAddressMatchListList().addAddressMatchList(wrapper);
		}
		
//		AddressMatchList wrapper = new AddressMatchList(
//				(Linux_DnsAddressMatchList) FcoHelper.reload(Linux_DnsAddressMatchListHelper.class,assoc.get_Linux_DnsAddressMatchList(),cimClient),
//				this);

//		for (Iterator iter = list.iterator(); iter.hasNext();) {
//			Linux_DnsAddressMatchListsForService assoc = (Linux_DnsAddressMatchListsForService) iter.next();
//			//load without reloading the object ???
//			AddressMatchList wrapper = new AddressMatchList(
//					(Linux_DnsAddressMatchList) FcoHelper.reload(Linux_DnsAddressMatchListHelper.class,assoc.get_Linux_DnsAddressMatchList(),cimClient),
//					this);
//			dnsService.getAddressMatchListList().addAddressMatchList(wrapper);
//		}
		
		dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("none",this));
		dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("any",this));
		dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("localhost",this));
		dnsService.getAddressMatchListList().addAddressMatchList(new AddressMatchList("localnets",this));
		
	}

	private void initMastersForService() throws ModelLoadException {
		
		ArrayList list = getDnsService().getFco().getAssociated_Linux_DnsMasters_Linux_DnsMastersForServices(cimClient, false, false, null);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Linux_DnsMasters masters = (Linux_DnsMasters) iter.next();
			Masters wrapper = new Masters(masters,this);
			dnsService.getMastersList().addMasters(wrapper);
		}
		
//		ArrayList list = Linux_DnsMastersForServiceHelper.enumerateInstances(cimClient,true);
//		
//		for (Iterator iter = list.iterator(); iter.hasNext();) {
//			Linux_DnsMastersForService assoc = (Linux_DnsMastersForService) iter.next();
//			//load without reloading the object ???
//			Masters wrapper = new Masters(
//					(Linux_DnsMasters) FcoHelper.reload(Linux_DnsMastersHelper.class,assoc.get_Linux_DnsMasters(),cimClient),
//					this);
//			dnsService.getMastersList().addMasters(wrapper);
//		}
	}

	public void addResourceRecords(Zone wrapper, ArrayList associatedRecords) {
		ResourceRecordList records = new ResourceRecordList();
		wrapper.setResourceRecords(records);
		for (Iterator iter2 = associatedRecords.iterator(); iter2.hasNext();) {
			Linux_DnsResourceRecord rrFco = (Linux_DnsResourceRecord) iter2.next();
			records.addResourceRecord(new ResourceRecord(wrapper,rrFco,this));
		}
	}
	
	public CimObjectKey getKeyByTreeNode(ITaskLauncherTreeNode treeNode) throws ObjectNotFoundException {

		if (treeNode instanceof ICIMInstanceNode) {
			ICIMInstanceNode node = (ICIMInstanceNode) treeNode;
			if (node.getCimInstance().getClassName().equals(Linux_DnsMasterZone.CIM_CLASS_NAME)
				|| node.getCimInstance().getClassName().equals(Linux_DnsSlaveZone.CIM_CLASS_NAME)
				|| node.getCimInstance().getClassName().equals(Linux_DnsStubZone.CIM_CLASS_NAME)
				|| node.getCimInstance().getClassName().equals(Linux_DnsHintZone.CIM_CLASS_NAME)
				|| node.getCimInstance().getClassName().equals(Linux_DnsForwardZone.CIM_CLASS_NAME)
				|| node.getCimInstance().getClassName().equals(Linux_DnsZone.CIM_CLASS_NAME)
				|| node.getCimInstance().getClassName().equals(Linux_DnsAddressMatchList.CIM_CLASS_NAME)
				|| node.getCimInstance().getClassName().equals(Linux_DnsMasters.CIM_CLASS_NAME)
				)
			{
				ICIMInstanceNode serviceNode = (ICIMInstanceNode) node.getParent().getParent();
				CimObjectKey key = new CimObjectKey(serviceNode);
				key.setNextKey(new CimObjectKey(node));
				return key;
			}
			if (node.getCimInstance().getClassName().equals(Linux_DnsService.CIM_CLASS_NAME))
			{
					ICIMInstanceNode serviceNode = (ICIMInstanceNode) node;
					CimObjectKey key = new CimObjectKey(serviceNode);
					return key;
			}
			if (node.getCimInstance().getClassName().equals(Linux_DnsResourceRecord.CIM_CLASS_NAME))
				{
					ICIMInstanceNode zoneNode = (ICIMInstanceNode) node.getParent().getParent();
					ICIMInstanceNode serviceNode = (ICIMInstanceNode) zoneNode.getParent().getParent();
					CimObjectKey serviceKey = new CimObjectKey(serviceNode);
					CimObjectKey zoneKey = new CimObjectKey(zoneNode);
					CimObjectKey recordKey = new CimObjectKey(node);
					
					serviceKey.setNextKey(zoneKey);
					zoneKey.setNextKey(recordKey);
					return serviceKey;
				}
		}
		
		//for the zones and the acls we select the dns service
		else if (treeNode instanceof ICIMClassNode) {
			ICIMClassNode classNode = (ICIMClassNode) treeNode;
			if (classNode.getName().equals("tree.addressMatchLists")
				|| classNode.getName().equals("tree.masters")	
				|| classNode.getName().equals("tree.masterzones")	
				|| classNode.getName().equals("tree.slavezones")	
				|| classNode.getName().equals("tree.stubzones")	
				|| classNode.getName().equals("tree.forwardzones")	
				|| classNode.getName().equals("tree.hintzones")	
				|| classNode.getName().equals("tree.reversezones")	
				)
			{
				return new CimObjectKey(dnsService.getFco().getCimInstance().getObjectPath());
			}
		}
		return null;
	}

	public String[] getResourceBundleNames() {
		return RESOURCE_BUNDLE_NAMES;
	}

	public boolean select_1_Linux_DnsMasterZone(CimObjectKey key)
	{
		//The select-Method is called even if this is a reverseZone because there is no real CIMObject for a reverse Zone 
		//so check if we have a reverse zone and delegate the call to the right methog
		String zoneName = (String) key.getObjectPath().getKey(Linux_DnsZone.CIM_PROPERTY_NAME).getValue().getValue();
		if (onlyReverseZoneFilter.accept(zoneName))
		{
			return select_1_Linux_DnsReverseZoneWrapper(key);
		}
		
		
		MasterZone zone =  dnsService.getMasterZoneList().getMasterZone(key.getObjectPath());
		//if zone was not found try to reload
		if (zone == null)
		{
			try {
				Linux_DnsMasterZone fco = Linux_DnsMasterZoneHelper.getInstance(cimClient,key.getObjectPath());
				if (fco != null)
				{
					zone = new MasterZone(fco,this);
					zone.loadChilds(cimClient);
					selectionHierarchy.add(zone);
					dnsService.getMasterZoneList().addMasterZone(zone);

					//zone loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select Zone with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(zone);
			//zone found
			return true;
		}
	}
	public boolean select_1_Linux_DnsSlaveZone(CimObjectKey key)
	{
		SlaveZone zone =  dnsService.getSlaveZoneList().getSlaveZone(key.getObjectPath());
		//if zone was not found try to reload
		if (zone == null)
		{
			try {
				Linux_DnsSlaveZone fco = Linux_DnsSlaveZoneHelper.getInstance(cimClient,key.getObjectPath());
				if (fco != null)
				{
					zone = new SlaveZone(fco,this);
					zone.loadChilds(cimClient);
					selectionHierarchy.add(zone);
					dnsService.getSlaveZoneList().addSlaveZone(zone);
					//zone loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select Zone with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(zone);
			//zone found
			return true;
		}
	}
	
	public boolean select_1_Linux_DnsStubZone(CimObjectKey key)
	{
		StubZone zone =  dnsService.getStubZoneList().getStubZone(key.getObjectPath());
		//if zone was not found try to reload
		if (zone == null)
		{
			try {
				Linux_DnsStubZone fco = Linux_DnsStubZoneHelper.getInstance(cimClient,key.getObjectPath());
				if (fco != null)
				{
					zone = new StubZone(fco,this);
					zone.loadChilds(cimClient);
					selectionHierarchy.add(zone);
					dnsService.getStubZoneList().addStubZone(zone);
					//zone loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select Zone with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(zone);
			//zone found
			return true;
		}
	}

	public boolean select_0_Linux_DnsService(CimObjectKey key)
	{
		return true;
	}
	
	public boolean select_1_Linux_DnsHintZone(CimObjectKey key)
	{
		HintZone zone =  dnsService.getHintZoneList().getHintZone(key.getObjectPath());
		//if zone was not found try to reload
		if (zone == null)
		{
			try {
				Linux_DnsHintZone fco = Linux_DnsHintZoneHelper.getInstance(cimClient,key.getObjectPath());
				if (fco != null)
				{
					zone = new HintZone(fco,this);
					zone.loadChilds(cimClient);
					selectionHierarchy.add(zone);
					dnsService.getHintZoneList().addHintZone(zone);
					//zone loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select Zone with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(zone);
			//zone found
			return true;
		}
	}
	public boolean select_1_Linux_DnsForwardZone(CimObjectKey key)
	{
		ForwardZone zone =  dnsService.getForwardZoneList().getForwardZone(key.getObjectPath());
		//if zone was not found try to reload
		if (zone == null)
		{
			try {
				Linux_DnsForwardZone fco = Linux_DnsForwardZoneHelper.getInstance(cimClient,key.getObjectPath());
				if (fco != null)
				{
					zone = new ForwardZone(fco,this);
					zone.loadChilds(cimClient);
					selectionHierarchy.add(zone);
					dnsService.getForwardZoneList().addForwardZone(zone);
					//zone loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select Zone with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(zone);
			//zone found
			return true;
		}
	}
	public boolean select_1_Linux_DnsReverseZoneWrapper(CimObjectKey key)
	{
		ReverseZone zone =  dnsService.getReverseZoneList().getReverseZone(key.getObjectPath());
		//if zone was not found try to reload
		if (zone == null)
		{
			try {
				Linux_DnsMasterZone fco = null;
				if (key.getObjectPath().getObjectName().equals(Linux_DnsMasterZone.CIM_CLASS_NAME))
				{
					fco = Linux_DnsMasterZoneHelper.getInstance(cimClient,key.getObjectPath());
				}
				else
				{
					logger.severe("Can only select Linux_DnsReverseZoneWrapper with ObjectKey having ObjectPath of " + Linux_DnsMasterZone.CIM_CLASS_NAME);
				}
				
				if (fco != null)
				{
					zone = new ReverseZone(fco,this);
					zone.loadChilds(cimClient);
					selectionHierarchy.add(zone);
					dnsService.getReverseZoneList().addReverseZone(zone);
					//zone loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select Zone with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(zone);
			//zone found
			return true;
		}
	}
	
	public boolean select_1_Linux_DnsAddressMatchList(CimObjectKey key)
	{
		AddressMatchList aml =  dnsService.getAddressMatchListList().getAddressMatchList(key.getObjectPath());
		//if zone was not found try to reload
		if (aml == null)
		{
			try {
				Linux_DnsAddressMatchList fco = Linux_DnsAddressMatchListHelper.getInstance(cimClient,key.getObjectPath());
				if (fco != null)
				{
					aml = new AddressMatchList(fco,this);
					aml.loadChilds(cimClient);
					selectionHierarchy.add(aml);
					dnsService.getAddressMatchListList().addAddressMatchList(aml);
					//AddressMatchList loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select AddressMatchList with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(aml);
			//AddressMatchList found
			return true;
		}
	}	
	
	public boolean select_1_Linux_DnsMasters(CimObjectKey key)
	{
		Masters aml =  dnsService.getMastersList().getMasters(key.getObjectPath());
		//if zone was not found try to reload
		if (aml == null)
		{
			try {
				Linux_DnsMasters fco = Linux_DnsMastersHelper.getInstance(cimClient,key.getObjectPath());
				if (fco != null)
				{
					aml = new Masters(fco,this);
					aml.loadChilds(cimClient);
					selectionHierarchy.add(aml);
					dnsService.getMastersList().addMasters(aml);
					//Masters loaded
					return true;
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE,"Cannot select Masters with key " + key.toString(),e);
			}
			//zone not found
			return false;
		}
		else
		{
			selectionHierarchy.add(aml);
			//Masters found
			return true;
		}
	}	

	public boolean select_2_Linux_DnsResourceRecord(CimObjectKey key)
	{
		Zone zone = getSelectedZone();
		ResourceRecordList resourceRecords = zone.getResourceRecords();

		ResourceRecord rr = resourceRecords.getResourceRecord(key);
		if (rr != null)
		{
			selectionHierarchy.add(rr);
			return true;
		}
		
		//if object was not found try to reload
		try {
			Linux_DnsResourceRecord fco = Linux_DnsResourceRecordHelper.getInstance(cimClient,key.getObjectPath());
			if (fco != null)
			{
				rr = new ResourceRecord(zone,fco,this);
				resourceRecords.addResourceRecord(rr);
				selectionHierarchy.add(rr);
				resourceRecords.addResourceRecord(rr);
				return true;
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Cannot select Linux_DnsResourceRecord with key " + key.toString(),e);
		}
		
		return false;
	}

	public AddressMatchList getSelectedAddressMatchList() {
		return selectedAddressMatchList;
	}

	public void setSelectedAddressMatchList(
			AddressMatchList selectedAddressMatchList) {
		this.selectedAddressMatchList = selectedAddressMatchList;
	}

	
	public Masters getSelectedMasters() {
		return selectedMasters;
	}

	public void setSelectedMasters(Masters selectedMasters) {
		this.selectedMasters = selectedMasters;
	}

	public ForwardZone getSelectedForwardZone() {
		return selectedForwardZone;
	}

	public void setSelectedForwardZone(ForwardZone selectedForwardZone) {
		clearSelectedZones();
		this.selectedZone = this.selectedForwardZone = selectedForwardZone;
	}

	public HintZone getSelectedHintZone() {
		return selectedHintZone;
	}

	public void setSelectedHintZone(HintZone selectedHintZone) {
		clearSelectedZones();
		this.selectedZone = this.selectedHintZone = selectedHintZone;
	}

	public MasterZone getSelectedMasterZone() {
		return selectedMasterZone;
	}

	public Zone getSelectedZone() {
		return selectedZone;
	}

	public void setSelectedMasterZone(MasterZone selectedMasterZone) {
		clearSelectedZones();
		this.selectedZone = this.selectedMasterZone = selectedMasterZone;
	}

	public ResourceRecord getSelectedResourceRecord() {
		return selectedResourceRecord;
	}

	public void setSelectedResourceRecord(ResourceRecord selectedResourceRecord) {
		this.selectedResourceRecord = selectedResourceRecord;
	}

	public ReverseZone getSelectedReverseZone() {
		return selectedReverseZone;
	}

	public void setSelectedReverseZone(ReverseZone selectedReverseZone) {
		clearSelectedZones();
		this.selectedZone = this.selectedReverseZone = selectedReverseZone;
	}

	public SlaveZone getSelectedSlaveZone() {
		return selectedSlaveZone;
	}

	public StubZone getSelectedStubZone() {
		return selectedStubZone;
	}

	public void setSelectedSlaveZone(SlaveZone selectedSlaveZone) {
		clearSelectedZones();
		this.selectedZone = this.selectedSlaveZone = selectedSlaveZone;
	}
	
	public void setSelectedStubZone(StubZone selectedStubZone) {
		clearSelectedZones();
		this.selectedZone = this.selectedStubZone = selectedStubZone;
	}

	public void clearSelectedZones()
	{
		this.selectedZone = null;
		this.selectedForwardZone = null; 
		this.selectedHintZone = null;
		this.selectedMasterZone = null;
		this.selectedReverseZone = null;
		this.selectedSlaveZone = null;
		this.selectedStubZone = null;
		this.selectedResourceRecord = null;
		this.activeWizard = null;
	}

	public AddressMatchListWizard getAddressMatchListWizard() {
		return addressMatchListWizard;
	}

	public ForwardZoneWizard getForwardZoneWizard() {
		return forwardZoneWizard;
	}

	public MastersWizard getMastersWizard() {
		return mastersWizard;
	}

	public MasterZoneWizard getMasterZoneWizard() {
		return masterZoneWizard;
	}

	public ResourceRecordWizard getResourceRecordWizard() {
		return resourceRecordWizard;
	}

	public ReverseZoneWizard getReverseZoneWizard() {
		return reverseZoneWizard;
	}

	public SlaveZoneWizard getSlaveZoneWizard() {
		return slaveZoneWizard;
	}

	public StubZoneWizard getStubZoneWizard() {
		return stubZoneWizard;
	}

	public CreateDelegatee getCreateDelegatee() {
		return createDelegatee;
	}

	public SaveDelegatee getSaveDelegatee() {
		return saveDelegatee;
	}

	public RevertDelegatee getRevertDelegatee() {
		return revertDelegatee;
	}

	public DeleteDelegatee getDeleteDelegatee() {
		return deleteDelegatee;
	}

	public UpdateControlsDelegatee getUpdateControlsDelegatee() {
		return updateControlsDeletegatee;
	}

	public UpdateModelDelegatee getUpdateModelDelegatee() {
		return updateModelDelegatee;
	}

	public CountDelegatee getCountDelegatee() {
		return countDelegatee;
	}

	public InstallValidatorsDelegatee getInstallValidatorsDelegatee() {
		return installValidatorsDelegatee;
	}

	public InitWizardDelegatee getInitWizardDelegatee() {
		return initWizardDelegatee;
	}
	
	public InitContainerDelegatee getInitContainerDelegatee() {
		return initContainerDelegatee;
	}
	

	public DnsSelectionHierarchy getSelectionHierarchy() {
		return selectionHierarchy;
	}

	public Service getDnsService() throws ModelLoadException {
		if (dnsService == null)
		{
			initDnsService();
		}
		return dnsService;
	}

	public Service getDnsService(String serviceName) throws ModelLoadException {
		// TODO use serviceName parameter if more than one service is needed
		return getDnsService();
	}

	public DnsWizard getActiveWizard() {
		return activeWizard;
	}

	public void setActiveWizard(DnsWizard activeWizard) {
		this.activeWizard = activeWizard;
	}

	public Zone getZone(String serviceName, String zoneName) throws ModelLoadException {
		//TODO first select service if more than one service is supported
		ArrayList list = Linux_DnsZoneHelper.enumerateInstances(getCimClient(),true);
		for (Iterator iter = list.iterator(); iter.hasNext();) 
		{
			Linux_DnsZone zoneFco =  (Linux_DnsZone) iter.next();
			CIMObjectPath path = zoneFco.getCimObjectPath();
			if (zoneFco.get_Name().equals(zoneName))
			{
				int zoneType = zoneFco.get_Type().intValue();
				if (zoneType == Linux_DnsZone.TYPE_MASTER)
				{
					Linux_DnsMasterZone fco = Linux_DnsMasterZoneHelper.getInstance(getCimClient(),path);
					MasterZone zone = new MasterZone(fco,this);
					getDnsService().getMasterZoneList().addMasterZone(zone);
					return zone;
				}
				else if (zoneType == Linux_DnsZone.TYPE_SLAVE || zoneType == Linux_DnsZone.TYPE_STUB)
				{
					Linux_DnsSlaveZone fco = Linux_DnsSlaveZoneHelper.getInstance(getCimClient(),path);
					SlaveZone zone = new SlaveZone(fco,this);
					getDnsService().getSlaveZoneList().addSlaveZone(zone);
					return zone;
				}
				else if (zoneType == Linux_DnsZone.TYPE_HINT)
				{
					Linux_DnsHintZone fco = Linux_DnsHintZoneHelper.getInstance(getCimClient(),path);
					HintZone zone = new HintZone(fco,this);
					getDnsService().getHintZoneList().addHintZone(zone);
					return zone;
				}
				else if (zoneType == Linux_DnsZone.TYPE_FORWARD)
				{
					Linux_DnsForwardZone fco = Linux_DnsForwardZoneHelper.getInstance(getCimClient(),path);
					ForwardZone zone = new ForwardZone(fco,this);
					getDnsService().getForwardZoneList().addForwardZone(zone);
					return zone;
				}
				else
				{
					throw new ModelLoadException("Cannot load zone " + zoneName + " with zone of type " + zoneType);
				}
			}
		}
		throw new ModelLoadException(bundle.getString("zone.not.found",new Object[]{zoneName}));
	}
	
}
