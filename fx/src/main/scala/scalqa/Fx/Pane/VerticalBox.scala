package scalqa; package Fx; package Pane

class VerticalBox extends Pane {

  protected type REAL = javafx.scene.layout.VBox
  protected override def _createGui = new REAL

  def spacingPro: Pro.OM[Double] = Custom.ProWO(real.spacingProperty); def spacing = real.getSpacing; def spacing_=(b: Double) = real.setSpacing(b)

  def alignmentPro = Custom.ProWO(real.alignmentProperty).asBiMappedView(Pos); def alignment: Pos = real.getAlignment; def alignment_=(v: Pos) = real.setAlignment(v)

}

object VerticalBox {

  def make(a: ~[Fx.A.Node.Like]) = new VerticalBox().I(_.children +~= a)

  def make(a: Fx.A.Node.Like*) = new VerticalBox().I(_.children +~= a)

  def make(pSpacing: Double) = new VerticalBox().I(_.spacing = pSpacing)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
