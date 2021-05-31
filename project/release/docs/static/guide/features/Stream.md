---
layout: doc-page
title: Stream
---

Stream is a type defined as [~](../../api/scalqa/val/Stream.html)(tilde). It is the most important feature of Scalqa, 
responsible for universal data exchange and processing.

## Data Exchange

Whenever there is a need to pass multiple values of the same type, the preferred format is [~](../../api/scalqa/val/Stream.html). 
In Scalqa all collections, arrays, ranges, and other multi-value objects are implicitly and explicitly convertible to [~](../../api/scalqa/val/Stream.html). 
This also applies to all Java and Scala collections, which are also extended with streaming features. 

Let's consider [Buffer](../../api/scalqa/val/Buffer.html) method `++=` (alias for `addAll`),
which takes [~](../../api/scalqa/val/Stream.html) as an input. The following example is a valid code:

```
val buf: Buffer[Int] = Buffer()

buf ++= (1 <> 100) ++= idx ++= array ++= scalaSeq ++= scalaVector ++= javaList ++= javaIterator

def idx         : Val.Idx[Int]               = ???
def array       : Array[Int]                 = ???
def scalaSeq    : scala.Seq[Int]             = ???
def scalaVector : scala.Vector[Int]          = ???
def javaList    : java.util.List[Int]        = ???
def javaIterator: java.util.Iterator[Int]    = ???
```

[~](../../api/scalqa/val/Stream.html) is not only a collection iterator, it is more general and can be implemented 
for any abstract source of values, making this abstract data compatible with the collections. 

## Data Processing

Scalqa collections have few methods and are easy to understand, [Idx](../../api/scalqa/val/Idx.html) has just 4 core methods.
This is possible because all data processing functionality is removed to [~](../../api/scalqa/val/Stream.html). 
A collection can create a ~ of its elements and do all the manipulations required. If needed the ~ can be converted back 
to a collection.

```
var i: Idx[Int] = Idx(1,2,3,4,6)

i.~.tp  // Prints ~(1,2,3,4,6)

i = i.~.filter(_ % 2 == 0).toIdx

i.~.tp  // Prints ~(2,4,6)
```

[~](../../api/scalqa/val/Stream.html) already has a large number of data processing methods attached to it and this library will only grow. 
It is very easy to create a new [~](../../api/scalqa/val/Stream.html) operation, considering that it requires single implementation, 
but benefits everything attached to [~](../../api/scalqa/val/Stream.html).
```
extension (x: ~[Int])
  def countEven: Int = x.take(_ % 2 == 0).count

val l = scala.List(1,2,3,4,5)
val a = new Array[Int](10)

l.~.countEven  // Returns 2
a.~.countEven  // Returns 10

```

Stream also supports [parallel processing](../../api/scalqa/val/stream/_Build/_parallel.html).

## Heavy Operations

Whenever a Scala function is called, the call is translated into a special JVM feature: "invokedynamic". Without "invokedynamic" 
a special custom interface would have to be created for each single function call and the generated byte code size would go 
through the roof. "invokedynamic" is great, except it does have certain performance costs. 

Scalqa provides heavy overloads for the most important ~ operations, where the function code is inlined into 
specially generated classes, which are called without use of "invokedynamic". This certainly produces 
a lot more byte code, but is crucial when ultimate performance is required. The methods like: `filter`, `map`, `flatMap`, `fold`, `foreach`,
have heavy counterparts typed in upper case: `FILTER`, `MAP`, `FLAT_MAP`, `FOLD`, `FOREACH`.

Heavy methods generally make sense on streams with over 1000 elements. Here is a benchmark example, on what can be expected:  
```
val array : Array[String] = (1 <> 300).~.map(_.toString).toArray

J.Benchmark(
  ("Iterator", () => array.iterator.filter(_.length%2==0).flatMap (_ => array).map(_.length).fold(0)(_ + _)),
  ("~",        () => array.~       .filter(_.length%2==0).flatMap (_ => array).map(_.length).fold(0)(_ + _)),
  ("Heavy ~",  () => array.~       .FILTER(_.length%2==0).FLAT_MAP(_ => array).MAP(_.length).FOLD(0)(_ + _)),
)
```
```
// Output
Final Result. Total length is about 12 secs
--- -------- ------- --- ------- --- ---------
Num Name     Ops/Sec %   Memory  %   Avg Value
--- -------- ------- --- ------- --- ---------
1   Iterator 2.1k    21  429.8kB 100 71280.0
2   ~        3.6k    36  351B    0   71280.0
3   Heavy ~  9.8k    100 3.2kB   0   71280.0
--- -------- ------- --- ------- --- ---------
```  

## Specialized for Primitives

[~](../../api/scalqa/val/Stream.html) has specialized implementations for most important operations, 
so the streams of primitive or opaque primitive values can be processed without 
value boxing. 

Each primitive type has a generic implementation:
[Byte.G.~](../../api/scalqa/lang/byte/g/Stream.html),
[Int.G.~](../../api/scalqa/lang/int/g/Stream.html),
[Double.G.~](../../api/scalqa/lang/double/g/Stream.html), etc, where specialized methods are defined. The defined
specialized operation overrides same name generic operation, providing all the unboxed processing benefits.
If specialized operation is not available, the execution will fall back on generic implementation.

For example, let's consider a stream of [Percent](../../api/scalqa/gen/util/Percent.html) values, 
which are based on primitive Double:
```
   val s: Percent.~ = (1 <> 1000).~.map(_.Percent)
   s.docTree.tp

   // Prints  
   scalqa.lang.int.z.stream.map$Doubles@3ge6{raw=Double,fromRaw=Int,size=1000}
     scalqa.lang.int.z.Range$Stream@nvp{raw=Int,size=1000,from=1}

```
Notice that printout suggests some customized implementation involving Int and Double  

Just how important specialization is: let's benchmark stream with Scala Iterator, which is
obviously not specialized:
 
```
J.Benchmark(
  () => (1 to 1000).iterator.map(_.Percent).sum,
  () => (1 <> 1000).~       .map(_.Percent).sum,
  () => (1 <> 1000).~       .MAP(_.Percent).sum,
)
```
```
// Output:
Final Result. Total length is about 12 secs
--- ------- --- ------ --- ----------
Num Ops/Sec %   Memory %   Last Value
--- ------- --- ------ --- ----------
1   38.9k   3   60.5kB 100 500500.0
2   176.7k  14  126B   0   500500.0
3   1.2m    100 107B   0   500500.0
--- ------- --- ------ --- ----------
```

The obvious benefit is the speed increase, but more subtle advantage is low memory consumption, 
which on a busy server JVM might be even more important due to bottlenecks related to garbage collection.