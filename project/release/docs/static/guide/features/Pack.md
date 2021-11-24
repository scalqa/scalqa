---
layout: doc-page
title: Pack
---

[Pack](../../api/scalqa/val/Pack.html) is an immutable collection of values designed 
to replace scala.List and scala.Vector. Pack is mostly a wrapper around an Array, which is private and cannot be modified. 
Scala3 does introduce an IArray type, which also cannot be modified, but it can easily be cast into regular array and therefor
is not sufficiently tamper proof.  

## Creation

The only drawback of Pack is the "element append" operation. The entire internal array has to be copied each time. 
On smaller element count Pack is still competitive: 

```
    val array  : Array[String] = (0 <>> 12).stream.map(_.toString).toArray

    J.Benchmark(
      ("List",   () => {var l: List[String]   = Nil;          for(i <- 0 <>> 12) l = array(i) :: l; l.size}),
      ("Vector", () => {var v: Vector[String] = Vector.empty; for(i <- 0 <>> 12) v = v :+ array(i); v.size}),
      ("Pack",   () => {var p: Pack[String]   = \/;           for(i <- 0 <>> 12) p = p + array(i);  p.size}),
    )

    // Output
    Final Result. Total length is about 12 secs
    --- ------ ------- --- ------ --- ---------
    Num Name   Ops/Sec %   Memory %   Avg Value
    --- ------ ------- --- ------ --- ---------
    1   List   13.1m   100 228B   24  12.0
    2   Vector 3.1m    23  930B   100 12.0
    3   Pack   4.8m    37  712B   76  12.0
    --- ------ ------- --- ------ --- ---------
```

However, it is rare in Scalqa, to add elements one by one, everything is done with streams. 
When adding multiple elements Pack provides Buffer like performance. 

```
    val many: Seq[String] = (0 <>> 12).stream.map(_.toString).toSeq

    J.Benchmark(
        ("List",   () => {var l: List[String]   = Nil;          l = l :++ many; l.size}),
        ("Vector", () => {var v: Vector[String] = Vector.empty; v = v :++ many; v.size}),
        ("Pack",   () => {var p: Pack[String]   = \/;           p = p ++ many;  p.size}),
    )


    // Output
    Final Result. Total length is about 12 secs
    --- ------ ------- --- ------ --- ---------
    Num Name   Ops/Sec %   Memory %   Avg Value
    --- ------ ------- --- ------ --- ---------
    1   List   5.0m    21  383B   100 12.0
    2   Vector 14.2m   59  124B   32  12.0
    3   Pack   23.8m   100 59B    15  12.0
    --- ------ ------- --- ------ --- ---------
```

## Storage

Due to the fact that, from JVM prospective, Array is a perfect storage, Pack beats both: 
scala.List and scala.Vector on compactness. Note memory utilization to store 1 million strings:

```
    val array: Array[String] = (0 <>> 1000000).stream.map(_.toString).toArray

    J.Benchmark(
      ("List",   () => array.toList.size),
      ("Vector", () => array.toVector.size),
      ("Pack",   () => array.pack.size),
    )

    // Output
    Final Result. Total length is about 12 secs
    --- ------ ------- --- ------ --- ---------
    Num Name   Ops/Sec %   Memory %   Avg Value
    --- ------ ------- --- ------ --- ---------
    1   List   154     14  24.0mB 100 1000000.0
    2   Vector 120     11  4.5mB  18  1000000.0
    3   Pack   1.0k    100 3.7mB  15  1000000.0
    --- ------ ------- --- ------ --- ---------

```
   
## Specialized

Pack really shines when storing unboxed primitives:

```
    val array : Array[Time.Length] = (0 <>> 1000000).stream.map(_.Seconds).toArray

    J.Benchmark(
      ("List",   () => array.toList.size),
      ("Vector", () => array.toVector.size),
      ("Pack",   () => array.pack.size),
    ) 

   // Output
   Final Result. Total length is about 12 secs
   --- ------ ------- --- ------ --- ---------
   Num Name   Ops/Sec %   Memory %   Avg Value
   --- ------ ------- --- ------ --- ---------
   1   List   81      12  47.7mB 100 1000000.0
   2   Vector 101     16  27.5mB 57  1000000.0
   3   Pack   631     100 8.2mB  17  1000000.0
   --- ------ ------- --- ------ --- ---------
   
```

It takes slightly over 8mB to store 1 million Long values.        

   