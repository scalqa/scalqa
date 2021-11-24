package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class reverseEvery[A](x: Stream[A], size: Int) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private var cur: Stream[A] = \/

  def readOpt     = cur.readOpt orOpt { cur = x.readStream(size).reverse; cur.readOpt }
  def sizeLongOpt = x.sizeLongOpt.mix(cur.sizeLongOpt, _ + _)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
