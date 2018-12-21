package scalqa; package Util

package object Deficiency {
  private[scalqa] def This = this

  def apply(message: String) = new Deficiency(message)

  def apply(t: Throwable) = new Error(t)

  def make(message: String) = new Deficiency(message)

  def make(t: Throwable) = new Error(t)

  def unapply(v: Deficiency): Option[String] = Some(v.message)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 *  @object Deficiency ->
 *
 *  @def apply(m -> 'make' overload
 *
 *       Same as 'make' for shorter expression where applicable
 *
 *  @def apply(t -> 'make' overload
 *
 *       Same as 'make' for shorter expression where applicable
 *
 */
