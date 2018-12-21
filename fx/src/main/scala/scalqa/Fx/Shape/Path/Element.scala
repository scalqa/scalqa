package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ PathElement => JAVA }

trait Element extends Any with A.Delegate {
  protected type REAL <: JAVA

  def absolutePro: Pro.OM[Boolean] = Custom.ProWO(real.absoluteProperty); def absolute = real.isAbsolute; def absolute_=(b: Boolean) = real.setAbsolute(b)

}

object Element {

  import javafx.scene.{ shape => S }

  def make(real: JAVA): Element = real match {
    case e: S.ArcTo        => ArcTo.make(e)
    case e: S.ClosePath    => ClosePath.make(e)
    case e: S.CubicCurveTo => CubicCurveTo.make(e)
    case e: S.HLineTo      => HLineTo.make(e)
    case e: S.LineTo       => LineTo.make(e)
    case e: S.MoveTo       => MoveTo.make(e)
    case e: S.QuadCurveTo  => QuadCurveTo.make(e)
    case e: S.VLineTo      => VLineTo.make(e)
    case _                 => App.Fail.state

  }

  def map: BiMap[JAVA, Element] = Map; private object Map extends BiMap[JAVA, Element] { def apply(real: JAVA) = make(real); def undo(e: Element) = e.real }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
