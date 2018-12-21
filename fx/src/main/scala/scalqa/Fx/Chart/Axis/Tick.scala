package scalqa; package Fx; package Chart; package Axis

abstract class Tick[A] extends Any.Able.ToInfo {

  def label: String

  def position: Double

  def visible: Boolean

  def value: A

  def toInfo = new Pro.Info(this) += ("label", label) += ("position", position) += ("value", value)
}

private[Axis] object Tick {

  def apply[A, B](tm: javafx.scene.chart.Axis.TickMark[B], bm: BiMap[A, B]): Tick[A] = new The(tm, bm)

  // ************************************************************************************
  class The[A, B](val real: javafx.scene.chart.Axis.TickMark[B], bm: BiMap[A, B]) extends Tick[A] {

    def label: String = real.getLabel; def label_=(v: String) = real.setLabel(v)

    def position: Double = real.getPosition; def position_=(v: Double) = real.setPosition(v)

    def visible: Boolean = real.isTextVisible

    def value: A = bm.undo(real.getValue); def value_=(v: A) = real.setValue(bm(v))

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
