package scalqa; package Any; package Datum.Z.Number

private[scalqa] trait Compare extends Any {

  def ==(v: Byte): Boolean
  def ==(v: Short): Boolean
  def ==(v: Int): Boolean
  def ==(v: Long): Boolean
  def ==(v: Float): Boolean
  def ==(v: Double): Boolean

  def !=(v: Byte): Boolean
  def !=(v: Short): Boolean
  def !=(v: Int): Boolean
  def !=(v: Long): Boolean
  def !=(v: Float): Boolean
  def !=(v: Double): Boolean

  def <(v: Byte): Boolean
  def <(v: Short): Boolean
  def <(v: Int): Boolean
  def <(v: Long): Boolean
  def <(v: Float): Boolean
  def <(v: Double): Boolean

  def <=(v: Byte): Boolean
  def <=(v: Short): Boolean
  def <=(v: Int): Boolean
  def <=(v: Long): Boolean
  def <=(v: Float): Boolean
  def <=(v: Double): Boolean

  def >(v: Byte): Boolean
  def >(v: Short): Boolean
  def >(v: Int): Boolean
  def >(v: Long): Boolean
  def >(v: Float): Boolean
  def >(v: Double): Boolean

  def >=(v: Byte): Boolean
  def >=(v: Short): Boolean
  def >=(v: Int): Boolean
  def >=(v: Long): Boolean
  def >=(v: Float): Boolean
  def >=(v: Double): Boolean

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def >=(v: Byte) -> Is greater or equal test
 *
 *    Returns true if `this` is greater or equal to v, `false` otherwise
 *
 * @def >=(v: Short) -> Is greater or equal test
 *
 *    Returns true if `this` is greater or equal to v, `false` otherwise
 *
 * @def >=(v: Int) -> Is greater or equal test
 *
 *    Returns true if `this` is greater or equal to v, `false` otherwise
 *
 * @def >=(v: Long) -> Is greater or equal test
 *
 *    Returns true if `this` is greater or equal to v, `false` otherwise
 *
 * @def >=(v: Float) -> Is greater or equal test
 *
 *    Returns true if `this` is greater or equal to v, `false` otherwise
 *
 * @def >=(v: Double) -> Is greater or equal test
 *
 *    Returns true if `this` is greater or equal to v, `false` otherwise
 *
 * @def >(v: Byte) -> Is greater test
 *
 *    Returns true if `this` is greater than v, `false` otherwise
 *
 * @def >(v: Short) -> Is greater test
 *
 *    Returns true if `this` is greater than v, `false` otherwise
 *
 * @def >(v: Int) -> Is greater test
 *
 *    Returns true if `this` is greater than v, `false` otherwise
 *
 * @def >(v: Long) -> Is greater test
 *
 *    Returns true if `this` is greater than v, `false` otherwise
 *
 * @def >(v: Float) -> Is greater test
 *
 *    Returns true if `this` is greater than v, `false` otherwise
 *
 * @def >(v: Double) -> Is greater test
 *
 *    Returns true if `this` is greater than v, `false` otherwise
 *
 * @def <=(v: Byte) -> Is less or equal test
 *
 *    Returns true if `this` is less or equal to v, `false` otherwise
 *
 * @def <=(v: Short) -> Is less or equal test
 *
 *    Returns true if `this` is less or equal to v, `false` otherwise
 *
 * @def <=(v: Int) -> Is less or equal test
 *
 *    Returns true if `this` is less or equal to v, `false` otherwise
 *
 * @def <=(v: Long) -> Is less or equal test
 *
 *    Returns true if `this` is less or equal to v, `false` otherwise
 *
 * @def <=(v: Float) -> Is less or equal test
 *
 *    Returns true if `this` is less or equal to v, `false` otherwise
 *
 * @def <=(v: Double) -> Is less or equal test
 *
 *    Returns true if `this` is less or equal to v, `false` otherwise
 *
 * @def <(v: Byte) -> Is less test
 *
 *    Returns true if `this` is less than v, `false` otherwise
 *
 * @def <(v: Short) -> Is less test
 *
 *    Returns true if `this` is less than v, `false` otherwise
 *
 * @def <(v: Int) -> Is less test
 *
 *    Returns true if `this` is less than v, `false` otherwise
 *
 * @def <(v: Long) -> Is less test
 *
 *    Returns true if `this` is less than v, `false` otherwise
 *
 * @def <(v: Float) -> Is less test
 *
 *    Returns true if `this` is less than v, `false` otherwise
 *
 * @def <(v: Double) -> Is less test
 *
 *    Returns true if `this` is less than v, `false` otherwise
 *
 * @def ==(v: Byte) -> Equals test
 *
 *    Returns true if `this` is equal to v, `false` otherwise
 *
 * @def ==(v: Short) -> Equals test
 *
 *    Returns true if `this` is equal to v, `false` otherwise
 *
 * @def ==(v: Int) -> Equals test
 *
 *    Returns true if `this` is equal to v, `false` otherwise
 *
 * @def ==(v: Long) -> Equals test
 *
 *    Returns true if `this` is equal to v, `false` otherwise
 *
 * @def ==(v: Float) -> Equals test
 *
 *    Returns true if `this` is equal to v, `false` otherwise
 *
 * @def ==(v: Double) -> Equals test
 *
 *    Returns true if `this` is equal to v, `false` otherwise
 *
 * @def !=(v: Byte) -> Not equals test
 *
 *    Returns true if `this` is not equal to v, `false` otherwise
 *
 * @def !=(v: Short) -> Not equals test
 *
 *    Returns true if `this` is not equal to v, `false` otherwise
 *
 * @def !=(v: Int) -> Not equals test
 *
 *    Returns true if `this` is not equal to v, `false` otherwise
 *
 * @def !=(v: Long) -> Not equals test
 *
 *    Returns true if `this` is not equal to v, `false` otherwise
 *
 * @def !=(v: Float) -> Not equals test
 *
 *    Returns true if `this` is not equal to v, `false` otherwise
 *
 * @def !=(v: Double) -> Not equals test
 *
 *    Returns true if `this` is not equal to v, `false` otherwise
 *
 */
