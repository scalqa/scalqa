---
layout: doc-page
title: Pack
---

Pack is a type defined as [><](../../api/scalqa/val/Pack.html). It is an immutable collection of values designed 
to replace scala.List and scala.Vector. Pack is mostly a wrapper around an Array, which is private and cannot be modified. 
Scala3 does introduce an IArray type, which also cannot be modified, but it can easily be cast into regular array and therefor is not tamper proof.  

## Creation

The only drawback of >< is the "element append" operation. The entire internal array has to be copied each time. 
In those circumstances' scala.List and scala.Vector would shine:

```
    val array  : Array[String] = (0 <>> 1000).~.map(_.toString).toArray

    J.Benchmark(
      ("List",   () => {var list:   List[String]   = Nil;          for(i <- 0 <>> 1000) list   = array(i) :: list;   list.size}),
      ("Vector", () => {var vector: Vector[String] = Vector.empty; for(i <- 0 <>> 1000) vector = vector :+ array(i); vector.size}),
      ("><",     () => {var pack:   ><[String]     = \/;           for(i <- 0 <>> 1000) pack   = pack + array(i);    pack.size}),
    )

    // Output
    Final Result. Total length is about 12 secs
    --- ------ ------- --- ------- --- ---------
    Num Name   Ops/Sec %   Memory  %   Avg Value
    --- ------ ------- --- ------- --- ---------
    1   List   204.7k  100 23.5kB  1   1000.0
    2   Vector 40.5k   19  114.1kB 5   1000.0
    3   ><     4.0k    1   1.9mB   100 1000.0
    --- ------ ------- --- ------- --- ---------
```

However, it is rare in Scalqa, to add elements one by one, everything is done with streams. In this case >< wins, because it would provide Array Buffer like performance. 

```
    val many = (0 <>> 1000).~.map(_.toString).toSeq

    J.Benchmark(
        ("List",   () => {var list:   List[String]   = Nil;          list   = list :++ many;   list.size}),
        ("Vector", () => {var vector: Vector[String] = Vector.empty; vector = vector :++ many; vector.size}),
        ("><",     () => {var pack:   ><[String]     = \/;           pack   = pack ++ many;    pack.size}),
    )


    // Output
    Final Result. Total length is about 12 secs
    --- ------ ------- --- ------ --- ---------
    Num Name   Ops/Sec %   Memory %   Avg Value
    --- ------ ------- --- ------ --- ---------
    1   List   62.4k   33  24.0kB 100 1000.0
    2   Vector 120.5k  64  5.0kB  21  1000.0
    3   ><     188.2k  100 4.1kB  17  1000.0
    --- ------ ------- --- ------ --- ---------
```


## Storage

Due to the fact that, from JVM prospective, Array is a perfect storage, >< beats both: 
scala.List and scala.Vector on compactness. Note memory utilization to store 1 million strings:

```
    val array = (0 <>> 1000000).~.map(_.toString).toArray

    J.Benchmark(
      ("List",   () => array.toList.size),
      ("Vector", () => array.toVector.size),
      ("><",     () => array.><.size),
    )

    // Output
    Final Result. Total length is about 12 secs
    --- ------ ------- --- ------ --- ---------
    Num Name   Ops/Sec %   Memory %   Avg Value
    --- ------ ------- --- ------ --- ---------
    1   List   154     14  24.0mB 100 1000000.0
    2   Vector 120     11  4.5mB  18  1000000.0
    3   ><     1.0k    100 3.7mB  15  1000000.0
    --- ------ ------- --- ------ --- ---------

```
   
## Specialized

Pack really shines when storing unboxed primitives:

```
    val array : Array[Time.Length] = (0 <>> 1000000).~.map(_.Seconds).toArray

    J.Benchmark(
      ("List",   () => array.toList.size),
      ("Vector", () => array.toVector.size),
      ("><",     () => array.><.size),
    ) 

   // Output
   Final Result. Total length is about 12 secs
   --- ------ ------- --- ------ --- ---------
   Num Name   Ops/Sec %   Memory %   Avg Value
   --- ------ ------- --- ------ --- ---------
   1   List   81      12  47.7mB 100 1000000.0
   2   Vector 101     16  27.5mB 57  1000000.0
   3   ><     631     100 8.2mB  17  1000000.0
   --- ------ ------- --- ------ --- ---------
   
```

It takes slightly over 8mB to store 1 million Long values.        
   