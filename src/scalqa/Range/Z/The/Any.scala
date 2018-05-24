package scalqa; package Range; package Z; package The

private[Range] class Any[A](val start: A, override val startExclusive: Boolean, val end: A, override val endExclusive: Boolean, val sorting: Sorting[A]) extends Range[A] {
  type THIS = Range[A]

  protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Any(s, sx, e, ex, sorting)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/