package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.PackShape

object pack :

  inline def apply[A,PACK<: ><.AnyType[A]](inline x:Array[A], inline t: PackShape[A,PACK]): PACK =
    inline t match
      case _ : PackShape[A&Boolean.Raw,Boolean.G.><[A&Boolean.Raw]] => Boolean.G.><.fromArray(x.cast[Array[Boolean]]).cast[PACK]
      case _ : PackShape[A&Byte.Raw,   Byte   .G.><[A&Byte.Raw   ]] => Byte   .G.><.fromArray(x.cast[Array[Byte   ]]).cast[PACK]
      case _ : PackShape[A&Char.Raw,   Char   .G.><[A&Char.Raw   ]] => Char   .G.><.fromArray(x.cast[Array[Char   ]]).cast[PACK]
      case _ : PackShape[A&Short.Raw,  Short  .G.><[A&Short.Raw  ]] => Short  .G.><.fromArray(x.cast[Array[Short  ]]).cast[PACK]
      case _ : PackShape[A&Int.Raw,    Int    .G.><[A&Int.Raw    ]] => Int    .G.><.fromArray(x.cast[Array[Int    ]]).cast[PACK]
      case _ : PackShape[A&Long.Raw,   Long   .G.><[A&Long.Raw   ]] => Long   .G.><.fromArray(x.cast[Array[Long   ]]).cast[PACK]
      case _ : PackShape[A&Float.Raw,  Float  .G.><[A&Float.Raw  ]] => Float  .G.><.fromArray(x.cast[Array[Float  ]]).cast[PACK]
      case _ : PackShape[A&Double.Raw, Double .G.><[A&Double.Raw ]] => Double .G.><.fromArray(x.cast[Array[Double ]]).cast[PACK]
      case _ : PackShape[A&AnyRef,     AnyRef .G.><[A&AnyRef     ]] => AnyRef .G.><.fromArray(x.cast[Array[AnyRef ]]).cast[PACK]
      case _                                                        => any(x,\/).cast[PACK]

  def any[A](x:Array[A], sz: Int.Opt) : ><[A] =
    x match
      case x: Array[AnyRef]   => ><.fromArray(x,sz or x.length)
      case x: Array[Int]      => Int    .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Long]     => Long   .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Double]   => Double .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Boolean]  => Boolean.G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Byte]     => Byte   .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Char]     => Char   .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Float]    => Float  .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Short]    => Short  .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case _                  => J.illegalState()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
