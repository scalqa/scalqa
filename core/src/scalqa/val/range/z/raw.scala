package scalqa; package `val`; package range; package z; import language.implicitConversions

import gen.`given`.RangeShape

object raw:

  def byte   [A<:Byte.Raw   ](x: Range[A]): Byte   .G.<>[A] = x match{case v: Byte   .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Byte  .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.cast[Byte]  <> v.end.cast[Byte]   else v.start.cast[Byte]  <>> v.end.cast[Byte]  ).cast}
  def char   [A<:Char.Raw   ](x: Range[A]): Char   .G.<>[A] = x match{case v: Char   .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Char  .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.cast[Char]  <> v.end.cast[Char]   else v.start.cast[Char]  <>> v.end.cast[Char]  ).cast}
  def short  [A<:Short.Raw  ](x: Range[A]): Short  .G.<>[A] = x match{case v: Short  .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Short .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.cast[Short] <> v.end.cast[Short]  else v.start.cast[Short] <>> v.end.cast[Short] ).cast}
  def int    [A<:Int.Raw    ](x: Range[A]): Int    .G.<>[A] = x match{case v: Int    .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Int   .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.cast[Int]   <> v.end.cast[Int]    else v.start.cast[Int]   <>> v.end.cast[Int]   ).cast}
  def long   [A<:Long.Raw   ](x: Range[A]): Long   .G.<>[A] = x match{case v: Long   .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Long  .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.cast[Long]  <> v.end.cast[Long]   else v.start.cast[Long]  <>> v.end.cast[Long]  ).cast}
  def float  [A<:Float.Raw  ](x: Range[A]): Float  .G.<>[A] = x match{case v: Float  .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Float .G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.cast[Float] <> v.end.cast[Float]  else v.start.cast[Float] <>> v.end.cast[Float] ).cast}
  def double [A<:Double.Raw ](x: Range[A]): Double .G.<>[A] = x match{case v: Double .G.<>[A] => v; case v if(!v.ordering.isInstanceOf[Double.G.Ordering[A]]) => fail(v); case v => (if(v.endIsIn) v.start.cast[Double]<> v.end.cast[Double] else v.start.cast[Double]<>> v.end.cast[Double]).cast}

  private def fail(r: Range[_]) = J.unsupportedOperation("Range.ordering is not instance of Ordering  .Ordering  , so convertion to Raw.Range is not supported. Current ordering: "+r.ordering)

  inline def apply[A,RNG<:Range.RawType[A]](inline x: Range[A], inline s: RangeShape.Raw[A,RNG]): RNG  =
    inline x match
      case _ : Byte   .G.<>[A] => x.cast[RNG]
      case _ : Char   .G.<>[A] => x.cast[RNG]
      case _ : Short  .G.<>[A] => x.cast[RNG]
      case _ : Int    .G.<>[A] => x.cast[RNG]
      case _ : Long   .G.<>[A] => x.cast[RNG]
      case _ : Float  .G.<>[A] => x.cast[RNG]
      case _ : Double .G.<>[A] => x.cast[RNG]
      case _ => inline s match
          case _ : RangeShape.Raw[A,Byte   .G.<>[A & Byte.Raw   ]] => byte   [A & Byte.Raw   ](x.cast[Range[A & Byte.Raw   ]])
          case _ : RangeShape.Raw[A,Char   .G.<>[A & Char.Raw   ]] => char   [A & Char.Raw   ](x.cast[Range[A & Char.Raw   ]])
          case _ : RangeShape.Raw[A,Short  .G.<>[A & Short.Raw  ]] => short  [A & Short.Raw  ](x.cast[Range[A & Short.Raw  ]])
          case _ : RangeShape.Raw[A,Int    .G.<>[A & Int.Raw    ]] => int    [A & Int.Raw    ](x.cast[Range[A & Int.Raw    ]])
          case _ : RangeShape.Raw[A,Long   .G.<>[A & Long.Raw   ]] => long   [A & Long.Raw   ](x.cast[Range[A & Long.Raw   ]])
          case _ : RangeShape.Raw[A,Float  .G.<>[A & Float.Raw  ]] => float  [A & Float.Raw  ](x.cast[Range[A & Float.Raw  ]])
          case _ : RangeShape.Raw[A,Double .G.<>[A & Double.Raw ]] => double [A & Double.Raw ](x.cast[Range[A & Double.Raw ]])
          case _                                                 => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
