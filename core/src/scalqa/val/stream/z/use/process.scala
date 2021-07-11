package scalqa; package `val`; package stream; package z; package use; import language.implicitConversions

object process:

  inline def _FOREACH[A,U](x: ~[A], inline f: A=>U): Unit  = inline x match
    case _ : ~[A & Raw.Boolean] => x match {case _ : Boolean.G.~[_] => x.cast[Boolean.~].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Raw.Byte]    => x match {case _ : Byte.G.~[_]    => x.cast[Byte.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Raw.Short]   => x match {case _ : Short.G.~[_]   => x.cast[Short.~  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Raw.Char]    => x match {case _ : Char.G.~[_]    => x.cast[Char.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Raw.Int]     => x match {case _ : Int.G.~[_]     => x.cast[Int.~    ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Raw.Long]    => x match {case _ : Long.G.~[_]    => x.cast[Long.~   ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Raw.Float]   => x match {case _ : Float.G.~[_]   => x.cast[Float.~  ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _ : ~[A & Raw.Double]  => x match {case _ : Double.G.~[_]  => x.cast[Double.~ ].FOREACH(v => f(v.cast[A])); case _ => { var o=x.read_?; while(o.nonEmpty){f(o.`val`); o=x.read_?}}}
    case _                      => {var o=x.read_?; while(o.nonEmpty){ f(o.cast[A]); o=x.read_?}}

  inline def _foreach[A,U](x: ~[A], inline f: A=>U): Unit  = inline x match
    case _ : ~[A & Raw.Boolean] => foreachBoolean(x.cast[~[Boolean]],v => f(v.cast[A]))
    case _ : ~[A & Raw.Byte]    => foreachByte(   x.cast[~[Byte]],   v => f(v.cast[A]))
    case _ : ~[A & Raw.Short]   => foreachShort(  x.cast[~[Short]],  v => f(v.cast[A]))
    case _ : ~[A & Raw.Char]    => foreachChar(   x.cast[~[Char]],   v => f(v.cast[A]))
    case _ : ~[A & Raw.Int]     => foreachInt(    x.cast[~[Int]],    v => f(v.cast[A]))
    case _ : ~[A & Raw.Long]    => foreachLong(   x.cast[~[Long]],   v => f(v.cast[A]))
    case _ : ~[A & Raw.Float]   => foreachFloat(  x.cast[~[Float]],  v => f(v.cast[A]))
    case _ : ~[A & Raw.Double]  => foreachDouble( x.cast[~[Double]], v => f(v.cast[A]))
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
