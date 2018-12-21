package scalqa; package Fx

package object Tooltip {

  lazy val map = BiMap[javafx.scene.control.Tooltip, Tooltip](make, _.real)

  def make(t: javafx.scene.control.Tooltip): Tooltip = Window.make(t).asInstanceOf[Tooltip]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/