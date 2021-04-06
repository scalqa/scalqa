package scalqa; package `val`; package stream; package z; package build; package mutate; import language.implicitConversions

import Any.{Raw as RAW}
import Shape.OfStream.Raw
import z.a.Map

object raw:
  class Booleans[A<:RAW.Boolean](x: ~[A]) extends Map.ToBoolean[A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Bytes   [A<:RAW.Byte]   (x: ~[A]) extends Map.ToByte   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Chars   [A<:RAW.Char]   (x: ~[A]) extends Map.ToChar   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Shorts  [A<:RAW.Short]  (x: ~[A]) extends Map.ToShort  [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Ints    [A<:RAW.Int]    (x: ~[A]) extends Map.ToInt    [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Longs   [A<:RAW.Long]   (x: ~[A]) extends Map.ToLong   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Floats  [A<:RAW.Float]  (x: ~[A]) extends Map.ToFloat  [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Doubles [A<:RAW.Double] (x: ~[A]) extends Map.ToDouble [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }

  def boolean[A<:RAW.Boolean](x: ~[A]): Boolean.G.~[A] = x match{case v: Boolean.G.~[_] => v.cast[Boolean.G.~[A]]; case v => Booleans(v)}
  def byte   [A<:RAW.Byte   ](x: ~[A]): Byte   .G.~[A] = x match{case v: Byte   .G.~[_] => v.cast[Byte   .G.~[A]]; case v => Bytes(v)}
  def char   [A<:RAW.Char   ](x: ~[A]): Char   .G.~[A] = x match{case v: Char   .G.~[_] => v.cast[Char   .G.~[A]]; case v => Chars(v)}
  def short  [A<:RAW.Short  ](x: ~[A]): Short  .G.~[A] = x match{case v: Short  .G.~[_] => v.cast[Short  .G.~[A]]; case v => Shorts(v)}
  def int    [A<:RAW.Int    ](x: ~[A]): Int    .G.~[A] = x match{case v: Int    .G.~[_] => v.cast[Int    .G.~[A]]; case v => Ints(v)}
  def long   [A<:RAW.Long   ](x: ~[A]): Long   .G.~[A] = x match{case v: Long   .G.~[_] => v.cast[Long   .G.~[A]]; case v => Longs(v)}
  def float  [A<:RAW.Float  ](x: ~[A]): Float  .G.~[A] = x match{case v: Float  .G.~[_] => v.cast[Float  .G.~[A]]; case v => Floats(v)}
  def double [A<:RAW.Double ](x: ~[A]): Double .G.~[A] = x match{case v: Double .G.~[_] => v.cast[Double .G.~[A]]; case v => Doubles(v)}

  inline def apply[A,RAW<:Raw[A]](inline x:Stream[A], inline s: Raw.Def[A,RAW]): RAW  =
    inline x match
      case _ : Boolean.G.~[A] => x.cast[RAW]
      case _ : Byte   .G.~[A] => x.cast[RAW]
      case _ : Char   .G.~[A] => x.cast[RAW]
      case _ : Short  .G.~[A] => x.cast[RAW]
      case _ : Int    .G.~[A] => x.cast[RAW]
      case _ : Long   .G.~[A] => x.cast[RAW]
      case _ : Float  .G.~[A] => x.cast[RAW]
      case _ : Double .G.~[A] => x.cast[RAW]
      case _ => inline s match
          case _ : Raw.Def[A,Boolean.G.~[A & RAW.Boolean]] => boolean[A & RAW.Boolean](x.cast[~[A & RAW.Boolean]])
          case _ : Raw.Def[A,Byte   .G.~[A & RAW.Byte   ]] => byte   (x.cast[~[A & RAW.Byte   ]])
          case _ : Raw.Def[A,Char   .G.~[A & RAW.Char   ]] => char   (x.cast[~[A & RAW.Char   ]])
          case _ : Raw.Def[A,Short  .G.~[A & RAW.Short  ]] => short  (x.cast[~[A & RAW.Short  ]])
          case _ : Raw.Def[A,Int    .G.~[A & RAW.Int    ]] => int    (x.cast[~[A & RAW.Int    ]])
          case _ : Raw.Def[A,Long   .G.~[A & RAW.Long   ]] => long   (x.cast[~[A & RAW.Long   ]])
          case _ : Raw.Def[A,Float  .G.~[A & RAW.Float  ]] => float  (x.cast[~[A & RAW.Float  ]])
          case _ : Raw.Def[A,Double .G.~[A & RAW.Double ]] => double (x.cast[~[A & RAW.Double ]])
          case _                                              => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
