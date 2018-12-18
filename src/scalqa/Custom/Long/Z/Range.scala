package scalqa; package Custom; package Long; package Z

private[scalqa] class Range(val start: Long, override val startExclusive: Boolean, val end: Long, override val endExclusive: Boolean) extends Number.Z.Range[Long] {
  type this_type = Range

  def ordering = Ordering.Long

  def ilk = Ilk.Longs

  def step(v: Long, steps: Int) = v + steps

  override def startContains(v: Long, x: Boolean = false) = start < v || start == v && (x || !startExclusive)

  override def endContains(v: Long, x: Boolean = false) = end > v || end == v && (x || !endExclusive)

  protected def make(s: Long, sx: Boolean, e: Long, ex: Boolean) = new Range(s, sx, e, ex)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
