package scalqa; package Index; package W; package Z; package The

private[scalqa] trait JavaProxy[A] extends Index.Z.The.JavaProxy[A] with W[A] {

  def addAt(i: Int, e: A): Unit = real.add(i, e)

  def removeAt(r: Int.Range): Unit = r.all.reverse(real.remove)

  def replaceAt(i: Int, e: A): Unit = real.set(i, e)

  def refreshAt(r: Int.Range): Unit = real.all.letAt(r).apply(Able.Refresh.apply)

}

private[scalqa] object JavaProxy {

  def get[A](l: java.util.List[A]): W[A] = new JavaProxy[A] { def real = l }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
