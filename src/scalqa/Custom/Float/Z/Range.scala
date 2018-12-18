package scalqa; package Custom; package Float; package Z

private[scalqa] class Range(val start: Float, override val startExclusive: Boolean, val end: Float, override val endExclusive: Boolean) extends Number.Z.Range[Float] {
  type this_type = Range

  def ordering = Ordering.Float

  def ilk = Ilk.Floats

  def step(v: Float, steps: Int) = v + steps

  override def startContains(v: Float, x: Boolean = false) = start < v || start == v && (x || !startExclusive)

  override def endContains(v: Float, x: Boolean = false) = end > v || end == v && (x || !endExclusive)

  protected def make(s: Float, sx: Boolean, e: Float, ex: Boolean) = new Range(s, sx, e, ex)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
