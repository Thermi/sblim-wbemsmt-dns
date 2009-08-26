/**
 * Linux_DnsServiceConfigurationForService.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS
 * PROVIDED UNDER THE TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR
 * DISTRIBUTION OF THIS FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a
 * current copy of the Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.fco.jsr48.FcoGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/fco/jsr48/fco.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Association between a DNS service and its
 *            configuration generated Class
 */

package org.sblim.wbemsmt.dns.bl.fco;

import javax.cim.*;
import javax.wbem.client.*;

import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.schema.cim221.*;

public class Linux_DnsServiceConfigurationForService extends CIM_ElementConfiguration {

    public final static String CIM_CLASS_NAME = "Linux_DnsServiceConfigurationForService";
    public final static String CIM_CLASS_DISPLAYNAME = CIM_CLASS_NAME;

    /**
     * Constants of property Element
     * 
     */
    public static class PROPERTY_ELEMENT_LINUX_DNSSERVICE {
        /**
         * name of the property Element
         */
        public final static String NAME = "Element";

    }

    /**
     * Constants of property Configuration
     * 
     */
    public static class PROPERTY_CONFIGURATION_LINUX_DNSSERVICECONFIGURATION {
        /**
         * name of the property Configuration
         */
        public final static String NAME = "Configuration";

    }

    static {
        addPackage("org.sblim.wbemsmt.dns.bl.fco");
        String[] parentClassPackageList = CIM_ElementConfiguration.getPackages();

        for (int i = 0; i < parentClassPackageList.length; i++) {
            addPackage(parentClassPackageList[i]);
        }

    };

    //**********************************************************************
    // Constructors     
    //**********************************************************************

    /**
     *   Class constructor
     * 
     *       *   <br>
     *   Association between a DNS service and its configuration
     *   @param client the CIM Client
     *   @param namespace the target namespace
     */

    public Linux_DnsServiceConfigurationForService(WBEMClient client, String namespace)
            throws WbemsmtException {
        CIMClass cls = getClass(client, namespace);
        setFromServer(false);
        init(cls.newInstance(), true);
    }

    /**
     *   Class constructor
     * 
     *       *   <br>
     *   Association between a DNS service and its configuration
     *   @param cimInstance the instance that is used to create the Object
     */

    public Linux_DnsServiceConfigurationForService(CIMInstance cimInstance) throws WbemsmtException {

        if (cimInstance == null) {
            throw new WbemsmtException(WbemsmtException.ERR_INVALID_PARAMETER,
                    "The cimInstance parameter does not contain a valid reference.");
        }
        setFromServer(true);
        init(cimInstance, false);
    }

    /**
     * Default constructor
     */
    protected Linux_DnsServiceConfigurationForService() {
    }

    /**
     * initializes the FCO
     *
     *   @param cimInstance the instance that is used to create the Object
     *   @param overwrite currently the dataType of embeddedObject/Instance properties is not set correct by the cimClient. This flags decides if to overwrite thos properties
     */
    protected void init(CIMInstance cimInstance, boolean overwrite) throws WbemsmtException {
        propertiesToCheck.put("Element", new CIMProperty("Element", new CIMDataType(
                Linux_DnsService.CIM_CLASS_NAME), null));
        propertiesToCheck.put("Configuration", new CIMProperty("Configuration", new CIMDataType(
                Linux_DnsServiceConfiguration.CIM_CLASS_NAME), null));

        super.init(cimInstance, overwrite);

        //currently the dataType of embeddedObject/Instance properties is not set correct by the cimClient
        //we overwrite the dataType by setting null for every embeddedObject/Instance property
        if (overwrite) {

        }
    }

    //**********************************************************************
    // Properties get/set     
    //**********************************************************************

    /**
     * Get the property Element
     * @param client the client used to get the JavaObject by the retrieved CIMObjectPath of this attribute    * <br>
     * 
     *     */

    public Linux_DnsService get_Element_Linux_DnsService(javax.wbem.client.WBEMClient client)
            throws WbemsmtException {
        CIMProperty currentProperty = getProperty(PROPERTY_ELEMENT_LINUX_DNSSERVICE.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_ELEMENT_LINUX_DNSSERVICE.NAME
                    + " was not found in instance " + getCimObjectPath());
            return null;
        }

