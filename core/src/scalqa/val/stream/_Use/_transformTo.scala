package scalqa; package `val`; package stream; package _use; import language.implicitConversions

import z._use.{ _transformTo as _Z, transformTo as Z }
import java.{ util as J }

transparent trait _transformTo:

  extension[A] (inline x: ~[A])
    @tn("pack") inline def ><                                            : ><[A]               = pack.z.ArrayPack.fromStream[A](x)
    /**/        inline def makeString(inline sep:String= \/)
    /**/                                (using inline t :Any.Def.Doc[A]) : String              = Z.makeString(x,sep,t)
    /**/        inline def toIdx                                         : Idx[A]              = Z.toIdx(x)
    /**/        inline def toSet                                         : StableSet[A]        = StableSet(x)
    /**/        inline def toBuffer                                      : Buffer[A]           = new AnyRef.Buffer[A](x)
    /**/        inline def iterator                                      : Iterator[A]         = _Z.Scala.Iterator(x)
    /**/        inline def toArray          (using inline t:ClassTag[A]) : Array[A]            = _Z.Scala.Array(x)
    /**/        inline def toList                                        : List[A]             = _Z.Scala.List(x)
    /**/        inline def toVector                                      : Vector[A]           = _Z.Scala.Vector(x)
    /**/        inline def toSeq                                         : IndexedSeq[A]       = _Z.Scala.Seq(x)
    /**/        inline def toProduct                                     : Product             = _Z.Scala.Product(x)
    /**/        inline def toJavaList                                    : J.List[A]           = x.toBuffer.toJavaList_^
    /**/        inline def toJavaIterator                                : J.Iterator[A]       = _Z.Java.Iterator(x)
    /**/        inline def toJavaSpliterator(inline splitSize: Int)      : J.Spliterator[A]    = _Z.Java.Spliterator(x,splitSize)
    /**/        inline def toJavaStream(inline parallel: Boolean = false): J.stream.Stream[A]  = J.stream.StreamSupport.stream(x.toJavaSpliterator(1), parallel)
    /**/        inline def toText        (using inline t: Any.Def.Doc[A]): String              = z._use._print.toText(x,false)
    /**/        inline def toLookupBy[B](inline f: A => B)               : Lookup[B,A]         = Z.toLookupBy(x,f)
    /**/        inline def toMapBy[B](inline f: A => B)                  : Map[B,A]            = x.zipKey(f).toMap

  extension[A,B] (inline x: ~[(A,B)])
    /**/        inline def toLookup                                      : Lookup[A,B]         = Lookup.Stable[A,B](x)
    /**/        inline def toMap                                         : Map[A,B]            = scala.collection.immutable.Map.from(x.iterator)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _transformTo -> ### Stream Transformation Interface

@def toLookup -> Convert to Lookup

        Note. This operation is only available for streams holding tuples, like (KEY,VALUE)

        Converts a stream of tuples to [[scalqa.val.Lookup Lookup]]

        ```
        val intLookup : Lookup[Int,Char] = ('A' <> 'F').~.zipKey(_.toInt).toLookup

        intLookup.pair_~.TP   // Prints ~((69,E), (70,F), (65,A), (66,B), (67,C), (68,D))

        val charLookup : Lookup[Char,Int] = ('A' <> 'F').~.zipValue(_.toInt).toLookup

        charLookup.pair_~.TP   // Prints ~((E,69), (F,70), (A,65), (B,66), (C,67), (D,68))
        ```

@def toLookupBy -> Convert to Lookup

        Converts stream to a Lookup collection, where key is created with provided function

        ```
        val intLookup : Lookup[Int,Char] = ('A' <> 'F').~.toLookupBy(_.toInt)

        intLookup.pair_~.TP   // Prints ~((69,E), (70,F), (65,A), (66,B), (67,C), (68,D))
        ```

@def toMap -> Convert to scala.Map

        Note. This operation is only available for streams holding tuples, like (KEY,VALUE)

        Converts a stream of tuples to scala.Map

@def toMapBy -> Convert to scala.Map

        Converts stream to scala.Map, where key is created with provided function

@def iterator -> Iterator view

        Wraps current stream as `scala.collection.Iterator`

@def toSeq -> Convert to Seq

        Returns stream elements as `scala.collection.immutable.IndexedSeq`

@def toList -> Convert to List

        Returns stream elements as `scala.collection.immutable.List`

@def toVector -> Convert to Vector

        Returns stream elements as `scala.collection.immutable.Vector`

@def toProduct -> Convert to Product

        Returns stream elements as `scala.Product`

@def toArray -> Convert to Array

        Returns stream elements as Array

        ```
          val a : Array[Int] =  (1 <> 10).~.toArray
        ```

@def toIdx -> Convert to Idx

        Returns stream elements as [[scalqa.val.Idx Idx]]

@def toBuffer -> Convert to Buffer

        Returns stream elements as [[scalqa.val.Buffer Buffer]]

@def >< -> Pack elements

        Returns stream elements as ><

@def toSet -> Convert to unique collection

        Returns stream elements as [[scalqa.val.collection.StableSet StableSet]]

@def toJavaList -> Convert to Java List

        Returns stream elements as `java.util.List`

@def toJavaIterator -> Convert to Java Iterator

        Wraps current stream as `java.util.Iterator`

@def toJavaSpliterator -> Convert to Java Spliterator

        Wraps current stream as `java.util.Spliterator`

@def toJavaStream -> Convert to Java Stream

        Wraps current stream as `java.util.stream.Stream`


@def makeString -> Convert ot String

     The result is a concatenation of all elements with given separator

     ```
         ('a' <> 'j').~.makeString()              // Returns abcdefghij

         ('a' <> 'j').~.makeString("|")           // Returns a|b|c|d|e|f|g|h|i|j

     ```
@def toText -> Elements as multi-line String

      Returns all elements as String formatted table

      If elements implement [[Able.Doc]], each 'doc' property value is placed in a different column

      If elements implement `scala.Product` (like all Tuples), each Product element is placed in a different column

      ```
         ('a' <> 'e').~.map(v => (v + "1", v + "2", v + "3", v + "4", v + "5")).TP

         // Output
         -- -- -- -- --
         ?  ?  ?  ?  ?
         -- -- -- -- --
         a1 a2 a3 a4 a5
         b1 b2 b3 b4 b5
         c1 c2 c3 c4 c5
         d1 d2 d3 d4 d5
         e1 e2 e3 e4 e5
         -- -- -- -- --
      ```
*/
