/** 
 * Linux_DnsAllowQueryForService.java
 *
 * 
 * © Copyright IBM Corp. 2006,2007
 *
 * THIS FILE IS PROVIDED UNDER THE TER	MS OF THE COMMON PUBLIC LICENSE
 * ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
 * CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
 *
 * You can obtain a current copy of the Common Public License from
 * http://www.opensource.org/licenses/cpl1.0.php
 *
 * @author: org.sblim.wbemsmt.dcg.generator.fco.jsr48.FcoGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/fco/jsr48/fco.vm
 *
 * Contributors:
 *    michael.bauschert@de.ibm.com 
 * 
 * Description: Association pointing to Address Match Lists, hosting the list of elements that are allowed to support the request type: query.
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.bl.fco;

import javax.cim.*;
import javax.wbem.client.*;

import org.sblim.wbemsmt.exception.*;

import org.sblim.wbemsmt.schema.cim29.*;

public class Linux_DnsAllowQueryForService extends CIM_Component {

    public final static String CIM_CLASS_NAME = "Linux_DnsAllowQueryForService";
    public final static String CIM_CLASS_DISPLAYNAME = CIM_CLASS_NAME;

    /**
     * Constants of property GroupComponent
     * 
     */
    public static class PROPERTY_GROUPCOMPONENT_LINUX_DNSSERVICE {
        /**
         * name of the property GroupComponent
         */
        public final static String NAME = "GroupComponent";

    }

    /**
     * Constants of property PartComponent
     * 
     */
    public static class PROPERTY_PARTCOMPONENT_LINUX_DNSADDRESSMATCHLIST {
        /**
         * name of the property PartComponent
         */
        public final static String NAME = "PartComponent";

    }

    static {
        addPackage("org.sblim.wbemsmt.dns.bl.fco");
        String[] parentClassPackageList = CIM_Component.getPackages();

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
     *   Association pointing to Address Match Lists, hosting the list of elements that are allowed to support the request type: query.
     *   @param client the CIM Client
     *   @param namespace the target namespace
     */

    public Linux_DnsAllowQueryForService(WBEMClient client, String namespace)
            throws WbemsmtException {
        CIMClass cls = getClass(client, namespace);
        setFromServer(false);
        init(cls.newInstance(), true);
    }

    /**
     *   Class constructor
     * 
     *       *   <br>
     *   Association pointing to Address Match Lists, hosting the list of elements that are allowed to support the request type: query.
     *   @param cimInstance the instance that is used to create the Object
     */

    public Linux_DnsAllowQueryForService(CIMInstance cimInstance) throws WbemsmtException {

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
    protected Linux_DnsAllowQueryForService() {
    }

    /**
     * initializes the FCO
     *
     *   @param cimInstance the instance that is used to create the Object
     *   @param overwrite currently the dataType of embeddedObject/Instance properties is not set correct by the cimClient. This flags decides if to overwrite thos properties
     */
    protected void init(CIMInstance cimInstance, boolean overwrite) throws WbemsmtException {
        propertiesToCheck.put("GroupComponent", new CIMProperty("GroupComponent", new CIMDataType(
                Linux_DnsService.CIM_CLASS_NAME), null));
        propertiesToCheck.put("PartComponent", new CIMProperty("PartComponent", new CIMDataType(
                Linux_DnsAddressMatchList.CIM_CLASS_NAME), null));

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
     * Get the property GroupComponent
     * @param client the client used to get the JavaObject by the retrieved CIMObjectPath of this attribute    * <br>
     * 
     *     */

    public Linux_DnsService get_GroupComponent_Linux_DnsService(javax.wbem.client.WBEMClient client)
            throws WbemsmtException {
        CIMProperty currentProperty = getProperty(PROPERTY_GROUPCOMPONENT_LINUX_DNSSERVICE.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_GROUPCOMPONENT_LINUX_DNSSERVICE.NAME
                    + " was not found in instance " + getCimObjectPath());
            return null;
        }

        return Linux_DnsServiceHelper.getInstance(client, (CIMObjectPath) currentProperty
                .getValue());

    }

    /**
     * Set the property GroupComponent
     * <br>
     * 
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_GroupComponent_Linux_DnsService(Linux_DnsService newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_GROUPCOMPONENT_LINUX_DNSSERVICE.NAME);
        if (currentProperty != null) {
            currentProperty = setPropertyValue_GroupComponent_Linux_DnsService(currentProperty,
                    newValue);
            this.instance = this.instance.deriveInstance(new CIMProperty[] { currentProperty });
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_GROUPCOMPONENT_LINUX_DNSSERVICE.NAME
                    + " was not found in instance " + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property GroupComponent by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_GroupComponent_Linux_DnsService(WBEMClient client,
            String namespace, Linux_DnsService newValue) throws WbemsmtException {
        Linux_DnsAllowQueryForService fco = new Linux_DnsAllowQueryForService(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_GROUPCOMPONENT_LINUX_DNSSERVICE.NAME);
        if (property != null) {
            property = setPropertyValue_GroupComponent_Linux_DnsService(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_GROUPCOMPONENT_LINUX_DNSSERVICE.NAME
                    + " was not found in instance " + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property GroupComponent
     * <br>
     * 
     */

    private static CIMProperty setPropertyValue_GroupComponent_Linux_DnsService(
            CIMProperty currentProperty, Linux_DnsService newValue) {
        Object setThis = null;

        setThis = newValue != null ? newValue.getCimObjectPath() : null;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

    /**
     * Get the property PartComponent
     * @param client the client used to get the JavaObject by the retrieved CIMObjectPath of this attribute    * <br>
     * 
     *     */

    public Linux_DnsAddressMatchList get_PartComponent_Linux_DnsAddressMatchList(
            javax.wbem.client.WBEMClient client) throws WbemsmtException {
        CIMProperty currentProperty = getProperty(PROPERTY_PARTCOMPONENT_LINUX_DNSADDRESSMATCHLIST.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_PARTCOMPONENT_LINUX_DNSADDRESSMATCHLIST.NAME
                    + " was not found in instance " + getCimObjectPath());
            return null;
        }

        return Linux_DnsAddressMatchListHelper.getInstance(client, (CIMObjectPath) currentProperty
                .getValue());

    }

    /**
     * Set the property PartComponent
     * <br>
     * 
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_PartComponent_Linux_DnsAddressMatchList(Linux_DnsAddressMatchList newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_PARTCOMPONENT_LINUX_DNSADDRESSMATCHLIST.NAME);
        if (currentProperty != null) {
            currentProperty = setPropertyValue_PartComponent_Linux_DnsAddressMatchList(
                    currentProperty, newValue);
            this.instance = this.instance.deriveInstance(new CIMProperty[] { currentProperty });
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_PARTCOMPONENT_LINUX_DNSADDRESSMATCHLIST.NAME
                    + " was not found in instance " + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property PartComponent by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_PartComponent_Linux_DnsAddressMatchList(WBEMClient client,
            String namespace, Linux_DnsAddressMatchList newValue) throws WbemsmtException {
        Linux_DnsAllowQueryForService fco = new Linux_DnsAllowQueryForService(client, namespace);
        CIMProperty property = fco
                .getProperty(PROPERTY_PARTCOMPONENT_LINUX_DNSADDRESSMATCHLIST.NAME);
        if (property != null) {
            property = setPropertyValue_PartComponent_Linux_DnsAddressMatchList(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_PARTCOMPONENT_LINUX_DNSADDRESSMATCHLIST.NAME
                    + " was not found in instance " + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property PartComponent
     * <br>
     * 
     */

    private static CIMProperty setPropertyValue_PartComponent_Linux_DnsAddressMatchList(
            CIMProperty currentProperty, Linux_DnsAddressMatchList newValue) {
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
        return Linux_DnsAllowQueryForService.CIM_CLASS_NAME;
    }

}