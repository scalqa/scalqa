package scalqa; package fx; package scene; package pane; import language.implicitConversions

class VerticalBox extends Pane:
  protected type REAL = javafx.scene.layout.VBox
  protected override def _createReal = new REAL

  @tn("spacing_Pro")   def spacing_*            : Double.Pro.OM  = Fx.JavaFx.As.pro_OM(real.spacingProperty)
  /**/                 def spacing              : Double         = real.getSpacing
  /**/                 def spacing_=(b: Double) : Unit           = real.setSpacing(b)
  @tn("alignment_Pro") def alignment_*          : Pro.OM[Pos]    = Fx.JavaFx.As.pro_OM(real.alignmentProperty).twoWay_^[Pos]
  /**/                 def alignment            : Pos            = real.getAlignment
  /**/                 def alignment_=(v: Pos)  : Unit           = real.setAlignment(v)

object VerticalBox:

  def apply(a: ~[Node.Like]) : VerticalBox = VerticalBox().^(_.children ++= a)
  def apply(a: Node.Like*)   : VerticalBox = VerticalBox().^(_.children ++= a)
  def apply(spacing: Double)      : VerticalBox = VerticalBox().^(_.spacing = spacing)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
