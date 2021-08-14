package scalqa; package `val`; package stream; package z; package _use; package _aggregate; import language.implicitConversions

object fold:

  inline def any[A](inline x: ~[A], inline s: A, inline f: (A,A) => A) : A  = inline s match
    case _ : Boolean.Raw => boolean(x.cast[~[Boolean]],s.cast[Boolean],(x,y) => f(x.cast[A],y.cast[A]).cast[Boolean]).cast[A]
    case _ : Byte.Raw    => byte   (x.cast[~[Byte]],   s.cast[Byte],   (x,y) => f(x.cast[A],y.cast[A]).cast[Byte   ]).cast[A]
    case _ : Short.Raw   => short  (x.cast[~[Short]],  s.cast[Short],  (x,y) => f(x.cast[A],y.cast[A]).cast[Short  ]).cast[A]
    case _ : Char.Raw    => char   (x.cast[~[Char]],   s.cast[Char],   (x,y) => f(x.cast[A],y.cast[A]).cast[Char   ]).cast[A]
    case _ : Int.Raw     => int    (x.cast[~[Int]],    s.cast[Int],    (x,y) => f(x.cast[A],y.cast[A]).cast[Int    ]).cast[A]
    case _ : Long.Raw    => long   (x.cast[~[Long]],   s.cast[Long],   (x,y) => f(x.cast[A],y.cast[A]).cast[Long   ]).cast[A]
    case _ : Float.Raw   => float  (x.cast[~[Float]],  s.cast[Float],  (x,y) => f(x.cast[A],y.cast[A]).cast[Float  ]).cast[A]
    case _ : Double.Raw  => double (x.cast[~[Double]], s.cast[Double], (x,y) => f(x.cast[A],y.cast[A]).cast[Double ]).cast[A]
    case _               => ref(x,s,f)

  def ref[A] (x: ~[A], s: A, f: (A,A) => A)                 : A       = { var r = s; x.FOREACH(fv => r = f(r,fv)); r}
  def boolean(x: ~[Boolean],s: Boolean, f: Boolean.Fun.Fold): Boolean = x match {case x: Boolean.~ => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def byte   (x: ~[Byte],   s: Byte,    f: Byte.Fun.Fold   ): Byte    = x match {case x: Byte.~    => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def char   (x: ~[Char],   s: Char,    f: Char.Fun.Fold   ): Char    = x match {case x: Char.~    => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def short  (x: ~[Short],  s: Short,   f: Short.Fun.Fold  ): Short   = x match {case x: Short.~   => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def int    (x: ~[Int],    s: Int,     f: Int.Fun.Fold    ): Int     = x match {case x: Int.~     => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def long   (x: ~[Long],   s: Long,    f: Long.Fun.Fold   ): Long    = x match {case x: Long.~    => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def float  (x: ~[Float],  s: Float,   f: Float.Fun.Fold  ): Float   = x match {case x: Float.~   => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def double (x: ~[Double], s: Double,  f: Double.Fun.Fold ): Double  = x match {case x: Double.~  => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
