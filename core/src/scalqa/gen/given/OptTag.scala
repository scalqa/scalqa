package scalqa; package gen; package `given`; import language.implicitConversions

import Lang.Any.{ Raw as RAW }

class  OptTag[A, OPT <: Opt.AnyType[A]]

object OptTag extends zOptTagDefault:
  inline given givenBoolean[A<:RAW.Boolean] : OptTag[A,Boolean.G.Opt[A]] = new OptTag[A, Boolean.G.Opt[A]]
  inline given givenByte   [A<:RAW.Byte   ] : OptTag[A,Byte   .G.Opt[A]] = new OptTag[A, Byte   .G.Opt[A]]
  inline given givenChar   [A<:RAW.Char   ] : OptTag[A,Char   .G.Opt[A]] = new OptTag[A, Char   .G.Opt[A]]
  inline given givenShort  [A<:RAW.Short  ] : OptTag[A,Short  .G.Opt[A]] = new OptTag[A, Short  .G.Opt[A]]
  inline given givenInt    [A<:RAW.Int    ] : OptTag[A,Int    .G.Opt[A]] = new OptTag[A, Int    .G.Opt[A]]
  inline given givenLong   [A<:RAW.Long   ] : OptTag[A,Long   .G.Opt[A]] = new OptTag[A, Long   .G.Opt[A]]
  inline given givenFloat  [A<:RAW.Float  ] : OptTag[A,Float  .G.Opt[A]] = new OptTag[A, Float  .G.Opt[A]]
  inline given givenDouble [A<:RAW.Double ] : OptTag[A,Double .G.Opt[A]] = new OptTag[A, Double .G.Opt[A]]
  inline given givenRef    [A<:Lang.Any.Ref]: OptTag[A,      Val.Opt[A]] = new OptTag[A,       Val.Opt[A]]

  // ***************************************************************************************************************
  sealed class Raw[A, OPT <: Opt.RawType[A]] extends OptTag[A,OPT]

  object Raw:
    inline given givenBoolean[A<:RAW.Boolean] : Raw[A,Boolean.G.Opt[A]] = new Raw[A,Boolean.G.Opt[A]]()
    inline given givenByte   [A<:RAW.Byte   ] : Raw[A,Byte   .G.Opt[A]] = new Raw[A,Byte   .G.Opt[A]]()
    inline given givenChar   [A<:RAW.Char   ] : Raw[A,Char   .G.Opt[A]] = new Raw[A,Char   .G.Opt[A]]()
    inline given givenShort  [A<:RAW.Short  ] : Raw[A,Short  .G.Opt[A]] = new Raw[A,Short  .G.Opt[A]]()
    inline given givenInt    [A<:RAW.Int    ] : Raw[A,Int    .G.Opt[A]] = new Raw[A,Int    .G.Opt[A]]()
    inline given givenLong   [A<:RAW.Long   ] : Raw[A,Long   .G.Opt[A]] = new Raw[A,Long   .G.Opt[A]]()
    inline given givenFloat  [A<:RAW.Float  ] : Raw[A,Float  .G.Opt[A]] = new Raw[A,Float  .G.Opt[A]]()
    inline given givenDouble [A<:RAW.Double ] : Raw[A,Double .G.Opt[A]] = new Raw[A,Double .G.Opt[A]]()

private[`given`] class zOptTagDefault:
  inline given givenAny    [A             ] : OptTag[A,      Val.Opt[A]] = new OptTag[A,       Val.Opt[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
