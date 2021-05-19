package scalqa; package lang; package any; package self; package `given`; import language.implicitConversions

import Any. { Raw as RAW }

object PackTag:

  sealed class Raw[A, PACK <: ><.RawType[A]]

  object Raw:
    inline given givenBoolean[A<:RAW.Boolean] : Raw[A,Boolean.G.><[A]] = new Raw[A,Boolean.G.><[A]]
    inline given givenByte   [A<:RAW.Byte]    : Raw[A,Byte   .G.><[A]] = new Raw[A,Byte   .G.><[A]]
    inline given givenChar   [A<:RAW.Char]    : Raw[A,Char   .G.><[A]] = new Raw[A,Char   .G.><[A]]
    inline given givenShort  [A<:RAW.Short]   : Raw[A,Short  .G.><[A]] = new Raw[A,Short  .G.><[A]]
    inline given givenInt    [A<:RAW.Int]     : Raw[A,Int    .G.><[A]] = new Raw[A,Int    .G.><[A]]
    inline given givenLong   [A<:RAW.Long]    : Raw[A,Long   .G.><[A]] = new Raw[A,Long   .G.><[A]]
    inline given givenFloat  [A<:RAW.Float]   : Raw[A,Float  .G.><[A]] = new Raw[A,Float  .G.><[A]]
    inline given givenDouble [A<:RAW.Double]  : Raw[A,Double .G.><[A]] = new Raw[A,Double .G.><[A]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
