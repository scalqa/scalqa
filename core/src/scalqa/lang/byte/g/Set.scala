package scalqa; package lang; package byte; package g; import language.implicitConversions

import scala.collection.immutable.IntMap

class Set[A<:Raw] private(real: IntMap[Unit]) extends Val.Set[A] with Collection[A]:
  type THIS_TYPE = Set[A]
  /**/          def size               : Int       = real.size
  /**/ override def contains(v: A)     : Boolean   = real.contains(v.real)
  @tn("stream") def ~                  : Stream[A] = real.keysIterator.~.raw.map(_.toByte.cast[A])
  /**/          def join(v: A)         : Set[A]    = new Set(real.updated(v.real.toInt,()))
  /**/          def joinAll(v: ~[A])   : Set[A]    = new Set(real.concat(v.map(v => (v.real.toInt,())).iterator))

object Set:
  /**/                  def apply[A<:Raw](v: A *)       : Set[A] = new Set(IntMap.from(v.map(v => (v.real.toInt,()))))
  /**/                  def fromStream[A<:Raw](v: ~[A]) : Set[A] = new Set(IntMap.from(v.map(v => (v.real.toInt,())).iterator))
  @tn("getVoid") inline def void[A<:Raw]                : Set[A] = z_Void.cast[Set[A]]
  implicit       inline def implicitRequest[A<:Raw](v: \/) : Set[A] = void

  // **************************************************
  object z_Void extends Set(IntMap.empty) with Gen.Void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Set -> ### Byte Specialized Generic Set

        To be used with Byte based opaque values.

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/