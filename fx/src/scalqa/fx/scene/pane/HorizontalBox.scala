package scalqa; package fx; package scene; package pane; import language.implicitConversions

class HorizontalBox extends Pane:
  protected type REAL = javafx.scene.layout.HBox
  protected override def _createReal = new REAL

  @tn("spacing_Pro")   def spacing_*            : Double.Pro.OM  = Fx.JavaFx.As.pro_OM(real.spacingProperty)
  /**/                 def spacing              : Double         = real.getSpacing
  /**/                 def spacing_=(b: Double) : Unit           = real.setSpacing(b)
  @tn("alignment_Pro") def alignment_*          : Pro.OM[Pos]    = Fx.JavaFx.As.pro_OM(real.alignmentProperty).mutableMap_^[Pos]
  /**/                 def alignment            : Pos            = real.getAlignment
  /**/                 def alignment_=(v: Pos)  : Unit           = real.setAlignment(v)

object HorizontalBox:
  def apply(a: ~[Node.Like]) : HorizontalBox = new HorizontalBox().^(_.children ++= a)
  def apply(a: Node.Like*)   : HorizontalBox = new HorizontalBox().^(_.children ++= a)
  def apply(spacing: Double)      : HorizontalBox = new HorizontalBox().^(_.spacing = spacing)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
