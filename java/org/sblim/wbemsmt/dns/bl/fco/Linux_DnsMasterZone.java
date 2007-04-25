/** 
 * Linux_DnsMasterZone.java
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
 * Description:  Class representing DNS zones of type Master.
 * 
 */

package org.sblim.wbemsmt.dns.bl.fco;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Vector;

import org.sblim.wbem.cim.CIMDataType;
import org.sblim.wbem.cim.CIMException;
import org.sblim.wbem.cim.CIMInstance;
import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.cim.CIMProperty;
import org.sblim.wbem.cim.CIMValue;
import org.sblim.wbem.cim.UnsignedInt32;
import org.sblim.wbem.cim.UnsignedInt8;


/**
 *  Class representing DNS zones of type Master.
 */
public class Linux_DnsMasterZone extends Linux_DnsZone  {
	
	public final static String CIM_CLASS_NAME = "Linux_DnsMasterZone"; //$NON-NLS-1$
	public final static String CIM_CLASS_DISPLAYNAME = CIM_CLASS_NAME;

	private boolean validCimInstance = false;
	
	
	
	/**
	*	The owner mail address for this zone
	*/
	public final static String CIM_PROPERTY_CONTACT = "Contact"; //$NON-NLS-1$
	/**
	*	The time in seconds after a RR expires.
	*/
	public final static String CIM_PROPERTY_EXPIRE = "Expire"; //$NON-NLS-1$
	/**
	*	The default behavior for forwarding requests.
	*/
	public final static String CIM_PROPERTY_FORWARD = "Forward"; //$NON-NLS-1$
	/**
	*	
	*/
	public final static String CIM_PROPERTY_NAME = "Name"; //$NON-NLS-1$
	/**
	*	The negative caching time to live. This controls how long other servers will cache no-such-domain (NXDOMAIN) responses from you. Max value is 3 hours (10800 sec).
	*/
	public final static String CIM_PROPERTY_NEGATIVECACHINGTTL = "NegativeCachingTTL"; //$NON-NLS-1$
	/**
	*	The time in seconds after a RR is refershed.
	*/
	public final static String CIM_PROPERTY_REFRESH = "Refresh"; //$NON-NLS-1$
	/**
	*	The time in seconds after a RR is retried.
	*/
	public final static String CIM_PROPERTY_RETRY = "Retry"; //$NON-NLS-1$
	/**
	*	Serial Number of syntax year month day version: yyyymmddvv.
	*/
	public final static String CIM_PROPERTY_SERIALNUMBER = "SerialNumber"; //$NON-NLS-1$
	/**
	*	IP Address of the authoritative server for this zone
	*/
	public final static String CIM_PROPERTY_SERVER = "Server"; //$NON-NLS-1$
	/**
	*	The default time to live value for Resource Records (RR). TTL describes how long a RR can be cached, before it should be discarded.
	*/
	public final static String CIM_PROPERTY_TTL = "TTL"; //$NON-NLS-1$
	/**
	*	Value = 1 for Type Master.
	*/
	public final static String CIM_PROPERTY_TYPE = "Type"; //$NON-NLS-1$
	/**
	*	The zone file that contains the zone specific RR.
	*/
	public final static String CIM_PROPERTY_ZONEFILE = "ZoneFile"; //$NON-NLS-1$
	
	
	

	public static Vector CIM_PropertyNameList	= new Vector();
	public static Vector CIM_PropertyList 		= new Vector();
	public static Vector Java_Package_List 		= new Vector();
	
