package scalqa; package `val`; package pack; package z; import language.implicitConversions

object raw:

  def boolean[A<:Any.Boolean](x: Pack[A]): Boolean.G.Pack[A] = x match{case v: Boolean.G.Pack[A] => v; case v => Boolean.G.Pack.fromStream(x)}
  def byte   [A<:Any.Byte   ](x: Pack[A]): Byte   .G.Pack[A] = x match{case v: Byte   .G.Pack[A] => v; case v => Byte   .G.Pack.fromStream(x)}
  def char   [A<:Any.Char   ](x: Pack[A]): Char   .G.Pack[A] = x match{case v: Char   .G.Pack[A] => v; case v => Char   .G.Pack.fromStream(x)}
  def short  [A<:Any.Short  ](x: Pack[A]): Short  .G.Pack[A] = x match{case v: Short  .G.Pack[A] => v; case v => Short  .G.Pack.fromStream(x)}
  def int    [A<:Any.Int    ](x: Pack[A]): Int    .G.Pack[A] = x match{case v: Int    .G.Pack[A] => v; case v => Int    .G.Pack.fromStream(x)}
  def long   [A<:Any.Long   ](x: Pack[A]): Long   .G.Pack[A] = x match{case v: Long   .G.Pack[A] => v; case v => Long   .G.Pack.fromStream(x)}
  def float  [A<:Any.Float  ](x: Pack[A]): Float  .G.Pack[A] = x match{case v: Float  .G.Pack[A] => v; case v => Float  .G.Pack.fromStream(x)}
  def double [A<:Any.Double ](x: Pack[A]): Double .G.Pack[A] = x match{case v: Double .G.Pack[A] => v; case v => Double .G.Pack.fromStream(x)}

  inline def apply[A](inline x: Pack[A])(using inline A:Specialized.Primitive[A]): A.Pack =
    inline x match
      case _ : Boolean.G.Pack[A] => x.cast[A.Pack]
      case _ : Byte   .G.Pack[A] => x.cast[A.Pack]
      case _ : Char   .G.Pack[A] => x.cast[A.Pack]
      case _ : Short  .G.Pack[A] => x.cast[A.Pack]
      case _ : Int    .G.Pack[A] => x.cast[A.Pack]
      case _ : Long   .G.Pack[A] => x.cast[A.Pack]
      case _ : Float  .G.Pack[A] => x.cast[A.Pack]
      case _ : Double .G.Pack[A] => x.cast[A.Pack]
      case _ => inline A match
          case _ : Specialized.Primitive[A & Any.Boolean] => boolean[A & Any.Boolean](x.cast[Pack[A & Any.Boolean]]).cast[A.Pack]
          case _ : Specialized.Primitive[A & Any.Byte   ] => byte   [A & Any.Byte   ](x.cast[Pack[A & Any.Byte   ]]).cast[A.Pack]
          case _ : Specialized.Primitive[A & Any.Char   ] => char   [A & Any.Char   ](x.cast[Pack[A & Any.Char   ]]).cast[A.Pack]
          case _ : Specialized.Primitive[A & Any.Short  ] => short  [A & Any.Short  ](x.cast[Pack[A & Any.Short  ]]).cast[A.Pack]
          case _ : Specialized.Primitive[A & Any.Int    ] => int    [A & Any.Int    ](x.cast[Pack[A & Any.Int    ]]).cast[A.Pack]
          case _ : Specialized.Primitive[A & Any.Long   ] => long   [A & Any.Long   ](x.cast[Pack[A & Any.Long   ]]).cast[A.Pack]
          case _ : Specialized.Primitive[A & Any.Float  ] => float  [A & Any.Float  ](x.cast[Pack[A & Any.Float  ]]).cast[A.Pack]
          case _ : Specialized.Primitive[A & Any.Double ] => double [A & Any.Double ](x.cast[Pack[A & Any.Double ]]).cast[A.Pack]
          case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
