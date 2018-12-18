package scalqa; package Custom; package Byte; package Z

private[scalqa] class Range(val start: Byte, override val startExclusive: Boolean, val end: Byte, override val endExclusive: Boolean) extends Number.Z.Range[Byte] {
  type this_type = Range

  def ordering = Ordering.Byte

  def ilk = Ilk.Bytes

  def step(v: Byte, steps: Int) = v + steps toByte

  override def startContains(v: Byte, x: Boolean = false) = start < v || start == v && (x || !startExclusive)

  override def endContains(v: Byte, x: Boolean = false) = end > v || end == v && (x || !endExclusive)

  protected def make(s: Byte, sx: Boolean, e: Byte, ex: Boolean) = new Range(s, sx, e, ex)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
