/** 
 * Linux_DnsServiceSettingData.java
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
 * Description: Class representing the DNS service base configuration.
 * 
 * generated Class
 */

package org.sblim.wbemsmt.dns.bl.fco;

import javax.cim.*;
import javax.wbem.client.*;

import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.exception.impl.*;
import org.sblim.wbemsmt.exception.impl.userobject.*;

import org.sblim.wbemsmt.schema.cim29.*;

import java.lang.reflect.*;
import javax.wbem.*;

public class Linux_DnsServiceSettingData extends CIM_SettingData {

    public final static String CIM_CLASS_NAME = "Linux_DnsServiceSettingData";
    public final static String CIM_CLASS_DISPLAYNAME = CIM_CLASS_NAME;

    /**
     * Association between DNS Configuration and Setting
     */

    public final static String CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION = "Linux_DnsServiceSettingDataForServiceConfiguration";

    /**
     * Constants of property ConfigurationDirectory
     * The full qualified path to the directory containing the configuration files, e.g. /etc/domain.
     */
    public static class PROPERTY_CONFIGURATIONDIRECTORY {
        /**
         * name of the property ConfigurationDirectory
         */
        public final static String NAME = "ConfigurationDirectory";

    }

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
        //org.sblim.wbemsmt.dcg.generator.DCGContextUtil$Wrapper@14dc14dc
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
     * Id of the DNS Service this setting applies to.
     */
    public static class PROPERTY_NAME {
        /**
         * name of the property Name
         */
        public final static String NAME = "Name";

    }

    /**
     * Constants of property XferFormat
     * The transfer format that indicates, how updates are processed: incremental, complete.
     */
    public static class PROPERTY_XFERFORMAT {
        /**
         * name of the property XferFormat
         */
        public final static String NAME = "XferFormat";

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

        public final static javax.cim.UnsignedInteger8 VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Incremental = new javax.cim.UnsignedInteger8(
                "1");

        /**
         * constant for value entry Incremental (corresponds to mapEntry 1 )
         */
        public final static String VALUE_ENTRY_Incremental = "Incremental";

        /**
         * constant for value map entry 2
         */

        public final static javax.cim.UnsignedInteger8 VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_Complete = new javax.cim.UnsignedInteger8(
                "2");

        /**
         * constant for value entry Complete (corresponds to mapEntry 2 )
         */
        public final static String VALUE_ENTRY_Complete = "Complete";

