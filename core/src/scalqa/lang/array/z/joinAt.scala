package scalqa; package lang; package array; package z; import language.implicitConversions

object joinAt:

  inline def apply[A](inline x: Array[A], inline i: Int, inline v: A)(using inline s: Specialized[A]): s.Array =
    inline s match
      case _ : Specialized[A&Any.Boolean] => boolean(x.cast[Array[Boolean]],i,v.cast[Boolean]).cast[s.Array]
      case _ : Specialized[A&Any.Byte   ] => byte   (x.cast[Array[Byte   ]],i,v.cast[Byte   ]).cast[s.Array]
      case _ : Specialized[A&Any.Char   ] => char   (x.cast[Array[Char   ]],i,v.cast[Char   ]).cast[s.Array]
      case _ : Specialized[A&Any.Short  ] => short  (x.cast[Array[Short  ]],i,v.cast[Short  ]).cast[s.Array]
      case _ : Specialized[A&Any.Int    ] => int    (x.cast[Array[Int    ]],i,v.cast[Int    ]).cast[s.Array]
      case _ : Specialized[A&Any.Long   ] => long   (x.cast[Array[Long   ]],i,v.cast[Long   ]).cast[s.Array]
      case _ : Specialized[A&Any.Float  ] => float  (x.cast[Array[Float  ]],i,v.cast[Float  ]).cast[s.Array]
      case _ : Specialized[A&Any.Double ] => double (x.cast[Array[Double ]],i,v.cast[Double ]).cast[s.Array]
      case _ : Specialized[A&AnyRef     ] => anyref (x.cast[Array[AnyRef ]],i,v.cast[AnyRef ]).cast[s.Array]
      case _                              => any    (x.cast[Array[A      ]],i,v              ).cast[s.Array]

  def any[A](x: Array[A], i: Int, v: A): Array[A] =
    x match
       case x: Array[AnyRef]     => anyref (x,i,v)
       case x: Array[Int]        => int    (x,i,v)
       case x: Array[Double]     => double (x,i,v)
       case x: Array[Long]       => long   (x,i,v)
       case x: Array[Float]      => float  (x,i,v)
       case x: Array[Char]       => char   (x,i,v)
       case x: Array[Byte]       => byte   (x,i,v)
       case x: Array[Short]      => short  (x,i,v)
       case x: Array[Boolean]    => boolean(x,i,v)

  def boolean(x: Array[Boolean], i: Int, v: Boolean): Array[Boolean] = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def byte   (x: Array[Byte],    i: Int, v: Byte)   : Array[Byte]    = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def char   (x: Array[Char],    i: Int, v: Char)   : Array[Char]    = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def short  (x: Array[Short],   i: Int, v: Short)  : Array[Short]   = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def int    (x: Array[Int],     i: Int, v: Int)    : Array[Int]     = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def long   (x: Array[Long],    i: Int, v: Long)   : Array[Long]    = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def float  (x: Array[Float],   i: Int, v: Float)  : Array[Float]   = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def double (x: Array[Double],  i: Int, v: Double) : Array[Double]  = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def anyref (x: Array[AnyRef],  i: Int, v: AnyRef) : Array[AnyRef]  = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
