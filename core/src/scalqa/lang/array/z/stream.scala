package scalqa; package lang; package array; package z; import language.implicitConversions

object Stream:

  inline def apply[A](inline x:Array[A])(using inline s: Specialized[A]): s.Stream & Able.Size =
    inline s match
      case _ : Specialized[A&Any.Boolean] => boolean.Z.Stream_ofArray(x.cast[Array[Boolean]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Byte   ] => byte   .Z.Stream_ofArray(x.cast[Array[Byte   ]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Char   ] => char   .Z.Stream_ofArray(x.cast[Array[Char   ]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Short  ] => short  .Z.Stream_ofArray(x.cast[Array[Short  ]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Int    ] => int    .Z.Stream_ofArray(x.cast[Array[Int    ]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Long   ] => long   .Z.Stream_ofArray(x.cast[Array[Long   ]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Float  ] => float  .Z.Stream_ofArray(x.cast[Array[Float  ]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Double ] => double .Z.Stream_ofArray(x.cast[Array[Double ]]).cast[s.Stream & Able.Size]
      case _ : Specialized[A&AnyRef     ] => anyref .Z.Stream_ofArray(x.cast[Array[AnyRef ]]).cast[s.Stream & Able.Size]
      case _                              => any(x,VOID).cast[s.Stream & Able.Size]

  inline def apply[A](inline x:Array[A], sz: Int)(using inline s: Specialized[A]): s.Stream & Able.Size =
    inline s match
      case _ : Specialized[A&Any.Boolean] => boolean.Z.Stream_ofArray(x.cast[Array[Boolean]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Byte   ] => byte   .Z.Stream_ofArray(x.cast[Array[Byte   ]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Char   ] => char   .Z.Stream_ofArray(x.cast[Array[Char   ]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Short  ] => short  .Z.Stream_ofArray(x.cast[Array[Short  ]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Int    ] => int    .Z.Stream_ofArray(x.cast[Array[Int    ]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Long   ] => long   .Z.Stream_ofArray(x.cast[Array[Long   ]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Float  ] => float  .Z.Stream_ofArray(x.cast[Array[Float  ]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&Any.Double ] => double .Z.Stream_ofArray(x.cast[Array[Double ]],sz).cast[s.Stream & Able.Size]
      case _ : Specialized[A&AnyRef     ] => anyref .Z.Stream_ofArray(x.cast[Array[AnyRef ]],sz).cast[s.Stream & Able.Size]
      case _                              => any(x,sz).cast[s.Stream & Able.Size]

  def any[A](x:Array[A], sz:Int.Opt) : Stream[A] & Able.Size = x match
    case x: Array[AnyRef]   => anyref .Z.Stream_ofArray(x,sz or x.length)
    case x: Array[Int]      => int    .Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case x: Array[Long]     => long   .Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case x: Array[Double]   => double .Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case x: Array[Boolean]  => boolean.Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case x: Array[Byte]     => byte   .Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case x: Array[Char]     => char   .Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case x: Array[Float]    => float  .Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case x: Array[Short]    => short  .Z.Stream_ofArray(x,sz or x.length).cast[Stream[A] & Able.Size]
    case _                  => J.illegalState()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
