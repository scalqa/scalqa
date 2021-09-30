package scalqa; package `val`; package stream; package _use; package _transform; import language.implicitConversions

import z._use.{ _transform as _Z, transform as Z }

transparent trait _toCollections:

  extension[A] (inline x: ~[A])
    @tn("pack") inline def ><                                   (using inline A:Specialized[A]): A.><              = Z.toPack(x)
    /**/        inline def toIdx                                (using inline A:Specialized[A]): A.Idx             = Z.toIdx(x)
    /**/        inline def toSet                                (using inline A:Specialized[A]): A.Set             = Z.toSet(x)
    /**/        inline def toBuffer                             (using inline A:Specialized[A]): A.Buffer          = Z.toBuffer(x)
    /**/        inline def toArray         (using inline t:ClassTag[A],inline A:Specialized[A]): A.Array           = _Z.toArray(x)
    /**/        inline def toLookupBy[KEY](inline f: A=>KEY)(using inline KEY:Specialized[KEY]): KEY.Lookup[A]     = _Z.toLookup(x,f)

  extension[KEY,VALUE] (inline x: ~[(KEY,VALUE)])
    /**/        inline def toLookup                         (using inline KEY:Specialized[KEY]): KEY.Lookup[VALUE] = _Z.toLookup(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
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
@def toIdx -> Convert to Idx

        Returns stream elements as [[scalqa.val.Idx Idx]]

@def toBuffer -> Convert to Buffer

        Returns stream elements as [[scalqa.val.Buffer Buffer]]

@def >< -> Pack elements

        Returns stream elements as ><

@def toSet -> Convert to unique collection

        Returns stream elements as [[scalqa.val.Set Set]]

@def toArray -> Convert to Array

        Returns stream elements as Array

        ```
          val a : Array[Int] =  (1 <> 10).~.toArray
        ```
*/
