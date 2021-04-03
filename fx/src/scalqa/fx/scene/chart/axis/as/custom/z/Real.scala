package scalqa; package fx; package scene; package chart; package axis; package as; package custom; package z; import language.implicitConversions

import javafx.animation.{ KeyFrame, KeyValue }
import javafx.beans.value.{ WritableValue => WV }

class Real[A](axis: As.Custom[A]) extends javafx.scene.chart.ValueAxis[Number]:
  private       var animationId: AnyRef = null
  private lazy  val animator            = new Animator(this);

  def calculateTickValues(length: Double, s: Any) : java.util.List[Number] = axis.setup.tick_~(s.cast[Scope[A]]).map(axis.valueMap).toJavaList
  def calculateMinorTickMarks                     : java.util.List[Number] = axis.setup.minorTick_~(getRange, getMinorTickCount).map(axis.valueMap).toJavaList
  def getTickMarkLabel(v: Number)                 : String                 = axis.setup.label(axis.valueMap.undo(v))
  def getRange                                    : Scope[A]               = new Scope[A](axis.map.undo(getLowerBound), axis.map.undo(getUpperBound), axis.setup.unit, axis.setup.formatPattern, getScale)

  def setRange(range: AnyRef, animate: Boolean)   : Unit =
    val s = range.cast[Scope[A]]
    axis.setup.formatPattern = s.format
    val oldLowerBound: Double = getLowerBound
    setLowerBound(axis.map(s.start));
    setUpperBound(axis.map(s.end));
    axis.setup.unit = s.unit
    if (animate)
      animator.stop(animationId);
      val scaleV = new WV[Double] { def getValue = getScale; def setValue(v: Double): Unit = setScale(v) }
      val boundV = new WV[Double] { def getValue = currentLowerBound.get; def setValue(v: Double): Unit = currentLowerBound.set(v) }
      animationId = animator.animate(
        new KeyFrame(javafx.util.Duration.ZERO, new KeyValue(boundV, oldLowerBound), new KeyValue(scaleV, getScale)),
        new KeyFrame(javafx.util.Duration.millis(700), new KeyValue(boundV, getLowerBound), new KeyValue(scaleV, s.scale)))
    else
      currentLowerBound.set(axis.map(s.start))
      setScale(s.scale);

  override def autoRange(min: Double, max: Double, length: Double, labelSize: Double): AnyRef =
    val s = axis.setup.scope((min <> max).convert(axis.map.reverse)(using axis.ordering), length, labelSize)
    new Scope(s.start, s.end, s.unit, s.format, calculateNewScale(length, axis.map(s.start), axis.map(s.end)))

  private[as] def _measureTickMarkLabelSize(l: String, s: Double) : javafx.geometry.Dimension2D = measureTickMarkLabelSize(l, s)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
