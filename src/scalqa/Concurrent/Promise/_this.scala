package scalqa; package Concurrent; package Promise

trait _this[A] {

  def complete(v: Opt.orError[A]): Boolean

  def completeTry(expression: => Opt.orError[A]): Boolean = complete(try { expression } catch { case t: Throwable => Opt.orError.getError(t) })

  def fulfill(v: A): Boolean = complete(Opt.orError.get(v))

  def fulfillTry(expression: => A): Boolean = complete(Opt.orError.get(expression))

  def fail(t: Throwable): Boolean = complete(t)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def complete( -> Complete calculation
 *
 *    Sets the [[Concurrent]] calculation result
 *
 *    If the result is set once, consequent attempts will not succeed
 *
 *    Returns ''true'' if the result was successfully set
 *
 * @def completeTry -> Try complete calculation
 *
 *    Same as complete, except given ''expression'' is evaluated within try{} block, with errors producing failed result
 *
 * @def fulfill( -> Fulfill promise
 *
 *    Sets the [[Concurrent]] calculation result with value
 *
 *    If the result is set once, consequent attempts will not succeed
 *
 *    Returns ''true'' if the result was successfully set
 *
 * @def fulfillTry -> Try fulfill promise
 *
 *    Same as fulfill, except given ''expression'' is evaluated within try{} block, with errors producing failed result
 *
 * @def fail( -> Fail promise
 *
 *    Sets the [[Concurrent]] calculation result with failure
 *
 *    If the result is set once, consequent attempts will not succeed
 *
 *    Returns ''true'' if the result was successfully set
 */
