---
layout: doc-page
title: Operator Types
---

There are four Scalqa types, which are so basic, they are represented as operators without regular alphanumeric names:

 - [~](../../api/scalqa/val/Stream.html) is value stream
 - [<>](../../api/scalqa/val/Range.html) is value range
 - [><](../../api/scalqa/val/Pack.html)  is value pack
 - [\/](../../api/scalqa/gen//request/VOID.html) is a general request for a void instance.
     
There are also same named operator methods to construct some of those types. 
It is important to quickly grasp how these work, otherwise Scalqa code would not feel intuitive.

It is very easy to create a <> range type, because <> method is attached to all ordered types. 

```
    val rangeOfChars   : <>[Char]   = 'a' <> 'z'                     // Creating Char range from 'a' to 'z'
    val rangeOfInts    : <>[Int]    = 1 <>> 10                       // Creating Int range from 1 to 9 (10 exclusive)
    val rangeOfStrings : <>[String] = "a" <> "aaaaaaaaa"             // Creating String range from "a" to "aaaaaaaaa"
```

Range can be converted to a ~ (stream) of elements. 

```
    val streamOfChars  : ~[Char]    = rangeOfChars.~                    // Creating stream of Char
    val streamOfInts   : ~[Int]     = rangeOfInts.~.filter(_ % 2 == 0)  // Creating stream of Int and filter even numbers only
    val streamOfStrings: ~[String]  = rangeOfStrings.step_~(_ + "a")    // Creating stream of Strings with a step function
    val voidStream     : ~[Double]  = \/                                // Getting a void stream of Doubles
```

Stream elements can be packed into an immutable collection. 

```
    val packOfChars    : ><[Char]   = streamOfChars.><                
    val packOfInts     : ><[Int]    = streamOfInts.><                 
    val packOfStrings  : ><[String] = streamOfStrings.filter(_.length < 5).><                 
    val voidPack       : ><[Double] = \/                 
```

Every collection can have its elements streamed, processed, and re-packed.   

```
    val packOfChars2   : ><[Char]   = packOfChars.~.filter(_ < 's').><      
    val packOfInts2    : ><[Int]    = packOfInts.~.map(_ * 10).><           
    val packOfStrings2 : ><[String] = packOfStrings.~.map(_.toUpperCase).><           
```

These manipulations are also the basis for most examples in Scalqa documentation.  





