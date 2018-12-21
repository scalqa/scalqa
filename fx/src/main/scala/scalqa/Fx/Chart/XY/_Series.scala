package scalqa; package Fx; package Chart; package XY

trait _Series[X, Y] extends _Item[X, Y] { self: XY[X, Y] =>
  type SERIES <: Series

  class Series protected (nameOpt: Opt[String] = \/, private var _items: Idx.O[ITEM] = \/) {
    private[Chart] lazy val real = new chart.J_SERIES(new JFxList).I(s => nameOpt(s.setName))

    val chart: XY[X, Y] = self

    def name: String = real.getName; def name_=(v: String) = real.setName(v)

    def items: Idx.O[ITEM] = _items; def items_=(l: Idx.O[ITEM]) { _items = l; real.setData(new JFxList) }

    // ************************************
    private class JFxList extends Custom.ObservableList.O[chart.J_ITEM](items.asMappedView(_.real.asInstanceOf[chart.J_ITEM]).asSynchronizedView(self)) {
      def series: SERIES = Series.this.asInstanceOf[SERIES]
      //      override def addListener(l: javafx.collections.ListChangeListener[_ >: chart.J_ITEM]) = { ("addListenerC   :>", this.I.hashIndex, l).lp; super.addListener(l) }
      //      override def removeListener(l: javafx.collections.ListChangeListener[_ >: chart.J_ITEM]) = {("removeListenerC:>", this.I.hashIndex, l).lp; super.removeListener(l) }
    }
  }

  object Series {

    def apply(s: javafx.scene.chart.XYChart.Series[_, _]): SERIES = s.getData.asInstanceOf[Series#JFxList].series

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
