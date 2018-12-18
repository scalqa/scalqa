package scalqa; package Util; package Range; package Z; package A

private[Range] class Void[A](val ordering: Ordering[A]) extends Range[A] with Util.Void {
  type this_type = Range[A]

  override def start = App.Fail.unsupported("Void range does not have a start")

  override def startExclusive = true

  override def startContains(a: A, ax: Boolean = false) = false

  override def end = App.Fail.unsupported("Void range does not have an end")

  override def endExclusive = true

  override def endContains(a: A, ax: Boolean = false) = false

  override def allStep(step: A => A) = \/

  override def contains(a: A) = false

  override def contains(that: Range[A]) = false

  override def overlapOpt(that: Range[A]) = \/

  override def join(that: Range[A]) = that

  protected def make(s: A, sx: Boolean, e: A, ex: Boolean): Range[A] = new A.Any(s, sx, e, ex, ordering)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
