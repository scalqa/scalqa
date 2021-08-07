package scalqa; package `val`; package opt; package z; import language.implicitConversions;

import gen.`given`.OptShape

object mapOpt:

  inline def apply[A,B,OPT<:Opt.AnyType[B]](x:Opt[A], inline f: A=>OPT, inline s:OptShape[B,OPT]): OPT =
    type BB=B&Boolean.Raw;type BY=B&Byte.Raw;type BC=B&Char.Raw;type BS=B&Short.Raw;type BI=B&Int.Raw;type BL=B&Long.Raw;type BF=B&Float.Raw;type BD=B&Double.Raw
    inline s match
      case _ : OptShape[B,Boolean.G.Opt[B]] => {var o:Boolean.G.Opt[BB]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Boolean.G.Opt[BB]]; o.cast[OPT]}
      case _ : OptShape[B,Byte   .G.Opt[B]] => {var o:Byte   .G.Opt[BY]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Byte   .G.Opt[BY]]; o.cast[OPT]}
      case _ : OptShape[B,Char   .G.Opt[B]] => {var o:Char   .G.Opt[BC]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Char   .G.Opt[BC]]; o.cast[OPT]}
      case _ : OptShape[B,Short  .G.Opt[B]] => {var o:Short  .G.Opt[BS]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Short  .G.Opt[BS]]; o.cast[OPT]}
      case _ : OptShape[B,Int    .G.Opt[B]] => {var o:Int    .G.Opt[BI]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Int    .G.Opt[BI]]; o.cast[OPT]}
      case _ : OptShape[B,Long   .G.Opt[B]] => {var o:Long   .G.Opt[BL]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Long   .G.Opt[BL]]; o.cast[OPT]}
      case _ : OptShape[B,Float  .G.Opt[B]] => {var o:Float  .G.Opt[BF]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Float  .G.Opt[BF]]; o.cast[OPT]}
      case _ : OptShape[B,Double .G.Opt[B]] => {var o:Double .G.Opt[BD]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Double .G.Opt[BD]]; o.cast[OPT]}
      case _ : OptShape[B,      Val.Opt[B]] => {var o:      Val.Opt[B ]= \/; if(x.nonEmpty) o= f(x.`val`).cast[      Val.Opt[B ]]; o.cast[OPT]}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
