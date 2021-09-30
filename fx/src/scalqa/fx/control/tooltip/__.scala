package scalqa; package fx; package control; import language.implicitConversions

import javafx.scene.control.{ Tooltip as JAVA }

class Tooltip(so: Opt[String]= \/) extends Popup.Control:
  protected override def _createReal: REAL = so.map(new REAL(_)) or new REAL
  protected type REAL = JAVA

  @tn("graphic_Pro") def graphic_*             : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.graphicProperty).mutableMap_^[Fx.Node]
  /**/               def graphic               : Fx.Node         = graphic_*()
  /**/               def graphic_=(n: Fx.Node) : Unit            = graphic_*() = n
  /**/               def attachTo(n: Fx.Node)  : Unit            = JAVA.install(n.real, real)

object Tooltip extends Void.Setup[Tooltip](new Tooltip(\/) with Void):
  def apply(s: Opt[String]= \/): Tooltip = new Tooltip(s)
  def apply(t: JAVA)           : Tooltip = Window(t).cast[Tooltip]

  given FxConverter: TwoWayFunction[JAVA, Tooltip] = TwoWayFunction(apply, _.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
