package scalqa; package Util; package Out; package Z

private[Out] final class FilterMonadic[+A] private[scalqa] (private val real: Any) extends AnyVal {
  private def _failed = real.isInstanceOf[Deficiency]
  private def _val = real.asInstanceOf[A]

  def foreach(f: A => Unit): Unit = real match { case v: Deficiency => (); case v => f(_val) }

  def flatMap[B](f: A => Out[B]): Out[B] = if (_failed) new Out(real) else f(_val)

  def withFilter(f: A => Boolean): Out[A] = new Out(if (_failed || f(_val)) real else Deficiency.apply("For-Comprehension predicate is not satisfied"))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
