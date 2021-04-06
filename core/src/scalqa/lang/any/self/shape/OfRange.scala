package scalqa; package lang; package any; package self; package shape; import language.implicitConversions

import Any. { Raw as RAW }

object OfRange:

  type   Any[A] = <>[A] | Raw[A]

  object Any:
    class  Def[A, RANGE <: OfRange.Any[A]]
    object Def extends zDefDefault:
      inline given xxByte   [A<:RAW.Byte   ] : Def[A,Byte   .G.<>[A]] = new Def[A, Byte   .G.<>[A]]
      inline given xxChar   [A<:RAW.Char   ] : Def[A,Char   .G.<>[A]] = new Def[A, Char   .G.<>[A]]
      inline given xxShort  [A<:RAW.Short  ] : Def[A,Short  .G.<>[A]] = new Def[A, Short  .G.<>[A]]
      inline given xxInt    [A<:RAW.Int    ] : Def[A,Int    .G.<>[A]] = new Def[A, Int    .G.<>[A]]
      inline given xxLong   [A<:RAW.Long   ] : Def[A,Long   .G.<>[A]] = new Def[A, Long   .G.<>[A]]
      inline given xxFloat  [A<:RAW.Float  ] : Def[A,Float  .G.<>[A]] = new Def[A, Float  .G.<>[A]]
      inline given xxDouble [A<:RAW.Double ] : Def[A,Double .G.<>[A]] = new Def[A, Double .G.<>[A]]
      inline given xxRef    [A<:Ref        ] : Def[A,      Val.<>[A]] = new Def[A,       Val.<>[A]]
    private[OfRange] class zDefDefault:
      inline given xxAny    [A             ] : Def[A,      Val.<>[A]] = new Def[A,       Val.<>[A]]

  // **************************************************************************************************
  import lang.byte   .g.{ Range as BYTE}
  import lang.char   .g.{ Range as CHAR}
  import lang.short  .g.{ Range as SHORT}
  import lang.int    .g.{ Range as INT}
  import lang.long   .g.{ Range as LONG}
  import lang.float  .g.{ Range as FLOAT}
  import lang.double .g.{ Range as DOUBLE}

  type Raw[A] = BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]

  object Raw:

    sealed class Def[A, RANGE <: Raw[A]] extends Any.Def[A,RANGE]

    object Def:
      inline given xxByte  [A<:RAW.Byte  ] : Def[A,Byte  .G.<>[A]] = new Def[A,Byte  .G.<>[A]]
      inline given xxChar  [A<:RAW.Char  ] : Def[A,Char  .G.<>[A]] = new Def[A,Char  .G.<>[A]]
      inline given xxShort [A<:RAW.Short ] : Def[A,Short .G.<>[A]] = new Def[A,Short .G.<>[A]]
      inline given xxInt   [A<:RAW.Int   ] : Def[A,Int   .G.<>[A]] = new Def[A,Int   .G.<>[A]]
      inline given xxLong  [A<:RAW.Long  ] : Def[A,Long  .G.<>[A]] = new Def[A,Long  .G.<>[A]]
      inline given xxFloat [A<:RAW.Float ] : Def[A,Float .G.<>[A]] = new Def[A,Float .G.<>[A]]
      inline given xxDouble[A<:RAW.Double] : Def[A,Double.G.<>[A]] = new Def[A,Double.G.<>[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
