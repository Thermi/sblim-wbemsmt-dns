/** 
 * Linux_DnsStubZone.java
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
 * Description: Class representing DNS zones of type Stub.
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.bl.fco;

import javax.cim.*;
import javax.wbem.client.*;

import org.sblim.wbemsmt.exception.*;

public class Linux_DnsStubZone extends Linux_DnsZone {

    public final static String CIM_CLASS_NAME = "Linux_DnsStubZone";
    public final static String CIM_CLASS_DISPLAYNAME = CIM_CLASS_NAME;

    /**
     * Constants of property Forward
     * The default behavior for forwarding requests.
     */
    public static class PROPERTY_FORWARD {
        /**
         * name of the property Forward
         */
        public final static String NAME = "Forward";

        /**
         * constant for value map entry 0
         */

        public final static javax.cim.UnsignedInteger8 VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown = new javax.cim.UnsignedInteger8(
                "0");

        /**
         * constant for value entry Unknown (corresponds to mapEntry 0 )
         */
        public final static String VALUE_ENTRY_Unknown = "Unknown";

        /**
         * constant for value map entry 1
         */

        public final static javax.cim.UnsignedInteger8 VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Only = new javax.cim.UnsignedInteger8(
                "1");

        /**
         * constant for value entry Only (corresponds to mapEntry 1 )
         */
        public final static String VALUE_ENTRY_Only = "Only";

        /**
         * constant for value map entry 2
         */

        public final static javax.cim.UnsignedInteger8 VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_First = new javax.cim.UnsignedInteger8(
                "2");

        /**
         * constant for value entry First (corresponds to mapEntry 2 )
         */
        public final static String VALUE_ENTRY_First = "First";

        /**
         * get the ValueMapEntry of the given value
         * @param value the value to find the ValueMapEntry for
         * @return the ValueMap entry or null if not found
         */
        //org.sblim.wbemsmt.dcg.generator.DCGContextUtil$Wrapper@4cd580
        public static javax.cim.UnsignedInteger8 getValueMapEntry(String value) {

            if (VALUE_ENTRY_Unknown.equals(value)) {
                return VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown;
            }

            if (VALUE_ENTRY_Only.equals(value)) {
                return VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Only;
            }

            if (VALUE_ENTRY_First.equals(value)) {
                return VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_First;
            }
            return null;

        }

        /**
         * uses the element within array VALUE_ENTRIES_FOR_DISPLAY at index indexInPulldown to get the ValueMapEntry
         * @param indexInPulldown the index within the pulldown element, the list etc
         * @return the ValueMap entry from the displayed values
         */
        public static javax.cim.UnsignedInteger8 getValueMapEntryFromDisplayedValue(
                Number indexInPulldown) {
            return getValueMapEntry(VALUE_ENTRIES_FOR_DISPLAY[indexInPulldown.intValue()]);
        }

        /**
         * gets the value for the given valueMap entry (currentValue) and gives back the index of this value within the VALUE_ENTRIES_FOR_DISPLAY array
         *
         * can be used to set the correct selection index for a pulldown field
         *
         * @return -1 if for the currentValue no value within VALUE_ENTRIES_FOR_DISPLAY was found
         * @param currentValue the currentValue to get the index for
         */
        public static int getIndexForDisplay(javax.cim.UnsignedInteger8 currentValue) {
            String valueEntry = getValueEntry(currentValue);
            if (valueEntry != null) {
                for (int i = 0; i < VALUE_ENTRIES_FOR_DISPLAY.length; i++) {
                    if (VALUE_ENTRIES_FOR_DISPLAY[i].equals(valueEntry)) {
                        return i;
                    }
                }
            }
            return -1;

        }

        /**
         * get the ValueEntry of the given valueMapEntry
         * @param valueMapEntry the entry within the valueMap to find the ValueEntry for
         * @return the Value entry or null if not found
         */

        public static String getValueEntry(javax.cim.UnsignedInteger8 value) {
            int iValue = value.intValue();

            if (iValue == VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown.intValue()) {
                return VALUE_ENTRY_Unknown;
            }

            if (iValue == VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Only.intValue()) {
                return VALUE_ENTRY_Only;
            }

            if (iValue == VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_First.intValue()) {
                return VALUE_ENTRY_First;
            }
            return null;

        }

        /**
         * ValueMap entries
         * Contains no entries that having an integer value range representation
         * 
         * The couterpart for the value entries is returned by VALUE_ENTRIES_FOR_DISPLAY
         *
         * @see \#VALUE_ENTRIES_FOR_DISPLAY
         * 
         * Value Map for the property Forward   
         */
        public final static javax.cim.UnsignedInteger8[] VALUE_MAP_ENTRIES = {
                VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown, VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Only,
                VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_First };

        /**
         * Values
         * Contains all values even those having an integer value range representation within the valueMap
         * Value Map for the property Forward   
         */
        public final static String[] VALUE_ENTRIES = { VALUE_ENTRY_Unknown, VALUE_ENTRY_Only,
                VALUE_ENTRY_First };

        /**
         * Values for displaying within pulldown elements, lists, radio buttons etc
         * Contains no values that having an integer value range representation within the valueMap
         * 
         * Value Map for the property Forward   
         */
        public final static String[] VALUE_ENTRIES_FOR_DISPLAY = { VALUE_ENTRY_Unknown,
                VALUE_ENTRY_Only, VALUE_ENTRY_First };

    }

    /**
     * Constants of property Name
     * 
     */
    public static class PROPERTY_NAME {
        /**
         * name of the property Name
         */
        public final static String NAME = "Name";

    }

    /**
     * Constants of property TTL
     * The default time to live value for Resource Records (RR). TTL describes how long a RR can be cached, before it should be discarded.
     */
    public static class PROPERTY_TTL {
        /**
         * name of the property TTL
         */
        public final static String NAME = "TTL";

    }

    /**
     * Constants of property Type
     * Value = 3 for Type Stub.
     */
    public static class PROPERTY_TYPE {
        /**
         * name of the property Type
         */
        public final static String NAME = "Type";

    }

    /**
     * Constants of property ZoneFile
     * The zone file that contains the zone specific RR.
     */
    public static class PROPERTY_ZONEFILE {
        /**
         * name of the property ZoneFile
         */
        public final static String NAME = "ZoneFile";

    }

    static {
        addPackage("org.sblim.wbemsmt.dns.bl.fco");
        String[] parentClassPackageList = Linux_DnsZone.getPackages();

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
     *   Class representing DNS zones of type Stub.
     *   @param client the CIM Client
     *   @param namespace the target namespace
     */

    public Linux_DnsStubZone(WBEMClient client, String namespace) throws WbemsmtException {
        CIMClass cls = getClass(client, namespace);
        setFromServer(false);
        init(cls.newInstance(), true);
    }

    /**
     *   Class constructor
     * 
     *       *   <br>
     *   Class representing DNS zones of type Stub.
     *   @param cimInstance the instance that is used to create the Object
     */

    public Linux_DnsStubZone(CIMInstance cimInstance) throws WbemsmtException {

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
    protected Linux_DnsStubZone() {
    }

    /**
     * initializes the FCO
     *
     *   @param cimInstance the instance that is used to create the Object
     *   @param overwrite currently the dataType of embeddedObject/Instance properties is not set correct by the cimClient. This flags decides if to overwrite thos properties
     */
    protected void init(CIMInstance cimInstance, boolean overwrite) throws WbemsmtException {
        propertiesToCheck.put("Forward", new CIMProperty("Forward", CIMDataType.UINT8_T, null));
        propertiesToCheck.put("Name", new CIMProperty("Name", CIMDataType.STRING_T, null));
        propertiesToCheck.put("TTL", new CIMProperty("TTL", CIMDataType.SINT32_T, null));
        propertiesToCheck.put("Type", new CIMProperty("Type", CIMDataType.UINT8_T, null));
        propertiesToCheck.put("ZoneFile", new CIMProperty("ZoneFile", CIMDataType.STRING_T, null));

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
     * Get the property Forward
     *     * <br>
     * The default behavior for forwarding requests.
     *     */

    public javax.cim.UnsignedInteger8 get_Forward() {
        CIMProperty currentProperty = getProperty(PROPERTY_FORWARD.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_FORWARD.NAME + " was not found in instance "
                    + getCimObjectPath());
            return null;
        }

        return (javax.cim.UnsignedInteger8) currentProperty.getValue();

    }

    /**
     * Set the property Forward
     * <br>
     * The default behavior for forwarding requests.
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_Forward(javax.cim.UnsignedInteger8 newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_FORWARD.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_Forward(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_FORWARD.NAME + " was not found in instance "
                    + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property Forward by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_Forward(WBEMClient client, String namespace,
            javax.cim.UnsignedInteger8 newValue) throws WbemsmtException {
        Linux_DnsStubZone fco = new Linux_DnsStubZone(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_FORWARD.NAME);
        if (property != null) {
            property = setPropertyValue_Forward(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_FORWARD.NAME + " was not found in instance "
                    + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property Forward
     * <br>
     * The default behavior for forwarding requests.
     */

    private static CIMProperty setPropertyValue_Forward(CIMProperty currentProperty,
            javax.cim.UnsignedInteger8 newValue) {
        Object setThis = null;

        setThis = newValue;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

    /**
     * Get the property Name
     *     * <br>
     * 
     *     */

    public String get_key_Name() {
        CIMProperty currentProperty = getProperty(PROPERTY_NAME.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_NAME.NAME + " was not found in instance "
                    + getCimObjectPath());
            return null;
        }

        return (String) currentProperty.getValue();

    }

    /**
     * Set the property Name
     * <br>
     * 
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_key_Name(String newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_NAME.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_key_Name(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_NAME.NAME + " was not found in instance "
                    + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property Name by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_key_Name(WBEMClient client, String namespace, String newValue)
            throws WbemsmtException {
        Linux_DnsStubZone fco = new Linux_DnsStubZone(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_NAME.NAME);
        if (property != null) {
            property = setPropertyValue_key_Name(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_NAME.NAME + " was not found in instance "
                    + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property Name
     * <br>
     * 
     */

    private static CIMProperty setPropertyValue_key_Name(CIMProperty currentProperty,
            String newValue) {
        Object setThis = null;

        setThis = newValue;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

    /**
     * Get the property TTL
     *     * <br>
     * The default time to live value for Resource Records (RR). TTL describes how long a RR can be cached, before it should be discarded.
     *     */

    public Integer get_TTL() {
        CIMProperty currentProperty = getProperty(PROPERTY_TTL.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_TTL.NAME + " was not found in instance "
                    + getCimObjectPath());
            return null;
        }

        return (Integer) currentProperty.getValue();

    }

    /**
     * Set the property TTL
     * <br>
     * The default time to live value for Resource Records (RR). TTL describes how long a RR can be cached, before it should be discarded.
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_TTL(Integer newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_TTL.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_TTL(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_TTL.NAME + " was not found in instance "
                    + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property TTL by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_TTL(WBEMClient client, String namespace, Integer newValue)
            throws WbemsmtException {
        Linux_DnsStubZone fco = new Linux_DnsStubZone(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_TTL.NAME);
        if (property != null) {
            property = setPropertyValue_TTL(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_TTL.NAME + " was not found in instance "
                    + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property TTL
     * <br>
     * The default time to live value for Resource Records (RR). TTL describes how long a RR can be cached, before it should be discarded.
     */

    private static CIMProperty setPropertyValue_TTL(CIMProperty currentProperty, Integer newValue) {
        Object setThis = null;

        setThis = newValue;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

    /**
     * Get the property Type
     *     * <br>
     * Value = 3 for Type Stub.
     *     */

    public javax.cim.UnsignedInteger8 get_Type() {
        CIMProperty currentProperty = getProperty(PROPERTY_TYPE.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_TYPE.NAME + " was not found in instance "
                    + getCimObjectPath());
            return null;
        }

        return (javax.cim.UnsignedInteger8) currentProperty.getValue();

    }

    /**
     * Set the property Type
     * <br>
     * Value = 3 for Type Stub.
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_Type(javax.cim.UnsignedInteger8 newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_TYPE.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_Type(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_TYPE.NAME + " was not found in instance "
                    + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property Type by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_Type(WBEMClient client, String namespace,
            javax.cim.UnsignedInteger8 newValue) throws WbemsmtException {
        Linux_DnsStubZone fco = new Linux_DnsStubZone(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_TYPE.NAME);
        if (property != null) {
            property = setPropertyValue_Type(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_TYPE.NAME + " was not found in instance "
                    + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property Type
     * <br>
     * Value = 3 for Type Stub.
     */

    private static CIMProperty setPropertyValue_Type(CIMProperty currentProperty,
            javax.cim.UnsignedInteger8 newValue) {
        Object setThis = null;

        setThis = newValue;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

    /**
     * Get the property ZoneFile
     *     * <br>
     * The zone file that contains the zone specific RR.
     *     */

    public String get_ZoneFile() {
        CIMProperty currentProperty = getProperty(PROPERTY_ZONEFILE.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_ZONEFILE.NAME + " was not found in instance "
                    + getCimObjectPath());
            return null;
        }

        return (String) currentProperty.getValue();

    }

    /**
     * Set the property ZoneFile
     * <br>
     * The zone file that contains the zone specific RR.
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_ZoneFile(String newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_ZONEFILE.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_ZoneFile(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_ZONEFILE.NAME + " was not found in instance "
                    + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property ZoneFile by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_ZoneFile(WBEMClient client, String namespace, String newValue)
            throws WbemsmtException {
        Linux_DnsStubZone fco = new Linux_DnsStubZone(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_ZONEFILE.NAME);
        if (property != null) {
            property = setPropertyValue_ZoneFile(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_ZONEFILE.NAME + " was not found in instance "
                    + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property ZoneFile
     * <br>
     * The zone file that contains the zone specific RR.
     */

    private static CIMProperty setPropertyValue_ZoneFile(CIMProperty currentProperty,
            String newValue) {
        Object setThis = null;

        setThis = newValue;

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
        return Linux_DnsStubZone.CIM_CLASS_NAME;
    }

}