package scalqa; package Any; package Value; package Ref

trait _Trait[VAL <: AnyRef] extends Any with Value {
  protected type THIS <: Ref[VAL]
  protected type VALUE = VAL

  protected def real: VAL
  protected def companion: Companion.Like[THIS, VAL]

  private[scalqa] def _real = real
  private[scalqa] override def kin = companion
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
 * @trait _Trait -> '''AnyRef Value'''
 *
 *   Generic ''AnyRef Value''
 *
 *   @example
 *   {{{
 *     class MyString private (protected val real: String) extends AnyVal with Any.Value.Ref[MyString, String] {
 *       protected def companion = MyString
 *
 *     }
 *
 *     object MyString extends Any.Value.Ref.Companion[MyString, String] {
 *
 *       def get(v: String) = new MyString(v)
 *
 *     }
 *   }}}
 */
