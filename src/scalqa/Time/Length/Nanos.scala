package scalqa; package Time; package Length

class Nanos private[Nanos] (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Nanos
  protected def companion = Nanos

  private[Time] def _totalMillis = value / Long.OneMillion
  private[Time] override def _totalSeconds = value / Long.OneBillion
  private[Time] override def _preciseNanos = (value % Long.OneBillion).toInt

}

object Nanos extends Z.Custom.Companion[Nanos]("nanos", 3) {

  def get(v: Long) = new Nanos(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Nanos ->
 *
 *     [[Nanos]] is a unit representing [[Time.Length]] of specified number of nanoseconds.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Nanos -> [[Nanos]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Nanos.lp     // Prints: 1 nanos
 *       3.Nanos.lp     // Prints: 3 nanos
 *       5000.Nanos.lp  // Prints: 5000 nanos
 *     }}}
 */
