package scalqa; package Numeric

class _library[VALUE] private[Numeric] (protected val This: Numeric) extends AnyVal {

  def <(v: Short) = This.toShort < v
  def >(v: Short) = This.toShort > v
  def <=(v: Short) = This.toShort <= v
  def >=(v: Short) = This.toShort >= v
  def ==(v: Short) = This.toShort == v
  def !=(v: Short) = This.toShort != v

  def <(v: Int) = This.toInt < v
  def >(v: Int) = This.toInt > v
  def <=(v: Int) = This.toInt <= v
  def >=(v: Int) = This.toInt >= v
  def ==(v: Int) = This.toInt == v
  def !=(v: Int) = This.toInt != v

  def <(v: Long) = This.toLong < v
  def >(v: Long) = This.toLong > v
  def <=(v: Long) = This.toLong <= v
  def >=(v: Long) = This.toLong >= v
  def ==(v: Long) = This.toLong == v
  def !=(v: Long) = This.toLong != v

  def <(v: Double) = This.toDouble < v
  def >(v: Double) = This.toDouble > v
  def <=(v: Double) = This.toDouble <= v
  def >=(v: Double) = This.toDouble >= v
  def ==(v: Double) = This.toDouble == v
  def !=(v: Double) = This.toDouble != v

  def <(v: Float) = This.toFloat < v
  def >(v: Float) = This.toFloat > v
  def <=(v: Float) = This.toFloat <= v
  def >=(v: Float) = This.toFloat >= v
  def ==(v: Float) = This.toFloat == v
  def !=(v: Float) = This.toFloat != v
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