        return Linux_DnsServiceHelper.getInstance(client, (CIMObjectPath) currentProperty
                .getValue());

    }

    /**
     * Set the property Element
     * <br>
     * 
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_Element_Linux_DnsService(Linux_DnsService newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_ELEMENT_LINUX_DNSSERVICE.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_Element_Linux_DnsService(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_ELEMENT_LINUX_DNSSERVICE.NAME
                    + " was not found in instance " + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property Element by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_Element_Linux_DnsService(WBEMClient client, String namespace,
            Linux_DnsService newValue) throws WbemsmtException {
        Linux_DnsServiceConfigurationForService fco = new Linux_DnsServiceConfigurationForService(
                client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_ELEMENT_LINUX_DNSSERVICE.NAME);
        if (property != null) {
            property = setPropertyValue_Element_Linux_DnsService(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_ELEMENT_LINUX_DNSSERVICE.NAME
                    + " was not found in instance " + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property Element
     * <br>
     * 
     */

    private static CIMProperty setPropertyValue_Element_Linux_DnsService(
            CIMProperty currentProperty, Linux_DnsService newValue) {
        Object setThis = null;

        setThis = newValue != null ? newValue.getCimObjectPath() : null;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

    /**
     * Get the property Configuration
     * @param client the client used to get the JavaObject by the retrieved CIMObjectPath of this attribute    * <br>
     * 
     *     */

    public Linux_DnsServiceConfiguration get_Configuration_Linux_DnsServiceConfiguration(
            javax.wbem.client.WBEMClient client) throws WbemsmtException {
        CIMProperty currentProperty = getProperty(PROPERTY_CONFIGURATION_LINUX_DNSSERVICECONFIGURATION.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_CONFIGURATION_LINUX_DNSSERVICECONFIGURATION.NAME
                    + " was not found in instance " + getCimObjectPath());
            return null;
        }

        return Linux_DnsServiceConfigurationHelper.getInstance(client,
                (CIMObjectPath) currentProperty.getValue());

    }

    /**
     * Set the property Configuration
     * <br>
     * 
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_Configuration_Linux_DnsServiceConfiguration(
            Linux_DnsServiceConfiguration newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_CONFIGURATION_LINUX_DNSSERVICECONFIGURATION.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_Configuration_Linux_DnsServiceConfiguration(
                    currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_CONFIGURATION_LINUX_DNSSERVICECONFIGURATION.NAME
                    + " was not found in instance " + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property Configuration by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_Configuration_Linux_DnsServiceConfiguration(WBEMClient client,
            String namespace, Linux_DnsServiceConfiguration newValue) throws WbemsmtException {
        Linux_DnsServiceConfigurationForService fco = new Linux_DnsServiceConfigurationForService(
                client, namespace);
        CIMProperty property = fco
                .getProperty(PROPERTY_CONFIGURATION_LINUX_DNSSERVICECONFIGURATION.NAME);
        if (property != null) {
            property = setPropertyValue_Configuration_Linux_DnsServiceConfiguration(property,
                    newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_CONFIGURATION_LINUX_DNSSERVICECONFIGURATION.NAME
                    + " was not found in instance " + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property Configuration
     * <br>
     * 
     */

    private static CIMProperty setPropertyValue_Configuration_Linux_DnsServiceConfiguration(
            CIMProperty currentProperty, Linux_DnsServiceConfiguration newValue) {
        Object setThis = null;

        setThis = newValue != null ? newValue.getCimObjectPath() : null;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

    //**********************************************************************
    // Associators methods     
    //**********************************************************************

    //**********************************************************************
    // Extrinsic Method invocations     
    //**********************************************************************                         

    //**********************************************************************
    // utility methods     
    //**********************************************************************                         

    /**
     * return the name of the CIMClass
     * @return
     */
    public String getObjectName() {
        return Linux_DnsServiceConfigurationForService.CIM_CLASS_NAME;
    }

}