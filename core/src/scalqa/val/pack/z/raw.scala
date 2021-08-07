package scalqa; package `val`; package pack; package z; import language.implicitConversions

import gen.`given`.PackShape.{ Raw as SHAPE }

object raw:

  def boolean[A<:Boolean.Raw](x: ><[A]): Boolean.G.><[A] = x match{case v: Boolean.G.><[A] => v; case v => Boolean.G.><.fromStream(x)}
  def byte   [A<:Byte.Raw   ](x: ><[A]): Byte   .G.><[A] = x match{case v: Byte   .G.><[A] => v; case v => Byte   .G.><.fromStream(x)}
  def char   [A<:Char.Raw   ](x: ><[A]): Char   .G.><[A] = x match{case v: Char   .G.><[A] => v; case v => Char   .G.><.fromStream(x)}
  def short  [A<:Short.Raw  ](x: ><[A]): Short  .G.><[A] = x match{case v: Short  .G.><[A] => v; case v => Short  .G.><.fromStream(x)}
  def int    [A<:Int.Raw    ](x: ><[A]): Int    .G.><[A] = x match{case v: Int    .G.><[A] => v; case v => Int    .G.><.fromStream(x)}
  def long   [A<:Long.Raw   ](x: ><[A]): Long   .G.><[A] = x match{case v: Long   .G.><[A] => v; case v => Long   .G.><.fromStream(x)}
  def float  [A<:Float.Raw  ](x: ><[A]): Float  .G.><[A] = x match{case v: Float  .G.><[A] => v; case v => Float  .G.><.fromStream(x)}
  def double [A<:Double.Raw ](x: ><[A]): Double .G.><[A] = x match{case v: Double .G.><[A] => v; case v => Double .G.><.fromStream(x)}

  inline def apply[A,PACK<:Pack.RawType[A]](inline x: ><[A], inline s: SHAPE[A,PACK]): PACK  =
    inline x match
      case _ : Boolean.G.><[A] => x.cast[PACK]
      case _ : Byte   .G.><[A] => x.cast[PACK]
      case _ : Char   .G.><[A] => x.cast[PACK]
      case _ : Short  .G.><[A] => x.cast[PACK]
      case _ : Int    .G.><[A] => x.cast[PACK]
      case _ : Long   .G.><[A] => x.cast[PACK]
      case _ : Float  .G.><[A] => x.cast[PACK]
      case _ : Double .G.><[A] => x.cast[PACK]
      case _ => inline s match
          case _ : SHAPE[A,Boolean.G.><[A & Boolean.Raw]] => boolean[A & Boolean.Raw](x.cast[><[A & Boolean.Raw]])
          case _ : SHAPE[A,Byte   .G.><[A & Byte.Raw   ]] => byte   [A & Byte.Raw   ](x.cast[><[A & Byte.Raw   ]])
          case _ : SHAPE[A,Char   .G.><[A & Char.Raw   ]] => char   [A & Char.Raw   ](x.cast[><[A & Char.Raw   ]])
          case _ : SHAPE[A,Short  .G.><[A & Short.Raw  ]] => short  [A & Short.Raw  ](x.cast[><[A & Short.Raw  ]])
          case _ : SHAPE[A,Int    .G.><[A & Int.Raw    ]] => int    [A & Int.Raw    ](x.cast[><[A & Int.Raw    ]])
          case _ : SHAPE[A,Long   .G.><[A & Long.Raw   ]] => long   [A & Long.Raw   ](x.cast[><[A & Long.Raw   ]])
          case _ : SHAPE[A,Float  .G.><[A & Float.Raw  ]] => float  [A & Float.Raw  ](x.cast[><[A & Float.Raw  ]])
          case _ : SHAPE[A,Double .G.><[A & Double.Raw ]] => double [A & Double.Raw ](x.cast[><[A & Double.Raw ]])
          case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
