package scalqa; package Fx; package Chart; package XY; package A; package Basic; package Z

import javafx.scene.chart.{ Axis => FxAxis }
import javafx.scene.chart.XYChart.{ Series => JSeries, Data => JItem }

private[A] class XYChart[X, Y, XA <: Axis[X], YA <: Axis[Y], XV, YV](val chart: Basic[X, Y, XA, YA], xa: FxAxis[XV], ya: FxAxis[YV]) extends javafx.scene.chart.XYChart[XV, YV](xa, ya) {

  protected def seriesAdded(s: JSeries[XV, YV], i: Int) = runFx {
    var n = chart.Series(s).node
    s.setNode(n.real);
    getPlotChildren.add(n.real)
    s.getData.all.foreach(it => {
      val n = chart.Item.make(it).node
      it.setNode(n.real)
      getPlotChildren.add(n.real)
    })
  }

  protected def dataItemAdded(s: JSeries[XV, YV], i: Int, it: JItem[XV, YV]): Unit = {
    val n = chart.Item.make(it).node
    runFx({
      it.setNode(n.real);
      try { getPlotChildren.add(n.real) }
      catch {
        case _: Throwable => () // toDo - Fix "duplicate children added"
      }
    })
  }

  protected def seriesRemoved(s: JSeries[XV, YV]) = runFx {
    s.getData.all.foreach(it => { it.getNode.I.Opt(getPlotChildren.remove(_)); removeDataItemFromDisplay(s, it) })
    removeSeriesFromDisplay(s)
  }

  protected def dataItemRemoved(it: JItem[XV, YV], s: JSeries[XV, YV]): Unit = runFx { it.getNode.I.Opt(getPlotChildren.remove(_)); removeDataItemFromDisplay(s, it) }

  protected def dataItemChanged(p: JItem[XV, YV]) = {}

  protected def layoutPlotChildren = runFx(getDisplayedSeriesIterator.all.foreach(s => {
    chart.Series(s).layoutJob()
    getDisplayedDataIterator(s).all.map(chart.Item.make(_)).foreach(_.layoutJob())
  }))

  override protected def updateLegend = chart.Setup.updateLegendJobs.all(_()); chart.Setup.updateLegendJobs += (() => super.updateLegend)

  override protected def updateAxisRange = if (getXAxis.isAutoRanging) {
    chart.Setup.calcXRangeOptFun().apply(r => getXAxis.invalidateRange((r.start ~+ r.end).map(chart.axisX.valueMap(_).asInstanceOf[XV]).to[java.util.List]))
    chart.Setup.calcYRangeOptFun().apply(r => getYAxis.invalidateRange((r.start ~+ r.end).map(chart.axisY.valueMap(_).asInstanceOf[YV]).to[java.util.List]))
  }

  // -----------------------------------------------------------------------
  private val list = Idx.OM.make[JSeries[XV, YV]].I(l => setData(new Fx.Custom.ObservableList.OM(l)))
  private var jobs: Idx.M[() => Any] = NEW

  private def runFx(job: => Any): Unit = chart.synchronized {
    jobs.isVoid.I { first =>
      if (first && Fx.Thread.is) job
      else {
        jobs += (() => job);
        if (first) Fx.Thread.run(chart.synchronized { val v = jobs; jobs = \/; v.all(_()) })
      }
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
