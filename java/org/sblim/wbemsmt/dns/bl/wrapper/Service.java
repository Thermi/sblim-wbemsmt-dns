 /** 
  * Service.java
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
  * Description: Wrapper for a Linux_DnsService
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.cim.CIMObjectPath;
import javax.cim.UnsignedInteger32;
import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.messages.Message;
import org.sblim.wbemsmt.bl.messages.MessageList;
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
import org.sblim.wbemsmt.exception.WbemsmtException;
import org.sblim.wbemsmt.schema.cim221.CIM_Service;
import org.sblim.wbemsmt.schema.cim221.CIM_Service.StartServiceResult;
import org.sblim.wbemsmt.schema.cim221.CIM_Service.StopServiceResult;

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
			public List<CIMObjectPath> load(int index) throws WbemsmtException {
				switch (index) {
                case AclHandler.IDX_NOTIFY:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowNotifyForServiceNames(adapter.getCimClient());
                case AclHandler.IDX_TRANSFER:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowTransferForServiceNames(adapter.getCimClient());
                case AclHandler.IDX_QUERY:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowQueryForServiceNames(adapter.getCimClient());
                case AclHandler.IDX_RECURSION:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsAllowRecursionForServiceNames(adapter.getCimClient());
                case AclHandler.IDX_BLACKHOLE:
                	return fco.getAssociated_Linux_DnsAddressMatchList_Linux_DnsBlackholeForServiceNames(adapter.getCimClient());
                default:
                	break;
                }
                return null;
			}
		}, null);
		
	}

	public Linux_DnsServiceSettingData getSetting() throws WbemsmtException {
		if (setting == null)
        {
        	WBEMClient cc = adapter.getCimClient();
        	List<CIMObjectPath> list = getConfiguration().getAssociated_Linux_DnsServiceSettingData_Linux_DnsServiceSettingDataForServiceConfigurationNames(cc);
        	setting = (Linux_DnsServiceSettingData)getFirstChild(Linux_DnsServiceSettingData.class,list,false,false, cc, adapter.getNamespace());
        }
        return setting;
	}



	public Linux_DnsServiceConfiguration getConfiguration() throws WbemsmtException {
		if (configuration == null)
        {
        	WBEMClient cc = adapter.getCimClient();
        	List<CIMObjectPath> list = fco.getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceConfigurationForServiceNames(cc);
        	configuration = (Linux_DnsServiceConfiguration)getFirstChild(Linux_DnsServiceConfiguration.class,list,false,false, cc, adapter.getNamespace());
        }
        return configuration;
	}

	public ForwarderList getForwarderList() throws WbemsmtException {
		if (forwarderList == null || forwarderList.isReloadFromServer() )
        {
        	forwarderList = new ForwarderList();
        	forwarder = (Linux_DnsForwarders) getFirstChild(Linux_DnsForwarders.class, fco.getAssociated_Linux_DnsForwarders_Linux_DnsForwardersForServiceNames(adapter.getCimClient()), true, true, adapter.getCimClient(), adapter.getNamespace());
        	addForwarderIps(forwarder,forwarderList);
        }
        return forwarderList;
	}



	public Linux_DnsAddressMatchList getAcl(int index) throws WbemsmtException {
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
		return new CimObjectKey(fco.getCimObjectPath());
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

	public List<Object> getZoneList() throws WbemsmtException {
		List<Object> allZones = new ArrayList<Object>();
		allZones.addAll(getMasterZoneList().getList());
		allZones.addAll(getSlaveZoneList().getList());
		allZones.addAll(getStubZoneList().getList());
		allZones.addAll(getHintZoneList().getList());
		allZones.addAll(getForwardZoneList().getList());
		allZones.addAll(getReverseZoneList().getList());
		return allZones;
	}


	public MessageList save(DnsAllowNotifyForServiceDataContainer container)  throws WbemsmtException {
		return aclHandler.save(AclHandler.IDX_NOTIFY);
	}
	public MessageList save(DnsBlackholeForServiceDataContainer container) throws WbemsmtException {
		return aclHandler.save(AclHandler.IDX_BLACKHOLE);
	}

	public MessageList save(DnsAllowTransferForServiceDataContainer container) throws WbemsmtException {
		return aclHandler.save(AclHandler.IDX_TRANSFER);
	}

	public MessageList save(DnsAllowRecursionForServiceDataContainer container) throws WbemsmtException {
		return aclHandler.save(AclHandler.IDX_RECURSION);
	}

	public MessageList save(DnsAllowQueryForServiceDataContainer container) throws WbemsmtException {
		return aclHandler.save(AclHandler.IDX_QUERY);
	}

	public MessageList save(DnsConfigurationDataContainer container) throws WbemsmtException {
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
        
        adapter.getFcoHelper().save(getConfiguration(),adapter.getCimClient());
        adapter.getFcoHelper().save(getSetting(),adapter.getCimClient());
        
        
        
        configuration = null;
        setting = null;
        
        return null;
	}

	public MessageList save(DnsServiceOperationsDataContainer container) throws WbemsmtException{
		//do nothing
		return null;
	}

	public void updateControls(DnsAllowNotifyForServiceDataContainer container) throws WbemsmtException {
		aclHandler.updateControls(container,AclHandler.IDX_NOTIFY,null);
	}

	public void updateControls(DnsAllowQueryForServiceDataContainer container)  throws WbemsmtException{
		aclHandler.updateControls(container,AclHandler.IDX_QUERY,null);
	}

	public void updateControls(DnsAllowRecursionForServiceDataContainer container)  throws WbemsmtException{
		aclHandler.updateControls(container,AclHandler.IDX_RECURSION,null);
	}

	public void updateControls(DnsAllowTransferForServiceDataContainer container)  throws WbemsmtException{
		aclHandler.updateControls(container,AclHandler.IDX_TRANSFER,null);
	}

	public void updateControls(DnsBlackholeForServiceDataContainer container)  throws WbemsmtException{
		aclHandler.updateControls(container,AclHandler.IDX_BLACKHOLE,null);
	}


	public void updateControls(DnsConfigurationDataContainer container) throws WbemsmtException {

		container.get_ConfigurationFile().setControlValue(getConfiguration().get_ConfigurationFile());
        if (getSetting().get_ConfigurationDirectory() != null)
        {
        	container.get_ConfigurationDirectory().setControlValue(getSetting().get_ConfigurationDirectory());				
        }
        else
        {
        	container.get_ConfigurationDirectory().setControlValue(DnsCimAdapter.NOT_SET);
        }
	}


	public void updateControls(DnsServiceOperationsDataContainer container) {
		container.get_RunAsRoot().setControlValue(fco.get_RunAsRoot());

		boolean running = fco.get_Started() != null && fco.get_Started().booleanValue();
		container.get_Status().setControlValue(running ? Service.RUNNING : Service.STOPPED);
		container.get_Status().getProperties().setColor(running ? "green" : "red");
		
	}

	public void updateControls(DnsServiceTracingDataContainer container) throws WbemsmtException {
		
		updateControls(container.getAllowNotifyAcl());
		updateControls(container.getAllowTransferAcl());
		updateControls(container.getAllowRecursionAcl());
		updateControls(container.getAllowQueryAcl());
		updateControls(container.getBlackholeAcl());
		updateControls(container.getConfiguration());
		
		
	}

	public void updateModel(DnsAllowNotifyForServiceDataContainer container) throws WbemsmtException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_NOTIFY);
	}

	public void updateModel(DnsAllowQueryForServiceDataContainer container) throws WbemsmtException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_QUERY);
	}

	public void updateModel(DnsAllowRecursionForServiceDataContainer container) throws WbemsmtException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_RECURSION);
	}

	public void updateModel(DnsAllowTransferForServiceDataContainer container) throws WbemsmtException  {
		aclHandler.updateModel(container,null,AclHandler.IDX_TRANSFER);
	}

	public void updateModel(DnsBlackholeForServiceDataContainer container) throws WbemsmtException {
		aclHandler.updateModel(container,null,AclHandler.IDX_BLACKHOLE);
	}


	public void updateModel(DnsServiceOperationsDataContainer container) throws WbemsmtException {

		WBEMClient cc = adapter.getCimClient();
		
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
			fco = (Linux_DnsService) adapter.getFcoHelper().save(fco,cc);
			
		}
		else
		{
			try {
                UnsignedInteger32 rc = new UnsignedInteger32(0);
                if (adapter.getUpdateTrigger() == container.get_invoke_Start())
                {
                    CIM_Service.StartServiceResult result = fco.invoke_StartService(cc);
                	rc = result.getResultObject();
                	evaluateRC(container,rc,true);
                }
                else if (adapter.getUpdateTrigger() == container.get_invoke_Stop())
                {
                	CIM_Service.StopServiceResult result = fco.invoke_StopService(cc);
                    rc = result.getResultObject();
                	evaluateRC(container,rc,false);
                }
                else if (adapter.getUpdateTrigger() == container.get_usr_Restart())
                {
                	CIM_Service.StopServiceResult result = fco.invoke_StopService(cc);
                    rc = result.getResultObject();
                	if (!evaluateRC(container,rc,false))
                	{
                		return;
                	}
                	
                	CIM_Service.StartServiceResult result1 = fco.invoke_StartService(cc);
                    rc = result1.getResultObject();
                	evaluateRC(container,rc,true);
                }
            }
            catch (NumberFormatException e) {
                throw new WbemsmtException(WbemsmtException.ERR_UPDATING_MODEL,e);
            }
			
			
		}
	}

	private boolean evaluateRC(DnsServiceOperationsDataContainer container, UnsignedInteger32 rc, boolean start) {
		
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

//	private void waitForStatus(DnsServiceOperationsDataContainer container, boolean started) throws WbemsmtException {
//		
//		int count = 0;
//		while (count < 10)
//		{
//			try {
//				fco = (Linux_DnsService) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
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

	public void updateModel(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		getSetting().set_Forward(super.getForwarder(container));
        updateForwarders(getForwarderList(),container,null);
	}

	public void updateControls(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		super.setForwarderToContainer(container,getSetting().get_Forward());
        container.get_Forwarders().setValues(getForwarders(getForwarderList()));
	}

	public MessageList save(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		//save the forward
        getSetting().set_Forward(super.getForwarder(container));
        adapter.getFcoHelper().save(getSetting(),adapter.getCimClient());
        setting = null;

        //save the forwarders
        saveForwardersIps(getForwarderList(), forwarder, null);
        forwarderList.setReloadFromServer(true);
        
        return null;
	}

	public void initContainer(DnsForwardersForServiceDataContainer container) throws WbemsmtException {
		super.setForwarderToContainer(container,getSetting().get_Forward());
	}
	
	public void updateModel(DnsConfigurationDataContainer container) throws WbemsmtException {

		if (adapter.getUpdateTrigger() == container.get_usr_RemoveDirectory())
        {
        	getSetting().set_ConfigurationDirectory(null);
        }
		
	}

	public MessageList revert(DnsAllowNotifyForServiceDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_NOTIFY);
		return null;
	}

	public MessageList revert(DnsAllowQueryForServiceDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_QUERY);
		return null;
	}

	public MessageList revert(DnsAllowRecursionForServiceDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_RECURSION);
		return null;
	}

	public MessageList revert(DnsAllowTransferForServiceDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_TRANSFER);
		return null;
	}

	public MessageList revert(DnsBlackholeForServiceDataContainer container) throws WbemsmtException {
		aclHandler.resetAcl(AclHandler.IDX_BLACKHOLE);
		return null;
	}

	public MessageList revert(DnsConfigurationDataContainer container) throws WbemsmtException {
		configuration = null;
		fco = (Linux_DnsService) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}

	public MessageList revert(DnsServiceOperationsDataContainer container) throws WbemsmtException {
		configuration = null;
		fco = (Linux_DnsService) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
		return null;
	}

	public MessageList revert(DnsForwardersForServiceDataContainer container) {
		forwarderList = null;
		setting = null;
		configuration = null;
		return null;
	}



	
}
