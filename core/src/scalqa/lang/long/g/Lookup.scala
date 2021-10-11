package scalqa; package lang; package long; package g; import language.implicitConversions

import scala.collection.immutable.LongMap

trait Lookup[A<:Raw,+B] extends Val.Lookup[A,B]:
  @tn("get_Opt")             def get_?(key: A) : Val.Opt[B]
  /**/              override def get(v: A)     : B           = get_?(v) or (throw ZZ.ME(v.tag))
  @tn("key_Stream") override def key_~         : Stream[A]   = super.key_~.raw

object Lookup:
  implicit def implicitRequest[A<:Raw,B](v: \/): Lookup[A,B] = Stable.void

  trait Mutable[A<:Raw,B] extends Lookup[A,B] with Val.Lookup.Mutable[A,B]:
    def put(key: A, value: B) : Unit
    def remove(key: A)        : Val.Opt[B]

  object Mutable:
    implicit inline def implicitRequest[A<:Raw,B](inline v: NEW): Mutable[A,B] = new X.Basic(J.initSize)
    object X:
      class Basic[A<:Raw,B](iSz: Int) extends Lookup.Mutable[A,B]:
        private val real = new collection.mutable.LongMap[B](iSz)
        /**/               def size           : Int          = real.size
        @tn("get_Opt")     def get_?(key: A)  : Val.Opt[B]   = Val.Opt.fromScala(real.get(key.real))
        @tn("pair_Stream") def pair_~         : ~[(A, B)]    = real.iterator.~.map((k,v)=>(k.cast[A],v))
        /**/               def put(k: A, v: B): Unit         = real.update(k.real,v)
        /**/               def clear          : Unit         = real.clear
        /**/               def remove(k: A)   : Val.Opt[B]   = Val.Opt.fromScala(real.remove(k.real))

  // ************************************************************************************************************
  class Stable[A<:Raw,B] private(real: LongMap[B]) extends Val.Lookup.Stable[A,B] with Lookup[A,B]:
    type THIS_TYPE = Stable[A,B]
    /**/                       def size                  : Int            = real.size
    @tn("get_Opt")             def get_?(key: A)         : Val.Opt[B]     = Val.Opt.fromScala(real.get(key.real))
    @tn("key_Stream") override def key_~                 : Stream[A]      = real.keysIterator.~.raw.map(_.cast[A])
    @tn("pair_Stream")         def pair_~                : ~[(A, B)]      = real.~.map(v => (v._1.cast[A],v._2))
    /**/                       def join(k: A, v: B)      : Stable[A,B] = new Stable(real.updated(k.real, v))
    /**/                       def joinAll(v: ~[(A, B)]) : Stable[A,B] = new Stable(real.concat(v.map(v => (v._1.real,v._2)).iterator))

  object Stable:
    /**/            def apply[A<:Raw,B](v: (A,B) *)      : Stable[A,B] = apply(v.~)
    /**/            def apply[A<:Raw,B](v: ~[(A,B)])     : Stable[A,B] = new Stable(LongMap.from(v.map(v => (v._1.real,v._2)).iterator))
    @tn("getVoid")  def void[A<:Raw,B]                   : Stable[A,B] = z_Void.cast[Stable[A,B]]; private object z_Void extends Stable(LongMap.empty) with Gen.Void
    implicit inline def implicitRequest[A<:Raw,B](v: \/) : Stable[A,B] = void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Lookup -> ### Long Specialized Generic Lookup Collection

        To be used with Long based opaque values as lookup keys.

@def void  -> Get void instance

@def implicitRequest -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/