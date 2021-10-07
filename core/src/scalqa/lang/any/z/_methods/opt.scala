package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

transparent trait opt:
  self =>

  // The `val` methods are not a public API, but they are inlined and must be public.  Here is the best place to put them
  extension[A             ](inline x:       Val.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:AnyRef     ](inline x:       Val.Opt[A]) @tn("ROV") inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A])            inline def `val`   : A        = {val v=(x.real == Boolean.G.Opt.TRUE.real).cast[A]; v}
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Double ](inline x: Double .G.Opt[A])            inline def `val`   : A        = {val v=x.cast[A]; v}

  extension[A             ](inline x:       Val.Opt[A]) @tn("VOE") inline def isEmpty : Boolean  = x eq ZZ.None
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A]) @tn("BOE") inline def isEmpty : Boolean  = x.real == Boolean.G.Opt.void.real
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A]) @tn("YOE") inline def isEmpty : Boolean  = x.real == Byte.G.Opt.void.real
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A]) @tn("COE") inline def isEmpty : Boolean  = x.real == Char.G.Opt.void.real
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A]) @tn("SOE") inline def isEmpty : Boolean  = x.real == Short.G.Opt.void.real
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A]) @tn("IOE") inline def isEmpty : Boolean  = x.real == Int.G.Opt.void.real
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A]) @tn("LOE") inline def isEmpty : Boolean  = x.real == Long.G.Opt.void.real
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A]) @tn("FOE") inline def isEmpty : Boolean  = java.lang.Float.isNaN(x.real)
  extension[A<:Any.Double ](inline x: Double .G.Opt[A]) @tn("DOE") inline def isEmpty : Boolean  = java.lang.Double.isNaN(x.real)

  extension[A             ](inline x:       Val.Opt[A]) @tn("VON") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A]) @tn("BON") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A]) @tn("YON") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A]) @tn("CON") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A]) @tn("SON") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A]) @tn("ION") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A]) @tn("LON") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A]) @tn("FON") inline def nonEmpty: Boolean  = !x.isEmpty
  extension[A<:Any.Double ](inline x: Double .G.Opt[A]) @tn("DON") inline def nonEmpty: Boolean  = !x.isEmpty

  extension[A             ](inline x:       Val.Opt[A]) @tn("VOV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A]) @tn("BOV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A]) @tn("YOV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A]) @tn("COV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A]) @tn("SOV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A]) @tn("IOV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A]) @tn("LOV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A]) @tn("FOV") inline def isVoid  : Boolean  = x.isEmpty
  extension[A<:Any.Double ](inline x: Double .G.Opt[A]) @tn("DOV") inline def isVoid  : Boolean  = x.isEmpty

  extension[A             ](inline x:       Val.Opt[A]) @tn("VOD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A]) @tn("BOD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A]) @tn("YOD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A]) @tn("COD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A]) @tn("SOD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A]) @tn("IOD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A]) @tn("LOD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A]) @tn("FOD") inline def nonVoid : Boolean  = !x.isEmpty
  extension[A<:Any.Double ](inline x: Double .G.Opt[A]) @tn("DOD") inline def nonVoid : Boolean  = !x.isEmpty

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/