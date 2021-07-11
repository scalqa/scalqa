package scalqa; package fx; package control; import language.implicitConversions

class Tooltip(s: String.Opt = \/) extends Popup.Control:
  protected override def _createReal: REAL = s.map(new REAL(_)) or new REAL
  protected type REAL = javafx.scene.control.Tooltip

  @tn("graphic_Pro") def graphic_*             : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.graphicProperty).mutableMap_^[Fx.Node]
  /**/               def graphic               : Fx.Node         = graphic_*()
  /**/               def graphic_=(n: Fx.Node) : Unit            = graphic_*() = n

  /**/               def attachTo(n: Fx.Node)  : Unit            = javafx.scene.control.Tooltip.install(n.real, real)

object Tooltip extends Gen.Void.Setup[Tooltip](new Tooltip(\/) with Gen.Void):
  def apply(s: String.Opt = \/)              : Tooltip = new Tooltip(s)
  def apply(t: javafx.scene.control.Tooltip) : Tooltip = Window(t).cast[Tooltip]

  given FxConverter: ReversibleFunction[javafx.scene.control.Tooltip, Tooltip] = ReversibleFunction(apply, _.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
