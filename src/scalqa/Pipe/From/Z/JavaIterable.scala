package scalqa; package Pipe; package From; package Z

private[scalqa] object JavaIterable extends Pipe.From[java.lang.Iterable] {

  def apply[A](v: java.lang.Iterable[A]): Pipe[A] = v match {
    case c: java.util.Collection[A] => if (c.isEmpty) \/ else v.I.letAs(classOf[java.util.List[A]]).map(new all(_)) orElse new JavaIterator.all(c.iterator, c.size)
    case v => v.iterator.all
  }

  // *************************************************************************************
  private class all[A](l: java.util.List[A]) extends Pipe.The.IndexBase[A](l.size) {

    protected def _apply(i: Int) = l.get(i)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
