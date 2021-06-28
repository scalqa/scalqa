package scalqa; package `val`; import collection.*; import language.implicitConversions

trait Collection[+A] extends gen.able.Stream[A] with gen.able.Size:
  @tn("stream") def ~    : ~[A]
  override      def size : Int

object Collection:
  /**/            def apply[A](v: A)                        : Collection[A]  = Pack(v)
  /**/            def apply[A](v1: A, v2: A)                : Collection[A]  = Pack(v1, v2)
  /**/            def apply[A](v1: A, v2: A, v3: A, vs: A*) : Collection[A]  = Pack(v1, v2, v3, vs *)
  @tn("getVoid")  def void[A]                               : Collection[A]  = Z.Void
  implicit inline def implicitRequestVoid[A](inline v: \/)  : Collection[A]  = void[A]
  /**/            def unapplySeq[A](v: Collection[A])       : Option[Seq[A]] = Some(v.~.toSeq)

  extension [A] (inline x: Collection[A])
    /**/                 inline def contains(inline v: A)          : Boolean       = Z.contains(x,v)
    @tn("readOnly_View") inline def readOnly_^                     : Collection[A] = Z.ReadOnly_View(x)
    /**/                 inline def withFilter(inline f:A=>Boolean): ~[A]          = x.~.take(f)
    @tn("map_View")      inline def map_^[B](inline f: A => B)     : Collection[B] = Z.ValueMap_View(x, f)
    /**/                 inline def map[B](inline f:A=>B)          : ~[B]          = x.~.map(f)
    /**/                 inline def flatMap[B](inline f:A=> ~[B])  : ~[B]          = x.~.flatMap(f)
    /**/                 inline def foreach[U](inline f: A=>U)     : Unit          = x.~.foreach(f)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Mutable[A]           = collection.Mutable[A];             inline def Mutable           = collection.Mutable
  type Observable[A]        = collection.Observable[A];          inline def Observable        = collection.Observable
  type ObservableMutable[A] = collection.ObservableMutable[A];   inline def ObservableMutable = collection.ObservableMutable
  type StableSet[A]         = collection.StableSet[A];           inline def StableSet         = collection.StableSet
  type M[A]                 = collection.Mutable[A];             inline def M                 = collection.Mutable
  type O[A]                 = collection.Observable[A];          inline def O                 = collection.Observable
  type OM[A]                = collection.ObservableMutable[A];   inline def OM                = collection.ObservableMutable


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Collection -> ### Value Collection

      Collection is the root of collections framework

      There are 3 main subtypes:

      - [[scalqa.val.Idx Idx]] - values can be accessed by Int index
      - [[scalqa.val.Lookup Lookup]] - values can be accessed by key lookup
      - [[scalqa.val.collection.StableSet StableSet]] - collection of unique values

@def ~  -> Stream elements

     Returns a stream of all collection elements

     Unless specifically defined, the order must be assumed as random

      ```
        val c = Collection(1,3,5,7)
        c.~.TP

        // Output
        ~(1, 3, 5, 7)
      ```

@def void  -> Get void instance

@def implicitRequestVoid -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
