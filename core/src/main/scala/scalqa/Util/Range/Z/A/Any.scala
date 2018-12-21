package scalqa; package Util; package Range; package Z; package A

private[scalqa] class Any[A](val start: A, override val startExclusive: Boolean, val end: A, override val endExclusive: Boolean, val ordering: Ordering[A]) extends Range[A] {
  type this_type = Range[A]

  protected def make(s: A, sx: Boolean, e: A, ex: Boolean) = new Any(s, sx, e, ex, ordering)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
