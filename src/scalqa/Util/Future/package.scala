package scalqa; package Util

import scala.concurrent.ExecutionContext

package object Future {
  private[scalqa] def This = this

  def apply[A](calculation: => A)(implicit e: ExecutionContext = DEFAULT): Future[A] = make(calculation)

  def make[A](calculation: => A)(implicit e: ExecutionContext = DEFAULT): Future[A] = {
    val p: Promise[A] = NEW
    e.execute(new Runnable { def run = p.complete(calculation) })
    p.future
  }

  def completed[A](value: A): Future[A] = new Z.A.Completed(value)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def apply[ -> 'get' overload
 *
 *     Same as 'get' for shorter expression where applicable
 *
 * @def make[ -> By implied function
 *
 *   Creates [[Future]] value with given `calculation`
 *
 *   {{{
 *     val c = Future(2 + 2)
 *
 *     c.onComplete( _ lp)  // Prints Out(4)
 *   }}}
 *
 *   @param e executor to run `calculation` with
 *
 * @def completed -> Already completed calculation
 *
 *    Creates already completed calculation [[Future]] with set result
 *
 */
