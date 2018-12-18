package scalqa; package Custom; package List

private[scalqa] abstract class _Class[A] extends java.util.AbstractList[A] with Any.Able.ToInfo {

  override def toString = this.I.id

  override def hashCode = lazyHashCode

  private lazy val lazyHashCode = new AnyRef().hashCode

  def toInfo = new Pro.Info(this) += ("size", size)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
