package scalqa; package Custom; package Char; package Z

private[scalqa] class Range(val start: Char, override val startExclusive: Boolean, val end: Char, override val endExclusive: Boolean) extends Number.Z.Range[Char] {
  type this_type = Range

  def ordering = Ordering.Char

  def ilk = Ilk.Chars

  def step(v: Char, steps: Int) = v + steps toChar

  override def startContains(v: Char, x: Boolean = false) = start < v || start == v && (x || !startExclusive)

  override def endContains(v: Char, x: Boolean = false) = end > v || end == v && (x || !endExclusive)

  protected def make(s: Char, sx: Boolean, e: Char, ex: Boolean) = new Range(s, sx, e, ex)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
