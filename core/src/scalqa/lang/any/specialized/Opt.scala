package scalqa; package lang; package any; package specialized; import language.implicitConversions

abstract class Opt[A,OPT<:Any.Opt[A]]:
  inline def apply[B](inline v: B, inline f:B=>OPT): Any.Opt[A]

object Opt extends zOptDefault:
  inline given givenBooleanOpt   [A<:Any.Boolean ]: X.BooleanRaw[A] = new X.BooleanRaw[A]
  inline given givenByteOpt      [A<:Any.Byte    ]: X.ByteRaw[A]    = new X.ByteRaw[A]
  inline given givenCharOpt      [A<:Any.Char    ]: X.CharRaw[A]    = new X.CharRaw[A]
  inline given givenShortOpt     [A<:Any.Short   ]: X.ShortRaw[A]   = new X.ShortRaw[A]
  inline given givenIntOpt       [A<:Any.Int     ]: X.IntRaw[A]     = new X.IntRaw[A]
  inline given givenLongOpt      [A<:Any.Long    ]: X.LongRaw[A]    = new X.LongRaw[A]
  inline given givenFloatOpt     [A<:Any.Float   ]: X.FloatRaw[A]   = new X.FloatRaw[A]
  inline given givenDoubleOpt    [A<:Any.Double  ]: X.DoubleRaw[A]  = new X.DoubleRaw[A]

  inline given givenValOptBoolean[A<:Any.Boolean ]: X.BooleanRef[A] = new X.BooleanRef[A]
  inline given givenValOptByte   [A<:Any.Byte    ]: X.ByteRef[A]    = new X.ByteRef[A]
  inline given givenValOptChar   [A<:Any.Char    ]: X.CharRef[A]    = new X.CharRef[A]
  inline given givenValOptShort  [A<:Any.Short   ]: X.ShortRef[A]   = new X.ShortRef[A]
  inline given givenValOptInt    [A<:Any.Int     ]: X.IntRef[A]     = new X.IntRef[A]
  inline given givenValOptLong   [A<:Any.Long    ]: X.LongRef[A]    = new X.LongRef[A]
  inline given givenValOptFloat  [A<:Any.Float   ]: X.FloatRef[A]   = new X.FloatRef[A]
  inline given givenValOptDouble [A<:Any.Double  ]: X.DoubleRef[A]  = new X.DoubleRef[A]
  inline given givenValOptAnyRef [A<:scala.AnyRef]: X.AnyRef[A]     = new X.AnyRef[A]

  object X:
    class BooleanRaw[A<:Any.Boolean ] extends Opt[A,Boolean.G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Boolean.G.Opt[A]): Boolean.G.Opt[A] = f(v) }
    class ByteRaw   [A<:Any.Byte    ] extends Opt[A,Byte   .G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Byte   .G.Opt[A]): Byte   .G.Opt[A] = f(v) }
    class CharRaw   [A<:Any.Char    ] extends Opt[A,Char   .G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Char   .G.Opt[A]): Char   .G.Opt[A] = f(v) }
    class ShortRaw  [A<:Any.Short   ] extends Opt[A,Short  .G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Short  .G.Opt[A]): Short  .G.Opt[A] = f(v) }
    class IntRaw    [A<:Any.Int     ] extends Opt[A,Int    .G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Int    .G.Opt[A]): Int    .G.Opt[A] = f(v) }
    class LongRaw   [A<:Any.Long    ] extends Opt[A,Long   .G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Long   .G.Opt[A]): Long   .G.Opt[A] = f(v) }
    class FloatRaw  [A<:Any.Float   ] extends Opt[A,Float  .G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Float  .G.Opt[A]): Float  .G.Opt[A] = f(v) }
    class DoubleRaw [A<:Any.Double  ] extends Opt[A,Double .G.Opt[A]]{ inline def apply[B](inline v:B, inline f:B=>Double .G.Opt[A]): Double .G.Opt[A] = f(v) }

    class BooleanRef[A<:Any.Boolean ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Boolean.G.Opt[A] = f(v).raw }
    class ByteRef   [A<:Any.Byte    ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Byte   .G.Opt[A] = f(v).raw }
    class CharRef   [A<:Any.Char    ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Char   .G.Opt[A] = f(v).raw }
    class ShortRef  [A<:Any.Short   ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Short  .G.Opt[A] = f(v).raw }
    class IntRef    [A<:Any.Int     ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Int    .G.Opt[A] = f(v).raw }
    class LongRef   [A<:Any.Long    ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Long   .G.Opt[A] = f(v).raw }
    class FloatRef  [A<:Any.Float   ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Float  .G.Opt[A] = f(v).raw }
    class DoubleRef [A<:Any.Double  ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Double .G.Opt[A] = f(v).raw }
    class AnyRef    [A              ] extends Opt[A,Val.Opt[A]      ]{ inline def apply[B](inline v:B, inline f:B=>Val.Opt[A]      ): Val.Opt[A]       = f(v) }

private[any] class zOptDefault:
  inline given givenValOpt[A]: Opt.X.AnyRef[A] = new Opt.X.AnyRef[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extention
*/
