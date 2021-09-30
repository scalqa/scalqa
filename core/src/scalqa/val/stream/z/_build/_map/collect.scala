package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions

class collect[A,B](x: ~[A], f: PartialFunction[A,B]) extends z.x.Pipe[B](x):
  @tn("read_Opt") def read_? =
    var o = x.read_?
    while (o)
      val v = o.cast[A]
      if(f.isDefinedAt(v)) return f(v)
      o =  x.read_?
    \/


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
