package scalqa; package Fx; package Application

import Util.Time.PreciseDuration

object Thread {

  def is: Boolean = javafx.application.Platform.isFxApplicationThread

  def future[A](f: => A, message: Opt[Popup] = \/)(implicit e: concurrent.ExecutionContext = DEFAULT): Future[A] = new Z.Promise(f, message).future

  def runEvery(period: PreciseDuration, f: => Any): EventControl = runEveryIn(period, period, f)

  def runEveryIn(delay: PreciseDuration, period: PreciseDuration, f: => Any): EventControl = App.runEveryIn(delay, period, run(f))

  def run(fun: => Any): Unit = if (is) fun else Executor.run(fun)

  def runIn(delay: PreciseDuration, f: => Any): EventControl = App.runIn(delay, run(f))

  // ********************************************
  object Executor extends concurrent.ExecutionContext {

    def execute(r: Runnable) = javafx.application.Platform.runLater(r)

    def reportFailure(cause: Throwable): Unit = cause.lp

    def run(v: => Any) = {
      object DelayedJob extends java.lang.Runnable { def run = v } // Better name for stackTrace
      execute(DelayedJob)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Thread ->
 *     [[Thread]] represents "FX Application Thread", the only one allowed to modify GUI controls
 *
 *   @def is -> FX Application Thread check
 *
 *     Returns `true` if current thread is "FX Application Thread"
 *
 *   @def future -> Creates FX Application Thread [[Future]]
 *
 *     The [[Future]] will be calculated with implicit executor, but onComplete event will be executed on FX Application Thread
 *
 *     `message` is an optional [[Popup]] to show during execution
 *
 *  @def run(f -> Runs function on FX Application Thread
 *
 *    If current thread is FX Application Thread, the function is run immediately
 *
 *    Otherwise it is scheduled for later
 *
 *  @def runIn -> Runs function on FX Application Thread with delay
 *
 *    Schedule the function to run once
 *
 */
