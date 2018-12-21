package scalqa; package Fx; package Table; package Cell; package Ui

trait _Trait[ENTRY, VIEW, VAL] extends Fx.Cell.Ui[Table.Cell[ENTRY, VIEW, VAL]] with Any.O with _value_setup[ENTRY, VIEW, VAL] with Any.Ref.Extra.Event1 {
  private[Table] def entryFilter: ENTRY => Boolean
  private[Ui] def onGetOptProEnhance(f: (ENTRY, Pro.O[Opt[VAL]]) => Pro.O[Opt[VAL]]): Unit

  private[Table] def refresh(s: Cell[ENTRY, VIEW, VAL]) = _fireEvent1(_Trait.Change, s)

  def onCellChange(f: Cell[ENTRY, VIEW, VAL] => Any) = _onEvent1(_Trait.Change, f)

  protected def onObservableChange(f: () => Any): EventControl = onCellChange(_ => f())

  protected def cellFilter: Cell[ENTRY, VIEW, VAL] => Boolean = c => c.entryOpt.let(entryFilter)

  private[Table] def column: Column[ENTRY, VIEW, VAL]

  def refreshOn(dep: ENTRY => Any.O*): Unit = onGetOptProEnhance((e, p) => p.asMappedView(v => v, dep.all.map(_(e))))

  def refreshEvery(tl: Duration): Unit = refreshOn(_ => Time.currentPro(tl))
}

private object _Trait { object Change }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
