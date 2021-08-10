---
layout: doc-page
title: Download and Setup
---

A natural pre-requisite for Scalqa is the installed Scala3 environment. 
If in doubt, take a look at project [Samples](https://github.com/scalqa/samples), which is SBT configured for Scala3 with Scalqa. 

### Download

SBT users should add following library dependency:

libraryDependencies += "org.scalqa" % "scalqa_3" % "0.99"

Everyone else can download single JAR file from the [latest release](https://github.com/scalqa/scalqa/releases)

Note. If GUI is to be used on JDK11 and above, the javaFx has to be provided manually. 
Take a look at ["samplesFx" configuration](https://github.com/scalqa/samplesFx/blob/master/build.sbt). 

### Simple Use

In basic case Scalqa root must always be imported into each program unit. This sounds a lot, but this is the only import to be done. 
Implicit conversions also must be enabled. 
```
package Foo; import scalqa.{*, given}; import language.implicitConversions
```
Note. It is suggested to use single line (as above) for package and static definitions, which will repeat in each program.

### Project Use

It is possible to set up a project specific Scalqa root, which will be shared by all program units.

To do so, copy the ["fx" package root content](https://github.com/scalqa/samplesFx/blob/master/src/example/fx/package.scala) 
of SamplesFx project into your root package. 

Note, other program units (like 
[Lines](https://github.com/scalqa/samplesFx/blob/master/src/example/fx/chart/Lines.scala),
[Sorting](https://github.com/scalqa/samplesFx/blob/master/src/example/fx/table/Sorting.scala), etc.)
do not need to import Scalqa anymore, but the "fx" package definition must be accessible:

``` 
package example.fx; package chart   // package 'fx' is accessible
// vs.    
package example.fx.chart            // Not accessible    
```
Note. `import language.implicitConversions` is still required in each file, unless implicits are enabled on configuration level.
