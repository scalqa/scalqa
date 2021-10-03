package scalqa; package lang; package boolean; package g; import language.implicitConversions; import G.Opt

object Opt:
  /**/           inline def apply[A<:Raw](inline v: A)                        : Opt[A]     = if(v.cast[Boolean]) TRUE else FALSE
  @tn("getVoid") inline def void[A<:Raw]                                      : Opt[A]     = -1.toByte.cast[Opt[A]]
  /**/           inline def TRUE      [A<:Raw]                                : Opt[A]     =  1.toByte.cast[Opt[A]]
  /**/           inline def FALSE     [A<:Raw]                                : Opt[A]     =  0.toByte.cast[Opt[A]]
  implicit       inline def implicitFromVoidRequest [A<:Raw](v: \/)    : Opt[A]     = void[A]
  implicit       inline def implicitFromBooleanTrue [A<:Raw](inline v: true)  : Opt[A]     = TRUE[A]
  implicit       inline def implicitFromBooleanFalse[A<:Raw](inline v: false) : Opt[A]     = FALSE[A]
  implicit       inline def implicitFromBooleanRaw  [A<:Raw](inline v: A)     : Opt[A]     = apply(v)
  implicit       inline def implicitToBoolean       [A<:Raw](inline v: Opt[A]): Boolean    = v.real != void.real
  implicit       inline def implicitToValOpt        [A<:Raw](inline v: Opt[A]): Val.Opt[A] = v.ref
  extension[A<:Raw](inline x: Opt[A])
    /**/               inline def real                                        : Byte       = x.cast[Byte]
    /**/               inline def ref                                         : Val.Opt[A] = {val X=x; if(X.isEmpty) ZZ.None else java.lang.Boolean.valueOf(X.real == TRUE[A].real)}.cast[Val.Opt[A]]
    /**/               inline def isEmpty                                     : Boolean    = x.real == void.real
    /**/               inline def nonEmpty                                    : Boolean    = x.real != void.real
    /**/               inline def take(  inline f: A => Boolean)              : Opt[A]     = {val X=x; var o:Opt[A]= \/; if(X!=o &&  f(X.`val`)) o=X; o}
    /**/               inline def takeOnly(inline v: A)                       : Opt[A]     = x.take(_.real == v.real)
    /**/               inline def drop(  inline f: A => Boolean)              : Opt[A]     = {val X=x; var o:Opt[A]= \/; if(X!=o && !f(X.`val`)) o=X; o}
    /**/               inline def dropOnly(inline v: A)                       : Opt[A]     = x.drop(_.real == v.real)
    /**/               inline def default(inline v: => A)                     : Opt[A]     = {val X=x; if(X.isEmpty) v       else X      }
    @tn("or_Opt")infix inline def or_?(inline that: => Opt[A])                : Opt[A]     = {val X=x; if(X.isEmpty) that    else X      }
    /**/         infix inline def or(inline default: => A)                    : A          = {val X=x; if(X.isEmpty) default else X.`val`}
    /**/               inline def contains(v: A)                              : Boolean    = x == v.?
    /**/               inline def forval[U]( inline f: A=>U)                  : Opt[A]     = {val X=x; if(X.nonEmpty) f(X.`val`); X}
    /**/               inline def foreach[U](inline f: A=>U)                  : Opt[A]     = {val X=x; if(X.nonEmpty) f(X.`val`); X}
    /**/         infix inline def fornil[U]( inline f: => U)                  : Opt[A]     = {val X=x; if(X.isEmpty){ val u:U=f}; X}
    /**/               inline def process[U,W](inline f:A=>U,inline fNil: =>W): Opt[A]     = {val X=x; if(X.isEmpty){ val w:W=fNil} else f(X.`val`); X}
    /**/               inline def filter(inline f: A => Boolean)              : Opt[A]     = x.take(f)
    /**/               inline def withFilter(inline f: A=>Boolean)            : Opt[A]     = x.take(f)
    /**/               inline def raw                                         : Opt[A]     = x
    /**/               inline def mapIf(inline f:A=>Boolean,inline m:A=>A)    : Opt[A]     = x.map[A](v => if(f(v)) m(v) else v)
    /**/               inline def map[B](inline f:A=>B)                                                        (using inline B:Specialized[B]): B.Opt = z.opt.map(x,f)
    @tn("map_Opt")     inline def map_?  [B,OPT<:Any.Opt[B]](inline f: A=>OPT)(using inline o:Specialized.Opt[B,OPT], inline B:Specialized[B]): B.Opt = z.opt.mapOpt(x,f)
    /**/               inline def flatMap[B,OPT<:Any.Opt[B]](inline f: A=>OPT)(using inline o:Specialized.Opt[B,OPT], inline B:Specialized[B]): B.Opt = z.opt.mapOpt(x,f)
    /**/               inline def mix[B,C](inline o:Any.Opt[B],inline f:(A,B)=>C)                              (using inline C:Specialized[C]): C.Opt = z.opt.mix(x,o,f)
  extension[A<:Raw](x: Opt[A])
    /**/                      def dropVoid         (using d: Any.Def.Void[A]) : Opt[A]     = if(x.nonEmpty && d.value_isVoid(x.`val`)) \/ else x
    /**/                      def get                                         : A          = { if(x.isEmpty) throw ZZ.EO(); x.`val` }
    @tn("stream")             def ~                                           : G.~[A]     = if(x.isEmpty) G.~.void else G.~(x.`val`)

  object TYPE:
    opaque type DEF[+A<:Raw] <: Byte.Opaque = Byte.Opaque

  given zzCanEqualOpt[A<:Raw,B<:Raw](using CanEqual[A,B]): CanEqual[Opt[A],Opt[B]]  = CanEqual.derived
  given zzNameDef [A<:Raw :Any.Def.TypeName]             : Any.Def.TypeName[Opt[A]] = new any.z.opt.NameDef()
  given zzVoidDef [A<:Raw]                               : Any.Def.Void[Opt[A]]     = Z.OptEmptyDef.cast[Any.Def.Void[Opt[A]]]
  given zzEmptyDef[A<:Raw]                               : Any.Def.Empty[Opt[A]]    = Z.OptEmptyDef.cast[Any.Def.Empty[Opt[A]]]
  given zzDoc[A<:Raw :Any.Def.TypeName :Any.Def.Tag]     : Any.Def.Doc[Opt[A]]      = new Z.OptDocDef()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF -> ### Boolean Specialized Generic Option

  To be used with Boolean based opaque values.

@def void      -> Get void instance
@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/