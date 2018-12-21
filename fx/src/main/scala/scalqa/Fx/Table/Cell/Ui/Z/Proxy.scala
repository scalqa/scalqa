package scalqa; package Fx; package Table; package Cell; package Ui; package Z

private[Fx] trait Proxy[ENTRY, VIEW, VAL] extends Fx.Cell.Ui.Z.Proxy[Table.Cell[ENTRY, VIEW, VAL]] with Ui[ENTRY, VIEW, VAL] {

  protected def realUi: Ui[ENTRY, VIEW, VAL]

  protected override def cellFilter: Table.Cell[ENTRY, VIEW, VAL] => Boolean = realUi._cellFilter

  override def onFormat(f: VAL => String) = realUi.onFormat(f)

  override def onFormatVoid(f: ENTRY => String) = realUi.onFormatVoid(f)

  override def onTooltip(f: Opt[VAL] ⇒ Any) = realUi.onTooltip(f)

  override def onGetOptPro(f: ENTRY => Pro.O[Opt[VAL]]) = realUi.onGetOptPro(f)

  override def onGetOptProEnhance(f: (ENTRY, Pro.O[Opt[VAL]]) => Pro.O[Opt[VAL]]) = realUi.onGetOptProEnhance(f)

  override def onCellChange(f: Cell[ENTRY, VIEW, VAL] => Any) = realUi.onCellChange(f)

}
