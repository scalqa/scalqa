package scalqa; package lang; package array; package z; import language.implicitConversions

object pack :

  inline def apply[A](inline x:Array[A])(using inline A: Specialized[A]): A.>< =
    inline A match
      case _ : Specialized[A&Any.Boolean] => Boolean.G.><.fromArray(x.cast[Array[Boolean]]).cast[A.><]
      case _ : Specialized[A&Any.Byte   ] => Byte   .G.><.fromArray(x.cast[Array[Byte   ]]).cast[A.><]
      case _ : Specialized[A&Any.Char   ] => Char   .G.><.fromArray(x.cast[Array[Char   ]]).cast[A.><]
      case _ : Specialized[A&Any.Short  ] => Short  .G.><.fromArray(x.cast[Array[Short  ]]).cast[A.><]
      case _ : Specialized[A&Any.Int    ] => Int    .G.><.fromArray(x.cast[Array[Int    ]]).cast[A.><]
      case _ : Specialized[A&Any.Long   ] => Long   .G.><.fromArray(x.cast[Array[Long   ]]).cast[A.><]
      case _ : Specialized[A&Any.Float  ] => Float  .G.><.fromArray(x.cast[Array[Float  ]]).cast[A.><]
      case _ : Specialized[A&Any.Double ] => Double .G.><.fromArray(x.cast[Array[Double ]]).cast[A.><]
      case _ : Specialized[A&AnyRef     ] =>       Val.><.fromArray(x.cast[Array[AnyRef ]]).cast[A.><]
      case _                              => any(x,\/).cast[A.><]

  def any[A](x:Array[A], sz: Int.Opt) : ><[A] =
    x match
      case x: Array[AnyRef]   => ><.fromArray(x,sz or x.length)
      case x: Array[Int]      => Int    .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Long]     => Long   .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Double]   => Double .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Boolean]  => Boolean.G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Byte]     => Byte   .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Char]     => Char   .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Float]    => Float  .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case x: Array[Short]    => Short  .G.><.fromArray(x, sz or x.length).cast[><[A]]
      case _                  => J.illegalState()


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
