/** 
 * EditDnsReverseZone.java
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
 * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/cmd/editCommand.vm
 *
 * Contributors: 
 *   michael.bauschert@de.ibm.com
 * 
 * Description: Class for editing objects
 * 
 * generated Class
 */

package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.*;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.messages.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.cli.*;

public class EditDnsReverseZone extends CimCommand {

    //All Options that are local and defined for this command
    /**
     *  --zoneFile
     */
    public static final OptionDefinition KEY_zoneFile = new OptionDefinition(null, "zoneFile",
            null, "DnsReverseZoneDataContainer.ZoneFile.argValue", false, false,
            "DnsReverseZoneDataContainer.ZoneFile.argDescription");
    /**
     *  --useGlobalForwarders
     */
    public static final OptionDefinition KEY_useGlobalForwarders = new OptionDefinition(null,
            "useGlobalForwarders", null, null, false, false,
            "DnsReverseZoneDataContainer.useGlobalForwarders.argDescription");
    /**
     * used for selection:  --zoneName
     */
    public static final OptionDefinition KEY_zoneName = new OptionDefinition(null, "zoneName",
            null, "DnsZoneDataContainer.Name.argValue", false, false,
            "DnsZoneDataContainer.Name.argDescription");
    /**
     *  --forward
     */
    public static final OptionDefinition KEY_forward = new OptionDefinition(null, "forward", null,
            "DnsForwarderDataContainer.Forward.argValue", false, false,
            "DnsForwarderDataContainer.Forward.argDescription");
    /**
     *  --forwarders
     */
    public static final OptionDefinition KEY_forwarders = new OptionDefinition(null, "forwarders",
            null, "DnsForwarderDataContainer.Forwarders.argValue", false, false,
            "DnsForwarderDataContainer.Forwarders.argDescription");
    /**
     *  --removeForwarder
     */
    public static final OptionDefinition KEY_removeForwarder = new OptionDefinition(null,
            "removeForwarder", null, null, false, false,
            "DnsForwarderDataContainer.removeForwarder.argDescription");
    /**
     *  --newForwarder
     */
    public static final OptionDefinition KEY_newForwarder = new OptionDefinition(null,
            "newForwarder", null, "DnsForwarderDataContainer.newForwarder.argValue", false, false,
            "DnsForwarderDataContainer.newForwarder.argDescription");
    /**
     *  --addForwarder
     */
    public static final OptionDefinition KEY_addForwarder = new OptionDefinition(null,
            "addForwarder", null, null, false, false,
            "DnsForwarderDataContainer.addForwarder.argDescription");
    /**
     *  --newForwarderType
     */
    public static final OptionDefinition KEY_newForwarderType = new OptionDefinition(null,
            "newForwarderType", null, "DnsForwarderDataContainer.newForwarderType.argValue", false,
            false, "DnsForwarderDataContainer.newForwarderType.argDescription");
    /**
     *  --ttl
     */
    public static final OptionDefinition KEY_ttl = new OptionDefinition(null, "ttl", null,
            "DnsTTLDataContainer.TTL.argValue", false, false,
            "DnsTTLDataContainer.TTL.argDescription");
    /**
     *  --ttlUnit
     */
    public static final OptionDefinition KEY_ttlUnit = new OptionDefinition(null, "ttlUnit", null,
            "DnsTTLDataContainer.TTLUnit.argValue", false, false,
            "DnsTTLDataContainer.TTLUnit.argDescription");
    /**
     *  --removeTTL
     */
    public static final OptionDefinition KEY_removeTTL = new OptionDefinition(null, "removeTTL",
            null, null, false, false, "DnsTTLDataContainer.removeTTL.argDescription");

    //All Options that are global and task-related
    /**
     * required, used for selection:  --dnsServiceName
     */
    public static final OptionDefinition KEY_GLOBAL_dnsServiceName = new OptionDefinition(null,
            "dnsServiceName", null, "dnsServiceName.argValue", true, false,
            "dnsServiceName.argDescription");

