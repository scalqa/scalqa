package scalqa; package `def`; package float; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.{ FlatMap => FM }
import g.Fun.{ ToMany => FUN }
import Shape.OfStream.*

object flatMap:
  class Booleans[A<:RAW,B<:Raw.Boolean](x: G.~[A], f: FUN[A,B]) extends FM.ToBoolean[B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Bytes   [A<:RAW,B<:Raw.Byte   ](x: G.~[A], f: FUN[A,B]) extends FM.ToByte   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Chars   [A<:RAW,B<:Raw.Char   ](x: G.~[A], f: FUN[A,B]) extends FM.ToChar   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Shorts  [A<:RAW,B<:Raw.Short  ](x: G.~[A], f: FUN[A,B]) extends FM.ToShort  [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Ints    [A<:RAW,B<:Raw.Int    ](x: G.~[A], f: FUN[A,B]) extends FM.ToInt    [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Longs   [A<:RAW,B<:Raw.Long   ](x: G.~[A], f: FUN[A,B]) extends FM.ToLong   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Floats  [A<:RAW,B<:Raw.Float  ](x: G.~[A], f: FUN[A,B]) extends FM.ToFloat  [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Doubles [A<:RAW,B<:Raw.Double ](x: G.~[A], f: FUN[A,B]) extends FM.ToDouble [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class Refs    [A<:RAW,B             ](x: G.~[A], f: FUN[A,B]) extends FM.ToRef    [B](x){ def fewOpt = x.read_?.map(f(_))}

  inline def apply[A<:RAW,B,STM<:Any[B]](inline x: G.~[A], inline f: A => ~[B], inline s:Tag[B,STM] ): STM =
    inline s match
      case _ : Tag[B,Boolean.G.~[B & Raw.Boolean]] => Booleans(x,f(_).cast[~[B & Raw.Boolean]])
      case _ : Tag[B,Byte   .G.~[B & Raw.Byte   ]] => Bytes   (x,f(_).cast[~[B & Raw.Byte   ]])
      case _ : Tag[B,Char   .G.~[B & Raw.Char   ]] => Chars   (x,f(_).cast[~[B & Raw.Char   ]])
      case _ : Tag[B,Short  .G.~[B & Raw.Short  ]] => Shorts  (x,f(_).cast[~[B & Raw.Short  ]])
      case _ : Tag[B,Int    .G.~[B & Raw.Int    ]] => Ints    (x,f(_).cast[~[B & Raw.Int    ]])
      case _ : Tag[B,Long   .G.~[B & Raw.Long   ]] => Longs   (x,f(_).cast[~[B & Raw.Long   ]])
      case _ : Tag[B,Float  .G.~[B & Raw.Float  ]] => Floats  (x,f(_).cast[~[B & Raw.Float  ]])
      case _ : Tag[B,Double .G.~[B & Raw.Double ]] => Doubles (x,f(_).cast[~[B & Raw.Double ]])
      case _ : Tag[B,      Val.~[B]]               => Refs    (x,f(_))

  inline def APPLY[A<:RAW,B,STM<:Any[B]](x: G.~[A], inline f: A => ~[B], inline s:Tag[B,STM] ): STM =
    inline s match
      case _ : Tag[B,Boolean.G.~[B & Raw.Boolean]] =>{ class Booleans(x: G.~[A]) extends FM.ToBoolean[B & Raw.Boolean](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Boolean]])}; Booleans(x)}
      case _ : Tag[B,Byte   .G.~[B & Raw.Byte   ]] =>{ class Bytes   (x: G.~[A]) extends FM.ToByte   [B & Raw.Byte   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Byte   ]])}; Bytes   (x)}
      case _ : Tag[B,Char   .G.~[B & Raw.Char   ]] =>{ class Chars   (x: G.~[A]) extends FM.ToChar   [B & Raw.Char   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Char   ]])}; Chars   (x)}
      case _ : Tag[B,Short  .G.~[B & Raw.Short  ]] =>{ class Shorts  (x: G.~[A]) extends FM.ToShort  [B & Raw.Short  ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Short  ]])}; Shorts  (x)}
      case _ : Tag[B,Int    .G.~[B & Raw.Int    ]] =>{ class Ints    (x: G.~[A]) extends FM.ToInt    [B & Raw.Int    ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Int    ]])}; Ints    (x)}
      case _ : Tag[B,Long   .G.~[B & Raw.Long   ]] =>{ class Longs   (x: G.~[A]) extends FM.ToLong   [B & Raw.Long   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Long   ]])}; Longs   (x)}
      case _ : Tag[B,Float  .G.~[B & Raw.Float  ]] =>{ class Floats  (x: G.~[A]) extends FM.ToFloat  [B & Raw.Float  ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Float  ]])}; Floats  (x)}
      case _ : Tag[B,Double .G.~[B & Raw.Double ]] =>{ class Doubles (x: G.~[A]) extends FM.ToDouble [B & Raw.Double ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Raw.Double ]])}; Doubles (x)}
      case _ : Tag[B,      Val.~[B]]               =>{ class Refs    (x: G.~[A]) extends FM.ToRef    [B]              (x){ def fewOpt=x.read_?.map(f(_))};                             Refs    (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
