package scalqa; package `val`; import collection.*; import language.implicitConversions

trait Collection[+A] extends gen.able.Stream[A] with gen.able.Size:
  def stream: Stream[A]
  def size  : Int

object Collection:
  /**/                  def apply[A](v: A)                   : Collection[A]  = Pack(v)
  /**/                  def apply[A](v1:A, v2:A)             : Collection[A]  = Pack(v1, v2)
  /**/                  def apply[A](v1:A, v2:A, v3:A, vs:A*): Collection[A]  = Pack(v1, v2, v3, vs *)
  @tn("getVoid") inline def void[A]                          : Collection[A]  = VOID : Pack[A]
  /**/                  def unapplySeq[A](v: Collection[A])  : Option[Seq[A]] = Some(v.stream.toSeq)
  implicit       inline def implicitRequest[A](v:VOID)       : Collection[A]  = void[A]

  extension [A] (inline x: Collection[A])
    inline def ~~                               : Stream[A]      = x.stream  // For documentation benefit, same extension is inherited
    inline def contains(inline v: A)            : Boolean        = Z.contains(x,v)
    inline def withFilter(inline f: A=>Boolean) : Stream[A]      = x.stream.take(f)
    inline def mapView[B](inline f: A => B)     : Collection[B]  = Z.ValueMap_View(x, f)
    inline def map[B](inline f:A=>B)            : Stream[B]      = x.stream.map(f)
    inline def flatMap[B](inline f:A=>Stream[B]): Stream[B]      = x.stream.flatMap(f)
    inline def foreach[U](inline f: A=>U)       : Unit           = x.stream.foreach(f)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Mutable[A]           = collection.Mutable[A];             transparent inline def Mutable           = collection.Mutable
  type Observable[A]        = collection.Observable[A];          transparent inline def Observable        = collection.Observable
  type ObservableMutable[A] = collection.ObservableMutable[A];   transparent inline def ObservableMutable = collection.ObservableMutable
  type M[A]                 = collection.Mutable[A];             transparent inline def M                 = collection.Mutable
  type O[A]                 = collection.Observable[A];          transparent inline def O                 = collection.Observable
  type OM[A]                = collection.ObservableMutable[A];   transparent inline def OM                = collection.ObservableMutable


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

      - [[scalqa.val.Idx Idx]]       - values can be accessed by Int index
      - [[scalqa.val.Lookup Lookup]] - values can be accessed by key lookup
      - [[scalqa.val.Set Set]]       - collection of unique values

@def stream  -> Stream elements

     Returns a stream of all collection elements

     Unless specifically defined, the order must be assumed as random

      ```
        val c = Collection(1,3,5,7)
        c.stream.TP

        // Output
        Stream(1, 3, 5, 7)
      ```

@def ~~ -> Shortcut to .stream method

   Call is inlined and is equivalent to calling method "stream" itself.

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request VOID to get void instance of this type, thanks to this implicit conversion.

*/
