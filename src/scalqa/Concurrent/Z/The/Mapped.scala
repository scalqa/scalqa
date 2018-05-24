package scalqa; package Concurrent; package Z; package The

private[Concurrent] class Mapped[A, B](real: Concurrent[A], f: Opt.orError[A] => Opt.orError[B]) extends Concurrent[B] {

  def resultOpt = real.resultOpt.map(f)

  def onResult(on: Opt.orError[B] => Any)(implicit e: Executor) = { real.onResult(r => on(Opt.orError.getTryCatch(f(r)))); this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/