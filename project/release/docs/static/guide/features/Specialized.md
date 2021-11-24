---
layout: doc-page
title: Specialized
---
## Containers and Collections

Scalqa provides a default generic value container framework [Val](../../api/scalqa/Val$.html), which works 
with Object based types. This is similar to what Java and Scala collections have to offer.

What is novel, is the generic specialized frameworks for all primitive based types, these are: 

 - [Boolean.G](../../api/scalqa/lang/boolean/G$.html),
 - [Byte.G](../../api/scalqa/lang/byte/G$.html),
 - [Char.G](../../api/scalqa/lang/char/G$.html),
 - [Short.G](../../api/scalqa/lang/short/G$.html),
 - [Int.G](../../api/scalqa/lang/int/G$.html),
 - [Long.G](../../api/scalqa/lang/long/G$.html),
 - [Float.G](../../api/scalqa/lang/float/G$.html),
 - [Double.G](../../api/scalqa/lang/double/G$.html)
   
Members of these frameworks are never called directly, they always have parameterized aliases in type 
companion objects.  For example:     
```   
val v: Int.G.Stream[Int] = ???
// usually written as 
val v: Int.Stream        = ???

val p: Double.G.Pro.Mutable[Percent] = ???
// usually written as 
val p: Percent.Pro.Mutable           = ???
```
   
Whenever a new custom data type based on primitives is created, the custom container framework inside the 
companion object is created as well.     
      
In most cases (except for Opt), specialized containers extend generic implementations, 
overriding members to work with primitives. Therefor, specialized instance can always be upcast to
a general type, however no-boxing performance may not be guaranteed anymore:
```
val pb : Percent.Buffer  = Percent.Buffer()
val b  : Buffer[Percent] = pb
pb.add(5.Percent) // No boxing
b .add(5.Percent) // Boxing is likely
```
 