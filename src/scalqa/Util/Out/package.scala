package scalqa; package Util

package object Out {
  private[scalqa] def This = this

  def apply[A](v: A) = new Out[A](v)

  def apply[A](d: Deficiency) = new Out[A](d)

  def make[A](v: A) = new Out[A](v)

  def make[A](v: Deficiency) = new Out[A](v)

  def withTry[A](v: => A): Out[A] = try { apply(v) } catch { case t: Throwable => apply(Deficiency.apply(t)) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def apply[A](v -> 'make' overload
 *
 *     Same as 'make' for shorter expression where applicable
 *
 * @def apply[A](d -> 'make' overload
 *
 *     Same as 'make' for shorter expression where applicable
 *
 */
