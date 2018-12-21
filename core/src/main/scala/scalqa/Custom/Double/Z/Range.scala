package scalqa; package Custom; package Double; package Z

private[scalqa] class Range(val start: Double, override val startExclusive: Boolean, val end: Double, override val endExclusive: Boolean) extends Number.Z.Range[Double] {
  type this_type = Range

  def ordering = Ordering.Double

  def ilk = Ilk.Doubles

  def step(v: Double, steps: Int) = v + steps

  override def startContains(v: Double, x: Boolean = false) = start < v || start == v && (x || !startExclusive)

  override def endContains(v: Double, x: Boolean = false) = end > v || end == v && (x || !endExclusive)

  protected def make(s: Double, sx: Boolean, e: Double, ex: Boolean) = new Range(s, sx, e, ex)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
