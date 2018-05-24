package scalqa; package Numeric

trait Companion[TYPE, VALUE] {

  def map: BiMap[VALUE, TYPE]

  protected def void: TYPE

  protected def math: Math[VALUE]

  private[scalqa] def _void = void
  private[scalqa] def _math = math
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Companion ->
 *
 *   Companion object type required to be implemented for each new [[Numeric]] type
 *
 */
