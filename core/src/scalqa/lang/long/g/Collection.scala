package scalqa; package lang; package long; package g; import language.implicitConversions

trait Collection[A<:Raw] extends Val.Collection[A] with Able.Contain[A] with any.z.PrimitiveTag.Long:
  @tn("stream") def ~             : Stream[A]
  @tn("pack")   def ><            : Pack[A]   = Pack.fromStream(this.~)
  /**/          def contains(v: A): Boolean   = this.~.takeOnly(v).readRaw_?

object Collection:
  implicit inline def implicitFrom[A<:Raw](inline v: \/): Collection[A] = Pack.void

  extension[A<:Raw](inline x: Collection[A])
    inline def map    [B](inline f: A=> B)   (using inline B:Specialized[B]): B.~    = x.~.map(f)
    inline def flatMap[B](inline f: A=> ~[B])(using inline B:Specialized[B]): B.~    = x.~.flatMap(f)
    inline def withFilter(inline f: Fun.Filter[A])                          : G.~[A] = x.~.filter(f)
    inline def foreach[U](inline f: Fun.Consume[A,U])                       : Unit   = x.~.foreach(f)

  // ***********************************************************************************************************************************
  trait Mutable[A<:Raw] extends Collection[A] with Val.Collection.M[A]:
    def add(v: A): Unit

  object Mutable:
    implicit inline def implicitFrom[A<:Raw](inline v: NEW): Mutable[A] = new Buffer()

  // ***********************************************************************************************************************************
  import scala.collection.immutable.LongMap
  class StableSet[A<:Raw] private(real: LongMap[Unit]) extends Val.StableSet[A] with Collection[A]:
    type THIS_TYPE = StableSet[A]
    /**/          def size               : Int          = real.size
    /**/ override def contains(v: A)     : Boolean      = real.contains(v.real)
    @tn("stream") def ~                  : Stream[A]    = real.keysIterator.~.raw.map(_.cast[A])
    /**/          def join(v: A)         : StableSet[A] = new StableSet(real.updated(v.real,()))
    /**/          def joinAll(v: ~[A])   : StableSet[A] = new StableSet(real.concat(v.map(v => (v.real,())).iterator))

  object StableSet:
    /**/            def apply[A<:Raw](v: A *)      : StableSet[A] = StableSet(v)
    /**/            def apply[A<:Raw](v: ~[A])     : StableSet[A] = new StableSet(LongMap.from(v.map(v => (v.real,())).iterator))
    @tn("getVoid")  def void [A<:Raw]              : StableSet[A] = zVoid.cast[StableSet[A]]; private object zVoid extends StableSet(LongMap.empty) with Gen.Void
    implicit inline def implicitFrom[A<:Raw](v: \/): StableSet[A] = void
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

@def implicitFrom    -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/