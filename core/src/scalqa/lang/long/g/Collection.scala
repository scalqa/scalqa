package scalqa; package lang; package long; package g; import language.implicitConversions

trait Collection[A<:RAW] extends Val.Collection[A] with Able.Contain[A] with any.raw.Specialized.OnLong:
  @tn("stream") def ~             : Stream[A]
  @tn("pack")   def ><            : Pack[A]   = Pack.fromStream(this.~)
  /**/          def contains(v: A): Boolean   = this.~.takeOnly(v).readRaw_?

object Collection:
  implicit inline def implicitRequest[A<:RAW](inline v: \/): Collection[A] = Pack.void

  extension[A<:RAW,T,STM<: ~~.AnyType[T]](inline x: Collection[A])
    /**/                                       inline def map    [B>:T](inline f: A=> B)   (using inline s: Given.StreamTag[B,STM]): STM       = g.Stream.map[A,T,STM](x.~)[B](f)(using s)
    /**/                                       inline def flatMap[B>:T](inline f: A=> ~[B])(using inline s: Given.StreamTag[B,STM]): STM       = g.Stream.flatMap[A,T,STM](x.~)[B](f)(using s)
  extension[A<:RAW]  (inline x: Collection[A]) inline def withFilter(inline f: Fun.Filter[A])                                      : Stream[A] = x.~.filter(f)
  extension[A<:RAW,U](inline x: Collection[A]) inline def foreach(   inline f: Fun.Consume[A,U])                                   : Unit      = x.~.foreach(f)

  // ***********************************************************************************************************************************
  trait Mutable[A<:RAW] extends Collection[A] with Val.Collection.M[A]:
    /**/                 def add(v: A): Unit
    @tn("_add") override def += (v: A): this.type = { add(v); this }

  object Mutable:
    implicit inline def implicitRequest[A<:RAW](inline v: NEW): Mutable[A] = new Buffer()

  // ***********************************************************************************************************************************
  import scala.collection.immutable.LongMap
  class StableSet[A<:RAW] private(real: LongMap[Unit]) extends Val.StableSet[A] with Collection[A]:
    type THIS_TYPE = StableSet[A]
    /**/          def size               : Int        = real.size
    /**/ override def contains(v: A)     : Boolean    = real.contains(v.real)
    @tn("stream") def ~                  : Stream[A]  = real.keysIterator.~.raw.map(_.cast[A])
    /**/          def join(v: A)         : StableSet[A] = new StableSet(real.updated(v.real,()))
    /**/          def joinAll(v: ~[A])   : StableSet[A] = new StableSet(real.concat(v.map(v => (v.real,())).iterator))

  object StableSet:
    /**/            def apply[A<:RAW](v: A *)          : StableSet[A] = StableSet(v)
    /**/            def apply[A<:RAW](v: ~[A])         : StableSet[A] = new StableSet(LongMap.from(v.map(v => (v.real,())).iterator))
    @tn("getVoid")  def void [A<:RAW]                  : StableSet[A] = zVoid.cast[StableSet[A]]; private object zVoid extends StableSet(LongMap.empty) with Gen.Void
    implicit inline def implicitRequest[A<:RAW](inline v: \/): StableSet[A] = void
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

@def implicitRequest -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/