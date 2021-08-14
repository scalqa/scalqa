package scalqa; package lang; package int; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.{ FlatMap => FM }
import g.Fun.{ ToMany => FUN }
import gen.`given`.StreamShape

class  flatMap   [A<:Raw,B             ](x: G.~[A], f: FUN[A,B]) extends FM.ToRef    [B](x){ def fewOpt = x.read_?.map(f(_))}
object flatMap:
  class toBoolean[A<:Raw,B<:Boolean.Raw](x: G.~[A], f: FUN[A,B]) extends FM.ToBoolean[B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toByte   [A<:Raw,B<:Byte.Raw   ](x: G.~[A], f: FUN[A,B]) extends FM.ToByte   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toChar   [A<:Raw,B<:Char.Raw   ](x: G.~[A], f: FUN[A,B]) extends FM.ToChar   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toShort  [A<:Raw,B<:Short.Raw  ](x: G.~[A], f: FUN[A,B]) extends FM.ToShort  [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toInt    [A<:Raw,B<:Int.Raw    ](x: G.~[A], f: FUN[A,B]) extends FM.ToInt    [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toLong   [A<:Raw,B<:Long.Raw   ](x: G.~[A], f: FUN[A,B]) extends FM.ToLong   [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toFloat  [A<:Raw,B<:Float.Raw  ](x: G.~[A], f: FUN[A,B]) extends FM.ToFloat  [B](x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toDouble [A<:Raw,B<:Double.Raw ](x: G.~[A], f: FUN[A,B]) extends FM.ToDouble [B](x){ def fewOpt = x.readRaw_?.map(f(_))}

  inline def apply[A<:Raw,B,STM<: ~~.AnyType[B]](inline x: G.~[A], inline f: A => ~[B], inline s:StreamShape[B,STM] ): STM =
    inline s match
      case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => new toBoolean(x,f(_).cast[~[B & Boolean.Raw]])
      case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => new toByte   (x,f(_).cast[~[B & Byte.Raw   ]])
      case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => new toChar   (x,f(_).cast[~[B & Char.Raw   ]])
      case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => new toShort  (x,f(_).cast[~[B & Short.Raw  ]])
      case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => new toInt    (x,f(_).cast[~[B & Int.Raw    ]])
      case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => new toLong   (x,f(_).cast[~[B & Long.Raw   ]])
      case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => new toFloat  (x,f(_).cast[~[B & Float.Raw  ]])
      case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => new toDouble (x,f(_).cast[~[B & Double.Raw ]])
      case _ : StreamShape[B,AnyRef .G.~[B]]               => new flatMap  (x,f(_))

  inline def APPLY[A<:Raw,B,STM<: ~~.AnyType[B]](x: G.~[A], inline f: A => ~[B], inline s:StreamShape[B,STM] ): STM =
    inline s match
      case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] =>{ class flatMapToBoolean(x: G.~[A]) extends FM.ToBoolean[B & Boolean.Raw](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Boolean.Raw]])}; new flatMapToBoolean(x)}
      case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] =>{ class flatMapToByte   (x: G.~[A]) extends FM.ToByte   [B & Byte.Raw   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Byte.Raw   ]])}; new flatMapToByte   (x)}
      case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] =>{ class flatMapToChar   (x: G.~[A]) extends FM.ToChar   [B & Char.Raw   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Char.Raw   ]])}; new flatMapToChar   (x)}
      case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] =>{ class flatMapToShort  (x: G.~[A]) extends FM.ToShort  [B & Short.Raw  ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Short.Raw  ]])}; new flatMapToShort  (x)}
      case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] =>{ class flatMapToInt    (x: G.~[A]) extends FM.ToInt    [B & Int.Raw    ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Int.Raw    ]])}; new flatMapToInt    (x)}
      case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] =>{ class flatMapToLong   (x: G.~[A]) extends FM.ToLong   [B & Long.Raw   ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Long.Raw   ]])}; new flatMapToLong   (x)}
      case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] =>{ class flatMapToFloat  (x: G.~[A]) extends FM.ToFloat  [B & Float.Raw  ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Float.Raw  ]])}; new flatMapToFloat  (x)}
      case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] =>{ class flatMapToDouble (x: G.~[A]) extends FM.ToDouble [B & Double.Raw ](x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[B & Double.Raw ]])}; new flatMapToDouble (x)}
      case _ : StreamShape[B,AnyRef .G.~[B]]               =>{ class flatMap         (x: G.~[A]) extends FM.ToRef    [B]              (x){ def fewOpt=x.read_?.map(f(_))};                             new flatMap         (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
