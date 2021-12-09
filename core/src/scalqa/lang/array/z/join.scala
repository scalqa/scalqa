package scalqa; package lang; package array; package z; import language.implicitConversions

object join:

  inline def apply[A](inline x: Array[A], inline v: A)(using inline s: Specialized[A]): s.Array =
    inline s match
      case _ : Specialized[A&Any.Boolean] => boolean(x.cast[Array[Boolean]],v.cast[Boolean]).cast[s.Array]
      case _ : Specialized[A&Any.Byte   ] => byte   (x.cast[Array[Byte   ]],v.cast[Byte   ]).cast[s.Array]
      case _ : Specialized[A&Any.Char   ] => char   (x.cast[Array[Char   ]],v.cast[Char   ]).cast[s.Array]
      case _ : Specialized[A&Any.Short  ] => short  (x.cast[Array[Short  ]],v.cast[Short  ]).cast[s.Array]
      case _ : Specialized[A&Any.Int    ] => int    (x.cast[Array[Int    ]],v.cast[Int    ]).cast[s.Array]
      case _ : Specialized[A&Any.Long   ] => long   (x.cast[Array[Long   ]],v.cast[Long   ]).cast[s.Array]
      case _ : Specialized[A&Any.Float  ] => float  (x.cast[Array[Float  ]],v.cast[Float  ]).cast[s.Array]
      case _ : Specialized[A&Any.Double ] => double (x.cast[Array[Double ]],v.cast[Double ]).cast[s.Array]
      case _ : Specialized[A&AnyRef     ] => anyref (x.cast[Array[AnyRef ]],v.cast[AnyRef ]).cast[s.Array]
      case _                              => any    (x.cast[Array[A      ]],v              ).cast[s.Array]

  def any[A](x: Array[A], v: A): Array[A] =
    x match
       case x: Array[AnyRef]     => anyref (x,v)
       case x: Array[Int]        => int    (x,v)
       case x: Array[Double]     => double (x,v)
       case x: Array[Long]       => long   (x,v)
       case x: Array[Float]      => float  (x,v)
       case x: Array[Char]       => char   (x,v)
       case x: Array[Byte]       => byte   (x,v)
       case x: Array[Short]      => short  (x,v)
       case x: Array[Boolean]    => boolean(x,v)

  def boolean(x: Array[Boolean], v: Boolean): Array[Boolean] = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def byte   (x: Array[Byte],    v: Byte)   : Array[Byte]    = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def char   (x: Array[Char],    v: Char)   : Array[Char]    = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def short  (x: Array[Short],   v: Short)  : Array[Short]   = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def int    (x: Array[Int],     v: Int)    : Array[Int]     = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def long   (x: Array[Long],    v: Long)   : Array[Long]    = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def float  (x: Array[Float],   v: Float)  : Array[Float]   = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def double (x: Array[Double],  v: Double) : Array[Double]  = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def anyref (x: Array[AnyRef],  v: AnyRef) : Array[AnyRef]  = {val a=x.copySize(x.length+1); a(x.length)=v; a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
