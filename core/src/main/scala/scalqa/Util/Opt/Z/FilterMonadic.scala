package scalqa; package Util; package Opt.Z

private[Opt] class FilterMonadic[+A] private[scalqa] (private val real: Any) extends AnyVal {
  @inline private def _is = !real.isInstanceOf[Util.Opt.VoidValue]
  @inline private def _val: A = real.asInstanceOf[A]

  def foreach(f: A => Unit): Unit = if (_is) f(_val)

  def flatMap[B](f: A => Opt[B]): Opt[B] = if (_is) f(_val) else Opt.Void

  def withFilter(f: A => Boolean): Opt[A] = if (_is && f(_val)) _val else Opt.Void

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
