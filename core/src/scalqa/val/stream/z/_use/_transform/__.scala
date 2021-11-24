package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object transform:

  def makeString[A](x: Stream[A], sep: String)(using t: Any.Def.Tag[A]): String =
    x.readOpt.map(v => {
      val b = String.Builder(256)
      b += t.value_tag(v)
      x.FOREACH(v => { b += sep; b += t.value_tag(v)})
      b.tag
    }) or ""

  inline def toIdx [A](inline x:Stream[A])(using inline A:Specialized[A]): A.Idx = toPack(x).cast[A.Idx]

  inline def toPack[A](inline x:Stream[A])(using inline A:Specialized[A]): A.Pack =
    inline A match
      case _ : Specialized[A & Any.Boolean] => lang.boolean.g.Pack.fromStream(x.cast[Stream[Boolean]]).cast[A.Pack]
      case _ : Specialized[A & Any.Byte   ] => lang.byte   .g.Pack.fromStream(x.cast[Stream[Byte   ]]).cast[A.Pack]
      case _ : Specialized[A & Any.Char   ] => lang.char   .g.Pack.fromStream(x.cast[Stream[Char   ]]).cast[A.Pack]
      case _ : Specialized[A & Any.Short  ] => lang.short  .g.Pack.fromStream(x.cast[Stream[Short  ]]).cast[A.Pack]
      case _ : Specialized[A & Any.Int    ] => lang.int    .g.Pack.fromStream(x.cast[Stream[Int    ]]).cast[A.Pack]
      case _ : Specialized[A & Any.Long   ] => lang.long   .g.Pack.fromStream(x.cast[Stream[Long   ]]).cast[A.Pack]
      case _ : Specialized[A & Any.Float  ] => lang.float  .g.Pack.fromStream(x.cast[Stream[Float  ]]).cast[A.Pack]
      case _ : Specialized[A & Any.Double ] => lang.double .g.Pack.fromStream(x.cast[Stream[Double ]]).cast[A.Pack]
      case _                                => `val`.pack.z.ArrayPack.fromStream[A](x).cast[A.Pack]

  inline def toSet[A](inline x:Stream[A])(using inline A:Specialized[A]): A.Set =
    inline A match
      case _ : Specialized[A & Any.Boolean] => `val`.Set.fromStream(x).cast[A.Set]
      case _ : Specialized[A & Any.Byte   ] => lang.byte   .g.Set.fromStream(x.cast[Stream[Byte   ]]).cast[A.Set]
      case _ : Specialized[A & Any.Char   ] => lang.char   .g.Set.fromStream(x.cast[Stream[Char   ]]).cast[A.Set]
      case _ : Specialized[A & Any.Short  ] => lang.short  .g.Set.fromStream(x.cast[Stream[Short  ]]).cast[A.Set]
      case _ : Specialized[A & Any.Int    ] => lang.int    .g.Set.fromStream(x.cast[Stream[Int    ]]).cast[A.Set]
      case _ : Specialized[A & Any.Long   ] => lang.long   .g.Set.fromStream(x.cast[Stream[Long   ]]).cast[A.Set]
      case _ : Specialized[A & Any.Float  ] => `val`.Set.fromStream(x).cast[A.Set]
      case _ : Specialized[A & Any.Double ] => `val`.Set.fromStream(x).cast[A.Set]
      case _                                => `val`.Set.fromStream(x).cast[A.Set]

  inline def toBuffer[A](inline x:Stream[A])(using inline A:Specialized[A]): A.Buffer =
    inline A match
      case _ : Specialized[A & Any.Boolean] => new Boolean.Buffer(x.cast[Stream[Boolean]]).cast[A.Buffer]
      case _ : Specialized[A & Any.Byte   ] => new Byte   .Buffer(x.cast[Stream[Byte   ]]).cast[A.Buffer]
      case _ : Specialized[A & Any.Char   ] => new Char   .Buffer(x.cast[Stream[Char   ]]).cast[A.Buffer]
      case _ : Specialized[A & Any.Short  ] => new Short  .Buffer(x.cast[Stream[Short  ]]).cast[A.Buffer]
      case _ : Specialized[A & Any.Int    ] => new Int    .Buffer(x.cast[Stream[Int    ]]).cast[A.Buffer]
      case _ : Specialized[A & Any.Long   ] => new Long   .Buffer(x.cast[Stream[Long   ]]).cast[A.Buffer]
      case _ : Specialized[A & Any.Float  ] => new Float  .Buffer(x.cast[Stream[Float  ]]).cast[A.Buffer]
      case _ : Specialized[A & Any.Double ] => new Double .Buffer(x.cast[Stream[Double ]]).cast[A.Buffer]
      case _                                => new AnyRef .Buffer[A](x).cast[A.Buffer]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
