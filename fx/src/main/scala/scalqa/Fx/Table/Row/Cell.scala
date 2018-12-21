package scalqa; package Fx; package Table; package Row

class Cell[ENTRY, VIEW](table: Table[ENTRY]) extends Fx.Cell.Indexed {
  { table.uiSetup.events(this.I.asInstanceOfTarget) }
  type ITEM = ENTRY

  protected type REAL = javafx.scene.control.TableRow[ENTRY]
  protected override def _createGui: REAL = new REAL {
    protected override def updateItem(row: ENTRY, empty: Boolean) {
      super.updateItem(row, empty);
      try { refresh } catch { case e: RuntimeException => { throw e; } }
    }
  }

  def entryOpt: Opt[ENTRY] = itemOpt

  def entry: ENTRY = entryOpt.value

  def viewOpt: Opt[VIEW] = entryOpt.letMap(table._viewOpt(_).asInstanceOf[Opt[VIEW]])

  def view: VIEW = viewOpt.value

  protected override def refresh {
    style = \/
    alignment = \/

    entryOpt(e => table.uiSetup.all.letType[Ui[ENTRY, VIEW]].findOpt(_._cellFilter(this)).apply(
      _.refreshList.all.letMap(_(e)).foreach(_.onObservableChangeRun(table.entries.refreshAt(index <>!)).cancelIf(() => !entryOpt.contains(e)))))

    super.refresh
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
