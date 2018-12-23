package scalqa; package Fx; package Cell; package Ui; package Z

private[Fx] trait Proxy[CELL <: Fx.Cell] extends Ui[CELL] {

  protected def realUi: Ui[CELL]

  protected def cellFilter: CELL => Boolean = realUi._cellFilter

  override def onCellUpdate(f: CELL => Any) = realUi.onCellUpdate(f)

  override def onCellMouseClicked(f: (Event.Mouse, CELL) => Any): Unit = realUi.onCellMouseClicked(f)

  override def onCellContextMenu(f: (Event.ContextMenu, CELL) => Any): Unit = realUi.onCellContextMenu(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
