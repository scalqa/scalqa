package scalqa; package `val`; package stream; package z; package build; package mutate; import language.implicitConversions

import Shape.OfStream.*
import z.a.Map

object raw:
  class Booleans[A<:Raw.Boolean](x: ~[A]) extends Map.ToBoolean[A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Bytes   [A<:Raw.Byte]   (x: ~[A]) extends Map.ToByte   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Chars   [A<:Raw.Char]   (x: ~[A]) extends Map.ToChar   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Shorts  [A<:Raw.Short]  (x: ~[A]) extends Map.ToShort  [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Ints    [A<:Raw.Int]    (x: ~[A]) extends Map.ToInt    [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Longs   [A<:Raw.Long]   (x: ~[A]) extends Map.ToLong   [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Floats  [A<:Raw.Float]  (x: ~[A]) extends Map.ToFloat  [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class Doubles [A<:Raw.Double] (x: ~[A]) extends Map.ToDouble [A](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }

  def boolean[A<:Raw.Boolean](x: ~[A]): Boolean.G.~[A] = x match{case v: Boolean.G.~[_] => v.cast[Boolean.G.~[A]]; case v => Booleans(v)}
  def byte   [A<:Raw.Byte   ](x: ~[A]): Byte   .G.~[A] = x match{case v: Byte   .G.~[_] => v.cast[Byte   .G.~[A]]; case v => Bytes(v)}
  def char   [A<:Raw.Char   ](x: ~[A]): Char   .G.~[A] = x match{case v: Char   .G.~[_] => v.cast[Char   .G.~[A]]; case v => Chars(v)}
  def short  [A<:Raw.Short  ](x: ~[A]): Short  .G.~[A] = x match{case v: Short  .G.~[_] => v.cast[Short  .G.~[A]]; case v => Shorts(v)}
  def int    [A<:Raw.Int    ](x: ~[A]): Int    .G.~[A] = x match{case v: Int    .G.~[_] => v.cast[Int    .G.~[A]]; case v => Ints(v)}
  def long   [A<:Raw.Long   ](x: ~[A]): Long   .G.~[A] = x match{case v: Long   .G.~[_] => v.cast[Long   .G.~[A]]; case v => Longs(v)}
  def float  [A<:Raw.Float  ](x: ~[A]): Float  .G.~[A] = x match{case v: Float  .G.~[_] => v.cast[Float  .G.~[A]]; case v => Floats(v)}
  def double [A<:Raw.Double ](x: ~[A]): Double .G.~[A] = x match{case v: Double .G.~[_] => v.cast[Double .G.~[A]]; case v => Doubles(v)}

  inline def apply[A,RAW<:Raw[A]](inline x:Stream[A], inline s: Tag.Raw[A,RAW]): RAW  =
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
          case _ : Tag.Raw[A,Boolean.G.~[A & Raw.Boolean]] => boolean[A & Raw.Boolean](x.cast[~[A & Raw.Boolean]])
          case _ : Tag.Raw[A,Byte   .G.~[A & Raw.Byte   ]] => byte   (x.cast[~[A & Raw.Byte   ]])
          case _ : Tag.Raw[A,Char   .G.~[A & Raw.Char   ]] => char   (x.cast[~[A & Raw.Char   ]])
          case _ : Tag.Raw[A,Short  .G.~[A & Raw.Short  ]] => short  (x.cast[~[A & Raw.Short  ]])
          case _ : Tag.Raw[A,Int    .G.~[A & Raw.Int    ]] => int    (x.cast[~[A & Raw.Int    ]])
          case _ : Tag.Raw[A,Long   .G.~[A & Raw.Long   ]] => long   (x.cast[~[A & Raw.Long   ]])
          case _ : Tag.Raw[A,Float  .G.~[A & Raw.Float  ]] => float  (x.cast[~[A & Raw.Float  ]])
          case _ : Tag.Raw[A,Double .G.~[A & Raw.Double ]] => double (x.cast[~[A & Raw.Double ]])
          case _                                              => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
