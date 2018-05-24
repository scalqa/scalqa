package scalqa; package Any; package Value; package Int

trait _Trait extends Any with Value with Sorting.Itself {
  protected type THIS <: Int
  protected type VALUE = scala.Int

  protected def sortingPositionTo(that: THIS) = Sorting.Position.get(this.value, that.value)

  protected def real: scala.Int
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
 * @trait _Trait -> '''Int Value'''
 *
 *   Generic ''Int Value''
 *
 *   @example
 *   {{{
 *     class MyInt private (protected val real: Int) extends AnyVal with Any.Value.Int[MyInt] {
 *        protected def companion = MyInt
 *
 *     }
 *
 *     object MyInt extends Any.Value.Int.Companion[MyInt] {
 *
 *       def get(v: Int) = new MyInt(v)
 *
 *     }
 *  }}}
 */
