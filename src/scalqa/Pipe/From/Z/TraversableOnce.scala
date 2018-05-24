package scalqa; package Pipe; package From; package Z

private[scalqa] object TraversableOnce extends Pipe.From[scala.TraversableOnce] {

  def apply[A](v: scala.TraversableOnce[A]): Pipe[A] = v match {
    case t if (t.isEmpty) => \/
    case s: scala.collection.IndexedSeq[A] => IndexedSeq(s)
    case l: List[A] => List(l)
    case t => new all(v)
  }

  // ******************************************************************************
  private class all[A](tr: scala.TraversableOnce[A]) extends Pipe.The.Base[A] {
    private var src: scala.Iterator[A] = null
    var i = 0

    def pumpOpt(lf: A => Boolean): Opt[A] = {
      if (src == null) src = tr.toIterator
      while (src.hasNext) { val v = src.next; i += 1; if (lf(v)) return v }
      \/
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
