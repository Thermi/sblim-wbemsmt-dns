 /** 
  * Service.java
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
  * Description: Wrapper for a Linux_DnsService
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.sblim.wbem.cim.UnsignedInt32;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.Message;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.DnsErrCodes;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowNotifyForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowQueryForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowRecursionForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsAllowTransferForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsBlackholeForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsConfigurationDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsForwardersForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceOperationsDataContainer;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsServiceTracingDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsAddressMatchList;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsForwarders;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsService;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsServiceConfiguration;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsServiceSettingData;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AclHandler;
import org.sblim.wbemsmt.dns.bl.wrapper.acl.AssociatedObjectsLoader;
import org.sblim.wbemsmt.dns.bl.wrapper.list.AddressMatchListList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwardZoneList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ForwarderList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.HintZoneList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MasterZoneList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.MastersList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.ReverseZoneList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.SlaveZoneList;
import org.sblim.wbemsmt.dns.bl.wrapper.list.StubZoneList;
import org.sblim.wbemsmt.exception.InitContainerException;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectRevertException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public class Service extends DnsBusinessObject {

	public static final String STOPPED = "Stopped";

	public static final String RUNNING = "Running";

	public static final int RC_OK = 0;
	public static final int RC_NOT_SUPPORTED = 1;
	public static final int RC_STATE_ALREADY_EXISTS = 2;
	public static final int RC_ERROR_WHILE_EXECUTION = 3;

	private Linux_DnsService fco;
	
	private ForwarderList forwarderList = null;
	
	/**
	 * Lists are filled by the DnsCimAdapter
	 */
	private MasterZoneList masterZoneList = new MasterZoneList();
	private SlaveZoneList slaveZoneList = new SlaveZoneList();
	private StubZoneList stubZoneList = new StubZoneList();
	private HintZoneList hintZoneList = new HintZoneList();
	private ForwardZoneList forwardZoneList = new ForwardZoneList();
	private AddressMatchListList addressMatchListList = new AddressMatchListList();
	private MastersList mastersList = new MastersList();
	private ReverseZoneList reverseZoneList = new ReverseZoneList();
	
	/**
	 * Lazy loaded childs
	 */
	private Linux_DnsServiceSettingData setting = null;
	private Linux_DnsServiceConfiguration configuration = null;

	/**
	 * Handler for acls
	 */
	AclHandler aclHandler = null;

	private Linux_DnsForwarders forwarder;

	/**
	 * 
	 */
	public Service(Linux_DnsService service, final DnsCimAdapter adapter) {
		super(adapter);
		this.fco = service;
		aclHandler = new AclHandler(adapter, new AssociatedObjectsLoader()
		{
			public List load(int index) {
				switch (index) {
				case AclHandler.IDX_NOTIFY:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowNotifyForService_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_TRANSFER:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowTransferForService_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_QUERY:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowQueryForService_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_RECURSION:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowRecursionForService_Names(adapter.getCimClient(),false);
				case AclHandler.IDX_BLACKHOLE:
					return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsBlackholeForService_Names(adapter.getCimClient(),false);
				default:
					break;
				}
				return null;
			}
		}, null);
		
	}

	public Linux_DnsServiceSettingData getSetting() throws ModelLoadException {
		if (setting == null)
		{
			CIMClient cc = adapter.getCimClient();
			List list = getConfiguration().getAssociated_Linux_DnsServiceSettingData_Linux_DnsServiceSettingDataForServiceConfiguration_Names(cc, false);
			setting = (Linux_DnsServiceSettingData)getFirstChild(cc,Linux_DnsServiceSettingData.class,list,false, false);
		}
		return setting;
	}



	public Linux_DnsServiceConfiguration getConfiguration() throws ModelLoadException {
		if (configuration == null)
		{
			CIMClient cc = adapter.getCimClient();
			List list = fco.getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceConfigurationForService_Names(cc,false);
			configuration = (Linux_DnsServiceConfiguration)getFirstChild(cc,Linux_DnsServiceConfiguration.class,list,false, false);
		}
		return configuration;
	}

	public ForwarderList getForwarderList() throws ModelLoadException {
		if (forwarderList == null || forwarderList.isReloadFromServer() )
		{
			forwarderList = new ForwarderList();
			forwarder = (Linux_DnsForwarders) getFirstChild(adapter.getCimClient(), Linux_DnsForwarders.class, fco.getAssociated_Linux_DnsForwarders_Linux_DnsForwardersForService_Names(adapter.getCimClient(), false), true, true);
			addForwarderIps(forwarder,forwarderList);
		}
		return forwarderList;
	}



	public Linux_DnsAddressMatchList getAcl(int index) throws ModelLoadException {
		return aclHandler.getAcl(index);
	}

	/**
	 * Get the wrapped fco
	 * @return
	 */
	public Linux_DnsService getFco() {
		return fco;
	}

	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(fco);
	}

	public AddressMatchListList getAddressMatchListList() {
		return addressMatchListList;
	}

	public void setAddressMatchListList(AddressMatchListList addressMatchListList) {
		this.addressMatchListList = addressMatchListList;
	}

	public MastersList getMastersList() {
		return mastersList;
	}

	public void setMastersList(MastersList masterList) {
		this.mastersList = masterList;
	}

	public ForwardZoneList getForwardZoneList() {
		return forwardZoneList;
	}

	public void setForwardZoneList(ForwardZoneList forwardZoneList) {
		this.forwardZoneList = forwardZoneList;
	}

	public HintZoneList getHintZoneList() {
		return hintZoneList;
	}

	public void setHintZoneList(HintZoneList hintZoneList) {
		this.hintZoneList = hintZoneList;
	}

	public MasterZoneList getMasterZoneList() {
		return masterZoneList;
	}

	public void setMasterZoneList(MasterZoneList masterZoneList) {
		this.masterZoneList = masterZoneList;
	}

	public ReverseZoneList getReverseZoneList() {
		return reverseZoneList;
	}

	public void setReverseZoneList(ReverseZoneList reverseZoneList) {
		this.reverseZoneList = reverseZoneList;
	}

	public SlaveZoneList getSlaveZoneList() {
		return slaveZoneList;
	}

	public void setSlaveZoneList(SlaveZoneList slaveZoneList) {
		this.slaveZoneList = slaveZoneList;
	}
	
	

	public StubZoneList getStubZoneList() {
		return stubZoneList;
	}

	public void setStubZoneList(StubZoneList stubZoneList) {
		this.stubZoneList = stubZoneList;
	}

	public List getZoneList() {
		List allZones = new ArrayList();
		allZones.addAll(getMasterZoneList().getList());
		allZones.addAll(getSlaveZoneList().getList());
		allZones.addAll(getStubZoneList().getList());
		allZones.addAll(getHintZoneList().getList());
		allZones.addAll(getForwardZoneList().getList());
		allZones.addAll(getReverseZoneList().getList());
		return allZones;
	}


	public MessageList save(DnsAllowNotifyForServiceDataContainer container)  throws ObjectSaveException {
		return aclHandler.save(AclHandler.IDX_NOTIFY);
	}
	public MessageList save(DnsBlackholeForServiceDataContainer container) throws ObjectSaveException {
		return aclHandler.save(AclHandler.IDX_BLACKHOLE);
	}

	public MessageList save(DnsAllowTransferForServiceDataContainer container) throws ObjectSaveException {
		return aclHandler.save(AclHandler.IDX_TRANSFER);
	}

	public MessageList save(DnsAllowRecursionForServiceDataContainer container) throws ObjectSaveException {
		return aclHandler.save(AclHandler.IDX_RECURSION);
	}

	public MessageList save(DnsAllowQueryForServiceDataContainer container) throws ObjectSaveException {
		return aclHandler.save(AclHandler.IDX_QUERY);
	}

	public MessageList save(DnsConfigurationDataContainer container) throws ObjectSaveException {
		try {
			getConfiguration().set_ConfigurationFile((String) container.get_ConfigurationFile().getConvertedControlValue());
			String directory = (String) container.get_ConfigurationDirectory().getConvertedControlValue();
			if (DnsCimAdapter.NOT_SET.equals(directory))
			{
				getSetting().set_ConfigurationDirectory(null);	
			}
			else
			{
				getSetting().set_ConfigurationDirectory(directory);
			}
			
			
			if (getConfiguration().isModified() || getSetting().isModified())
			{
				adapter.setMarkedForReload();
			}
			
			FcoHelper.save(getConfiguration(),adapter.getCimClient());
			FcoHelper.save(getSetting(),adapter.getCimClient());
			
			
			
			configuration = null;
			setting = null;
			
			return null;
			
		} catch (ModelLoadException e) {
			throw new ObjectSaveException(e);
		}
	}

	public MessageList save(DnsServiceOperationsDataContainer container) throws ObjectSaveException{
		//do nothing
		return null;
	}

	public void updateControls(DnsAllowNotifyForServiceDataContainer container) throws UpdateControlsException {
		aclHandler.updateControls(container,AclHandler.IDX_NOTIFY,null);
	}

	public void updateControls(DnsAllowQueryForServiceDataContainer container)  throws UpdateControlsException{
		aclHandler.updateControls(container,AclHandler.IDX_QUERY,null);
	}

	public void updateControls(DnsAllowRecursionForServiceDataContainer container)  throws UpdateControlsException{
		aclHandler.updateControls(container,AclHandler.IDX_RECURSION,null);
	}

	public void updateControls(DnsAllowTransferForServiceDataContainer container)  throws UpdateControlsException{
		aclHandler.updateControls(container,AclHandler.IDX_TRANSFER,null);
	}

	public void updateControls(DnsBlackholeForServiceDataContainer container)  throws UpdateControlsException{
		aclHandler.updateControls(container,AclHandler.IDX_BLACKHOLE,null);
	}


	public void updateControls(DnsConfigurationDataContainer container) throws UpdateControlsException {

		try {
			container.get_ConfigurationFile().setControlValue(getConfiguration().get_ConfigurationFile());
			if (getSetting().get_ConfigurationDirectory() != null)
			{
				container.get_ConfigurationDirectory().setControlValue(getSetting().get_ConfigurationDirectory());				
			}
			else
			{
				container.get_ConfigurationDirectory().setControlValue(DnsCimAdapter.NOT_SET);
			}
			
			//TODO where do we get the port number from
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}


	public void updateControls(DnsServiceOperationsDataContainer container) {
		container.get_RunAsRoot().setControlValue(fco.get_RunAsRoot());

		boolean running = fco.get_Started() != null && fco.get_Started().booleanValue();
		container.get_Status().setControlValue(running ? Service.RUNNING : Service.STOPPED);
		container.get_Status().getProperties().setColor(running ? "green" : "red");
		
	}

	public void updateControls(DnsServiceTracingDataContainer container) throws UpdateControlsException {
		
		updateControls(container.getAllowNotifyAcl());
		updateControls(container.getAllowTransferAcl());
		updateControls(container.getAllowRecursionAcl());
		updateControls(container.getAllowQueryAcl());
		updateControls(container.getBlackholeAcl());
		updateControls(container.getConfiguration());
		
		
	}

	public void updateModel(DnsAllowNotifyForServiceDataContainer container) throws ModelUpdateException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_NOTIFY);
	}

	public void updateModel(DnsAllowQueryForServiceDataContainer container) throws ModelUpdateException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_QUERY);
	}

	public void updateModel(DnsAllowRecursionForServiceDataContainer container) throws ModelUpdateException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_RECURSION);
	}

	public void updateModel(DnsAllowTransferForServiceDataContainer container) throws ModelUpdateException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_TRANSFER);
	}

	public void updateModel(DnsBlackholeForServiceDataContainer container) throws ModelUpdateException {
		aclHandler.updateModel(container,null,AclHandler.IDX_BLACKHOLE);
	}


	public void updateModel(DnsServiceOperationsDataContainer container) throws ModelUpdateException {

		CIMClient cc = adapter.getCimClient();
		
		if (DnsCimAdapter.DUMMY_MODE)
		{
			if (adapter.getUpdateTrigger() == container.get_invoke_Start()
				|| adapter.getUpdateTrigger() == container.get_usr_Restart() )
			{
				fco.set_Started(new Boolean(true));
			}
			else
			{
				fco.set_Started(new Boolean(false));
			}
			try {
				fco = (Linux_DnsService) FcoHelper.save(fco,cc);
			} catch (ObjectSaveException e) {
				throw new ModelUpdateException(e);
			}
			
		}
		else
		{
			UnsignedInt32 rc = new UnsignedInt32(0);
			if (adapter.getUpdateTrigger() == container.get_invoke_Start())
			{
				rc = fco.invoke_startService(cc);
				evaluateRC(container,rc,true);
			}
			else if (adapter.getUpdateTrigger() == container.get_invoke_Stop())
			{
				rc = fco.invoke_stopService(cc);
				evaluateRC(container,rc,false);
			}
			else if (adapter.getUpdateTrigger() == container.get_usr_Restart())
			{
				rc = fco.invoke_stopService(cc);
				if (!evaluateRC(container,rc,false))
				{
					return;
				}
				
				rc = fco.invoke_startService(cc);
				evaluateRC(container,rc,true);
			}
			
			
		}
	}

	private boolean evaluateRC(DnsServiceOperationsDataContainer container, UnsignedInt32 rc, boolean start) {
		
		int iRc = (int) rc.longValue();
		if (iRc == RC_OK)
		{
			if (start)
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_START_EXECUTED,Message.SUCCESS, adapter.getBundle().getString("start.executed")));
			}
			else
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_START_EXECUTED,Message.SUCCESS, adapter.getBundle().getString("stop.executed")));
			}
		}
		else if (iRc == RC_NOT_SUPPORTED)
		{
			if (start)
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_START_NOT_EXECUTED,Message.ERROR, adapter.getBundle().getString(DnsErrCodes.MSG_START_NOT_EXECUTED,"start.not.executed")
						+ " - " + adapter.getBundle().getString("not.supported")
						+ " RC: " + iRc));
			}
			else
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_STOP_NOT_EXECUTED,Message.ERROR,adapter.getBundle().getString(DnsErrCodes.MSG_STOP_NOT_EXECUTED,"stop.not.executed")
						+ " - " + adapter.getBundle().getString("not.supported")
						+ " RC: " + iRc));
			}
		}
		else if (iRc == RC_STATE_ALREADY_EXISTS)
		{
			if (start)
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_START_NOT_EXECUTED,Message.WARNING,adapter.getBundle().getString(DnsErrCodes.MSG_START_NOT_EXECUTED,"start.not.executed")
						+ " - " + adapter.getBundle().getString("already.started")
						+ " RC: " + iRc
				));
			}
			else
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_STOP_NOT_EXECUTED,Message.WARNING,adapter.getBundle().getString(DnsErrCodes.MSG_STOP_NOT_EXECUTED,"stop.not.executed")
						+ " - " + adapter.getBundle().getString("already.started")
						+ " RC: " + iRc
						));
			}
		}
		else
		{
			if (start)
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_START_NOT_EXECUTED,Message.ERROR,adapter.getBundle().getString(DnsErrCodes.MSG_START_NOT_EXECUTED,"start.not.executed")
						+ " RC: " + iRc));
			}
			else
			{
				MessageList.init(container).addMessage(new Message(DnsErrCodes.MSG_STOP_NOT_EXECUTED,Message.ERROR,adapter.getBundle().getString(DnsErrCodes.MSG_STOP_NOT_EXECUTED,"stop.not.executed")
						+ " RC: " + iRc));
			}
		}
		
		return iRc == RC_OK;
		
	}