	static {
		CIM_PropertyNameList.add(CIM_PROPERTY_CONTACT);
		CIM_PropertyNameList.add(CIM_PROPERTY_EXPIRE);
		CIM_PropertyNameList.add(CIM_PROPERTY_FORWARD);
		CIM_PropertyNameList.add(CIM_PROPERTY_NAME);
		CIM_PropertyNameList.add(CIM_PROPERTY_NEGATIVECACHINGTTL);
		CIM_PropertyNameList.add(CIM_PROPERTY_REFRESH);
		CIM_PropertyNameList.add(CIM_PROPERTY_RETRY);
		CIM_PropertyNameList.add(CIM_PROPERTY_SERIALNUMBER);
		CIM_PropertyNameList.add(CIM_PROPERTY_SERVER);
		CIM_PropertyNameList.add(CIM_PROPERTY_TTL);
		CIM_PropertyNameList.add(CIM_PROPERTY_TYPE);
		CIM_PropertyNameList.add(CIM_PROPERTY_ZONEFILE);
				
		for (int i = 0; i < Linux_DnsZone.CIM_PropertyNameList.size(); i++) {
			if (((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_CONTACT)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_EXPIRE)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_FORWARD)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_NAME)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_NEGATIVECACHINGTTL)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_REFRESH)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_RETRY)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_SERIALNUMBER)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_SERVER)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_TTL)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_TYPE)||
				((String)Linux_DnsZone.CIM_PropertyNameList.elementAt(i)).equals(CIM_PROPERTY_ZONEFILE)){
				continue;
			}
			
			Linux_DnsMasterZone.CIM_PropertyNameList.add(Linux_DnsZone.CIM_PropertyNameList.elementAt(i));
		}
		
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_CONTACT, new CIMValue(null, new CIMDataType(CIMDataType.STRING))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_EXPIRE, new CIMValue(null, new CIMDataType(CIMDataType.UINT32))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_FORWARD, new CIMValue(null, new CIMDataType(CIMDataType.UINT8))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_NAME, new CIMValue(null, new CIMDataType(CIMDataType.STRING))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_NEGATIVECACHINGTTL, new CIMValue(null, new CIMDataType(CIMDataType.UINT32))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_REFRESH, new CIMValue(null, new CIMDataType(CIMDataType.UINT32))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_RETRY, new CIMValue(null, new CIMDataType(CIMDataType.UINT32))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_SERIALNUMBER, new CIMValue(null, new CIMDataType(CIMDataType.STRING))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_SERVER, new CIMValue(null, new CIMDataType(CIMDataType.STRING))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_TTL, new CIMValue(null, new CIMDataType(CIMDataType.SINT32))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_TYPE, new CIMValue(new UnsignedInt8("1"), new CIMDataType(CIMDataType.UINT8))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_ZONEFILE, new CIMValue(null, new CIMDataType(CIMDataType.STRING))));
				
		for (int i = 0; i < Linux_DnsZone.CIM_PropertyList.size(); i++) {
			if (((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_CONTACT)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_EXPIRE)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_FORWARD)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_NAME)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_NEGATIVECACHINGTTL)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_REFRESH)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_RETRY)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_SERIALNUMBER)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_SERVER)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_TTL)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_TYPE)||
				((CIMProperty)Linux_DnsZone.CIM_PropertyList.get(i)).getName().equals(CIM_PROPERTY_ZONEFILE)){
				continue;
			}
			
			Linux_DnsMasterZone.CIM_PropertyList.add(Linux_DnsZone.CIM_PropertyList.elementAt(i));
		}
		
		Java_Package_List.add("org.sblim.wbemsmt.dns.bl.fco");
				
		for (int i = 0; i < Linux_DnsZone.Java_Package_List.size(); i++) {
			if (((String)Linux_DnsZone.Java_Package_List.elementAt(i)).equals("org.sblim.wbemsmt.dns.bl.fco")){
				continue;
			}
			
			Java_Package_List.add(Linux_DnsZone.Java_Package_List.elementAt(i));
		}
	};
			
	public final static String[] CIM_VALUEMAP_FORWARD = {"Unknown","Only","First"};
	
	
	public final static int FORWARD_UNKNOWN = 0;
	public final static int FORWARD_ONLY = 1;
	public final static int FORWARD_FIRST = 2;
	
	
	
	//**********************************************************************
	// Constructors 	
	//**********************************************************************

	/**
	*	Class constructor
	*/	
	public Linux_DnsMasterZone() {

		this.cimInstance	= new CIMInstance();
		
		for (int i = 0; i < CIM_PropertyList.size(); i++) {
			this.cimInstance.addProperty((CIMProperty)((CIMProperty)CIM_PropertyList.get(i)).clone());
		}
		
		this.cimObjectPath 	= new CIMObjectPath(CIM_CLASS_NAME);
		this.cimInstance.setObjectPath(this.cimObjectPath);

		this.original_cimInstance	= (CIMInstance)this.cimInstance.clone();

		setValidCimInstance(false);
	}


	/**
	*	Class constructor
	*/	
	public Linux_DnsMasterZone(Vector keyProperties){ 
		this();
		
		if (keyProperties == null) {
			throw new InvalidParameterException("The keyProperties parameter does not contain a valid reference.");
		
		}
		
		Iterator iter = keyProperties.iterator();
		while (iter.hasNext()) {
			Object property = iter.next();
			
			if (property instanceof CIMProperty) {
				CIMProperty keyProperty = (CIMProperty)property;
				this.cimObjectPath.addKey(keyProperty);
				
				if (this.cimInstance.getProperty(keyProperty.getName()) != null) {
					this.cimInstance.removeProperty(keyProperty.getName());
				}
				this.cimInstance.addProperty(keyProperty);
				
			} else {
				throw new InvalidParameterException("The keyProperties parameter should only contain objects of class CIMProperty.");
				
			}
		}
		
		setValidCimInstance(false);
	}

	
	/**
	*	Class constructor
	*/	
	public Linux_DnsMasterZone(CIMObjectPath cimObjectPath, CIMInstance cimInstance){ 
		
		if (cimInstance == null) {
			throw new InvalidParameterException("The cimInstance parameter does not contain a valid reference.");
		
		} else if (cimObjectPath == null){
			throw new InvalidParameterException("The cimObjectPath parameter does not contain a valid reference.");		
		
		} else if (!CIM_CLASS_NAME.equals(cimInstance.getClassName())) {
			throw new InvalidParameterException("The class of the cimInstance must be of type " + CIM_CLASS_NAME + ".");
		}
		
		setCimInstance(cimInstance);
		this.original_cimInstance = (CIMInstance)cimInstance.clone();
		this.cimObjectPath        = cimObjectPath;
		setValidCimInstance(true);
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
		boolean result = true;
		
		if (invalidProperties == null) {
			invalidProperties = new Vector();
		} else {
			invalidProperties.removeAllElements();
		}
		
		CIMProperty CIMProperty_Name = this.cimInstance.getProperty(CIM_PROPERTY_NAME);
		
		if (CIMProperty_Name == null || CIMProperty_Name.getValue().isEmpty() || CIMProperty_Name.getValue().isNullValue()) {
			invalidProperties.add(new String[]{CIM_PROPERTY_NAME, "Key"});
			result = false;
		}
		
		return result;
	}
	
	/**
	 * @return Returns the validCimInstance.
	 */
	public boolean isValidCimInstance() {
		return this.validCimInstance;
	}
	
	/**
	 * @param validCimInstance The validCimInstance to set.
	 */
	private void setValidCimInstance(boolean isValidCimInstance) {

		this.validCimInstance = isValidCimInstance;
	}
	
	
	/**
	*	The method returns this CIM instance
	*/
	public CIMInstance getCimInstance() {
		
		return this.cimInstance;
	}
	
	
	/**
	*	The method sets this CIM instance
	*/
	public void setCimInstance(CIMInstance cimInstance) {
		
		this.cimInstance = cimInstance;
	}
	
		
	/**
	*	The method returns this CIM object path
	*/
	public CIMObjectPath getCimObjectPath() {
		return this.cimObjectPath;
	}
	
	
	/**
	*	The method checks if the cimInstance has been modified
	*/
	public boolean isModified() {
	    
	    if (!this.original_cimInstance.equals(this.cimInstance)) 
	        return true;
	    
	    return false;
	}
	
	
	/**
	*	The method resets the values of the cimInstance
	*/	
	public void resetValues() {
	    this.cimInstance = (CIMInstance)this.original_cimInstance.clone();
	}
	
	
	/**
	*	The method checks if the cimInstance equals an other cimInstance
	*/	
	public boolean equals(Object object) {
	    
	    if (!(object instanceof Linux_DnsMasterZone)) {
	        return false;
	    }
	    
	    if (this.cimInstance == null && ((Linux_DnsMasterZone)object).cimInstance != null) {
	    	return false;
	    	
	    } else if (this.cimInstance != null && ((Linux_DnsMasterZone)object).cimInstance == null) {
	    	return false;
	    	
	    } else if (this.cimInstance != null && !this.cimInstance.equals(((Linux_DnsMasterZone)object).cimInstance)) {
	    	return false;
	    	
	    } else if (this.original_cimInstance == null && ((Linux_DnsMasterZone)object).original_cimInstance != null) {
	    	return false;
	    	
	    } else if (this.original_cimInstance != null && ((Linux_DnsMasterZone)object).original_cimInstance == null) {
	    	return false;
	    	
	    } else if (this.original_cimInstance != null && !this.original_cimInstance.equals(((Linux_DnsMasterZone)object).original_cimInstance)) {
	        return false;
	        
	    } else if (this.cimObjectPath == null && ((Linux_DnsMasterZone)object).cimObjectPath != null) {
	    	return false;
	    	
	    } else if (this.cimObjectPath != null && ((Linux_DnsMasterZone)object).cimObjectPath == null) {
	    	return false;
		    	
	    } else if (this.cimObjectPath != null && !this.cimObjectPath.equals(((Linux_DnsMasterZone)object).cimObjectPath)) {
	        return false;
	        
	    } 
	    
	    return true;
	}
	
	/**
	*	The method return this method as a string
	*/	
	public String toString() {
		return this.cimInstance.toString();
	}

	//*****************************************************
	// Associators methods
	//*****************************************************
	
	
	
	//*****************************************************
	// Attribute methods
	//*****************************************************
	
	// Attribute Contact
	
	public String get_Contact() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_CONTACT);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_CONTACT + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_CONTACT + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (String)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Contact(String newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_CONTACT);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_CONTACT + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Contact(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_CONTACT);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_CONTACT + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.STRING));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Expire
	
	public UnsignedInt32 get_Expire() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_EXPIRE);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_EXPIRE + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_EXPIRE + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (UnsignedInt32)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Expire(UnsignedInt32 newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_EXPIRE);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_EXPIRE + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Expire(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_EXPIRE);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_EXPIRE + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.UINT32));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Forward
	
	public UnsignedInt8 get_Forward() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_FORWARD);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_FORWARD + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT8) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_FORWARD + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT8) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (UnsignedInt8)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Forward(UnsignedInt8 newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_FORWARD);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_FORWARD + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Forward(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_FORWARD);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT8) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_FORWARD + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT8) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.UINT8));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Name
	
	public String get_Name() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_NAME);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NAME + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NAME + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (String)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Name(String newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_NAME);
    	
		if (isValidCimInstance()) {
    		throw new InvalidParameterException("The property " + Linux_DnsMasterZone.CIM_PROPERTY_NAME + "can not be modified. It is a KEY value.");
    		
		} else if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NAME + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Name(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_NAME);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NAME + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.STRING));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute NegativeCachingTTL
	
	public UnsignedInt32 get_NegativeCachingTTL() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_NEGATIVECACHINGTTL);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NEGATIVECACHINGTTL + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NEGATIVECACHINGTTL + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (UnsignedInt32)currentProperty.getValue().getValue();
	}
	    
			
	public void set_NegativeCachingTTL(UnsignedInt32 newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_NEGATIVECACHINGTTL);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NEGATIVECACHINGTTL + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_NegativeCachingTTL(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_NEGATIVECACHINGTTL);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_NEGATIVECACHINGTTL + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.UINT32));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Refresh
	
	public UnsignedInt32 get_Refresh() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_REFRESH);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_REFRESH + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_REFRESH + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (UnsignedInt32)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Refresh(UnsignedInt32 newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_REFRESH);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_REFRESH + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Refresh(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_REFRESH);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_REFRESH + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.UINT32));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Retry
	
	public UnsignedInt32 get_Retry() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_RETRY);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_RETRY + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_RETRY + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (UnsignedInt32)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Retry(UnsignedInt32 newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_RETRY);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_RETRY + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Retry(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_RETRY);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_RETRY + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT32) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.UINT32));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute SerialNumber
	
	public String get_SerialNumber() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_SERIALNUMBER);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERIALNUMBER + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERIALNUMBER + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (String)currentProperty.getValue().getValue();
	}
	    
			
	public void set_SerialNumber(String newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_SERIALNUMBER);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERIALNUMBER + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_SerialNumber(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_SERIALNUMBER);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERIALNUMBER + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.STRING));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Server
	
	public String get_Server() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_SERVER);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERVER + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERVER + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (String)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Server(String newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_SERVER);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERVER + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Server(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_SERVER);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_SERVER + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.STRING));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute TTL
	
	public Integer get_TTL() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_TTL);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TTL + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.SINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TTL + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.SINT32) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (Integer)currentProperty.getValue().getValue();
	}
	    
			
	public void set_TTL(Integer newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_TTL);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TTL + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_TTL(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_TTL);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.SINT32) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TTL + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.SINT32) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.SINT32));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Type
	
	public UnsignedInt8 get_Type() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_TYPE);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TYPE + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT8) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TYPE + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT8) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (UnsignedInt8)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Type(UnsignedInt8 newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_TYPE);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TYPE + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_Type(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_TYPE);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.UINT8) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_TYPE + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.UINT8) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.UINT8));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute ZoneFile
	
	public String get_ZoneFile() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_ZONEFILE);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_ZONEFILE + " could not be found");
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_ZONEFILE + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (String)currentProperty.getValue().getValue();
	}
	    
			
	public void set_ZoneFile(String newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsMasterZone.CIM_PROPERTY_ZONEFILE);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_ZONEFILE + " could not be found");
    		
		} else if (!Linux_DnsMasterZoneHelper.isValid_ZoneFile(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsMasterZone.CIM_PROPERTY_ZONEFILE);
    		
		} else if (currentProperty.getType() == null || currentProperty.getType().getType() != CIMDataType.STRING) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsMasterZone.CIM_PROPERTY_ZONEFILE + " is not of expected type " + CIMDataType.getPredefinedType(CIMDataType.STRING) + ".");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue, new CIMDataType(CIMDataType.STRING));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	
	
	//*****************************************************
	// Invoke methods
	//*****************************************************
	
	

}
