/**
 * CreateDnsAddressMatchList.java Â© Copyright IBM Corp.  2009,2006,2007 THIS FILE IS PROVIDED UNDER THE
 * TER MS OF THE ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS
 * FILE CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT. You can obtain a current copy of the
 * Eclipse Public License from http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * @author: org.sblim.wbemsmt.dcg.generator.cmd.CMDPresentationLayerGenerator
 * @template: org/sblim/wbemsmt/dcg/templates/cmd/createCommand.vm Contributors: Prashanth
 *            Karnam<prkarnam@in.ibm.com> Description: Class for creating objects generated Class
 */

package org.sblim.wbemsmt.cli.dns;

import org.apache.commons.cli.*;
import org.apache.commons.lang.ClassUtils;
import org.sblim.wbemsmt.bl.adapter.*;
import org.sblim.wbemsmt.bl.messages.*;
import org.sblim.wbemsmt.exception.*;
import org.sblim.wbemsmt.tools.cli.*;
import org.sblim.wbemsmt.tools.wizard.cli.*;

public class CreateDnsAddressMatchList extends CimCommand implements ContainerUpdater {

    //All Options that are local and defined for this command
    /**
     * required,  --matchListName
     */
    public static final OptionDefinition KEY_matchListName = new OptionDefinition(null,
            "matchListName", null, "DnsAddressMatchListWizardPage1DataContainer.Name.argValue",
            true, false, "DnsAddressMatchListWizardPage1DataContainer.Name.argDescription");
    /**
     *  --addressList
     */
    public static final OptionDefinition KEY_addressList = new OptionDefinition(null,
            "addressList", null, "DnsAddressMatchListDataContainer.AddressList.argValue", false,
            false, "DnsAddressMatchListDataContainer.AddressList.argDescription");
    /**
     *  --removeAddress
     */
    public static final OptionDefinition KEY_removeAddress = new OptionDefinition(null,
            "removeAddress", null, null, false, false,
            "DnsAddressMatchListDataContainer.removeAddress.argDescription");
    /**
     *  --userAddresses
     */
    public static final OptionDefinition KEY_userAddresses = new OptionDefinition(null,
            "userAddresses", null, "DnsAddressMatchListDataContainer.userAddresses.argValue",
            false, false, "DnsAddressMatchListDataContainer.userAddresses.argDescription");
    /**
     *  --newAddress
     */
    public static final OptionDefinition KEY_newAddress = new OptionDefinition(null, "newAddress",
            null, "DnsAddressMatchListDataContainer.newAddress.argValue", false, false,
            "DnsAddressMatchListDataContainer.newAddress.argDescription");
    /**
     *  --addPredefinedAddress
     */
    public static final OptionDefinition KEY_addPredefinedAddress = new OptionDefinition(null,
            "addPredefinedAddress", null, null, false, false,
            "DnsAddressMatchListDataContainer.addPredefinedAddress.argDescription");
    /**
     *  --addNewAddress
     */
    public static final OptionDefinition KEY_addNewAddress = new OptionDefinition(null,
            "addNewAddress", null, null, false, false,
            "DnsAddressMatchListDataContainer.addNewAddress.argDescription");
    /**
     *  --addressUp
     */
    public static final OptionDefinition KEY_addressUp = new OptionDefinition(null, "addressUp",
            null, null, false, false, "DnsAddressMatchListDataContainer.addressUp.argDescription");
    /**
     *  --addressDown
     */
    public static final OptionDefinition KEY_addressDown = new OptionDefinition(null,
            "addressDown", null, null, false, false,
            "DnsAddressMatchListDataContainer.addressDown.argDescription");

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

    private static final OptionDefinition[] LOCAL_OPTIONS = new OptionDefinition[] {
            KEY_matchListName, KEY_addressList, KEY_removeAddress, KEY_userAddresses,
            KEY_newAddress, KEY_addPredefinedAddress, KEY_addNewAddress, KEY_addressUp,
            KEY_addressDown, };

