package scalqa; package fx; package scene; package chart; package xy; package x; package basic; package z; import language.implicitConversions

import javafx.scene.{ chart => J }
import J.XYChart.{ Series => JSeries, Data => JItem }

private[x] class Real[X, Y, XA <: Chart.Axis[X], YA <: Chart.Axis[Y], XV, YV](val chart: Basic[X, Y, XA, YA], xa: J.Axis[XV], ya: J.Axis[YV]) extends J.XYChart[XV, YV](xa, ya) with Real_Base:
  private val list =  Idx.OM[JSeries[XV, YV]]().self(l => setData(Fx.JavaFx.list(l)))

  protected def seriesAdded(s: JSeries[XV, YV], i: Int) = runFx {
    val n = chart.SeriesBase(s).node
    if (n != null)
      s.setNode(n.real);
      getPlotChildren.add(n.real)
    s.getData.valStream.foreach(it => {
      val n = chart.ItemBase(it).node
      it.setNode(n.real)
      getPlotChildren.add(n.real)
    })
  }

  protected def dataItemAdded(s: JSeries[XV, YV], i: Int, it: JItem[XV, YV]): Unit =
    val n = chart.ItemBase(it).node
    runFx({
      it.setNode(n.real);
      try getPlotChildren.add(n.real)
      catch
        case _ : Throwable => () // toDo - Fix "duplicate children added problem"
    })

  protected def seriesRemoved(s: JSeries[XV, YV]) = runFx {
    s.getData.valStream.foreach(it => { it.getNode.?.forval(getPlotChildren.remove(_)); removeDataItemFromDisplay(s, it) })
    removeSeriesFromDisplay(s)
  }

  protected def dataItemRemoved(it: JItem[XV, YV], s: JSeries[XV, YV]): Unit = runFx { it.getNode.?.forval(getPlotChildren.remove(_)); removeDataItemFromDisplay(s, it) }

  protected def dataItemChanged(p: JItem[XV, YV]) = {}

  protected def layoutPlotChildren = runFx(getDisplayedSeriesIterator.stream.foreach(s => {
    chart.SeriesBase(s).layoutJob()
    getDisplayedDataIterator(s).stream.load.map(chart.ItemBase(_)).foreach(_.layoutJob())
  }))

  override protected def updateLegend = chart.Setup.updateLegendJobs.stream.foreach(_()); chart.Setup.updateLegendJobs += (() => super.updateLegend)

  override protected def updateAxisRange = if (getXAxis.isAutoRanging)
    chart.Setup.calcXRangeAsOpt().forval(r => getXAxis.invalidateRange(Stream(r.start, r.end).map(chart.axisX.valueMap(_).cast[XV]).toJavaList))
    chart.Setup.calcYRangeAsOpt().forval(r => getYAxis.invalidateRange(Stream(r.start, r.end).map(chart.axisY.valueMap(_).cast[YV]).toJavaList))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