    // Global Communication Options
    /**
     *  --hostname
     */
    public static final OptionDefinition KEY_GLOBAL_hostname = new OptionDefinition(null,
            "hostname", null, "hostname.argValue", false, false, "hostname.argDescription");
    /**
     *  --port, default: 5988
     */
    public static final OptionDefinition KEY_GLOBAL_port = new OptionDefinition(null, "port",
            "5988", "port.argValue", false, false, "port.argDescription");
    /**
     *  --namespace, default: /root/cimv2
     */
    public static final OptionDefinition KEY_GLOBAL_namespace = new OptionDefinition(null,
            "namespace", "/root/cimv2", "namespace.argValue", false, false,
            "namespace.argDescription");
    /**
     *  --user
     */
    public static final OptionDefinition KEY_GLOBAL_user = new OptionDefinition(null, "user", null,
            "user.argValue", false, false, "user.argDescription");
    /**
     *  --password
     */
    public static final OptionDefinition KEY_GLOBAL_password = new OptionDefinition(null,
            "password", null, "password.argValue", false, false, "password.argDescription");
    /**
     *  --publickeyfile
     */
    public static final OptionDefinition KEY_GLOBAL_publickeyfile = new OptionDefinition(null,
            "publickeyfile", null, "publickeyfile.argValue", false, false,
            "publickeyfile.argDescription");
    /**
     *  --privatekeyfile
     */
    public static final OptionDefinition KEY_GLOBAL_privatekeyfile = new OptionDefinition(null,
            "privatekeyfile", null, "privatekeyfile.argValue", false, false,
            "privatekeyfile.argDescription");
    /**
     * used for selection:  --httpProtocolType, default: http
     */
    public static final OptionDefinition KEY_GLOBAL_httpProtocolType = new OptionDefinition(null,
            "httpProtocolType", "http", "httpProtocolType.argValue", false, false,
            "httpProtocolType.argDescription");

    // Global Common Options
    /**
     *  -L --locale, default: en
     */
    public static final OptionDefinition KEY_GLOBAL_locale = new OptionDefinition("L", "locale",
            "en", "locale.argValue", false, false, "locale.argDescription");
    /**
     *  -?
     */
    public static final OptionDefinition KEY_GLOBAL_QUESTION_MARK_ = new OptionDefinition("?",
            null, null, null, false, false, "?.argDescription");
    /**
     *  -h --help
     */
    public static final OptionDefinition KEY_GLOBAL_help = new OptionDefinition("h", "help", null,
            null, false, false, "help.argDescription");

    private static final OptionDefinition[] LOCAL_OPTIONS = new OptionDefinition[] { KEY_zoneFile,
            KEY_useGlobalForwarders, KEY_zoneName, KEY_forward, KEY_forwarders,
            KEY_removeForwarder, KEY_newForwarder, KEY_addForwarder, KEY_newForwarderType, KEY_ttl,
            KEY_ttlUnit, KEY_removeTTL, };

    private static final OptionDefinition[] GLOBAL_TASK_OPTIONS = new OptionDefinition[] { KEY_GLOBAL_dnsServiceName, };

    private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS = new OptionDefinition[] {
            KEY_GLOBAL_hostname, KEY_GLOBAL_port, KEY_GLOBAL_namespace, KEY_GLOBAL_user,
            KEY_GLOBAL_password, KEY_GLOBAL_publickeyfile, KEY_GLOBAL_privatekeyfile,
            KEY_GLOBAL_httpProtocolType, };

    private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMON_OPTIONS = new OptionDefinition[] {
            KEY_GLOBAL_locale, KEY_GLOBAL_QUESTION_MARK_, KEY_GLOBAL_help, };

    CommandLine cmd = null;
    AbstractBaseCimAdapter adapter = null;

