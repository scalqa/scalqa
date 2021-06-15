---
layout: doc-page
title: Download and Setup
---

A natural pre-requisite for Scalqa is the installed Scala3 environment. 
If in doubt, take a look at project [Samples](https://github.com/scalqa/samples), which is SBT configured for Scala3 with Scalqa. 

### Download

SBT users should add following library dependency:

libraryDependencies += "org.scalqa" % "scalqa_3" % "0.92"

Everyone else can download single JAR file from the [latest release](https://github.com/scalqa/scalqa/releases)

### Simple Use

In basic case Scalqa root must always be imported into each program unit. This sounds a lot, but this is the only import to be done. 
Implicit conversions also must be enabled. 
```
package Foo; import scalqa.{*, given}; import language.implicitConversions
```
Note. It is suggested to use single line (as above) for package and static repeating definitions.

### Project Use

It is possible to set up a project specific Scalqa root, which will be shared by all program units.

To do so, copy the [root package content](https://github.com/scalqa/samples/blob/master/src/example/package.scala) of Samples project. 

Other program units in [Samples](https://github.com/scalqa/samples) do not need to import Scalqa anymore, but the root package definition must be accessible:

``` 
package example; package data   // package 'example' is accessible
// vs.    
package example.data            // Not accessible    
```
Note. `import language.implicitConversions` is still required in each file, unless implicits are enabled on configuration level.
