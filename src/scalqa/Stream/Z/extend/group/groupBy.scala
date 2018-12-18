package scalqa; package Stream; package Z; package extend; package group

private[Stream] object groupBy {

  def apply[@specialized(DATA) A](s: Stream[A], pros: ~[Mapping[A, Any]]): Stream[~[A]] = {

    val g: (A, A) => Boolean = pros.foldAs[(A, A) => Boolean]((x, y) => true)((f, m) => (x, y) => f(x, y) && m(x) == m(y))

    group[A](s, g, \/)
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
