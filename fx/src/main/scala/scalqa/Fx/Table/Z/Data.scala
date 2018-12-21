package scalqa; package Fx; package Table; package Z

private[Table] class Data[A](table: Table[A]) {

  def init(real: javafx.scene.control.TableView[A]) {
    real.setItems(new Custom.ObservableList.OM(entriesPro()))
    real.setSortPolicy(_ => true)
    Custom.ProO(real.comparatorProperty).I(p => {
      var ok = true // recursion check
      var oldOrd: Refs[table.Column[_]] = \/
      p.onObservableChange(() => if (ok) {
        val ord = table.sortOrder
        if (ord.isEmpty && !sortModePro().isProxyWithUnsorted && !oldOrd.isEmpty) {
          val c = oldOrd.first
          if (!c.sortReversed.isVoid) {
            import javafx.scene.control.TableColumn.SortType._
            c.real.setSortType(if (c.real.getSortType == DESCENDING) ASCENDING else DESCENDING)
          }
          table.sortOrder = oldOrd
        } else {
          oldOrd = ord
          ok = false;

          sortingPro() = ord.all.map(_.entryOrdering).foldAs[Ordering[A]](\/)(_ + _)
          ok = true
        }
      })
      sortingPro.onObservableChangeRun(if (ok) { ok = false; real.getSortOrder.clear; ok = true })
    })
  }

  // -----------------------------------------------------------------------------------------------------------------------------------------
  private def resetEntries: Unit = {
    var it = itemsPro()
    if (sortModePro().isProxy) it = new OrderedProxyList(it)
    if ({ val hf = headerFooterPro(); !hf._1.isEmpty || !hf._2.isEmpty }) it = new HeaderFooterList(headerFooterPro(), it)
    entriesPro() = it
  }

  val itemsPro = new Pro.OM.A.Basic[Idx.OM[A]](NEW).I(_.onChangeRun(resetEntries))

  val entriesPro = new Pro.OM.A.Basic[Idx.OM[A]](itemsPro()).I(p => p.onChangeRun(table.real.setItems(new Custom.ObservableList.OM(p()))))

  val headerFooterPro = new Pro.OM.A.Basic[(Idx[A], Idx[A])]((\/, \/)).I(_.onChangeRun(resetEntries))

  val sortModePro = Pro.OM.make(SortMode.Direct).I(p => p.onChangeRun({
    resetEntries;
    table.columns.all(c => c.sortable = !p().isVoid && !c.ordering.isVoid)
  }))

  // ----------------------------------------------------------------------------------------------------------------------------------------
  val sortingBasePro = new Pro.OM.A.Basic[Ordering[A]](\/).I(p => p.onChangeRun(entriesPro().order(p() + sortingPro())))

  val sortingPro: Pro.OM[Ordering[A]] = new Pro.OM.A.Basic[Ordering[A]](\/).I(p => p.onChangeRun(entriesPro().order(sortingBasePro() + p())))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
