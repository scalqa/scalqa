package scalqa; package Any; package Value; package Char

trait _Trait extends Any with Value with Sorting.Itself {
  protected type THIS <: Char
  protected type VALUE = scala.Char

  protected def sortingPositionTo(that: THIS) = Sorting.Position.get(this.value, that.value)

  protected def real: scala.Char
  protected def companion: Companion[THIS]

  private[scalqa] override def kin = companion
  private[scalqa] def _real = real
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Char Value'''
 *
 *   Generic ''Char Value''
 *
 *   @example
 *   {{{
 *     class MyChar private (protected val real: Char) extends AnyVal with Any.Value.Char[MyChar] {
 *        protected def companion = MyChar
 *
 *     }
 *
 *     object MyChar extends Any.Value.Char.Companion[MyChar] {
 *
 *       def get(v: Char) = new MyChar(v)
 *
 *     }
 *  }}}
 */
