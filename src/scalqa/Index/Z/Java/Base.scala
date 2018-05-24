package scalqa; package Index; package Z; package Java

private[scalqa] abstract class Base[A] extends java.util.AbstractList[A] with Able.Info {

  override def toString = this.I.id

  override def hashCode = lazyHashCode

  private lazy val lazyHashCode = new AnyRef().hashCode

  protected def info = \/.info ~ ("size", size)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/