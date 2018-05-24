package scalqa; package Any; package Value; package Float

trait _Trait extends Any with Value with Sorting.Itself {
  protected type THIS <: Float
  protected type VALUE = scala.Float

  protected def sortingPositionTo(that: THIS) = Sorting.Position.get(this.value, that.value)

  protected def real: scala.Float
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
 * @trait _Trait -> '''Float Value'''
 *
 *   Generic ''Float Value''
 *
 *   @example
 *   {{{
 *     class MyFloat private (protected val real: Float) extends AnyVal with Any.Value.Float[MyFloat] {
 *        protected def companion = MyFloat
 *
 *     }
 *
 *     object MyFloat extends Any.Value.Float.Companion[MyFloat] {
 *
 *       def get(v: Float) = new MyFloat(v)
 *
 *     }
 *  }}}
 */
