package scalqa; package `val`; package stream; package _use; package _transform; import language.implicitConversions

import z._use.{ _transform as _Z, transform as Z }

transparent trait _toScala:

  extension[A] (inline x: ~[A])
    inline def iterator                                                     : Iterator[A]   = _Z.toScala.Iterator(x)
    inline def toList                                                       : List[A]       = _Z.toScala.List(x)
    inline def toVector                                                     : Vector[A]     = _Z.toScala.Vector(x)
    inline def toSeq                                                        : IndexedSeq[A] = _Z.toScala.Seq(x)
    inline def toMapBy[B](inline f: A => B)                                 : Map[B,A]      = x.zipKey(f).toMap
    inline def toProduct                                                    : Product       = _Z.toScala.Product(x)
    inline def toArray (using inline t:ClassTag[A],inline A:Specialized[A]) : A.Array

  extension[KEY,VALUE](inline x: ~[(KEY,VALUE)])
    inline def toMap                                                        : Map[KEY,VALUE]= scala.collection.immutable.Map.from(x.iterator)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

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

*/
