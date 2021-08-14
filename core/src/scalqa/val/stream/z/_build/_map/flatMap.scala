package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions

import a.{ FlatMap as FM }
import gen.`given`.StreamShape

class flatMap[A,B] (x:Stream[A], f: A => ~[B]) extends FM.ToRef[B](x){ def fewOpt = x.read_?.map(f(_))}

object flatMap:
  class toBoolean[A,B<:Boolean.Raw](x:Stream[A], f: A => ~[B]) extends FM.ToBoolean[B](x){ def fewOpt = x.read_?.map(f(_))}
  class toByte   [A,B<:Byte.Raw]   (x:Stream[A], f: A => ~[B]) extends FM.ToByte   [B](x){ def fewOpt = x.read_?.map(f(_))}
  class toChar   [A,B<:Char.Raw]   (x:Stream[A], f: A => ~[B]) extends FM.ToChar   [B](x){ def fewOpt = x.read_?.map(f(_))}
  class toShort  [A,B<:Short.Raw]  (x:Stream[A], f: A => ~[B]) extends FM.ToShort  [B](x){ def fewOpt = x.read_?.map(f(_))}
  class toInt    [A,B<:Int.Raw]    (x:Stream[A], f: A => ~[B]) extends FM.ToInt    [B](x){ def fewOpt = x.read_?.map(f(_))}
  class toLong   [A,B<:Long.Raw]   (x:Stream[A], f: A => ~[B]) extends FM.ToLong   [B](x){ def fewOpt = x.read_?.map(f(_))}
  class toFloat  [A,B<:Float.Raw]  (x:Stream[A], f: A => ~[B]) extends FM.ToFloat  [B](x){ def fewOpt = x.read_?.map(f(_))}
  class toDouble [A,B<:Double.Raw] (x:Stream[A], f: A => ~[B]) extends FM.ToDouble [B](x){ def fewOpt = x.read_?.map(f(_))}

  inline def apply[A,B,STM<: ~~.AnyType[B]](inline x: Stream[A], inline f: A => ~[B], inline s:StreamShape[B,STM] ): STM =
    inline s match
      case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => toBoolean(x,f(_).cast[~[B & Boolean.Raw]])
      case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => toByte   (x,f(_).cast[~[B & Byte.Raw   ]])
      case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => toChar   (x,f(_).cast[~[B & Char.Raw   ]])
      case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => toShort  (x,f(_).cast[~[B & Short.Raw  ]])
      case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => toInt    (x,f(_).cast[~[B & Int.Raw    ]])
      case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => toLong   (x,f(_).cast[~[B & Long.Raw   ]])
      case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => toFloat  (x,f(_).cast[~[B & Float.Raw  ]])
      case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => toDouble (x,f(_).cast[~[B & Double.Raw ]])
      case _ : StreamShape[B,      Val.~[B]]               => new flatMap(x,f(_))

  inline def APPLY[A,B,STM<: ~~.AnyType[B]](x: Stream[A], inline f: A => ~[B], inline s:StreamShape[B,STM] ): STM =
    inline s match
      case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] =>{ class flatMapToBoolean(x: Stream[A]) extends FM.ToBoolean[B & Boolean.Raw](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Boolean.Raw]])}; flatMapToBoolean(x)}
      case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] =>{ class flatMapToByte   (x: Stream[A]) extends FM.ToByte   [B & Byte.Raw   ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Byte.Raw   ]])}; flatMapToByte   (x)}
      case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] =>{ class flatMapToChar   (x: Stream[A]) extends FM.ToChar   [B & Char.Raw   ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Char.Raw   ]])}; flatMapToChar   (x)}
      case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] =>{ class flatMapToShort  (x: Stream[A]) extends FM.ToShort  [B & Short.Raw  ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Short.Raw  ]])}; flatMapToShort  (x)}
      case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] =>{ class flatMapToInt    (x: Stream[A]) extends FM.ToInt    [B & Int.Raw    ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Int.Raw    ]])}; flatMapToInt    (x)}
      case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] =>{ class flatMapToLong   (x: Stream[A]) extends FM.ToLong   [B & Long.Raw   ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Long.Raw   ]])}; flatMapToLong   (x)}
      case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] =>{ class flatMapToFloat  (x: Stream[A]) extends FM.ToFloat  [B & Float.Raw  ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Float.Raw  ]])}; flatMapToFloat  (x)}
      case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] =>{ class flatMapToDouble (x: Stream[A]) extends FM.ToDouble [B & Double.Raw ](x){ def fewOpt=x.read_?.map(f(_).cast[~[B & Double.Raw ]])}; flatMapToDouble (x)}
      case _ : StreamShape[B,      Val.~[B]]               =>{ class flatMap         (x: Stream[A]) extends FM.ToRef    [B]              (x){ def fewOpt=x.read_?.map(f(_))};                          new flatMap     (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
