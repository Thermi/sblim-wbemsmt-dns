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

import javax.cim.CIMInstance;
import javax.cim.CIMObjectPath;
import javax.cim.UnsignedInteger32;
import javax.cim.UnsignedInteger8;

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
	
	public String get_key_Name() {
		
		return masterZone.get_key_Name();
	}
	    
			
	// Attribute ResourceRecordFile
	
	public String get_ZoneFile() {
		
		return masterZone.get_ZoneFile();
	}
	    
			
	// Attribute Type
	
	public UnsignedInteger8 get_Type() {
		
		return masterZone.get_Type();
	}
	    
	public Linux_DnsZone getReversedZone() {
		return masterZone;
	}

	public Linux_DnsMasterZone getMasterZone() {
		return masterZone;
	}

	public void set_NegativeCachingTTL(UnsignedInteger32 asUnsignedInt32) {
		if (masterZone != null) masterZone.set_NegativeCachingTTL(asUnsignedInt32);
	}

	public void set_Forward(UnsignedInteger8 forward) {
		if (masterZone != null) masterZone.set_Forward(forward);
	}

	public void set_ZoneFile(String file) {
		masterZone.set_ZoneFile(file);
	}

	public void set_Contact(String contact) {
		if (masterZone != null) masterZone.set_Contact(contact);
	}

	public void set_Expire(UnsignedInteger32 expire) {
		if (masterZone != null) masterZone.set_Expire(expire);
	}

	public void set_Retry(UnsignedInteger32 retry) {
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

	public UnsignedInteger32 get_Expire() {
		if (masterZone != null) return masterZone.get_Expire();
		return null;
	}

	public UnsignedInteger8 get_Forward() {
		if (masterZone != null) return masterZone.get_Forward();
		return null;
	}

	public UnsignedInteger32 get_Retry() {
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

	public UnsignedInteger32 get_NegativeCachingTTL() {
		if (masterZone != null) return masterZone.get_NegativeCachingTTL();
		return null;
	}

	public void setMasterZone(Linux_DnsMasterZone masterZone) {
		this.masterZone = masterZone;
	}
	
	
}
