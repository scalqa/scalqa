package scalqa; package Custom; package Short

class _library private[scalqa] (protected val real: Short) extends AnyVal {

  def isVoid = real == 0

  def allUp: ~[Short] = new Z.stream.Up(real)

  def allDown: ~[Short] = new Z.stream.Down(real)

  def Number: java.lang.Short = java.lang.Short.valueOf(real)

  def <>(that: Short): Range[Short] = new Z.Range(real, false, that, false)
  def <>>(that: Short): Range[Short] = new Z.Range(real, false, that, true)
  def <<>(that: Short): Range[Short] = new Z.Range(real, true, that, false)
  def <<>>(that: Short): Range[Short] = new Z.Range(real, true, that, true)
  def <>+(size: Int): Range[Short] = new Z.Range(real, false, real + size toShort, false)
  def <>>+(size: Int): Range[Short] = new Z.Range(real, false, real + size toShort, true)
  def <>! : Range[Short] = new Z.Range(real, false, real, false)
  def <>>! : Range[Short] = new Z.Range(real, false, real, true)
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
 *   Creates a stream of elements from `this` to Short.MaxValue
 *   {{{ (0: Short).allUp.count.lp // Prints: 32768 }}}
 *
 * @def allDown -> Down stream
 *
 *   Creates a stream of elements from `this` to Short.MinValue
 *   {{{ (0: Short).allDown.count.lp // Prints: 32769 }}} *
 */
