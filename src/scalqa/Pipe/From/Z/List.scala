package scalqa; package Pipe; package From; package Z

private[scalqa] object List extends Pipe.From[scala.List] {

  def apply[A](v: scala.List[A]): Pipe[A] = new all(v)

  // ******************************************************************
  private class all[A](var cur: List[A]) extends Pipe.The.Base[A] {

    def pumpOpt(lf: A => Boolean): Opt[A] = { while (!cur.isEmpty) { val v = cur.head; cur = cur.tail; if (lf(v)) return v }; \/ }

    override def isMutable = false

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
