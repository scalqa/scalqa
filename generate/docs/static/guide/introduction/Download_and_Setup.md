---
layout: doc-page
title: Download and Setup
---

## Download


Scalqa is available on Maven central repository for open source projects

SBT users can add library dependencies:

libraryDependencies += "org.scalqa" % "scalqa-stream_2.12" % "0.1"


## Simple Use

In basic case Scalqa root must always be imported into each program unit. 
Implicit conversions also must be enabled. 

```
package myProjectsRoot.tests; import scalqa.{*, given}; import language.implicitConversions
 
object Test:

  def main(sa: Array[String]): Unit = println("Hellow world")

```
Note. It is suggested to use single line (as above) for package and static repeating definitions.

## Project Use

We can setup project specific Scalqa root, which will be shared by all program units.

Consider the following package, which has all necessary Scalqa elements exported within:
```
package myProjectsRoot:
  export scalqa.Def._
  export scalqa.Gen._
  export scalqa.Val._
  export scalqa.Gen.Request._
  export scalqa.j.vm.Predef.given
  @tn("RootStream") val ~~ = scalqa.`val`.Stream
```      

Now we can re-write the above `object Test`, taking advantage of root definitions:
```
package myProjectsRoot; package tests; import language.implicitConversions
 
object Test:

  def main(sa: Array[String]): Unit = println("Hellow world")
```
Note. There is no need to import Scalqa anymore, but the root package must be open (`myProjectsRoot` followed by word `package`, not period)

Also `import language.implicitConversions` is still required in each file, unless implicits are enabled on configuration level.
