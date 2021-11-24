package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class takeType[B](x: Stream[Any])(implicit t: ClassTag[B]) extends z.x.Pipe[B](x):

  def readOpt =
    var o = x.readOpt
    while(o){ if(o.takeType[B]) return o.cast[Opt[B]];  o = x.readOpt }
    o.cast[Opt[B]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
