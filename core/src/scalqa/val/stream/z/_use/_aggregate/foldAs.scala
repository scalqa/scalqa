package scalqa; package `val`; package stream; package z; package _use; package _aggregate; import language.implicitConversions

object foldAs:

  transparent inline def any[A,B](inline x: Stream[A], inline s: B, inline f: (B,A) => B) : B  = inline x match
    case _ : Stream[A & Any.Boolean] => { var r = s; _process.foreach.boolean(x.cast[Stream[Boolean]],v => r = f(r,v.cast[A])); r}
    case _ : Stream[A & Any.Byte]    => { var r = s; _process.foreach.byte(   x.cast[Stream[Byte]],   v => r = f(r,v.cast[A])); r}
    case _ : Stream[A & Any.Short]   => { var r = s; _process.foreach.short(  x.cast[Stream[Short]],  v => r = f(r,v.cast[A])); r}
    case _ : Stream[A & Any.Char]    => { var r = s; _process.foreach.char(   x.cast[Stream[Char]],   v => r = f(r,v.cast[A])); r}
    case _ : Stream[A & Any.Int]     => { var r = s; _process.foreach.int(    x.cast[Stream[Int]],    v => r = f(r,v.cast[A])); r}
    case _ : Stream[A & Any.Long]    => { var r = s; _process.foreach.long(   x.cast[Stream[Long]],   v => r = f(r,v.cast[A])); r}
    case _ : Stream[A & Any.Float]   => { var r = s; _process.foreach.float(  x.cast[Stream[Float]],  v => r = f(r,v.cast[A])); r}
    case _ : Stream[A & Any.Double]  => { var r = s; _process.foreach.double( x.cast[Stream[Double]], v => r = f(r,v.cast[A])); r}
    case _                      => ref(x,s,f)

  def ref[A,B](x: Stream[A], s: B, f: (B,A) => B) : B  = { var r = s; x.FOREACH(v => r = f(r,v)); r}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
