package scalqa; package lang; package array; package z; import language.implicitConversions

object fill:

  inline def apply[A](inline x: Array[A], inline p: Int, inline sz: Int, inline v: A)(using inline A: Specialized[A]): Unit =
    inline A match
              case _ : Specialized[A&Any.Boolean] => boolean(x.cast[Array[Boolean]],p, sz, v.cast[Boolean])
              case _ : Specialized[A&Any.Byte   ] => byte   (x.cast[Array[Byte]],   p, sz, v.cast[Byte])
              case _ : Specialized[A&Any.Char   ] => char   (x.cast[Array[Char]],   p, sz, v.cast[Char])
              case _ : Specialized[A&Any.Short  ] => short  (x.cast[Array[Short]],  p, sz, v.cast[Short])
              case _ : Specialized[A&Any.Int    ] => int    (x.cast[Array[Int]],    p, sz, v.cast[Int])
              case _ : Specialized[A&Any.Long   ] => long   (x.cast[Array[Long]],   p, sz, v.cast[Long])
              case _ : Specialized[A&Any.Float  ] => float  (x.cast[Array[Float]],  p, sz, v.cast[Float])
              case _ : Specialized[A&Any.Double ] => double (x.cast[Array[Double]], p, sz, v.cast[Double])
              case _ : Specialized[A&AnyRef     ] => anyref (x.cast[Array[AnyRef]], p, sz, v.cast[AnyRef])
              case _                              => any    (x.cast[Array[A]],      p, sz, v)

  def any[A](x: Array[A], p:Int, sz:Int, v: A): Unit =
    x match
       case x: Array[AnyRef]     => anyref (x,p,sz,v)
       case x: Array[Int]        => int    (x,p,sz,v)
       case x: Array[Double]     => double (x,p,sz,v)
       case x: Array[Long]       => long   (x,p,sz,v)
       case x: Array[Float]      => float  (x,p,sz,v)
       case x: Array[Char]       => char   (x,p,sz,v)
       case x: Array[Byte]       => byte   (x,p,sz,v)
       case x: Array[Short]      => short  (x,p,sz,v)
       case x: Array[Boolean]    => boolean(x,p,sz,v)

  def boolean(a: Array[Boolean], p: Int, sz: Int, v: Boolean): Unit  = for(i <- p <>= sz) a(i) = v
  def byte   (a: Array[Byte],    p: Int, sz: Int, v: Byte)   : Unit  = for(i <- p <>= sz) a(i) = v
  def char   (a: Array[Char],    p: Int, sz: Int, v: Char)   : Unit  = for(i <- p <>= sz) a(i) = v
  def short  (a: Array[Short],   p: Int, sz: Int, v: Short)  : Unit  = for(i <- p <>= sz) a(i) = v
  def int    (a: Array[Int],     p: Int, sz: Int, v: Int)    : Unit  = for(i <- p <>= sz) a(i) = v
  def long   (a: Array[Long],    p: Int, sz: Int, v: Long)   : Unit  = for(i <- p <>= sz) a(i) = v
  def float  (a: Array[Float],   p: Int, sz: Int, v: Float)  : Unit  = for(i <- p <>= sz) a(i) = v
  def double (a: Array[Double],  p: Int, sz: Int, v: Double) : Unit  = for(i <- p <>= sz) a(i) = v
  def anyref (a: Array[AnyRef],  p: Int, sz: Int, v: AnyRef) : Unit  = for(i <- p <>= sz) a(i) = v

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
