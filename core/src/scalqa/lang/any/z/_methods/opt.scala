package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

transparent trait opt:
  self =>

  extension[A             ](inline x:       Val.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A])            inline def `val`  : A        = {val v=(x.real == Boolean.G.Opt.TRUE.real).cast[A]; v}
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}
  extension[A<:Any.Double ](inline x: Double .G.Opt[A])            inline def `val`  : A        = {val v=x.cast[A]; v}

  extension[A             ](inline x:       Val.Opt[A]) @tn("VOV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A]) @tn("BOV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A]) @tn("YOV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A]) @tn("COV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A]) @tn("SOV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A]) @tn("IOV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A]) @tn("LOV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A]) @tn("FOV") inline def isVoid : Boolean  = x.isEmpty
  extension[A<:Any.Double ](inline x: Double .G.Opt[A]) @tn("DOV") inline def isVoid : Boolean  = x.isEmpty

  extension[A             ](inline x:       Val.Opt[A]) @tn("VON") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A]) @tn("BON") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A]) @tn("YON") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A]) @tn("CON") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A]) @tn("SON") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A]) @tn("ION") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A]) @tn("LON") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A]) @tn("FON") inline def nonVoid: Boolean  = !x.isEmpty
  extension[A<:Any.Double ](inline x: Double .G.Opt[A]) @tn("DON") inline def nonVoid: Boolean  = !x.isEmpty

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/