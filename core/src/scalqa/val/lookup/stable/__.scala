package scalqa; package `val`; package lookup; import language.implicitConversions

abstract class Stable[A,B] private[scalqa]() extends Lookup[A,B]:
  type THIS_TYPE <: Stable[A,B]
  /**/                   def join(key: A, v: B)            : THIS_TYPE
  /**/                   def joinAll(v: ~[(A, B)])         : THIS_TYPE
  @tn("_join")    inline def + (inline key: A, inline v: B): THIS_TYPE   = join(key,v)
  @tn("_joinAll") inline def ++(inline v: ~[(A, B)])       : THIS_TYPE   = joinAll(v)

object Stable :
  /**/                 def apply[A,B](v: ~[(A, B)])        : Stable[A,B] = stable.z.AnyRef(v.iterator)
  /**/                 def apply[A,B](v: (A, B)*)          : Stable[A,B] = stable.z.AnyRef(v.iterator)
  @tn("getVoid")inline def void[A,B]                       : Stable[A,B] = stable.z.Void.cast[Stable[A,B]]
  implicit      inline def implicitFrom[A,B](v: \/)        : Stable[A,B] = void[A,B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Stable -> Stable is an immutable lookup collection


@def void  -> Get void instance

@def implicitFrom    -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

@def join -> Join key/value association

    Creates a new [[Stable]] with given key/value joined

@def + -> Alias for [[join]]

    Creates a new [[Stable]] with given key/value joined

@def joinAll -> Join multiple key/value associations

    Creates a new [[Stable]] with all given key/value pairs joined

@def ++ -> Alias for [[joinAll]]

    Creates a new [[Stable]] with all given key/value pairs joined

*/
