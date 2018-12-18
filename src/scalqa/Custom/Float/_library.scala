package scalqa; package Custom; package Float

class _library private[scalqa] (private val real: Float) extends AnyVal {

  def isVoid = real == 0F

  def %@(v: Double) = Percent.make(real / v * 100)
  def apply(p: Percent): Float = real * p.toDouble / 100 toFloat
  def +(v: Percent): Float = real + apply(v)
  def -(v: Percent): Float = real - apply(v)

  def round(scale: Int, r: Custom.Rounding = \/): Float = r.scale(real, scale).toFloat
  def Number: java.lang.Float = java.lang.Float.valueOf(real)

  def <>(that: Float): Range[Float] = new Z.Range(real, false, that, false)
  def <>>(that: Float): Range[Float] = new Z.Range(real, false, that, true)
  def <<>(that: Float): Range[Float] = new Z.Range(real, true, that, false)
  def <<>>(that: Float): Range[Float] = new Z.Range(real, true, that, true)
  def <>+(size: Int): Range[Float] = new Z.Range(real, false, real + size, false)
  def <>>+(size: Int): Range[Float] = new Z.Range(real, false, real + size, true)
  def <>! : Range[Float] = new Z.Range(real, false, real, false)
  def <>>! : Range[Float] = new Z.Range(real, false, real, true)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
