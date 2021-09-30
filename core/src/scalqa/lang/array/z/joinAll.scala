package scalqa; package lang; package array; package z; import language.implicitConversions

object joinAll:

  inline def apply[A](inline x: Array[A], inline v: ~[A])(using inline A: Specialized[A]): A.Array =
    inline A match
      case _ : Specialized[A&Any.Boolean] => boolean.g.Buffer.zzArrayJoinAll(x.cast[Array[Boolean]],v.cast[~[Boolean]]).cast[A.Array]
      case _ : Specialized[A&Any.Byte   ] => byte   .g.Buffer.zzArrayJoinAll(x.cast[Array[Byte   ]],v.cast[~[Byte   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Char   ] => char   .g.Buffer.zzArrayJoinAll(x.cast[Array[Char   ]],v.cast[~[Char   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Short  ] => short  .g.Buffer.zzArrayJoinAll(x.cast[Array[Short  ]],v.cast[~[Short  ]]).cast[A.Array]
      case _ : Specialized[A&Any.Int    ] => int    .g.Buffer.zzArrayJoinAll(x.cast[Array[Int    ]],v.cast[~[Int    ]]).cast[A.Array]
      case _ : Specialized[A&Any.Long   ] => long   .g.Buffer.zzArrayJoinAll(x.cast[Array[Long   ]],v.cast[~[Long   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Float  ] => float  .g.Buffer.zzArrayJoinAll(x.cast[Array[Float  ]],v.cast[~[Float  ]]).cast[A.Array]
      case _ : Specialized[A&Any.Double ] => double .g.Buffer.zzArrayJoinAll(x.cast[Array[Double ]],v.cast[~[Double ]]).cast[A.Array]
      case _ : Specialized[A&AnyRef     ] => anyref   .Buffer.zzArrayJoinAll(x.cast[Array[AnyRef ]],v.cast[~[AnyRef ]]).cast[A.Array]
      case _                              => any(x,v).cast[A.Array]

  def any[A](x: Array[A], v: ~[A]): Array[A] =
    x match
       case x: Array[AnyRef]     => anyref   .Buffer.zzArrayJoinAll(x,v)
       case x: Array[Int]        => int    .g.Buffer.zzArrayJoinAll(x,v)
       case x: Array[Double]     => double .g.Buffer.zzArrayJoinAll(x,v)
       case x: Array[Long]       => long   .g.Buffer.zzArrayJoinAll(x,v)
       case x: Array[Float]      => float  .g.Buffer.zzArrayJoinAll(x,v)
       case x: Array[Char]       => char   .g.Buffer.zzArrayJoinAll(x,v)
       case x: Array[Byte]       => byte   .g.Buffer.zzArrayJoinAll(x,v)
       case x: Array[Short]      => short  .g.Buffer.zzArrayJoinAll(x,v)
       case x: Array[Boolean]    => boolean.g.Buffer.zzArrayJoinAll(x,v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
