package scalqa; package Range; package Z

private[Range] class Void[A](val sorting: Sorting[A]) extends Range[A] with Any.As.Void {
  type THIS = Range[A]

  def start = Fail.unsupported("Void range does not have a start")

  override def startExclusive = true

  override def startContains(a: A, ax: Boolean = false) = false

  def end = Fail.unsupported("Void range does not have an end")

  override def endExclusive = true

  override def endContains(a: A, ax: Boolean = false) = false

  override def allStep(step: A => A) = \/

  override def contains(a: A) = false

  override def contains(that: Range[A]) = false

  override def overlapOpt(that: Range[A]) = \/

  override def join(that: Range[A]) = that

  protected def _get(s: A, sx: Boolean, e: A, ex: Boolean): Range[A] = Range.getGeneral(s,sx,e,ex)(sorting)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/