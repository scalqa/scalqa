package scalqa; package gen; package `given`; import language.implicitConversions

import Lang.Any. { Raw as RAW }

class  RangeTag[A, RANGE <: <>.AnyType[A]]

object RangeTag extends zRangeTagDefault:
  inline given givenByte   [A<:RAW.Byte   ] : RangeTag[A,Byte   .G.<>[A]] = new RangeTag[A, Byte   .G.<>[A]]
  inline given givenChar   [A<:RAW.Char   ] : RangeTag[A,Char   .G.<>[A]] = new RangeTag[A, Char   .G.<>[A]]
  inline given givenShort  [A<:RAW.Short  ] : RangeTag[A,Short  .G.<>[A]] = new RangeTag[A, Short  .G.<>[A]]
  inline given givenInt    [A<:RAW.Int    ] : RangeTag[A,Int    .G.<>[A]] = new RangeTag[A, Int    .G.<>[A]]
  inline given givenLong   [A<:RAW.Long   ] : RangeTag[A,Long   .G.<>[A]] = new RangeTag[A, Long   .G.<>[A]]
  inline given givenFloat  [A<:RAW.Float  ] : RangeTag[A,Float  .G.<>[A]] = new RangeTag[A, Float  .G.<>[A]]
  inline given givenDouble [A<:RAW.Double ] : RangeTag[A,Double .G.<>[A]] = new RangeTag[A, Double .G.<>[A]]
  inline given givenRef    [A<:Ref        ] : RangeTag[A,      Val.<>[A]] = new RangeTag[A,       Val.<>[A]]

  // *********************************************************************************************************
  sealed class Raw[A, RANGE <: <>.RawType[A]] extends RangeTag[A,RANGE]

  object Raw:
    inline given givenByte  [A<:RAW.Byte  ] : Raw[A,Byte  .G.<>[A]] = new Raw[A,Byte  .G.<>[A]]
    inline given givenChar  [A<:RAW.Char  ] : Raw[A,Char  .G.<>[A]] = new Raw[A,Char  .G.<>[A]]
    inline given givenShort [A<:RAW.Short ] : Raw[A,Short .G.<>[A]] = new Raw[A,Short .G.<>[A]]
    inline given givenInt   [A<:RAW.Int   ] : Raw[A,Int   .G.<>[A]] = new Raw[A,Int   .G.<>[A]]
    inline given givenLong  [A<:RAW.Long  ] : Raw[A,Long  .G.<>[A]] = new Raw[A,Long  .G.<>[A]]
    inline given givenFloat [A<:RAW.Float ] : Raw[A,Float .G.<>[A]] = new Raw[A,Float .G.<>[A]]
    inline given givenDouble[A<:RAW.Double] : Raw[A,Double.G.<>[A]] = new Raw[A,Double.G.<>[A]]

private[`given`] class zRangeTagDefault:
  inline given givenAny    [A             ] : RangeTag[A,      Val.<>[A]] = new RangeTag[A,       Val.<>[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
