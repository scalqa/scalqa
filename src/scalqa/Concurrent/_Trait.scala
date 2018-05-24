package scalqa; package Concurrent

trait _Trait[+A] {

  def resultOpt: Opt[Opt.orError[A]]

  def onResult(f: Opt.orError[A] => Any)(implicit e: Executor = \/): this.type

  def valueOpt: Opt[A] = resultOpt.letMap(_.valueOpt)

  def onValue(f: A => Any)(implicit e: Executor = \/): this.type = onResult(_(f))

  def failOpt: Opt[Throwable] = resultOpt.letMap(_.failOpt)

  def onFailure(f: Throwable => Any)(implicit e: Executor = \/): this.type = onResult(_.failOpt(f))

}

object _Trait extends Able.Void.Companion.Typed[Concurrent](Z.The.Void) {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: Concurrent[A]) = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Concurrent Future Value'''
 *
 *   [[Concurrent]] can also be called [[https://en.wikipedia.org/wiki/Futures_and_promises Future]]
 *
 *   [[Concurrent]] represents value which will be available 'at some point of time', but it can already be incorporated in current calculations
 *
 *   {{{
 *       val s = "Hello"
 *
 *       val c: Concurrent[String] = Concurrent.get { Pause(1.Second);  s + " Concurrent Future!" }
 *
 *       c.valueOpt lp     // Value is not available yet
 *       c.onValue(_ lp)   // Will run when value is available
 *
 *       // Output
 *       Opt.Void
 *       Hello Concurrent Future!
 *    }}}
 *
 *    Most of the [[Concurrent]] methods take parameter '' 'implicit e: Concurrent.Executor = \/' '' to run the computation
 *
 *    The void [[Executor]] will pass actions to the one defined in [[App.Pro.DefaultExecutor]]
 *
 *    However if there is locally defined [[Executor]], it will take over
 *
 *    {{{
 *       // Define implicit custom executor
 *       implicit val custom = new Concurrent.Executor {
 *           val pool = new java.util.concurrent.ScheduledThreadPoolExecutor(4)
 *
 *           def execute(r: Runnable) { Print("Run "); pool.execute(r) }
 *       }
 *
 *       Concurrent.get(3 * 3).onValue(Print)  // Prints: Run Run 9
 *
 *       // Note: 'custom' executor was invoked twice, first to
 *       //       calculate value and second to process the event
 *
 *       Schedule.onceIn(1.Second, App.exit) // Does not exit by default
 *    }}}
 * @def resultOpt -> Result if available
 *
 *     Returns calculation result if it is available
 *
 *     {{{
 *         val c = Concurrent.get { Pause(1.Second); 2 * 2 }
 *
 *         c.resultOpt lp    // Prints: Opt.Void
 *
 *         Pause(2.Seconds)
 *
 *         c.resultOpt lp    // Will most likely print: Opt(Opt(4))
 *     }}}
 *
 * @def onResult -> Run on result
 *
 *     Will run the given function, when the result will get available
 *
 *     {{{
 *       val c = Concurrent.get { Pause(1.Second); 2 * 2 }
 *
 *       c.onResult(Print) // Prints in 1 second: Opt(4)
 *
 *       c.resultOpt lp    // Prints immediately: Opt.Void
 *     }}}
 *
 * @def valueOpt -> Value if available
 *
 *     Returns value if the calculation has already succeeded
 *
 *     Note. If the calculation fails, the value will never get available
 *
 *     {{{
 *       val c = Concurrent.get { Pause(1.Second); 2 * 2 }
 *
 *       c.valueOpt lp     // Prints: Opt.Void
 *
 *       Pause(2.Seconds)
 *
 *       c.valueOpt lp     // Will most likely print: Opt(4)
 *     }}}
 *
 * @def onValue -> Run on value
 *
 *     Will run the given function, when the value will get available
 *
 *     Note. If the calculation fails, the function will never run
 *
 *     {{{
 *       val c = Concurrent.get { Pause(1.Second); 2 * 2 }
 *
 *       c.onValue(Print)  // Prints in 1 second: 4
 *
 *       c.valueOpt lp     // Prints immediately: Opt.Void
 *     }}}
 *
 * @def failOpt -> Failure if available
 *
 *     Returns failure if the calculation has already failed
 *
 *     Note. If the calculation succeeds, the failure will never get available
 *
 *     {{{
 *       val c = Concurrent.get { Pause(1.Second); 2 / 0 }
 *
 *       c.failOpt lp     // Prints: Opt.Void
 *
 *       Pause(2.Seconds)
 *
 *       c.failOpt lp     // Will most likely print: Opt(java.lang.ArithmeticException: / by zero)
 *     }}}
 *
 * @def onFailure -> Run on failure
 *
 *     Will run the given function, when the calculation fails
 *
 *     Note. If the calculation succeeds, the function will never run
 *
 *     {{{
 *       val c = Concurrent.get { Pause(1.Second); 2 / 0 }
 *
 *       c.onFailure(Print)   // Prints in 1 second: java.lang.ArithmeticException: / by zero
 *
 *       c.failOpt lp         // Prints immediately: Opt.Void
 *     }}}
 *
 */
