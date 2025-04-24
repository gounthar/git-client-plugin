@echo off
REM This script explicitly uses Java 25 for compilation only

REM Save current JAVA_HOME
set JAVA_HOME_BACKUP=%JAVA_HOME%

REM Set Java 25 path
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-25.0.0.9-hotspot

REM Update PATH to use Java 25 first
set PATH=%JAVA_HOME%\bin;%PATH%

echo Using Java 25 from: %JAVA_HOME%
echo Java version:
java -version

echo.
echo Verifying Java version...
"%JAVA_HOME%\bin\javac" VerifyJava25.java
"%JAVA_HOME%\bin\java" VerifyJava25

echo.
echo Compiling with Java 25...

REM Only compile the code, skipping the license plugin
call mvn clean compile -Dmaven.license.skip=true

if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilation successful! The code has been compiled with Java 25.
) else (
    echo.
    echo Compilation failed. Please check the error messages above.
)

REM Restore original JAVA_HOME
set JAVA_HOME=%JAVA_HOME_BACKUP%
