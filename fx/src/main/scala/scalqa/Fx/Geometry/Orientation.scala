package scalqa; package Fx; package Geometry

import javafx.geometry.{ Orientation => JOrientation }

sealed class Orientation(p: JOrientation) extends Util.Enum.A.Java[Orientation, JOrientation](p, Orientation)

object Orientation extends Util.Enum.A.Java.Setup[Orientation, JOrientation] {

  val Horizontal = new Orientation(JOrientation.HORIZONTAL)

  val Vertical = new Orientation(JOrientation.VERTICAL)

  implicit def zzMake(v: HORIZONTAL.type) = Horizontal

  implicit def zzMake(v: VERTICAL.type) = Vertical
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
