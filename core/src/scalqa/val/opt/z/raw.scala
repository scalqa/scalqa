package scalqa; package `val`; package opt; package z; import language.implicitConversions;

import Shape.OfOpt.Raw

object raw:

  inline def apply[A,RAW<:Raw[A]](x:Opt[A], inline s: Raw.Def[A,RAW]): RAW  =
    inline s match
              case _ : Raw.Def[A,Boolean.G.Opt[A]] => (if(x.isEmpty) Boolean.G.Opt.void[Boolean] else Boolean.G.Opt(x.cast[java.lang.Boolean].booleanValue)).cast[RAW]
              case _ : Raw.Def[A,Byte   .G.Opt[A]] => (if(x.isEmpty) Byte   .G.Opt.void[Byte]    else x.cast[java.lang.Byte     ].shortValue).cast[RAW]
              case _ : Raw.Def[A,Char   .G.Opt[A]] => (if(x.isEmpty) Char   .G.Opt.void[Char]    else x.cast[java.lang.Character].charValue.Int).cast[RAW]
              case _ : Raw.Def[A,Short  .G.Opt[A]] => (if(x.isEmpty) Short  .G.Opt.void[Short]   else x.cast[java.lang.Short    ].intValue).cast[RAW]
              case _ : Raw.Def[A,Int    .G.Opt[A]] => (if(x.isEmpty) Int    .G.Opt.void[Int]     else x.cast[java.lang.Integer  ].longValue).cast[RAW]
              case _ : Raw.Def[A,Long   .G.Opt[A]] => (if(x.isEmpty) Long   .G.Opt.void[Long]    else x.cast[java.lang.Long     ].longValue).cast[RAW]
              case _ : Raw.Def[A,Float  .G.Opt[A]] => (if(x.isEmpty) Float  .G.Opt.void[Float]   else x.cast[java.lang.Float    ].floatValue).cast[RAW]
              case _ : Raw.Def[A,Double .G.Opt[A]] => (if(x.isEmpty) Double .G.Opt.void[Double]  else x.cast[java.lang.Double   ].doubleValue).cast[RAW]
              case _                               => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
