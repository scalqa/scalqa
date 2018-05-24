package scalqa; package Any; package Value; package Short

trait _Trait extends Any with Value with Sorting.Itself {
  protected type THIS <: Short
  protected type VALUE = scala.Short

  protected def sortingPositionTo(that: THIS) = Sorting.Position.get(this.value, that.value)

  protected def real: scala.Short
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
 * @trait _Trait -> '''Short Value'''
 *
 *   Generic ''Short Value''
 *
 *   @example
 *   {{{
 *     class MyShort private (protected val real: Short) extends AnyVal with Any.Value.Short[MyShort] {
 *        protected def companion = MyShort
 *
 *     }
 *
 *     object MyShort extends Any.Value.Short.Companion[MyShort] {
 *
 *       def get(v: Short) = new MyShort(v)
 *
 *     }
 *  }}}
 */
