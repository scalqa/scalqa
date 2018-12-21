package scalqa; package Fx; package Table; package Column

private[Column] trait _pro[ENTRY, VIEW, VAL] extends Any.Able.ToInfo { self: Column[ENTRY, VIEW, VAL] =>

  def idPro: Pro.OM[String] = Custom.ProWO(real.idProperty); def id = real.getId; def id_=(v: String) = real.setId(v)

  def visiblePro: Pro.OM[Boolean] = Custom.ProWO(real.visibleProperty); def visible = real.isVisible; def visible_=(b: Boolean) = real.setVisible(b)

  def labelPro: Pro.OM[String] = Custom.ProWO(real.textProperty); def label = real.getText; def label_=(v: String) = real.setText(v)

  def maxWidthPro: Pro.OM[Double] = Custom.ProWO(real.maxWidthProperty); def maxWidth = real.getMaxWidth; def maxWidth_=(v: Double) = real.setMaxWidth(v)

  def minWidthPro: Pro.OM[Double] = Custom.ProWO(real.minWidthProperty); def minWidth = real.getMinWidth; def minWidth_=(v: Double) = real.setMinWidth(v)

  def prefWidthPro: Pro.OM[Double] = Custom.ProWO(real.prefWidthProperty); def prefWidth = real.getPrefWidth; def prefWidth_=(v: Double) = real.setPrefWidth(v)

  def widthPro = Custom.ProO(real.widthProperty); def width = real.getWidth; def width_=(v: Double) = { /*maxWidth = v; minWidth = v;*/ prefWidth = v; }

  def graphicPro: Pro.OM[A.Node.Like] = Custom.ProWO(real.graphicProperty).asBiMappedView(A.Node.Like.Map); def graphic = A.Node.Like.make(real.getGraphic); def graphic_=(g: A.Node.Like) = real.setGraphic(g.real)

  def onHeaderContextMenu(actions: => ~[Action]): Unit = actions.I.Opt(a => real.setContextMenu(Popup.Menu.make(a).real))

  def toInfo = new Pro.Info(this) += ("label", label) += ("width", width)

  val sortingPro = Pro.OM.make[Ordering[VAL]](\/); def ordering = sortingPro(); def ordering_=(o: Ordering[VAL]) { sortingPro() = o };

  lazy val sortablePro = Custom.ProWO(real.sortableProperty); def sortable = sortablePro(); def sortable_=(b: Boolean) = sortablePro() = b

  lazy val sortReversedPro: Pro.OM[Util.Trilean] = new Z.SortReversedPro(real.sortTypeProperty); def sortReversed = sortReversedPro(); def sortReversed_=(v: Util.Trilean) = sortReversedPro() = v
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
