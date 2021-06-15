package scalqa; package `val`; package stream; package _Use; import language.implicitConversions

import scala.{ collection as SC }
import java.{ util as JU }

transparent trait _transformTo:

  extension[A] (x: ~[A])
    @tn("pack") def ><                                        : ><[A]                = pack.z.ArrayPack.fromStream[A](x)
    /**/        def iterator                                  : Iterator[A]          = z.use.transformTo.Iterator(x)
    /**/        def makeString(sep:String= \/)(using t :Given.DocTag[A]): String               = String.Builder(256).^(b => x.foreachIndexed((i,v) =>{ if (i>0) b +=sep; b +=t.tag(v)})).tag
    /**/        def toIdx                                     : Idx[A]               = pack.z.ArrayPack.fromStream[A](x)
    /**/        def toBuffer                                  : Buffer[A]            = new Any.Ref.Buffer[A](x)
    /**/        def toSet                                     : StableSet[A]         = StableSet(x)
    /**/        def toProduct                                 : Product              = x.><.toProduct_^
    /**/        def toSeq                                     : IndexedSeq[A]        = z.use.transformTo.Seq(x)
    /**/        def toArray               (using ClassTag[A]) : Array[A]             = {val b=Buffer.accessible(x.size_?).^(_ ++= x); var a:Array[A]=b.access; if(a.length!=b.size) a=a.copySize(b.size); a.cast[Array[A]]}
    /**/        def toList                                    : List[A]              = {var l: List[A] = Nil; x.FOREACH(v => l = l :+ v); l }
    /**/        def toVector                                  : Vector[A]            = {var b=new scala.collection.immutable.VectorBuilder[A](); x.FOREACH(b += _); b.result }
    /**/        def toJavaList                                : JU.List[A]           = x.toBuffer.toJavaList_^
    /**/ inline def toJavaIterator                            : JU.Iterator[A]       = z.use.transformTo.JavaIterator(x)
    /**/ inline def toJavaSpliterator(inline splitSize: Int)  : JU.Spliterator[A]    = z.use.transformTo.JavaSpliterator(x,splitSize)
    /**/        def toJavaStream(parallel: Boolean = false)   : JU.stream.Stream[A]  = JU.stream.StreamSupport.stream(x.toJavaSpliterator(1), parallel)
    /**/        def toText                    (using t :Given.DocTag[A]): String               = z.use.print.toText(x,false)
    /**/        def toLookupBy[K](f: A => K)                  : Lookup[K,A]          = {val l=Lookup.Mutable[K,A](); x.FOREACH(v => l.put(f(v),v)); l}
    /**/        def toMapBy[K](f: A => K)                     : Map[K,A]             = x.zipKey(f).toMap

  extension[A,B] (x: ~[(A,B)])
    /**/        def toLookup                                  : Lookup[A,B]          = Lookup.Stable[A,B](x)
    /**/        def toMap                                     : Map[A,B]             = SC.immutable.Map.from(x.iterator)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _transformTo -> ### Stream Transformation Interface

@def toLookup -> Convert to Lookup

        Returns a stream of tuples with (Key,Value) pairs as [[scalqa.val.Lookup Lookup]]

        ```
        val intLookup : Lookup[Int,Char] = ('A' <> 'F').~.zipKey(_.Int).toLookup

        intLookup.pair_~.TP   // Prints ~((69,E), (70,F), (65,A), (66,B), (67,C), (68,D))

        val charLookup : Lookup[Char,Int] = ('A' <> 'F').~.zipValue(_.Int).toLookup

        charLookup.pair_~.TP   // Prints ~((E,69), (F,70), (A,65), (B,66), (C,67), (D,68))
        ```

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
