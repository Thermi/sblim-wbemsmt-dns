/** 
 * Linux_DnsReverseZoneWrapper.java
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
 * @author:	ECCG 0.9.7 generated 
 * 			(author should be changed, e.g. First and Last Name <xxx@cc.ibm.com>)
 *
 * Contributors:
 *
 *
 * Description:  Class representing DNS zones of different types.
 * 
 * Just a wrapper class for the zone represented by the reverse Zone
 * 
 * The attribute reversedZone is from type Linux_DnsZone and is set always
 * 
 * The attributes slaveZone,masterZone,hintZone and forwardZone are only set if
 * the reversed zone is form corresponding type.
 * 
 */

package org.sblim.wbemsmt.dns.bl.fco;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.sblim.wbem.cim.CIMDataType;
import org.sblim.wbem.cim.CIMInstance;
import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.cim.CIMProperty;
import org.sblim.wbem.cim.CIMValue;
import org.sblim.wbem.cim.UnsignedInt32;
import org.sblim.wbem.cim.UnsignedInt8;
import org.sblim.wbemsmt.schema.cim29.CIM_Component;
import org.sblim.wbemsmt.schema.cim29.CIM_ManagedElement;


/**
 * Class representing DNS zones of different types.
 * Just a wrapper class for the zone represented by the reverse Zone 
 */
public class Linux_DnsReverseZoneWrapper extends CIM_ManagedElement  {
	
	public final static String CIM_CLASS_NAME = "Linux_DnsReverseZoneWrapper"; //$NON-NLS-1$
	public final static String CIM_CLASS_DISPLAYNAME = CIM_CLASS_NAME;

	protected Linux_DnsMasterZone masterZone = null;
	
	/** 
	*	
	*/
	public final static String CIM_PROPERTY_NAME = "Name"; //$NON-NLS-1$
	/**
	*	
	*/
	public final static String CIM_PROPERTY_RESOURCERECORDFILE = "ResourceRecordFile"; //$NON-NLS-1$
	/**
	*	Value = 5 for Type Hint.
	*/
	public final static String CIM_PROPERTY_TYPE = "Type"; //$NON-NLS-1$
	
	
	

	public static Vector CIM_PropertyNameList	= new Vector();
	public static Vector CIM_PropertyList 		= new Vector();
	private static Set Java_Package_List 		= new HashSet();
	
