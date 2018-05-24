package scalqa; package Index; package Z; package The

private[scalqa] trait JavaProxy[A] extends scalqa.Index[A] {

  protected def real: java.util.List[A]

  def size = real.size

  def apply(i: Int) = real.get(i)

}

private[scalqa] object JavaProxy {

  def apply[A](l: java.util.List[A]): Index[A] = new JavaProxy[A] { def real = l }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/