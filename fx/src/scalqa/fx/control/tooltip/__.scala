package scalqa; package fx; package control; import language.implicitConversions

class Tooltip(s: String.Opt = \/) extends Popup.Control:
  protected override def _createReal: REAL = s.map(new REAL(_)) or new REAL
  protected type REAL = javafx.scene.control.Tooltip

  @tn("graphic_Pro") def graphic_*          : Pro.OM[Node] = Fx.JavaFx.As.pro_OM(real.graphicProperty).twoWay_^[Node]
  /**/               def graphic            : Node         = graphic_*()
  /**/               def graphic_=(n: Node) : Unit           = graphic_*() = n

  /**/               def attachTo(n: Node)  : Unit           = javafx.scene.control.Tooltip.install(n.real, real)

object Tooltip extends Void.Setup[Tooltip](new Tooltip(\/) with Void):
  def apply(s: String.Opt = \/)              : Tooltip = new Tooltip(s)
  def apply(t: javafx.scene.control.Tooltip) : Tooltip = Window(t).cast[Tooltip]

  given FxConverter: TwoWayFun[javafx.scene.control.Tooltip, Tooltip] = TwoWayFun(apply, _.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
