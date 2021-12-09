package scalqa; package lang; package array; package z; import language.implicitConversions

object pack :

  inline def apply[A](inline x:Array[A])(using inline s: Specialized[A]): s.Pack =
    inline s match
      case _ : Specialized[A&Any.Boolean] => Boolean.G.Pack.fromArray(x.cast[Array[Boolean]]).cast[s.Pack]
      case _ : Specialized[A&Any.Byte   ] => Byte   .G.Pack.fromArray(x.cast[Array[Byte   ]]).cast[s.Pack]
      case _ : Specialized[A&Any.Char   ] => Char   .G.Pack.fromArray(x.cast[Array[Char   ]]).cast[s.Pack]
      case _ : Specialized[A&Any.Short  ] => Short  .G.Pack.fromArray(x.cast[Array[Short  ]]).cast[s.Pack]
      case _ : Specialized[A&Any.Int    ] => Int    .G.Pack.fromArray(x.cast[Array[Int    ]]).cast[s.Pack]
      case _ : Specialized[A&Any.Long   ] => Long   .G.Pack.fromArray(x.cast[Array[Long   ]]).cast[s.Pack]
      case _ : Specialized[A&Any.Float  ] => Float  .G.Pack.fromArray(x.cast[Array[Float  ]]).cast[s.Pack]
      case _ : Specialized[A&Any.Double ] => Double .G.Pack.fromArray(x.cast[Array[Double ]]).cast[s.Pack]
      case _ : Specialized[A&AnyRef     ] =>       Val.Pack.fromArray(x.cast[Array[AnyRef ]]).cast[s.Pack]
      case _                              => any(x,VOID).cast[s.Pack]

  def any[A](x:Array[A], sz: Int.Opt) : Pack[A] =
    x match
      case x: Array[AnyRef]   => Pack.fromArray(x,sz or x.length)
      case x: Array[Int]      => Int    .G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case x: Array[Long]     => Long   .G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case x: Array[Double]   => Double .G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case x: Array[Boolean]  => Boolean.G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case x: Array[Byte]     => Byte   .G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case x: Array[Char]     => Char   .G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case x: Array[Float]    => Float  .G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case x: Array[Short]    => Short  .G.Pack.fromArray(x, sz or x.length).cast[Pack[A]]
      case _                  => J.illegalState()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
