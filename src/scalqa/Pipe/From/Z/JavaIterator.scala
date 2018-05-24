package scalqa; package Pipe; package From; package Z

private[scalqa] object JavaIterator extends Pipe.From[java.util.Iterator] {

  def apply[A](v: java.util.Iterator[A]): Pipe[A] = new all(v)

  // *************************************************************************************
  class all[A](src: java.util.Iterator[A], so: Opt[Int] = \/) extends Pipe.The.Base[A] {
    private var i = 0

    def pumpOpt(f: A => Boolean): Opt[A] = { while (src.hasNext) { val v = src.next; i += 1; if (f(v)) return v }; \/ }

    override def sizeOpt = so.map(_ - i)
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
