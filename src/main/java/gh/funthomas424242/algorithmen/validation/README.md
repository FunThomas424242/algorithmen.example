## JBoss Validation
* http://musingsofaprogrammingaddict.blogspot.de/2009/08/script-annotation-for-bean-validation.html


## Hintergrundinfos zum Checkerframework

* http://2010.geecon.org/materials/presentations/2010_05_14/room_3/2010-geecon-warski.pdf
* http://in.relation.to/2010/05/07/a-validation-stickler/
* http://types.cs.washington.edu/jsr308/
* http://types.cs.washington.edu/checker-framework/current/checker-framework-manual.html
* http://types.cs.washington.edu/checker-framework/current/checker-framework-manual.html#maven
* http://types.cs.washington.edu/checker-framework/current/checker-framework-manual.html#eclipse
* http://types.cs.washington.edu/checker-framework/eclipse/
* http://types.cs.washington.edu/checker-framework/current/checker-framework-manual.html#intellij

<properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

        <!-- These properties will be set by the Maven Dependency plugin -->
        <!-- Change to jdk7 if using Java 7 -->
        <annotatedJdk>${org.checkerframework:jdk8:jar}</annotatedJdk>
        <!-- Uncomment to use the type annotations compiler. -->
        <!-- <typeAnnotationsJavac>${org.checkerframework:compiler:jar}</typeAnnotationsJavac> -->
    </properties>


<!-- annotations from the Checker Framework: nullness, interning, locking, 
            ... -->
        <dependency>
            <groupId>org.checkerframework</groupId>
            <artifactId>checker-qual</artifactId>
            <version>1.9.13</version>
        </dependency>
        <dependency>
            <groupId>org.checkerframework</groupId>
            <artifactId>checker</artifactId>
            <version>1.9.13</version>
        </dependency>
        <!-- The type annotations compiler - uncomment if desired -->
        <!-- <dependency> <groupId>org.checkerframework</groupId> <artifactId>compiler</artifactId> 
            <version>1.9.13</version> </dependency> -->
        <!-- The annotated JDK to use (change to jdk7 if using Java 7) -->
        <dependency>
            <groupId>org.checkerframework</groupId>
            <artifactId>jdk8</artifactId>
            <version>1.9.13</version>
        </dependency>
        
        
        <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <annotationProcessors>
                        <!-- Add all the checkers you want to enable here -->
                        <annotationProcessor>org.checkerframework.checker.nullness.NullnessChecker</annotationProcessor>
                    </annotationProcessors>
                    <compilerArgs>
                        <!-- location of the annotated JDK, which comes from a Maven dependency -->
                        <arg>-Xbootclasspath/p:${annotatedJdk}</arg>
                        <!-- Uncomment the following line to use the type annotations compiler. -->
                        <!-- <arg>-J-Xbootclasspath/p:${typeAnnotationsJavac}</arg> -->
                    </compilerArgs>
                </configuration>
            </plugin>