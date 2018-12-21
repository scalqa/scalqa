package scalqa; package Fx; package Table; package Cell

abstract class _Class[ENTRY, VIEW, VAL](val column: Column[ENTRY, VIEW, _]) extends Fx.Cell.Indexed {
  {
    column.uiSetup.events(this)
  }

  protected override def refresh {
    editable = itemOpt.map(i => column._onEditEnabled(i.entry)).or(false)

    itemOpt(_.initCell(this),psedoClasses.clear)
    tooltip = itemOpt.letMap(_.ui._onTooltipOpt).map(_(valueOpt)) or \/
    style = \/
    text = \/
    alignment = \/
    super.refresh
    textOpt(text = _)
  }

  protected type ITEM = Z.Item[ENTRY, VIEW, VAL]
  protected type REAL <: javafx.scene.control.TableCell[ENTRY, ITEM]

  def table: Table[ENTRY] = column.table

  def entryOpt: Opt[ENTRY] = itemOpt.map(_.entry)

  def entry: ENTRY = entryOpt.value

  def viewOpt: Opt[VIEW] = entryOpt.letMap(i => column.table._viewOpt(i)).asInstanceOf[Opt[VIEW]]

  def view: VIEW = viewOpt.value

  def valueOpt: Opt[VAL] = itemOpt.letMap(_.valueOpt)

  def value: VAL = valueOpt.value

  def textOpt: Opt[String] = itemOpt.letMap(_.textOpt)

  def uiOpt: Opt[Cell.Ui[ENTRY, VIEW, VAL]] = itemOpt.map(_.ui)

  def ui: Cell.Ui[ENTRY, VIEW, VAL] = uiOpt.value
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
