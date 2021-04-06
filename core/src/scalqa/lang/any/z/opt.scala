package scalqa; package lang; package any; package z; import language.implicitConversions

import Shape.OfOpt.Any

object opt:

  inline def apply[A,OPT<:Any[A]](x: A, inline s:Any.Def[A,OPT] ): OPT =
    inline s match
      case _ : Any.Def[A,Boolean.G.Opt[A]] => if(x.cast[Boolean]) Boolean.G.Opt.TRUE else Boolean.G.Opt.FALSE
      case _ : Any.Def[A,Byte   .G.Opt[A]] => x.cast[Byte  .G.Opt[A & Byte]]
      case _ : Any.Def[A,Char   .G.Opt[A]] => x.cast[Char  .G.Opt[A & Char]]
      case _ : Any.Def[A,Short  .G.Opt[A]] => x.cast[Short .G.Opt[A & Short]]
      case _ : Any.Def[A,Int    .G.Opt[A]] => x.cast[Int   .G.Opt[A & Int]]
      case _ : Any.Def[A,Long   .G.Opt[A]] => x.cast[Long  .G.Opt[A & Long]]
      case _ : Any.Def[A,Float  .G.Opt[A]] => x.cast[Float .G.Opt[A & Float]]
      case _ : Any.Def[A,Double .G.Opt[A]] => x.cast[Double.G.Opt[A & Double]]
      case _ : Any.Def[A,      Val.Opt[A]] => x.cast[     Val.Opt[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
