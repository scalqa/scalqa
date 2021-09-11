package scalqa; package lang; package array; package z; import language.implicitConversions

object Stream:

  inline def apply[A](inline x:Array[A])(using inline A: Specialized[A]): A.~ & Able.Size =
    inline A match
      case _ : Specialized[A&Any.Boolean] => As.BooleanStream(x.cast[Array[Boolean]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Byte   ] => As.ByteStream   (x.cast[Array[Byte   ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Char   ] => As.CharStream   (x.cast[Array[Char   ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Short  ] => As.ShortStream  (x.cast[Array[Short  ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Int    ] => As.IntStream    (x.cast[Array[Int    ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Long   ] => As.LongStream   (x.cast[Array[Long   ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Float  ] => As.FloatStream  (x.cast[Array[Float  ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Double ] => As.DoubleStream (x.cast[Array[Double ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&AnyRef     ] => As.RefStream    (x.cast[Array[AnyRef ]]).cast[A.~ & Able.Size]
      case _                              => any(x,\/).cast[A.~ & Able.Size]

  inline def apply[A](inline x:Array[A], sz: Int)(using inline A: Specialized[A]): A.~ & Able.Size =
    inline A match
      case _ : Specialized[A&Any.Boolean] => As.BooleanStream(x.cast[Array[Boolean]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Byte   ] => As.ByteStream   (x.cast[Array[Byte   ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Char   ] => As.CharStream   (x.cast[Array[Char   ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Short  ] => As.ShortStream  (x.cast[Array[Short  ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Int    ] => As.IntStream    (x.cast[Array[Int    ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Long   ] => As.LongStream   (x.cast[Array[Long   ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Float  ] => As.FloatStream  (x.cast[Array[Float  ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Double ] => As.DoubleStream (x.cast[Array[Double ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&AnyRef     ] => As.RefStream    (x.cast[Array[AnyRef ]],sz).cast[A.~ & Able.Size]
      case _                              => any(x,\/).cast[A.~ & Able.Size]

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
