/** 
  * DnsSlaveZoneWizardSummaryDataContainerImpl.java
  * 
  * Â© Copyright IBM Corp.  2009,2006,2007
  *
  * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE ECLIPSE PUBLIC LICENSE
  * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
  * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
  *
  * You can obtain a current copy of the Eclipse Public License from
  * http://www.opensource.org/licenses/eclipse-1.0.php
  *
  * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
  * @template: org/sblim/wbemsmt/dcg/templates/cmd/containerImpl.vm
  *
  * Contributors: 
  *   Prashanth Karnam<prkarnam@in.ibm.com>
  * 
  * Description: Summary-Page of SlaveZone-Wizard
  * 
  * generated Class
  */

package org.sblim.wbemsmt.cli.dns.container.wizard;

import java.util.*;

import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf;



import org.sblim.wbemsmt.bl.adapter.DataContainer;
import org.sblim.wbemsmt.bl.adapter.DataContainerUtil;

public class DnsSlaveZoneWizardSummaryDataContainerImpl extends BaseDataContainer implements org.sblim.wbemsmt.dns.bl.container.wizard.DnsSlaveZoneWizardSummaryDataContainer
	{
			private org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf ic_usr_Name;
    		private org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf ic_usr_IpAdressses;
    	
		
	public DnsSlaveZoneWizardSummaryDataContainerImpl(AbstractBaseCimAdapter adapter) throws  WbemsmtException {
		super();
		setAdapter(adapter);
    			adapter.initContainer(this);
	}

			/**
		* 
		* DataType STRING
		* UIType LABEL
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledBaseInputComponentIf get_usr_Name() {
    		if (ic_usr_Name == null)
    		{
				String label = getAdapter().getBundle().getString("DnsSlaveZoneWizardSummaryDataContainer.Name");
				org.sblim.wbemsmt.tools.converter.Converter converter = new org.sblim.wbemsmt.tools.converter.test.DummyConverter();
    			ic_usr_Name = new org.sblim.wbemsmt.tools.input.test.LabeledTestInputComponent(this,label,null,converter);
    		}
    		return ic_usr_Name;
    	}
			/**
		* 
		* DataType UNSIGNED_INT16
		* UIType LIST
		* ReadOnly true
		*/

		public org.sblim.wbemsmt.tools.input.LabeledStringArrayInputComponentIf get_usr_IpAdressses() {
    		if (ic_usr_IpAdressses == null)
    		{
				String label = getAdapter().getBundle().getString("DnsSlaveZoneWizardSummaryDataContainer.IpAdressses");
				org.sblim.wbemsmt.tools.converter.StringArrayConverter converter = new org.sblim.wbemsmt.tools.converter.UnsignedInt16StringArrayConverter();
    			ic_usr_IpAdressses = new org.sblim.wbemsmt.tools.input.test.LabeledTestStringArrayComponent(this,label,null,converter);
    		}
    		return ic_usr_IpAdressses;
    	}
		
	
		
	public void trace(java.io.PrintWriter 	printStream, String listOptions, boolean title)
	{
		if (title)
		{
			printStream.println(getAdapter().getBundle().getString("DnsSlaveZoneWizardSummaryDataContainer.caption"));
		}
		
		if (showKey(listOptions))
		{
			String key = getKey() != null ? getKey().toString() : "-";
			printStream.println(getAdapter().getBundle().getString("key") + ": " + key + "\n");
		}
	
		if (showInstance(listOptions))
		{
			   			   			if (get_usr_Name().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_Name()).getValue();
        				printStream.println(get_usr_Name().getLabelText() + ": " + value);
   			}
   			   			   			if (get_usr_IpAdressses().isVisible())
   			{
        				Object value = ((org.sblim.wbemsmt.tools.input.test.TestInputComponentIf)get_usr_IpAdressses()).getValue();
        				printStream.println(get_usr_IpAdressses().getLabelText() + ": " + value);
   			}
   					}

		if (showChilds(listOptions))
		{
			traceChilds(printStream,listOptions,title);
		}
	}
	
	public void traceChilds(java.io.PrintWriter printStream, String listOptions, boolean title)
	{
    			
			
	}
	
	
 
	/**
	 * Return a list of all Fields. A Field is a LabeledBaseInputComponentIf
	 * @return
	 */
	public List<LabeledBaseInputComponentIf> getFields()
	{
		List<LabeledBaseInputComponentIf> fields = new ArrayList<LabeledBaseInputComponentIf>();
    				fields.add(get_usr_Name());
    				fields.add(get_usr_IpAdressses());
    			return fields;
	}

	/**
	 * Return a list of all associated childContainers. A childContainer is a DataContainer
	 * @return
	 */
	public List<DataContainer> getChildContainers()
	{
		List<DataContainer> childs = new ArrayList<DataContainer>();
    	    			return childs;
	
	}
	
	public void copyFrom(DataContainer sourceContainer) throws WbemsmtException
	{
	    		       DnsSlaveZoneWizardSummaryDataContainerImpl source = (DnsSlaveZoneWizardSummaryDataContainerImpl)sourceContainer;
		    		    
    	    		   get_usr_Name().copyFrom(source.get_usr_Name());
		        		   get_usr_IpAdressses().copyFrom(source.get_usr_IpAdressses());
		    		
    	    		}
	
	public boolean isModified()
	{
    	return DataContainerUtil.isModified(this);
	}		
}