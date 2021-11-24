package scalqa; package fx; package scene; package pane; import language.implicitConversions

class Flow extends Pane:
  protected type REAL = javafx.scene.layout.FlowPane
  protected override def _createReal = new REAL

  def hGapPro             : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.hgapProperty)
  def hGap                : Double         = real.getHgap
  def hGap_=(b: Double)   : Unit           = real.setHgap(b)
  def vGapPro             : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.vgapProperty)
  def vGap                : Double         = real.getVgap
  def vGap_=(b: Double)   : Unit           = real.setVgap(b)
  def alignmentPro        : Pro.OM[Pos]    = Fx.JavaFx.To.pro_OM(real.alignmentProperty).mutableMapView[Pos]
  def alignment           : Pos            = real.getAlignment
  def alignment_=(v: Pos) : Unit           = real.setAlignment(v)

object Flow:
  def apply(na: Fx.Node.Like*) = new Flow().self(_.children ++= na)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
