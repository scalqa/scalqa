package scalqa; package Idx; package M; package Z; package A

private[scalqa] class JavaProxy[A](val real: java.util.List[A]) extends JavaProxy.Like[A]

private[scalqa] object JavaProxy {

  trait Like[A] extends Idx.Z.A.JavaProxy.Like[A] with M[A] {

    def addAt(i: Int, e: A): Unit = real.add(i, e)

    def removeAt(r: Idx.Range): Unit = r.all.reverse.foreach(real.remove)

    def update(i: Int, e: A): Unit = real.set(i, e)

    def refreshAt(r: Idx.Range): Unit = real.all.letAt(r).letType[Any.Able.Refresh].foreach(_.refresh)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
