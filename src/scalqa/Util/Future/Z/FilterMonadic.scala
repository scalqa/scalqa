package scalqa; package Util; package Future; package Z

import concurrent.ExecutionContext
import scala.util.control.NonFatal

private[Future] final class FilterMonadic[A] private[scalqa] (private val future: Util.Future[A]) extends AnyVal {

  def foreach(f: A => Unit)(implicit e: ExecutionContext = DEFAULT): Unit = future.onComplete(_(f))

  @inline def flatMap[B](m: A => Future[B])(implicit e: ExecutionContext = DEFAULT): Util.Future[B] = _Trait.flatMap(future, m)

  def withFilter(f: A => Boolean)(implicit e: ExecutionContext = DEFAULT): Util.Future[A] =
    future.mapResult(_.letMap(v => if (f(v)) Out.make(v) else new Deficiency("For-Comprehension predicate is not satisfied")))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
