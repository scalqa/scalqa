package scalqa; package `val`; package opt; package z; import language.implicitConversions;

import Self.Given.OptTag

object mapOpt:

  inline def apply[A,B,OPT<:Opt.AnyType[B]](x:Opt[A], inline f: A=>OPT, inline s:OptTag[B,OPT]): OPT =
    type BB=B&Raw.Boolean;type BY=B&Raw.Byte;type BC=B&Raw.Char;type BS=B&Raw.Short;type BI=B&Raw.Int;type BL=B&Raw.Long;type BF=B&Raw.Float;type BD=B&Raw.Double
    inline s match
      case _ : OptTag[B,Boolean.G.Opt[B]] => {var o:Boolean.G.Opt[BB]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Boolean.G.Opt[BB]]; o}
      case _ : OptTag[B,Byte   .G.Opt[B]] => {var o:Byte   .G.Opt[BY]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Byte   .G.Opt[BY]]; o}
      case _ : OptTag[B,Char   .G.Opt[B]] => {var o:Char   .G.Opt[BC]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Char   .G.Opt[BC]]; o}
      case _ : OptTag[B,Short  .G.Opt[B]] => {var o:Short  .G.Opt[BS]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Short  .G.Opt[BS]]; o}
      case _ : OptTag[B,Int    .G.Opt[B]] => {var o:Int    .G.Opt[BI]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Int    .G.Opt[BI]]; o}
      case _ : OptTag[B,Long   .G.Opt[B]] => {var o:Long   .G.Opt[BL]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Long   .G.Opt[BL]]; o}
      case _ : OptTag[B,Float  .G.Opt[B]] => {var o:Float  .G.Opt[BF]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Float  .G.Opt[BF]]; o}
      case _ : OptTag[B,Double .G.Opt[B]] => {var o:Double .G.Opt[BD]= \/; if(x.nonEmpty) o= f(x.`val`).cast[Double .G.Opt[BD]]; o}
      case _ : OptTag[B,      Val.Opt[B]] => {var o:      Val.Opt[B ]= \/; if(x.nonEmpty) o= f(x.`val`).cast[      Val.Opt[B ]]; o}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
