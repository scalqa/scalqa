package scalqa; package fx; package control; package action; package z; import language.implicitConversions

private[fx] class Basic(n: Node.Like) extends Action():
  protected type REAL = javafx.scene.control.CustomMenuItem

  protected override def _createReal: REAL = new REAL(n.real).^(_.setUserData(this))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
