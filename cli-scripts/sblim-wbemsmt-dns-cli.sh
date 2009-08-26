#!/bin/bash
###############################################################################
# sblim-wbemsmt-dns-cli.sh
#
# (C) Copyright IBM Corp. 2006
#
# THIS FILE IS PROVIDED UNDER THE TERMS OF THE ECLIPSE PUBLIC LICENSE
# ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
# CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
#
# You can obtain a current copy of the Eclipse Public License from
# http://www.opensource.org/licenses/eclipse-1.0.php
#
# Author:       Wolfgang Taphorn <taphorn@de.ibm.com>
#
# Contributors: Michael Bauschert <michael.bauschert@de.ibm.com>
#
###############################################################################
# Description:
#
# This file is a JPackage based startup script for the SBLIM WBEM-SMT Dns
# command line interface.
#
###############################################################################


#######################################
# Check for the JPackage functions lib
if [ -f /usr/share/java-utils/java-functions ]; then 
  . /usr/share/java-utils/java-functions
else
  echo "Can not find JPackage Functions Library for Japa Applications."
  exit 1
fi

#######################################
# Set the CLASSPATH
#
CLASSPATH=$(build-classpath sblim-cim-client xerces-j2):$CLASSPATH
CLASSPATH=$(build-classpath tomcat5-servlet-2.4-api):$CLASSPATH
CLASSPATH=$(build-classpath xbean jsr173_1.0_api myfaces-api myfaces-impl tomahawk):$CLASSPATH
CLASSPATH=$(build-classpath commons-collections commons-cli commons-lang commons-logging):$CLASSPATH
CLASSPATH=$(build-classpath xml-commons-resolver):$CLASSPATH
CLASSPATH=$(build-classpath sblim-wbemsmt/sblim-wbemsmt-dns):$CLASSPATH
CLASSPATH=$(build-classpath sblim-wbemsmt/sblim-wbemsmt-commons):$CLASSPATH

#######################################
# Set additional parameter
#
OPTIONS=-Djava.util.logging.config.file=/etc/java/sblim-wbemsmt/logging-cmd.properties -Dcommands=org.sblim.wbemsmt.cli.dns.Commands


#######################################
# Set the main class to execute
#
MAIN_CLASS=org.sblim.wbemsmt.tools.cli.Cli


#######################################
# start the application
#
run

