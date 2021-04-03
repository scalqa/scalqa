package scalqa; package `def`; package any; package self; package shape; import language.implicitConversions

import `def`.boolean.G.{ >< as BOOLEAN}
import `def`.byte   .G.{ >< as BYTE}
import `def`.char   .G.{ >< as CHAR}
import `def`.short  .G.{ >< as SHORT}
import `def`.int    .G.{ >< as INT}
import `def`.long   .G.{ >< as LONG}
import `def`.float  .G.{ >< as FLOAT}
import `def`.double .G.{ >< as DOUBLE}
import Any. { Raw as RAW }

object OfPack:

  type Raw[A] = BOOLEAN[A & RAW.Boolean] | BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]

  // ***********************************************************************************
  object Tag:

    sealed class Raw[A, RAW <: OfPack.Raw[A]]

    object Raw:
      inline given xxBoolean[A<:RAW.Boolean] : Raw[A,Boolean.G.><[A]] = new Raw[A,Boolean.G.><[A]]
      inline given xxByte   [A<:RAW.Byte]    : Raw[A,Byte   .G.><[A]] = new Raw[A,Byte   .G.><[A]]
      inline given xxChar   [A<:RAW.Char]    : Raw[A,Char   .G.><[A]] = new Raw[A,Char   .G.><[A]]
      inline given xxShort  [A<:RAW.Short]   : Raw[A,Short  .G.><[A]] = new Raw[A,Short  .G.><[A]]
      inline given xxInt    [A<:RAW.Int]     : Raw[A,Int    .G.><[A]] = new Raw[A,Int    .G.><[A]]
      inline given xxLong   [A<:RAW.Long]    : Raw[A,Long   .G.><[A]] = new Raw[A,Long   .G.><[A]]
      inline given xxFloat  [A<:RAW.Float]   : Raw[A,Float  .G.><[A]] = new Raw[A,Float  .G.><[A]]
      inline given xxDouble [A<:RAW.Double]  : Raw[A,Double .G.><[A]] = new Raw[A,Double .G.><[A]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
