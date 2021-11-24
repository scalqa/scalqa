package scalqa; package `val`; package stream; package z; package _use; package _process; import language.implicitConversions

object foreach:

  inline def heavy[A,U](x: Stream[A], inline f: A=>U): Unit  = inline x match
    case _ : Stream[A & Any.Boolean] => x match {case _ : Boolean.G.Stream[_] => x.cast[Boolean.Stream].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _ : Stream[A & Any.Byte]    => x match {case _ : Byte.G.Stream[_]    => x.cast[Byte.Stream   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _ : Stream[A & Any.Short]   => x match {case _ : Short.G.Stream[_]   => x.cast[Short.Stream  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _ : Stream[A & Any.Char]    => x match {case _ : Char.G.Stream[_]    => x.cast[Char.Stream   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _ : Stream[A & Any.Int]     => x match {case _ : Int.G.Stream[_]     => x.cast[Int.Stream    ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _ : Stream[A & Any.Long]    => x match {case _ : Long.G.Stream[_]    => x.cast[Long.Stream   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _ : Stream[A & Any.Float]   => x match {case _ : Float.G.Stream[_]   => x.cast[Float.Stream  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _ : Stream[A & Any.Double]  => x match {case _ : Double.G.Stream[_]  => x.cast[Double.Stream ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
    case _                      => {var o=x.readOpt; while(o){ f(o.cast[A]); o=x.readOpt}}

  inline def any[A,U](x: Stream[A], inline f: A=>U): Unit  = inline x match
    case _ : Stream[A & Any.Boolean] => boolean(x.cast[Stream[Boolean]],v => f(v.cast[A]))
    case _ : Stream[A & Any.Byte]    => byte(   x.cast[Stream[Byte]],   v => f(v.cast[A]))
    case _ : Stream[A & Any.Short]   => short(  x.cast[Stream[Short]],  v => f(v.cast[A]))
    case _ : Stream[A & Any.Char]    => char(   x.cast[Stream[Char]],   v => f(v.cast[A]))
    case _ : Stream[A & Any.Int]     => int(    x.cast[Stream[Int]],    v => f(v.cast[A]))
    case _ : Stream[A & Any.Long]    => long(   x.cast[Stream[Long]],   v => f(v.cast[A]))
    case _ : Stream[A & Any.Float]   => float(  x.cast[Stream[Float]],  v => f(v.cast[A]))
    case _ : Stream[A & Any.Double]  => double( x.cast[Stream[Double]], v => f(v.cast[A]))
    case _                      => apply(  x,f)

  def apply[A,U](x: Stream[A],      f: A=>U                  ): Unit = {var o=x.readOpt; while(o){ f(o.`val`); o=x.readOpt}}
  def boolean[U](x: Stream[Boolean],f: Boolean.Fun.Consume[U]): Unit = x match {case x: Boolean.Stream => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
  def byte   [U](x: Stream[Byte],   f: Byte.Fun.Consume[U]   ): Unit = x match {case x: Byte.Stream    => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
  def char   [U](x: Stream[Char],   f: Char.Fun.Consume[U]   ): Unit = x match {case x: Char.Stream    => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
  def short  [U](x: Stream[Short],  f: Short.Fun.Consume[U]  ): Unit = x match {case x: Short.Stream   => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
  def int    [U](x: Stream[Int],    f: Int.Fun.Consume[U]    ): Unit = x match {case x: Int.Stream     => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
  def long   [U](x: Stream[Long],   f: Long.Fun.Consume[U]   ): Unit = x match {case x: Long.Stream    => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
  def float  [U](x: Stream[Float],  f: Float.Fun.Consume[U]  ): Unit = x match {case x: Float.Stream   => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}
  def double [U](x: Stream[Double], f: Double.Fun.Consume[U] ): Unit = x match {case x: Double.Stream  => x.foreach(f); case _ => { var o=x.readOpt; while(o){f(o.`val`); o=x.readOpt}}}

  def indexed[A,U](x: Stream[A],f: (Int,A) => U, start: Int=0): Unit = {var i=start; x.FOREACH(v => {f(i,v); i+=1})}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
