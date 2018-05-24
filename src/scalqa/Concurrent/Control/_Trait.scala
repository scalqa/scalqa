package scalqa; package Concurrent; package Control

trait _Trait {

  def cancel: Boolean

  def isCancelled: Boolean

  def onCancel(b: () => Any): Control

  def onCancelRun(f: => Any): Control = onCancel(() => f)

  def cancelIf(b: () => Boolean): Control

  def cancelIfTrue(b: => Boolean): Control = cancelIf(() => b)

  def cancelIfFalse(b: => Boolean): Control = cancelIf(() => !b)

  def expireIn(tl: Time.Length): Control = { val t = Time.get + tl; cancelIf(() => Time.get > t) }

  def limitRunsTo(maxRunCount: Int): Control = if (maxRunCount <= 0) { cancel; this } else { var c = 0; cancelIf(() => maxRunCount < { c += 1; c }) }

}

object _Trait extends Able.Void.Companion[Control](Z.Void)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *    [[Concurrent.Control]] is an interface to cancel a job attached to some event or scheduled
 *
 *    [[Concurrent.Control]] allows to cancel the job immediately or conditionally
 *
 *    {{{
 *       val timer = Time.currentPro(1.Second)
 *
 *       val cc1: Concurrent.Control = timer.onValueChange(_.subSeconds lp "1: ")
 *       val cc2: Concurrent.Control = timer.onValueChange(_.subSeconds lp "2: ")
 *       val cc3: Concurrent.Control = timer.onValueChange(_.subSeconds lp "3: ")
 *
 *       cc1.limitRunsTo(2)
 *       cc2.cancelIf(cc1.isCancelled)
 *       cc2.onCancelRun(cc3.cancel)
 *
 *       // Output
 *       3: 20 secs
 *       2: 20 secs
 *       1: 20 secs
 *       3: 21 secs
 *       2: 21 secs
 *       1: 21 secs
 *       3: 22 secs
 *       2: 22 secs
 *       3: 23 secs
 *    }}}
 *
 * @def cancel: -> Cancel
 *
 *    Cancels the controlled job, so it will never execute again
 *
 *    Returns 'true' if the job was cancelled, 'false' if it was already cancelled
 *
 * @def isCancelled -> Canceled check
 *
 *    Returns 'true' if the controlled job is cancelled
 *
 * @def onCancel( -> On cancelled event
 *
 *    Executes given function when the job is cancelled
 *
 *    Returns ''this''
 *
 * @def onCancelRun -> Run on cancel
 *
 *    Executes given implied function when the job is cancelled
 *
 *    Returns ''this''
 *
 * @def cancelIf( -> Conditional cancel
 *
 *    The given function will be checked before each controlled job execution and if positive, the job will be canceled
 *
 *    Returns ''this''
 *
 * @def cancelIfTrue( -> Conditional cancel
 *
 *    The given implied function will be checked before each controlled job execution and if positive, the job will be canceled
 *
 *    Returns ''this''
 * *
 * @def cancelIfFalse -> Reverse conditional cancel
 *
 *    The given function will be checked before each controlled job execution and if negative, the job will be canceled
 *
 * @def expireIn -> Timed cancel
 *
 *    The time will be checked before each controlled job execution and if expired, the job will be canceled
 *
 * @def limitRunsTo -> Counter cancel
 *
 *    Each controlled job execution will be counted, and if ''maxRunCount'' exceeded, the job will be canceled
 *
 */
