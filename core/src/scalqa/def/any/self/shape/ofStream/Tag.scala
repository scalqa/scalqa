package scalqa; package `def`; package any; package self; package shape; package ofStream; import language.implicitConversions

import Def.Any.{ Raw as RAW }

class  Tag[A, STREAM <: OfStream.Any[A]]

object Tag extends zTagDefault:
  class  Raw[A, RAW <: OfStream.Raw[A]] extends Tag[A,RAW]
  object Raw:
    inline given xxBoolean   [A<:RAW.Boolean] : Raw[A,Boolean.G.~[A]] = new Raw[A,Boolean.G.~[A]]
    inline given xxByte      [A<:RAW.Byte   ] : Raw[A,Byte   .G.~[A]] = new Raw[A,Byte   .G.~[A]]
    inline given xxChar      [A<:RAW.Char   ] : Raw[A,Char   .G.~[A]] = new Raw[A,Char   .G.~[A]]
    inline given xxShort     [A<:RAW.Short  ] : Raw[A,Short  .G.~[A]] = new Raw[A,Short  .G.~[A]]
    inline given xxInt       [A<:RAW.Int    ] : Raw[A,Int    .G.~[A]] = new Raw[A,Int    .G.~[A]]
    inline given xxLong      [A<:RAW.Long   ] : Raw[A,Long   .G.~[A]] = new Raw[A,Long   .G.~[A]]
    inline given xxFloat     [A<:RAW.Float  ] : Raw[A,Float  .G.~[A]] = new Raw[A,Float  .G.~[A]]
    inline given xxDouble    [A<:RAW.Double ] : Raw[A,Double .G.~[A]] = new Raw[A,Double .G.~[A]]

  // **********************************************************************************************************************************************
  class  Opt[A, OPT <: Shape.OfOpt.Any[A], STREAM <: OfStream.Any[A]]
  object Opt extends zOptDefault:
    inline given xxBoolean   [A<:RAW.Boolean] : Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]] = new Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]]
    inline given xxByte      [A<:RAW.Byte   ] : Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]] = new Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]]
    inline given xxChar      [A<:RAW.Char   ] : Opt[A,Char   .G.Opt[A], Char   .G.~[A]] = new Opt[A,Char   .G.Opt[A], Char   .G.~[A]]
    inline given xxShort     [A<:RAW.Short  ] : Opt[A,Short  .G.Opt[A], Short  .G.~[A]] = new Opt[A,Short  .G.Opt[A], Short  .G.~[A]]
    inline given xxInt       [A<:RAW.Int    ] : Opt[A,Int    .G.Opt[A], Int    .G.~[A]] = new Opt[A,Int    .G.Opt[A], Int    .G.~[A]]
    inline given xxLong      [A<:RAW.Long   ] : Opt[A,Long   .G.Opt[A], Long   .G.~[A]] = new Opt[A,Long   .G.Opt[A], Long   .G.~[A]]
    inline given xxFloat     [A<:RAW.Float  ] : Opt[A,Float  .G.Opt[A], Float  .G.~[A]] = new Opt[A,Float  .G.Opt[A], Float  .G.~[A]]
    inline given xxDouble    [A<:RAW.Double ] : Opt[A,Double .G.Opt[A], Double .G.~[A]] = new Opt[A,Double .G.Opt[A], Double .G.~[A]]

    inline given xxRefBoolean[A<:RAW.Boolean] : Opt[A,      Val.Opt[A], Boolean.G.~[A]] = new Opt[A,      Val.Opt[A], Boolean.G.~[A]]
    inline given xxRefByte   [A<:RAW.Byte   ] : Opt[A,      Val.Opt[A], Byte   .G.~[A]] = new Opt[A,      Val.Opt[A], Byte   .G.~[A]]
    inline given xxRefChar   [A<:RAW.Char   ] : Opt[A,      Val.Opt[A], Char   .G.~[A]] = new Opt[A,      Val.Opt[A], Char   .G.~[A]]
    inline given xxRefShort  [A<:RAW.Short  ] : Opt[A,      Val.Opt[A], Short  .G.~[A]] = new Opt[A,      Val.Opt[A], Short  .G.~[A]]
    inline given xxRefInt    [A<:RAW.Int    ] : Opt[A,      Val.Opt[A], Int    .G.~[A]] = new Opt[A,      Val.Opt[A], Int    .G.~[A]]
    inline given xxRefLong   [A<:RAW.Long   ] : Opt[A,      Val.Opt[A], Long   .G.~[A]] = new Opt[A,      Val.Opt[A], Long   .G.~[A]]
    inline given xxRefFloat  [A<:RAW.Float  ] : Opt[A,      Val.Opt[A], Float  .G.~[A]] = new Opt[A,      Val.Opt[A], Float  .G.~[A]]
    inline given xxRefDouble [A<:RAW.Double ] : Opt[A,      Val.Opt[A], Double .G.~[A]] = new Opt[A,      Val.Opt[A], Double .G.~[A]]
    inline given xxRef       [A<:Def.Any.Ref] : Opt[A,      Val.Opt[A],       Val.~[A]] = new Opt[A,      Val.Opt[A],       Val.~[A]]
  private[Tag] class zOptDefault:
    inline given xxAny       [A             ] : Opt[A,      Val.Opt[A],       Val.~[A]] = new Opt[A,      Val.Opt[A],       Val.~[A]]

  // ------------------------------------------------------------------------------------------------
  inline given xxBoolean   [A<:RAW.Boolean] : Tag[A,Boolean.G.~[A]] = new Tag[A, Boolean.G.~[A]]
  inline given xxByte      [A<:RAW.Byte   ] : Tag[A,Byte   .G.~[A]] = new Tag[A, Byte   .G.~[A]]
  inline given xxChar      [A<:RAW.Char   ] : Tag[A,Char   .G.~[A]] = new Tag[A, Char   .G.~[A]]
  inline given xxShort     [A<:RAW.Short  ] : Tag[A,Short  .G.~[A]] = new Tag[A, Short  .G.~[A]]
  inline given xxInt       [A<:RAW.Int    ] : Tag[A,Int    .G.~[A]] = new Tag[A, Int    .G.~[A]]
  inline given xxLong      [A<:RAW.Long   ] : Tag[A,Long   .G.~[A]] = new Tag[A, Long   .G.~[A]]
  inline given xxFloat     [A<:RAW.Float  ] : Tag[A,Float  .G.~[A]] = new Tag[A, Float  .G.~[A]]
  inline given xxDouble    [A<:RAW.Double ] : Tag[A,Double .G.~[A]] = new Tag[A, Double .G.~[A]]
  inline given xxRef       [A<:Def.Any.Ref] : Tag[A,      Val.~[A]] = new Tag[A,       Val.~[A]]
private[ofStream] class zTagDefault:
  inline given xxAny[A]: Tag[A, Val.~[A]] = new Tag[A, Val.~[A]]




/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

