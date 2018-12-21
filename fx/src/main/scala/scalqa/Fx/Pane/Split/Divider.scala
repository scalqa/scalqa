package scalqa; package Fx; package Pane; package Split

class Divider(val real: javafx.scene.control.SplitPane.Divider) extends Any.Able.ToInfo {

  lazy val positionPro: Pro.OM[Double] = Custom.ProWO(real.positionProperty); def position = real.getPosition; def position_=(b: Double) = real.setPosition(b)

  def toInfo = new Pro.Info(this) += ("position", position)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
