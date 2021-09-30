package scalqa; package `val`; package range; package z; import language.implicitConversions

object raw:

  inline def apply[A](inline x: Range[A])(using inline A:Specialized.Primitive[A]): A.<> =
    inline x match
      case _ : Byte   .G.<>[A] => x.cast[A.<>]
      case _ : Char   .G.<>[A] => x.cast[A.<>]
      case _ : Short  .G.<>[A] => x.cast[A.<>]
      case _ : Int    .G.<>[A] => x.cast[A.<>]
      case _ : Long   .G.<>[A] => x.cast[A.<>]
      case _ : Float  .G.<>[A] => x.cast[A.<>]
      case _ : Double .G.<>[A] => x.cast[A.<>]
      case _ => inline A match
          case _ : Specialized.Primitive[A & Any.Byte  ] => byte  (x.cast[Range[Byte  ]]).cast[A.<>]
          case _ : Specialized.Primitive[A & Any.Char  ] => char  (x.cast[Range[Char  ]]).cast[A.<>]
          case _ : Specialized.Primitive[A & Any.Short ] => short (x.cast[Range[Short ]]).cast[A.<>]
          case _ : Specialized.Primitive[A & Any.Int   ] => int   (x.cast[Range[Int   ]]).cast[A.<>]
          case _ : Specialized.Primitive[A & Any.Long  ] => long  (x.cast[Range[Long  ]]).cast[A.<>]
          case _ : Specialized.Primitive[A & Any.Float ] => float (x.cast[Range[Float ]]).cast[A.<>]
          case _ : Specialized.Primitive[A & Any.Double] => double(x.cast[Range[Double]]).cast[A.<>]
          case _                                         => J.illegalState()

  def byte   [A<:Any.Byte   ](x: Range[A]): Byte   .G.<>[A] = x match{case v: Byte   .G.<>[A] => v; case v if(v ne lang.byte  .z.Math) => fail(v); case v => (if(v.endIsIn) v.start.cast[Byte]  <> v.end.cast[Byte]   else v.start.cast[Byte]  <>> v.end.cast[Byte]  ).cast}
  def char   [A<:Any.Char   ](x: Range[A]): Char   .G.<>[A] = x match{case v: Char   .G.<>[A] => v; case v if(v ne lang.char  .z.Math) => fail(v); case v => (if(v.endIsIn) v.start.cast[Char]  <> v.end.cast[Char]   else v.start.cast[Char]  <>> v.end.cast[Char]  ).cast}
  def short  [A<:Any.Short  ](x: Range[A]): Short  .G.<>[A] = x match{case v: Short  .G.<>[A] => v; case v if(v ne lang.short .z.Math) => fail(v); case v => (if(v.endIsIn) v.start.cast[Short] <> v.end.cast[Short]  else v.start.cast[Short] <>> v.end.cast[Short] ).cast}
  def int    [A<:Any.Int    ](x: Range[A]): Int    .G.<>[A] = x match{case v: Int    .G.<>[A] => v; case v if(v ne lang.int   .z.Math) => fail(v); case v => (if(v.endIsIn) v.start.cast[Int]   <> v.end.cast[Int]    else v.start.cast[Int]   <>> v.end.cast[Int]   ).cast}
  def long   [A<:Any.Long   ](x: Range[A]): Long   .G.<>[A] = x match{case v: Long   .G.<>[A] => v; case v if(v ne lang.long  .z.Math) => fail(v); case v => (if(v.endIsIn) v.start.cast[Long]  <> v.end.cast[Long]   else v.start.cast[Long]  <>> v.end.cast[Long]  ).cast}
  def float  [A<:Any.Float  ](x: Range[A]): Float  .G.<>[A] = x match{case v: Float  .G.<>[A] => v; case v if(v ne lang.float .z.Math) => fail(v); case v => (if(v.endIsIn) v.start.cast[Float] <> v.end.cast[Float]  else v.start.cast[Float] <>> v.end.cast[Float] ).cast}
  def double [A<:Any.Double ](x: Range[A]): Double .G.<>[A] = x match{case v: Double .G.<>[A] => v; case v if(v ne lang.double.z.Math) => fail(v); case v => (if(v.endIsIn) v.start.cast[Double]<> v.end.cast[Double] else v.start.cast[Double]<>> v.end.cast[Double]).cast}

  private def fail(r: Range[_]) = J.unsupportedOperation("Range.ordering is not instance of primitive Ordering, so convertion to Primitive.Range is not supported. Current ordering: "+r.ordering)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
