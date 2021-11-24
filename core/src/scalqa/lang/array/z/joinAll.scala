package scalqa; package lang; package array; package z; import language.implicitConversions

object joinAll:

  inline def apply[A](inline x: Array[A], inline v: Stream[A])(using inline A: Specialized[A]): A.Array =
    inline A match
      case _ : Specialized[A&Any.Boolean] => boolean.g.Buffer.z_ArrayJoinAll(x.cast[Array[Boolean]],v.cast[Stream[Boolean]]).cast[A.Array]
      case _ : Specialized[A&Any.Byte   ] => byte   .g.Buffer.z_ArrayJoinAll(x.cast[Array[Byte   ]],v.cast[Stream[Byte   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Char   ] => char   .g.Buffer.z_ArrayJoinAll(x.cast[Array[Char   ]],v.cast[Stream[Char   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Short  ] => short  .g.Buffer.z_ArrayJoinAll(x.cast[Array[Short  ]],v.cast[Stream[Short  ]]).cast[A.Array]
      case _ : Specialized[A&Any.Int    ] => int    .g.Buffer.z_ArrayJoinAll(x.cast[Array[Int    ]],v.cast[Stream[Int    ]]).cast[A.Array]
      case _ : Specialized[A&Any.Long   ] => long   .g.Buffer.z_ArrayJoinAll(x.cast[Array[Long   ]],v.cast[Stream[Long   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Float  ] => float  .g.Buffer.z_ArrayJoinAll(x.cast[Array[Float  ]],v.cast[Stream[Float  ]]).cast[A.Array]
      case _ : Specialized[A&Any.Double ] => double .g.Buffer.z_ArrayJoinAll(x.cast[Array[Double ]],v.cast[Stream[Double ]]).cast[A.Array]
      case _ : Specialized[A&AnyRef     ] => anyref   .Buffer.z_ArrayJoinAll(x.cast[Array[AnyRef ]],v.cast[Stream[AnyRef ]]).cast[A.Array]
      case _                              => any(x,v).cast[A.Array]

  def any[A](x: Array[A], v: Stream[A]): Array[A] =
    x match
       case x: Array[AnyRef]     => anyref   .Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Int]        => int    .g.Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Double]     => double .g.Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Long]       => long   .g.Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Float]      => float  .g.Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Char]       => char   .g.Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Byte]       => byte   .g.Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Short]      => short  .g.Buffer.z_ArrayJoinAll(x,v)
       case x: Array[Boolean]    => boolean.g.Buffer.z_ArrayJoinAll(x,v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
