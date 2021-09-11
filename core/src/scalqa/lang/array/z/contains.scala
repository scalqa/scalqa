package scalqa; package lang; package array; package z; import language.implicitConversions

object contains:

  inline def apply[A](inline x: Array[A], inline v: A)(using inline A: Specialized[A]): Boolean =
    inline A match
              case _ : Specialized[A&Any.Boolean] => boolean(x.cast[Array[Boolean]],v.cast[Boolean])
              case _ : Specialized[A&Any.Byte   ] => byte   (x.cast[Array[Byte   ]],v.cast[Byte])
              case _ : Specialized[A&Any.Char   ] => char   (x.cast[Array[Char   ]],v.cast[Char])
              case _ : Specialized[A&Any.Short  ] => short  (x.cast[Array[Short  ]],v.cast[Short])
              case _ : Specialized[A&Any.Int    ] => int    (x.cast[Array[Int    ]],v.cast[Int])
              case _ : Specialized[A&Any.Long   ] => long   (x.cast[Array[Long   ]],v.cast[Long])
              case _ : Specialized[A&Any.Float  ] => float  (x.cast[Array[Float  ]],v.cast[Float])
              case _ : Specialized[A&Any.Double ] => double (x.cast[Array[Double ]],v.cast[Double])
              case _ : Specialized[A&AnyRef     ] => anyref (x.cast[Array[AnyRef ]],v.cast[AnyRef])
              case _                              => any    (x.cast[Array[A      ]],v)

  def any[A](x: Array[A], v: A): Boolean =
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

  def boolean(a: Array[Boolean], v: Boolean, sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def byte   (a: Array[Byte],    v: Byte,    sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def char   (a: Array[Char],    v: Char,    sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def short  (a: Array[Short],   v: Short,   sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def int    (a: Array[Int],     v: Int,     sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def long   (a: Array[Long],    v: Long,    sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def float  (a: Array[Float],   v: Float,   sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def double (a: Array[Double],  v: Double,  sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def anyref (a: Array[AnyRef],  v: AnyRef,  sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}

  inline def boolean(x:Array[Boolean],inline v: Boolean): Boolean = boolean(x,v,x.length)
  inline def byte   (x:Array[Byte],   inline v: Byte)   : Boolean = byte   (x,v,x.length)
  inline def char   (x:Array[Char],   inline v: Char)   : Boolean = char   (x,v,x.length)
  inline def short  (x:Array[Short],  inline v: Short)  : Boolean = short  (x,v,x.length)
  inline def int    (x:Array[Int],    inline v: Int)    : Boolean = int    (x,v,x.length)
  inline def long   (x:Array[Long],   inline v: Long)   : Boolean = long   (x,v,x.length)
  inline def float  (x:Array[Float],  inline v: Float)  : Boolean = float  (x,v,x.length)
  inline def double (x:Array[Double], inline v: Double) : Boolean = double (x,v,x.length)
  inline def anyref (x:Array[AnyRef], inline v: AnyRef) : Boolean = anyref (x,v,x.length)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
