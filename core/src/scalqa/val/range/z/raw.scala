package scalqa; package `val`; package range; package z; import language.implicitConversions

import gen.`given`.RangeTag

object raw:

  def byte   [A<:Raw.Byte   ](x: Range[A]): Byte   .G.<>[A] = x match{case v: Byte   .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Byte  .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.real <> v.end.real else v.start.real <>> v.end.real).cast}
  def char   [A<:Raw.Char   ](x: Range[A]): Char   .G.<>[A] = x match{case v: Char   .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Char  .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.real <> v.end.real else v.start.real <>> v.end.real).cast}
  def short  [A<:Raw.Short  ](x: Range[A]): Short  .G.<>[A] = x match{case v: Short  .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Short .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.real <> v.end.real else v.start.real <>> v.end.real).cast}
  def int    [A<:Raw.Int    ](x: Range[A]): Int    .G.<>[A] = x match{case v: Int    .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Int   .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.real <> v.end.real else v.start.real <>> v.end.real).cast}
  def long   [A<:Raw.Long   ](x: Range[A]): Long   .G.<>[A] = x match{case v: Long   .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Long  .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.real <> v.end.real else v.start.real <>> v.end.real).cast}
  def float  [A<:Raw.Float  ](x: Range[A]): Float  .G.<>[A] = x match{case v: Float  .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Float .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.real <> v.end.real else v.start.real <>> v.end.real).cast}
  def double [A<:Raw.Double ](x: Range[A]): Double .G.<>[A] = x match{case v: Double .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Double.G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.real <> v.end.real else v.start.real <>> v.end.real).cast}

  private def fail(r: Range[_]) = J.unsupportedOperation("Range.ordering is not instance of Ordering  .Ordering  , so convertion to Raw.Range is not supported. Current ordering: "+r.ordering)

  inline def apply[A,RNG<:Range.RawType[A]](inline x: Range[A], inline s: RangeTag.Raw[A,RNG]): RNG  =
    inline x match
      case _ : Byte   .G.<>[A] => x.cast[RNG]
      case _ : Char   .G.<>[A] => x.cast[RNG]
      case _ : Short  .G.<>[A] => x.cast[RNG]
      case _ : Int    .G.<>[A] => x.cast[RNG]
      case _ : Long   .G.<>[A] => x.cast[RNG]
      case _ : Float  .G.<>[A] => x.cast[RNG]
      case _ : Double .G.<>[A] => x.cast[RNG]
      case _ => inline s match
          case _ : RangeTag.Raw[A,Byte   .G.<>[A & Raw.Byte   ]] => byte   [A & Raw.Byte   ](x.cast[Range[A & Raw.Byte   ]])
          case _ : RangeTag.Raw[A,Char   .G.<>[A & Raw.Char   ]] => char   [A & Raw.Char   ](x.cast[Range[A & Raw.Char   ]])
          case _ : RangeTag.Raw[A,Short  .G.<>[A & Raw.Short  ]] => short  [A & Raw.Short  ](x.cast[Range[A & Raw.Short  ]])
          case _ : RangeTag.Raw[A,Int    .G.<>[A & Raw.Int    ]] => int    [A & Raw.Int    ](x.cast[Range[A & Raw.Int    ]])
          case _ : RangeTag.Raw[A,Long   .G.<>[A & Raw.Long   ]] => long   [A & Raw.Long   ](x.cast[Range[A & Raw.Long   ]])
          case _ : RangeTag.Raw[A,Float  .G.<>[A & Raw.Float  ]] => float  [A & Raw.Float  ](x.cast[Range[A & Raw.Float  ]])
          case _ : RangeTag.Raw[A,Double .G.<>[A & Raw.Double ]] => double [A & Raw.Double ](x.cast[Range[A & Raw.Double ]])
          case _                                            => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
