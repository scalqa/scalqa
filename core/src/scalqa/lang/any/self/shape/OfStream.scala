package scalqa; package lang; package any; package self; package shape; import language.implicitConversions

import Any. { Raw as RAW }

object OfStream:

  type   Any[A] = Val.~[A] | Raw[A]
  object Any:
    class  Def[A, STREAM <: Any[A]]

    object Def extends zDefDefault:
      inline given xxBoolean   [A<:RAW.Boolean] : Def[A,Boolean.G.~[A]] = new Def[A, Boolean.G.~[A]]
      inline given xxByte      [A<:RAW.Byte   ] : Def[A,Byte   .G.~[A]] = new Def[A, Byte   .G.~[A]]
      inline given xxChar      [A<:RAW.Char   ] : Def[A,Char   .G.~[A]] = new Def[A, Char   .G.~[A]]
      inline given xxShort     [A<:RAW.Short  ] : Def[A,Short  .G.~[A]] = new Def[A, Short  .G.~[A]]
      inline given xxInt       [A<:RAW.Int    ] : Def[A,Int    .G.~[A]] = new Def[A, Int    .G.~[A]]
      inline given xxLong      [A<:RAW.Long   ] : Def[A,Long   .G.~[A]] = new Def[A, Long   .G.~[A]]
      inline given xxFloat     [A<:RAW.Float  ] : Def[A,Float  .G.~[A]] = new Def[A, Float  .G.~[A]]
      inline given xxDouble    [A<:RAW.Double ] : Def[A,Double .G.~[A]] = new Def[A, Double .G.~[A]]
      inline given xxRef       [A<:Lang.Any.Ref] : Def[A,      Val.~[A]] = new Def[A,       Val.~[A]]
    private[OfStream] class zDefDefault:
      inline given xxAny[A]: Def[A, Val.~[A]] = new Def[A, Val.~[A]]

    // ********************************************************************************************************************************************
    class  OptDef[A, OPT <: Shape.OfOpt.Any[A], STREAM <: OfStream.Any[A]]
    object OptDef extends zOptDefDefault:
      inline given xxBoolean   [A<:RAW.Boolean] : OptDef[A,Boolean.G.Opt[A], Boolean.G.~[A]] = new OptDef[A,Boolean.G.Opt[A], Boolean.G.~[A]]
      inline given xxByte      [A<:RAW.Byte   ] : OptDef[A,Byte   .G.Opt[A], Byte   .G.~[A]] = new OptDef[A,Byte   .G.Opt[A], Byte   .G.~[A]]
      inline given xxChar      [A<:RAW.Char   ] : OptDef[A,Char   .G.Opt[A], Char   .G.~[A]] = new OptDef[A,Char   .G.Opt[A], Char   .G.~[A]]
      inline given xxShort     [A<:RAW.Short  ] : OptDef[A,Short  .G.Opt[A], Short  .G.~[A]] = new OptDef[A,Short  .G.Opt[A], Short  .G.~[A]]
      inline given xxInt       [A<:RAW.Int    ] : OptDef[A,Int    .G.Opt[A], Int    .G.~[A]] = new OptDef[A,Int    .G.Opt[A], Int    .G.~[A]]
      inline given xxLong      [A<:RAW.Long   ] : OptDef[A,Long   .G.Opt[A], Long   .G.~[A]] = new OptDef[A,Long   .G.Opt[A], Long   .G.~[A]]
      inline given xxFloat     [A<:RAW.Float  ] : OptDef[A,Float  .G.Opt[A], Float  .G.~[A]] = new OptDef[A,Float  .G.Opt[A], Float  .G.~[A]]
      inline given xxDouble    [A<:RAW.Double ] : OptDef[A,Double .G.Opt[A], Double .G.~[A]] = new OptDef[A,Double .G.Opt[A], Double .G.~[A]]

      inline given xxRefBoolean[A<:RAW.Boolean] : OptDef[A,      Val.Opt[A], Boolean.G.~[A]] = new OptDef[A,      Val.Opt[A], Boolean.G.~[A]]
      inline given xxRefByte   [A<:RAW.Byte   ] : OptDef[A,      Val.Opt[A], Byte   .G.~[A]] = new OptDef[A,      Val.Opt[A], Byte   .G.~[A]]
      inline given xxRefChar   [A<:RAW.Char   ] : OptDef[A,      Val.Opt[A], Char   .G.~[A]] = new OptDef[A,      Val.Opt[A], Char   .G.~[A]]
      inline given xxRefShort  [A<:RAW.Short  ] : OptDef[A,      Val.Opt[A], Short  .G.~[A]] = new OptDef[A,      Val.Opt[A], Short  .G.~[A]]
      inline given xxRefInt    [A<:RAW.Int    ] : OptDef[A,      Val.Opt[A], Int    .G.~[A]] = new OptDef[A,      Val.Opt[A], Int    .G.~[A]]
      inline given xxRefLong   [A<:RAW.Long   ] : OptDef[A,      Val.Opt[A], Long   .G.~[A]] = new OptDef[A,      Val.Opt[A], Long   .G.~[A]]
      inline given xxRefFloat  [A<:RAW.Float  ] : OptDef[A,      Val.Opt[A], Float  .G.~[A]] = new OptDef[A,      Val.Opt[A], Float  .G.~[A]]
      inline given xxRefDouble [A<:RAW.Double ] : OptDef[A,      Val.Opt[A], Double .G.~[A]] = new OptDef[A,      Val.Opt[A], Double .G.~[A]]
      inline given xxRef       [A<:Lang.Any.Ref]: OptDef[A,      Val.Opt[A],       Val.~[A]] = new OptDef[A,      Val.Opt[A],       Val.~[A]]
    private[OfStream] class zOptDefDefault:
      inline given xxAny       [A             ] : OptDef[A,      Val.Opt[A],       Val.~[A]] = new OptDef[A,      Val.Opt[A],       Val.~[A]]

  // **********************************************************************************************************************************************
  import lang.boolean.g.{Stream as BOOLEAN}; import lang.byte.g.{Stream as BYTE}; import lang.char .g.{Stream as CHAR};  import lang.short .g.{Stream as SHORT}
  import lang.int    .g.{Stream as INT};     import lang.long.g.{Stream as LONG}; import lang.float.g.{Stream as FLOAT}; import lang.double.g.{Stream as DOUBLE}

  type   Raw[A] = BOOLEAN[A & RAW.Boolean] | BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]
  object Raw:
    class  Def[A, RAW <: Raw[A]] extends Any.Def[A,RAW]
    object Def:
      inline given xxBoolean   [A<:RAW.Boolean] : Def[A,Boolean.G.~[A]] = new Def[A,Boolean.G.~[A]]
      inline given xxByte      [A<:RAW.Byte   ] : Def[A,Byte   .G.~[A]] = new Def[A,Byte   .G.~[A]]
      inline given xxChar      [A<:RAW.Char   ] : Def[A,Char   .G.~[A]] = new Def[A,Char   .G.~[A]]
      inline given xxShort     [A<:RAW.Short  ] : Def[A,Short  .G.~[A]] = new Def[A,Short  .G.~[A]]
      inline given xxInt       [A<:RAW.Int    ] : Def[A,Int    .G.~[A]] = new Def[A,Int    .G.~[A]]
      inline given xxLong      [A<:RAW.Long   ] : Def[A,Long   .G.~[A]] = new Def[A,Long   .G.~[A]]
      inline given xxFloat     [A<:RAW.Float  ] : Def[A,Float  .G.~[A]] = new Def[A,Float  .G.~[A]]
      inline given xxDouble    [A<:RAW.Double ] : Def[A,Double .G.~[A]] = new Def[A,Double .G.~[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
