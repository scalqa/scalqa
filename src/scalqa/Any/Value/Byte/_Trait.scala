package scalqa; package Any; package Value; package Byte

trait _Trait extends Any with Value with Sorting.Itself {
  protected type THIS <: Byte
  protected type VALUE = scala.Byte

  protected def sortingPositionTo(that: THIS) = Sorting.Position.get(this.value, that.value)

  protected def real: scala.Byte
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
 * @trait _Trait -> '''Byte Value'''
 *
 *   Generic ''Byte Value''
 *
 *   @example
 *   {{{
 *     class MyByte private (protected val real: Byte) extends AnyVal with Any.Value.Byte[MyByte] {
 *        protected def companion = MyByte
 *
 *     }
 *
 *     object MyByte extends Any.Value.Byte.Companion[MyByte] {
 *
 *       def get(v: Byte) = new MyByte(v)
 *
 *     }
 *  }}}
 */
