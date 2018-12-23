package scalqa; package Util; package Future

import concurrent.ExecutionContext

trait _Trait[+A] {

  def resultOpt: Opt[Out[A]]

  def onComplete(f: Out[A] => Unit)(implicit e: ExecutionContext = DEFAULT): Unit

  def map[B](f: A => B)(implicit e: ExecutionContext = DEFAULT): Future[B] = mapResult(_.map(f))

  def letMap[B](f: A => Out[B])(implicit e: ExecutionContext = DEFAULT): Future[B] = mapResult(_.letMap(f))

  def apply[B](f: A => Any, d: Deficiency => Any = \/)(implicit e: ExecutionContext = DEFAULT): Future[A] = { onComplete(_.apply(f, d)); this }

  def zip[B](f: Future[B])(implicit e: ExecutionContext = DEFAULT): Future[(A, B)] = Z.zip(this, f): @inline

  def mapResult[B](f: Out[A] => Out[B])(implicit e: concurrent.ExecutionContext): Future[B] = Z.mapResult(this, f): @inline

  def await(v: Util.Time.PreciseDuration)(implicit e: ExecutionContext = DEFAULT): Out[A] = Z.await(this, v): @inline

  protected def _flatMap[B](m: A => Future[B])(implicit e: ExecutionContext = DEFAULT): Future[B] = Z.flatMap(this, m): @inline
}

object _Trait {

  implicit def zzFilterMonadic[A](f: Future[A]): Z.FilterMonadic[A] = new Z.FilterMonadic[A](f)

  @inline private[Future] def flatMap[A, B](f: Future[A], m: A => Future[B])(implicit e: ExecutionContext): Future[B] = f._flatMap(m)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Future Value`
 *
 *   [[Future]] represents value which will be available 'at some point of time', but it can already be incorporated in current calculations
 *
 *   {{{
 *     val s = "Hello"
 *
 *     val v: Future[String] = Future(s + " Concurrent Future!")
 *
 *     v.resultOpt.lp      // Value is likely not available yet
 *
 *     v.onComplete(print) // Will run when value is available
 *
 *     // Output
 *     Opt.Void
 *     Out(Hello Concurrent Future!)
 *   }}}
 *
 * @def resultOpt -> Optional outcome
 *
 *     Returns calculation outcome if it is available
 *
 *     {{{
 *       val v = Future{ 2 * 2 }
 *
 *       v.resultOpt lp      // Likely prints: Opt.Void
 *
 *       App.pause(1.Second)
 *
 *       v.resultOpt lp      // Likely prints: Opt(Out(4))
 *     }}}
 *
 * @def onComplete -> Run when ready
 *
 *     Will run the given function, when the outcome will get available
 *
 *     {{{
 *       val v = Future{ 2 * 2 }
 *
 *       v.onComplete("onComplete: " + _ lp)
 *
 *       "Immediate Result: " + v.resultOpt lp
 *
 *       // Output
 *       Immediate Result: Opt(Out(4))
 *       onComplete: Out(4)
 *     }}}
 *
 * @def mapResult[ -> Map outcome
 *
 *    Creates a new [[Future]] value, which [[Out outcome]] is mapped from this value outcome
 *
 *    {{{
 *       val v1 = Future { 2 * 2 }
 *       val v2 = v1.map(_.validate(_ > 10, "Too Small"))
 *
 *       v1.onComplete("v1: " + _ lp)
 *       v2.onComplete("v2: " + _ lp)
 *
 *
 *       // Output
 *       v1: Out(4)
 *       v3: Out(deficiency=Too Small)
 *    }}}
 */