        /**
         * get the ValueMapEntry of the given value
         * @param value the value to find the ValueMapEntry for
         * @return the ValueMap entry or null if not found
         */
        //org.sblim.wbemsmt.dcg.generator.DCGContextUtil$Wrapper@56b256b2
        public static javax.cim.UnsignedInteger8 getValueMapEntry(String value) {

            if (VALUE_ENTRY_Unknown.equals(value)) {
                return VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown;
            }

            if (VALUE_ENTRY_Incremental.equals(value)) {
                return VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Incremental;
            }

            if (VALUE_ENTRY_Complete.equals(value)) {
                return VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_Complete;
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

            if (iValue == VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Incremental.intValue()) {
                return VALUE_ENTRY_Incremental;
            }

            if (iValue == VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_Complete.intValue()) {
                return VALUE_ENTRY_Complete;
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
         * Value Map for the property XferFormat   
         */
        public final static javax.cim.UnsignedInteger8[] VALUE_MAP_ENTRIES = {
                VALUE_MAP_ENTRY_0_FOR_VALUE_ENTRY_Unknown,
                VALUE_MAP_ENTRY_1_FOR_VALUE_ENTRY_Incremental,
                VALUE_MAP_ENTRY_2_FOR_VALUE_ENTRY_Complete };

        /**
         * Values
         * Contains all values even those having an integer value range representation within the valueMap
         * Value Map for the property XferFormat   
         */
        public final static String[] VALUE_ENTRIES = { VALUE_ENTRY_Unknown,
                VALUE_ENTRY_Incremental, VALUE_ENTRY_Complete };

        /**
         * Values for displaying within pulldown elements, lists, radio buttons etc
         * Contains no values that having an integer value range representation within the valueMap
         * 
         * Value Map for the property XferFormat   
         */
        public final static String[] VALUE_ENTRIES_FOR_DISPLAY = { VALUE_ENTRY_Unknown,
                VALUE_ENTRY_Incremental, VALUE_ENTRY_Complete };

    }

    static {
        addPackage("org.sblim.wbemsmt.dns.bl.fco");
        String[] parentClassPackageList = CIM_SettingData.getPackages();

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
     *   Class representing the DNS service base configuration.
     *   @param client the CIM Client
     *   @param namespace the target namespace
     */

    public Linux_DnsServiceSettingData(WBEMClient client, String namespace) throws WbemsmtException {
        CIMClass cls = getClass(client, namespace);
        setFromServer(false);
        init(cls.newInstance(), true);
    }

    /**
     *   Class constructor
     * 
     *       *   <br>
     *   Class representing the DNS service base configuration.
     *   @param cimInstance the instance that is used to create the Object
     */

    public Linux_DnsServiceSettingData(CIMInstance cimInstance) throws WbemsmtException {

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
    protected Linux_DnsServiceSettingData() {
    }

    /**
     * initializes the FCO
     *
     *   @param cimInstance the instance that is used to create the Object
     *   @param overwrite currently the dataType of embeddedObject/Instance properties is not set correct by the cimClient. This flags decides if to overwrite thos properties
     */
    protected void init(CIMInstance cimInstance, boolean overwrite) throws WbemsmtException {
        propertiesToCheck.put("ConfigurationDirectory", new CIMProperty("ConfigurationDirectory",
                CIMDataType.STRING_T, null));
        propertiesToCheck.put("Forward", new CIMProperty("Forward", CIMDataType.UINT8_T, null));
        propertiesToCheck.put("Name", new CIMProperty("Name", CIMDataType.STRING_T, null));
        propertiesToCheck.put("XferFormat",
                new CIMProperty("XferFormat", CIMDataType.UINT8_T, null));

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
     * Get the property ConfigurationDirectory
     *     * <br>
     * The full qualified path to the directory containing the configuration files, e.g. /etc/domain.
     *     */

    public String get_ConfigurationDirectory() {
        CIMProperty currentProperty = getProperty(PROPERTY_CONFIGURATIONDIRECTORY.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_CONFIGURATIONDIRECTORY.NAME
                    + " was not found in instance " + getCimObjectPath());
            return null;
        }

        return (String) currentProperty.getValue();

    }

    /**
     * Set the property ConfigurationDirectory
     * <br>
     * The full qualified path to the directory containing the configuration files, e.g. /etc/domain.
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_ConfigurationDirectory(String newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_CONFIGURATIONDIRECTORY.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_ConfigurationDirectory(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_CONFIGURATIONDIRECTORY.NAME
                    + " was not found in instance " + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property ConfigurationDirectory by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_ConfigurationDirectory(WBEMClient client, String namespace,
            String newValue) throws WbemsmtException {
        Linux_DnsServiceSettingData fco = new Linux_DnsServiceSettingData(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_CONFIGURATIONDIRECTORY.NAME);
        if (property != null) {
            property = setPropertyValue_ConfigurationDirectory(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_CONFIGURATIONDIRECTORY.NAME
                    + " was not found in instance " + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property ConfigurationDirectory
     * <br>
     * The full qualified path to the directory containing the configuration files, e.g. /etc/domain.
     */

    private static CIMProperty setPropertyValue_ConfigurationDirectory(CIMProperty currentProperty,
            String newValue) {
        Object setThis = null;

        setThis = newValue;

        CIMProperty newProperty = new CIMProperty(currentProperty.getName(), currentProperty
                .getDataType(), setThis, currentProperty.isKey(), currentProperty.isPropagated(),
                currentProperty.getOriginClass());

        return newProperty;
    }

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
        Linux_DnsServiceSettingData fco = new Linux_DnsServiceSettingData(client, namespace);
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
     * Id of the DNS Service this setting applies to.
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
     * Id of the DNS Service this setting applies to.
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
        Linux_DnsServiceSettingData fco = new Linux_DnsServiceSettingData(client, namespace);
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
     * Id of the DNS Service this setting applies to.
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
     * Get the property XferFormat
     *     * <br>
     * The transfer format that indicates, how updates are processed: incremental, complete.
     *     */

    public javax.cim.UnsignedInteger8 get_XferFormat() {
        CIMProperty currentProperty = getProperty(PROPERTY_XFERFORMAT.NAME);

        if (currentProperty == null || currentProperty.getValue() == null) {
            logger.warning("Property " + PROPERTY_XFERFORMAT.NAME + " was not found in instance "
                    + getCimObjectPath());
            return null;
        }

        return (javax.cim.UnsignedInteger8) currentProperty.getValue();

    }

    /**
     * Set the property XferFormat
     * <br>
     * The transfer format that indicates, how updates are processed: incremental, complete.
     *
     * @return true if the property was found, false if the property was not found and the value was not set
     */

    public boolean set_XferFormat(javax.cim.UnsignedInteger8 newValue) {
        CIMProperty currentProperty = getProperty(PROPERTY_XFERFORMAT.NAME);
        if (currentProperty != null) {
            setProperty(setPropertyValue_XferFormat(currentProperty, newValue));
            return true;
        }
        else {
            logger.warning("Property " + PROPERTY_XFERFORMAT.NAME + " was not found in instance "
                    + getCimObjectPath());
            return false;
        }

    }

    /**
     * Get the property XferFormat by getting the class from the server<br>
     * and retrieving the property from it
     * After that the value is set to this property and the property is returned
     * @return null if the property cannot be found in the instance from the server
     * @throws WbemsmtException 
     */

    public static CIMProperty create_XferFormat(WBEMClient client, String namespace,
            javax.cim.UnsignedInteger8 newValue) throws WbemsmtException {
        Linux_DnsServiceSettingData fco = new Linux_DnsServiceSettingData(client, namespace);
        CIMProperty property = fco.getProperty(PROPERTY_XFERFORMAT.NAME);
        if (property != null) {
            property = setPropertyValue_XferFormat(property, newValue);
        }
        else {
            logger.warning("Property " + PROPERTY_XFERFORMAT.NAME + " was not found in instance "
                    + fco.getCimObjectPath());
        }
        return property;
    }

    /**
     * Set the property XferFormat
     * <br>
     * The transfer format that indicates, how updates are processed: incremental, complete.
     */

    private static CIMProperty setPropertyValue_XferFormat(CIMProperty currentProperty,
            javax.cim.UnsignedInteger8 newValue) {
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

    /**
     * Get the list with Linux_DnsServiceConfiguration objects associated by the association Linux_DnsServiceSettingDataForServiceConfiguration
     * 
     * @param cimClient the WBEMClient for the communication
     *
     * uses CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION as associationClass<br>
     * uses false for includeQualifiers and includeClassOrigin <br>
     * uses null for resultClass, role, resultRole<br>
     * <br>
     * @see javax.wbem.client.WBEMClient#associators(CIMObjectPath, String, String, String, String, boolean, boolean, String[])
     **/

    public java.util.List getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurations(
            WBEMClient cimClient) throws WbemsmtException {

        return getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurations(
                cimClient,
                CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                Linux_DnsServiceConfiguration.CIM_CLASS_NAME, null, null, false, false, null);

    }

    /**
     * Get the list with Linux_DnsServiceConfiguration objects associated by the association Linux_DnsServiceSettingDataForServiceConfiguration
     * 
     * @param cimClient the WBEMClient for the communication
     * @param resultClass This string MUST either contain a valid CIM Class name or be null. It filters the Objects returned to contain only the Objects of this Class name or one of its subclasses. The resultClass should be CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION or a subclass 
     * @param role This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects associated to the source Object via an Association class in which the source Object plays the specified role. (i.e. the Property name in the Association class that refers to the source Object matches this value) If "Antecedent" is specified, then only Associations in which the source Object is the "Antecedent" reference are examined.
     * @param resultRole This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects associated to the source Object via an Association class in which the Object returned plays the specified role. (i.e. the Property name in the Association class that refers to the Object returned matches this value) If "Dependent" is specified, then only Associations in which the Object returned is the "Dependent" reference are examined. 
     *
     * uses CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION as associationClass<br>
     * uses false for includeQualifiers and includeClassOrigin <br>
     * uses null for resultClass, role, resultRole<br>
     * <br>
     * @see javax.wbem.client.WBEMClient#associators(CIMObjectPath, String, String, String, String, boolean, boolean, String[])
     **/

    public java.util.List getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurations(
            WBEMClient cimClient, String resultClass, String role, String resultRole)
            throws WbemsmtException {

        return getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurations(
                cimClient,
                CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                resultClass, role, resultRole, false, false, null);

    }

    /**
     * Get the list with Linux_DnsServiceConfiguration objects associated by the association Linux_DnsServiceSettingDataForServiceConfiguration
     * 
     * @param cimClient the WBEMClient for the communication
     * @param associationClass This string MUST either contain a valid CIM Association class name or be null. It filters the Objects returned to contain only Objects associated to the source Object via this CIM Association class or one of its subclasses.
     * @param resultClass This string MUST either contain a valid CIM Class name or be null. It filters the Objects returned to contain only the Objects of this Class name or one of its subclasses. The resultClass should be CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION or a subclass 
     * @param role This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects associated to the source Object via an Association class in which the source Object plays the specified role. (i.e. the Property name in the Association class that refers to the source Object matches this value) If "Antecedent" is specified, then only Associations in which the source Object is the "Antecedent" reference are examined.
     * @param resultRole This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects associated to the source Object via an Association class in which the Object returned plays the specified role. (i.e. the Property name in the Association class that refers to the Object returned matches this value) If "Dependent" is specified, then only Associations in which the Object returned is the "Dependent" reference are examined. 
     * @param includeQualifiers If true, all Qualifiers for each Object (including Qualifiers on the Object and on any returned Properties) MUST be included in the Objects returned. If false, no Qualifiers are present in each Object returned.
     * @param includeClassOrigin If true, the CLASSORIGIN attribute will be present on all appropriate elements in the Objects returned. If false, no CLASSORIGIN attributes are present in the Objects returned. CLASSORIGIN is attached to an element (properties, methods, references) to indicate the class in which it was first defined.
     * @param propertyList An array of property names used to filter what is contained in the Objects returned. Each CIMClass or CIMInstance returned only contains elements for the properties of the names specified. Duplicate and invalid property names are ignored and the request is otherwise processed normally. An empty array indicates that no properties should be included in the Objects returned. A null value indicates that all properties should be contained in the Objects returned. NOTE: Properties should not be specified in this parameter unless a non-null value is specified in the resultClass  parameter.
     *
     * @see javax.wbem.client.WBEMClient#associators(CIMObjectPath, String, String, String, String, boolean, boolean, String[])
     **/

    public java.util.List getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurations(
            WBEMClient cimClient, String associationClass, String resultClass, String role,
            String resultRole, boolean includeQualifiers, boolean includeClassOrigin,
            java.lang.String[] propertyList) throws WbemsmtException {

        if (cimClient == null) {
            throw new WbemsmtException(WbemsmtException.ERR_INVALID_PARAMETER,
                    "The cimClient parameter does not contain a valid reference.");
        }

        java.util.List result = new java.util.ArrayList();
        CloseableIterator enumeration = null;

        try {
            enumeration = cimClient.associators(this.getCimObjectPath(), associationClass,
                    resultClass, role, resultRole, includeQualifiers, includeClassOrigin,
                    propertyList);
        }
        catch (WBEMException e) {
            throw new AssociatorException(e, new AssociatorUserObject(this.getCimObjectPath(),
                    associationClass, resultClass, role, resultRole, includeQualifiers,
                    includeClassOrigin, propertyList));
        }

        try {
            while (enumeration.hasNext()) {
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);

                Object obj = enumeration.next();
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);

                if (obj instanceof CIMInstance) {
                    CIMInstance cimInstance = (CIMInstance) obj;
                    Class clazz = Linux_DnsServiceSettingDataHelper.findClass(cimClient,
                            cimInstance);

                    if (clazz == null) {
                        System.err.println("The class " + cimInstance.getClassName()
                                + " was not found. Constructing instance of the base class.");
                        result.add(new Linux_DnsServiceConfiguration(cimInstance));
                        continue;
                    }

                    Class[] constParams = new Class[1];
                    constParams[0] = CIMInstance.class;
                    Constructor cons = null;
                    try {
                        cons = clazz.getConstructor(constParams);
                    }
                    catch (NoSuchMethodException e) {
                        System.err.println("The required constructor of class "
                                + cimInstance.getClassName()
                                + " could not be found. Constructing instance of the base class.");
                        result.add(new Linux_DnsServiceConfiguration(cimInstance));
                        continue;
                    }

                    try {
                        Object[] actargs = new Object[] { cimInstance };
                        Object dataObj = cons.newInstance(actargs);
                        result.add(dataObj);
                    }
                    catch (Exception e) {
                        System.err
                                .println("The instance of class "
                                        + cimInstance.getClassName()
                                        + " could not be created successful. Constructing instance of the base class.");
                        result.add(new Linux_DnsServiceConfiguration(cimInstance));
                        continue;
                    }
                }
            }
            Linux_DnsServiceSettingDataHelper.checkException(enumeration);
        }
        finally {
            try {
                if (enumeration != null) {
                    enumeration.close();
                }
            }
            catch (Exception e) {
                throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                        "The socket of the result could not be closed properly.");
            }
        }

        return result;
    }

    /**
     * Get the list of CIMObjectPath items of the objects associated by the association Linux_DnsServiceSettingDataForServiceConfiguration
     * @param cimClient the WBEMClient for the communication
     *
     * uses CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION as associationClass<br>
     * uses false for includeQualifiers and includeClassOrigin <br>
     * uses null for resultClass, role, resultRole<br>
     * <br>
     
     * @see javax.wbem.client.WBEMClient#associatorNames(CIMObjectPath, String, String, String, String)
     **/

    public java.util.List getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurationNames(
            WBEMClient cimClient) throws WbemsmtException {

        return getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurationNames(
                cimClient, true,
                CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                Linux_DnsServiceConfiguration.CIM_CLASS_NAME, null, null);
    }

    /**
     * Get the list of CIMObjectPath items of the objects associated by the association Linux_DnsServiceSettingDataForServiceConfiguration
     * @param cimClient the WBEMClient for the communication
     * @param resultClass This string MUST either contain a valid CIM Class name or be null. It filters the Objects returned to contain only the Objects of this Class name or one of its subclasses. The resultClass should be CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION or a subclass 
     * @param role This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects associated to the source Object via an Association class in which the source Object plays the specified role. (i.e. the Property name in the Association class that refers to the source Object matches this value) If "Antecedent" is specified, then only Associations in which the source Object is the "Antecedent" reference are examined.
     * @param resultRole This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects associated to the source Object via an Association class in which the Object returned plays the specified role. (i.e. the Property name in the Association class that refers to the Object returned matches this value) If "Dependent" is specified, then only Associations in which the Object returned is the "Dependent" reference are examined. 
     *
     * uses CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION as associationClass<br>
     * uses false for includeQualifiers and includeClassOrigin <br>
     * uses null for resultClass, role, resultRole<br>
     * <br>
     
     * @see javax.wbem.client.WBEMClient#associatorNames(CIMObjectPath, String, String, String, String)
     **/

    public java.util.List getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurationNames(
            WBEMClient cimClient, String resultClass, String role, String resultRole)
            throws WbemsmtException {

        return getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurationNames(
                cimClient, true,
                CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                resultClass, role, resultRole);
    }

    /**
     * Get the list of CIMObjectPath items of the objects associated by the association Linux_DnsServiceSettingDataForServiceConfiguration
     * @param cimClient the WBEMClient for the communication
     * @param deep if true the subclasses returned also
     *
     * @see javax.wbem.client.WBEMClient#associatorNames(CIMObjectPath, String, String, String, String)
     **/

    public java.util.List getAssociated_Linux_DnsServiceConfiguration_Linux_DnsServiceSettingDataForServiceConfigurationNames(
            WBEMClient cimClient, boolean deep, String associationClass, String resultClass,
            String role, String resultRole) throws WbemsmtException {

        if (cimClient == null) {
            throw new WbemsmtException(WbemsmtException.ERR_INVALID_PARAMETER,
                    "The cimClient parameter does not contain a valid reference.");
        }

        java.util.List result = new java.util.ArrayList();
        CloseableIterator enumeration = null;

        try {
            enumeration = cimClient.associatorNames(this.getCimObjectPath(), associationClass,
                    resultClass, role, resultRole);

        }
        catch (WBEMException e) {
            throw new AssociatorNamesException(e, new AssociatorNamesUserObject(this
                    .getCimObjectPath(),
                    CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                    Linux_DnsServiceConfiguration.CIM_CLASS_NAME, null, null));
        }

        try {
            while (enumeration.hasNext()) {
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);

                Object obj = enumeration.next();
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);
                if (obj instanceof CIMObjectPath) {
                    if (deep
                            || ((CIMObjectPath) obj).getObjectName().equals(
                                    Linux_DnsServiceConfiguration.CIM_CLASS_NAME)) {
                        result.add(obj);
                    }
                }
            }
            Linux_DnsServiceSettingDataHelper.checkException(enumeration);
        }
        finally {
            try {
                if (enumeration != null) {
                    enumeration.close();
                }
            }
            catch (Exception e) {
                throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                        "The socket of the result could not be closed properly.");
            }
        }
        return result;
    }

