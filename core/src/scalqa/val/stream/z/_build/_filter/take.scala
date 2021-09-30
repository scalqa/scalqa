package scalqa; package `val`; package stream; package z; package _build; package _filter; import scala.language.implicitConversions

class take[A](x: ~[A], f: A => Boolean) extends z.x.Pipe[A](x):

  @tn("read_Opt") def read_? =
    var o = x.read_?
    while (o)
      if(f(o.cast[A])) return o
      o = x.read_?
    \/


object take:
  inline def HEAVY[A](inline x: ~[A], inline f: A => Boolean): ~[A] =
    class TAKE(x: ~[A]) extends z.x.Pipe[A](x):
      @tn("read_Opt")
      def read_? =
        var o=x.read_?
        while(o)
          if(f(o.cast[A])) return o
          o=x.read_?
        o
    new TAKE(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
