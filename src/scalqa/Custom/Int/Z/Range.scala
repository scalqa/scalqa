package scalqa; package Custom; package Int; package Z

private[scalqa] class Range(val start: Int, override val startExclusive: Boolean, val end: Int, override val endExclusive: Boolean) extends Number.Z.Range[Int] {
  type this_type = Range

  def ordering = Ordering.Int

  def ilk = Ilk.Ints

  def step(v: Int, steps: Int) = v + steps

  override def startContains(v: Int, x: Boolean = false) = start < v || start == v && (x || !startExclusive)

  override def endContains(v: Int, x: Boolean = false) = end > v || end == v && (x || !endExclusive)

  protected def make(s: Int, sx: Boolean, e: Int, ex: Boolean) = new Range(s, sx, e, ex)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
