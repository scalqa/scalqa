package scalqa; package Stream; package Z; package A; package Java

private[scalqa] object List {

  def toStream[A](l: java.util.List[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = new Stream.A.Indexed[A] with Any.Able.Stream[A] {

    @inline override def _size = l.size;

    @inline override def _apply(i: Int) = l.get(i)

    @inline override def ilkOpt = i.ilkOpt

    @inline def all = this
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
