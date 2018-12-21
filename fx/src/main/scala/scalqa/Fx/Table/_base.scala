package scalqa; package Fx; package Table

trait _base[ENTRY] { self: Table[ENTRY] =>
  protected type REAL = javafx.scene.control.TableView[ENTRY]
  private[Table]type Column[A] <: Table.Column[ENTRY, VIEW, A]

  private[Table] val data = new Z.Data[ENTRY](This)

  lazy val columns: Idx.M[Table.Column[ENTRY, _, _]] with Any.Able.Seal = Idx.M.sealable()

  protected def setupDefaultColumns = ()

  protected def viewOpt: ENTRY => Opt[VIEW] = _.asInstanceOf[VIEW]; private[Table] def _viewOpt = viewOpt

  def sortOrder: Refs[Column[_]] = real.getSortOrder.all.map(_.getUserData.asInstanceOf[Column[_]]).to[Refs]; def sortOrder_=(a: ~[Column[_]]): Unit = real.getSortOrder.setAll(a.map(_.real).to[java.util.List])

  lazy val selection = Selection.make[ENTRY](entries, real.getSelectionModel)

  protected def onCreateRowCell(f: ⇒ Row.Cell[ENTRY, VIEW]) { real.rowFactoryProperty.set(prm ⇒ f.real.asInstanceOf[javafx.scene.control.TableRow[ENTRY]]) }

  // ---------------------------------------------------------------------------
  def scrollTo(i: Int) = real.scrollTo(i)

  def entriesPro: Pro.OM[Idx.OM[ENTRY]] = data.entriesPro: @inline; def entries = entriesPro()

  def itemsPro: Pro.OM[Idx.OM[ENTRY]] = data.itemsPro: @inline; def items = itemsPro(); def items_=(l: Idx[ENTRY]): Unit = itemsPro() = l.asObservableMutableView

  def sortModePro: Pro.OM[SortMode] = data.sortModePro: @inline; def sortMode = sortModePro(); def sortMode_=(v: SortMode) = sortModePro() = v

  def sortingPro: Pro.OM[Ordering[ENTRY]] = data.sortingPro: @inline; def ordering = sortingPro(); def ordering_=(v: Ordering[ENTRY]): Unit = sortingPro() = v

  def sortingBasePro: Pro.OM[Ordering[ENTRY]] = data.sortingBasePro: @inline; def sortingBase = sortingBasePro(); def sortingBase_=(v: Ordering[ENTRY]) = sortingBasePro() = v

  val headerFooterPro: Pro.OM[(Idx[ENTRY], Idx[ENTRY])] = data.headerFooterPro: @inline; def headerFooter = headerFooterPro(); def headerFooter_=(hf: (~[ENTRY], ~[ENTRY])): Unit = headerFooterPro() = (hf._1.to[Idx], hf._2.to[Idx])

  def editablePro: Pro.OM[Boolean] = Custom.ProWO(real.editableProperty); def editable = real.isEditable; def editable_=(b: Boolean) = real.setEditable(b)

  def placeholderPro = Custom.ProWO(real.placeholderProperty).asBiMappedView(A.Node.Map); def placeholder = placeholderPro(); def placeholder_=(v: A.Node) = real.setPlaceholder(v.real)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
