---
layout: doc-page
title: Data
---

A data element in Scalqa is an opaque type often based on Java primitive, which is also provided with custom 
specialized framework of containers for efficient unboxed data processing.  

Defining data elements is quite easy, one just needs to select one of the following data roots and follow certain conventions:

- [Boolean.Opaque.Data](../../api/scalqa/lang/boolean/opaque/Data.html)
- [Byte.Opaque.Data](../../api/scalqa/lang/byte/opaque/Data.html) 
- [Char.Opaque.Data](../../api/scalqa/lang/char/opaque/Data.html) 
- [Short.Opaque.Data](../../api/scalqa/lang/short/opaque/Data.html) 
- [Int.Opaque.Data](../../api/scalqa/lang/int/opaque/Data.html) 
- [Long.Opaque.Data](../../api/scalqa/lang/long/opaque/Data.html) 
- [Float.Opaque.Data](../../api/scalqa/lang/float/opaque/Data.html) 
- [Double.Opaque.Data](../../api/scalqa/lang/double/opaque/Data.html) 
- [AnyRef.Opaque.Data](../../api/scalqa/lang/anyref/opaque/Data.html) 
- [String.Opaque.Data](../../api/scalqa/lang/string/opaque/Data.html) 

## Define

Let's create an example of data element 'Price', which would be based on a Float, behave like a Float, but be distinct from a Float.

He is the definition part (available in [samples](https://github.com/scalqa/samples/blob/master/src/example/opaque/PriceData.scala)):
```
type  Price = Price.TYPE.DEF

extension (inline x: Double) inline def Dollars : Price = Price(x.toFloat)

object Price extends Float.Opaque.Data.Numerical[Price]("Price"):
  inline   def apply(inline v: Float): Price  = v.toOpaque
  override def value_tag(v:Price)    : String = "$"+v.roundTo(0.01.Dollars).toString

  extension(x: Price)
    inline def discount(inline p: Percent): Price   = (x.real - p(x.real)).toOpaque
    inline def isNotExpensive             : Boolean = x < 100

  object TYPE:
    opaque type DEF <: Float.Opaque = Float.Opaque

```
Let's explain the above line by line.  
```  
type Price = Price.TYPE.DEF
```
The `Price` alias is the public name to be used. This definition can be next to the '`object Price`' or can be in some other 
more accessible place, like a root package (it is for developers to decide).

```  
extension (inline x: Double) inline def Dollars : Price = Price(x.toFloat)
```  
The extension creates a Double based Price constructor. This is an optional convenience pattern, but it is widely used in Scalqa. 
Double constructor will cover all primitives. 

```  
object Price extends Float.Opaque.Data.Numerical[Price]("Price"):
```  
Object Price extends not only [Float.Opaque.Data](../../api/scalqa/lang/float/opaque/Data.html), which would be sufficient to create a data element.
Price extends [Float.Opaque.Data.Numerical](../../api/scalqa/lang/float/opaque/data/Numerical.html), which adds Float like behaviour with a set of 
[default methods](../../api/scalqa/lang/float/opaque/data/Numerical$$_methods.html) provided. For example:
```
var p: Price = 19.99.Dollars

if(p > 10 && p <= 100.0) ()   // Like Float, Price can be compared to primitives   

p = p / 2 * 1.5F + 10 - 2     // Like Float, Price supports arithmetics with primitives

p = 12.0F                     // FAILS to compile, Price is NOT a Float
```
All the above operations are inlined and are as efficient, as if they were performed on Float value.

```
inline   def apply(inline v: Float): Price  = v.toOpaque
```
This is a standard constructor, which is inlined and does not have any overhead. The method `.toOpaque` is attached 
to base type within Data definition scope. 

```
override def value_tag(v:Price)           : String =  "$"+v.roundTo(0.01.Dollars).toString
```
The `value_tag` is the new `.toString`. Here we define what the universal `.tag` method on type Price will return. If this method is
not overridden, the default behavior would convert Float toString.  

```
extension (x: Price)    
```
The extension section is where custom Price methods are defined. 

## Use

The Price object already contains specialized collections. 
To see what they are, look at [Float](../../api/scalqa/lang/Float$.html), the 'Alias' section contains same containers 
(but parameterized for Float)
  
Here are some usage examples:
```
val s: Price.Stream     = (1 <> 10).stream.map(_.Dollars)
val o: Price.Opt        = stream.readRawOpt
val p: Price.Pack       = stream.pack
val i: Price.Idx        = pack
val c: Price.Collection = pack
```

Let's find out how efficient those specialized containers are. 
To do so, we will benchmark them to Scala non-specialized collections: 
```
J.Benchmark(
  ("Scala ",      () => (1 to 1000).iterator.map(v => (v % 200 + 0.99).Dollars).filter(_.isNotExpensive).map(_.discount(5.Percent)).sum),
  ("Scalqa",      () => (1 <> 1000).stream  .map(v => (v % 200 + 0.99).Dollars).filter(_.isNotExpensive).map(_.discount(5.Percent)).sum),
  ("Scalqa Heavy",() => (1 <> 1000).stream  .MAP(v => (v % 200 + 0.99).Dollars).FILTER(_.isNotExpensive).MAP(_.discount(5.Percent)).sum),
)
```
```
// Output
Final Result. Total length is about 12 secs
--- ------------ ------- --- ------ --- -----------------
Num Name         Ops/Sec %   Memory %   Last Value
--- ------------ ------- --- ------ --- -----------------
1   Scala        32.6k   11  59.1kB 100 23982.74999999997
2   Scalqa       77.1k   27  251B   0   23982.74999999997
3   Scalqa Heavy 279.2k  100 171B   0   23982.74999999997
--- ------------ ------- --- ------ --- -----------------
```

The conclusion is: boxing in Scala is quite efficient, it is only few times slower. The biggest difference is the memory consumption, 
which on heavy calculations could slow down the entire JVM. 
    
