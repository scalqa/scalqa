package scalqa; package Pipe; package Z; package flow

private[scalqa] object parallel {

  def apply[A](p: Pipe[A], groupSize: Int): Flow[A] = App.Pro.PipeParallelFactory().apply(p, groupSize).cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/