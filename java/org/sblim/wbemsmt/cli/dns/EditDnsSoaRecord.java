/** 
 * EditDnsSoaRecord.java
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
import org.sblim.wbemsmt.bl.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.cli.*;

public class EditDnsSoaRecord extends CimCommand {

    //All Options that are local and defined for this command
    /**
     * required, used for selection:  --zoneName
     */
    public static final OptionDefinition KEY_zoneName = new OptionDefinition(null, "zoneName",
            null, "EditDnsSoaRecord.zoneName.argValue", true, false,
            "EditDnsSoaRecord.zoneName.argDescription");
    /**
     *  --server
     */
    public static final OptionDefinition KEY_server = new OptionDefinition(null, "server", null,
            "DnsSoaContainer.Server.argValue", false, false,
            "DnsSoaContainer.Server.argDescription");
    /**
     *  --contact
     */
    public static final OptionDefinition KEY_contact = new OptionDefinition(null, "contact", null,
            "DnsSoaContainer.Contact.argValue", false, false,
            "DnsSoaContainer.Contact.argDescription");
    /**
     *  --serialNumber
     */
    public static final OptionDefinition KEY_serialNumber = new OptionDefinition(null,
            "serialNumber", null, "DnsSoaContainer.SerialNumber.argValue", false, false,
            "DnsSoaContainer.SerialNumber.argDescription");
    /**
     *  --refresh
     */
    public static final OptionDefinition KEY_refresh = new OptionDefinition(null, "refresh", null,
            "DnsSoaContainer.Refresh.argValue", false, false,
            "DnsSoaContainer.Refresh.argDescription");
    /**
     *  --retry
     */
    public static final OptionDefinition KEY_retry = new OptionDefinition(null, "retry", null,
            "DnsSoaContainer.Retry.argValue", false, false, "DnsSoaContainer.Retry.argDescription");
    /**
     *  --expire
     */
    public static final OptionDefinition KEY_expire = new OptionDefinition(null, "expire", null,
            "DnsSoaContainer.Expire.argValue", false, false,
            "DnsSoaContainer.Expire.argDescription");
    /**
     *  --negativeCachingTTL
     */
    public static final OptionDefinition KEY_negativeCachingTTL = new OptionDefinition(null,
            "negativeCachingTTL", null, "DnsSoaContainer.NegativeCachingTTL.argValue", false,
            false, "DnsSoaContainer.NegativeCachingTTL.argDescription");
    /**
     *  --ttlUnit
     */
    public static final OptionDefinition KEY_ttlUnit = new OptionDefinition(null, "ttlUnit", null,
            "DnsSoaContainer.TTLUnit.argValue", false, false,
            "DnsSoaContainer.TTLUnit.argDescription");
    /**
     *  --setSerialNumber
     */
    public static final OptionDefinition KEY_setSerialNumber = new OptionDefinition(null,
            "setSerialNumber", null, null, false, false,
            "DnsSoaContainer.setSerialNumber.argDescription");

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

    private static final OptionDefinition[] LOCAL_OPTIONS = new OptionDefinition[] { KEY_zoneName,
            KEY_server, KEY_contact, KEY_serialNumber, KEY_refresh, KEY_retry, KEY_expire,
            KEY_negativeCachingTTL, KEY_ttlUnit, KEY_setSerialNumber, };

    private static final OptionDefinition[] GLOBAL_TASK_OPTIONS = new OptionDefinition[] { KEY_GLOBAL_dnsServiceName, };

    private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS = new OptionDefinition[] {
            KEY_GLOBAL_hostname, KEY_GLOBAL_port, KEY_GLOBAL_namespace, KEY_GLOBAL_user,
            KEY_GLOBAL_password, KEY_GLOBAL_publickeyfile, KEY_GLOBAL_privatekeyfile,
            KEY_GLOBAL_httpProtocolType, };

    private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMON_OPTIONS = new OptionDefinition[] {
            KEY_GLOBAL_locale, KEY_GLOBAL_QUESTION_MARK_, KEY_GLOBAL_help, };

    CommandLine cmd = null;
    AbstractBaseCimAdapter adapter = null;

    public EditDnsSoaRecord(java.util.Locale locale) {
        super("EditDnsSoaRecord", new String[] { "messages", "messagesDns" }, locale);
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
                                    .getString("DnsSoaContainer.caption") }));

            CliDataLoader loader = new EditDnsSoaRecordLoader();
            loader.load(bundle, adapter, commandValues);

            org.sblim.wbemsmt.cli.dns.container.edit.DnsSoaContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsSoaContainerImpl(
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
                                    .getString("DnsSoaContainer.caption") }));

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
            org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer dc) throws WbemsmtException {
    }

    /**
     * Set all Values that are not read-Only
     **/
    private void setValues(CommandLine cmd, AbstractBaseCimAdapter adapter,
            org.sblim.wbemsmt.dns.bl.container.edit.DnsSoaContainer dc) throws WbemsmtException {
        setValue(cmd, dc.get_Server(), KEY_server);
        setValue(cmd, dc.get_Contact(), KEY_contact);
        setValue(cmd, dc.get_SerialNumber(), KEY_serialNumber);
        setValue(cmd, dc.get_Refresh(), KEY_refresh);
        setValue(cmd, dc.get_Retry(), KEY_retry);
        setValue(cmd, dc.get_Expire(), KEY_expire);
        setValue(cmd, dc.get_NegativeCachingTTL(), KEY_negativeCachingTTL);
        setMultiValue(adapter.getBundle(), cmd, dc.get_usr_TTLUnit(), KEY_ttlUnit);

        //The Buttons
        if (!pressButton(cmd, adapter, dc, dc.get_usr_SetSerialNumber(), KEY_setSerialNumber))
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