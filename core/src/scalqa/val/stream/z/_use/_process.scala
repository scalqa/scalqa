package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object _process:

  inline def _FOREACH[A,U](x: ~[A], inline f: A=>U): Unit  = inline x match
    case _ : ~[A & Boolean.Raw] => x match {case _ : Boolean.G.~[_] => x.cast[Boolean.~].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Byte.Raw]    => x match {case _ : Byte.G.~[_]    => x.cast[Byte.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Short.Raw]   => x match {case _ : Short.G.~[_]   => x.cast[Short.~  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Char.Raw]    => x match {case _ : Char.G.~[_]    => x.cast[Char.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Int.Raw]     => x match {case _ : Int.G.~[_]     => x.cast[Int.~    ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Long.Raw]    => x match {case _ : Long.G.~[_]    => x.cast[Long.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Float.Raw]   => x match {case _ : Float.G.~[_]   => x.cast[Float.~  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Double.Raw]  => x match {case _ : Double.G.~[_]  => x.cast[Double.~ ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _                      => {var o=x.read_?; while(o.nonEmpty){ f(o.cast[A]); o=x.read_?}}

  inline def _foreach[A,U](x: ~[A], inline f: A=>U): Unit  = inline x match
    case _ : ~[A & Boolean.Raw] => foreachBoolean(x.cast[~[Boolean]],v => f(v.cast[A]))
    case _ : ~[A & Byte.Raw]    => foreachByte(   x.cast[~[Byte]],   v => f(v.cast[A]))
    case _ : ~[A & Short.Raw]   => foreachShort(  x.cast[~[Short]],  v => f(v.cast[A]))
    case _ : ~[A & Char.Raw]    => foreachChar(   x.cast[~[Char]],   v => f(v.cast[A]))
    case _ : ~[A & Int.Raw]     => foreachInt(    x.cast[~[Int]],    v => f(v.cast[A]))
    case _ : ~[A & Long.Raw]    => foreachLong(   x.cast[~[Long]],   v => f(v.cast[A]))
    case _ : ~[A & Float.Raw]   => foreachFloat(  x.cast[~[Float]],  v => f(v.cast[A]))
    case _ : ~[A & Double.Raw]  => foreachDouble( x.cast[~[Double]], v => f(v.cast[A]))
    case _                      => foreach(x,f)

  def foreach     [A,U](x: ~[A],      f: A=>U                  ): Unit = {var o=x.read_?; while(o.nonEmpty){ f(o.`val`); o=x.read_?}}
  def foreachBoolean[U](x: ~[Boolean],f: Boolean.Fun.Consume[U]): Unit = x match {case x: Boolean.~ => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def foreachByte   [U](x: ~[Byte],   f: Byte.Fun.Consume[U]   ): Unit = x match {case x: Byte.~    => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def foreachChar   [U](x: ~[Char],   f: Char.Fun.Consume[U]   ): Unit = x match {case x: Char.~    => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def foreachShort  [U](x: ~[Short],  f: Short.Fun.Consume[U]  ): Unit = x match {case x: Short.~   => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def foreachInt    [U](x: ~[Int],    f: Int.Fun.Consume[U]    ): Unit = x match {case x: Int.~     => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def foreachLong   [U](x: ~[Long],   f: Long.Fun.Consume[U]   ): Unit = x match {case x: Long.~    => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def foreachFloat  [U](x: ~[Float],  f: Float.Fun.Consume[U]  ): Unit = x match {case x: Float.~   => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
  def foreachDouble [U](x: ~[Double], f: Double.Fun.Consume[U] ): Unit = x match {case x: Double.~  => x.foreach(f); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
