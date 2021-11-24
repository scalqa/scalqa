package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class dropFirst[A](x: Stream[A], sz: Int) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private var i   = if (sz < 0) 0 else sz
  def readOpt     = { while (i > 0 && x.readOpt.nonEmpty) i -= 1; x.readOpt}
  def sizeLongOpt = x.sizeLongOpt.map(v => (v - i) max 0)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
