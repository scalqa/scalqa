package scalqa; package `val`; package stream; package z; package _use; package _aggregate; import language.implicitConversions

object fold:

  inline def any[A](inline x: Stream[A], inline s: A, inline f: (A,A) => A) : A  = inline s match
    case _ : Any.Boolean => boolean(x.cast[Stream[Boolean]],s.cast[Boolean],(x,y) => f(x.cast[A],y.cast[A]).cast[Boolean]).cast[A]
    case _ : Any.Byte    => byte   (x.cast[Stream[Byte]],   s.cast[Byte],   (x,y) => f(x.cast[A],y.cast[A]).cast[Byte   ]).cast[A]
    case _ : Any.Short   => short  (x.cast[Stream[Short]],  s.cast[Short],  (x,y) => f(x.cast[A],y.cast[A]).cast[Short  ]).cast[A]
    case _ : Any.Char    => char   (x.cast[Stream[Char]],   s.cast[Char],   (x,y) => f(x.cast[A],y.cast[A]).cast[Char   ]).cast[A]
    case _ : Any.Int     => int    (x.cast[Stream[Int]],    s.cast[Int],    (x,y) => f(x.cast[A],y.cast[A]).cast[Int    ]).cast[A]
    case _ : Any.Long    => long   (x.cast[Stream[Long]],   s.cast[Long],   (x,y) => f(x.cast[A],y.cast[A]).cast[Long   ]).cast[A]
    case _ : Any.Float   => float  (x.cast[Stream[Float]],  s.cast[Float],  (x,y) => f(x.cast[A],y.cast[A]).cast[Float  ]).cast[A]
    case _ : Any.Double  => double (x.cast[Stream[Double]], s.cast[Double], (x,y) => f(x.cast[A],y.cast[A]).cast[Double ]).cast[A]
    case _               => ref(x,s,f)

  def ref[A] (x: Stream[A], s: A, f: (A,A) => A)                 : A       = { var r = s; x.FOREACH(fv => r = f(r,fv)); r}
  def boolean(x: Stream[Boolean],s: Boolean, f: Boolean.Fun.Fold): Boolean = x match {case x: Boolean.Stream => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}
  def byte   (x: Stream[Byte],   s: Byte,    f: Byte.Fun.Fold   ): Byte    = x match {case x: Byte.Stream    => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}
  def char   (x: Stream[Char],   s: Char,    f: Char.Fun.Fold   ): Char    = x match {case x: Char.Stream    => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}
  def short  (x: Stream[Short],  s: Short,   f: Short.Fun.Fold  ): Short   = x match {case x: Short.Stream   => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}
  def int    (x: Stream[Int],    s: Int,     f: Int.Fun.Fold    ): Int     = x match {case x: Int.Stream     => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}
  def long   (x: Stream[Long],   s: Long,    f: Long.Fun.Fold   ): Long    = x match {case x: Long.Stream    => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}
  def float  (x: Stream[Float],  s: Float,   f: Float.Fun.Fold  ): Float   = x match {case x: Float.Stream   => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}
  def double (x: Stream[Double], s: Double,  f: Double.Fun.Fold ): Double  = x match {case x: Double.Stream  => x.fold(s)(f); case _ => {var v=s; var o=x.readOpt; while(o){v=f(v,o.`val`); o=x.readOpt};v}}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
