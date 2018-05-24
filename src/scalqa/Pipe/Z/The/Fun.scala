package scalqa; package Pipe; package Z; package The

private[scalqa] class Fun[A](f: => Opt[A]) extends Pipe.The.Base[A] {

  override def pumpOpt(lf: A => Boolean): Opt[A] = {
    var o = f
    while (o && !o.let(lf)) o = f
    o
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/