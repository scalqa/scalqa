package scalqa; package Fx; package Pane

class Flow extends Pane {
  protected type REAL = javafx.scene.layout.FlowPane
  protected override def _createGui = new REAL

  def hGapPro: Pro.OM[Double] = Custom.ProWO(real.hgapProperty); def hGap = real.getHgap; def hGap_=(b: Double) = real.setHgap(b)

  def vGapPro: Pro.OM[Double] = Custom.ProWO(real.vgapProperty); def vGap = real.getVgap; def vGap_=(b: Double) = real.setVgap(b)

  def alignmentPro = Custom.ProWO(real.alignmentProperty).asBiMappedView(Pos); def alignment: Pos = real.getAlignment; def alignment_=(v: Pos) = real.setAlignment(v)
}

object Flow {

  def make(na: Fx.A.Node.Like*) = new Flow().I(_.children +~= na)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
