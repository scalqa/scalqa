package scalqa; package Fx; package Geometry

import javafx.geometry.{ Pos => JPos }

sealed class Pos(p: JPos) extends Util.Enum.A.Java[Pos, JPos](p, Pos) {

  def vertical = VPos(real.getVpos)

  def horizontal = HPos(real.getHpos)
}

object Pos extends Util.Enum.A.Java.Setup[Pos, JPos] {

  val Void = new Pos(JPos.CENTER) with Void
  val TopLeft = new Pos(JPos.TOP_LEFT)
  val TopCenter = new Pos(JPos.TOP_CENTER)
  val TopRight = new Pos(JPos.TOP_RIGHT)
  val CenterLeft = new Pos(JPos.CENTER_LEFT)
  val Center = new Pos(JPos.CENTER)
  val CenterRight = new Pos(JPos.CENTER_RIGHT)
  val BottomLeft = new Pos(JPos.BOTTOM_LEFT)
  val BottomCenter = new Pos(JPos.BOTTOM_CENTER)
  val BottomRight = new Pos(JPos.BOTTOM_RIGHT)
  val BaselineLeft = new Pos(JPos.BASELINE_LEFT)
  val BaselineCenter = new Pos(JPos.BASELINE_CENTER)
  val BaselineRight = new Pos(JPos.BASELINE_RIGHT)

  implicit def zzMake(vp: CENTER.type): Pos = Center
  implicit def zzMake(vp: TOP.type): Pos = TopCenter
  implicit def zzMake(vp: BOTTOM.type): Pos = BottomCenter
  implicit def zzMake(vp: LEFT.type): Pos = CenterLeft
  implicit def zzMake(vp: RIGHT.type): Pos = CenterRight

  implicit def zzMake(hp: HPos): Pos = hp match {
    case HPos.Left   => BaselineLeft
    case HPos.Center => BaselineCenter
    case HPos.Right  => BaselineRight
    case _           => App.Fail.state
  }

  implicit def zzMake(vp: VPos): Pos = vp match {
    case VPos.Top      => TopCenter
    case VPos.Center   => Center
    case VPos.Baseline => BaselineCenter
    case VPos.Bottom   => BottomCenter
    case _             => App.Fail.state
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
