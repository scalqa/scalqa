package scalqa; package fx; package scene; package chart; package axis; package x; package custom; package z; import language.implicitConversions

import javafx.animation.{ KeyFrame, KeyValue }
import javafx.beans.value.{ WritableValue => WV }

class Real[A](axis: X.Custom[A]) extends javafx.scene.chart.ValueAxis[Number]:
  private       var animationId: AnyRef = null
  private lazy  val animator            = new Animator(this);

  def calculateTickValues(length: Double, s: Any) : java.util.List[Number] = axis.setup.tickStream(s.cast[Range[A]]).map(axis.valueMap).toJavaList
  def calculateMinorTickMarks                     : java.util.List[Number] = axis.setup.minorTickStream(getRange, getMinorTickCount).map(axis.valueMap).toJavaList
  def getTickMarkLabel(v: Number)                 : String                 = axis.setup.label(axis.valueMap.undo(v))
  def getRange                                    : Range[A]               = new Range[A](axis.map.undo(getLowerBound), axis.map.undo(getUpperBound), axis.setup.unit, axis.setup.formatPattern, getScale)

  def setRange(range: AnyRef, animate: Boolean)   : Unit =
    val r = range.cast[Range[A]]
    axis.setup.formatPattern = r.format
    val oldLowerBound: Double = getLowerBound
    setLowerBound(axis.map(r.start));
    setUpperBound(axis.map(r.end));
    axis.setup.unit = r.unit
    if (animate)
      animator.stop(animationId);
      val scaleV = new WV[Double] { def getValue = getScale; def setValue(v: Double): Unit = setScale(v) }
      val boundV = new WV[Double] { def getValue = currentLowerBound.get; def setValue(v: Double): Unit = currentLowerBound.set(v) }
      animationId = animator.animate(
        new KeyFrame(javafx.util.Duration.ZERO, new KeyValue(boundV, oldLowerBound), new KeyValue(scaleV, getScale)),
        new KeyFrame(javafx.util.Duration.millis(700), new KeyValue(boundV, getLowerBound), new KeyValue(scaleV, r.scale)))
    else
      currentLowerBound.set(axis.map(r.start))
      setScale(r.scale);

  override def autoRange(min: Double, max: Double, length: Double, labelSize: Double): AnyRef =
    val s = axis.setup.scope((min <> max).convert(axis.map.reverse)(using axis.ordering), length, labelSize)
    new Range(s.start, s.end, s.unit, s.format, calculateNewScale(length, axis.map(s.start), axis.map(s.end)))

  private[x] def _measureTickMarkLabelSize(l: String, s: Double) : javafx.geometry.Dimension2D = measureTickMarkLabelSize(l, s)


  override def invalidateRange(data: java.util.List[Number]) = super.invalidateRange(data)



/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
