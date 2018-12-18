package scalqa; package Util; package Range; package Z

private[Range] class FilterMonadic[A] private[scalqa] (private val real: Range[A]) extends AnyVal {

  def foreach(c: Stream.Consumer[A])(implicit n: math.Numeric[A]): Unit = real.all.foreach(c)

  def flatMap[B](m: Stream.Mapping[A, ~[B]])(implicit n: math.Numeric[A], i: Ilk[B]): Stream[B] = real.all.flatMap(m)

  def withFilter(f: Stream.Filter[A])(implicit n: math.Numeric[A]) = real.all.let(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
