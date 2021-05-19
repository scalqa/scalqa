package scalqa; package `val`; package pack; package z; import language.implicitConversions

import Self.Given.PackTag.{ Raw as SHAPE }

object raw:

  def boolean[A<:Raw.Boolean](x: ><[A]): Boolean.G.><[A] = x match{case v: Boolean.G.><[A] => v; case v => Boolean.G.><.fromStream(x)}
  def byte   [A<:Raw.Byte   ](x: ><[A]): Byte   .G.><[A] = x match{case v: Byte   .G.><[A] => v; case v => Byte   .G.><.fromStream(x)}
  def char   [A<:Raw.Char   ](x: ><[A]): Char   .G.><[A] = x match{case v: Char   .G.><[A] => v; case v => Char   .G.><.fromStream(x)}
  def short  [A<:Raw.Short  ](x: ><[A]): Short  .G.><[A] = x match{case v: Short  .G.><[A] => v; case v => Short  .G.><.fromStream(x)}
  def int    [A<:Raw.Int    ](x: ><[A]): Int    .G.><[A] = x match{case v: Int    .G.><[A] => v; case v => Int    .G.><.fromStream(x)}
  def long   [A<:Raw.Long   ](x: ><[A]): Long   .G.><[A] = x match{case v: Long   .G.><[A] => v; case v => Long   .G.><.fromStream(x)}
  def float  [A<:Raw.Float  ](x: ><[A]): Float  .G.><[A] = x match{case v: Float  .G.><[A] => v; case v => Float  .G.><.fromStream(x)}
  def double [A<:Raw.Double ](x: ><[A]): Double .G.><[A] = x match{case v: Double .G.><[A] => v; case v => Double .G.><.fromStream(x)}

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
          case _ : SHAPE[A,Boolean.G.><[A & Raw.Boolean]] => boolean[A & Raw.Boolean](x.cast[><[A & Raw.Boolean]])
          case _ : SHAPE[A,Byte   .G.><[A & Raw.Byte   ]] => byte   [A & Raw.Byte   ](x.cast[><[A & Raw.Byte   ]])
          case _ : SHAPE[A,Char   .G.><[A & Raw.Char   ]] => char   [A & Raw.Char   ](x.cast[><[A & Raw.Char   ]])
          case _ : SHAPE[A,Short  .G.><[A & Raw.Short  ]] => short  [A & Raw.Short  ](x.cast[><[A & Raw.Short  ]])
          case _ : SHAPE[A,Int    .G.><[A & Raw.Int    ]] => int    [A & Raw.Int    ](x.cast[><[A & Raw.Int    ]])
          case _ : SHAPE[A,Long   .G.><[A & Raw.Long   ]] => long   [A & Raw.Long   ](x.cast[><[A & Raw.Long   ]])
          case _ : SHAPE[A,Float  .G.><[A & Raw.Float  ]] => float  [A & Raw.Float  ](x.cast[><[A & Raw.Float  ]])
          case _ : SHAPE[A,Double .G.><[A & Raw.Double ]] => double [A & Raw.Double ](x.cast[><[A & Raw.Double ]])
          case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
