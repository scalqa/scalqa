package scalqa; package `val`; package stream; package z; package _use; package _transform; import language.implicitConversions

object toArray:

  inline def apply[A](inline x: Stream[A])(using inline t: ClassTag[A], inline s: Specialized[A]): s.Array =
    inline s match
      case _ : Specialized[A&Any.Boolean] => x.cast[Stream[Boolean]].raw.toArray.cast[s.Array]
      case _ : Specialized[A&Any.Byte   ] => x.cast[Stream[Byte   ]].raw.toArray.cast[s.Array]
      case _ : Specialized[A&Any.Char   ] => x.cast[Stream[Char   ]].raw.toArray.cast[s.Array]
      case _ : Specialized[A&Any.Short  ] => x.cast[Stream[Short  ]].raw.toArray.cast[s.Array]
      case _ : Specialized[A&Any.Int    ] => x.cast[Stream[Int    ]].raw.toArray.cast[s.Array]
      case _ : Specialized[A&Any.Long   ] => x.cast[Stream[Long   ]].raw.toArray.cast[s.Array]
      case _ : Specialized[A&Any.Float  ] => x.cast[Stream[Float  ]].raw.toArray.cast[s.Array]
      case _ : Specialized[A&Any.Double ] => x.cast[Stream[Double ]].raw.toArray.cast[s.Array]
      case _                              => AnyRef.Buffer.z_StreamToArray(x).cast[s.Array]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
