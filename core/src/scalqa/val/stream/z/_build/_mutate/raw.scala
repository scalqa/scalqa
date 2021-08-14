package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

import lang.any.{Raw as RAW}
import gen.`given`.StreamShape
import z.a.Map

object raw:
  class toBoolean[A<:Boolean.Raw](x: ~[A]) extends Map.ToBoolean[A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toByte   [A<:Byte.Raw]   (x: ~[A]) extends Map.ToByte   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toChar   [A<:Char.Raw]   (x: ~[A]) extends Map.ToChar   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toShort  [A<:Short.Raw]  (x: ~[A]) extends Map.ToShort  [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toInt    [A<:Int.Raw]    (x: ~[A]) extends Map.ToInt    [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toLong   [A<:Long.Raw]   (x: ~[A]) extends Map.ToLong   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toFloat  [A<:Float.Raw]  (x: ~[A]) extends Map.ToFloat  [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toDouble [A<:Double.Raw] (x: ~[A]) extends Map.ToDouble [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }

  def boolean[A<:Boolean.Raw](x: ~[A]): Boolean.G.~[A] = x match{case v: Boolean.G.~[_] => v.cast[Boolean.G.~[A]]; case v => toBoolean(v)}
  def byte   [A<:Byte.Raw   ](x: ~[A]): Byte   .G.~[A] = x match{case v: Byte   .G.~[_] => v.cast[Byte   .G.~[A]]; case v => toByte(v)}
  def char   [A<:Char.Raw   ](x: ~[A]): Char   .G.~[A] = x match{case v: Char   .G.~[_] => v.cast[Char   .G.~[A]]; case v => toChar(v)}
  def short  [A<:Short.Raw  ](x: ~[A]): Short  .G.~[A] = x match{case v: Short  .G.~[_] => v.cast[Short  .G.~[A]]; case v => toShort(v)}
  def int    [A<:Int.Raw    ](x: ~[A]): Int    .G.~[A] = x match{case v: Int    .G.~[_] => v.cast[Int    .G.~[A]]; case v => toInt(v)}
  def long   [A<:Long.Raw   ](x: ~[A]): Long   .G.~[A] = x match{case v: Long   .G.~[_] => v.cast[Long   .G.~[A]]; case v => toLong(v)}
  def float  [A<:Float.Raw  ](x: ~[A]): Float  .G.~[A] = x match{case v: Float  .G.~[_] => v.cast[Float  .G.~[A]]; case v => toFloat(v)}
  def double [A<:Double.Raw ](x: ~[A]): Double .G.~[A] = x match{case v: Double .G.~[_] => v.cast[Double .G.~[A]]; case v => toDouble(v)}

  inline def apply[A,RAW<: ~~.RawType[A]](inline x:Stream[A], inline s: StreamShape.Raw[A,RAW]): RAW  =
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
          case _ : StreamShape.Raw[A,Boolean.G.~[A & Boolean.Raw]] => boolean[A & Boolean.Raw](x.cast[~[A & Boolean.Raw]])
          case _ : StreamShape.Raw[A,Byte   .G.~[A & Byte.Raw   ]] => byte   (x.cast[~[A & Byte.Raw   ]])
          case _ : StreamShape.Raw[A,Char   .G.~[A & Char.Raw   ]] => char   (x.cast[~[A & Char.Raw   ]])
          case _ : StreamShape.Raw[A,Short  .G.~[A & Short.Raw  ]] => short  (x.cast[~[A & Short.Raw  ]])
          case _ : StreamShape.Raw[A,Int    .G.~[A & Int.Raw    ]] => int    (x.cast[~[A & Int.Raw    ]])
          case _ : StreamShape.Raw[A,Long   .G.~[A & Long.Raw   ]] => long   (x.cast[~[A & Long.Raw   ]])
          case _ : StreamShape.Raw[A,Float  .G.~[A & Float.Raw  ]] => float  (x.cast[~[A & Float.Raw  ]])
          case _ : StreamShape.Raw[A,Double .G.~[A & Double.Raw ]] => double (x.cast[~[A & Double.Raw ]])
          case _                                                   => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
