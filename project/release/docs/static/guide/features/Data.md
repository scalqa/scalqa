---
layout: doc-page
title: Data
---

A data element in Scalqa is an opaque type often based on Java primitive, which is also provided with custom 
specialized framework of collections for efficient unboxed data processing.  

Defining data elements is quite easy, one just needs to select one of the following data roots and follow certain conventions:

- [Boolean.Custom.Data](../../api/scalqa/lang/boolean/custom/Data.html)
- [Byte.Custom.Data](../../api/scalqa/lang/byte/custom/Data.html) 
- [Char.Custom.Data](../../api/scalqa/lang/char/custom/Data.html) 
- [Short.Custom.Data](../../api/scalqa/lang/short/custom/Data.html) 
- [Int.Custom.Data](../../api/scalqa/lang/int/custom/Data.html) 
- [Long.Custom.Data](../../api/scalqa/lang/long/custom/Data.html) 
- [Float.Custom.Data](../../api/scalqa/lang/float/custom/Data.html) 
- [Double.Custom.Data](../../api/scalqa/lang/double/custom/Data.html) 
- [Any.Ref.Custom.Data](../../api/scalqa/lang/any/ref/custom/Data.html) 
- [String.Custom.Data](../../api/scalqa/lang/string/custom/Data.html) 

## Define

Let's create an example of data element 'Price', which would be based on a Float, behave like a Float, but be distinct from a Float.

He is the definition part (available in [samples](https://github.com/scalqa/samples/blob/master/src/example/data/PriceData.scala)):
```
type  Price = Price.opaque.`type`

extension (inline x: Double) inline def Dollars : Price = Price(x.Float)

object Price extends Float.Custom.Data.Numerical[Price]("Price"):
  inline   def apply(inline v: Float): Price  = v.asOpaque[Price]
  override def tag(v:Price)          : String =  "$"+v.roundTo(0.01.Dollars).toString

  extension (x: Price)
    def discount(p: Percent): Price   = x - p(x)
    def isNotExpensive      : Boolean = x < 100

  object opaque:
    opaque type `type` <: Any.Opaque.Float = Any.Opaque.Float

```
Let's explain the above line by line.  
```  
type Price = Price.opaque.`type`
```
The `Price` alias is the public name to be used. This definition can be next to the '`object Price`' or can be in some other 
more accessible place, like a root package (it is for developer to decide).

```  
extension (inline x: Double) inline def Dollars : Price = Price(x.Float)
```  
Extension creates a Double method Price constructor. This is an optional convenience pattern, but it is widely used in Scalqa. 
Double constructor will cover all primitives. 

```  
object Price extends Float.Custom.Data.Numerical[Price]("Price"):
```  
Object Price extends not only `Float.Custom.Data`, which would be sufficient to create a data element.
Price extends `Float.Custom.Data.Numerical`, which adds Float like behaviour with a set of 
[default methods](../../api/scalqa/lang/float/custom/data/Numerical$$_methods.html) provided. For example:
```
var p: Price = 19.99.Dollars

if(p > 10 && p <= 100.0) ()   // Like Float, Price can be compared to primitives   

p = p / 2 * 1.5F + 10 - 2     // Like Float, Price supports arithmetics with primitives

p = 12.0F                     // FAILS to compile, Price is NOT a Float
```
All the above operations are inlined and are as efficient, as if they were performed on Float value.

```
inline   def apply(inline v: Float): Price  = v.asOpaque[Price]
```
This is a standard constructor, which is inlined and does not have any overhead.

```
override def tag(v:Price)           : String =  "$"+v.roundTo(0.01.Dollars).toString
```
The `tag` is the new `.toString`. Here we define what the universal `.tag` method on type Price will return. If this method is
not overridden, the default behavior would convert Float toString.  

```
extension (x: Price)    
```
The extension section is where custom Price methods are defined. 

```
object opaque:   
```
The type definition must be inside another object to allow `inline` definitions in parent scope (this is a Scala3 limitation to go around).  


## Use

The Price object already contains specialized collections. 
To see what they are, look at [Float](../../api/scalqa/lang/Float$.html), the 'Alias' section contains same containers 
(but parameterized for Float)
  
Here are some usage examples:
```
val stream: Price.~          = (1 <> 10).~.map(_.Dollars)
val opt   : Price.Opt        = stream.readRaw_?
val pack  : Price.><         = stream.><
val idx   : Price.Idx        = pack
val col   : Price.Collection = pack
```

Let's find out how efficient those specialized containers are. 
To do so, we will benchmark them to Scala non-specialized collections: 
```
J.Benchmark(
  ("Scala ",      () => (1 to 1000).iterator.map(v => (v % 200 + 0.99).Dollars).filter(_.isNotExpensive).map(_.discount(5.Percent)).sum),
  ("Scalqa",      () => (1 <> 1000).~       .map(v => (v % 200 + 0.99).Dollars).filter(_.isNotExpensive).map(_.discount(5.Percent)).sum),
  ("Scalqa Heavy",() => (1 <> 1000).~       .MAP(v => (v % 200 + 0.99).Dollars).FILTER(_.isNotExpensive).MAP(_.discount(5.Percent)).sum),
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
    
  
 