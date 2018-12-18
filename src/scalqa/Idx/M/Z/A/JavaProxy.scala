package scalqa; package Idx; package M; package Z; package A

private[scalqa] trait JavaProxy[A] extends Idx.Z.A.JavaProxy[A] with M[A] {

  def addAt(i: Int, e: A): Unit = real.add(i, e)

  def removeAt(r: Idx.Range): Unit = r.all.reverse.foreach(real.remove)

  def update(i: Int, e: A): Unit = real.set(i, e)

  def refreshAt(r: Idx.Range): Unit = real.all.letAt(r).letType[Any.Able.Refresh].foreach(_.refresh)

}

private[scalqa] object JavaProxy {

  def make[A](l: java.util.List[A]): M[A] = new JavaProxy[A] { def real = l }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
