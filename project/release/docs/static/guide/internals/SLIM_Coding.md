---
layout: doc-page
title: SLIM Coding
---
### Single LIne Methods Coding

Most methods in Scalqa are written as a single line of code and program units never exceed one screen (no need for scrolling down).

For example, this is the definition of 
[Lookup](../../api/scalqa/val/Lookup.html) ([source](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/val/lookup/__.scala))
collection trait:

```scala
trait Lookup[A,+B] extends Collection[B]:
  def getOpt(key: A)            : Opt[B]
  def get(v: A)                 : B               = getOpt(v) or (throw ZZ.ME(v.tag))
  def getStream(keys: Stream[A]): Stream[B]       = keys.mapOpt(getOpt(_))
  def pairStream                : Stream[(A, B)]
  def keyStream                 : Stream[A]       = pairStream.map(_._1)
  def stream                    : Stream[B]       = pairStream.map(_._2)
```

This format allows to understand the entire program unit in a glance, facilitating different kind 
of non-linear thinking about program development.

Take a look at few more source code examples:

 - [Val.Collection](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/val/collection/__.scala)
 - [Val.Idx](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/val/idx/__.scala)
 - [Int.G.Stream](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/lang/int/g/Stream.scala)
 - [Double.G.Opt](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/lang/double/g/Opt.scala)
 
 