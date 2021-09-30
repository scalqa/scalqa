package scalqa; package lang; package array; package z; import language.implicitConversions

object Stream:

  inline def apply[A](inline x:Array[A])(using inline A: Specialized[A]): A.~ & Able.Size =
    inline A match
      case _ : Specialized[A&Any.Boolean] => boolean.Z.Stream_ofArray(x.cast[Array[Boolean]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Byte   ] => byte   .Z.Stream_ofArray(x.cast[Array[Byte   ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Char   ] => char   .Z.Stream_ofArray(x.cast[Array[Char   ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Short  ] => short  .Z.Stream_ofArray(x.cast[Array[Short  ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Int    ] => int    .Z.Stream_ofArray(x.cast[Array[Int    ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Long   ] => long   .Z.Stream_ofArray(x.cast[Array[Long   ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Float  ] => float  .Z.Stream_ofArray(x.cast[Array[Float  ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Double ] => double .Z.Stream_ofArray(x.cast[Array[Double ]]).cast[A.~ & Able.Size]
      case _ : Specialized[A&AnyRef     ] => anyref .Z.Stream_ofArray(x.cast[Array[AnyRef ]]).cast[A.~ & Able.Size]
      case _                              => any(x,\/).cast[A.~ & Able.Size]

  inline def apply[A](inline x:Array[A], sz: Int)(using inline A: Specialized[A]): A.~ & Able.Size =
    inline A match
      case _ : Specialized[A&Any.Boolean] => boolean.Z.Stream_ofArray(x.cast[Array[Boolean]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Byte   ] => byte   .Z.Stream_ofArray(x.cast[Array[Byte   ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Char   ] => char   .Z.Stream_ofArray(x.cast[Array[Char   ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Short  ] => short  .Z.Stream_ofArray(x.cast[Array[Short  ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Int    ] => int    .Z.Stream_ofArray(x.cast[Array[Int    ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Long   ] => long   .Z.Stream_ofArray(x.cast[Array[Long   ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Float  ] => float  .Z.Stream_ofArray(x.cast[Array[Float  ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&Any.Double ] => double .Z.Stream_ofArray(x.cast[Array[Double ]],sz).cast[A.~ & Able.Size]
      case _ : Specialized[A&AnyRef     ] => anyref .Z.Stream_ofArray(x.cast[Array[AnyRef ]],sz).cast[A.~ & Able.Size]
      case _                              => any(x,sz).cast[A.~ & Able.Size]

  def any[A](x:Array[A], sz:Int.Opt) : ~[A] & Able.Size = x match
    case x: Array[AnyRef]   => anyref .Z.Stream_ofArray(x,sz or x.length)
    case x: Array[Int]      => int    .Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Long]     => long   .Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Double]   => double .Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Boolean]  => boolean.Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Byte]     => byte   .Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Char]     => char   .Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Float]    => float  .Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case x: Array[Short]    => short  .Z.Stream_ofArray(x,sz or x.length).cast[~[A] & Able.Size]
    case _                  => J.illegalState()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
