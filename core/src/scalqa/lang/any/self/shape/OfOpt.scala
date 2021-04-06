package scalqa; package lang; package any; package self; package shape; import language.implicitConversions

import Any.{ Raw as RAW }

object OfOpt:

  type   Any[A] = Opt[A] | Raw[A]
  object Any:
    class  Def[A, OPT <: OfOpt.Any[A]]
    object Def extends zDefDefault:
      inline given xxBoolean[A<:RAW.Boolean] : Def[A,Boolean.G.Opt[A]] = new Def[A, Boolean.G.Opt[A]]
      inline given xxByte   [A<:RAW.Byte   ] : Def[A,Byte   .G.Opt[A]] = new Def[A, Byte   .G.Opt[A]]
      inline given xxChar   [A<:RAW.Char   ] : Def[A,Char   .G.Opt[A]] = new Def[A, Char   .G.Opt[A]]
      inline given xxShort  [A<:RAW.Short  ] : Def[A,Short  .G.Opt[A]] = new Def[A, Short  .G.Opt[A]]
      inline given xxInt    [A<:RAW.Int    ] : Def[A,Int    .G.Opt[A]] = new Def[A, Int    .G.Opt[A]]
      inline given xxLong   [A<:RAW.Long   ] : Def[A,Long   .G.Opt[A]] = new Def[A, Long   .G.Opt[A]]
      inline given xxFloat  [A<:RAW.Float  ] : Def[A,Float  .G.Opt[A]] = new Def[A, Float  .G.Opt[A]]
      inline given xxDouble [A<:RAW.Double ] : Def[A,Double .G.Opt[A]] = new Def[A, Double .G.Opt[A]]
      inline given xxRef    [A<:Lang.Any.Ref] : Def[A,      Val.Opt[A]] = new Def[A,       Val.Opt[A]]
    private[OfOpt] class zDefDefault:
      inline given xxAny    [A             ] : Def[A,      Val.Opt[A]] = new Def[A,       Val.Opt[A]]

    extension[A](x: Any[A])
      private[scalqa] inline def SOME: Boolean = inline x match
        case _: lang.boolean.G.Opt[A] => x.cast[lang.boolean.G.Opt[A & RAW.Boolean]].nonEmpty
        case _: lang.byte   .G.Opt[A] => x.cast[lang.byte   .G.Opt[A & RAW.Byte   ]].nonEmpty
        case _: lang.char   .G.Opt[A] => x.cast[lang.char   .G.Opt[A & RAW.Char   ]].nonEmpty
        case _: lang.short  .G.Opt[A] => x.cast[lang.short  .G.Opt[A & RAW.Short  ]].nonEmpty
        case _: lang.int    .G.Opt[A] => x.cast[lang.int    .G.Opt[A & RAW.Int    ]].nonEmpty
        case _: lang.long   .G.Opt[A] => x.cast[lang.long   .G.Opt[A & RAW.Long   ]].nonEmpty
        case _: lang.float  .G.Opt[A] => x.cast[lang.float  .G.Opt[A & RAW.Float  ]].nonEmpty
        case _: lang.double .G.Opt[A] => x.cast[lang.double .G.Opt[A & RAW.Double ]].nonEmpty
        case v:             Val.Opt[A] => x.cast[          Val.Opt[A              ]].nonEmpty

      private[scalqa] inline def VAL: A = inline x match
        case _: lang.boolean.G.Opt[A] => x.cast[lang.boolean.G.Opt[A & RAW.Boolean]].`val`
        case _: lang.byte   .G.Opt[A] => x.cast[lang.byte   .G.Opt[A & RAW.Byte   ]].`val`
        case _: lang.char   .G.Opt[A] => x.cast[lang.char   .G.Opt[A & RAW.Char   ]].`val`
        case _: lang.short  .G.Opt[A] => x.cast[lang.short  .G.Opt[A & RAW.Short  ]].`val`
        case _: lang.int    .G.Opt[A] => x.cast[lang.int    .G.Opt[A & RAW.Int    ]].`val`
        case _: lang.long   .G.Opt[A] => x.cast[lang.long   .G.Opt[A & RAW.Long   ]].`val`
        case _: lang.float  .G.Opt[A] => x.cast[lang.float  .G.Opt[A & RAW.Float  ]].`val`
        case _: lang.double .G.Opt[A] => x.cast[lang.double .G.Opt[A & RAW.Double ]].`val`
        case v:             Val.Opt[A] => x.cast[          Val.Opt[A              ]].`val`

  // ***************************************************************************************************************
  import lang.boolean.G.{Opt as BOOLEAN}; import lang.byte.G.{Opt as BYTE}; import lang.char .G.{Opt as CHAR};  import lang.short .G.{Opt as SHORT}
  import lang.int    .G.{Opt as INT};     import lang.long.G.{Opt as LONG}; import lang.float.G.{Opt as FLOAT}; import lang.double.G.{Opt as DOUBLE}

  type   Raw[A] = BOOLEAN[A & RAW.Boolean] | BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]

  object Raw:

    sealed class Def[A, OPT <: Raw[A]] extends Any.Def[A,OPT]

    object Def:
      inline given xxBoolean[A<:RAW.Boolean] : Def[A,Boolean.G.Opt[A]] = new Def[A,Boolean.G.Opt[A]]()
      inline given xxByte   [A<:RAW.Byte   ] : Def[A,Byte   .G.Opt[A]] = new Def[A,Byte   .G.Opt[A]]()
      inline given xxChar   [A<:RAW.Char   ] : Def[A,Char   .G.Opt[A]] = new Def[A,Char   .G.Opt[A]]()
      inline given xxShort  [A<:RAW.Short  ] : Def[A,Short  .G.Opt[A]] = new Def[A,Short  .G.Opt[A]]()
      inline given xxInt    [A<:RAW.Int    ] : Def[A,Int    .G.Opt[A]] = new Def[A,Int    .G.Opt[A]]()
      inline given xxLong   [A<:RAW.Long   ] : Def[A,Long   .G.Opt[A]] = new Def[A,Long   .G.Opt[A]]()
      inline given xxFloat  [A<:RAW.Float  ] : Def[A,Float  .G.Opt[A]] = new Def[A,Float  .G.Opt[A]]()
      inline given xxDouble [A<:RAW.Double ] : Def[A,Double .G.Opt[A]] = new Def[A,Double .G.Opt[A]]()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
