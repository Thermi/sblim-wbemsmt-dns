%define name                    sblim-wbemsmt-dns
%define version                 0.5.0
%define build_release           1
%define release                 %{build_release}jpp
%define section                 free


###############################################################################

Name:           %{name}
Version:        %{version}
Release:        %{release}
License:        Common Public License
Url:            http://sblim.sourceforge.net/
Group:          Development/Libraries/Java
Vendor:         IBM
Summary:        Provides a wbemmsmt-based task that provides support to configure DNS
SOURCE0:        %{name}-%{version}-src.tar.bz2
BuildRoot:      %{_tmppath}/%{name}-%{version}-%{release}
BuildArch:      noarch

BuildRequires: jpackage-utils >= 0:1.5.32
BuildRequires: ant >= 0:1.6
BuildRequires: sblim-cim-client >= 0:1.3.3
BuildRequires: sblim-wbemsmt-commons => 0.5.0
BuildRequires: jakarta-commons-cli >= 1.0
BuildRequires: jakarta-commons-lang >= 2.0
#BuildRequires:  myfaces >= 1.1.5
#BuildRequires:  tomahawk >= 1.1.3
#BuildRequires:  xbeans >= 2.2.0

###############################################################################

Requires: jpackage-utils >= 0:1.5.32
Requires: sblim-cim-client >= 0:1.3.3
Requires: sblim-wbemsmt-commons => 0.5.0
Requires: sblim-wbemsmt-webapp => 0.5.0
Requires: jakarta-commons-cli >= 1.0
Requires: jakarta-commons-lang >= 2.0
#Requires:  myfaces >= 1.1.5
#Requires:  tomahawk >= 1.1.3

###############################################################################

%description
This module provides the wbemmsmt-based task that provides the support to
configure DNS zones, resource records and address match lists.  It contains
the generated data containers, the generated first class objects and the 
business logic for the DNS app. It also contains the generated cli interface 
for the DNS task.

###############################################################################

%prep
%setup -q -n %{name}

###############################################################################

%build
CLASSPATH=$(build-classpath sblim-cim-client)
CLASSPATH=$(build-classpath commons-cli commons-lang):$CLASSPATH
CLASSPATH=$(build-classpath myfaces-api myfaces-impl tomahawk xbean):$CLASSPATH
CLASSPATH=$(build-classpath sblim-wbemsmt/sblim-wbemsmt-commons sblim-wbemsmt/sblim-wbemsmt-commons-launcher-config):$CLASSPATH
export CLASSPATH

ant build-jar


###############################################################################

%install
rm -rf $RPM_BUILD_ROOT
install -d $RPM_BUILD_ROOT%{_bindir}/
install -d $RPM_BUILD_ROOT%{_sysconfdir}/sblim-wbemsmt/tasklauncher.d
install -d $RPM_BUILD_ROOT%{_javadir}/sblim-wbemsmt
install -d $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}
install -d $RPM_BUILD_ROOT%{_localstatedir}/lib/%{name}/help

# Installation of documentation files
install COPYING   $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/COPYING
install AUTHORS   $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/AUTHORS
install README    $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/README
install ChangeLog $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/ChangeLog
install NEWS      $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/NEWS
install TroubleShooting $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/TroubleShooting
install MultipleHostsSupport $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/MultipleHostsSupport

install target/package/etc/sblim-wbemsmt/tasklauncher.d/dns-task-config.xml $RPM_BUILD_ROOT%{_sysconfdir}/sblim-wbemsmt/tasklauncher.d/
install target/package/cli-scripts/sblim-wbemsmt-dns-cli.sh $RPM_BUILD_ROOT%{_bindir}/sblim-wbemsmt-dns-cli.sh

# Installation of java files
install target/package/%{name}-%{version}.jar $RPM_BUILD_ROOT%{_javadir}/sblim-wbemsmt
(
  cd $RPM_BUILD_ROOT%{_javadir}/sblim-wbemsmt &&
    ln -sf %{name}-%{version}.jar %{name}.jar;
)

