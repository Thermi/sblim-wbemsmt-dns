%define name                    sblim-wbemsmt-dns
%define version                 0.2.3
%define build_release           1
%define release                 %{build_release}jpp
%define section                 free


%define wbemsmt_webapp_name     sblim-wbemsmt-webapp
%define wbemsmt_webapp_instdir  %{_localstatedir}/lib/%{wbemsmt_webapp_name}/webapps/%{wbemsmt_webapp_name}

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
BuildRequires: sblim-cim-client >= 0:1.3.1
#BuildRequires: sblim-wbemsmt-commons => 0.2.3
BuildRequires: jakarta-commons-cli >= 1.0
BuildRequires: jakarta-commons-lang >= 2.0
#BuildRequires:  myfaces >= 1.1.4

###############################################################################

Requires: jpackage-utils >= 0:1.5.32
Requires: sblim-cim-client >= 0:1.3.1
Requires: sblim-wbemsmt-commons => 0.2.3
Requires: sblim-wbemsmt-webapp => 0.2.3
Requires: jakarta-commons-cli >= 1.0
Requires: jakarta-commons-lang >= 2.0
#Requires:  myfaces >= 1.1.4

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
CLASSPATH=$(build-classpath myfaces-api myfaces-impl ):$CLASSPATH
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

# Installation of documentation files
install COPYING   $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/COPYING
install AUTHORS   $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/AUTHORS
install README    $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/README
install ChangeLog $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/ChangeLog
install NEWS      $RPM_BUILD_ROOT%{_docdir}/%{name}-%{version}/NEWS

install target/package/etc/sblim-wbemsmt/tasklauncher.d/dns-task-config.xml $RPM_BUILD_ROOT%{_sysconfdir}/sblim-wbemsmt/tasklauncher.d/
install target/package/cli-scripts/sblim-wbemsmt-dns-cli.sh $RPM_BUILD_ROOT%{_bindir}/sblim-wbemsmt-dns-cli.sh

# Installation of java files
install target/package/%{name}-%{version}.jar $RPM_BUILD_ROOT%{_javadir}/sblim-wbemsmt
(
  cd $RPM_BUILD_ROOT%{_javadir}/sblim-wbemsmt &&
    ln -sf %{name}-%{version}.jar %{name}.jar;
)

###############################################################################

%post
unset JAVA_HOME
[ -r %{_sysconfdir}/tomcat5/tomcat5.conf ] && . %{_sysconfdir}/tomcat5/tomcat5.conf
[ -z "$JAVA_HOME" ] && [ -r %{_sysconfdir}/java/java.conf ] && \
    . %{_sysconfdir}/java/java.conf
[ -z "$JAVA_HOME" ] && JAVA_HOME=%{_jvmdir}/java
build-jar-repository %{wbemsmt_webapp_instdir}/WEB-INF/lib sblim-wbemsmt/%{name}


###############################################################################

%preun
if [ $1 = 0 ]; then
     rm -f %{wbemsmt_webapp_instdir}/WEB-INF/lib/\[sblim-wbemsmt\]\[%{name}.jar\]*.jar
fi


###############################################################################

%files
%defattr(0644,root,root,0755)
%doc %{_docdir}/%{name}-%{version}/COPYING
%doc %{_docdir}/%{name}-%{version}/AUTHORS
%doc %{_docdir}/%{name}-%{version}/README
%doc %{_docdir}/%{name}-%{version}/ChangeLog
%doc %{_docdir}/%{name}-%{version}/NEWS
%{_javadir}/sblim-wbemsmt/%{name}.jar
%{_javadir}/sblim-wbemsmt/%{name}-%{version}.jar
%{_bindir}/sblim-wbemsmt-dns-cli.sh
%attr(444,root,tomcat) %config(noreplace) %{_sysconfdir}/sblim-wbemsmt/tasklauncher.d/dns-task-config.xml

###############################################################################
%changelog
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
    
* Fir Oct 28 2006 Wolfgang Taphorn <taphorn@de.ibm.com> 0.1.1-1
  - Initial upload of distributed CVS modules
