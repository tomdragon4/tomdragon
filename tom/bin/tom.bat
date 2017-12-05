@echo off
if "%OS%" == "Windows_NT" setlocal
rem ---------------------------------------------------------------------------
rem Script for TOM compiler
rem
rem Environment Variable Prequisites
rem
rem   TOM_HOME      May point at your Tom "build" directory.
rem                 if not, we try to guess.
rem
rem   TOM_OPTS      (Optional) TOM options.
rem
rem   JAVA_HOME     Must point at your Java Development Kit installation.
rem
rem   JAVA_OPTS     (Optional) Java runtime options.
rem
rem Written by strating from tom.bat, gom.bat (tonio) and gomantlradaptor.bat (jcb)
rem
rem $Id: script.bat.in,v 0.2 2011/02/16 10:00:00 jcb Exp $
rem $Id: script.bat.in,v 0.1 2011/02/16 09:17:06 jcb Exp $
rem ---------------------------------------------------------------------------
 
rem Make sure prerequisite environment variables are set
if not "%JAVA_HOME%" == "" goto gotJavaHome
echo WARNING: The JAVA_HOME environment variable is not defined
echo The installation may not work
set JAVA_PREFIX=
rem goto end
goto okJavaHome

:gotJavaHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\javaw.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\jdb.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\javac.exe" goto noJavaHome
set JAVA_PREFIX=%JAVA_HOME%\bin\
goto okJavaHome
:noJavaHome
echo The JAVA_HOME environment variable is not defined correctly
echo This environment variable is needed to run this program
goto end
:okJavaHome

rem Guess TOM_HOME if not defined
if not "%TOM_HOME%" == "" goto gotHome
set TOM_HOME=.
if exist "%TOM_HOME%\bin\tom.bat" goto okHome
set TOM_HOME=..
:gotHome
if exist "%TOM_HOME%\bin\tom.bat" goto okHome
echo The TOM_HOME environment variable is not defined correctly
echo This environment variable is needed to run this program
goto end
:okHome

rem Check for TOM_LIB variable
if not "%TOM_LIB%" == "" goto okLib
rem Add all jars in lib dir to TOM_LIB variable (will include a initial semicolon ";")
call "%TOM_HOME%\bin\tlappend.bat" "%TOM_HOME%\lib\tom-runtime-full.jar"
call "%TOM_HOME%\bin\tlappend.bat" "%TOM_HOME%\lib\tom-compiler-full.jar"
:okLib

rem Check for TOM_OPTS variable
if not "%TOM_OPTS%" == "" goto okOpts
rem Use standard options
set TOM_OPTS=-X "%TOM_HOME%\Tom.xml"
set STD_OPTS=true
:okOpts

rem ----- Execute The Requested Command ---------------------------------------
rem echo Using JAVA_HOME:       %JAVA_HOME%
rem echo Using JAVA_PREFIX:     %JAVA_PREFIX%
rem echo Using TOM_HOME:        %TOM_HOME%

rem Set standard command for invoking Java.
set _RUNJAVA="%JAVA_PREFIX%java"

rem Get command line arguments and save them in 
rem the CMD_LINE_ARGS environment variable
set CMD_LINE_ARGS=
:setArgs
if ""%1""=="""" goto doneSetArgs
if not ""%STD_OPTS%"" == ""true"" goto noStdOpts
rem Check for options clash when using standard options
if ""%1""==""-X"" goto optClash
if ""%1""==""-I"" goto optClash
if ""%1""==""--import"" goto optClash
:noStdOpts
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setArgs
:optClash
rem Here there are two possibilities:
rem 1. to encourage the user to use the TOM_OPTS environment variable
%echo You should specify the configuration and import files
%echo using the TOM_OPTS environment variable
%goto end
rem 2. to use the user arguments instead of the TOM_OPTS environment variable
set TOM_OPTS=
:doneSetArgs

rem execute TOM
%_RUNJAVA% %JAVA_OPTS% -Dtom.home="%TOM_HOME%" -classpath "%CLASSPATH%""%TOM_LIB%" tom.engine.Tom %TOM_OPTS% %CMD_LINE_ARGS%

:end

