package scalqa; package Fx; package Menu; package Item; package A

import javafx.scene.control.{ CustomMenuItem => CMI }

class Basic protected extends Item {
  def this(n: Fx.A.Node.Like, hideOnClick: Boolean = true) = { this; _onCreateGuiRun(new CMI(if (n == null) null else n.real, hideOnClick)) }

  protected type REAL = CMI
  protected override def _createGui = new REAL

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
