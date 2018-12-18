package scalqa; package Stream; package Z; package consume; package aggregate

private[Stream] object min {

  def Opt[@specialized(DATA) A](s: Stream[A])(implicit o: Ordering[A]): Opt[A] = {
    val c = o.custom

    val r = new Reducer[A] { def reduce(x: A, y: A) = if (c.compare(x, y) <= 0) x else y }

    s.foreach(r)

    r.toOpt
  }

  def ByOpt[A, @specialized(DATA) B](s: Stream[A], map: Mapping[A, B])(implicit o: Ordering[B]): Opt[A] = {
    val c = o.custom

    val r = new Reducer[A] { def reduce(x: A, y: A) = if (c.compare(map(x), map(y)) <= 0) x else y }

    s.foreach(r)

    r.toOpt
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
