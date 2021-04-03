package scalqa; package `def`; package any; package self; package shape; package ofRange; import language.implicitConversions

import Def.Any.{ Raw as RAW }

class Tag[A, RANGE <: OfRange.Any[A]]

object Tag extends zTagDefault:

  sealed class Raw[A, RANGE <: OfRange.Raw[A]] extends Tag[A,RANGE]

  object Raw:
    inline given xxByte  [A<:RAW.Byte  ] : Raw[A,Byte  .G.<>[A]] = new Raw[A,Byte  .G.<>[A]]
    inline given xxChar  [A<:RAW.Char  ] : Raw[A,Char  .G.<>[A]] = new Raw[A,Char  .G.<>[A]]
    inline given xxShort [A<:RAW.Short ] : Raw[A,Short .G.<>[A]] = new Raw[A,Short .G.<>[A]]
    inline given xxInt   [A<:RAW.Int   ] : Raw[A,Int   .G.<>[A]] = new Raw[A,Int   .G.<>[A]]
    inline given xxLong  [A<:RAW.Long  ] : Raw[A,Long  .G.<>[A]] = new Raw[A,Long  .G.<>[A]]
    inline given xxFloat [A<:RAW.Float ] : Raw[A,Float .G.<>[A]] = new Raw[A,Float .G.<>[A]]
    inline given xxDouble[A<:RAW.Double] : Raw[A,Double.G.<>[A]] = new Raw[A,Double.G.<>[A]]

  // ---------------------------------------------------------------------------------------------
  inline given xxByte   [A<:RAW.Byte   ] : Tag[A,Byte   .G.<>[A]] = new Tag[A, Byte   .G.<>[A]]
  inline given xxChar   [A<:RAW.Char   ] : Tag[A,Char   .G.<>[A]] = new Tag[A, Char   .G.<>[A]]
  inline given xxShort  [A<:RAW.Short  ] : Tag[A,Short  .G.<>[A]] = new Tag[A, Short  .G.<>[A]]
  inline given xxInt    [A<:RAW.Int    ] : Tag[A,Int    .G.<>[A]] = new Tag[A, Int    .G.<>[A]]
  inline given xxLong   [A<:RAW.Long   ] : Tag[A,Long   .G.<>[A]] = new Tag[A, Long   .G.<>[A]]
  inline given xxFloat  [A<:RAW.Float  ] : Tag[A,Float  .G.<>[A]] = new Tag[A, Float  .G.<>[A]]
  inline given xxDouble [A<:RAW.Double ] : Tag[A,Double .G.<>[A]] = new Tag[A, Double .G.<>[A]]
  inline given xxRef    [A<:Ref        ] : Tag[A,      Val.<>[A]] = new Tag[A,       Val.<>[A]]
private[ofRange] class zTagDefault:
  inline given xxTag     [A            ] : Tag[A,      Val.<>[A]] = new Tag[A,       Val.<>[A]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
