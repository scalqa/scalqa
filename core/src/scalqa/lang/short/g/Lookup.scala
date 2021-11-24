package scalqa; package lang; package short; package g; import language.implicitConversions

import scala.collection.immutable.IntMap

trait Lookup[A<:Raw,+B] extends Val.Lookup[A,B]:
  override def getOpt(key: A): Val.Opt[B]
  override def get(v: A)     : B           = getOpt(v) or (throw ZZ.ME(v.tag))
  override def keyStream     : Stream[A]   = super.keyStream.raw

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
        def size           : Int               = real.size
        def getOpt(key: A) : Val.Opt[B]        = Val.Opt.fromScala(real.get(key.real))
        def pairStream     : Val.Stream[(A,B)] = real.iterator.stream.map((k,v)=>(k.cast[A],v))
        def put(k: A, v: B): Unit              = real.update(k.real,v)
        def clear          : Unit              = real.clear
        def remove(k: A)   : Val.Opt[B]        = Val.Opt.fromScala(real.remove(k.real))

  // ************************************************************************************************************
  class Stable[A<:Raw,B] private(real: IntMap[B]) extends Val.Lookup.Stable[A,B] with Lookup[A,B]:
    type THIS_TYPE = Stable[A,B]
    override def size                        : Int                = real.size
    override def getOpt(key: A)              : Val.Opt[B]         = Val.Opt.fromScala(real.get(key.real))
    override def keyStream                   : Stream[A]          = real.keysIterator.stream.raw.map(_.toShort.cast[A])
    override def pairStream                  : Val.Stream[(A, B)] = real.stream.map(v => (v._1.toShort.cast[A],v._2))
    override def join(k: A, v: B)            : Stable[A,B]        = new Stable(real.updated(k.real.toInt, v))
    override def joinAll(v:Val.Stream[(A,B)]): Stable[A,B]        = new Stable(real.concat(v.map(v => (v._1.real.toInt,v._2)).iterator))

  object Stable:
    /**/            def apply[A<:Raw,B](v: (A,B) *)         : Stable[A,B] = apply(v.stream)
    /**/            def apply[A<:Raw,B](v:Val.Stream[(A,B)]): Stable[A,B] = new Stable(IntMap.from(v.map(v => (v._1.real.toInt,v._2)).iterator))
    @tn("getVoid")  def void[A<:Raw,B]                      : Stable[A,B] = z_Void.cast[Stable[A,B]]; private object z_Void extends Stable(IntMap.empty) with Gen.Void
    implicit inline def implicitRequest[A<:Raw,B](v: \/)    : Stable[A,B] = void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Lookup -> ### Short Specialized Generic Lookup Collection

        To be used with Short based opaque values as lookup keys.

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/