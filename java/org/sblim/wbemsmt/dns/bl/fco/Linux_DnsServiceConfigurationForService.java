/** 
 * Linux_DnsServiceConfigurationForService.java
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
 * Description:  Association between a DNS service and its configuration
 * 
 */

package org.sblim.wbemsmt.dns.bl.fco;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.sblim.wbem.cim.CIMDataType;
import org.sblim.wbem.cim.CIMException;
import org.sblim.wbem.cim.CIMInstance;
import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.cim.CIMProperty;
import org.sblim.wbem.cim.CIMValue;
import org.sblim.wbemsmt.schema.cim29.CIM_ElementConfiguration;


/**
 *  Association between a DNS service and its configuration
 */
public class Linux_DnsServiceConfigurationForService extends CIM_ElementConfiguration  {
	
	public final static String CIM_CLASS_NAME = "Linux_DnsServiceConfigurationForService"; //$NON-NLS-1$
	public final static String CIM_CLASS_DISPLAYNAME = CIM_CLASS_NAME;

	private boolean validCimInstance = false;
	
	public final static String CIM_PROPERTY_LINUX_DNSSERVICE = "Element"; //$NON-NLS-1$
	public final static String CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION = "Configuration"; //$NON-NLS-1$
	
	
	
	
	

	public static Vector CIM_PropertyNameList	= new Vector();
	public static Vector CIM_PropertyList 		= new Vector();
	private static Set Java_Package_List 		= new HashSet();
	
