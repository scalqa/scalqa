---
layout: doc-page
title: Private Packages
---
## Z Stands for Private

Throughout Scalqa, if types or objects are not a part of public API, their implementations are usually 
put in special packages named ".z". In simpler cases there is a "Z" object to hold all private members.
Sometimes a type name would start from a lower case "z", like "zProvider", to show that it is private.
Thus, 'Z' stands for 'private'.

Note that "Z" objects are not necessarily inaccessible. Due to the fact that many methods are inlined, "Z" definitions must
remain public to be inline able. Nevertheless, they are not part of public API and must not be used directly, because 
they can change in future releases.   

"Z" definitions also simplify reading stack traces, where it is
immediately clear which classes and packages are private implementations.   

```
(1 <> 10).~.peek(_ => ???).filter(_ < 100).map(_.Long).flatMap(i => ~~(i,i,i)).foreach(_.tp)

at scala.Predef$.$qmark$qmark$qmark(Predef.scala:345)
at scalqa.Test0$.main$$anonfun$3(Test0.scala:8)
at scalqa.Test0$.main$$anonfun$adapted$1(Test0.scala:8)
at scalqa.val.stream.z.build.peek.peek.read_Opt(peek.scala:5)
at scalqa.val.stream.z.build.filter.take.read_Opt(take.scala:6)
at scalqa.val.stream.z.build.map.map$Longs.readRaw_Opt(map.scala:11)
at scalqa.lang.long.z.stream.flatMap$Longs.fewOpt(flatMap.scala:13)
at scalqa.val.stream.z.a.FlatMap$ToLong.fetchOpt(FlatMap.scala:43)
at scalqa.val.stream.z.a.FlatMap$ToLong.readRaw_Opt(FlatMap.scala:44)
at scalqa.lang.long.g.Stream.foreach(Stream.scala:31)
at scalqa.Test0$.main(Test0.scala:8)
at scalqa.Test0.main(Test0.scala)

```