    /**
     * Get the list with Linux_DnsServiceSettingDataForServiceConfiguration associations
     *
     * @param cimClient the WBEMClient for the communication
     * @param includeQualifiers If true, all Qualifiers for each Object (including Qualifiers on the Object and on any returned Properties) MUST be included in the Objects returned. If false, no Qualifiers are present in each Object returned.
     * @param includeClassOrigin If true, the CLASSORIGIN attribute will be present on all appropriate elements in the Objects returned. If false, no CLASSORIGIN attributes are present in the Objects returned. CLASSORIGIN is attached to an element (properties, methods, references) to indicate the class in which it was first defined.
     * @param role This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects referring to the source Object via a Property with the specified name. If "Antecedent" is specified, then only Associations in which the source Object is the "Antecedent" reference are returned.
     * @param propertyList An array of property names used to filter what is contained in the Objects returned. Each CIMClass or CIMInstance returned only contains elements for the properties of the names specified. Duplicate and invalid property names are ignored and the request is otherwise processed normally. An empty array indicates that no properties should be included in the Objects returned. A null value indicates that all properties should be contained in the Objects returned. NOTE: Properties should not be specified in this parameter unless a non-null value is specified in the resultClass  parameter.
     *
     * @see javax.wbem.client.WBEMClient#references(CIMObjectPath, String, String, boolean, boolean, String[])
     **/

