package scalqa; package Fx; package Table; package Column

abstract class _Class[ENTRY, VIEW, VAL] private[Table] extends Cell.Ui[ENTRY, VIEW, VAL]
  with _value_setup[ENTRY, VIEW, VAL]
  with _edit_setup[ENTRY, VIEW, VAL]
  with _pro[ENTRY, VIEW, VAL]
  with _row_setup[ENTRY, VIEW, VAL] {

  protected type REAL = javafx.scene.control.TableColumn[ENTRY, Cell.Z.Item[ENTRY, VIEW, VAL]]

  def table: Table[ENTRY]

  def setupCell(f: ⇒ Cell[ENTRY, VIEW, VAL]): Unit = real.cellFactoryProperty.set(p ⇒ f.real.asInstanceOf[javafx.scene.control.TableCell[ENTRY, Cell.Z.Item[ENTRY, VIEW, VAL]]])

  def reposition(index: Int): Unit = { table.columns remove this.I.asInstanceOfTarget; table.columns.addAt(index max 0 min table.columns.size, this.I.asInstanceOfTarget) }

  def refreshColumn: Unit = column.real.I(c => if (c.isVisible) { c.setVisible(false); c.setVisible(true) })

  def refreshRow(c: Cell[ENTRY, VIEW, VAL]): Unit = refreshRows(c.index <>!)

  def refreshRows(r: Idx.Range): Unit = column.table.entries.refreshAt(r)

  // ------------------------------------------------------------------------------------------------------------------------------------------------------
  private[Table] def entryOrdering: Ordering[ENTRY] = {
    val o = ordering.asOptValueView(1).on[ENTRY](e => createOptPro(e).apply())
    if (sortReversed) o.reverse else o
  }

  private[Table] def column = this

  private[Table] def real: javafx.scene.control.TableColumn[ENTRY, Cell.Z.Item[ENTRY, VIEW, VAL]]

  private[Table] val uiSetup = new Fx.Cell.Ui.Setup[Table.Cell[ENTRY, VIEW, _]]().I(_.add(this.I.asInstanceOfTarget))

  private[Table] def entryFilter: ENTRY => Boolean = ANY
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