//	private void waitForStatus(DnsServiceOperationsDataContainer container, boolean started) throws ModelUpdateException {
//		
//		int count = 0;
//		while (count < 10)
//		{
//			try {
//				fco = (Linux_DnsService) FcoHelper.reload(fco, adapter.getCimClient());
//				if (fco.get_Started() != null && fco.get_Started().booleanValue() == started)
//				{
//					return;
//				}
//				else
//				{
//					logger.info("Wait and check state of DNS Service again");
//					count++;
//					Thread.sleep(1000);
//				}
//			} catch (ModelLoadException e) {
//				throw new ModelUpdateException("Cannot check if service was started/stopped",e);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (started)
//		{
//			MessageList.init(container).addWarning(adapter.getBundle().getString("start.not.executed"));
//		}
//		else
//		{
//			MessageList.init(container).addWarning(adapter.getBundle().getString("stop.not.executed"));
//		}
//		
//		
//		
//		
//	}

	public void updateModel(DnsForwardersForServiceDataContainer container) throws ModelUpdateException {
		try {
			getSetting().set_Forward(super.getForwarder(container));
			updateForwarders(getForwarderList(),container,null);
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
	}

	public void updateControls(DnsForwardersForServiceDataContainer container) throws UpdateControlsException {
		try {
			super.setForwarder(container,getSetting().get_Forward());
			container.get_Forwarders().setValues(getForwarders(getForwarderList()));
		} catch (ModelLoadException e) {
			throw new UpdateControlsException(e);
		}
	}

	public MessageList save(DnsForwardersForServiceDataContainer container) throws ObjectSaveException {
		try {
			
			//save the forward
			getSetting().set_Forward(super.getForwarder(container));
			FcoHelper.save(getSetting(),adapter.getCimClient());
			setting = null;

			//save the forwarders
			saveForwardersIps(getForwarderList(), forwarder, null);
			forwarderList.setReloadFromServer(true);
			
			return null;
		} catch (ModelLoadException e) {
			throw new ObjectSaveException(e);
		}
	}

	public void initContainer(DnsForwardersForServiceDataContainer container) throws InitContainerException {
		try {
			super.setForwarder(container,getSetting().get_Forward());
		} catch (ModelLoadException e) {
			throw new InitContainerException(e);
		}
	}
	
	public void updateModel(DnsConfigurationDataContainer container) throws ModelUpdateException {

		try {
			if (adapter.getUpdateTrigger() == container.get_usr_RemoveDirectory())
			{
				getSetting().set_ConfigurationDirectory(null);
			}
		} catch (ModelLoadException e) {
			throw new ModelUpdateException(e);
		}
		
	}

	public MessageList revert(DnsAllowNotifyForServiceDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_NOTIFY);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsAllowQueryForServiceDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_QUERY);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsAllowRecursionForServiceDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_RECURSION);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsAllowTransferForServiceDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_TRANSFER);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsBlackholeForServiceDataContainer container) throws ObjectRevertException {
		try {
			aclHandler.resetAcl(AclHandler.IDX_BLACKHOLE);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsConfigurationDataContainer container) throws ObjectRevertException {
		configuration = null;
		try {
			fco = (Linux_DnsService) FcoHelper.reload(fco, adapter.getCimClient());
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsServiceOperationsDataContainer container) throws ObjectRevertException {
		configuration = null;
		try {
			fco = (Linux_DnsService) FcoHelper.reload(fco, adapter.getCimClient());
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}

	public MessageList revert(DnsForwardersForServiceDataContainer container) {
		forwarderList = null;
		setting = null;
		configuration = null;
		return null;
	}



	
}