	static {
		CIM_PropertyNameList.add(CIM_PROPERTY_NAME);
		CIM_PropertyNameList.add(CIM_PROPERTY_RESOURCERECORDFILE);
		CIM_PropertyNameList.add(CIM_PROPERTY_TYPE);
				
		for (int i = 0; i < Linux_DnsZone.CIM_PropertyNameList.size(); i++) {
			if (((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_NAME)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_RESOURCERECORDFILE)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_TYPE)){
				continue;
			}
			
			Linux_DnsReverseZoneWrapper.CIM_PropertyNameList.add(Linux_DnsZone.CIM_PropertyNameList.elementAt(i));
		}
		
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_NAME, new CIMValue(null, new CIMDataType(CIMDataType.STRING))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_RESOURCERECORDFILE, new CIMValue(null, new CIMDataType(CIMDataType.STRING))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_TYPE, new CIMValue(null, new CIMDataType(CIMDataType.UINT16))));
				
		for (int i = 0; i < Linux_DnsZone.CIM_PropertyList.size(); i++) {
			if (((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_NAME)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_RESOURCERECORDFILE)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_TYPE)){
				continue;
			}
			
			Linux_DnsReverseZoneWrapper.CIM_PropertyList.add(Linux_DnsZone.CIM_PropertyList.elementAt(i));
		}
		
		addPackage("org.sblim.wbemsmt.dns.bl.fco");
		
		String[] parentClassPackageList = Linux_DnsZone.getPackages();
		
		for (int i = 0; i < parentClassPackageList.length; i++) {
			Java_Package_List.add(parentClassPackageList[i]);
		}

		Java_Package_List.add("org.sblim.wbemsmt.dns.bl.fco");
				
	};
			
	
	//**********************************************************************
	// Constructors 	
	//**********************************************************************

	
	public Linux_DnsReverseZoneWrapper(Linux_DnsMasterZone zone) {
		masterZone = (Linux_DnsMasterZone) zone;
	}

	/**
	*	The method returns the display name of the class
	*/	
	public String getClassDisplayName(){
		return CIM_CLASS_DISPLAYNAME;
	}
	
	//**********************************************************************
	// Instance methods
	//**********************************************************************

	/**
	*	no description
	*/	
	public boolean isDataValid(Vector invalidProperties) {
		return masterZone.isDataValid(invalidProperties);
	}
	
	/**
	*	The method returns this CIM instance
	*/
	public CIMInstance getCimInstance() {
		
		return masterZone.getCimInstance();
	}
	
	
	/**
	*	The method returns this CIM object path
	*/
	public CIMObjectPath getCimObjectPath() {
		return masterZone.getCimObjectPath();
	}
	
	
	/**
	*	The method checks if the cimInstance has been modified
	*/
	public boolean isModified() {
	    
	    return masterZone.isModified();
	}
	
	

	
	/**
	*	The method checks if the cimInstance equals an other cimInstance
	*/	
	public boolean equals(Object object) {
	    
	    return masterZone.equals(object);
	}
	
	/**
	*	The method return this method as a string
	*/	
	public String toString() {
		return masterZone.toString();
	}

	//*****************************************************
	// Associators methods
	//*****************************************************
	
	
	
	//*****************************************************
	// Attribute methods
	//*****************************************************
	
	// Attribute Name
	
	public String get_Name() {
		
		return masterZone.get_Name();
	}
	    
			
	// Attribute ResourceRecordFile
	
	public String get_ZoneFile() {
		
		return masterZone.get_ZoneFile();
	}
	    
			
	// Attribute Type
	
	public UnsignedInt8 get_Type() {
		
		return masterZone.get_Type();
	}
	    
	public Linux_DnsZone getReversedZone() {
		return masterZone;
	}

	public Linux_DnsMasterZone getMasterZone() {
		return masterZone;
	}

	public void set_NegativeCachingTTL(UnsignedInt32 asUnsignedInt32) {
		if (masterZone != null) masterZone.set_NegativeCachingTTL(asUnsignedInt32);
	}

	public void set_Forward(UnsignedInt8 forward) {
		if (masterZone != null) masterZone.set_Forward(forward);
	}

	public void set_ZoneFile(String file) {
		masterZone.set_ZoneFile(file);
	}

	public void set_Contact(String contact) {
		if (masterZone != null) masterZone.set_Contact(contact);
	}

	public void set_Expire(UnsignedInt32 expire) {
		if (masterZone != null) masterZone.set_Expire(expire);
	}

	public void set_Retry(UnsignedInt32 retry) {
		if (masterZone != null) masterZone.set_Retry(retry);
	}

	public void set_SerialNumber(String serial) {
		if (masterZone != null) masterZone.set_Contact(serial);
	}

	public void set_Server(String server) {
		if (masterZone != null) masterZone.set_Server(server);
	}

	public String get_Contact() {
		if (masterZone != null) return masterZone.get_Contact();
		return null;
	}

	public UnsignedInt32 get_Expire() {
		if (masterZone != null) return masterZone.get_Expire();
		return null;
	}

	public UnsignedInt8 get_Forward() {
		if (masterZone != null) return masterZone.get_Forward();
		return null;
	}

	public UnsignedInt32 get_Retry() {
		if (masterZone != null) return masterZone.get_Retry();
		return null;
	}

	public String get_SerialNumber() {
		if (masterZone != null) return masterZone.get_SerialNumber();
		return null;
	}

	public String get_Server() {
		if (masterZone != null) return masterZone.get_Server();
		return null;
	}

	public Integer get_TTL() {
		if (masterZone != null) return masterZone.get_TTL();
		return null;
	}

	public void set_TTL(Integer ttl) {
		if (masterZone != null) masterZone.set_TTL(ttl);
		
	}

	public UnsignedInt32 get_NegativeCachingTTL() {
		if (masterZone != null) return masterZone.get_NegativeCachingTTL();
		return null;
	}

	public void setMasterZone(Linux_DnsMasterZone masterZone) {
		this.masterZone = masterZone;
	}
	
	
}
