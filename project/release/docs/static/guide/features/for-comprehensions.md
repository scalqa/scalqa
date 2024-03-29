---
layout: doc-page
title: For-Comprehensions 
---

All containers fully support Scala language ["for-comprehensions"](https://docs.scala-lang.org/tour/for-comprehensions.html) notation.
There is one twist though, which must be kept in mind. Collections delegate functional processing to the
[Stream](../../api/scalqa/val/Stream.html), thus whenever
a collection is included in "for-comprehension" it is automatically converted to [Stream](../../api/scalqa/val/Stream.html).

```
    val packOfInts: Pack[Int] = (1 <> 10).stream.pack

    var sum = 0

    for(i <- packOfInts if i < 5) sum += i    

    // Explicit .stream call would produce exactly same compiled code 

    for(i <- packOfInts.stream if i < 5) sum += i    

```

The usage is different from Scala, when one needs to yield the result as a collection,
the [Stream](../../api/scalqa/val/Stream.html) has to be converted explicitly:  
  
```
    val seq: Seq[String] =   for(i <- 1 until 10 ) yield i.tag

    val idx: Idx[String] = { for(i <- 1 <>> 10)    yield i.tag }.toIdx  // Explicit stream conversion  
```
 
Single value containers: [Opt](../../api/scalqa/val/Opt.html), [Result](../../api/scalqa/val/Result.html),
and [Promise](../../api/scalqa/val/Promise.html) are processed and yielded as their own type.
This is exactly same as Option, Try, and Future in Scala.
   
## Specialized

Containers, when used in "for-comprehensions", are still specialized for primitives:

```
    val array: Array[Int] = (1 <> 1_000_000).stream.toArray

    J.Benchmark(
      ("Array ", () => { var s=0L;  for(i <- array        if i%2 == 0) s += i; s }),
      ("Stream", () => { var s=0L;  for(i <- array.stream if i%2 == 0) s += i; s }),
    )

    // Output
    Final Result. Total length is about 12 secs
    --- ------- ------- --- ------ --- -----------
    Num Name    Ops/Sec %   Memory %   Avg Value
    --- ------- ------- --- ------ --- -----------
    1   Array   69      53  15.8mB 100 2.500005E11
    2   Stream  130     100 5.3kB  0   2.500005E11
    --- ------- ------- --- ------ --- -----------
```
Memory consumption clearly indicates unboxed processing.

## Perfect Int Loop

[Int.Range](../../api/scalqa/lang/int/_methods.html) is special.
When used in simple "for-comprehension" with foreach logic, a direct Java for-loop is produced.
Some [macro magic](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/lang/int/z/range/foreachMacro.scala) is obviously involved.

```
    var a = new Array[Int](1000)
    for(i <- 0 <>> a.length) a(i) = i
```
gets compiled into Java "for":
```
    int[] a = (int[])(new int[1000]);
    int i = 0;

    for(int e = a.length; i < e; ++i) {
        a[i] = i;
    }
```
with ultimate performance as a result:
```
    val a: Array[Int] = new Array(1000)

    J.Benchmark(
      ("Range    ", () => { for(i <- 0 until a.length) a(i)=i; a.length }),
      ("Int.Range", () => { for(i <- 0 <>> a.length  ) a(i)=i; a.length }),
    )

    // Output
    Final Result. Total length is about 12 secs
    --- --------- ------- --- ------ --- ---------
    Num Name      Ops/Sec %   Memory %   Avg Value
    --- --------- ------- --- ------ --- ---------
    1   Range     126.5k  3   14.1kB 100 1000.0
    2   Int.Range 3.4m    100 6B     0   1000.0
    --- --------- ------- --- ------ --- ---------
```
