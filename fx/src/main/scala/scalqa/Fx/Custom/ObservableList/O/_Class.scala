package scalqa; package Fx; package Custom; package ObservableList; package O

class _Class[A](val real: Idx.O[A]) extends java.util.AbstractList[A] with javafx.collections.ObservableList[A] {

  def get(i: Int) = real(i)
  def size = real.size

  // ---------------------------------------------------------------------------------
  def addAll(v: A*): Boolean = App.Fail.unsupported()
  def remove(from: Int, end: Int): Unit = App.Fail.unsupported()
  def removeAll(c: A*): Boolean = App.Fail.unsupported()
  def retainAll(c: A*): Boolean = App.Fail.unsupported()
  def setAll(v: java.util.Collection[_ <: A]): Boolean = App.Fail.unsupported()
  def setAll(v: A*): Boolean = App.Fail.unsupported()

  // --------------------------------------------------------------
  def addListener(l: javafx.beans.InvalidationListener) = real.onObservableChange(EventControl.id0(l, () => l.invalidated(_Class.this)))
  def removeListener(l: javafx.beans.InvalidationListener) = real.onObservableChange(EventControl.cancelId0(l))

  def addListener(l: javafx.collections.ListChangeListener[_ >: A]) = real.onChange(new fireFxChange(l))
  def removeListener(l: javafx.collections.ListChangeListener[_ >: A]) = real.onChange(EventControl.cancelId1(l))

  override def toString = this.I.id
  override def hashCode = 31 * real.hashCode

  // ***********************************************************************
  private class fireFxChange(val id: javafx.collections.ListChangeListener[_ >: A]) extends (Idx[Idx.Change[A]] => Any) with Util.EventControl.WithId {
    def apply(c: Idx[Idx.Change[A]]) = {
      val fxc = new Change(c, _Class.this)
      try {
        id.onChanged(fxc)
      } catch {
        case t: Throwable => {
          System.err.println(fxc.all.toText.indent("FxListChange"))
          System.err.println(_Class.this.all.zipIdx.toText.indent("FxList"))
          throw t
        }
      }
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
