 /** 
  * Masters.java
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
  * Description: wrapper for a Masters directive
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;


import java.util.Iterator;
import java.util.List;

import org.sblim.wbem.cim.CIMDataType;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.bl.fco.CIMPropertyBuilder;
import org.sblim.wbemsmt.bl.fco.FcoHelper;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForService;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForServiceHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersHelper;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsService;
import org.sblim.wbemsmt.dns.bl.wrapper.masters.MastersHandler;
import org.sblim.wbemsmt.dns.naming.MastersNaming;
import org.sblim.wbemsmt.exception.ModelLoadException;
import org.sblim.wbemsmt.exception.ModelUpdateException;
import org.sblim.wbemsmt.exception.ObjectCreationException;
import org.sblim.wbemsmt.exception.ObjectDeletionException;
import org.sblim.wbemsmt.exception.ObjectRevertException;
import org.sblim.wbemsmt.exception.ObjectSaveException;
import org.sblim.wbemsmt.exception.UpdateControlsException;

public class Masters extends DnsBusinessObject {

	private Linux_DnsMasters fco;
	private MastersHandler mastersHandler = null;
	private MastersNaming mastersNaming = new MastersNaming();
	/**
	 * 
	 */
	public Masters(final Linux_DnsMasters fco, DnsCimAdapter adapter) {
		super(adapter);
		this.fco = fco;
		updateName(mastersNaming.getDisplayString(fco.getCimInstance()));
		mastersHandler = new MastersHandler(adapter,fco,true, null);
	}

	private void updateName(Object value) {
		this.fco.getCimInstance().setProperty(Linux_DnsMasters.CIM_PROPERTY_NAME,CIMPropertyBuilder.createVaue(value, CIMDataType.STRING));
	}

	/* (non-Javadoc)
	 * @see org.sblim.wbemsmt.dns.bl.wrapper.DnsBusinessObject#getCimObjectKey()
	 */
	public CimObjectKey getCimObjectKey() {
		return new CimObjectKey(fco.getCimObjectPath());
	}

	
	public Linux_DnsMasters getFco() {
			return fco;
	}
	
	public void loadChilds(CIMClient cimClient) {
	}

	public MessageList save(DnsMastersForServiceDataContainer container)  throws ObjectSaveException {
		//fco.set_Name((String) container.get_Name().getConvertedControlValue());
		updateName(NameFactory.createName(Linux_DnsMastersForService.class, fco.get_Name()));
		mastersHandler.save();
		updateName(mastersNaming.getDisplayString(fco.getCimInstance()));
		return null;
	}

	public void updateControls(DnsMastersForServiceDataContainer container) throws UpdateControlsException {
		container.get_Name().setControlValue(fco.get_Name());
		mastersHandler.updateIpAddressList(container);
	}

	public void updateModel(DnsMastersForServiceDataContainer container) throws ModelUpdateException {
		mastersHandler.updateAddressModel(container);
	}

	public void delete() throws ObjectDeletionException {
		
		try {
			updateName(NameFactory.createName(Linux_DnsMastersForService.class, fco.get_Name()));
			String serviceName = adapter.getDnsService().getFco().get_Name();
			String mastersName = fco.get_Name();
			List list = Linux_DnsMastersForServiceHelper.enumerateInstances(adapter.getCimClient(),false);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Linux_DnsMastersForService mastersForService = (Linux_DnsMastersForService) iter.next();
				Object serviceName2 = mastersForService.get_Linux_DnsService().getKey(Linux_DnsService.CIM_PROPERTY_NAME).getValue().getValue();
				Object mastersName2 = mastersForService.get_Linux_DnsMasters().getKey(Linux_DnsMasters.CIM_PROPERTY_NAME).getValue().getValue();
				if (serviceName2.equals(serviceName) && mastersName2.equals(mastersName))
				{
					Linux_DnsMasters masters = (Linux_DnsMasters) FcoHelper.reload(Linux_DnsMastersHelper.class, mastersForService.get_Linux_DnsMasters(),adapter.getCimClient() );
					FcoHelper.delete(masters,adapter.getCimClient());
					if (DnsCimAdapter.DUMMY_MODE)
					{
						FcoHelper.delete(mastersForService,adapter.getCimClient());
					}
					return;
				}
			}
			
			throw new ObjectDeletionException(getFco());
			
		} catch (ModelLoadException e) {
			throw new ObjectDeletionException(e);
		} catch (ObjectCreationException e) {
			throw new ObjectDeletionException(getFco(),e);
		}
		
	}

	public MessageList revert(DnsMastersForServiceDataContainer container) throws ObjectRevertException {
		try {
			fco = (Linux_DnsMasters) FcoHelper.reload(fco, adapter.getCimClient());
			updateName(mastersNaming.getDisplayString(fco.getCimInstance()));
			mastersHandler = new MastersHandler(adapter,fco,true, null);
		} catch (ModelLoadException e) {
			throw new ObjectRevertException(e);
		}
		return null;
	}
}
