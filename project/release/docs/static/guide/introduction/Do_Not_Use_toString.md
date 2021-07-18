---
layout: doc-page
title: Do Not Use 'toString'
---

A wide use of opaque types introduces a new unexpected problem: how to convert them to String. 
From JVM prospective opaques do not exist. Simple `.toString()` conversion will always be done for the base type.

For example, the following outputs are not very informative, as they represent `Long.toString` result: 

```scala
    val t : Time        = CURRENT
    val tl: Time.Length = 12.Seconds

    println(t)      // Prints: 1603916378729
    println(tl)     // Prints: 12000000000
```   

In Scalqa, instead of `.toString()` one has to always use method [`.tag`](../../api/scalqa/lang/any/_methods.html#tag), 
which is universally available for all types including opaques.

```scala
    println(t.tag)  // Prints: 2020-10-28 16:23:08.888
    println(tl.tag) // Prints: 12 secs
```

Furthermore, there is a universal method to print debugging information 
[`.tp`](../../api/scalqa/lang/any/_methods.html#tp) (pronounced as 'tip'), which stands for 'tag print'. 
Same as [`.tag`](../../api/scalqa/lang/any/_methods.html#tag), [`.tp`](../../api/scalqa/lang/any/_methods.html#tp) is also 
available for all types: 

```scala
    t.tp            // Prints: 2020-10-28 16:23:08.888
    tl.tp           // Prints: 12 secs
```

Note, [`.tp`](../../api/scalqa/lang/any/_methods.html#tp) must not appear in production code, 
its presence indicates leftover debugging functionality. 

Method [`.tp`](../../api/scalqa/lang/any/_methods.html#tp) is also widely used in examples, 
so prepare to see a lot of it in this documentation.  