    private static final OptionDefinition[] GLOBAL_TASK_OPTIONS = new OptionDefinition[] { KEY_GLOBAL_dnsServiceName, };

    private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMUNICATION_OPTIONS = new OptionDefinition[] {
            KEY_GLOBAL_hostname, KEY_GLOBAL_port, KEY_GLOBAL_namespace, KEY_GLOBAL_user,
            KEY_GLOBAL_password, KEY_GLOBAL_publickeyfile, KEY_GLOBAL_privatekeyfile,
            KEY_GLOBAL_httpProtocolType, };

    private static final OptionDefinition[] GLOBAL_WBEMSMT_COMMON_OPTIONS = new OptionDefinition[] {
            KEY_GLOBAL_locale, KEY_GLOBAL_QUESTION_MARK_, KEY_GLOBAL_help, };

    CommandLine cmd = null;
    AbstractBaseCimAdapter adapter = null;

    public CreateDnsAddressMatchList(java.util.Locale locale) {
        super("CreateDnsAddressMatchList", new String[] { "messages", "messagesDns" }, locale);
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

            values.getOut().println("\n" + bundle.getString("AddressMatchListWizard.create.start"));

            CliDataLoader loader = new CreateDnsAddressMatchListLoader();
            loader.load(bundle, adapter, commandValues);

            org.sblim.wbemsmt.cli.dns.wizard.AddressMatchListWizard wizard = new org.sblim.wbemsmt.cli.dns.wizard.AddressMatchListWizard(
                    (org.sblim.wbemsmt.dns.bl.adapter.DnsCimAdapter) adapter);
            if (!wizard.canBeExecuted()) {
                traceErrors("error.while.execution", wizard.getMessageList());
                return;
            }
            wizard.startWizard();

            while (!wizard.getContainer().isLast(wizard.getContainer().getCurrentPageName())) {
                BaseDataContainer dataContainer = wizard.getCurrentPanel();
                if (true == false)
                    ;
                else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
                    setCommandLineValues(
                            cmd,
                            adapter,
                            (org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer) dataContainer);
                else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
                    setCommandLineValues(
                            cmd,
                            adapter,
                            (org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer) dataContainer);
                else {
                    logger.severe(dataContainer.getClass().getName()
                            + " cannot be handled from command class " + this.getClass().getName());
                    throw new WbemsmtException(WbemsmtException.ERR_INVALID_PARAMETER, bundle
                            .getString("internal.error"));
                }

                MessageList result = MessageList.init(dataContainer);
                if (result.hasErrors()) {
                    traceErrors(result);
                    return;
                }
                else {
                    Message caption = Message.create(ErrCodes.MSG_ADDITIONAL_MESSAGES,
                            Message.ERROR, bundle, "additional.messages");
                    traceMessages(caption, result);
                    result.clear();
                }

                wizard.next(this);
                result = wizard.getCurrentPanel().getMessagesList();

                if (result != null) {
                    if (result.hasErrors()) {
                        Message caption = Message.create(ErrCodes.MSG_VALIDATION_ERROR,
                                Message.ERROR, bundle, "validation.error");
                        traceMessages(caption, result);
                        return;
                    }
                    else {
                        Message caption = Message.create(ErrCodes.MSG_ADDITIONAL_MESSAGES,
                                Message.ERROR, bundle, "additional.messages");
                        traceMessages(caption, result);
                        dataContainer.getMessagesList().clear();
                    }
                }
            }

            BaseDataContainer lastPanel = wizard.getCurrentPanel();

            MessageList result = wizard.finish();
            String wizardName = ClassUtils.getShortClassName(wizard.getClass());
            if (result != null && result.hasErrors()) {
                result.addMessage(new Message(ErrCodes.MSG_CREATE_FAILED, Message.ERROR, bundle
                        .getString(wizardName + ".create.failed")));
            }
            else {
                result.addMessage(new Message(ErrCodes.MSG_CREATE_SUCCESS, Message.SUCCESS, bundle
                        .getString(wizardName + ".create.success")));
            }
            traceErrors(result);

            if (true == false)
                ;
            else if (lastPanel instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
                ((CreateDnsAddressMatchListLoader) loader)
                        .loadTracingObject(
                                bundle,
                                adapter,
                                (org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer) lastPanel);
            else {
                logger.severe("Cannot loadTracingObject for " + lastPanel.getClass().getName());
                throw new WbemsmtException(WbemsmtException.ERR_INVALID_PARAMETER, bundle
                        .getString("internal.error"));
            }

            org.sblim.wbemsmt.cli.dns.container.edit.DnsAddressMatchListDataContainerImpl dc = new org.sblim.wbemsmt.cli.dns.container.edit.DnsAddressMatchListDataContainerImpl(
                    adapter);

            adapter.updateControls(dc);
            values.getOut().println("\n" + bundle.getString("createdObject") + ":\n");
            dc.trace(values.getOut());

            //values.getOut().println("\n" + bundle.getString("AddressMatchListWizard.create.success"));

        }
        catch (Exception e) {
            super.handleException(e, values.getArgs(), values.getOptions(), KEY_GLOBAL_password);
        }
        finally {
            if (adapter != null)
                adapter.cleanup();
        }
    }