    public EditDnsReverseZone(java.util.Locale locale) {
        super("EditDnsReverseZone", new String[] { "messages", "messagesDns" }, locale);
    }

    public void execute(CimCommandValues values) throws WbemsmtException {

        //do the real processing
        try {

            commandValues = values;
            cmd = values.getCommandLine();

            Options options = values.getOptions();

            //first handle the help options and then the parseException
            //if the user wants help parsing the args will fail (due to missing required args)
            //and so the helpOptions should be handled first

            if (hasOption(values.getArgs(), "-" + KEY_GLOBAL_QUESTION_MARK_.getShortKey())
                    || hasOption(values.getArgs(), "-" + KEY_GLOBAL_help.getShortKey())) {
                showUsage(values.getOut(), options);
                return;
            }
            else if (hasOption(values.getArgs(), "--" + KEY_GLOBAL_help.getLongKey())) {
                //TODO add extendedHelp by loading a manpage or sth else
                showUsage(values.getOut(), options);
                return;
            }

            else if (values.getParseException() != null) {
                handleParseException(values, KEY_GLOBAL_password);
                return;
            }
            adapter = (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) CimAdapterFactory
                    .getInstance().getAdapter(org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter.class,
                            this);
            adapter.setBundle(bundle);
            adapter.setCimClient(values.getCimClient());

            adapter.loadInitial(adapter.getCimClient());

            values.getOut().println(
                    "\n"
                            + bundle.getString("editing", new Object[] { bundle
                                    .getString("DnsReverseZoneDataContainer.caption") }));

            CliDataLoader loader = new EditDnsReverseZoneLoader();
            loader.load(bundle, adapter, commandValues);

            org.sblim.wbemsmt.cli.dns.container.edit.DnsReverseZoneDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsReverseZoneDataContainerImpl(
                    adapter);

            setKeyValues(cmd, adapter, dc);

            adapter.updateControls(dc);
            adapter.setActiveModule(AbstractBaseCimAdapter.ACTIVE_EDIT);

            values.getOut().println("\n" + bundle.getString("before.edit"));
            dc.trace(values.getOut());

            setValues(cmd, adapter, dc);

            MessageList result = MessageList.init(dc);

            if (result.hasErrors()) {
                Message caption = Message.create(ErrCodes.MSG_SAVE_ERROR, Message.ERROR, bundle,
                        "save.error");
                traceMessages(caption, result);
                return;
            }
            else {
                Message caption = Message.create(ErrCodes.MSG_ADDITIONAL_MESSAGES, Message.ERROR,
                        bundle, "additional.messages");
                traceMessages(caption, result);
                result.clear();
            }

            adapter.validateValues(dc);
            result = dc.getMessagesList();
            if (!result.hasErrors()) {
                adapter.save(dc);
                //Get the infos afte storing the values
                result = dc.getMessagesList();
                if (result.hasErrors()) {
                    Message caption = Message.create(ErrCodes.MSG_SAVE_ERROR, Message.ERROR,
                            bundle, "save.error");
                    traceMessages(caption, result);
                }
                else if (result.hasWarning()) {
                    Message caption = Message.create(ErrCodes.MSG_SAVE_WARNING, Message.WARNING,
                            bundle, "save.warning");
                    traceMessages(caption, result);
                }
                else if (result.hasInfo()) {
                    Message caption = Message.create(ErrCodes.MSG_SAVE_INFO, Message.INFO, bundle,
                            "save.info");
                    traceMessages(caption, result);
                }
            }
            else {
                Message caption = Message.create(ErrCodes.MSG_VALIDATION_ERROR, Message.ERROR,
                        bundle, "validation.error");
                traceMessages(caption, result);
                return;
            }
            values.getOut().println(
                    "\n"
                            + bundle.getString("edited", new Object[] { bundle
                                    .getString("DnsReverseZoneDataContainer.caption") }));

            adapter.updateControls(dc);

            values.getOut().println("\n" + bundle.getString("after.edit"));
            dc.trace(values.getOut());

        }
        catch (Exception e) {
            super.handleException(e, values.getArgs(), values.getOptions(), KEY_GLOBAL_password);
        }
        finally {
            if (adapter != null)
                adapter.cleanup();
        }
    }

