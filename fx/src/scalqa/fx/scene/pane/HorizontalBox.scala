package scalqa; package fx; package scene; package pane; import language.implicitConversions

class HorizontalBox extends Pane:
  protected type REAL = javafx.scene.layout.HBox
  protected override def _createReal = new REAL

  def spacingPro           : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.spacingProperty)
  def spacing              : Double         = real.getSpacing
  def spacing_=(b: Double) : Unit           = real.setSpacing(b)
  def alignmentPro         : Pro.OM[Pos]    = Fx.JavaFx.To.pro_OM(real.alignmentProperty).mutableMapView[Pos]
  def alignment            : Pos            = real.getAlignment
  def alignment_=(v: Pos)  : Unit           = real.setAlignment(v)

object HorizontalBox:
  def apply(a: Stream[Fx.Node.Like]): HorizontalBox = new HorizontalBox().self(_.children ++= a)
  def apply(a: Fx.Node.Like*)       : HorizontalBox = new HorizontalBox().self(_.children ++= a)
  def apply(spacing: Double)        : HorizontalBox = new HorizontalBox().self(_.spacing = spacing)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
