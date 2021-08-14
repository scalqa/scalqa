package scalqa; package `val`; package stream; package z; package _use; package _process; import language.implicitConversions

object foreach:

  inline def heavy[A,U](x: ~[A], inline f: A=>U): Unit  = inline x match
    case _ : ~[A & Boolean.Raw] => x match {case _ : Boolean.G.~[_] => x.cast[Boolean.~].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Byte.Raw]    => x match {case _ : Byte.G.~[_]    => x.cast[Byte.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Short.Raw]   => x match {case _ : Short.G.~[_]   => x.cast[Short.~  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Char.Raw]    => x match {case _ : Char.G.~[_]    => x.cast[Char.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Int.Raw]     => x match {case _ : Int.G.~[_]     => x.cast[Int.~    ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Long.Raw]    => x match {case _ : Long.G.~[_]    => x.cast[Long.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Float.Raw]   => x match {case _ : Float.G.~[_]   => x.cast[Float.~  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Double.Raw]  => x match {case _ : Double.G.~[_]  => x.cast[Double.~ ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _                      => {var o=x.read_?; while(o.nonEmpty){ f(o.cast[A]); o=x.read_?}}

  inline def any[A,U](x: ~[A], inline f: A=>U): Unit  = inline x match
    case _ : ~[A & Boolean.Raw] => boolean(x.cast[~[Boolean]],v => f(v.cast[A]))
    case _ : ~[A & Byte.Raw]    => byte(   x.cast[~[Byte]],   v => f(v.cast[A]))
    case _ : ~[A & Short.Raw]   => short(  x.cast[~[Short]],  v => f(v.cast[A]))
    case _ : ~[A & Char.Raw]    => char(   x.cast[~[Char]],   v => f(v.cast[A]))
    case _ : ~[A & Int.Raw]     => int(    x.cast[~[Int]],    v => f(v.cast[A]))
    case _ : ~[A & Long.Raw]    => long(   x.cast[~[Long]],   v => f(v.cast[A]))
    case _ : ~[A & Float.Raw]   => float(  x.cast[~[Float]],  v => f(v.cast[A]))
    case _ : ~[A & Double.Raw]  => double( x.cast[~[Double]], v => f(v.cast[A]))
    case _                      => ref(x,f)

  def ref    [A,U](x: ~[A],      f: A=>U                  ): Unit = {var o=x.read_?; while(o.nonEmpty){ f(o.`val`); o=x.read_?}}
  def boolean[U](x: ~[Boolean],f: Boolean.Fun.Consume[U]): Unit = x match {case x: Boolean.~ => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def byte   [U](x: ~[Byte],   f: Byte.Fun.Consume[U]   ): Unit = x match {case x: Byte.~    => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def char   [U](x: ~[Char],   f: Char.Fun.Consume[U]   ): Unit = x match {case x: Char.~    => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def short  [U](x: ~[Short],  f: Short.Fun.Consume[U]  ): Unit = x match {case x: Short.~   => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def int    [U](x: ~[Int],    f: Int.Fun.Consume[U]    ): Unit = x match {case x: Int.~     => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def long   [U](x: ~[Long],   f: Long.Fun.Consume[U]   ): Unit = x match {case x: Long.~    => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def float  [U](x: ~[Float],  f: Float.Fun.Consume[U]  ): Unit = x match {case x: Float.~   => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def double [U](x: ~[Double], f: Double.Fun.Consume[U] ): Unit = x match {case x: Double.~  => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}

  def indexed[A,U](x: ~[A],f: (Int,A) => U, start: Int=0): Unit = {var i=start; x.FOREACH(v => {f(i,v); i+=1})}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
