package scalqa; package Any; package Value; package Long

trait _Trait extends Any with Value with Sorting.Itself {
  protected type THIS <: Long
  protected type VALUE = scala.Long

  protected def sortingPositionTo(that: THIS) = Sorting.Position.get(this.value, that.value)

  protected def real: scala.Long
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
 * @trait _Trait -> '''Long Value'''
 *
 *   Generic ''Long Value''
 *
 *   @example
 *   {{{
 *     class MyLong private (protected val real: Long) extends AnyVal with Any.Value.Long[MyLong] {
 *        protected def companion = MyLong
 *
 *     }
 *
 *     object MyLong extends Any.Value.Long.Companion[MyLong] {
 *
 *       def get(v: Long) = new MyLong(v)
 *
 *     }
 *  }}}
 */
