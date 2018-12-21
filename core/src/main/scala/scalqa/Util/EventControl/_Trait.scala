package scalqa; package Util; package EventControl

trait _Trait {

  def cancel: Boolean

  def isCancelled: Boolean

  def onCancel(b: () => Any): EventControl

  def onCancelRun(f: => Any): EventControl = onCancel(() => f)

  def cancelIf(b: () => Boolean): EventControl

  def cancelIfTrue(b: => Boolean): EventControl = cancelIf(() => b)

  def cancelIfFalse(b: => Boolean): EventControl = cancelIf(() => !b)

  def expireIn(tl: Duration): EventControl = { val t = Time.now + tl; cancelIf(() => Time.now > t) }

  def limitRunsTo(maxRunCount: Int): EventControl = if (maxRunCount <= 0) { cancel; this } else { var c = 0; cancelIf(() => maxRunCount < { c += 1; c }) }

}

object _Trait extends Util.Void.Setup[EventControl](Z.Void)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *    [[EventControl]] allows to cancel the event job directly or conditionally
 *
 *    {{{
 *       val timer: Pro.O[Time] = Time.currentPro(1.Second)                   // Value changes every 1 second
 *
 *       val ec1: EventControl = timer.onValueChange("1: " + _.subSeconds lp) // Prints seconds within minute
 *       val ec2: EventControl = timer.onValueChange("2: " + _.subSeconds lp) // Prints seconds within minute
 *       val ec3: EventControl = timer.onValueChange("3: " + _.subSeconds lp) // Prints seconds within minute
 *
 *       ec1.limitRunsTo(2)
 *       ec2.cancelIfTrue(ec1.isCancelled)
 *       ec2.onCancelRun(ec3.cancel)
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
 *    Returns `this`
 *
 * @def onCancelRun -> Run on cancel
 *
 *    Executes given implied function when the job is cancelled
 *
 *    Returns `this`
 *
 * @def cancelIf( -> Conditional cancel
 *
 *    The given function will be checked before each controlled job execution and if positive, the job will be canceled
 *
 *    Returns `this`
 *
 * @def cancelIfTrue( -> Conditional cancel
 *
 *    The given implied function will be checked before each controlled job execution and if positive, the job will be canceled
 *
 *    Returns `this`
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
 *    Each controlled job execution will be counted, and if `maxRunCount` exceeded, the job will be canceled
 *
 */