    /**
     * Set all Values that are needed for selecting the right objects. This fields are used even if they are read-only
     **/
    private void setKeyValues(CommandLine cmd, AbstractBaseCimAdapter adapter,
            org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer dc)
            throws WbemsmtException {
        setValue(cmd, dc.get_Name(), KEY_zoneName);
    }

    /**
     * Set all Values that are not read-Only
     **/
    private void setValues(CommandLine cmd, AbstractBaseCimAdapter adapter,
            org.sblim.wbemsmt.dns.bl.container.edit.DnsReverseZoneDataContainer dc)
            throws WbemsmtException {
        setValue(cmd, dc.get_ZoneFile(), KEY_zoneFile);
        setValue(cmd, dc.get_Name(), KEY_zoneName);
        setMultiValue(adapter.getBundle(), cmd, dc.get_Forward(), KEY_forward);
        setMultiValue(adapter.getBundle(), cmd, dc.get_Forwarders(), KEY_forwarders);
        setValue(cmd, dc.get_usr_NewForwarder(), KEY_newForwarder);
        setMultiValue(adapter.getBundle(), cmd, dc.get_usr_NewForwarderType(), KEY_newForwarderType);
        setValue(cmd, dc.get_TTL(), KEY_ttl);
        setMultiValue(adapter.getBundle(), cmd, dc.get_usr_TTLUnit(), KEY_ttlUnit);

        //The Buttons
        if (!pressButton(cmd, adapter, dc, dc.get_usr_UseGlobalForwarders(),
                KEY_useGlobalForwarders))
            return;
        if (!pressButton(cmd, adapter, dc, dc.get_usr_RemoveForwarder(), KEY_removeForwarder))
            return;
        if (!pressButton(cmd, adapter, dc, dc.get_usr_AddForwarder(), KEY_addForwarder))
            return;
        if (!pressButton(cmd, adapter, dc, dc.get_usr_RemoveTTL(), KEY_removeTTL))
            return;
    }

    protected LoginOptionValues getLoginOptions() {
        return new LoginOptionValues(KEY_GLOBAL_hostname, KEY_GLOBAL_user, KEY_GLOBAL_password);
    }

    protected CimClientOptionValues getCimClientOptions() {

        return new CimClientOptionValues(KEY_GLOBAL_httpProtocolType, KEY_GLOBAL_hostname,
                KEY_GLOBAL_port, KEY_GLOBAL_namespace, KEY_GLOBAL_user, KEY_GLOBAL_password,
                KEY_GLOBAL_publickeyfile, KEY_GLOBAL_privatekeyfile);
    }

    public Options getOptions() throws WbemsmtException {
        Options options = super.createOptions(LOCAL_OPTIONS, bundle);
        super.createOptions(options, GLOBAL_TASK_OPTIONS, bundle);
        super.createOptions(options, GLOBAL_WBEMSMT_COMMON_OPTIONS, bundle);
        super.createOptions(options, GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS, bundle);
        return options;
    }

    public Options getLocalOptions() throws WbemsmtException {
        Options options = super.createOptions(LOCAL_OPTIONS, bundle);
        return options;
    }

    public Options getGlobalWbemsmtCommonOptions() throws WbemsmtException {
        Options options = super.createOptions(GLOBAL_WBEMSMT_COMMON_OPTIONS, bundle);
        return options;
    }

    public Options getGlobalWbemsmtCommunicationOptions() throws WbemsmtException {
        Options options = super.createOptions(GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS, bundle);
        return options;
    }

    public Options getGlobalTaskOptions() throws WbemsmtException {
        Options options = super.createOptions(GLOBAL_TASK_OPTIONS, bundle);
        return options;
    }

}