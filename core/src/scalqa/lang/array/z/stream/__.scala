package scalqa; package lang; package array; package z; package stream; import language.implicitConversions

import gen.`given`.StreamTag

object __ :

  inline def apply[A,STREAM<: ~~.AnyType[A]](inline x:Array[A], inline t: StreamTag[A,STREAM]): STREAM & Able.Size =
    inline t match
      case _ : StreamTag[A&Raw.Boolean,Boolean.G.~[A&Raw.Boolean]] => As.Booleans(x.cast[Array[Boolean]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Byte,   Byte   .G.~[A&Raw.Byte   ]] => As.Bytes   (x.cast[Array[Byte   ]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Char,   Char   .G.~[A&Raw.Char   ]] => As.Chars   (x.cast[Array[Char   ]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Short,  Short  .G.~[A&Raw.Short  ]] => As.Shorts  (x.cast[Array[Short  ]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Int,    Int    .G.~[A&Raw.Int    ]] => As.Ints    (x.cast[Array[Int    ]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Long,   Long   .G.~[A&Raw.Long   ]] => As.Longs   (x.cast[Array[Long   ]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Float,  Float  .G.~[A&Raw.Float  ]] => As.Floats  (x.cast[Array[Float  ]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Double, Double .G.~[A&Raw.Double ]] => As.Doubles (x.cast[Array[Double ]]).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Ref,                  ~[A&Ref        ]] => As.Refs    (x.cast[Array[Ref    ]]).cast[STREAM & Able.Size]
      case _                                                       => any(x,\/).cast[STREAM & Able.Size]

  inline def apply[A,STREAM<: ~~.AnyType[A]](inline x:Array[A], sz: Int, inline t: StreamTag[A,STREAM]): STREAM & Able.Size =
    inline t match
      case _ : StreamTag[A&Raw.Boolean,Boolean.G.~[A&Raw.Boolean]] => As.Booleans(x.cast[Array[Boolean]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Byte,   Byte   .G.~[A&Raw.Byte   ]] => As.Bytes   (x.cast[Array[Byte   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Char,   Char   .G.~[A&Raw.Char   ]] => As.Chars   (x.cast[Array[Char   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Short,  Short  .G.~[A&Raw.Short  ]] => As.Shorts  (x.cast[Array[Short  ]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Int,    Int    .G.~[A&Raw.Int    ]] => As.Ints    (x.cast[Array[Int    ]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Long,   Long   .G.~[A&Raw.Long   ]] => As.Longs   (x.cast[Array[Long   ]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Float,  Float  .G.~[A&Raw.Float  ]] => As.Floats  (x.cast[Array[Float  ]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Raw.Double, Double .G.~[A&Raw.Double ]] => As.Doubles (x.cast[Array[Double ]],sz).cast[STREAM & Able.Size]
      case _ : StreamTag[A&Ref,                  ~[A&Ref        ]] => As.Refs    (x.cast[Array[Ref    ]],sz).cast[STREAM & Able.Size]
      case _                                                       => any(x,\/).cast[STREAM & Able.Size]

  def any[A](x:Array[A], sz:Int.Opt) : ~[A] & Able.Size = x match
    case x: Array[Ref]      => As.Refs    (x,sz or x.length)
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
