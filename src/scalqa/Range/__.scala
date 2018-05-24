package scalqa; package Range

private[scalqa] trait __[A] extends Any {
  protected type THIS <: Range[A]
  protected def THIS_CLASS: Class[_] = classOf[Range[A]]

  protected def start: A
  protected def startExclusive: Boolean

  protected def end: A
  protected def endExclusive: Boolean

  protected def sorting: Sorting[A]

  protected def startContains(v: A, x: Boolean = false): Boolean = sorting(start, v).I.to(p => p.isAsIs || p.isEither && (x || !startExclusive))
  protected def endContains(v: A, x: Boolean = false): Boolean = sorting(end, v).I.to(p => p.isInverse || p.isEither && (x || !endExclusive))

  protected def _get(start: A, startIn: Boolean, end: A, endIn: Boolean): THIS

  @inline protected def This: THIS = this.cast
  @inline private[Range] def _get(r: Range[A]): THIS = if (THIS_CLASS.isAssignableFrom(r.getClass)) r.cast else _get(r.start, r.startExclusive, r.end, r.endExclusive)
  @inline private[Range] def _startContains(v: A, x: Boolean = false) = startContains(v, x)
  @inline private[Range] def _endContains(v: A, x: Boolean = false) = endContains(v, x)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 */
