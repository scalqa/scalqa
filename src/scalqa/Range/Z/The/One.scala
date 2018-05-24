package scalqa; package Range; package Z; package The

private[Range] class One[A](val start: A, val sorting: Sorting[A]) extends Range[A] {
  type THIS = Range[A]

  def end = start

  def endExclusive = false

  def startExclusive = false

  protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Any(s, sx, e, ex, sorting)

}

private[Range] object One {

  class Exclusive[A](val s: A, srt: Sorting[A]) extends One[A](s, srt) {

    override def endExclusive = true
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
