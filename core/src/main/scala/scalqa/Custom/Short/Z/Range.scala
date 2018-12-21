package scalqa; package Custom; package Short; package Z

private[scalqa] class Range(val start: Short, override val startExclusive: Boolean, val end: Short, override val endExclusive: Boolean) extends Number.Z.Range[Short] {
  type this_type = Range

  def ordering = Ordering.Short

  def ilk = Ilk.Shorts

  def step(v: Short, steps: Int) = v + steps toShort

  override def startContains(v: Short, x: Boolean = false) = start < v || start == v && (x || !startExclusive)

  override def endContains(v: Short, x: Boolean = false) = end > v || end == v && (x || !endExclusive)

  protected def make(s: Short, sx: Boolean, e: Short, ex: Boolean) = new Range(s, sx, e, ex)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
