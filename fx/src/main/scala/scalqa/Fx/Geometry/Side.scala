package scalqa; package Fx; package Geometry

import javafx.geometry.{ Side => JSide }

sealed class Side(v: JSide) extends Util.Enum.A.Java[Side, JSide](v, Side)

object Side extends Util.Enum.A.Java.Setup[Side, JSide] {

  val Bottom = new Side(JSide.BOTTOM)
  val Left = new Side(JSide.LEFT)
  val Right = new Side(JSide.RIGHT)
  val Top = new Side(JSide.TOP)

  implicit def zzMake(vp: LEFT.type) = Left
  implicit def zzMake(vp: RIGHT.type) = Right
  implicit def zzMake(vp: TOP.type) = Top
  implicit def zzMake(vp: BOTTOM.type) = Bottom
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
