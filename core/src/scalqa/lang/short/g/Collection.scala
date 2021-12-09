package scalqa; package lang; package short; package g; import language.implicitConversions

trait Collection[A<:Raw] extends Val.Collection[A] with Able.Contain[A] with any.z.PrimitiveTag.Short:
  def stream        : Stream[A]
  def contains(v: A): Boolean   = this.stream.takeOnly(v).readRawOpt

object Collection:
  implicit inline def implicitRequest[A<:Raw](v:VOID): Collection[A] = Pack.void

  extension[A<:Raw](inline x: Collection[A])
    inline def map    [B](inline f: A=> B)           (using inline s:Specialized[B]): s.Stream    = x.stream.map(f)
    inline def flatMap[B](inline f: A=>Val.Stream[B])(using inline s:Specialized[B]): s.Stream    = x.stream.flatMap(f)
    inline def withFilter(inline f: Fun.Filter[A])                                  : G.Stream[A] = x.stream.filter(f)
    inline def foreach[U](inline f: Fun.Consume[A,U])                               : Unit   = x.stream.foreach(f)

  // ******************************************************************************************************************************************
  trait Mutable[A<:Raw] extends Collection[A] with Val.Collection.M[A]:
    def add(v: A): Unit

  object Mutable:
    implicit inline def implicitRequest[A<:Raw](inline v: NEW): Mutable[A] = new Buffer()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Collection -> ### Short Specialized Generic Collection

    To be used with Short based opaque values.

@def implicitRequest   -> General void instance request \n\n It is possible to use general request VOID to get void instance of this type, thanks to this implicit conversion.

*/