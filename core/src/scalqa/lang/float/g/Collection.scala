package scalqa; package lang; package float; package g; import language.implicitConversions

trait Collection[A<:Raw] extends Val.Collection[A] with Able.Contain[A] with Raw.Specialized:
  @tn("stream") def ~             : Stream[A]
  @tn("pack")   def ><            : Pack[A]   = Pack.fromStream(this.~)
  /**/          def contains(v: A): Boolean   = this.~.takeOnly(v).readRaw_?

object Collection:
  implicit inline def implicitRequest[A<:Raw](inline v: \/): Collection[A] = Pack.void

  trait Mutable[A<:Raw] extends Collection[A] with Val.Collection.M[A]:
    /**/                 def add(v: A): Unit
    @tn("_add") override def += (v: A): this.type = { add(v); this }

  object Mutable:
    implicit inline def implicitRequest[A<:Raw](inline v: NEW): Mutable[A] = new Buffer()

  // ------------------------------------------------------------------------------------------------------------------------------------------
  extension[A<:Raw,T,STM<: ~~.AnyType[T]](inline x: Collection[A])
    /**/                                       inline def map    [B>:T](inline f: A=> B)   (using inline s: Given.StreamShape[B,STM]): STM       = g.Stream.map[A,T,STM](x.~)[B](f)(using s)
    /**/                                       inline def flatMap[B>:T](inline f: A=> ~[B])(using inline s: Given.StreamShape[B,STM]): STM       = g.Stream.flatMap[A,T,STM](x.~)[B](f)(using s)
  extension[A<:Raw]  (inline x: Collection[A]) inline def withFilter(inline f: Fun.Filter[A])                                        : Stream[A] = x.~.filter(f)
  extension[A<:Raw,U](inline x: Collection[A]) inline def foreach(   inline f: Fun.Consume[A,U])                                     : Unit      = x.~.foreach(f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
