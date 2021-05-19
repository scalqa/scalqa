package scalqa; package lang; package any; package self; package `given`; import language.implicitConversions

import Any. { Raw as RAW }

class  StreamTag[A, STREAM <: ~~.AnyType[A]]

object StreamTag extends zStreamTagDefault:
  inline given givenBoolean   [A<:RAW.Boolean] : StreamTag[A,Boolean.G.~[A]] = new StreamTag[A, Boolean.G.~[A]]
  inline given givenByte      [A<:RAW.Byte   ] : StreamTag[A,Byte   .G.~[A]] = new StreamTag[A, Byte   .G.~[A]]
  inline given givenChar      [A<:RAW.Char   ] : StreamTag[A,Char   .G.~[A]] = new StreamTag[A, Char   .G.~[A]]
  inline given givenShort     [A<:RAW.Short  ] : StreamTag[A,Short  .G.~[A]] = new StreamTag[A, Short  .G.~[A]]
  inline given givenInt       [A<:RAW.Int    ] : StreamTag[A,Int    .G.~[A]] = new StreamTag[A, Int    .G.~[A]]
  inline given givenLong      [A<:RAW.Long   ] : StreamTag[A,Long   .G.~[A]] = new StreamTag[A, Long   .G.~[A]]
  inline given givenFloat     [A<:RAW.Float  ] : StreamTag[A,Float  .G.~[A]] = new StreamTag[A, Float  .G.~[A]]
  inline given givenDouble    [A<:RAW.Double ] : StreamTag[A,Double .G.~[A]] = new StreamTag[A, Double .G.~[A]]
  inline given givenRef       [A<:Lang.Any.Ref] : StreamTag[A,      Val.~[A]] = new StreamTag[A,       Val.~[A]]

  // ********************************************************************************************************************************************
  class  Raw[A, RAW <: ~~.RawType[A]] extends StreamTag[A,RAW]
  object Raw:
    inline given givenBoolean   [A<:RAW.Boolean] : Raw[A,Boolean.G.~[A]] = new Raw[A,Boolean.G.~[A]]
    inline given givenByte      [A<:RAW.Byte   ] : Raw[A,Byte   .G.~[A]] = new Raw[A,Byte   .G.~[A]]
    inline given givenChar      [A<:RAW.Char   ] : Raw[A,Char   .G.~[A]] = new Raw[A,Char   .G.~[A]]
    inline given givenShort     [A<:RAW.Short  ] : Raw[A,Short  .G.~[A]] = new Raw[A,Short  .G.~[A]]
    inline given givenInt       [A<:RAW.Int    ] : Raw[A,Int    .G.~[A]] = new Raw[A,Int    .G.~[A]]
    inline given givenLong      [A<:RAW.Long   ] : Raw[A,Long   .G.~[A]] = new Raw[A,Long   .G.~[A]]
    inline given givenFloat     [A<:RAW.Float  ] : Raw[A,Float  .G.~[A]] = new Raw[A,Float  .G.~[A]]
    inline given givenDouble    [A<:RAW.Double ] : Raw[A,Double .G.~[A]] = new Raw[A,Double .G.~[A]]

  // ********************************************************************************************************************************************
  class  Opt[A, OPT <: Val.Opt.AnyType[A], STREAM <: ~~.AnyType[A]]
  object Opt extends zOptTagDefault:
    inline given givenBoolean   [A<:RAW.Boolean] : Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]] = new Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]]
    inline given givenByte      [A<:RAW.Byte   ] : Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]] = new Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]]
    inline given givenChar      [A<:RAW.Char   ] : Opt[A,Char   .G.Opt[A], Char   .G.~[A]] = new Opt[A,Char   .G.Opt[A], Char   .G.~[A]]
    inline given givenShort     [A<:RAW.Short  ] : Opt[A,Short  .G.Opt[A], Short  .G.~[A]] = new Opt[A,Short  .G.Opt[A], Short  .G.~[A]]
    inline given givenInt       [A<:RAW.Int    ] : Opt[A,Int    .G.Opt[A], Int    .G.~[A]] = new Opt[A,Int    .G.Opt[A], Int    .G.~[A]]
    inline given givenLong      [A<:RAW.Long   ] : Opt[A,Long   .G.Opt[A], Long   .G.~[A]] = new Opt[A,Long   .G.Opt[A], Long   .G.~[A]]
    inline given givenFloat     [A<:RAW.Float  ] : Opt[A,Float  .G.Opt[A], Float  .G.~[A]] = new Opt[A,Float  .G.Opt[A], Float  .G.~[A]]
    inline given givenDouble    [A<:RAW.Double ] : Opt[A,Double .G.Opt[A], Double .G.~[A]] = new Opt[A,Double .G.Opt[A], Double .G.~[A]]

    inline given givenRefBoolean[A<:RAW.Boolean] : Opt[A,      Val.Opt[A], Boolean.G.~[A]] = new Opt[A,      Val.Opt[A], Boolean.G.~[A]]
    inline given givenRefByte   [A<:RAW.Byte   ] : Opt[A,      Val.Opt[A], Byte   .G.~[A]] = new Opt[A,      Val.Opt[A], Byte   .G.~[A]]
    inline given givenRefChar   [A<:RAW.Char   ] : Opt[A,      Val.Opt[A], Char   .G.~[A]] = new Opt[A,      Val.Opt[A], Char   .G.~[A]]
    inline given givenRefShort  [A<:RAW.Short  ] : Opt[A,      Val.Opt[A], Short  .G.~[A]] = new Opt[A,      Val.Opt[A], Short  .G.~[A]]
    inline given givenRefInt    [A<:RAW.Int    ] : Opt[A,      Val.Opt[A], Int    .G.~[A]] = new Opt[A,      Val.Opt[A], Int    .G.~[A]]
    inline given givenRefLong   [A<:RAW.Long   ] : Opt[A,      Val.Opt[A], Long   .G.~[A]] = new Opt[A,      Val.Opt[A], Long   .G.~[A]]
    inline given givenRefFloat  [A<:RAW.Float  ] : Opt[A,      Val.Opt[A], Float  .G.~[A]] = new Opt[A,      Val.Opt[A], Float  .G.~[A]]
    inline given givenRefDouble [A<:RAW.Double ] : Opt[A,      Val.Opt[A], Double .G.~[A]] = new Opt[A,      Val.Opt[A], Double .G.~[A]]
    inline given givenRef       [A<:Lang.Any.Ref]: Opt[A,      Val.Opt[A],       Val.~[A]] = new Opt[A,      Val.Opt[A],       Val.~[A]]
  private[`given`] class zOptTagDefault:
    inline given givenAny       [A             ] : Opt[A,      Val.Opt[A],       Val.~[A]] = new Opt[A,      Val.Opt[A],       Val.~[A]]

// **********************************************************************************************************************************************
private[`given`] class zStreamTagDefault:
  inline given givenAny[A]: StreamTag[A, Val.~[A]] = new StreamTag[A, Val.~[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
