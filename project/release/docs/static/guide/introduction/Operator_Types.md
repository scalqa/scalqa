---
layout: doc-page
title: Operator Types
---

There are three Scalqa types, which are so basic, they are represented as operators without regular alphanumeric names:

 - [~](../../api/scalqa/val/Stream.html) is value stream
 - [<>](../../api/scalqa/val/Range.html) is value range
 - [><](../../api/scalqa/val/Pack.html)  is value pack
     
There are also same named operator methods to construct those types. 
It is important to quickly grasp how these work, otherwise Scalqa code would not feel intuitive.

It is very easy to create a <> range type, because <> method is attached to all ordered types. 

```
    val charRange   : <>[Char]   = 'a' <> 'z'                     // Creating Char range from 'a' to 'z'
    val intRange    : <>[Int]    = 1 <>> 10                       // Creating Int range from 1 to 9 (10 exclusive)
    val stringRange : <>[String] = "a" <> "aaaaaaaaa"             // Creating String range from "a" to "aaaaaaaaa"
```

Range can be converted to a ~ (stream) of elements. 

```
    val charStream  : ~[Char]    = charRange.~                    // Creating stream of Char
    val intStream   : ~[Int]     = intRange.~.filter(_ % 2 == 0)  // Creating stream of Int and filter even numbers only
    val stringStream: ~[String]  = stringRange.step_~(_ + "a")    // Creating stream of Strings with a step function
```

Stream elements can be packed into an immutable collection. 

```
    val charPack    : ><[Char]   = charStream.><                
    val intPack     : ><[Int]    = intStream.><                 
    val stringPack  : ><[String] = stringStream.filter(_.length < 5).><                 
```

Every collection can have its elements streamed, processed, and re-packed.   

```
    val charPack2   : ><[Char]   = charPack.~.filter(_ < 's').><      
    val intPack2    : ><[Int]    = intPack.~.map(_ * 10).><           
    val stringPack2 : ><[String] = stringPack.~.map(_.toUpperCase).><           
```

These manipulations are the basis for most examples in Scalqa documentation.  





