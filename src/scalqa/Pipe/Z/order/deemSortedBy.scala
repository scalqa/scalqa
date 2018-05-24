package scalqa; package Pipe; package Z; package order

private[Pipe] class deemSortedBy[A, B] private (p: Pipe[A], s: Sorting[A], tpl: Opt[(Sorting[B], A => B)]) extends deemSorted(p, s) {
  def this(p: Pipe[A], s: Sorting[B], f: A => B) = this(p, s.asMap(f), (s, f))

  override def sortingByOpt[C] = tpl.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/