package scalqa; package Fx; package Tooltip

class _Class(s: Opt[String] = \/) extends Popup.Control {
  protected override def _createGui: REAL = s.map(new REAL(_)) or new REAL
 protected type REAL = javafx.scene.control.Tooltip

  def graphicPro = Custom.ProWO(real.graphicProperty).asBiMappedView(A.Node.Map); def graphic = graphicPro(); def graphic_=(n: A.Node) = graphicPro() = n

  def attachTo(n: A.Node) = javafx.scene.control.Tooltip.install(n.real, real)

 
}

object _Class extends Util.Void.Setup[Tooltip](new Tooltip(\/) with Void)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
