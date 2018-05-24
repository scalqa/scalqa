package scalqa; package Pipe; package Z; package order

private[Pipe] class sort[A] private (l: Index[A], override val sortingOpt: Opt[Sorting[A]]) extends Pipe.The.IndexBasic[A](l) {

  def this(all: Pipe[A])(implicit o: Sorting[A]) = this(all.as[Index.W].I(_.sort(o)), o)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
