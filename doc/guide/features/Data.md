---
layout: doc-page
title: Data
---

A data element in Scalqa is an opaque type often based on Java primitive, which is also provided with custom 
specialized framework of collections for efficient unboxed data processing.  

Defining data elements is quite easy, one just needs to select one of the following data roots and follow certain conventions:

- [Boolean.Custom.Data](../../api/scalqa/def/boolean/custom/Data.html)
- [Byte.Custom.Data](../../api/scalqa/def/byte/custom/Data.html) 
- [Char.Custom.Data](../../api/scalqa/def/char/custom/Data.html) 
- [Short.Custom.Data](../../api/scalqa/def/short/custom/Data.html) 
- [Int.Custom.Data](../../api/scalqa/def/int/custom/Data.html) 
- [Long.Custom.Data](../../api/scalqa/def/long/custom/Data.html) 
- [Float.Custom.Data](../../api/scalqa/def/float/custom/Data.html) 
- [Double.Custom.Data](../../api/scalqa/def/double/custom/Data.html) 
- [Any.Ref.Custom.Data](../../api/scalqa/def/any/ref/custom/Data.html) 
- [String.Custom.Data](../../api/scalqa/def/string/custom/Data.html) 

## Define

Let's create an example of data element 'Price', which would be based on a Double, behave like a Double, but be distinct from a Double.

He is the definition part:
```
type  Price = Price.opaque.`type`

extension (inline x: Double) inline def Dollars : Price = x.asOpaque[Price]

object Price extends Double.Custom.Data.Number[Price]("Price"):
  inline   def apply(inline v: Double): Price  = v.asOpaque[Price]
  override def tag(v:Price)           : String =  "$"+v.roundTo(0.01.Dollars).toString

  extension (x: Price)
    def discount(p: Percent): Price   = x - p(x)
    def isExpensive         : Boolean = x >= 100

  object opaque:
    opaque type `type` <: Any.Opaque.Double = Any.Opaque.Double

```
Let's explain the above line by line.  
```  
type Price = Price.opaque.`type`
```
The `Price` alias is the public name to be used. This definition can be next to the '`object Price`' or can be in some other 
more accessible place, like a root package (it is for developer to decide).

```  
extension (inline x: Double) inline def Dollars : Price = x.asOpaque[Price]
```  
Extension creates a Double method Price constructor. This is an optional convenience pattern, but it is widely used in Scalqa. 

```  
object Price extends Double.Custom.Data.Number[Price]("Price"):
```  
Object Price extends not only `Double.Custom.Data`, which would be sufficient to create a data element.
Price extends `Double.Custom.Data.Number`, which adds Double like behaviour. For example:
```
var p: Price = 19.99.Dollars

if(p > 10 && p <= 100.0) ???  // Like Double, Price can be compared to primitives   

p = p / 2 * 1.5 + 10 - 2      // Like Double, Price supports arithmetics with primitives

p = 12.0                      // Assignment Fails, Price is NOT Double
```

`override def tag` is the new `.toString`. Here we define what the universal `.tag` method on type Price will return. If this method is
not overridden, the default behavior would convert Double toString.  

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
To see what they are, look at [Double](../../api/scalqa/def/Double$.html), the 'Alias' section contains same containers 
(but parameterized for Double)
  
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
  ("Scala ",      () => (1 to 10_000).iterator.map(v => (v % 200 + 0.99).Dollars).toList.iterator.map(_.discount(5.Percent)).filter(! _.isExpensive).sum),
  ("Scalqa",      () => (1 <> 10_000).~       .map(v => (v % 200 + 0.99).Dollars).><    .~       .map(_.discount(5.Percent)).filter(! _.isExpensive).sum),
  ("Scalqa Heavy",() => (1 <> 10_000).~       .MAP(v => (v % 200 + 0.99).Dollars).><    .~       .MAP(_.discount(5.Percent)).FILTER(! _.isExpensive).sum)
)
```
```
// Output
Final Result. Total length is about 12 secs
--- ------------ ------- --- ------- --- -----------------
Num Name         Ops/Sec %   Memory  %   Last Value
--- ------------ ------- --- ------- --- -----------------
1   Scala        1.8k    9   908.2kB 100 2607.750000000001
2   Scalqa       5.3k    27  74.0kB  8   2607.750000000001
3   Scalqa Heavy 19.2k   100 78.4kB  8   2607.750000000001
--- ------------ ------- --- ------- --- -----------------
```


    
  
 