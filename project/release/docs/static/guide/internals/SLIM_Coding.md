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
  @tn("get_Opt")     def get_?(key: A)     : Opt[B]
  @tn("get_Stream")  def get_~(keys: ~[A]) : ~[B]       = keys.map_?(get_?(_))
  /* */              def get(v: A)         : B          = get_?(v) or (throw ZZ.ME(v.tag))
  @tn("pair_Stream") def pair_~            : ~[(A, B)]
  @tn("key_Stream")  def key_~             : ~[A]       = pair_~.map(_._1)
  @tn("stream")      def ~                 : ~[B]       = pair_~.map(_._2)
```

This format allows to understand the entire program unit in a glance, facilitating different kind 
of non-linear thinking about program development.

Take a look at few more source code examples:

 - [Val.Collection](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/val/collection/__.scala)
 - [Val.Idx](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/val/idx/__.scala)
 - [Int.G.~](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/lang/int/g/Stream.scala)
 - [Double.G.Opt](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/lang/double/g/Opt.scala)
 
 