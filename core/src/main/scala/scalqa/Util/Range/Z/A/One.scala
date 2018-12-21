package scalqa; package Util; package Range; package Z; package A

private class One[A](val start: A)(implicit val ordering: Ordering[A]) extends Range[A] {
  type this_type = Range[A]

  def end = start

  def endExclusive = false

  def startExclusive = false

  protected def make(s: A, sx: Boolean, e: A, ex: Boolean) = new Any(s, sx, e, ex, ordering)

}

private[Range] object One {

  def make[A: Ordering](v: A, ex: Boolean): Range[A] = if (ex) new Exclusive(v) else new One(v)

  private class Exclusive[A: Ordering: Ilk](val v: A) extends One[A](v) {

    override def endExclusive = true

  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
