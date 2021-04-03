package scalqa; package `def`; package any; package self; package shape; package ofOpt; import language.implicitConversions

import Def.Any.{ Raw as RAW }

class Tag[A, OPT <: OfOpt.Any[A]]

object Tag extends zTagDefault:

  sealed class Raw[A, OPT <: OfOpt.Raw[A]] extends Tag[A,OPT]

  object Raw:
    inline given xxBoolean[A<:RAW.Boolean] : Raw[A,Boolean.G.Opt[A]] = new Raw[A,Boolean.G.Opt[A]]()
    inline given xxByte   [A<:RAW.Byte   ] : Raw[A,Byte   .G.Opt[A]] = new Raw[A,Byte   .G.Opt[A]]()
    inline given xxChar   [A<:RAW.Char   ] : Raw[A,Char   .G.Opt[A]] = new Raw[A,Char   .G.Opt[A]]()
    inline given xxShort  [A<:RAW.Short  ] : Raw[A,Short  .G.Opt[A]] = new Raw[A,Short  .G.Opt[A]]()
    inline given xxInt    [A<:RAW.Int    ] : Raw[A,Int    .G.Opt[A]] = new Raw[A,Int    .G.Opt[A]]()
    inline given xxLong   [A<:RAW.Long   ] : Raw[A,Long   .G.Opt[A]] = new Raw[A,Long   .G.Opt[A]]()
    inline given xxFloat  [A<:RAW.Float  ] : Raw[A,Float  .G.Opt[A]] = new Raw[A,Float  .G.Opt[A]]()
    inline given xxDouble [A<:RAW.Double ] : Raw[A,Double .G.Opt[A]] = new Raw[A,Double .G.Opt[A]]()

  // ***************************************************************************************************************
  inline given xxBoolean[A<:RAW.Boolean] : Tag[A,Boolean.G.Opt[A]] = new Tag[A, Boolean.G.Opt[A]]
  inline given xxByte   [A<:RAW.Byte   ] : Tag[A,Byte   .G.Opt[A]] = new Tag[A, Byte   .G.Opt[A]]
  inline given xxChar   [A<:RAW.Char   ] : Tag[A,Char   .G.Opt[A]] = new Tag[A, Char   .G.Opt[A]]
  inline given xxShort  [A<:RAW.Short  ] : Tag[A,Short  .G.Opt[A]] = new Tag[A, Short  .G.Opt[A]]
  inline given xxInt    [A<:RAW.Int    ] : Tag[A,Int    .G.Opt[A]] = new Tag[A, Int    .G.Opt[A]]
  inline given xxLong   [A<:RAW.Long   ] : Tag[A,Long   .G.Opt[A]] = new Tag[A, Long   .G.Opt[A]]
  inline given xxFloat  [A<:RAW.Float  ] : Tag[A,Float  .G.Opt[A]] = new Tag[A, Float  .G.Opt[A]]
  inline given xxDouble [A<:RAW.Double ] : Tag[A,Double .G.Opt[A]] = new Tag[A, Double .G.Opt[A]]
  inline given xxRef    [A<:Def.Any.Ref] : Tag[A,      Val.Opt[A]] = new Tag[A,       Val.Opt[A]]
private[ofOpt] class zTagDefault:
  inline given xxAny    [A             ] : Tag[A,      Val.Opt[A]] = new Tag[A,       Val.Opt[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