# Moving help files to the webapp directory
mv target/package/help/* $RPM_BUILD_ROOT%{_localstatedir}/lib/%{name}/help

###############################################################################

%post
unset JAVA_HOME
[ -z "$JAVA_HOME" ] && [ -r %{_sysconfdir}/java/java.conf ] && \
    . %{_sysconfdir}/java/java.conf
[ -z "$JAVA_HOME" ] && JAVA_HOME=%{_jvmdir}/java

unset WBEMSMT_WEBAPP_HOME
[ -r %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-webapp.conf ] && . %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-webapp.conf
[ -z "$WBEMSMT_WEBAPP_HOME" ] && WBEMSMT_WEBAPP_HOME=%{_localstatedir}/lib/sblim-wbemsmt-webapp/webapps/sblim-wbemsmt-webapp

unset WBEMSMT_HELPDIR
[ -r %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-commons.conf ] && . %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-commons.conf
[ -z "$WBEMSMT_HELPDIR" ] && WBEMSMT_HELPDIR=/var/lib/sblim-wbemsmt/help
ln -sf %{_localstatedir}/lib/%{name}/help/plugins/org.sblim.wbemsmt.help.dns $WBEMSMT_HELPDIR/plugins/org.sblim.wbemsmt.help.dns

build-jar-repository $WBEMSMT_WEBAPP_HOME/WEB-INF/lib sblim-wbemsmt/%{name}


###############################################################################

%preun
unset WBEMSMT_WEBAPP_HOME
[ -r %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-webapp.conf ] && . %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-webapp.conf
[ -z "$WBEMSMT_WEBAPP_HOME" ] && WBEMSMT_WEBAPP_HOME=%{_localstatedir}/lib/sblim-wbemsmt-webapp/webapps/sblim-wbemsmt-webapp
rm -f $WBEMSMT_WEBAPP_HOME/WEB-INF/lib/\[sblim-wbemsmt\]\[%{name}.jar\]*.jar

unset WBEMSMT_HELPDIR
[ -r %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-commons.conf ] && . %{_sysconfdir}/sblim-wbemsmt/sblim-wbemsmt-commons.conf
[ -z "$WBEMSMT_HELPDIR" ] && WBEMSMT_HELPDIR=/var/lib/sblim-wbemsmt/help
unlink $WBEMSMT_HELPDIR/plugins/org.sblim.wbemsmt.help.dns


###############################################################################

%files
%defattr(0644,root,root,0755)
%doc %{_docdir}/%{name}-%{version}/COPYING
%doc %{_docdir}/%{name}-%{version}/AUTHORS
%doc %{_docdir}/%{name}-%{version}/README
%doc %{_docdir}/%{name}-%{version}/ChangeLog
%doc %{_docdir}/%{name}-%{version}/NEWS
%doc %{_docdir}/%{name}-%{version}/TroubleShooting
%doc %{_docdir}/%{name}-%{version}/MultipleHostsSupport
%{_localstatedir}/lib/%{name}/help/*
%{_javadir}/sblim-wbemsmt/%{name}.jar
%{_javadir}/sblim-wbemsmt/%{name}-%{version}.jar
%{_bindir}/sblim-wbemsmt-dns-cli.sh
%attr(444,root,tomcat) %config(noreplace) %{_sysconfdir}/sblim-wbemsmt/tasklauncher.d/dns-task-config.xml

###############################################################################
%changelog
* Fri Jul 6 2007 Wolfgang Taphorn <taphorn@de.ibm.com> 0.5.0-1
  - Inclusion of fixes for the following issues:
    o 1764521  wbemsmt-dns: Correct translation of validator warning/error
    o 1764516  wbemsmt-dns: set Size of resource record fields
    o 1763522  wbemsmt-dns: cleanup addressmatchlistwizard
    o 1763520  wbemsmt-dns: Handling of forward-attribute
    o 1760852  wbemsmt-samba/dns: remove unnecessary installValidator calls
    o 1760804  wbemsmt-jsf: child tables: controls displayed in empty row
    o 1754942  wbemsmt-dns: Upgrade to build environment
    o 1750200  wbemsmt-client: update jar references
    o 1749362  wbemsmt-dns: Upgrade FCOs to latest generator level
    o 1746585  wbemsmt-admin: namespace for application
    o 1737048  wbemsmt-tasks: set Loaded flag if adapter was initialized
    o 1731236  wbemsmt-jsf: childrenTables as HtmlDataTable
    o 1728151  wbemsmt-jsf: scrollable childTables
    o 1727285  wbemsmt-jsf: configurable ajax update interval
    o 1724706  wbemsmt-commons-bl: CIMObjectKey with FCOs
    o 1724637  wbemsmt-common: InstanceNaming based in FCO
    o 1714724  wbemsmt-webapp: rendering of table with childContainers
    o 1720068  wbemsmt-dcg: add support for plugin modules
    o 1715061  wbemsmt: businesObjectList.getKey must return object
    o 1710995  wbemsmt-client: switchable cim schema for tasks
    o 1707399  wbemsmt: change file encoding to utf8
    o 1706397  wbemsmt: add base class for wbemsmt business objects
    o 1705834  wbemsmt: removing java 1.5 methods
    o 1700233  wbemsmt-cli&webapp: customizable feedback msg for wizards
    o 1674057  wbemsmt: update to sblim-cimclient-1.3.2
    o 1671504  wbemsmt-webapp: update to myfaces-core-1.1.5
    o 1699791  wbemsmt-webapp: revert changes after selecting new treenode
    o 1700178  wbemsmt-cli&webapp: cancel wizards
    o 1699830  wbemsmt-common: new UI Comp. for rendering a readonly list
    o 1699213  wbemsmt-common: CIMInstanceFilter.accept: add CimClient
    o 1685389  wbemsmt-dns: add welcome page
    o 1680547  wbemsmt-webapp: welcome screens
    o 1675864  wbemsmt-webapp: common contextMenu
    o 1674186  wbemsmt-webapp: Cancel action for tabbed editActions
    o 1671545  wbemsmt-common: version-attribute for treeConfig.xml
    o 1671546  wbemsmt-common: version-attribute for taskConfig.xml
    o 1671547  wbemsmt-common: version-attribute for containerConfig.xml
    o 1658315  wbemsmt-webapp help integration
    o 1648068  wbemsmt-webapp: Login for Portlet containers
    o 1648024  wbemsmt-webapp: confirmation at pending changes
    o 1645083  wbemsmt-webapp: multilineTable - row deletion
    o 1638397  wbemsmt-webapp: add action menue
    o 1638396  wbemsmt-webapp: add close link to wait indicator
    o 1636819  wbemsmt-dns: reorder fields of resourceRecord List
    o 1618646  wbemsmt-webapp: rework ui: messages
    o 1620646  wbemsmt-webapp: wait indicator / confirmation dlg
    o 1633880  wbemsmt-common: titles for Tables - remove duplicated title for resource records
    o 1633279  wbemsmt-dns: Label instead of InputField in WizardSummary
    o 1633828  wbemsmt-common: remove inherited attributes from derived class
    o 1633822  wbemsmt-common: copy DataContainers
    o 1633209  wbemsmt-webapp: legend only if necessary
    o 1633006  wbemsmt-webapp: alignment of Fields
    o 1631557  wbemsmt-webapp: remove Cancel- and add Revert-Button
    o 1619945  wbemsmt-webapp: TreeSynchronisation
    o 1619423  wbemsmt-webapp: rework ui: field indicators
    o 1619411  wbemsmt-webapp: rework ui: changes for IE,opera...
    o 1613959  wbemsmt-webapp: rework ui: content of editPanels
    o 1615822  wbemsmt-webapp: rework ui: wizards

* Mon Dec 4 2006 Wolfgang Taphorn <taphorn@de.ibm.com> 0.2.3-1
  - Consolidation of the different cvs modules
  - Inclusion of fixes for the following bug entries:
    o 1609091  wbemsmt-dns: Consolidation of cvs module
    o 1609068  wbemsmt-dns: JSF EUI and Commandline support
    

* Tue Oct 17 2006 Wolfgang Taphorn <taphorn@de.ibm.com> 0.2.2-1
  Changelog information out of the distributed cvs modules
  - Inclusion of fixes for the following bug entries:
    o 1572076  Missing Validation Messages
    o 1412716  cannot delete DNS Resource Record
    o 1574472  Cleanup for client projects    
    
* Fri Oct 28 2005 Wolfgang Taphorn <taphorn@de.ibm.com> 0.1.1-1
  - Initial upload of distributed CVS modules
