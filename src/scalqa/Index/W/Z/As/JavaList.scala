package scalqa; package Index; package W; package Z; package As

private[Index] class JavaList[A](protected val real: W[A]) extends Index.Z.Java.Base[A] with Able.Info {

  def get(i: Int): A = real(i)

  def size = real.size

  override def set(i: Int, a: A) = { val o = get(i); real.replaceAt(i, a); o }

  override def add(i: Int, a: A) = real.addAt(i, a)

  override def remove(i: Int) = { val o = get(i); real.removeAt(i); o }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/