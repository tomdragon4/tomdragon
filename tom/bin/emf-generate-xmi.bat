@echo off

set SCRIPT_ARGS=
set JAVA_ARGS=
set JAVA_CP=

:setArgs
if ""%1""=="""" goto doneSetArgs
set arg1=%1
if ""%1""==""-cp"" goto labelArgs1
if not "%arg1:-D=%"=="%arg1%" goto labelArgs2
goto labelArgs3
:labelArgs1
shift
if ""%JAVA_CP%""=="""" (set JAVA_CP=%1) else (set JAVA_CP=%JAVA_CP% %1)
goto endArgs
:labelArgs2
if ""%JAVA_ARGS%""=="""" (set JAVA_ARGS=%1) else (set JAVA_ARGS=%JAVA_ARGS% %1)
goto endArgs
:labelArgs3
if ""%SCRIPT_ARGS%""=="""" (set SCRIPT_ARGS=%1) else (set SCRIPT_ARGS=%SCRIPT_ARGS% %1)
goto endArgs
:endArgs
shift
goto setArgs
:doneSetArgs

if not ""%JAVA_CP%""=="""" set JAVA_CP=%JAVA_CP:"=%

set TOM_LIB=%TOM_HOME%\lib
set TOM_JAR=%TOM_LIB%\tom-compiler-full.jar;%TOM_LIB%\tom-runtime-full.jar

rem This loops doesn't seem to work correctly
rem set TOM_EMF=
rem for /f "delims=" %%a in ('dir /b %TOM_LIB%\tools\org.eclipse.emf.*.jar') do (
rem call :SUBROUTINE %%a
rem )

set LOCALCLASSPATH=%TOM_JAR%;%CLASSPATH%
if not ""%JAVA_CP%""=="""" set LOCALCLASSPATH=%LOCALCLASSPATH%;%JAVA_CP%

java %JAVA_ARGS% -cp "%LOCALCLASSPATH%" -Dtom.home="%TOM_HOME%" tom.emf.EcoreMappingToXMI %SCRIPT_ARGS%
goto :eof

rem :subroutine
rem set TOM_EMF=%TOM_EMF%;%TOM_LIB%\tools\%*