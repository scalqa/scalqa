---
layout: doc-page
title: Attached Constructors
---

Java and Scala widely use a conversion pattern which starts with a prefix "to":

```
    val i : Int    = 12
    val s : String = i.toString
    val d : Double = i.toDouble
    val d : Byte   = i.toByte
```

In Scalqa the prefix "to" is dropped in cases when the base type is a straight forward argument for creating target type. 
This makes a method name start with an upper case, but this is exactly what differentiates constructor methods from regular methods.
This pattern really shines with simple opaque types, when constructors are attached to primitives: 

```
    val p   : Percent     = 12.Percent
    val tl1 : Time.Length = 14.Minutes
    val tl2 : Time.Length = 3.Seconds
    val bd  : BigDecimal  = 3.14.Big
```

Here are the definitions for attached default constructor methods on
[Int](../../api/scalqa/lang/int/_methods.html) and [Double](../../api/scalqa/lang/double/_methods.html). 