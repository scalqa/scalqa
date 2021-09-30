package scalqa; package `val`; package pack; package z; import language.implicitConversions

object StreamAble:

  inline def apply[A](inline x:Able.~[A])(using inline A: Specialized[A]): A.>< =
    inline x match
      case _ : Boolean.G.Collection[A & Any.Boolean] => x.~.><.cast[A.><]
      case _ : Byte   .G.Collection[A & Any.Byte]    => x.~.><.cast[A.><]
      case _ : Char   .G.Collection[A & Any.Char]    => x.~.><.cast[A.><]
      case _ : Short  .G.Collection[A & Any.Short]   => x.~.><.cast[A.><]
      case _ : Int    .G.Collection[A & Any.Int]     => x.~.><.cast[A.><]
      case _ : Long   .G.Collection[A & Any.Long]    => x.~.><.cast[A.><]
      case _ : Float  .G.Collection[A & Any.Float]   => x.~.><.cast[A.><]
      case _ : Double .G.Collection[A & Any.Double]  => x.~.><.cast[A.><]
      case _  => inline A match
        case _ : Specialized[A & Any.Boolean] => x.~.cast[~[Boolean]].><.cast[A.><]
        case _ : Specialized[A & Any.Byte   ] => x.~.cast[~[Byte   ]].><.cast[A.><]
        case _ : Specialized[A & Any.Char   ] => x.~.cast[~[Char   ]].><.cast[A.><]
        case _ : Specialized[A & Any.Short  ] => x.~.cast[~[Short  ]].><.cast[A.><]
        case _ : Specialized[A & Any.Int    ] => x.~.cast[~[Int    ]].><.cast[A.><]
        case _ : Specialized[A & Any.Long   ] => x.~.cast[~[Long   ]].><.cast[A.><]
        case _ : Specialized[A & Any.Float  ] => x.~.cast[~[Float  ]].><.cast[A.><]
        case _ : Specialized[A & Any.Double ] => x.~.cast[~[Double ]].><.cast[A.><]
        case _                                => x.~.><.cast[A.><]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
