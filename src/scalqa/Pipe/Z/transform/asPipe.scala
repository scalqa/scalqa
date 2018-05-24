package scalqa; package Pipe; package Z; package transform

private[scalqa] class asPipe[A](src: ~[A]) extends Pipe.The.Base[A] {

  def pumpOpt(lf: A => Boolean) = {
    var o = Interface._Trait.supplyOpt(src)
    while (o && !lf(o.value)) o = Interface._Trait.supplyOpt(src)
    o
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/