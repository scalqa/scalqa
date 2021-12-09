package scalqa; package `val`; package pack; package z; import language.implicitConversions

object StreamAble:

  inline def apply[A](inline x:Able.Stream[A])(using inline s: Specialized[A]): s.Pack =
    inline x match
      case _ : Boolean.G.Collection[A & Any.Boolean] => x.stream.pack.cast[s.Pack]
      case _ : Byte   .G.Collection[A & Any.Byte]    => x.stream.pack.cast[s.Pack]
      case _ : Char   .G.Collection[A & Any.Char]    => x.stream.pack.cast[s.Pack]
      case _ : Short  .G.Collection[A & Any.Short]   => x.stream.pack.cast[s.Pack]
      case _ : Int    .G.Collection[A & Any.Int]     => x.stream.pack.cast[s.Pack]
      case _ : Long   .G.Collection[A & Any.Long]    => x.stream.pack.cast[s.Pack]
      case _ : Float  .G.Collection[A & Any.Float]   => x.stream.pack.cast[s.Pack]
      case _ : Double .G.Collection[A & Any.Double]  => x.stream.pack.cast[s.Pack]
      case _  => inline s match
        case _ : Specialized[A & Any.Boolean] => x.stream.cast[Stream[Boolean]].pack.cast[s.Pack]
        case _ : Specialized[A & Any.Byte   ] => x.stream.cast[Stream[Byte   ]].pack.cast[s.Pack]
        case _ : Specialized[A & Any.Char   ] => x.stream.cast[Stream[Char   ]].pack.cast[s.Pack]
        case _ : Specialized[A & Any.Short  ] => x.stream.cast[Stream[Short  ]].pack.cast[s.Pack]
        case _ : Specialized[A & Any.Int    ] => x.stream.cast[Stream[Int    ]].pack.cast[s.Pack]
        case _ : Specialized[A & Any.Long   ] => x.stream.cast[Stream[Long   ]].pack.cast[s.Pack]
        case _ : Specialized[A & Any.Float  ] => x.stream.cast[Stream[Float  ]].pack.cast[s.Pack]
        case _ : Specialized[A & Any.Double ] => x.stream.cast[Stream[Double ]].pack.cast[s.Pack]
        case _                                => x.stream.pack.cast[s.Pack]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