    public java.util.List getAssociations_Linux_DnsServiceSettingDataForServiceConfiguration(
            WBEMClient cimClient, boolean includeQualifiers, boolean includeClassOrigin,
            String role, java.lang.String[] propertyList) throws WbemsmtException {

        if (cimClient == null) {
            throw new WbemsmtException(WbemsmtException.ERR_INVALID_PARAMETER,
                    "The cimClient parameter does not contain a valid reference.");
        }

        java.util.List result = new java.util.ArrayList();
        CloseableIterator enumeration = null;

        try {
            enumeration = cimClient.references(this.getCimObjectPath(),
                    CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                    role, includeQualifiers, includeClassOrigin, propertyList);
        }
        catch (WBEMException e) {
            throw new ReferencesException(e, new ReferencesUserObject(this.getCimObjectPath(),
                    CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                    role, includeQualifiers, includeClassOrigin, propertyList));
        }

        try {
            while (enumeration.hasNext()) {
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);
                Object obj = enumeration.next();
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);

                if (obj instanceof CIMInstance) {
                    CIMInstance cimInstance = (CIMInstance) obj;
                    Class clazz = Linux_DnsServiceSettingDataForServiceConfigurationHelper
                            .findClass(cimClient, cimInstance);

                    if (clazz == null) {
                        System.err.println("The class " + cimInstance.getClassName()
                                + " was not found. Constructing instance of the base class.");
                        result.add(new Linux_DnsServiceSettingDataForServiceConfiguration(
                                cimInstance));
                        continue;
                    }

                    Class[] constParams = new Class[1];
                    constParams[0] = CIMInstance.class;
                    Constructor cons = null;
                    try {
                        cons = clazz.getConstructor(constParams);
                    }
                    catch (NoSuchMethodException e) {
                        System.err.println("The required constructor of class "
                                + cimInstance.getClassName()
                                + " could not be found. Constructing instance of the base class.");
                        result.add(new Linux_DnsServiceSettingDataForServiceConfiguration(
                                cimInstance));
                        continue;
                    }

                    try {
                        Object[] actargs = new Object[] { cimInstance };
                        Object dataObj = cons.newInstance(actargs);
                        result.add(dataObj);
                    }
                    catch (Exception e) {
                        System.err
                                .println("The instance of class "
                                        + cimInstance.getClassName()
                                        + " could not be created successful. Constructing instance of the base class.");
                        result.add(new Linux_DnsServiceSettingDataForServiceConfiguration(
                                cimInstance));
                        continue;
                    }
                }
            }
            Linux_DnsServiceSettingDataHelper.checkException(enumeration);
        }
        finally {
            try {
                if (enumeration != null) {
                    enumeration.close();
                }
            }
            catch (Exception e) {
                throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                        "The socket of the result could not be closed properly.");
            }
        }

        return result;
    }

    /**
     * Get a list of CIMObjectPath items of the associations Linux_DnsServiceSettingDataForServiceConfiguration
     *
     * @param cimClient the WBEMClient for the communication
     * @param role This string MUST either contain a valid Property name or be null. It filters the Objects returned to contain only Objects referring to the source Object via a Property with the specified name. If "Antecedent" is specified, then only Associations in which the source Object is the "Antecedent" reference are returned.
     * @param deep if true the subclasses returned also
     *
     * @see javax.wbem.client.WBEMClient#referenceNames(CIMObjectPath, String, String)
     **/

    public java.util.List getAssociationNames_Linux_DnsServiceSettingDataForServiceConfiguration(
            WBEMClient cimClient, String role, boolean deep) throws WbemsmtException {

        if (cimClient == null) {
            throw new WbemsmtException(WbemsmtException.ERR_INVALID_PARAMETER,
                    "The cimClient parameter does not contain a valid reference.");
        }

        java.util.List result = new java.util.ArrayList();
        CloseableIterator enumeration = null;

        try {
            enumeration = cimClient.referenceNames(this.getCimObjectPath(),
                    CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                    role);
        }
        catch (WBEMException e) {
            throw new ReferenceNamesException(e, new ReferenceNamesUserObject(this
                    .getCimObjectPath(),
                    CIM_ASSOCIATOR_CLASS_NAME_LINUX_DNSSERVICESETTINGDATAFORSERVICECONFIGURATION,
                    role));
        }

        try {
            while (enumeration.hasNext()) {
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);
                Object obj = enumeration.next();
                Linux_DnsServiceSettingDataHelper.checkException(enumeration);

                if (obj instanceof CIMObjectPath) {
                    if (deep
                            || ((CIMObjectPath) obj)
                                    .getObjectName()
                                    .equals(
                                            Linux_DnsServiceSettingDataForServiceConfiguration.CIM_CLASS_NAME)) {
                        result.add(obj);
                    }
                }
            }
            Linux_DnsServiceSettingDataHelper.checkException(enumeration);
        }
        finally {
            try {
                if (enumeration != null) {
                    enumeration.close();
                }
            }
            catch (Exception e) {
                throw new WbemsmtException(WbemsmtException.ERR_FAILED,
                        "The socket of the result could not be closed properly.");
            }
        }
        return result;
    }

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
        return Linux_DnsServiceSettingData.CIM_CLASS_NAME;
    }

}