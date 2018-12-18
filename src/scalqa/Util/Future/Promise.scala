package scalqa; package Util; package Future

trait Promise[A] {

  def future: Future[A]

  def complete(v: Out[A]): Boolean

  def tryComplete(expression: => Out[A]): Boolean = complete(try { expression } catch { case t: Throwable => Deficiency.apply(t) })

}

object Promise {

  def make[T]: Promise[T] = new Z.Control[T]

  implicit def zzMake[T](v: NEW.type) = make[T]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Promise ->
 *
 *   [[Promise]] provides [[Future]] and methods to complete it
 *
 * @def future -> [[Future]] under control of this [[Future]]
 *
 *     [[Future]] is given to application logic, which will wait for [[Future]] completion through 'onComplete' event
 *
 * @def complete( -> Complete calculation
 *
 *    Sets the [[Future]] calculation outcome
 *
 *    If the outcome is set once, consequent attempts will not succeed
 *
 *    Returns `true` if the result was successfully set
 *
 * @def tryComplete -> Try complete calculation
 *
 *    Same as complete, except given `expression` is evaluated within try{}catch{} block, with errors producing failed outcome
 *
 * @object Promise ->
 *
 *     Canonical way to create a promise is to use universal NEW
 *
 *     {{{
 *         val p: Future[Int] = NEW
 *     }}}
 */
