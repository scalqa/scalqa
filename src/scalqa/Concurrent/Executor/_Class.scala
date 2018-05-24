package scalqa; package Concurrent; package Executor

class _Class private[Executor] (val real: java.util.concurrent.Executor) extends AnyVal with Able.Void {

  def execute(command: Runnable): Unit = real.execute(command)

  protected override def isVoid = real == JavaVoid

}

object _Class extends Able.Void.Companion[Executor](get(JavaVoid)) {

  import scala.language.implicitConversions

  implicit def zzGet(e: java.util.concurrent.Executor): Executor = get(e)

}

private[scalqa] object JavaVoid extends java.util.concurrent.Executor {

  def execute(v: Runnable) = App.Pro.DefaultExecutor().execute(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *   The [[Concurrent.Executor]] is a wrapper around ''java.util.concurrent.Executor''
 *
 *   Void [[Concurrent.Executor]] always passes execution to the [[App.Pro.DefaultExecutor]]
 *
 *   @param real the wrapped Java peer
 *
 * @def execute(command ->   Executes the given command
 *
 *    Executes the given command at some time in the future
 *
 *    The command may execute in a new thread, in a pooled thread, or in the calling thread, at the discretion of the Executor implementation
 */
