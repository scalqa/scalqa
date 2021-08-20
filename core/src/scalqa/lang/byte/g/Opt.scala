package scalqa; package lang; package byte; package g; import language.implicitConversions; import G.Opt

object Opt extends z.opt._base:
  @tn("getVoid") inline def void[A<:Raw]                               : Opt[A]  = 1000.cast[Opt[A]]
  implicit       inline def implicitFrom     [A<:Raw](inline v: \/)    : Opt[A]  = void[A]
  implicit       inline def implicitFromRaw  [A<:Raw](inline v: A)     : Opt[A]  = v.cast[Opt[A]]
  implicit       inline def implicitToBoolean[A<:Raw](inline v: Opt[A]): Boolean = v.real != void.real

  extension[A<:Raw](inline x: Opt[A])
    /**/               inline def real                                        : Short      = x.cast[Short]
    @tn("is_Void")     inline def isEmpty                                     : Boolean    = x.real == void.real
    @tn("not_Void")    inline def nonEmpty                                    : Boolean    = x.real != void.real
    /**/               inline def raw                                         : Opt[A]     = x
  extension[A<:Raw](x: Opt[A])
    /**/               inline def ref                                         : Val.Opt[A] = (if(x.isEmpty) ZZ.None else java.lang.Long.valueOf(x.real)).cast[Val.Opt[A]]
    /**/               inline def filter(inline f: A => Boolean)              : Opt[A]     = x.take(f)
    /**/               inline def withFilter(inline f: A=>Boolean)            : Opt[A]     = x.take(f)
    /**/               inline def take(  inline f: A => Boolean)              : Opt[A]     = {var o:Opt[A]= \/; if(x!=o &&  f(x.`val`)) o=x; o}
    /**/               inline def takeOnly(inline v: A)                       : Opt[A]     = x.take(_.real == v.real)
    /**/               inline def drop(  inline f: A => Boolean)              : Opt[A]     = {var o:Opt[A]= \/; if(x!=o && !f(x.`val`)) o=x; o}
    /**/               inline def dropOnly(inline v: A)                       : Opt[A]     = x.drop(_.real == v.real)
    /**/               inline def dropVoid(using inline d: Given.VoidDef[A])  : Opt[A]     = if(x.nonEmpty && d.value_isVoid(x.`val`)) \/ else x
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
  extension[A<:Raw,T,OPT<:AnyType[T]](inline x:Opt[A])
    /**/               inline def map    [B>:T](inline f: A => B)                            (using inline s: Given.OptShape[B,OPT]): OPT    = z.opt.map(x,f,s)
  extension[A<:Raw,T](inline x:Opt[A])
    @tn("map_Opt")     inline def map_?  [OPT<:AnyType[T]](inline f: A=>OPT)                 (using inline s: Given.OptShape[T,OPT]): OPT    = z.opt.mapOpt(x,f,s)
    /**/               inline def flatMap[OPT<:AnyType[T]](inline f: A=>OPT)                 (using inline s: Given.OptShape[T,OPT]): OPT    = z.opt.mapOpt(x,f,s)
  extension[A<:Raw,B,C](inline x:Opt[A])
    /**/               inline def mix[OPT<:AnyType[C]](inline o:AnyType[B],inline f:(A,B)=>C)(using inline s: Given.OptShape[C,OPT]): OPT    = z.opt.mixOpt(x,o,f,s)

  object OPAQUE:
    opaque type TYPE[+A<:Raw] <: Short.Opaque = Short.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void      -> Get void instance

@def implicitFrom    -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/