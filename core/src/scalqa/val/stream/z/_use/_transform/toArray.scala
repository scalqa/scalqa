package scalqa; package `val`; package stream; package z; package _use; package _transform; import language.implicitConversions

object toArray:

  inline def apply[A](inline x: ~[A])(using inline t: ClassTag[A], inline A: Specialized[A]): A.Array =
    inline A match
      case _ : Specialized[A&Any.Boolean] => x.cast[~[Boolean]].raw.toArray.cast[A.Array]
      case _ : Specialized[A&Any.Byte   ] => x.cast[~[Byte   ]].raw.toArray.cast[A.Array]
      case _ : Specialized[A&Any.Char   ] => x.cast[~[Char   ]].raw.toArray.cast[A.Array]
      case _ : Specialized[A&Any.Short  ] => x.cast[~[Short  ]].raw.toArray.cast[A.Array]
      case _ : Specialized[A&Any.Int    ] => x.cast[~[Int    ]].raw.toArray.cast[A.Array]
      case _ : Specialized[A&Any.Long   ] => x.cast[~[Long   ]].raw.toArray.cast[A.Array]
      case _ : Specialized[A&Any.Float  ] => x.cast[~[Float  ]].raw.toArray.cast[A.Array]
      case _ : Specialized[A&Any.Double ] => x.cast[~[Double ]].raw.toArray.cast[A.Array]
      case _                              => AnyRef.Buffer.z_StreamToArray(x).cast[A.Array]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
