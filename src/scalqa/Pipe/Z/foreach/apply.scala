package scalqa; package Pipe; package Z; package foreach

private[Pipe] object apply {

  def apply[A](src: Flow[A], f: A => Any): Unit = src match {
    case a: Pipe[A] => a.pumpOpt(v => { f(v); false })
    case l          => src.synchronize.apply(f)
  }

  def idx[A](src: Flow[A], f: (Int, A) => Any, start: Int = 0): Unit = {
    var i = start;
    src.synchronize.apply(v => { f(i, v); i += 1 })
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/