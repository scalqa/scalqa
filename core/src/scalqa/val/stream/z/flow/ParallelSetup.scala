package scalqa; package `val`; package stream; package z; package flow

private[scalqa] object ParallelSetup extends ((Stream[Any], Opt[(J.Vm.Priority, Int)]) => Flow[Any]):

  def apply(x: Stream[Any], customPoolOpt: Opt[(J.Vm.Priority,Int)]): Flow[Any] =
    val js = new JavaStreamParallelFlow(x)
    customPoolOpt.map(t => new CustomThreadPoolParallelFlow(t._1, t._2, js)) or js

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/