package scalqa; package Fx; package Table; package Cell; package Z

private[Table] class Item[ENTRY, VIEW, VAL](val entry: ENTRY, val ui: Cell.Ui[ENTRY, VIEW, VAL])
    extends Custom.ObservableBase[Item[ENTRY, VIEW, VAL]]
    with Any.Able.ToInfo with Comparable[Item[ENTRY, VIEW, VAL]] {

  // --------------------------------------------------------------------------------------------------------------------------------------------
  def this(ui: Cell.Ui[ENTRY, VIEW, VAL], v: VAL) = { this(().asInstanceOf[ENTRY], ui); _valueOpt = v }

  private val pro: Pro.O[Opt[VAL]] = ui.createOptPro(entry)

  def valueOpt: Opt[VAL] = _valueOpt orOpt pro(); def valueOpt_=(v: Opt[VAL]) { _valueOpt = v }; private var _valueOpt: Opt[VAL] = \/

  def textOpt: Opt[String] = valueOpt.map(ui._onFormat) orOpt ui._onFormatVoid(entry).Opt

  def toInfo = new Pro.Info(this) += ("text", textOpt) += ("value", valueOpt)

  def compareTo(that: Item[ENTRY, VIEW, VAL]) = ui.column.ordering.optCompare(this.valueOpt, that.valueOpt)

  def getValue = this

  // --------------------------------------------------------------------------------------------------------------------------------------------
  def initCell(cell: Table.Cell[ENTRY, VIEW, VAL]) = pro.onObservableChange(EventControl.id0(this, () => { ui.refresh(cell); fireInvalidate }))

  override def removeListener(l: javafx.beans.InvalidationListener) { super.removeListener(l); if (listenerCount == 0) pro.onObservableChange(EventControl.cancelId0(this)) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
