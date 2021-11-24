package scalqa; package `val`; package stream; package z; package _build; package _filter

class takeIndexed[A](x: Stream[A], f: (Int, A) => Boolean, start: Int) extends z.x.Pipe[A](x):
  private var i = start

  def readOpt =
    var o = x.readOpt
    while (o && !f(i, o.get)) { o = x.readOpt; i += 1 }
    o

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
