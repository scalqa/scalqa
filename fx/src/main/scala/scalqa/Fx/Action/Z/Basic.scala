package scalqa; package Fx; package Action; package Z

private[Fx] class Basic(n: A.Node.Like) extends Action() {
  protected type REAL = javafx.scene.control.CustomMenuItem

  protected override def _createGui: REAL = new REAL(n.real).I(_.setUserData(this))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
