package scalqa; package Fx; package Geometry

import javafx.geometry.{ HPos => JHPos }

sealed class HPos(p: JHPos) extends Util.Enum.A.Java[HPos, JHPos](p, HPos)

object HPos extends Util.Enum.A.Java.Setup[HPos, JHPos] {

  val Left = new HPos(JHPos.LEFT)
  val Center = new HPos(JHPos.CENTER)
  val Right = new HPos(JHPos.RIGHT)

  implicit def zzMake(vp: CENTER.type) = Center
  implicit def zzMake(vp: LEFT.type) = Left
  implicit def zzMake(vp: RIGHT.type) = Right
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