	static {
		CIM_PropertyNameList.add(CIM_PROPERTY_LINUX_DNSSERVICE);
		CIM_PropertyNameList.add(CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION);
				
		for (int i = 0; i < CIM_ElementConfiguration.CIM_PropertyNameList.size(); i++) {
			
			Linux_DnsServiceConfigurationForService.CIM_PropertyNameList.add(CIM_ElementConfiguration.CIM_PropertyNameList.elementAt(i));
		}
		
		
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_LINUX_DNSSERVICE, new CIMValue(null, new CIMDataType(Linux_DnsService.CIM_CLASS_NAME))));
		CIM_PropertyList.add(new CIMProperty(CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION, new CIMValue(null, new CIMDataType(Linux_DnsServiceConfiguration.CIM_CLASS_NAME))));
				
		for (int i = 0; i < CIM_ElementConfiguration.CIM_PropertyList.size(); i++) {
			
			Linux_DnsServiceConfigurationForService.CIM_PropertyList.add(CIM_ElementConfiguration.CIM_PropertyList.elementAt(i));
		}
		
		addPackage("org.sblim.wbemsmt.dns.bl.fco");
				
		String[] parentClassPackageList = CIM_ElementConfiguration.getPackages();
		
		for (int i = 0; i < parentClassPackageList.length; i++) {
			Java_Package_List.add(parentClassPackageList[i]);
		}
	};
			
	
	
	
	
	//**********************************************************************
	// Constructors 	
	//**********************************************************************

	/**
	*	Class constructor
	*/	
	public Linux_DnsServiceConfigurationForService() {

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
	public Linux_DnsServiceConfigurationForService(Vector keyProperties){ 
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
	public Linux_DnsServiceConfigurationForService(CIMObjectPath cimObjectPath, CIMInstance cimInstance){ 
		
		if (cimInstance == null) {
			throw new InvalidParameterException("The cimInstance parameter does not contain a valid reference.");
		
		} else if (cimObjectPath == null){
			throw new InvalidParameterException("The cimObjectPath parameter does not contain a valid reference.");		
		
		} else if (!cimObjectPath.getObjectName().equals(cimInstance.getClassName())) {
			throw new InvalidParameterException("The class name of the instance and the ObjectPath are not the same.");
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
	
	public static void addPackage(String packagename) {
        if (packagename != null) {
            if (!packagename.endsWith(".")) {
                packagename = packagename + ".";
            }
            Linux_DnsServiceConfigurationForService.Java_Package_List.add(packagename);
            
        } else {
            throw new NullPointerException();
        }
    }

    public static String[] getPackages() {
        return (String[]) Linux_DnsServiceConfigurationForService.Java_Package_List.toArray(new String[Linux_DnsServiceConfigurationForService.Java_Package_List.size()]);
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
	    
	    if (!(object instanceof Linux_DnsServiceConfigurationForService)) {
	        return false;
	    }
	    
	    if (this.cimInstance == null && ((Linux_DnsServiceConfigurationForService)object).cimInstance != null) {
	    	return false;
	    	
	    } else if (this.cimInstance != null && ((Linux_DnsServiceConfigurationForService)object).cimInstance == null) {
	    	return false;
	    	
	    } else if (this.cimInstance != null && !this.cimInstance.equals(((Linux_DnsServiceConfigurationForService)object).cimInstance)) {
	    	return false;
	    	
	    } else if (this.original_cimInstance == null && ((Linux_DnsServiceConfigurationForService)object).original_cimInstance != null) {
	    	return false;
	    	
	    } else if (this.original_cimInstance != null && ((Linux_DnsServiceConfigurationForService)object).original_cimInstance == null) {
	    	return false;
	    	
	    } else if (this.original_cimInstance != null && !this.original_cimInstance.equals(((Linux_DnsServiceConfigurationForService)object).original_cimInstance)) {
	        return false;
	        
	    } else if (this.cimObjectPath == null && ((Linux_DnsServiceConfigurationForService)object).cimObjectPath != null) {
	    	return false;
	    	
	    } else if (this.cimObjectPath != null && ((Linux_DnsServiceConfigurationForService)object).cimObjectPath == null) {
	    	return false;
		    	
	    } else if (this.cimObjectPath != null && !this.cimObjectPath.equals(((Linux_DnsServiceConfigurationForService)object).cimObjectPath)) {
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
	
	// Attribute Linux_DnsService
	
	public CIMObjectPath get_Linux_DnsService() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICE);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICE + " could not be found");
    		
		} else if (currentProperty.getType() == null ) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICE + " is not of expected type Linux_DnsService.");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (CIMObjectPath)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Linux_DnsService(Linux_DnsService newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICE);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICE + " could not be found");
    		
		} else if (!Linux_DnsServiceConfigurationForServiceHelper.isValid_Linux_DnsService(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICE);
    		
		} else if (currentProperty.getType() == null ) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICE + " is not of expected type Linux_DnsService.");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue.getCimObjectPath(), new CIMDataType(Linux_DnsService.CIM_CLASS_NAME));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	// Attribute Linux_DnsServiceConfiguration
	
	public CIMObjectPath get_Linux_DnsServiceConfiguration() {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION);
        
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION + " could not be found");
    		
		} else if (currentProperty.getType() == null ) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION + " is not of expected type Linux_DnsServiceConfiguration.");
		}
        
		if (currentProperty.getValue() == null) {
			return null;
		}
        
		return (CIMObjectPath)currentProperty.getValue().getValue();
	}
	    
			
	public void set_Linux_DnsServiceConfiguration(Linux_DnsServiceConfiguration newValue) {
		
		CIMProperty currentProperty = this.cimInstance.getProperty(Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION);
    	
		if (currentProperty == null) {
			throw new CIMException(CIMException.CIM_ERR_NO_SUCH_PROPERTY, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION + " could not be found");
    		
		} else if (!Linux_DnsServiceConfigurationForServiceHelper.isValid_Linux_DnsServiceConfiguration(newValue)) {
			throw new InvalidParameterException("The value " + newValue + " is not valid for property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION);
    		
		} else if (currentProperty.getType() == null ) {
			throw new CIMException(CIMException.CIM_ERR_TYPE_MISMATCH, "The property " + Linux_DnsServiceConfigurationForService.CIM_PROPERTY_LINUX_DNSSERVICECONFIGURATION + " is not of expected type Linux_DnsServiceConfiguration.");
		}
    	
		CIMValue updatedValue = new CIMValue(newValue.getCimObjectPath(), new CIMDataType(Linux_DnsServiceConfiguration.CIM_CLASS_NAME));
		currentProperty.setValue(updatedValue);
	}	
	    
	

	
	
	//*****************************************************
	// Invoke methods
	//*****************************************************
	
	

}