    public void prepareForUpdateControls(DataContainer dataContainer) throws WbemsmtException {
        if (true == false)
            ;
        else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer)
            updateContainerChilds(
                    cmd,
                    adapter,
                    (org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer) dataContainer);
        else if (dataContainer instanceof org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer)
            updateContainerChilds(
                    cmd,
                    adapter,
                    (org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer) dataContainer);
        else {

            logger.severe("Cannot setValues for Container " + dataContainer.getClass().getName());
            throw new WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS,
                    "Cannot setValues for Container " + dataContainer.getClass().getName());
        }
    }

    private void updateContainerChilds(CommandLine cmd, AbstractBaseCimAdapter adapter,
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer dc)
            throws WbemsmtException {

        try {
            //update the child-containers

        }
        catch (Exception e) {
            throw new WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS, bundle
                    .getString("internal.error"), e);
        }

    }

    private void setCommandLineValues(CommandLine cmd, AbstractBaseCimAdapter adapter,
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardPage1DataContainer dc)
            throws WbemsmtException {
        //set the values
        setValue(cmd, dc.get_Name(), KEY_matchListName);
        setMultiValue(adapter.getBundle(), cmd, dc.get_AddressList(), KEY_addressList);
        setMultiValue(adapter.getBundle(), cmd, dc.get_usr_UserAddresses(), KEY_userAddresses);
        setValue(cmd, dc.get_usr_NewAddress(), KEY_newAddress);

        //The Buttons
        if (!pressButton(cmd, adapter, dc, dc.get_usr_RemoveAddress(), KEY_removeAddress))
            return;
        if (!pressButton(cmd, adapter, dc, dc.get_usr_AddPredefinedAddress(),
                KEY_addPredefinedAddress))
            return;
        if (!pressButton(cmd, adapter, dc, dc.get_usr_AddNewAddress(), KEY_addNewAddress))
            return;
        if (!pressButton(cmd, adapter, dc, dc.get_usr_AddressUp(), KEY_addressUp))
            return;
        if (!pressButton(cmd, adapter, dc, dc.get_usr_AddressDown(), KEY_addressDown))
            return;

    }

    private void updateContainerChilds(
            CommandLine cmd,
            AbstractBaseCimAdapter adapter,
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer dc)
            throws WbemsmtException {

        try {
            //update the child-containers

        }
        catch (Exception e) {
            throw new WbemsmtException(WbemsmtException.ERR_UPDATE_CONTROLS, bundle
                    .getString("internal.error"), e);
        }

    }

    private void setCommandLineValues(
            CommandLine cmd,
            AbstractBaseCimAdapter adapter,
            org.sblim.wbemsmt.dns.bl.container.wizard.DnsAddressMatchListWizardSummaryDataContainer dc)
            throws WbemsmtException {
        //set the values

        //The Buttons

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