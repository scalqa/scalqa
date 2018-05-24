package scalqa; package Any; package Value; package Double

trait _Trait extends Any with Value with Sorting.Itself {
  protected type THIS <: Double
  protected type VALUE = scala.Double

  protected def sortingPositionTo(that: THIS) = Sorting.Position.get(this.value, that.value)

  protected def real: scala.Double
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
 * @trait _Trait -> '''Double Value'''
 *
 *   Generic ''Double Value''
 *
 *   @example
 *   {{{
 *     class MyDouble private (protected val real: Double) extends AnyVal with Any.Value.Double[MyDouble] {
 *        protected def companion = MyDouble
 *
 *     }
 *
 *     object MyDouble extends Any.Value.Double.Companion[MyDouble] {
 *
 *       def get(v: Double) = new MyDouble(v)
 *
 *     }
 *  }}}
 */
