package scalqa; package Fx

package object Chart {
  type Axis[A] = Axis._Class[A]
  type XY[X, Z] = XY._Class[X, Z]

  private[Chart]type JNumber = java.lang.Number

  private[Chart] object JNumber {

    def make(v: Double): JNumber = new A.Double(v)

    def make(v: Float): JNumber = new A.Float(v)

    def make(v: Long): JNumber = new A.Long(v)

    def make(v: Int): JNumber = new A.Int(v)

    val Ordering: Ordering[JNumber] = math.Ordering.Double.on(_.doubleValue)

    // ***************************************************
    private object A {
      class Double(val doubleValue: scala.Double) extends JNumber { def floatValue = doubleValue.toFloat; def intValue = doubleValue.toInt; def longValue = doubleValue.toLong }
      class Float(val floatValue: scala.Float) extends JNumber { def doubleValue = floatValue.toDouble; def intValue = floatValue.toInt; def longValue = floatValue.toLong }
      class Long(val longValue: scala.Long) extends JNumber { def doubleValue = longValue.toDouble; def floatValue = longValue.toFloat; def intValue = longValue.toInt }
      class Int(val intValue: scala.Int) extends JNumber { def doubleValue = intValue.toDouble; def floatValue = intValue.toFloat; def longValue = intValue.toLong }
    }

    implicit def zzMake(v: Double): JNumber = make(v)

    implicit def zzDouble(v: JNumber) = v.doubleValue
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
