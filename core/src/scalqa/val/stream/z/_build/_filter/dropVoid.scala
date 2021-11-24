package scalqa; package `val`; package stream; package z; package _build; package _filter; import scala.language.implicitConversions

class dropVoid[A :Any.Def.Void](x: Stream[A]) extends z.x.Pipe[A](x):

  def readOpt =
    var o = x.readOpt
    while (o)
      if(o.cast[A].self.nonVoid) return o
      o = x.readOpt
    \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
