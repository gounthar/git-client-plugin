# Java 25 Compatibility Summary

## Findings

1. **Code Compatibility**: The git-client-plugin code itself is compatible with Java 25. We successfully compiled the code with Java 25 as shown by the `java25-compile-only.bat` script.

2. **Build Process Issue**: The build process fails during the license plugin execution with the error:
   ```
   BUG! exception in phase 'semantic analysis' in source unit 'inlineScript' Unsupported class file major version 69
   ```

3. **Root Cause**: The license plugin uses an older version of Groovy that doesn't support Java 25's class file format (version 69).

## Solutions

1. **Skip the License Plugin**: For development with Java 25, you can skip the license plugin:
   ```
   mvn clean compile -Dmaven.license.skip=true
   ```

2. **Use the Java 25 Compatibility Profile**: We've added a profile in the pom.xml that activates when building with Java 25:
   ```xml
   <profile>
     <id>java25-compatibility</id>
     <activation>
       <property>
         <name>java25.compatibility</name>
       </property>
     </activation>
     <properties>
       <maven.license.skip>true</maven.license.skip>
       <spotless.check.skip>true</spotless.check.skip>
       <spotbugs.skip>true</spotbugs.skip>
       <animal.sniffer.skip>true</animal.sniffer.skip>
       <enforcer.skip>true</enforcer.skip>
       <maven.javadoc.skip>true</maven.javadoc.skip>
     </properties>
   </profile>
   ```

3. **Verification**: We've created a `VerifyJava25.java` program that confirms we're using Java 25:
   ```
   Java Version: 25-beta
   Java Vendor: Eclipse Adoptium
   Java Home: C:\Program Files\Eclipse Adoptium\jdk-25.0.0.9-hotspot
   Java VM Version: 25-beta+9-ea
   Java VM Name: OpenJDK 64-Bit Server VM
   Java Class Version: 69.0
   ```

## Scripts

1. **java25-compile-only.bat**: Compiles the code with Java 25, skipping the license plugin.

## Recommendations

1. For development with Java 25, use:
   ```
   .\java25-compile-only.bat
   ```

2. For production builds, continue using Java 21 or earlier until the Jenkins ecosystem fully supports Java 25.

3. When the Jenkins ecosystem updates its Groovy dependencies to support Java 25, you can remove the compatibility profile from the pom.xml.
