package scalqa; package Concurrent; package Z; package The

private[Concurrent] object Void extends Concurrent[Nothing] with Void {

  override val resultOpt = \/

  override def onResult(f: Opt.orError[Nothing] => Any)(implicit e: Executor) = this

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/