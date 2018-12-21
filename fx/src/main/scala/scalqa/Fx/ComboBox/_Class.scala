package scalqa; package Fx; package ComboBox

import javafx.scene.control.ListCell
import javafx.scene.control.ListView

class _Class[A] extends Like[A] {

  protected override def _createGui = new REAL

  protected type REAL = javafx.scene.control.ComboBox[A]

  lazy val items: Idx.M[A] = Idx.M.wrap(real.getItems)

  lazy val selection = Selection.make(items, real.getSelectionModel)

  def selectAt(i: Int) = selection.selectAt(i)

  def select(a: A) = selection.select(a)

  def apply(): A = real.getValue

  def update(v: A): Unit = real.setValue(v)

  def visibleRowCountPro: Pro.OM[Int] = Custom.ProWO(real.visibleRowCountProperty); def visibleRowCount = real.getVisibleRowCount; def visibleRowCount_=(v: Int) = real.setVisibleRowCount(v)

  def onFormat(f: A => Any) = {
    class apply extends ListCell[A] { override def updateItem(a: A, empty: Boolean) = { super.updateItem(a, empty); setText(if (empty) null else f(a).toString) } }
    real.setCellFactory(l => new apply)
    real.setButtonCell(new apply);
  }

  onFormat(a => a.toString)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
