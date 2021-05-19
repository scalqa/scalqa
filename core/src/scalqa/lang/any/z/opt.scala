package scalqa; package lang; package any; package z; import language.implicitConversions

import Self.Given.OptTag

object opt:

  inline def apply[A,OPT<:Opt.AnyType[A]](x: A, inline s:OptTag[A,OPT] ): OPT =
    inline s match
      case _ : OptTag[A,Boolean.G.Opt[A]] => if(x.cast[Boolean]) Boolean.G.Opt.TRUE else Boolean.G.Opt.FALSE
      case _ : OptTag[A,Byte   .G.Opt[A]] => x.cast[Byte  .G.Opt[A & Byte]]
      case _ : OptTag[A,Char   .G.Opt[A]] => x.cast[Char  .G.Opt[A & Char]]
      case _ : OptTag[A,Short  .G.Opt[A]] => x.cast[Short .G.Opt[A & Short]]
      case _ : OptTag[A,Int    .G.Opt[A]] => x.cast[Int   .G.Opt[A & Int]]
      case _ : OptTag[A,Long   .G.Opt[A]] => x.cast[Long  .G.Opt[A & Long]]
      case _ : OptTag[A,Float  .G.Opt[A]] => x.cast[Float .G.Opt[A & Float]]
      case _ : OptTag[A,Double .G.Opt[A]] => x.cast[Double.G.Opt[A & Double]]
      case _ : OptTag[A,      Val.Opt[A]] => (if(x == null) ZZ.None else x).cast[     Val.Opt[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
