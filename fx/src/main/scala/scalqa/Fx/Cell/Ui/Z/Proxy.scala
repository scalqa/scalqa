package scalqa; package Fx; package Cell; package Ui; package Z

private[Fx] trait Proxy[CELL <: Fx.Cell] extends Ui[CELL] {

  protected def realUi: Ui[CELL]

  protected def cellFilter: CELL => Boolean = realUi._cellFilter

  override def onCellUpdate(f: CELL => Any) = realUi.onCellUpdate(f)

  override def onCellMouseClicked(f: (Event.Mouse, CELL) => Any): Unit = realUi.onCellMouseClicked(f)

  override def onCellContextMenu(f: (Event.ContextMenu, CELL) => Any): Unit = realUi.onCellContextMenu(f)

}
