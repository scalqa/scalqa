package scalqa; package Fx; package Chart; package Axis; package A; package Numeric; package Z

import javafx.animation.{ KeyFrame, KeyValue }
import javafx.beans.value.{ WritableValue => WV }

private[Numeric] class ValueAxis[A](ax: Numeric[A]) extends javafx.scene.chart.ValueAxis[JNumber] {

  def calculateTickValues(length: Double, r: Any) = ax.Setup.getAllTicksFun(r.asInstanceOf[Span[A]]).map(ax.valueMap).to[Idx].asJavaListView

  def calculateMinorTickMarks = ax.Setup.getAllMinorTicksFun(getRange, getMinorTickCount).map(ax.valueMap).to[Idx].asJavaListView

  def getTickMarkLabel(v: JNumber): String = ax.Setup.getTickLabelFun(ax.valueMap.undo(v))

  override def autoRange(min: Double, max: Double, length: Double, labelSize: Double) = {
    val r = ax.Setup.getRangeFun((min <> max).map(ax.map.asReversedView)(ax.ordering), length, labelSize)
    new Span(r.start, r.end, r.unit, r.format, calculateNewScale(length, ax.map(r.start), ax.map(r.end)))
  }

  def getRange = new Span[A](ax.map.undo(getLowerBound), ax.map.undo(getUpperBound), ax.Setup.unit, ax.Setup.currentFormatter, getScale)

  def setRange(range: Any, animate: Boolean) = {
    val r = range.asInstanceOf[Span[A]]
    //("setRange "+ r).lp
    ax.Setup.currentFormatter = r.format
    val oldLowerBound: Double = getLowerBound
    setLowerBound(ax.map(r.start));
    setUpperBound(ax.map(r.end));
    ax.Setup.unit = r.unit
    if (animate) {
      animator.stop(animationId);
      val scalePro = new WV[Double] { def getValue = getScale; def setValue(v: Double): Unit = setScale(v) }
      val boundPro = new WV[Double] { def getValue = currentLowerBound.get; def setValue(v: Double): Unit = currentLowerBound.set(v) }
      animationId = animator.animate(
        new KeyFrame(javafx.util.Duration.ZERO, new KeyValue(boundPro, oldLowerBound), new KeyValue(scalePro, getScale)),
        new KeyFrame(javafx.util.Duration.millis(700), new KeyValue(boundPro, getLowerBound), new KeyValue(scalePro, r.scale)))
    } else {
      currentLowerBound.set(ax.map(r.start))
      setScale(r.scale);
    }
  }

  // --------------------------------------------------------------------------
  private lazy val animator = new Animator(this); private var animationId: AnyRef = null

  //(a: javafx.scene.chart.NumberAxis)
  private[Numeric] def currentLowerBoundX = currentLowerBound
  private[Numeric] def zSetScaleX(s: Double) = setScale(s)
  private[Numeric] def measureTickMarkLabelSizeX(l: String, r: Double) = measureTickMarkLabelSize(l, r)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
