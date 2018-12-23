package scalqa; package Fx; package Chart; package Axis; package A; package Numeric

class Span[A] private[Numeric] (val start: A, val end: A, val unit: Double, val format: String, private[Numeric] val scale: Double) extends Any.Able.ToInfo {
  def this(start: A, end: A, unit: Double, format: String) = this(start, end, unit, format, 0)

  def map[B](m: A => B) = new Span[B](m(start), m(end), unit, format, scale)

  def newUnit(u: Double) = new Span[A](start, end, u, format, scale)

  def isSingularity = start == end

  def toInfo = new Pro.Info(this) += (("start", start)) += (("end", end)) += (("unit", unit)) += (("format", format)) += (("scale", scale)) += (("class", start.getClass))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
