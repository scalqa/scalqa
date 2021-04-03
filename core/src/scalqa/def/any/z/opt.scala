package scalqa; package `def`; package any; package z; import language.implicitConversions

import Shape.OfOpt.*

object opt:

  inline def apply[A,OPT<:Any[A]](x: A, inline s:Tag[A,OPT] ): OPT =
    inline s match
      case _ : Tag[A,Boolean.G.Opt[A]] => if(x.cast[Boolean]) Boolean.G.Opt.TRUE else Boolean.G.Opt.FALSE
      case _ : Tag[A,Byte   .G.Opt[A]] => x.cast[Byte  .G.Opt[A & Byte]]
      case _ : Tag[A,Char   .G.Opt[A]] => x.cast[Char  .G.Opt[A & Char]]
      case _ : Tag[A,Short  .G.Opt[A]] => x.cast[Short .G.Opt[A & Short]]
      case _ : Tag[A,Int    .G.Opt[A]] => x.cast[Int   .G.Opt[A & Int]]
      case _ : Tag[A,Long   .G.Opt[A]] => x.cast[Long  .G.Opt[A & Long]]
      case _ : Tag[A,Float  .G.Opt[A]] => x.cast[Float .G.Opt[A & Float]]
      case _ : Tag[A,Double .G.Opt[A]] => x.cast[Double.G.Opt[A & Double]]
      case _ : Tag[A,      Val.Opt[A]] => x.cast[     Val.Opt[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
