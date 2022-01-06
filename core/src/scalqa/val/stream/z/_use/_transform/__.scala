package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object transform:

  def makeString[A](x: Stream[A], sep: String)(using t: Any.Def.Tag[A]): String =
    x.readOpt.map(v => {
      val b = String.Builder(256)
      b += t.value_tag(v)
      x.FOREACH(v => { b += sep; b += t.value_tag(v)})
      b.tag
    }) or ""

  inline def toIdx [A](inline x:Stream[A])(using inline s:Specialized[A]): s.Idx = toPack(x).cast[s.Idx]

  inline def toPack[A](inline x:Stream[A])(using inline s:Specialized[A]): s.Pack =
    inline s match
      case _ : Specialized[A & Any.Boolean] => lang.boolean.g.Pack.fromStream(x.cast[Stream[Boolean]]).cast[s.Pack]
      case _ : Specialized[A & Any.Byte   ] => lang.byte   .g.Pack.fromStream(x.cast[Stream[Byte   ]]).cast[s.Pack]
      case _ : Specialized[A & Any.Char   ] => lang.char   .g.Pack.fromStream(x.cast[Stream[Char   ]]).cast[s.Pack]
      case _ : Specialized[A & Any.Short  ] => lang.short  .g.Pack.fromStream(x.cast[Stream[Short  ]]).cast[s.Pack]
      case _ : Specialized[A & Any.Int    ] => lang.int    .g.Pack.fromStream(x.cast[Stream[Int    ]]).cast[s.Pack]
      case _ : Specialized[A & Any.Long   ] => lang.long   .g.Pack.fromStream(x.cast[Stream[Long   ]]).cast[s.Pack]
      case _ : Specialized[A & Any.Float  ] => lang.float  .g.Pack.fromStream(x.cast[Stream[Float  ]]).cast[s.Pack]
      case _ : Specialized[A & Any.Double ] => lang.double .g.Pack.fromStream(x.cast[Stream[Double ]]).cast[s.Pack]
      case _                                => `val`.pack.z.ArrayPack.fromStream[A](x).cast[s.Pack]

  inline def toSet[A](inline x:Stream[A])(using inline s:Specialized[A]): s.Set =
    inline s match
      case _ : Specialized[A & Any.Boolean] => `val`.Set.fromStream(x).cast[s.Set]
      case _ : Specialized[A & Any.Byte   ] => lang.byte   .g.Set.fromStream(x.cast[Stream[Byte   ]]).cast[s.Set]
      case _ : Specialized[A & Any.Char   ] => lang.char   .g.Set.fromStream(x.cast[Stream[Char   ]]).cast[s.Set]
      case _ : Specialized[A & Any.Short  ] => lang.short  .g.Set.fromStream(x.cast[Stream[Short  ]]).cast[s.Set]
      case _ : Specialized[A & Any.Int    ] => lang.int    .g.Set.fromStream(x.cast[Stream[Int    ]]).cast[s.Set]
      case _ : Specialized[A & Any.Long   ] => lang.long   .g.Set.fromStream(x.cast[Stream[Long   ]]).cast[s.Set]
      case _ : Specialized[A & Any.Float  ] => `val`.Set.fromStream(x).cast[s.Set]
      case _ : Specialized[A & Any.Double ] => `val`.Set.fromStream(x).cast[s.Set]
      case _                                => `val`.Set.fromStream(x).cast[s.Set]

  inline def toBuffer[A](inline x:Stream[A])(using inline s:Specialized[A]): s.Buffer =
    inline s match
      case _ : Specialized[A & Any.Boolean] => new Boolean .Buffer(x.cast[Stream[Boolean]]).cast[s.Buffer]
      case _ : Specialized[A & Any.Byte   ] => new Byte    .Buffer(x.cast[Stream[Byte   ]]).cast[s.Buffer]
      case _ : Specialized[A & Any.Char   ] => new Char    .Buffer(x.cast[Stream[Char   ]]).cast[s.Buffer]
      case _ : Specialized[A & Any.Short  ] => new Short   .Buffer(x.cast[Stream[Short  ]]).cast[s.Buffer]
      case _ : Specialized[A & Any.Int    ] => new Int     .Buffer(x.cast[Stream[Int    ]]).cast[s.Buffer]
      case _ : Specialized[A & Any.Long   ] => new Long    .Buffer(x.cast[Stream[Long   ]]).cast[s.Buffer]
      case _ : Specialized[A & Any.Float  ] => new Float   .Buffer(x.cast[Stream[Float  ]]).cast[s.Buffer]
      case _ : Specialized[A & Any.Double ] => new Double  .Buffer(x.cast[Stream[Double ]]).cast[s.Buffer]
      case _                                => new AnyRef.G.Buffer[A](x).cast[s.Buffer]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
