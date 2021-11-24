package scalqa; package fx; package control; package table; import language.implicitConversions

class RowCell[ROW, VIEW](val table: Table[ROW]) extends control.Cell.Indexed:
  self =>
  type ITEM = ROW

  protected type REAL = javafx.scene.control.TableRow[ROW]
  protected override def _createReal: REAL = new REAL {
    protected override def updateItem(row: ROW, empty: Boolean): Unit =
      super.updateItem(row, empty);
      try
        afterItemUpdated;
        table.rowSetup(self.cast[RowCell[ROW,table.VIEW]],empty).apply(self)
      catch
        case e: RuntimeException => { throw e; }
  }

  def rowOpt  : Opt[ROW]  = itemOpt
  def row     : ROW       = rowOpt.get
  def viewOpt : Opt[VIEW] = rowOpt.mapOpt(table.mkViewOpt[VIEW](_))
  def view    : VIEW      = viewOpt.get

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
