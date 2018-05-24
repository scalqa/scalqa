package scalqa; package Pipe; package From; package Z

private[scalqa] object IndexedSeq extends Pipe.From[scala.IndexedSeq] {

  def apply[A](v: scala.IndexedSeq[A]): Pipe[A] = new all(v)

  // ******************************************************************************
  private class all[A](s: scala.collection.IndexedSeq[A]) extends Pipe.The.IndexBase[A](s.size) {

    protected def _apply(i: Int) = s(i)

    override def isMutable = !s.isInstanceOf[scala.Immutable]
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
