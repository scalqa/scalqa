package scalqa; package Fx; package Cell; package Ui

class Setup[CELL <: Fx.Cell] extends Idx[Ui[CELL]] with Any.Able.Seal {
  private var refs: Refs[Ui[CELL]] = \/
  private lazy val updateIdx: Refs[Ui[CELL]] = refs.all.let(_.onCellUpdateJobs.isVoid !).to[Refs]
  private lazy val mouseClickedIdx: Refs[Ui[CELL]] = refs.all.let(_.onCellMouseClickedJobs.isVoid !).to[Refs]
  private lazy val contextMenuIdx: Refs[Ui[CELL]] = refs.all.let(_.onCellContextMenuJobs.isVoid !).to[Refs]

  def add(ui: Ui[CELL]) { _failIfSealed; refs +@= (0, ui) }

  def events(c: CELL) {
    seal
    if (updateIdx.size > 0) c.onObservableChange(() => updateIdx.all.findOpt(_._cellFilter(c)).apply(_.onCellUpdateJobs.all(_(c))))
    if (mouseClickedIdx.size > 0) c.onMouseClicked(e => mouseClickedIdx.all.findOpt(_._cellFilter(c)).apply(_.onCellMouseClickedJobs.all(_(e, c))))
    if (contextMenuIdx.size > 0) c.onContextMenu(e => contextMenuIdx.all.findOpt(_._cellFilter(c)).apply(_.onCellContextMenuJobs.all(_(e, c))))
  }

  def uiOpt(c: CELL): Opt[Ui[CELL]] = all.findOpt(_._cellFilter(c))

  def apply(i: Int) = refs(i)
  def size = refs.size
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
