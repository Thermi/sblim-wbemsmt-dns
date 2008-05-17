 /** 
  * Masters.java
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
  * Description: wrapper for a Masters directive
  * 
  */
package org.sblim.wbemsmt.dns.bl.wrapper;


import java.util.Iterator;
import java.util.List;

import javax.wbem.client.WBEMClient;

import org.sblim.wbemsmt.bl.adapter.CimObjectKey;
import org.sblim.wbemsmt.bl.adapter.MessageList;
import org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter;
import org.sblim.wbemsmt.dns.bl.container.edit.DnsMastersForServiceDataContainer;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMasters;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForService;
import org.sblim.wbemsmt.dns.bl.fco.Linux_DnsMastersForServiceHelper;
import org.sblim.wbemsmt.dns.bl.wrapper.masters.MastersHandler;
import org.sblim.wbemsmt.dns.naming.MastersNaming;
import org.sblim.wbemsmt.exception.WbemsmtException;

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
		updateName(mastersNaming.getDisplayString(fco.getCimInstance(), adapter.getCimClient()));
		mastersHandler = new MastersHandler(adapter,fco,true, null);
	}

	private void updateName(Object value) {
		this.fco.set_key_Name(value.toString());
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
	
	public void loadChilds(WBEMClient cimClient) {
	}

	public MessageList save(DnsMastersForServiceDataContainer container)  throws WbemsmtException {
		//fco.set_Name((String) container.get_Name().getConvertedControlValue());
		updateName(NameFactory.createName(Linux_DnsMastersForService.class, fco.get_key_Name()));
		mastersHandler.save();
		updateName(mastersNaming.getDisplayString(fco.getCimInstance(), adapter.getCimClient()));
		return null;
	}

	public void updateControls(DnsMastersForServiceDataContainer container) throws WbemsmtException {
		container.get_Name().setControlValue(fco.get_key_Name());
		mastersHandler.updateIpAddressList(container);
	}

	public void updateModel(DnsMastersForServiceDataContainer container) throws WbemsmtException {
		mastersHandler.updateAddressModel(container);
	}

	public void delete() throws WbemsmtException {
		
		try {
			updateName(NameFactory.createName(Linux_DnsMastersForService.class, fco.get_key_Name()));
			String serviceName = adapter.getDnsService().getFco().get_Name();
			String mastersName = fco.get_key_Name();
			List list = Linux_DnsMastersForServiceHelper.enumerateInstances(adapter.getCimClient(),adapter.getNamespace(),false);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Linux_DnsMastersForService mastersForService = (Linux_DnsMastersForService) iter.next();
				Object serviceName2 = mastersForService.get_GroupComponent_Linux_DnsService(adapter.getCimClient()).get_key_Name();
				Object mastersName2 = mastersForService.get_PartComponent_Linux_DnsMasters(adapter.getCimClient()).get_key_Name();
				if (serviceName2.equals(serviceName) && mastersName2.equals(mastersName))
				{
					Linux_DnsMasters masters = mastersForService.get_PartComponent_Linux_DnsMasters(adapter.getCimClient());
					adapter.getFcoHelper().delete(masters,adapter.getCimClient());
					if (DnsCimAdapter.DUMMY_MODE)
					{
						adapter.getFcoHelper().delete(mastersForService,adapter.getCimClient());
					}
					return;
				}
			}
			
			throw new WbemsmtException(WbemsmtException.ERR_DELETE_OBJECT,"Cannot delete Masters",getFco());
			
		} catch (Exception e) {
			throw new WbemsmtException(WbemsmtException.ERR_DELETE_OBJECT,e);
		}
		
	}

	public MessageList revert(DnsMastersForServiceDataContainer container) throws WbemsmtException {
		fco = (Linux_DnsMasters) adapter.getFcoHelper().reload(fco, adapter.getCimClient());
        updateName(mastersNaming.getDisplayString(fco.getCimInstance(), adapter.getCimClient()));
        mastersHandler = new MastersHandler(adapter,fco,true, null);
		return null;
	}
}
