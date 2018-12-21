package scalqa; package Util; package Range; package Z

private[Range] trait Base[A] extends Any { self: Range[A] =>
  protected type this_type <: Range[A]
  protected def thisClass: Class[_] = classOf[Range[A]]

  protected def startContains(v: A, x: Boolean = false): Boolean = { val i = ordering.compare(start, v); i <= 0 || i == 0 && (x || !startExclusive) }
  protected def endContains(v: A, x: Boolean = false): Boolean = { val i = ordering.compare(end, v); i > 0 || i == 0 && (x || !endExclusive) }
  protected def make(start: A, startIn: Boolean, end: A, endIn: Boolean): this_type

  @inline private[Range] def adapt(r: Range[A]): this_type = if (thisClass.isAssignableFrom(r.getClass)) r.asInstanceOf[this_type] else make(r.start, r.startExclusive, r.end, r.endExclusive)
}

private[Range] object Base {

  @inline private[Range] def startContains[A](r: Base[A], v: A, x: Boolean = false) = r.startContains(v, x)
  @inline private[Range] def endContains[A](r: Base[A], v: A, x: Boolean = false) = r.endContains(v, x)
  @inline private[Range] def make[A](r: Base[A], start: A, startIn: Boolean, end: A, endIn: Boolean): r.this_type = r.make(start, startIn, end, endIn)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
