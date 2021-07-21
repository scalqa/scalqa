package scalqa; package `val`; package stream; package z; package build; package map; import language.implicitConversions

import a.{ FlatMap as FM }
import gen.`given`.StreamTag

object flatMap:
  class Booleans[A,B<:Raw.Boolean](x:Stream[A], f: A => ~[B]) extends FM.ToBoolean[B](x){ def fewOpt = x.read_?.map(f(_))}
  class Bytes   [A,B<:Raw.Byte]   (x:Stream[A], f: A => ~[B]) extends FM.ToByte   [B](x){ def fewOpt = x.read_?.map(f(_))}
  class Chars   [A,B<:Raw.Char]   (x:Stream[A], f: A => ~[B]) extends FM.ToChar   [B](x){ def fewOpt = x.read_?.map(f(_))}
  class Shorts  [A,B<:Raw.Short]  (x:Stream[A], f: A => ~[B]) extends FM.ToShort  [B](x){ def fewOpt = x.read_?.map(f(_))}
  class Ints    [A,B<:Raw.Int]    (x:Stream[A], f: A => ~[B]) extends FM.ToInt    [B](x){ def fewOpt = x.read_?.map(f(_))}
  class Longs   [A,B<:Raw.Long]   (x:Stream[A], f: A => ~[B]) extends FM.ToLong   [B](x){ def fewOpt = x.read_?.map(f(_))}
  class Floats  [A,B<:Raw.Float]  (x:Stream[A], f: A => ~[B]) extends FM.ToFloat  [B](x){ def fewOpt = x.read_?.map(f(_))}
  class Doubles [A,B<:Raw.Double] (x:Stream[A], f: A => ~[B]) extends FM.ToDouble [B](x){ def fewOpt = x.read_?.map(f(_))}
  class Refs    [A,B]             (x:Stream[A], f: A => ~[B]) extends FM.ToRef    [B](x){ def fewOpt = x.read_?.map(f(_))}

  inline def apply[A,B,STM<: ~~.AnyType[B]](inline x: Stream[A], inline f: A => ~[B], inline s:StreamTag[B,STM] ): STM =
    inline s match
      case _ : StreamTag[B,Boolean.G.~[B & Raw.Boolean]] => Booleans(x,f(_).cast[~[B & Raw.Boolean]])
      case _ : StreamTag[B,Byte   .G.~[B & Raw.Byte   ]] => Bytes   (x,f(_).cast[~[B & Raw.Byte   ]])
      case _ : StreamTag[B,Char   .G.~[B & Raw.Char   ]] => Chars   (x,f(_).cast[~[B & Raw.Char   ]])
      case _ : StreamTag[B,Short  .G.~[B & Raw.Short  ]] => Shorts  (x,f(_).cast[~[B & Raw.Short  ]])
      case _ : StreamTag[B,Int    .G.~[B & Raw.Int    ]] => Ints    (x,f(_).cast[~[B & Raw.Int    ]])
      case _ : StreamTag[B,Long   .G.~[B & Raw.Long   ]] => Longs   (x,f(_).cast[~[B & Raw.Long   ]])
      case _ : StreamTag[B,Float  .G.~[B & Raw.Float  ]] => Floats  (x,f(_).cast[~[B & Raw.Float  ]])
      case _ : StreamTag[B,Double .G.~[B & Raw.Double ]] => Doubles (x,f(_).cast[~[B & Raw.Double ]])
      case _ : StreamTag[B,       Val.~[B]]               => Refs     (x,f(_))

  inline def APPLY[A,B,STM<: ~~.AnyType[B]](x: Stream[A], inline f: A => ~[B], inline s:StreamTag[B,STM] ): STM =
    inline s match
      case _ : StreamTag[B,Boolean.G.~[B & Raw.Boolean]] =>{ class Booleans(x: Stream[A]) extends FM.ToBoolean[B & Raw.Boolean](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Boolean]])}; Booleans(x)}
      case _ : StreamTag[B,Byte   .G.~[B & Raw.Byte   ]] =>{ class Bytes   (x: Stream[A]) extends FM.ToByte   [B & Raw.Byte   ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Byte   ]])}; Bytes   (x)}
      case _ : StreamTag[B,Char   .G.~[B & Raw.Char   ]] =>{ class Chars   (x: Stream[A]) extends FM.ToChar   [B & Raw.Char   ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Char   ]])}; Chars   (x)}
      case _ : StreamTag[B,Short  .G.~[B & Raw.Short  ]] =>{ class Shorts  (x: Stream[A]) extends FM.ToShort  [B & Raw.Short  ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Short  ]])}; Shorts  (x)}
      case _ : StreamTag[B,Int    .G.~[B & Raw.Int    ]] =>{ class Ints    (x: Stream[A]) extends FM.ToInt    [B & Raw.Int    ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Int    ]])}; Ints    (x)}
      case _ : StreamTag[B,Long   .G.~[B & Raw.Long   ]] =>{ class Longs   (x: Stream[A]) extends FM.ToLong   [B & Raw.Long   ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Long   ]])}; Longs   (x)}
      case _ : StreamTag[B,Float  .G.~[B & Raw.Float  ]] =>{ class Floats  (x: Stream[A]) extends FM.ToFloat  [B & Raw.Float  ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Float  ]])}; Floats  (x)}
      case _ : StreamTag[B,Double .G.~[B & Raw.Double ]] =>{ class Doubles (x: Stream[A]) extends FM.ToDouble [B & Raw.Double ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Raw.Double ]])}; Doubles (x)}
      case _ : StreamTag[B,      Val.~[B]]               =>{ class Refs    (x: Stream[A]) extends FM.ToRef    [B]              (x){ def fewOpt=x.read_?.map(f(_))};                          Refs    (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
