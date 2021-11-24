package scalqa; package `val`; package stream; package z; package _build; package _filter; import scala.language.implicitConversions

class takeDuplicates[A](x: Stream[A]) extends z.x.Pipe[A](x):
  private var lastOpt: Opt[A] = \/

  def readOpt =
    var o = x.readOpt
    while(o && !lastOpt.contains(o.`val`))
      lastOpt = o
      o = x.readOpt
    o

object takeDuplicates:

  class By[A,B](x: Stream[A], f: A => B) extends z.x.Pipe[A](x):
    private var lastOpt: Opt[B] = \/

    def readOpt =
      var o = x.readOpt
      while(o && !lastOpt.contains(f(o.`val`)))
        lastOpt = o.map(f)
        o = x.readOpt
      o

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
