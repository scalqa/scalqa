package scalqa; package lang; package boolean; package g; import language.implicitConversions

trait Collection[A<:Raw] extends Val.Collection[A] with Able.Contain[A] with any.z.PrimitiveTag.Boolean:
  @tn("stream") def ~             : Stream[A]
  /**/          def contains(v: A): Boolean   = this.~.takeOnly(v).readRaw_?

object Collection:
  implicit inline def implicitRequest[A<:Raw](v: \/): Collection[A] = Pack.void

  trait Mutable[A<:Raw] extends Collection[A] with Val.Collection.M[A]:
    def add(v: A): Unit

  object Mutable:
    implicit inline def implicitRequest[A<:Raw](inline v: NEW): Mutable[A] = new Buffer()

  // ------------------------------------------------------------------------------------------------------------------------------------------
  extension[A<:Raw](inline x: Collection[A])
    inline def map    [B](inline f: A=> B)   (using inline B:Specialized[B]): B.~    = x.~.map(f)
    inline def flatMap[B](inline f: A=> ~[B])(using inline B:Specialized[B]): B.~    = x.~.flatMap(f)
    inline def withFilter(inline f: Fun.Filter[A])                          : G.~[A] = x.~.filter(f)
    inline def foreach[U](inline f: Fun.Consume[A,U])                       : Unit   = x.~.foreach(f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Collection -> ### Boolean Specialized Generic Collection

    To be used with Boolean based opaque values.

*/