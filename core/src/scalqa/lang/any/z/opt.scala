package scalqa; package lang; package any; package z; import language.implicitConversions

import gen.`given`.OptShape

object opt:

  transparent inline def apply[A,OPT<:Opt.AnyType[A]](x: A, inline s:OptShape[A,OPT] ): OPT =
    inline s match
      case _ : OptShape[A,Boolean.G.Opt[A]] => (if(x.cast[Boolean]) Boolean.G.Opt.TRUE else Boolean.G.Opt.FALSE).asInstanceOf[OPT & Boolean.G.Opt[A & Boolean]]
      case _ : OptShape[A,Byte   .G.Opt[A]] => x.asInstanceOf[OPT & Byte  .G.Opt[A & Byte]]
      case _ : OptShape[A,Char   .G.Opt[A]] => x.asInstanceOf[OPT & Char  .G.Opt[A & Char]]
      case _ : OptShape[A,Short  .G.Opt[A]] => x.asInstanceOf[OPT & Short .G.Opt[A & Short]]
      case _ : OptShape[A,Int    .G.Opt[A]] => x.asInstanceOf[OPT & Int   .G.Opt[A & Int]]
      case _ : OptShape[A,Long   .G.Opt[A]] => x.asInstanceOf[OPT & Long  .G.Opt[A & Long]]
      case _ : OptShape[A,Float  .G.Opt[A]] => x.asInstanceOf[OPT & Float .G.Opt[A & Float]]
      case _ : OptShape[A,Double .G.Opt[A]] => x.asInstanceOf[OPT & Double.G.Opt[A & Double]]
      case _ : OptShape[A,      Val.Opt[A]] => (if(x == null) ZZ.None else x).cast[Val.Opt[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
