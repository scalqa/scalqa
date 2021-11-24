package scalqa; package `val`; package stream; package z; package _build; package _filter; import scala.language.implicitConversions

class drop[A](x: Stream[A], f: A => Boolean) extends z.x.Pipe[A](x):

  def readOpt =
    var o = x.readOpt
    while(o)
      if(!f(o.cast[A])) return o
      o = x.readOpt
    \/

object drop:

  inline def HEAVY[A](inline x: Stream[A], inline f: A => Boolean): Stream[A] =
    class DROP(x: Stream[A]) extends z.x.Pipe[A](x):
      def readOpt =
        var o=x.readOpt
        while(o)
          if(!f(o.cast[A])) return o
          o=x.readOpt
        o
    new DROP(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
