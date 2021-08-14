package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.StreamShape

object Stream:

  inline def apply[A,STREAM<: ~~.AnyType[A]](inline x:Array[A], inline t: StreamShape[A,STREAM]): STREAM & Able.Size =
    inline t match
      case _ : StreamShape[A&Boolean.Raw,Boolean.G.~[A&Boolean.Raw]] => As.BooleanStream(x.cast[Array[Boolean]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Byte.Raw,   Byte   .G.~[A&Byte.Raw   ]] => As.ByteStream   (x.cast[Array[Byte   ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Char.Raw,   Char   .G.~[A&Char.Raw   ]] => As.CharStream   (x.cast[Array[Char   ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Short.Raw,  Short  .G.~[A&Short.Raw  ]] => As.ShortStream  (x.cast[Array[Short  ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Int.Raw,    Int    .G.~[A&Int.Raw    ]] => As.IntStream    (x.cast[Array[Int    ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Long.Raw,   Long   .G.~[A&Long.Raw   ]] => As.LongStream   (x.cast[Array[Long   ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Float.Raw,  Float  .G.~[A&Float.Raw  ]] => As.FloatStream  (x.cast[Array[Float  ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Double.Raw, Double .G.~[A&Double.Raw ]] => As.DoubleStream (x.cast[Array[Double ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&AnyRef,     AnyRef .G.~[A&AnyRef     ]] => As.RefStream    (x.cast[Array[AnyRef ]]).cast[STREAM & Able.Size]
      case _                                                         => any(x,\/).cast[STREAM & Able.Size]

  inline def apply[A,STREAM<: ~~.AnyType[A]](inline x:Array[A], sz: Int, inline t: StreamShape[A,STREAM]): STREAM & Able.Size =
    inline t match
      case _ : StreamShape[A&Boolean.Raw,Boolean.G.~[A&Boolean.Raw]] => As.BooleanStream(x.cast[Array[Boolean]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Byte.Raw,   Byte   .G.~[A&Byte.Raw   ]] => As.ByteStream   (x.cast[Array[Byte   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Char.Raw,   Char   .G.~[A&Char.Raw   ]] => As.CharStream   (x.cast[Array[Char   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Short.Raw,  Short  .G.~[A&Short.Raw  ]] => As.ShortStream  (x.cast[Array[Short  ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Int.Raw,    Int    .G.~[A&Int.Raw    ]] => As.IntStream    (x.cast[Array[Int    ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Long.Raw,   Long   .G.~[A&Long.Raw   ]] => As.LongStream   (x.cast[Array[Long   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Float.Raw,  Float  .G.~[A&Float.Raw  ]] => As.FloatStream  (x.cast[Array[Float  ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Double.Raw, Double .G.~[A&Double.Raw ]] => As.DoubleStream (x.cast[Array[Double ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&AnyRef,     AnyRef .G.~[A&AnyRef     ]] => As.RefStream    (x.cast[Array[AnyRef ]],sz).cast[STREAM & Able.Size]
      case _                                                         => any(x,\/).cast[STREAM & Able.Size]

  def any[A](x:Array[A], sz:Int.Opt) : ~[A] & Able.Size = x match
    case x: Array[AnyRef]   => As.RefStream    (x,sz or x.length)
    case x: Array[Int]      => As.IntStream    (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Long]     => As.LongStream   (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Double]   => As.DoubleStream (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Boolean]  => As.BooleanStream(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Byte]     => As.ByteStream   (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Char]     => As.CharStream   (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Float]    => As.FloatStream  (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Short]    => As.ShortStream  (x,sz or x.length).cast[~[A] & Able.Size]
    case _                  => J.illegalState()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
