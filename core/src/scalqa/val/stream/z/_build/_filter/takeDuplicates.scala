package scalqa; package `val`; package stream; package z; package _build; package _filter; import scala.language.implicitConversions

class takeDuplicates[A](x: ~[A]) extends z.x.Pipe[A](x):
  private var lastOpt: Opt[A] = \/

  @tn("read_Opt") def read_? =
    var o = x.read_?
    while(o && !lastOpt.contains(o.`val`))
      lastOpt = o
      o = x.read_?
    o

object takeDuplicates:

  class By[A,B](x: ~[A], f: A => B) extends z.x.Pipe[A](x):
    private var lastOpt: Opt[B] = \/

    @tn("read_Opt") def read_? =
      var o = x.read_?
      while(o && !lastOpt.contains(f(o.`val`)))
        lastOpt = o.map(f)
        o = x.read_?
      o

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
