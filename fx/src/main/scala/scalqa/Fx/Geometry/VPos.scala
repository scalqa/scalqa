package scalqa; package Fx; package Geometry

import javafx.geometry.{ VPos => JVPos }

sealed class VPos(v: JVPos) extends Util.Enum.A.Java[VPos, JVPos](v, VPos)

object VPos extends Util.Enum.A.Java.Setup[VPos, JVPos] {

  val Top = new VPos(JVPos.TOP)
  val Center = new VPos(JVPos.CENTER)
  val Baseline = new VPos(JVPos.BASELINE)
  val Bottom = new VPos(JVPos.BOTTOM)

  implicit def zzMake(vp: CENTER.type) = Center
  implicit def zzMake(vp: TOP.type) = Top
  implicit def zzMake(vp: BOTTOM.type) = Bottom
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
