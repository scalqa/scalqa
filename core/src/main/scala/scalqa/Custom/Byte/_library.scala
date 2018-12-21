package scalqa; package Custom; package Byte

class _library private[scalqa] (private val real: Byte) extends AnyVal {

  def allUp: ~[Byte] = new Z.stream.Up(real)

  def allDown: ~[Byte] = new Z.stream.Down(real)

  def Number: java.lang.Byte = java.lang.Byte.valueOf(real)

  def %@(v: Double) = Percent.make(real.toDouble / v * 100)
  def apply(p: Percent): Int = real * p.toDouble / 100 toByte
  def +(v: Percent): Int = real + apply(v) toByte
  def -(v: Percent): Int = real - apply(v) toByte

  def <>(that: Byte): Range[Byte] = new Z.Range(real, false, that, false)
  def <>>(that: Byte): Range[Byte] = new Z.Range(real, false, that, true)
  def <<>(that: Byte): Range[Byte] = new Z.Range(real, true, that, false)
  def <<>>(that: Byte): Range[Byte] = new Z.Range(real, true, that, true)
  def <>+(size: Int): Range[Byte] = new Z.Range(real, false, real + size toByte, false)
  def <>>+(size: Int): Range[Byte] = new Z.Range(real, false, real + size toByte, true)
  def <>! : Range[Byte] = new Z.Range(real, false, real, false)
  def <>>! : Range[Byte] = new Z.Range(real, false, real, true)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def allUp -> Up stream
 *
 *   Creates a stream of elements from `this` to Byte.MaxValue
 *   {{{ 0.toByte.allUp.count lp // Prints: 128 }}}
 *
 * @def allDown -> Down stream
 *
 *   Creates a stream of elements from `this` to Byte.MinValue
 *   {{{ 0.toByte.allDown.count lp // Prints: 129 }}} *
 */
