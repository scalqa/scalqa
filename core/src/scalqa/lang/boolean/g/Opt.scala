package scalqa; package lang; package boolean; package g; import language.implicitConversions; import G.Opt

object Opt extends z.opt._base:
  /**/           inline def apply[A<:RAW](inline v: A)          : Opt[A]  = if(v.cast[Boolean]) TRUE else FALSE
  @tn("getVoid") inline def void[A<:RAW]                        : Opt[A]  = -1.toByte.cast[Opt[A]]
  /**/           inline def TRUE      [A<:RAW]                  : Opt[A]  =  1.toByte.cast[Opt[A]]
  /**/           inline def FALSE     [A<:RAW]                  : Opt[A]  =  0.toByte.cast[Opt[A]]
  implicit       inline def implicitFromTrue [A<:RAW](inline v: true)   : Opt[A]  = TRUE[A]
  implicit       inline def implicitFromFalse[A<:RAW](inline v: false)  : Opt[A]  = FALSE[A]
  implicit       inline def implicitRequestVoid[A<:RAW](inline v: \/)   : Opt[A]  = void[A]
  implicit       inline def implicitFromValue [A<:RAW](inline v: A)     : Opt[A]  = apply(v)
  implicit       inline def implicitToBoolean [A<:RAW](inline v: Opt[A]): Boolean = v.real != void.real
  extension[A<:RAW](inline x: Opt[A])
    /**/               inline def real                                       : Byte       = x.cast[Byte]
    @tn("is_Void")     inline def isEmpty                                     : Boolean    = x.real == void.real
    @tn("not_Void")    inline def nonEmpty                                    : Boolean    = x.real != void.real
    /**/               inline def raw                                         : Opt[A]     = x
  extension[A<:RAW](x: Opt[A])
    /**/               inline def ref                                         : Val.Opt[A] = (if(x.isEmpty) ZZ.None else java.lang.Boolean.valueOf(x.real == TRUE[A].real)).cast[Val.Opt[A]]
    /**/               inline def filter(inline f: A => Boolean)              : Opt[A]     = x.take(f)
    /**/               inline def withFilter(inline f: A=>Boolean)            : Opt[A]     = x.take(f)
    /**/               inline def take(  inline f: A => Boolean)              : Opt[A]     = {var o:Opt[A]= \/; if(x!=o &&  f(x.`val`)) o=x; o}
    /**/               inline def takeOnly(inline v: A)                       : Opt[A]     = x.take(_.real == v.real)
    /**/               inline def drop(  inline f: A => Boolean)              : Opt[A]     = {var o:Opt[A]= \/; if(x!=o && !f(x.`val`)) o=x; o}
    /**/               inline def dropOnly(inline v: A)                       : Opt[A]     = x.drop(_.real == v.real)
    /**/               inline def dropVoid(using inline t: Self.VoidTag[A])       : Opt[A]     = if(x.nonEmpty && t.isVoid(x.`val`)) \/ else x
    /**/               inline def default(inline v: => A)                     : Opt[A]     = if(x.isEmpty) v       else x
    @tn("or_Opt")infix inline def or_?(inline that: => Opt[A])                : Opt[A]     = if(x.isEmpty) that    else x
    /**/         infix inline def or(inline default: => A)                    : A          = if(x.isEmpty) default else x.`val`
    /**/               inline def contains(v: A)                              : Boolean    = x == v.?
    /**/                      def get                                         : A          = { if(x.isEmpty) throw ZZ.EO(); x.`val` }
    @tn("stream")             def ~                                           : G.~[A]     = if(x.isEmpty) G.~.void else G.~(x.`val`)
    /**/               inline def forval[U]( inline f: A=>U)                  : Opt[A]     = { if(x.nonEmpty) f(x.`val`); x}
    /**/               inline def foreach[U](inline f: A=>U)                  : Opt[A]     = { if(x.nonEmpty) f(x.`val`); x}
    /**/         infix inline def fornil[U]( inline f: => U)                  : Opt[A]     = { if(x.isEmpty){var u:U=f }; x}
    /**/               inline def process[U,W](inline f:A=>U,inline fNil: =>W): Opt[A]     = { if(x.isEmpty){ val w:W=fNil} else f(x.`val`); x}
  //------------ Mapping ---------------------------------------------------------------------------------------------------------------------------------
  import Val.Opt.AnyType
  extension[A<:RAW,T,OPT<:AnyType[T]](inline x:Opt[A])
    /**/               inline def map    [B>:T](inline f: A => B)                    (using inline s: Self.OptTag[B,OPT]) : OPT    = z.opt.map(x,f,s)
  extension[A<:RAW,T](inline x:Opt[A])
    @tn("map_Opt")     inline def map_?  [OPT<:AnyType[T]](inline f: A=>OPT)             (using inline s: Self.OptTag[T,OPT]) : OPT    = z.opt.mapOpt(x,f,s)
    /**/               inline def flatMap[OPT<:AnyType[T]](inline f: A=>OPT)             (using inline s: Self.OptTag[T,OPT]) : OPT    = z.opt.mapOpt(x,f,s)
  extension[A<:RAW,B,C](inline x:Opt[A])
    /**/               inline def mix[OPT<:AnyType[C]](inline o:AnyType[B],inline f:(A,B)=>C)(using inline s: Self.OptTag[C,OPT]) : OPT    = z.opt.mixOpt(x,o,f,s)

  object opaque { opaque type `type`[+A<:RAW] <: Opaque.Byte = Byte & Opaque.Byte }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void      -> Get void instance
@def implicitRequestVoid -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/