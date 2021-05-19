package scalqa; package `val`; import collection.*; import language.implicitConversions

trait Coll[+A] extends gen.able.Stream[A] with gen.able.Size:
  @tn("stream") def ~    : ~[A]
  /**/          def size : Int

object Coll:
  /**/            def apply[A](v: A)                        : Coll[A]  = ???
  /**/            def apply[A](v1: A, v2: A)                : Coll[A]  = ???
  /**/            def apply[A](v1: A, v2: A, v3: A, vs: A*) : Coll[A]  = ???
  @tn("getVoid")  def void[A]                               : Coll[A]  = ???
  implicit inline def implicitRequestVoid[A](inline v: \/)  : Coll[A]  = ???
  /**/            def unapplySeq[A](v: Coll[A])       : Option[Seq[A]] = ???

  extension [A] (inline x: Coll[A])
    /**/                 inline def mapp[B](inline f: A => B)     : Coll[B]       = ???



/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Coll -> ### Value Coll

      Coll is the root of collections framework

      There are 3 main subtypes:

      - [[scalqa.val.Idx Idx]] - values can be accessed by Int index
      - [[scalqa.val.Lookup Lookup]] - values can be accessed by key lookup
      - [[scalqa.val.collection.StableSet StableSet]] - collection of unique values

@def ~  -> Stream elements

     Returns a stream of all collection elements

     Unless specifically defined, the order must be assumed as random

      ```
        val c = Coll(1,3,5,7)
        c.~.TP

        // Output
        ~(1, 3, 5, 7)
      ```

@def void  -> Get void instance

@def implicitRequestVoid -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
