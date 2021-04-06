package scalqa; package lang; package any; package self; package shape; import language.implicitConversions

import lang.boolean.G.{ >< as BOOLEAN}
import lang.byte   .G.{ >< as BYTE}
import lang.char   .G.{ >< as CHAR}
import lang.short  .G.{ >< as SHORT}
import lang.int    .G.{ >< as INT}
import lang.long   .G.{ >< as LONG}
import lang.float  .G.{ >< as FLOAT}
import lang.double .G.{ >< as DOUBLE}
import Any. { Raw as RAW }

object OfPack:

  type Raw[A] = BOOLEAN[A & RAW.Boolean] | BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]

  object Raw:

    sealed class Def[A, RAW <: Raw[A]]

    object Def:
      inline given xxBoolean[A<:RAW.Boolean] : Def[A,Boolean.G.><[A]] = new Def[A,Boolean.G.><[A]]
      inline given xxByte   [A<:RAW.Byte]    : Def[A,Byte   .G.><[A]] = new Def[A,Byte   .G.><[A]]
      inline given xxChar   [A<:RAW.Char]    : Def[A,Char   .G.><[A]] = new Def[A,Char   .G.><[A]]
      inline given xxShort  [A<:RAW.Short]   : Def[A,Short  .G.><[A]] = new Def[A,Short  .G.><[A]]
      inline given xxInt    [A<:RAW.Int]     : Def[A,Int    .G.><[A]] = new Def[A,Int    .G.><[A]]
      inline given xxLong   [A<:RAW.Long]    : Def[A,Long   .G.><[A]] = new Def[A,Long   .G.><[A]]
      inline given xxFloat  [A<:RAW.Float]   : Def[A,Float  .G.><[A]] = new Def[A,Float  .G.><[A]]
      inline given xxDouble [A<:RAW.Double]  : Def[A,Double .G.><[A]] = new Def[A,Double .G.><[A]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
