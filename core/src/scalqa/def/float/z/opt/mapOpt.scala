package scalqa; package `def`; package float; package z; package opt; import language.implicitConversions

import Shape.OfOpt.*

object mapOpt:

  inline def apply[A<:RAW,B,OPT<:Any[B]](x:G.Opt[A], inline f: A=>OPT, inline s:Tag[B,OPT]): OPT =
    type BB=B&Raw.Boolean;type BY=B&Raw.Byte;type BC=B&Raw.Char;type BS=B&Raw.Short;type BI=B&Raw.Int;type BL=B&Raw.Long;type BF=B&Raw.Float;type BD=B&Raw.Double
    inline s match
      case _ : Tag[B,Boolean.G.Opt[B]] => {var o:Boolean.G.Opt[BB]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Boolean.G.Opt[BB]]; o}
      case _ : Tag[B,Byte   .G.Opt[B]] => {var o:Byte   .G.Opt[BY]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Byte   .G.Opt[BY]]; o}
      case _ : Tag[B,Char   .G.Opt[B]] => {var o:Char   .G.Opt[BC]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Char   .G.Opt[BC]]; o}
      case _ : Tag[B,Short  .G.Opt[B]] => {var o:Short  .G.Opt[BS]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Short  .G.Opt[BS]]; o}
      case _ : Tag[B,Int    .G.Opt[B]] => {var o:Int    .G.Opt[BI]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Int    .G.Opt[BI]]; o}
      case _ : Tag[B,Long   .G.Opt[B]] => {var o:Long   .G.Opt[BL]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Long   .G.Opt[BL]]; o}
      case _ : Tag[B,Float  .G.Opt[B]] => {var o:Float  .G.Opt[BF]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Float  .G.Opt[BF]]; o}
      case _ : Tag[B,Double .G.Opt[B]] => {var o:Double .G.Opt[BD]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[Double .G.Opt[BD]]; o}
      case _ : Tag[B,      Val.Opt[B]] => {var o:      Val.Opt[B ]= \/; if(x.nonEmpty) o= f(x.`val`).asInstanceOf[      Val.Opt[B ]]; o}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
