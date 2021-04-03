package scalqa; package fx; package scene; package chart; package axis; import language.implicitConversions

import javafx.scene.chart.Axis.{ TickMark => JTick }

abstract class Tick[A] extends Able.Info:
  def label    : String
  def position : Double
  def visible  : Boolean
  def value    : A
  def info     : Info          = Info(this) += ("label", label) += ("position", position) += ("value", value)

private[chart] object Tick:
  def apply[A,B](tm: JTick[B], bm: TwoWayFun[A,B]): Tick[A] = new Z(tm, bm)

  // **************************************************************************************************************
  private class Z[A,B](val real: JTick[B], bm: TwoWayFun[A,B]) extends Tick[A]:
    def label    : String  = real.getLabel; def label_=(v: String) = real.setLabel(v)
    def position : Double  = real.getPosition; def position_=(v: Double) = real.setPosition(v)
    def visible  : Boolean = real.isTextVisible
    def value    : A       = bm.undo(real.getValue); def value_=(v: A) = real.setValue(bm(v))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
