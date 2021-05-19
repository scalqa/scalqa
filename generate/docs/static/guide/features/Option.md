---
layout: doc-page
title: Option
---

Value option (type [Opt](../../api/scalqa/val/Opt.html)) is the second most important Scalqa feature.

[Opt](../../api/scalqa/val/Opt.html) either contains a value or is empty (void), thus it 
naturally solves the problem of 'null' pointer exception. The large processing library attached to [Opt](../../api/scalqa/val/Opt.html)
allows to define complex value manipulations without the need to check if value is present, because this is constantly done by the library.

[Opt](../../api/scalqa/val/Opt.html) has implementation with zero runtime costs. It creates no object,  [Opt](../../api/scalqa/val/Opt.html)
is an opaque type of the value itself. Moreover, the option methods a fully inlined, so the resulting Java code will simply manipulate value, 
without any mention of option type.

Consider a method which optionally takes a String, and triples it by simple concatenation:

```
def triple(v: Opt[String]): Opt[String] = v.map(s => s + s + s)
```
If we do the same without option, we will have to check for emptiness: 
```
def triple(v: String): String = {
   var r: String = null
   if(v != null) 
      r = s + s + s
   r
}
```

and here is the first program compiled to Java, doing the same thing:
```
public Object length(Object v) {
    Object o = ZZ.None;
    if (v != ZZ.None) {
        String v = (String)v;
        o = v + v + v;
    }
    return o;
}
``` 
Basicly, [Opt](../../api/scalqa/val/Opt.html) greatly reduces boilerplate null checking code with almost no
execution cost. 

The use of [Opt](../../api/scalqa/val/Opt.html) in Scalqa is ubiquitous, there are very few program 
units without options.
Most notably [Opt](../../api/scalqa/val/Opt.html) is the key mechanism for reading 
[Stream](../../api/scalqa/val/Stream.html) values.

## Specialized for Primitives

Regular [Opt](../../api/scalqa/val/Opt.html) with its zero cost processing is extremely fast and sufficient
for most usage scenarios. But since Scalqa is focused on ultimate performance, 
each primitive type has a generic option implementation:
[Byte.G.Opt](../../api/scalqa/lang/byte/g/Opt.html),
[Int.G.Opt](../../api/scalqa/lang/int/g/Opt.html),
[Double.G.Opt](../../api/scalqa/lang/double/g/Opt.html), etc, where option is an opaque primitive value.

Let's benchmark heavy option processing for regular, specialized and Scala options:
```
val CNT = 100000
val array: Array[Int] = (0 <> CNT).~.toArray

J.Benchmark(
  ("Int.Opt",           () => { var sum=0.Percent; for(i <- 0<>CNT){ val o: Int.Opt     = array(i);       o.filter(_ % 2 == 0).map(_.Percent).foreach(sum += _)}; sum}),
  ("Opt[Int]",          () => { var sum=0.Percent; for(i <- 0<>CNT){ val o: Opt[Int]    = array(i);       o.filter(_ % 2 == 0).map(_.Percent).foreach(sum += _)}; sum}),
  ("scala.Option[Int]", () => { var sum=0.Percent; for(i <- 0<>CNT){ val o: Option[Int] = Some(array(i)); o.filter(_ % 2 == 0).map(_.Percent).foreach(sum += _)}; sum}),
)
```
```
// Output 
Final Result. Total length is about 12 secs
--- ----------------- ------- --- ------ --- -------------
Num Name              Ops/Sec %   Memory %   Last Value
--- ----------------- ------- --- ------ --- -------------
1   Int.Opt           15.5k   100 66B    0   2.499984464E9
2   Opt[Int]          1.5k    9   1.5mB  14  2.499984464E9
3   scala.Option[Int] 276     1   10.7mB 100 2.50005E9
--- ----------------- ------- --- ------ --- -------------
```

`Note.` Unlike streams, where specialized version extends regular, specialized options are not directly related 
to non-specialized. This is due to their opaque nature limitations. But they can always be converted with 
some extra cost:
```
var o:  Opt[Int] = 12
var io: Int.Opt  = o.raw
var oi: Opt[Int] = io.ref
```
  








