package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.PackTag

object pack :

  inline def apply[A,PACK<: ><.AnyType[A]](inline x:Array[A], inline t: PackTag[A,PACK]): PACK =
    inline t match
      case _ : PackTag[A&Raw.Boolean,Boolean.G.><[A&Raw.Boolean]] => Boolean.G.><.fromArray(x.cast[Array[Boolean]]).cast[PACK]
      case _ : PackTag[A&Raw.Byte,   Byte   .G.><[A&Raw.Byte   ]] => Byte   .G.><.fromArray(x.cast[Array[Byte   ]]).cast[PACK]
      case _ : PackTag[A&Raw.Char,   Char   .G.><[A&Raw.Char   ]] => Char   .G.><.fromArray(x.cast[Array[Char   ]]).cast[PACK]
      case _ : PackTag[A&Raw.Short,  Short  .G.><[A&Raw.Short  ]] => Short  .G.><.fromArray(x.cast[Array[Short  ]]).cast[PACK]
      case _ : PackTag[A&Raw.Int,    Int    .G.><[A&Raw.Int    ]] => Int    .G.><.fromArray(x.cast[Array[Int    ]]).cast[PACK]
      case _ : PackTag[A&Raw.Long,   Long   .G.><[A&Raw.Long   ]] => Long   .G.><.fromArray(x.cast[Array[Long   ]]).cast[PACK]
      case _ : PackTag[A&Raw.Float,  Float  .G.><[A&Raw.Float  ]] => Float  .G.><.fromArray(x.cast[Array[Float  ]]).cast[PACK]
      case _ : PackTag[A&Raw.Double, Double .G.><[A&Raw.Double ]] => Double .G.><.fromArray(x.cast[Array[Double ]]).cast[PACK]
      case _ : PackTag[A&Ref,                  ><[A&Ref        ]] =>           ><.fromArray(x.cast[Array[Ref    ]]).cast[PACK]
      case _                                                      => any(x,\/).cast[PACK]

  def any[A](x:Array[A], sz: Int.Opt) : ><[A] =
    x match
      case x: Array[Ref]      => ><.fromArray(x,sz or x.length)
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
