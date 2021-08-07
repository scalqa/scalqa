package scalqa; package `val`; package stream; package z; package _build; package _filter

class dropWhile[A](x: ~[A], f: A => Boolean) extends a.Pipe[A](x):
  private var b = true

  @tn("read_Opt") def read_? =
    var o = x.read_?
    while(b && o.nonEmpty){ if(!f(o.cast[A])){ b=false; return o}; o = x.read_? }
    o

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
