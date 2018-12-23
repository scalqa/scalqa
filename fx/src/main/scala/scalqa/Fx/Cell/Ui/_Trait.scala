package scalqa; package Fx; package Cell; package Ui

trait _Trait[CELL <: Fx.Cell] {
  private[Cell] var onCellUpdateJobs: Refs[CELL => Any] = \/
  private[Cell] var onCellMouseClickedJobs: Refs[(Event.Mouse, CELL) => Any] = \/
  private[Cell] var onCellContextMenuJobs: Refs[(Event.ContextMenu, CELL) => Any] = \/

  def onCellUpdate(f: CELL => Any): Unit = onCellUpdateJobs += f

  def onCellMouseClicked(f: (Event.Mouse, CELL) => Any): Unit = onCellMouseClickedJobs += f

  def onCellContextMenu(f: (Event.ContextMenu, CELL) => Any): Unit = onCellContextMenuJobs += f

  def onAlignmentOpt(on: CELL => Opt[Pos]): Unit = onCellUpdate(c => on(c).apply(c.alignment= _))

  def onAlignment(on: CELL => Pos): Unit = onAlignmentOpt(on(_).Opt)

  def onStyleOpt(on: CELL => Opt[Style]) { onCellUpdate(c => on(c).apply(c.style += _)) }

  def onStyle(on: CELL => Style) { onStyleOpt(on(_).Opt) }

  def onStyleClassOpt(on: CELL => Opt[Style.Class]) { onCellUpdate(c => on(c).apply(c.styleClass= _)) }

  def onStyleClass(on: CELL => Style.Class) { onStyleClassOpt(on(_).Opt) }

  // -----------------------------------------------------------------------------------------
  def alignment_=(s: Pos) = onAlignment(r => s); def alignment: Pos = App.Fail.unsupported()

  def style_=(s: Style) = onStyle(r => s); def style: Style = App.Fail.unsupported()

  def styleClass_=(s: Style.Class) = onStyleClass(c => s); def styleClass: Style.Class = App.Fail.unsupported()

  // -----------------------------------------------------------------------------------------
  private[Fx] def _cellFilter = cellFilter
  protected def cellFilter: CELL => Boolean
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
