package scalqa; package `val`; package stream; package z; package _use; package _evaluate; import language.implicitConversions

object find:

  def opt[A](x: ~[A], f: A => Boolean): Opt[A] =
    var o = x.read_?
    var b = true
    while(b && o.nonEmpty)
      if(f(o.cast[A])) b = false
      else o = x.read_?
    o

  def position_Opt[A](x: ~[A], f: A => Boolean): Int.Opt =
    var r : Int.Opt = \/
    var o = x.read_?
    var i = 0
    while(r.isEmpty && o.nonEmpty)
      if(f(o.cast[A])) r = i
      else             o = x.read_?
      i += 1
    r


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
