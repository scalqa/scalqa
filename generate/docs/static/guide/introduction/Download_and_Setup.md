---
layout: doc-page
title: Download and Setup
---

A natural pre-requisite for Scalqa is the installed Scala3 environment.


## Download

SBT users should add following library dependency:

libraryDependencies += "org.scalqa" % "scalqa_3" % "0.9"

Everyone else can download single JAR file from the [latest release](https://github.com/scalqa/scalqa/releases)

## Simple Use

In basic case Scalqa root must always be imported into each program unit. This sounds a lot, but this is the only import to be done. 
Implicit conversions also must be enabled. 

```
package myProjectsRoot.tests; import scalqa.{*, given}; import language.implicitConversions
 
object Test:

  def main(sa: Array[String]): Unit = println("Hellow world")

```
Note. It is suggested to use single line (as above) for package and static repeating definitions.

## Project Use

It is possible to setup project specific Scalqa root, which will be shared by all program units.

Consider the following package, which has all necessary Scalqa elements exported within:
```
package myProjectsRoot:
  export scalqa.Lang.*
  export scalqa.Val.*
  export scalqa.Gen.*
  export scalqa.Gen.Request.*
  export scalqa.j.vm.Predef.given
  @scala.annotation.targetName("RootStream") val ~~ = scalqa.`val`.Stream
```      

Now there is no need to import scalqa.
```
package myProjectsRoot; package tests; import language.implicitConversions
 
object Test:

  def main(sa: Array[String]): Unit = println("Hellow world")
```
Note. The root package must be open (`myProjectsRoot` followed by word `package`, not period)

Note. `import language.implicitConversions` is still required in each file, unless implicits are enabled on configuration level.
