package scalqa; package gen; package `given`; import language.implicitConversions

class  RangeShape[A, RANGE <: <>.AnyType[A]]

object RangeShape extends zRangeShapeDefault:
  inline given givenByte   [A<:Byte.Raw   ] : RangeShape[A,Byte   .G.<>[A]] = new RangeShape[A, Byte   .G.<>[A]]
  inline given givenChar   [A<:Char.Raw   ] : RangeShape[A,Char   .G.<>[A]] = new RangeShape[A, Char   .G.<>[A]]
  inline given givenShort  [A<:Short.Raw  ] : RangeShape[A,Short  .G.<>[A]] = new RangeShape[A, Short  .G.<>[A]]
  inline given givenInt    [A<:Int.Raw    ] : RangeShape[A,Int    .G.<>[A]] = new RangeShape[A, Int    .G.<>[A]]
  inline given givenLong   [A<:Long.Raw   ] : RangeShape[A,Long   .G.<>[A]] = new RangeShape[A, Long   .G.<>[A]]
  inline given givenFloat  [A<:Float.Raw  ] : RangeShape[A,Float  .G.<>[A]] = new RangeShape[A, Float  .G.<>[A]]
  inline given givenDouble [A<:Double.Raw ] : RangeShape[A,Double .G.<>[A]] = new RangeShape[A, Double .G.<>[A]]
  inline given givenRef    [A<:AnyRef     ] : RangeShape[A,      Val.<>[A]] = new RangeShape[A,       Val.<>[A]]

  // *********************************************************************************************************
  sealed class Raw[A, RANGE <: <>.RawType[A]] extends RangeShape[A,RANGE]

  object Raw:
    inline given givenByte  [A<:Byte.Raw  ] : Raw[A,Byte  .G.<>[A]]         = new Raw[A,Byte  .G.<>[A]]
    inline given givenChar  [A<:Char.Raw  ] : Raw[A,Char  .G.<>[A]]         = new Raw[A,Char  .G.<>[A]]
    inline given givenShort [A<:Short.Raw ] : Raw[A,Short .G.<>[A]]         = new Raw[A,Short .G.<>[A]]
    inline given givenInt   [A<:Int.Raw   ] : Raw[A,Int   .G.<>[A]]         = new Raw[A,Int   .G.<>[A]]
    inline given givenLong  [A<:Long.Raw  ] : Raw[A,Long  .G.<>[A]]         = new Raw[A,Long  .G.<>[A]]
    inline given givenFloat [A<:Float.Raw ] : Raw[A,Float .G.<>[A]]         = new Raw[A,Float .G.<>[A]]
    inline given givenDouble[A<:Double.Raw] : Raw[A,Double.G.<>[A]]         = new Raw[A,Double.G.<>[A]]

private[`given`] class zRangeShapeDefault:
  inline given givenAny    [A             ] : RangeShape[A,Val.<>[A]]       = new RangeShape[A,       Val.<>[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
