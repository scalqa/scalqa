package scalqa; package lang; package array; package z; import language.implicitConversions

object joinAll:

  inline def apply[A](inline x: Array[A], inline v: ~[A])(using inline A: Specialized[A]): A.Array =
    inline A match
      case _ : Specialized[A&Any.Boolean] => boolean(x.cast[Array[Boolean]],v.cast[~[Boolean]]).cast[A.Array]
      case _ : Specialized[A&Any.Byte   ] => byte   (x.cast[Array[Byte   ]],v.cast[~[Byte   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Char   ] => char   (x.cast[Array[Char   ]],v.cast[~[Char   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Short  ] => short  (x.cast[Array[Short  ]],v.cast[~[Short  ]]).cast[A.Array]
      case _ : Specialized[A&Any.Int    ] => int    (x.cast[Array[Int    ]],v.cast[~[Int    ]]).cast[A.Array]
      case _ : Specialized[A&Any.Long   ] => long   (x.cast[Array[Long   ]],v.cast[~[Long   ]]).cast[A.Array]
      case _ : Specialized[A&Any.Float  ] => float  (x.cast[Array[Float  ]],v.cast[~[Float  ]]).cast[A.Array]
      case _ : Specialized[A&Any.Double ] => double (x.cast[Array[Double ]],v.cast[~[Double ]]).cast[A.Array]
      case _ : Specialized[A&AnyRef     ] => anyref (x.cast[Array[AnyRef ]],v.cast[~[AnyRef ]]).cast[A.Array]
      case _                              => any    (x.cast[Array[A      ]],v                 ).cast[A.Array]

  def any[A](x: Array[A], v: ~[A]): Array[A] =
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

  def boolean(x:Array[Boolean],v: ~[Boolean]): Array[Boolean]= {var b=lang.boolean.g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def byte   (x:Array[Byte],   v: ~[Byte])   : Array[Byte]   = {val b=lang.byte   .g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def char   (x:Array[Char],   v: ~[Char])   : Array[Char]   = {var b=lang.char   .g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def short  (x:Array[Short],  v: ~[Short])  : Array[Short]  = {var b=lang.short  .g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def int    (x:Array[Int],    v: ~[Int])    : Array[Int]    = {var b=lang.int    .g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def long   (x:Array[Long],   v: ~[Long])   : Array[Long]   = {var b=lang.long   .g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def float  (x:Array[Float],  v: ~[Float])  : Array[Float]  = {var b=lang.float  .g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def double (x:Array[Double], v: ~[Double]) : Array[Double] = {var b=lang.double .g.Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}
  def anyref (x:Array[AnyRef], v: ~[AnyRef]) : Array[AnyRef] = {var b=lang.anyref   .Buffer.accessible(x,x.length).^(_ ++= v); var a=b.access; val sz=b.size; if(a.length!=sz || (a eq x)) a=a.copySize(sz); a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
