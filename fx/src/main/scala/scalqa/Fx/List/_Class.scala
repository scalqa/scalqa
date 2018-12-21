package scalqa; package Fx; package List

class _Class[A] extends A.Control {
  protected override def _createGui: REAL = new javafx.scene.control.ListView[A]().asInstanceOf[REAL]

  protected type REAL <: javafx.scene.control.ListView[A]

  lazy val items = Idx.M.wrap(real.getItems)

  lazy val selection = Selection.make(items, real.getSelectionModel)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
