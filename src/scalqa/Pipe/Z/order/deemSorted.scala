package scalqa; package Pipe; package Z; package order

private[Pipe] class deemSorted[A](val real: Pipe[A], override val sortingOpt: Opt[Sorting[A]]) extends The.Build[A] {

  def pumpOpt(f: A => Boolean) = real.pumpOpt(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/