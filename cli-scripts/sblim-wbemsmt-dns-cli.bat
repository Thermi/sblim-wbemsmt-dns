@REM ##############################################################################
@REM sblim-wbemsmt-dns-cli.bat
@REM
@REM (C) Copyright IBM Corp. 2006
@REM
@REM THIS FILE IS PROVIDED UNDER THE TERMS OF THE COMMON PUBLIC LICENSE
@REM ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THIS FILE
@REM CONSTITUTES RECIPIENTS ACCEPTANCE OF THE AGREEMENT.
@REM
@REM You can obtain a current copy of the Common Public License from
@REM http://www.opensource.org/licenses/cpl1.0.php
@REM
@REM Author:       Michael.Bauschert@de.ibm.com
@REM
@REM ##############################################################################
@REM Description:
@REM
@REM This file is a startup script for the SBLIM WBEM-SMT Dns
@REM command line interface 
@REM
@REM ##############################################################################

@echo off
setlocal

if exist "%JAR_REPO%" goto RUNCMD
echo environment variable JAR_REPO is not set
goto THEEND

:RUNCMD

SET CLASSPATH=%JAR_REPO%\xmlbeans\xbean\2.1.0\xbean-2.1.0.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\xmlbeans\xmlbeans-jsr173-api\2.0-dev\xmlbeans-jsr173-api-2.0-dev.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\sblim\sblim-cim-client\1.3.0\sblim-cim-client-1.3.0.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\myfaces\myfaces-impl\1.1.3\myfaces-impl-1.1.3.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\myfaces\myfaces-api\1.1.3\myfaces-api-1.1.3.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\myfaces\tomahawk\1.1.3\tomahawk-1.1.3.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\commons-collections\commons-collections\3.1\commons-collections-3.1.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\commons-cli\commons-cli\1.0\commons-cli-1.0.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\commons-lang\commons-lang\2.1\commons-lang-2.1.jar
SET CLASSPATH=%CLASSPATH%;%JAR_REPO%\javax\servlet\servlet-api\2.4\servlet-api-2.4.jar
SET CLASSPATH=%CLASSPATH%;lib\sblim-wbemsmt-cim-schema-bl-2.9-0.2.1.jar
SET CLASSPATH=%CLASSPATH%;lib\sblim-wbemsmt-dns-0.2.1.jar
SET CLASSPATH=%CLASSPATH%;lib\sblim-wbemsmt-tools-bl-0.2.1.jar
SET CLASSPATH=%CLASSPATH%;lib\sblim-wbemsmt-tools-bl-launcher-config-0.2.1.jar
SET CLASSPATH=%CLASSPATH%;lib\sblim-wbemsmt-tools-eui-0.2.1.jar
SET CLASSPATH=%CLASSPATH%;lib\sblim-wbemsmt-tools-wizard-framework-0.2.1.jar

SET VM_OPTIONS=-Djava.util.logging.config.file=cmdlogging.properties -Dcommands=org.sblim.wbemsmt.cli.dns.Commands
java %VM_OPTIONS% org.sblim.wbemsmt.tools.cli.Cli %*

:THEEND
endlocal
