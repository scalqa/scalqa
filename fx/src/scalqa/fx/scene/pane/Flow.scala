package scalqa; package fx; package scene; package pane; import language.implicitConversions

class Flow extends Pane:
  protected type REAL = javafx.scene.layout.FlowPane
  protected override def _createReal = new REAL

  @tn("hGap_Pro")      def hGap_*              : Double.Pro.OM  = Fx.JavaFx.As.pro_OM(real.hgapProperty)
  /**/                 def hGap                : Double         = real.getHgap
  /**/                 def hGap_=(b: Double)   : Unit           = real.setHgap(b)
  @tn("vGap_Pro")      def vGap_*              : Double.Pro.OM  = Fx.JavaFx.As.pro_OM(real.vgapProperty)
  /**/                 def vGap                : Double         = real.getVgap
  /**/                 def vGap_=(b: Double)   : Unit           = real.setVgap(b)
  @tn("alignment_Pro") def alignment_*         : Pro.OM[Pos]    = Fx.JavaFx.As.pro_OM(real.alignmentProperty).mutableMap_^[Pos]
  /**/                 def alignment           : Pos            = real.getAlignment
  /**/                 def alignment_=(v: Pos) : Unit           = real.setAlignment(v)

object Flow:
  def apply(na: Node.Like*) = new Flow().^(_.children ++= na)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
