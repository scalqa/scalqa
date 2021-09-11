package scalqa; package `val`; package pack; package z; import language.implicitConversions

object raw:

  def boolean[A<:Any.Boolean](x: ><[A]): Boolean.G.><[A] = x match{case v: Boolean.G.><[A] => v; case v => Boolean.G.><.fromStream(x)}
  def byte   [A<:Any.Byte   ](x: ><[A]): Byte   .G.><[A] = x match{case v: Byte   .G.><[A] => v; case v => Byte   .G.><.fromStream(x)}
  def char   [A<:Any.Char   ](x: ><[A]): Char   .G.><[A] = x match{case v: Char   .G.><[A] => v; case v => Char   .G.><.fromStream(x)}
  def short  [A<:Any.Short  ](x: ><[A]): Short  .G.><[A] = x match{case v: Short  .G.><[A] => v; case v => Short  .G.><.fromStream(x)}
  def int    [A<:Any.Int    ](x: ><[A]): Int    .G.><[A] = x match{case v: Int    .G.><[A] => v; case v => Int    .G.><.fromStream(x)}
  def long   [A<:Any.Long   ](x: ><[A]): Long   .G.><[A] = x match{case v: Long   .G.><[A] => v; case v => Long   .G.><.fromStream(x)}
  def float  [A<:Any.Float  ](x: ><[A]): Float  .G.><[A] = x match{case v: Float  .G.><[A] => v; case v => Float  .G.><.fromStream(x)}
  def double [A<:Any.Double ](x: ><[A]): Double .G.><[A] = x match{case v: Double .G.><[A] => v; case v => Double .G.><.fromStream(x)}

  inline def apply[A](inline x: ><[A])(using inline A:Specialized.Primitive[A]): A.>< =
    inline x match
      case _ : Boolean.G.><[A] => x.cast[A.><]
      case _ : Byte   .G.><[A] => x.cast[A.><]
      case _ : Char   .G.><[A] => x.cast[A.><]
      case _ : Short  .G.><[A] => x.cast[A.><]
      case _ : Int    .G.><[A] => x.cast[A.><]
      case _ : Long   .G.><[A] => x.cast[A.><]
      case _ : Float  .G.><[A] => x.cast[A.><]
      case _ : Double .G.><[A] => x.cast[A.><]
      case _ => inline A match
          case _ : Specialized.Primitive[A & Any.Boolean] => boolean[A & Any.Boolean](x.cast[><[A & Any.Boolean]]).cast[A.><]
          case _ : Specialized.Primitive[A & Any.Byte   ] => byte   [A & Any.Byte   ](x.cast[><[A & Any.Byte   ]]).cast[A.><]
          case _ : Specialized.Primitive[A & Any.Char   ] => char   [A & Any.Char   ](x.cast[><[A & Any.Char   ]]).cast[A.><]
          case _ : Specialized.Primitive[A & Any.Short  ] => short  [A & Any.Short  ](x.cast[><[A & Any.Short  ]]).cast[A.><]
          case _ : Specialized.Primitive[A & Any.Int    ] => int    [A & Any.Int    ](x.cast[><[A & Any.Int    ]]).cast[A.><]
          case _ : Specialized.Primitive[A & Any.Long   ] => long   [A & Any.Long   ](x.cast[><[A & Any.Long   ]]).cast[A.><]
          case _ : Specialized.Primitive[A & Any.Float  ] => float  [A & Any.Float  ](x.cast[><[A & Any.Float  ]]).cast[A.><]
          case _ : Specialized.Primitive[A & Any.Double ] => double [A & Any.Double ](x.cast[><[A & Any.Double ]]).cast[A.><]
          case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
