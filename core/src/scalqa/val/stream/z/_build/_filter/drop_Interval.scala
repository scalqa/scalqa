package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class drop_Interval[A](x: Stream[A], in: Int.Range) extends z.x.Pipe[A](x):
  private var i = 0

  def readOpt =
    var o = x.readOpt
    while (in.contains(i) && o) { i += 1; o = x.readOpt }
    i += 1
    o

  override def doc = super.doc +@= (0, "", in)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
