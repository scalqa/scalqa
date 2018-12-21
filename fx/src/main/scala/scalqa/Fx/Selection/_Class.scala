package scalqa; package Fx; package Selection

import javafx.scene.control.{ MultipleSelectionModel, SelectionModel, SelectionMode }

class _Class[A] protected[Selection] (val target: Idx[A], val real: SelectionModel[_ <: Any]) extends Any.O with Idx.Selection.O[A] {
  private lazy val multiRealOpt = real.I.letType[MultipleSelectionModel[A]]

  lazy val positions: Idx[Int] = multiRealOpt.map(v => Idx.wrap(v.getSelectedIndices).asMappedView(_.intValue)) or
    new Idx[Int] { def size = if (real.getSelectedIndex < 0) 0 else 1; def apply(i: Int) = real.getSelectedIndex }

  def mode = if (multiRealOpt && multiRealOpt.value.getSelectionMode == SelectionMode.MULTIPLE) Mode.Multiple else Mode.Single

  def mode_=(v: Mode): Unit = { multiRealOpt(_.setSelectionMode(v.real)) }

  def onChange(run: this.type => Any): EventControl = new Util.EventControl.A.Base with javafx.beans.InvalidationListener {
    def invalidated(o: javafx.beans.Observable) = if (isActive) run(_Class.this)
    onCancel(() => real.selectedIndexProperty.removeListener(this))
    real.selectedIndexProperty.addListener(this)
  }
}

object _Class {

  implicit def zzLibrary[A](v: Selection[A]) = new _library[A](v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
