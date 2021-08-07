package scalqa; package lang; package array; package z; import language.implicitConversions

import stream.As
import gen.`given`.StreamShape

object Stream:

  inline def apply[A,STREAM<: ~~.AnyType[A]](inline x:Array[A], inline t: StreamShape[A,STREAM]): STREAM & Able.Size =
    inline t match
      case _ : StreamShape[A&Boolean.Raw,Boolean.G.~[A&Boolean.Raw]] => As.Booleans(x.cast[Array[Boolean]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Byte.Raw,   Byte   .G.~[A&Byte.Raw   ]] => As.Bytes   (x.cast[Array[Byte   ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Char.Raw,   Char   .G.~[A&Char.Raw   ]] => As.Chars   (x.cast[Array[Char   ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Short.Raw,  Short  .G.~[A&Short.Raw  ]] => As.Shorts  (x.cast[Array[Short  ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Int.Raw,    Int    .G.~[A&Int.Raw    ]] => As.Ints    (x.cast[Array[Int    ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Long.Raw,   Long   .G.~[A&Long.Raw   ]] => As.Longs   (x.cast[Array[Long   ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Float.Raw,  Float  .G.~[A&Float.Raw  ]] => As.Floats  (x.cast[Array[Float  ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Double.Raw, Double .G.~[A&Double.Raw ]] => As.Doubles (x.cast[Array[Double ]]).cast[STREAM & Able.Size]
      case _ : StreamShape[A&AnyRef,               ~[A&AnyRef     ]] => As.Refs    (x.cast[Array[AnyRef ]]).cast[STREAM & Able.Size]
      case _                                                       => any(x,\/).cast[STREAM & Able.Size]

  inline def apply[A,STREAM<: ~~.AnyType[A]](inline x:Array[A], sz: Int, inline t: StreamShape[A,STREAM]): STREAM & Able.Size =
    inline t match
      case _ : StreamShape[A&Boolean.Raw,Boolean.G.~[A&Boolean.Raw]] => As.Booleans(x.cast[Array[Boolean]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Byte.Raw,   Byte   .G.~[A&Byte.Raw   ]] => As.Bytes   (x.cast[Array[Byte   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Char.Raw,   Char   .G.~[A&Char.Raw   ]] => As.Chars   (x.cast[Array[Char   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Short.Raw,  Short  .G.~[A&Short.Raw  ]] => As.Shorts  (x.cast[Array[Short  ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Int.Raw,    Int    .G.~[A&Int.Raw    ]] => As.Ints    (x.cast[Array[Int    ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Long.Raw,   Long   .G.~[A&Long.Raw   ]] => As.Longs   (x.cast[Array[Long   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Float.Raw,  Float  .G.~[A&Float.Raw  ]] => As.Floats  (x.cast[Array[Float  ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&Double.Raw, Double .G.~[A&Double.Raw ]] => As.Doubles (x.cast[Array[Double ]],sz).cast[STREAM & Able.Size]
      case _ : StreamShape[A&AnyRef,               ~[A&AnyRef     ]] => As.Refs    (x.cast[Array[AnyRef ]],sz).cast[STREAM & Able.Size]
      case _                                                       => any(x,\/).cast[STREAM & Able.Size]

  def any[A](x:Array[A], sz:Int.Opt) : ~[A] & Able.Size = x match
    case x: Array[AnyRef]   => As.Refs    (x,sz or x.length)
    case x: Array[Int]      => As.Ints    (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Long]     => As.Longs   (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Double]   => As.Doubles (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Boolean]  => As.Booleans(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Byte]     => As.Bytes   (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Char]     => As.Chars   (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Float]    => As.Floats  (x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Short]    => As.Shorts  (x,sz or x.length).cast[~[A] & Able.Size]
    case _                  => J.illegalState()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
