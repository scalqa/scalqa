package scalqa; package `val`; package stream; package z; package _use; package _aggregate; import language.implicitConversions

object foldAs:

  transparent inline def any[A,B](inline x: ~[A], inline s: B, inline f: (B,A) => B) : B  = inline x match
    case _ : ~[A & Boolean.Raw] => { var r = s; _process.foreach.boolean(x.cast[~[Boolean]],v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Byte.Raw]    => { var r = s; _process.foreach.byte(   x.cast[~[Byte]],   v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Short.Raw]   => { var r = s; _process.foreach.short(  x.cast[~[Short]],  v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Char.Raw]    => { var r = s; _process.foreach.char(   x.cast[~[Char]],   v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Int.Raw]     => { var r = s; _process.foreach.int(    x.cast[~[Int]],    v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Long.Raw]    => { var r = s; _process.foreach.long(   x.cast[~[Long]],   v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Float.Raw]   => { var r = s; _process.foreach.float(  x.cast[~[Float]],  v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Double.Raw]  => { var r = s; _process.foreach.double( x.cast[~[Double]], v => r = f(r,v.cast[A])); r}
    case _                      => ref(x,s,f)

  def ref[A,B](x: ~[A], s: B, f: (B,A) => B) : B  = { var r = s; x.FOREACH(v => r = f(r,v)); r}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
