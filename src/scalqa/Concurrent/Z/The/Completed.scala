package scalqa; package Concurrent; package Z; package The

private[Concurrent] class Completed[A](v: A) extends Concurrent[A] {

  override val resultOpt = Opt.orError.get(v)

  override def onResult(f: Opt.orError[A] => Any)(implicit e: Executor) = { f(resultOpt.value); this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/