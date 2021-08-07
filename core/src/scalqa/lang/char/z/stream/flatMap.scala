package scalqa; package lang; package char; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.{ FlatMap => FM }
import g.Fun.{ ToMany => FUN }
import gen.`given`.StreamShape

object flatMap:
  class Booleans[A<:Raw,B<:Boolean.Raw](x: G.~[A], f: FUN[A,B]) extends FM.ToBoolean[B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Bytes   [A<:Raw,B<:Byte.Raw   ](x: G.~[A], f: FUN[A,B]) extends FM.ToByte   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Chars   [A<:Raw,B<:Char.Raw   ](x: G.~[A], f: FUN[A,B]) extends FM.ToChar   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Shorts  [A<:Raw,B<:Short.Raw  ](x: G.~[A], f: FUN[A,B]) extends FM.ToShort  [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Ints    [A<:Raw,B<:Int.Raw    ](x: G.~[A], f: FUN[A,B]) extends FM.ToInt    [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Longs   [A<:Raw,B<:Long.Raw   ](x: G.~[A], f: FUN[A,B]) extends FM.ToLong   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Floats  [A<:Raw,B<:Float.Raw  ](x: G.~[A], f: FUN[A,B]) extends FM.ToFloat  [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Doubles [A<:Raw,B<:Double.Raw ](x: G.~[A], f: FUN[A,B]) extends FM.ToDouble [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Refs    [A<:Raw,B             ](x: G.~[A], f: FUN[A,B]) extends FM.ToRef    [B](x){ def fewOpt = x.read_?.map(f(_))}

  inline def apply[A<:Raw,B,STM<: ~~.AnyType[B]](inline x: G.~[A], inline f: A => ~[B], inline s:StreamShape[B,STM] ): STM =
    inline s match
      case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => Booleans(x,f(_).cast[~[B & Boolean.Raw]])
      case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => Bytes   (x,f(_).cast[~[B & Byte.Raw   ]])
      case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => Chars   (x,f(_).cast[~[B & Char.Raw   ]])
      case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => Shorts  (x,f(_).cast[~[B & Short.Raw  ]])
      case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => Ints    (x,f(_).cast[~[B & Int.Raw    ]])
      case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => Longs   (x,f(_).cast[~[B & Long.Raw   ]])
      case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => Floats  (x,f(_).cast[~[B & Float.Raw  ]])
      case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => Doubles (x,f(_).cast[~[B & Double.Raw ]])
      case _ : StreamShape[B,      Val.~[B]]               => Refs    (x,f(_))

  inline def APPLY[A<:Raw,B,STM<: ~~.AnyType[B]](x: G.~[A], inline f: A => ~[B], inline s:StreamShape[B,STM] ): STM =
    inline s match
      case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] =>{ class Booleans(x: G.~[A]) extends FM.ToBoolean[B & Boolean.Raw](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Boolean.Raw]])}; Booleans(x)}
      case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] =>{ class Bytes   (x: G.~[A]) extends FM.ToByte   [B & Byte.Raw   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Byte.Raw   ]])}; Bytes   (x)}
      case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] =>{ class Chars   (x: G.~[A]) extends FM.ToChar   [B & Char.Raw   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Char.Raw   ]])}; Chars   (x)}
      case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] =>{ class Shorts  (x: G.~[A]) extends FM.ToShort  [B & Short.Raw  ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Short.Raw  ]])}; Shorts  (x)}
      case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] =>{ class Ints    (x: G.~[A]) extends FM.ToInt    [B & Int.Raw    ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Int.Raw    ]])}; Ints    (x)}
      case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] =>{ class Longs   (x: G.~[A]) extends FM.ToLong   [B & Long.Raw   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Long.Raw   ]])}; Longs   (x)}
      case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] =>{ class Floats  (x: G.~[A]) extends FM.ToFloat  [B & Float.Raw  ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Float.Raw  ]])}; Floats  (x)}
      case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] =>{ class Doubles (x: G.~[A]) extends FM.ToDouble [B & Double.Raw ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Double.Raw ]])}; Doubles (x)}
      case _ : StreamShape[B,      Val.~[B]]               =>{ class Refs    (x: G.~[A]) extends FM.ToRef    [B]              (x){ def fewOpt=x.read_?.map(f(_))};                             Refs    (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
